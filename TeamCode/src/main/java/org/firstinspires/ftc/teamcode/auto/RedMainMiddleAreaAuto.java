package org.firstinspires.ftc.teamcode.auto;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "RedMainMiddleAreaAuto", group = "Autonomous")
public class RedMainMiddleAreaAuto extends LinearOpMode {

    double startPoseX = -56; //SmallTriangleAuto = 58
    double startPoseY = 45; //SmallTriangleAuto = 0
    double minYValue = 31;
    double maxYValue = 54;

    @Override
    public void runOpMode(){
        Pose2d startingPose = new Pose2d(-startPoseX, startPoseY, Math.toRadians(0));

        MecanumDrive drive = new MecanumDrive(hardwareMap, startingPose);

        Action trajectoryAction = drive.actionBuilder(startingPose)
                .strafeToSplineHeading(new Vector2d(0,0),Math.toRadians(135))

                .waitSeconds(6) //Replace this with shoot code

                .strafeToSplineHeading(new Vector2d(-10,minYValue), Math.toRadians(90))
                //Start intake
                .splineToConstantHeading(new Vector2d(-11,maxYValue),Math.toRadians(90))

                .strafeToSplineHeading(new Vector2d(0,0),Math.toRadians(135))
                //stop intake
                .waitSeconds(6) //Replace this with the shoot code

                .strafeToSplineHeading(new Vector2d(11,minYValue), Math.toRadians(90))
                //Start intake
                .splineToConstantHeading(new Vector2d(12,maxYValue),Math.toRadians(90))

                .strafeToSplineHeading(new Vector2d(0,0),Math.toRadians(135))
                //stop intake
                .waitSeconds(6)
                //Replace this shooter code
                .build();
    }

}
