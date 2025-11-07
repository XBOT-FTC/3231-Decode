package org.firstinspires.ftc.teamcode.auto;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "BlueAuto", group = "Autonomous")
public class BlueSmallToBigTriangleAuto extends LinearOpMode {
    
    public void runOpMode(){
        Pose2d startingPose = new Pose2d(68, -10, Math.toRadians(0));

        MecanumDrive drive = new MecanumDrive(hardwareMap, startingPose);

        Action trajectoryAction = drive.actionBuilder(startingPose)
                .strafeToLinearHeading(new Vector2d(-40, -34), Math.toRadians(230))
                //come to destination to shoot
                .waitSeconds(5)
                // wait 5s to shoot
                .strafeToLinearHeading(new Vector2d(-13, -30), Math.toRadians(270))
                //come to the 1st location to take the ball and start the intake
                .strafeToLinearHeading(new Vector2d(-13, -47),Math.toRadians(270))
                //take the ball
                .strafeToLinearHeading(new Vector2d(-40, -34), Math.toRadians(-130))
                //back to the location to shoot stop intake
                .waitSeconds(5)
                //wait 5s to shoot
                .strafeToLinearHeading(new Vector2d(12, -30), Math.toRadians(270))
                //come to 2nd location to take the ball start intake
                .strafeToLinearHeading(new Vector2d(12, -47),Math.toRadians(270))
                //take 2nd line of ball
                .strafeToLinearHeading(new Vector2d(-40, -34), Math.toRadians(-130))
                //back to location to shoot stop intake
                .waitSeconds(5)
                //5s to shoot
                .strafeToLinearHeading(new Vector2d(38, -32), Math.toRadians(270))
                //go to the location to park
                .build();
    }

}
