package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.MecanumKinematics;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Rotation2d;
import com.acmerobotics.roadrunner.ftc.LazyHardwareMapImu;
import com.acmerobotics.roadrunner.ftc.LazyImu;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class AutoturnDriveTrain {
    private final DcMotorEx frontLeftMotor;
    private final DcMotorEx frontRightMotor;
    private final DcMotorEx backLeftMotor;
    private final DcMotorEx backRightMotor;
    private final static Constants.Params PARAMS = new Constants.Params();
    public final LazyImu lazyImu;
    public final MecanumKinematics kinematics = new MecanumKinematics(
            PARAMS.inPerTick * PARAMS.trackWidthTicks, PARAMS.inPerTick / PARAMS.lateralInPerTick);
    public final DriveLocalizer localizer;
    public double frontLeftPower;
    public double frontRightPower;
    public double backLeftPower;
    public double backRightPower;
    public double getFrontLeftPower() {
        return this.frontLeftPower;
    }
    public double getFrontRightPower() {
        return this.frontRightPower;
    }

    public double getBackLeftPower() {
        return this.backLeftPower;
    }
    public double getBackRightPower() {
        return this.backRightPower;
    }
    public AutoturnDriveTrain(HardwareMap hardwareMap, Telemetry telemetry) {
        this.frontLeftMotor  = hardwareMap.get(DcMotorEx.class, Constants.leftFrontDriveMotor());
        this.frontRightMotor = hardwareMap.get(DcMotorEx.class, Constants.rightFrontDriveMotor());
        this.backLeftMotor   = hardwareMap.get(DcMotorEx.class, Constants.leftBackDriveMotor());
        this.backRightMotor  = hardwareMap.get(DcMotorEx.class, Constants.rightBackDriveMotor());

        this.lazyImu = new LazyHardwareMapImu(hardwareMap, "imu",
                new RevHubOrientationOnRobot(PARAMS.logoFacingDirection, PARAMS.usbFacingDirection));

        this.localizer = new DriveLocalizer(new Pose2d(0, 0, 0), kinematics, lazyImu.get(),
                frontLeftMotor,
                backLeftMotor,
                frontRightMotor,
                backRightMotor
        );

        this.frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        this.backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void power(double x, double y, double rx, double denominator) {
        this.frontLeftPower = (y - x + rx) / denominator;
        this.backLeftPower = (y + x + rx) / denominator;
        this.frontRightPower = (y + x - rx) / denominator;
        this.backRightPower = (y - x - rx) / denominator;

        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }

    public void power(double x, double y, double rx) {
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        power(x, y, rx, denominator);
    }

    public void drive(Gamepad gamepad, Telemetry telemetry){
        double y = gamepad.left_stick_y;
        double x = gamepad.left_stick_x * 1.1;
        double rx = -gamepad.right_stick_x;

        power(x, y, rx);
    }

    public Pose2d getPoseEstimate() {
        return localizer.getPose();
    }

    public Rotation2d getHeading() {
        return localizer.getPose().heading;
    }

    public double getHeadingInRadians() {
        return localizer.getPose().heading.toDouble();
    }

    public double getHeadingInDegrees() {
        return Math.toDegrees(localizer.getPose().heading.toDouble());
    }

    public PoseVelocity2d updatePoseEstimate() {
        return localizer.update();
    }

    public void lookAtAngle(double desiredDegrees) {
        double currentDegrees = Math.toDegrees(localizer.getPose().heading.toDouble());
        double angleDelta = (currentDegrees - desiredDegrees) / 180;
        power(0, 0, angleDelta, 1);
    }
}
