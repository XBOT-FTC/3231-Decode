package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "Shooter", group = "LinearOpMode")
public class Shooter extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor leftShooterMotor = hardwareMap.dcMotor.get("leftShooterMotor");
        DcMotor rightShooterMotor = hardwareMap.dcMotor.get("rightShooterMotor");

        rightShooterMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        //Shooters start at 10% power
        double leftShooterPower = .1;
        double rightShooterPower = .1;

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

            if (shoot == true) {
                leftShooterMotor.setPower(leftShooterPower);
                rightShooterMotor.setPower(rightShooterPower);
            }else {
                leftShooterMotor.setPower(0);
                rightShooterMotor.setPower(0);
            }

            //Shooter power increases by 10% everytime Dpad up is pressed
            if (currentGamepad1.dpad_up && !previousGamepad1.dpad_up) {
                leftShooterPower = leftShooterPower + 0.1;
                rightShooterPower = rightShooterPower +0.1;
            }

            //Shooter power decreases by 10% everytime Dpad down is pressed
            if (currentGamepad1.dpad_down && !previousGamepad1.dpad_down) {
                leftShooterPower = leftShooterPower - 0.1;
                rightShooterPower = rightShooterPower - 0.1;
            }

            //The highest the shooter power can go is 100%
            leftShooterPower = Math.min(leftShooterPower, 1.0);
            rightShooterPower = Math.min(rightShooterPower, 1.0);
            //The lowest the shooter power can go is 0%
            leftShooterPower = Math.max(leftShooterPower, 0);
            rightShooterPower = Math.max(rightShooterPower, 0);

            telemetry.addData("motors", "leftShooter(%.2f) rightShooter(%.2f)", leftShooterPower, rightShooterPower);
            telemetry.update();
    }
}}