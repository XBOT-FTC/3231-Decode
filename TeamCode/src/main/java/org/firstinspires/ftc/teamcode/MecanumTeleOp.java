package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;

@TeleOp(name = "2025TeleOp", group="Linear OpMode")
public class MecanumTeleOp extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        DriveTrain driveTrain = new DriveTrain(hardwareMap, telemetry);

        Shooter shooter = new Shooter(hardwareMap, telemetry);
        ColorSensing colorSensor = new ColorSensing(hardwareMap, telemetry, "Test");
        Intake intake = new Intake(hardwareMap, telemetry);
        waitForStart();

        if (isStopRequested()) return;

        Gamepad currentGamepad1 = new Gamepad();
        Gamepad previousGamepad1 = new Gamepad();

        while (opModeIsActive()) {
            driveTrain.drive(currentGamepad1, telemetry);
            colorSensor.updateTelemetry();

            //The Y button is for shooting
            //Use the Dpad to change the speed of the motors
            boolean wasYPressed = gamepad1.y;
            boolean wasXPressed = gamepad1.x;
            boolean wasAPressed = gamepad1.a;
            boolean wasBPressed = gamepad1.b;
            boolean more = gamepad1.dpad_up;
            boolean less = gamepad1.dpad_down;

            previousGamepad1.copy(currentGamepad1);
            currentGamepad1.copy(gamepad1);

            //Shooting Code
            if (wasYPressed == true) {
                shooter.shooter100();
            } else if (wasXPressed == true) {
                shooter.shooter30();
            } else if (wasAPressed == true) {
                shooter.shooter50();
            } else if (wasBPressed == true) {
                shooter.shooter70();
            } else {
                shooter.setZero(shooter.getShooterMotor());
            }

            //Shooter power increases by 10% everytime Dpad up is pressed
            if (currentGamepad1.dpad_up && !previousGamepad1.dpad_up) {
                shooter.increasePower();
            }

            //Shooter power decreases by 10% everytime Dpad down is pressed
            if (currentGamepad1.dpad_down && !previousGamepad1.dpad_down) {
                shooter.decreasePower();
            }

            intake.run(currentGamepad1);
            colorSensor.updateTelemetry();

            //Telemetry for movement motors and shooters
            telemetry.addData("motors", "frontLeft(%.2f) frontRight(%.2f) backLeft(%.2f) backRight(%.2f)", driveTrain.getFrontLeftPower(), driveTrain.getFrontRightPower(), driveTrain.getBackLeftPower(), driveTrain.getBackRightPower());
            telemetry.addData("motors", "shooter(%.2f)", shooter.getShooterMotor());
            telemetry.update();
        }
    }
}
