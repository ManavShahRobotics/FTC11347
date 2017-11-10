package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
/**
 * Created by Ganondorf on 10/18/2017.
 */

@Autonomous(name = "JewelBlue", group = "GK")
public class JewelBlue extends LinearOpMode {

    Hardware robot = new Hardware();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        robot.colorSensor.enableLed(true);
        waitForStart();
        robot.Jewel.setPosition(1); // range from 0 to 1
        robot.waitForTick(1000);
        telemetry.addData("color", robot.colorSensor.red());
        telemetry.update();
        if(robot.colorSensor.red() > robot.colorSensor.blue() && robot.colorSensor.red() > robot.colorSensor.green()){

            robot.driveForwardTime(1, 1000);
        }
        else if(robot.colorSensor.blue() > robot.colorSensor.red() && robot.colorSensor.blue() > robot.colorSensor.green()){

            robot.driveBackwardTime(1, 1000);
        }
        robot.Jewel.setPosition(-1);

        robot.driveForwardTime(1, 1500);


    }

}
