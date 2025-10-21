package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();


        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(68, -10, 0))
                .splineTo(new Vector2d(-40, -34), Math.toRadians(-150))
                .waitSeconds(6)
                .strafeToLinearHeading(new Vector2d(-13, -30), Math.toRadians(90))
                .lineTo

                //.splineTo(new Vector2d(38, -32), Math.toRadians(90))
                //.waitSeconds(3)
                /*.splineTo(new Vector2d(-40, -34), Math.toRadians(-150))
                .waitSeconds(6)
                .splineTo(new Vector2d(38, -30), Math.toRadians(-90))
                .turn(Math.toRadians(180))
                .waitSeconds(4)
                .splineTo(new Vector2d(-40, -34), Math.toRadians(-150))
                .waitSeconds(6)
                .splineTo(new Vector2d(12, -30), Math.toRadians(-90))
                .turn(Math.toRadians(180))
                .waitSeconds(4)
                .splineTo(new Vector2d(-40, -34), Math.toRadians(-150))
                .waitSeconds(6)
                .splineTo(new Vector2d(-14, -30), Math.toRadians(-90))
                .turn(Math.toRadians(180))
                .waitSeconds(4)
                .splineTo(new Vector2d(-40, -34), Math.toRadians(-150))
                .waitSeconds(6)
                .splineTo(new Vector2d(38, -32), Math.toRadians(-90))
                .turn(Math.toRadians(180))*/


                /*.lineToX(-20)
                .turn(Math.toRadians(220))
                .lineToY(-24)
                .turn(Math.toRadians(90))
                .lineToX(0)
                .turn(Math.toRadians(90))
                .lineToY(0)
                .turn(Math.toRadians(90))*/
                .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_JUICE_BLACK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}