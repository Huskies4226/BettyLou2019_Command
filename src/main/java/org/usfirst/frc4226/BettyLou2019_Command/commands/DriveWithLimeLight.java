/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc4226.BettyLou2019_Command.commands;

import org.usfirst.frc4226.BettyLou2019_Command.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithLimeLight extends Command {
  public DriveWithLimeLight() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double Kp = .05;
    double tx = Robot.oi.getLimeLight().getdegRotationToTarget();

    double zRotation = tx * Kp;

    Robot.driveTrain.my_DriveArchade(0.0, zRotation);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.my_DriveArchade(0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
