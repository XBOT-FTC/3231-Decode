package org.firstinspires.ftc.teamcode.src;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Intake", group = "Linear OpMode")
public class Intake extends LinearOpMode {

    private DcMotor intakeMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize the intake motor
        intakeMotor = hardwareMap.dcMotor.get("intakeMotor");

        // Set the motor direction (adjust if necessary)
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        // Wait for the start button to be pressed
        waitForStart();

        if (isStopRequested()) return;

        // Main TeleOp loop
        while (opModeIsActive()) {
            // Intake control
            if (gamepad1.left_bumper) { // Intake balls (forward)
                intakeMotor.setPower(1.0);
            } else if (gamepad1.right_bumper) { // Outtake (reverse)
                intakeMotor.setPower(-1.0);
            } else { // Stop intake
                intakeMotor.setPower(0);
            }

            // Display intake motor power
            telemetry.addData("Intake Power", "%.2f", intakeMotor.getPower());
            telemetry.update();
        }
    }


}

