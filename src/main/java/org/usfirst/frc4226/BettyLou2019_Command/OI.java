// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4226.BettyLou2019_Command;

import org.usfirst.frc4226.BettyLou2019_Command.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import oi.limelightvision.limelight.frc.LimeLight;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc4226.BettyLou2019_Command.subsystems.*;
import org.usfirst.frc4226.BettyLou2019_Command.util.JoystickPOVButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    
    public Joystick diverStick;
    public JoystickButton DiverStick_A;


    public Joystick coDiverStick;
    public JoystickButton coDiverStick_A;
    public JoystickButton coDiverStick_B;
    public JoystickButton coDiverStick_X;
    public JoystickButton coDiverStick_Y;
    public JoystickPOVButton coDiverStick_POV_N;
    public JoystickPOVButton coDiverStick_POV_S;
    public JoystickPOVButton coDiverStick_POV_E;
    public JoystickPOVButton coDiverStick_POV_W;
    public JoystickButton coDiverStick_left_Bumper_PB;
    public JoystickButton coDiverStick_right_Bumper_PB;
    public JoystickButton coDiverStick_back_PB;
    public JoystickButton coDiverStick_start_PB;
    public LimeLight limeLight;

   

    public OI() {
        limeLight = new LimeLight();
       
        
        
        setUpDriverStick();
        setUpCoDriverStick();
        
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Drive Mode", new DriveModeToggle());
    }

    private void setUpDriverStick() {
        diverStick = new Joystick(0);

        DiverStick_A = new JoystickButton(diverStick, 1);
        DiverStick_A.whileHeld(new DriveWithLimeLight());

    }

    private void setUpCoDriverStick() {

        coDiverStick = new Joystick(1);

        coDiverStick_start_PB = new JoystickButton(coDiverStick, 8);
        coDiverStick_start_PB.whenPressed(new Intake_TallyWacker_DWN(.5));
        coDiverStick_back_PB = new JoystickButton(coDiverStick, 7);
        coDiverStick_back_PB.whenPressed(new Intake_TallyWacker_Up(0.5));
        coDiverStick_right_Bumper_PB = new JoystickButton(coDiverStick, 6);
        coDiverStick_right_Bumper_PB.whileHeld(new Intake_Tallywacker_Jog_DWN());
        coDiverStick_left_Bumper_PB = new JoystickButton(coDiverStick, 5);
        coDiverStick_left_Bumper_PB.whileHeld(new Intake_Tallywacker_Jog_Up());
        
        //elevator Butons
        coDiverStick_A = new JoystickButton(coDiverStick, 1);
        coDiverStick_A.whileHeld(new Elevator_To_Setpoint(Robot.elevator.deliver_Hatch_Rocket_POS1));

        coDiverStick_B = new JoystickButton(coDiverStick, 2);
        coDiverStick_B.whileHeld(new Elevator_To_Setpoint(Robot.elevator.deliver_Hatch_Rocket_POS2));

        coDiverStick_X = new JoystickButton(coDiverStick, 3);
        coDiverStick_X.whileHeld(new Elevator_To_Setpoint(Robot.elevator.pick_Hatch_Depot_POS));

        coDiverStick_Y = new JoystickButton(coDiverStick, 4);
        coDiverStick_Y.whileHeld(new Elevator_To_Setpoint(Robot.elevator.deliver_Hatch_Rocket_POS3));


        coDiverStick_POV_N = new JoystickPOVButton(coDiverStick, JoystickPOVButton.NORTH);
        coDiverStick_POV_N.whileHeld(new Elevator_To_Setpoint(Robot.elevator.deliver_Cargo_Rocket_POS3));

        coDiverStick_POV_E = new JoystickPOVButton(coDiverStick, JoystickPOVButton.EAST);
        coDiverStick_POV_E.whileHeld(new Elevator_To_Setpoint(Robot.elevator.deliver_Cargo_Rocket_POS2));

        coDiverStick_POV_E = new JoystickPOVButton(coDiverStick, JoystickPOVButton.WEST);
        coDiverStick_POV_E.whileHeld(new Elevator_To_Setpoint(Robot.elevator.deliver_Cargo_Ship_POS));

        coDiverStick_POV_S = new JoystickPOVButton(coDiverStick, JoystickPOVButton.SOUTH);
        coDiverStick_POV_S.whileHeld(new Elevator_To_Setpoint(Robot.elevator.deliver_Cargo_Rocket_POS1));
    }

    

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getdiverStick() {
        return diverStick;
    }

    public Joystick getcoDiverStick() {
        return coDiverStick;
    }

    public LimeLight getLimeLight(){
        return limeLight;
    }
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

