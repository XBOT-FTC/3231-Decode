package org.firstinspires.ftc.teamcode.auto;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "RedSmallTriangleAuto", group = "Autonomous")
public class RedSmallTriangleAuto {
    public void runOpMode(){
        Pose2d startingPose = new Pose2d(58, 0, Math.toRadians(0));

        MecanumDrive drive = new MecanumDrive(hardwareMap, startingPose);

        Action trajectoryAction = drive.actionBuilder(startingPose)

                .splineTo(new Vector2d(35,36),Math.toRadians(90))

                .waitSeconds(20)

                .strafeToLinearHeading(new Vector2d(58,0),Math.toRadians(150))

                .waitSeconds(20)

                .splineTo(new Vector2d(12,56),Math.toRadians(90))

                .waitSeconds(20)

                .strafeToSplineHeading(new Vector2d(-11,0),Math.toRadians(135))

                .waitSeconds(20)

                .setTangent(Math.toRadians(90))

                .waitSeconds(20)

                .strafeToSplineHeading(new Vector2d(-11,56), Math.toRadians(90))

                .waitSeconds(20)

                .strafeToSplineHeading(new Vector2d(-34,38),Math.toRadians(140))
                
                .build();
    }

}
