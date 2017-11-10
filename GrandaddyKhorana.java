package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_WITHOUT_ENCODERS;


//Defining all of the variables here
@TeleOp(name="GKTeleOp", group="GK")
public class GrandaddyKhorana extends OpMode {
    Hardware robot = new Hardware();

    @Override
    public void init()  {
        robot.init(hardwareMap);
    }
    @Override
    public void loop(){
        float RPower = -gamepad1.left_stick_y;
        float LPower = -gamepad1.right_stick_y;
        float Position = gamepad2.left_stick_y;
        float Claw = -gamepad2.right_stick_y;
        /* float Clawposition = gamepad2.left_stick_y;
        boolean Clawrelease = gamepad2.a; */
        robot.backLeftMotor.setPower(LPower*0.75);
        robot.frontLeftMotor.setPower(LPower*0.75);

        robot.backRightMotor.setPower(RPower*0.75);
        robot.frontRightMotor.setPower(RPower*0.75);
        //Claw release can either be 1 or 0, 1 is released 0 is holding,

        robot.Arm.setPower(Position*0.75);
        robot.SpinL.setPower(Claw*.9);
        robot.SpinR.setPower(Claw*.9);
    }
}