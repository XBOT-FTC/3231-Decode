package org.firstinspires.ftc.teamcode.auto;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
// This auto is ONLY intended to be used for emergency situations where the robot is unable to function
// properly due to damage or other problems with the robot. This auto moves the robot out of the starting
// area to get the moving points.
@Autonomous(name = "RedEmergencyAuto", group = "Autonomous")
public class RedEmergencyAuto extends LinearOpMode {
    double startPoseX = -56; //SmallTriangleAuto = 58
    double startPoseY = 45; //SmallTriangleAuto = 0

    @Override
    public void runOpMode(){
        Pose2d startingPose = new Pose2d(startPoseX, startPoseY, Math.toRadians(0));

        MecanumDrive drive = new MecanumDrive(hardwareMap, startingPose);

        Action trajectoryAction = drive.actionBuilder(startingPose)
                .strafeToLinearHeading(new Vector2d(-31,48), Math.toRadians(127))
                .build();
    }

}





