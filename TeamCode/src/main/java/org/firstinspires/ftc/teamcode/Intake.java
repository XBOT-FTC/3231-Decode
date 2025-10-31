package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    private final DcMotor intakeMotor;
    private final Telemetry telemetry;

    public Intake(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.intakeMotor = hardwareMap.dcMotor.get("intakeMotor");
        this.intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }
    
    public void run(Gamepad gamepad) {
        if (gamepad.left_bumper) { // Intake
            intakeMotor.setPower(1.0);
        } else if (gamepad.right_bumper) { // Outtake
            intakeMotor.setPower(-1.0);
        } else {
            intakeMotor.setPower(0);
        }

        telemetry.addData("Intake Power", "%.2f", intakeMotor.getPower());
        telemetry.update();
    }
}
