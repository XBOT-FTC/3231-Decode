package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

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
    public static double inPerTick = 0.023856904;
    public static double lateralInPerTick = .02520816;
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
    public static double shooterPower = .6;

    // Auto calibration
    public static double inPerTick3231 = 0.02393;
    public static double lateralInPerTick3231 = 0.02519;

    public static double ks3231 = 1.0967513649697667;

    public static double kv3231 = 0.0042730455553834186;

    public static double ka3231 = .00067;

    public static double trackWidth3231 = 1226.5643209432749;

    public static double axialGain3231 = 3;

    public static double axialVelGain3231 = 1.9;

    public static double headingGain3231 = 4.5;

    public static double headingVelGain3231 = .5;

    public static double lateralGain3231 = 1.3;

    public static double lateralVelGain3231 = 0;

    // Color Sensor
    public static String getColorSensorName () { return "Test"; }
    public static class Params {
        // IMU orientation
        // TODO: fill in these values based on
        //   see https://ftc-docs.firstinspires.org/en/latest/programming_resources/imu/imu.html?highlight=imu#physical-hub-mounting
        public RevHubOrientationOnRobot.LogoFacingDirection logoFacingDirection =
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT;
        public RevHubOrientationOnRobot.UsbFacingDirection usbFacingDirection =
                RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD;

        // drive model parameters
        public double inPerTick = Constants.inPerTick3231;
        public double lateralInPerTick = Constants.lateralInPerTick3231;
        public double trackWidthTicks = Constants.trackWidth3231;

        // feedforward parameters (in tick units)
        public double kS = Constants.ks3231;
        public double kV = Constants.kv3231;
        public double kA = ka3231;

        // path profile parameters (in inches)
        public double maxWheelVel = 50;
        public double minProfileAccel = -30;
        public double maxProfileAccel = 50;

        // turn profile parameters (in radians)
        public double maxAngVel = Math.PI; // shared with path
        public double maxAngAccel = Math.PI;

        // path controller gains
        public double axialGain = axialGain3231;
        public double lateralGain = lateralGain3231;
        public double headingGain = headingGain3231; // shared with turn

        public double axialVelGain = axialVelGain3231;
        public double lateralVelGain = lateralVelGain3231;
        public double headingVelGain = headingVelGain3231; // shared with turn
    }

}
