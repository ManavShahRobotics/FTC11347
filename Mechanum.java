package org.firstinspires.ftc.teamcode;

/**
 * Created by Ganondorf on 9/8/2017.
 */
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_WITHOUT_ENCODERS;

@TeleOp (name="MecanumDemo", group="Mechanum")
@Disabled
public class Mechanum extends OpMode{


    MechanumHardware robot = new MechanumHardware();

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop(){
        float powery = -gamepad1.left_stick_y;
        float powerx = gamepad1.left_stick_x;
        float powerz = gamepad1.right_stick_x;

        robot.frontLeftMotor.setPower(powery + powerx - powerz);
        robot.frontRightMotor.setPower(powery - powerx + powerz);
        robot.backRightMotor.setPower(powery - powerx - powerz);
        robot.backLeftMotor.setPower(powery + powerx + powerz);
    }

}
