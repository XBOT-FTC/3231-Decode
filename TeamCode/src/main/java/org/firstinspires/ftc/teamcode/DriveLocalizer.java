package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.DualNum;
import com.acmerobotics.roadrunner.MecanumKinematics;
import com.acmerobotics.roadrunner.Pose2d;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Rotation2d;
import com.acmerobotics.roadrunner.Time;
import com.acmerobotics.roadrunner.Twist2d;
import com.acmerobotics.roadrunner.Twist2dDual;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Encoder;
import com.acmerobotics.roadrunner.ftc.FlightRecorder;
import com.acmerobotics.roadrunner.ftc.OverflowEncoder;
import com.acmerobotics.roadrunner.ftc.PositionVelocityPair;
import com.acmerobotics.roadrunner.ftc.RawEncoder;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.messages.MecanumLocalizerInputsMessage;

public class DriveLocalizer implements Localizer {
   private final Constants.Params PARAMS = new Constants.Params();
   private final MecanumKinematics kinematics;
   public final Encoder leftFront, leftBack, rightBack, rightFront;
   public final IMU imu;

   private int lastLeftFrontPos, lastLeftBackPos, lastRightBackPos, lastRightFrontPos;
   private Rotation2d lastHeading;
   private boolean initialized;
   private Pose2d pose;

   public DriveLocalizer(Pose2d pose, MecanumKinematics kinematics, IMU imu, DcMotorEx leftFront, DcMotorEx leftBack, DcMotorEx rightFront, DcMotorEx rightBack) {
      this.leftFront = new OverflowEncoder(new RawEncoder(leftFront));
      this.leftBack = new OverflowEncoder(new RawEncoder(leftBack));
      this.rightFront = new OverflowEncoder(new RawEncoder(rightFront));
      this.rightBack = new OverflowEncoder(new RawEncoder(rightBack));

      this.kinematics = kinematics;
      this.imu = imu;

      // TODO: reverse encoders if needed
      //   leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
      // leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
      // leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

      this.pose = pose;
   }

   @Override
   public void setPose(Pose2d pose) {
      this.pose = pose;
   }

   @Override
   public Pose2d getPose() {
      return pose;
   }

   @Override
   public PoseVelocity2d update() {
      PositionVelocityPair leftFrontPosVel = leftFront.getPositionAndVelocity();
      PositionVelocityPair leftBackPosVel = leftBack.getPositionAndVelocity();
      PositionVelocityPair rightBackPosVel = rightBack.getPositionAndVelocity();
      PositionVelocityPair rightFrontPosVel = rightFront.getPositionAndVelocity();

      YawPitchRollAngles angles = imu.getRobotYawPitchRollAngles();

      FlightRecorder.write("MECANUM_LOCALIZER_INPUTS", new MecanumLocalizerInputsMessage(
         leftFrontPosVel, leftBackPosVel, rightBackPosVel, rightFrontPosVel, angles));

      Rotation2d heading = Rotation2d.exp(angles.getYaw(AngleUnit.RADIANS));

      if (!initialized) {
         initialized = true;

         lastLeftFrontPos = leftFrontPosVel.position;
         lastLeftBackPos = leftBackPosVel.position;
         lastRightBackPos = rightBackPosVel.position;
         lastRightFrontPos = rightFrontPosVel.position;

         lastHeading = heading;

         return new PoseVelocity2d(new Vector2d(0.0, 0.0), 0.0);
      }

      double headingDelta = heading.minus(lastHeading);
      Twist2dDual<Time> twist = kinematics.forward(new MecanumKinematics.WheelIncrements<>(
         new DualNum<Time>(new double[]{
         (leftFrontPosVel.position - lastLeftFrontPos),
            leftFrontPosVel.velocity,
         }).times(PARAMS.inPerTick),
         new DualNum<Time>(new double[]{
         (leftBackPosVel.position - lastLeftBackPos),
            leftBackPosVel.velocity,
         }).times(PARAMS.inPerTick),
         new DualNum<Time>(new double[]{
         (rightBackPosVel.position - lastRightBackPos),
            rightBackPosVel.velocity,
         }).times(PARAMS.inPerTick),
         new DualNum<Time>(new double[]{
         (rightFrontPosVel.position - lastRightFrontPos),
            rightFrontPosVel.velocity,
         }).times(PARAMS.inPerTick)
      ));

      lastLeftFrontPos = leftFrontPosVel.position;
      lastLeftBackPos = leftBackPosVel.position;
      lastRightBackPos = rightBackPosVel.position;
      lastRightFrontPos = rightFrontPosVel.position;

      lastHeading = heading;

      pose = pose.plus(new Twist2d(
         twist.line.value(),
         headingDelta
      ));

      return twist.velocity().value();
   }
}
