package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import edu.spa.ftclib.internal.state.ToggleBoolean;
import edu.spa.ftclib.sample.TestClass;

/**
 *
 */

@TeleOp(name = "Teleop", group = "prototype")

public class Teleop extends OpMode {

    private OmegaBot robot;

    private ToggleBoolean toggleBoolean = new ToggleBoolean();
    private ToggleBoolean driveMode = new ToggleBoolean();
    private ElapsedTime time = new ElapsedTime();

    @Override
    public void init() {
        robot = new OmegaBot(telemetry, hardwareMap);
    }

    /**
     * In teleop mode, the robot is continually checking for input from the user.
     */
    @Override
    public void loop() {
        robot.arm1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        if(!robot.arm1.isBusy()){ robot.arm1.setPower(0);}
        if(gamepad1.x) {
            robot.arm1.setTargetPosition(robot.arm1.getCurrentPosition() + 500);
            robot.arm1.setPower(0.5);
        }
        if(gamepad1.y) {
            robot.arm1.setTargetPosition(robot.arm1.getCurrentPosition() - 500);
            robot.arm1.setPower(-0.5);
        }
        if(gamepad1.a) {
            time.reset();
            robot.arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            while(time.seconds() < 1) {
                robot.arm1.setPower(1);
            }
            robot.arm1.setPower(0);
        }
        if(gamepad1.b) {
            time.reset();
            robot.arm1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            while(time.seconds() < 1) {
                robot.arm1.setPower(-1);
            }
            robot.arm1.setPower(0);
        }
        if(gamepad1.left_bumper) {
            robot.drivetrain.setTargetPosition(1000);
            robot.drivetrain.setVelocity(1);
        }
        if(!robot.drivetrain.isPositioning()) {
            robot.drivetrain.setVelocity(0);
        }

        telemetry.addData("arm pos", robot.arm1.getCurrentPosition());
        telemetry.addData("front_left pos", robot.frontLeft.getCurrentPosition());
        telemetry.addData("front_right pos", robot.frontRight.getCurrentPosition());
    }

    private double absMax(double a, double b) { //Returns the argument whose absolute value is greater (similar to Math.max() but compares absolute values)
        return (Math.abs(a) > Math.abs(b)) ? a : b;
    }
}

