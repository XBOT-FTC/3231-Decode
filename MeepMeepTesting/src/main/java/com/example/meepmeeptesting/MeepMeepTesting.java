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
                .strafeToLinearHeading(new Vector2d(-40, -34), Math.toRadians(230))
                .waitSeconds(5)
                .strafeToLinearHeading(new Vector2d(-13, -30), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(-13, -47),Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(-40, -34), Math.toRadians(-130))
                .waitSeconds(5)
                .strafeToLinearHeading(new Vector2d(12, -30), Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(12, -47),Math.toRadians(270))
                .strafeToLinearHeading(new Vector2d(-40, -34), Math.toRadians(-130))
                .waitSeconds(5)
                .strafeToLinearHeading(new Vector2d(38, -32), Math.toRadians(270))
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
                .turn(Math.toRadians(90))
                .build());


       /* meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_JUICE_BLACK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
} */


/* Red SmallTriangleAuto right here:


                .turn(Math.toRadians(150))
                .waitSeconds(1)
                .splineTo(new Vector2d(35,56),Math.toRadians(90))
                .waitSeconds(1)
                .strafeToLinearHeading(new Vector2d(startPoseX,startPoseY),Math.toRadians(150))
                .waitSeconds(1)
                .splineTo(new Vector2d(12,56),Math.toRadians(90))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-11,0),Math.toRadians(135))
                .waitSeconds(1)
                .turnTo(Math.toRadians(90))
                .strafeToSplineHeading(new Vector2d(-11,56), Math.toRadians(90))
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-34,38),Math.toRadians(140))*/

//.splineToLinearHeading(new Pose2d(40, 40, Math.toRadians(90)), Math.toRadians(0))
//.splineTo(new Vector2d(-16,60),1)

                /*.turn(Math.toRadians(90))
                .lineToY(30)
                .turn(Math.toRadians(90))
                .lineToX(0)
                .turn(Math.toRadians(90))
                .lineToY(0)
                .turn(Math.toRadians(90))


                Red main auto code here:
                                .turnTo(Math.toRadians(127))
                                .waitSeconds(6)
                                .strafeToSplineHeading(new Vector2d(-20,minYValue), Math.toRadians(90))
                                .splineToConstantHeading(new Vector2d(-11,maxYValue),Math.toRadians(90))
                                .strafeToSplineHeading(new Vector2d(startPoseX,startPoseY),Math.toRadians(127))
                                .waitSeconds(6)
                                .strafeToSplineHeading(new Vector2d(3,minYValue), Math.toRadians(90))
                                .splineToConstantHeading(new Vector2d(12,maxYValue),Math.toRadians(90))
                                .strafeToSplineHeading(new Vector2d(startPoseX,startPoseY),Math.toRadians(127))
                                .waitSeconds(6)

 /* The following gets the other 3 times but doesnt do it time

                                .strafeToSplineHeading(new Vector2d(26.5,minYValue), Math.toRadians(90))
                                .splineToConstantHeading(new Vector2d(35.5,maxYValue),Math.toRadians(90))
                                .strafeToSplineHeading(new Vector2d(startPoseX,startPoseY),Math.toRadians(127))*/








