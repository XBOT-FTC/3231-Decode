package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "2025TeleOp", group="Linear OpMode")
public class MecanumTeleOp extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get(Constants.leftFrontDriveMotor());
        DcMotor backLeftMotor = hardwareMap.dcMotor.get(Constants.leftBackDriveMotor());
        DcMotor frontRightMotor = hardwareMap.dcMotor.get(Constants.rightFrontDriveMotor());
        DcMotor backRightMotor = hardwareMap.dcMotor.get(Constants.rightBackDriveMotor());

        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        Shooter shooter = new Shooter(hardwareMap,telemetry);

        waitForStart();

        if (isStopRequested()) return;

        Gamepad currentGamepad1 = new Gamepad();
        Gamepad previousGamepad1 = new Gamepad();

        while (opModeIsActive()) {
            //The Y button is for shooting
            //Use the Dpad to change the speed of the motors
            boolean shoot = gamepad1.y;
            boolean more = gamepad1.dpad_up;
            boolean less = gamepad1.dpad_down;

            previousGamepad1.copy(currentGamepad1);
            currentGamepad1.copy(gamepad1);

            //Drive Code
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rx = -gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y - x + rx) / denominator;
            double backLeftPower = (y + x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            //Shooting Code
            if (shoot == true) {
                shooter.setMotorPower(shooter.getLeftShooterMotor(), shooter.getLeftShooterPower());
                shooter.setMotorPower(shooter.getRightShooterMotor(), shooter.getRightShooterPower());
            }else {
                shooter.setZero(shooter.getLeftShooterMotor());
                shooter.setZero(shooter.getRightShooterMotor());
            }

            //Shooter power increases by 10% everytime Dpad up is pressed
            if (currentGamepad1.dpad_up && !previousGamepad1.dpad_up) {
                shooter.increasePower();
            }

            //Shooter power decreases by 10% everytime Dpad down is pressed
            if (currentGamepad1.dpad_down && !previousGamepad1.dpad_down) {
                shooter.decreasePower();
            }

            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);

            //Telemetry for movement motors and shooters
            telemetry.addData("motors", "frontLeft(%.2f) frontRight(%.2f) backLeft(%.2f) backRight(%.2f) leftShooter(%.2f) rightShooter(%.2f)", frontLeftPower, frontRightPower, backLeftPower, backRightPower, shooter.getLeftShooterPower(), shooter.getRightShooterPower());
            telemetry.update();
        }
    }
}