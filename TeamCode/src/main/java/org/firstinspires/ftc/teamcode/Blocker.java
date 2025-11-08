package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Blocker {
    Servo blockerServo = null;
    boolean leftBumperPressed;
    boolean rightBumperPressed;
    double closePosition = 1;
    double openPosition = 0.25;
    boolean hold = false;
    String direction;

    public Blocker(HardwareMap hardwareMap, Telemetry telemetry, String direction) {
        blockerServo = hardwareMap.get(Servo.class,direction);
        blockerServo.setDirection(Servo.Direction.REVERSE);
        this.leftBumperPressed = false;
        this.rightBumperPressed = false;
        this.direction = direction;
    }

    public void powerServo(Gamepad gamepad, Telemetry telemetry) {
        controlServo(gamepad, telemetry);
    }

    public void controlServo(Gamepad gamepad, Telemetry telemetry) {
        if (gamepad.left_bumper && this.direction.equals("left")) {
            if (!leftBumperPressed) {
                leftBumperPressed = true;
            }
        } else if (gamepad.right_bumper && this.direction.equals("right")) {
            if (!rightBumperPressed){
                rightBumperPressed = true;
            }
        } else {
            if (leftBumperPressed) {
                leftBumperPressed = false;
                hold = !hold;
            }
            if (rightBumperPressed) {
                rightBumperPressed = false;
                hold = !hold;
            }
        }
        this.setServo(telemetry);
    }

    public void setServo(Telemetry telemetry) {
         if (hold) {
             blockerServo.setPosition(closePosition);
             telemetry.addLine("Closed");
         } else {
             blockerServo.setPosition(openPosition);
             telemetry.addLine("Opened");
         }

         telemetry.addData("Blocker Position", blockerServo.getPosition());
    }

    public void open() {
        blockerServo.setPosition(openPosition);
    }

    public void close() {
        blockerServo.setPosition(closePosition);
    }
}
