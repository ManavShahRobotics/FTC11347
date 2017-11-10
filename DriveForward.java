package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
/**
 * Created by Ganondorf on 10/18/2017.
 */


@Autonomous(name = "DriveForward", group = "GK")
public class DriveForward extends LinearOpMode {

    Hardware robot = new Hardware();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        robot.colorSensor.enableLed(true);
        waitForStart();
        robot.waitForTick(1000);
        robot.driveForwardTime(1, 2500);
        robot.Jewel.setPosition(0);
    }
}