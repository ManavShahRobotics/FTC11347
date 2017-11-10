package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.ThreadPool;

/**
 * Created by Ganondorf on 9/11/2017.
 */

public class Hardware {
    public DcMotor backLeftMotor   = null;
    public DcMotor backRightMotor  = null;
    public DcMotor frontRightMotor = null;
    public DcMotor frontLeftMotor  = null;


    public Servo Jewel = null;
    public ColorSensor colorSensor = null;

    public DcMotor Arm = null;
    public DcMotor SpinR = null;
    public DcMotor SpinL = null;
  //  public Servo Claw = null;

    public static final double Speed      =  0.5 ;



    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        backLeftMotor   = hwMap.dcMotor.get("backLeft");
        backRightMotor  = hwMap.dcMotor.get("backRight");
        frontLeftMotor  = hwMap.dcMotor.get("frontLeft");
        frontRightMotor = hwMap.dcMotor.get("frontRight");
        backLeftMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        backRightMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotor.Direction.FORWARD); // Set to FORWARD if using AndyMark motors

        Jewel = hwMap.servo.get("Jewel");
        colorSensor = hwMap.colorSensor.get("color");

        Arm = hwMap.dcMotor.get("arm");
        SpinL = hwMap.dcMotor.get("SpinL");
        SpinR = hwMap.dcMotor.get("SpinR");
        //Claw = hwMap.servo.get("Claw");



        // Set all motors to zero power
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        Jewel.setPosition(0);

        Arm.setPower(0);
        SpinR.setPower(0);
        SpinL.setPower(0);

        Arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        SpinR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        SpinL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


       // Claw.setPosition(0);
    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     */
    public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
    }
    public void driveForward (double power){

        backLeftMotor.setPower(-power);
        backRightMotor.setPower(-power);
        frontLeftMotor.setPower(-power);
        frontRightMotor.setPower(-power);
    }
    public void driveForwardTime (double power, long time){
        driveForward(power);
        waitForTick(time);
    }
    public void driveBackward (double power){
        backLeftMotor.setPower(power);
        backRightMotor.setPower(power);
        frontLeftMotor.setPower(power);
        frontRightMotor.setPower(power);
    }
    public void driveBackwardTime (double power, long time){
        driveBackward(power);
        waitForTick(time);
    }

}
