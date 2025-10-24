package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

//Shooter class
public class Shooter {
    private final DcMotor leftShooterMotor;
    private final DcMotor rightShooterMotor;
    //Shooters starting power constants
    public double leftShooterPower = Constants.leftShooterPower;
    public double rightShooterPower = Constants.rightShooterPower;

    //Shooter power increase function
    public void increasePower() {
        this.leftShooterPower = leftShooterPower + 0.1;
        this.rightShooterPower = rightShooterPower + 0.1;
        this.leftShooterPower = Math.min(leftShooterPower, 1.0);
        this.rightShooterPower = Math.min(rightShooterPower, 1.0);
    }

    //Shooter power decrease function
    public void decreasePower() {
        this.leftShooterPower = leftShooterPower - 0.1;
        this.rightShooterPower = rightShooterPower - 0.1;
        this.leftShooterPower = Math.max(leftShooterPower, 0);
        this.rightShooterPower = Math.max(rightShooterPower, 0);
    }

    //Constant for shooter motors stop
    public void setZero(DcMotor motor) {
        motor.setPower(0);
    }

    public void setMotorPower(DcMotor motor, double power) {
        motor.setPower(power);
    }

    public Shooter(HardwareMap hardwareMap, Telemetry telemetry) {
        this.leftShooterMotor = hardwareMap.dcMotor.get(Constants.leftShooterMotor());
        this.rightShooterMotor = hardwareMap.dcMotor.get(Constants.rightShooterMotor());
        this.rightShooterMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    //Return shooter motors and powers
    public DcMotor getLeftShooterMotor() {
        return this.leftShooterMotor;
    }

    public DcMotor getRightShooterMotor() {
        return this.rightShooterMotor;
    }

    public double getLeftShooterPower() {
        return leftShooterPower;
    }

    public double getRightShooterPower() {
        return rightShooterPower;
    }

    public void shooter10() {
        //leftShooterMotor.setPower(leftShooterPower);
        //rightShooterMotor.setPower(rightShooterPower);
        this.leftShooterPower = 0.1;
        this.rightShooterPower = 0.1;
    }

    public void shooter30() {
        this.leftShooterPower = 0.3;
        this.rightShooterPower= 0.3;
    }

    public void shooter50() {
        this.leftShooterPower = 0.5;
        this.rightShooterPower = 0.5;
    }

    public void shooter70() {
        this.leftShooterPower = 0.7;
        this.rightShooterPower = 0.7;
    }

          //  telemetry.addData("motors", "leftShooter(%.2f) rightShooter(%.2f)", leftShooterPower, rightShooterPower);
          //  telemetry.update();
    }
