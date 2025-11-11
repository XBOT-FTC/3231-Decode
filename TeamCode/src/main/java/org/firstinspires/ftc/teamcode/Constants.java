package org.firstinspires.ftc.teamcode;

public class Constants {

    //Motor Constants
    //Port 3
    public static String leftFrontDriveMotor(){
       return "frontLeftMotor";
    }
    //Port 0
    public static String rightFrontDriveMotor(){
        return "frontRightMotor";
    }
    //Port 2
    public static String leftBackDriveMotor(){
        return "backLeftMotor";
    }
    //Port 1
    public static String rightBackDriveMotor(){
        return "backRightMotor";
    }

    // Tuned values
    public static double inPerTick = 0.001979133858;
    public static double lateralInPerTick = 0.0015679876322895851;
    public static double trackWidthTicks = 8060.506364813945;
    public static final double kA = .000078;
    public static final double kV = 0.0003510462253567012;
    public static final double kS = 1.1082062641862467;
    public static final double maxWheelVel = 50;
    public static final double minProfileAccel = -30;
    public static final double maxProfileAccel = 50;

    // Shooter Constants
    public static String shooterMotor(){
        return "shooterMotor";
    }

    // Starting Power
    public static double shooterPower = .3;

    // Color Sensor
    public static String getColorSensorName () { return "Test"; }



}
