package org.firstinspires.ftc.teamcode;

/**
 * Created by tvt on 9/21/17.
 */

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "AutoDepotExp", group = "Testers")
//@Disabled

public class AutoDepotExp extends AutoBaseRoverRuckus {

    @Override
    public void runOpMode() {
        super.runOpMode();
    }

    //preset paths based on where the gold cube is located (left, center, right) based on approximate x values
    public void goldLeft() {
        turnUsingPIDVoltage(35, robotSpeed);
        movePID(28, robotSpeed);
        turnUsingPIDVoltage(-57, robotSpeed);
        movePID(25, robotSpeed);
        robot.leftFlip.setPosition(0.6);
        robot.rightFlip.setPosition(0.4);
        sleep(500);
        robot.teamMarker.setPosition(1);
        sleep(1000);
        robot.teamMarker.setPosition(0);

        //go for crater
        robot.leftFlip.setPosition(0);
        robot.rightFlip.setPosition(1);
        movePID(-8, robotSpeed);
        turnUsingPIDVoltage(20, robotSpeed);
        movePID(8, robotSpeed);
        turnUsingPIDVoltage(138, robotSpeed);
        movePID(65, robotSpeed);
        robot.leftFlip.setPosition(0.8);
        robot.rightFlip.setPosition(0.2);
    }

    public void goldCenter() {
        movePID(40, robotSpeed);
        robot.leftFlip.setPosition(0.6);
        robot.rightFlip.setPosition(0.4);
        sleep(1000);
        robot.teamMarker.setPosition(1);
        sleep(1000);
        robot.teamMarker.setPosition(0);

//        //simple backup
//        robot.leftFlip.setPosition(0);
//        robot.rightFlip.setPosition(1);
//        movePID(-39, robotSpeed);

        //go for crater
        robot.leftFlip.setPosition(0);
        robot.rightFlip.setPosition(1);
        turnUsingPIDVoltage(20, robotSpeed);
        robot.move(10, robotSpeed);
        turnUsingPIDVoltage(100, robotSpeed);
        movePID(65, robotSpeed);
        robot.leftFlip.setPosition(0.8);
        robot.rightFlip.setPosition(0.2);

    }

    //Test goldRight before goldLeft. then apply reverse to goldLeft.
    public void goldRight() {
        turnUsingPIDVoltage(-35, robotSpeed);
        movePID(28, robotSpeed);
        turnUsingPIDVoltage(63, robotSpeed);
        movePID(27, robotSpeed);
        robot.leftFlip.setPosition(0.6);
        robot.rightFlip.setPosition(0.4);
        sleep(100);
        robot.teamMarker.setPosition(1);
        sleep(1000);
        robot.teamMarker.setPosition(0);

//        //simple backup
//        robot.leftFlip.setPosition(0);
//        robot.rightFlip.setPosition(1);
//        movePID(-29, robotSpeed);
//        turnUsingPIDVoltage(-63, robotSpeed);
//        movePID(-24, robotSpeed);
        robot.leftFlip.setPosition(0);
        robot.rightFlip.setPosition(1);
        turnUsingPIDVoltage(15, 1);
        movePID(3, 1);
        turnUsingPIDVoltage(40, 1);
        movePID(65, 1);
        robot.leftFlip.setPosition(0.8);
        robot.rightFlip.setPosition(0.2);
    }

    public void finishPath() {
        movePID(102, robotSpeed);
    }
}
