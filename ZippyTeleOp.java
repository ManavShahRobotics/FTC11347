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
@TeleOp(name="TeleOp1", group="Zippy")
public class ZippyTeleOp extends OpMode {
    //DcMotor frontLeftMotor = null;
    //DcMotor frontRightMotor = null;
    //For Mechanum
    // Zippy Kind Langur
    DcMotor backLeft = null;
    DcMotor backRight = null;
    /*Servo leftPoker = null;
    Servo rightPoker = null;
    //Low Goal Shooter Motor
    DcMotor lowGoal = null;
    DcMotor HiGoal = null;
    LightSensor lightSensor;
    ColorSensor beacon = null;*/

    @Override
    //Finding everything on the hardware map when we have the means to do so
    //Initialization[Set Up/Restart]
    public void init() {
        //                        Mechanum Program(Not Integrated)
        //frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        //frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        //                        Mechanum Program(Not Integrated)
        /*beacon = hardwareMap.colorSensor.get("beacon");
        beacon.enableLed(false);*/

        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");

      /*  leftPoker = hardwareMap.servo.get("leftPoker");
        rightPoker = hardwareMap.servo.get("rightPoker");
        lightSensor = hardwareMap.lightSensor.get("sensor_light");
        lightSensor.enableLed(false);*/





        //Right Motor needs to be reversed
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        //frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
       /* leftPoker.setPosition(0);
        rightPoker.setPosition(1);
        //Low Goal Shooter
        lowGoal = hardwareMap.dcMotor.get("lowGoal");
        HiGoal = hardwareMap.dcMotor.get("HiGoal");*/
    }
    @Override
    public void loop() {
     /*   telemetry.addData ("light", lightSensor.getLightDetected());
        telemetry.addData("3 Red ", beacon.red());
        telemetry.addData("4 Green ", beacon.green());
        telemetry.addData("5 Blue ", beacon.blue());
        telemetry.addData("light", beacon.alpha());*/
        //determines what power the motors get
        double powery = gamepad1.left_stick_y;
        //float powerx = gamepad1.left_stick_x;
        //float powerz = gamepad1.right_stick_x;
        //For tank drive;
        double powerv = gamepad1.right_stick_y;
        //tells the position of the servos

      /*  if (gamepad2.left_bumper){
            //poking for beacons
            leftPoker.setPosition(0.715);
            rightPoker.setPosition(1);}

        if (gamepad2.right_bumper){
            rightPoker.setPosition(0.235);
            leftPoker.setPosition(0);}
*/
        if (gamepad2.y){
          //  rightPoker.setPosition(1);
            //leftPoker.setPosition(0);
        }
        if (gamepad1.right_trigger>0.001){
            backRight.setPower(powerv*10/10);
            backLeft.setPower(powery*10/10);
        }
        else if (gamepad1.right_trigger<=0.001){
            backRight.setPower(powerv*6/10);
            backLeft.setPower(powery*6/10);
        }
        if (gamepad1.left_trigger>0.001){
            backRight.setPower(powerv*1/10);
            backLeft.setPower(powery*1/10);
        }
        else if (gamepad1.left_trigger<=0.001){
            backRight.setPower(powerv*6/10);
            backLeft.setPower(powery*6/10);
        }



//Looked at the sample code

        //Low Goal Shooter
        float goalPower = -gamepad2.right_stick_y;
        //float hiPower = gamepad2.right_trigger + -gamepad2.left_trigger;
        //range clip
        Range.clip(powery, -1, 1);
        //range.clip(powerx, -0.25, 0.25);
        //range.clip(powerz, -0.25, 0.25);
        Range.clip(powerv, -1, 1);
        Range.clip(goalPower, -1, 1);
        //The range of the servo that we want to work with is till halfway of where it can turn
        //Tank Drive with only two motors


        // [Start]Turbo Mode


        //failed turbo mode
        /*driving for the mechanums
        *frontLeftMotor.setPower(powery - powerx + powerz);
        *frontRightMotor.setPower(powery + powerx - powerz);
        *backRightMotor.setPower(powery - powerx - powerz);
        *backLeft.setPower(powery + powerx + powerz);
         [End]Turbo Mode*/
//Turbo Mode doesn't seem to work
        //LowGoal
        //lowGoal.setPower(goalPower);
        //need to test these asap
        //HiGoal.setPower(hiPower);

    }
}