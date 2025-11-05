package org.firstinspires.ftc.teamcode.auto;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "RedSmallTriangleAuto", group = "Autonomous")
public class RedSmallTriangleAuto extends LinearOpMode {

    @Override
    public void runOpMode(){
        Pose2d startingPose = new Pose2d(58, 0, Math.toRadians(0));

        MecanumDrive drive = new MecanumDrive(hardwareMap, startingPose);

        Action trajectoryAction = drive.actionBuilder(startingPose)

                .waitSeconds(6)

                .strafeToSplineHeading(new Vector2d(43,29),Math.toRadians(90))

                .splineToConstantHeading(new Vector2d(36,56),Math.toRadians(90))

                .waitSeconds(6)

                .strafeToSplineHeading(new Vector2d(58.2,25),Math.toRadians(150))

                .waitSeconds(6)

                .strafeToSplineHeading(new Vector2d(16,30), Math.toRadians(90))

                .splineToConstantHeading(new Vector2d(9,56),Math.toRadians(150))

                .waitSeconds(6)

                .strafeToSplineHeading(new Vector2d(-11,21),Math.toRadians(130))

                .waitSeconds(6)

                .turnTo(Math.toRadians(90))

                .strafeToSplineHeading(new Vector2d(-11,56), Math.toRadians(90))

                .waitSeconds(6)

                .strafeToSplineHeading(new Vector2d(-34,38),Math.toRadians(140))
                
                .build();
    }

}
