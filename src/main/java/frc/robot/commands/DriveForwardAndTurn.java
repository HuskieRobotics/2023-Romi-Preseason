// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import java.lang.Math;

public class DriveForwardAndTurn extends CommandBase {

  private double distance;
  private double degrees;
  private Drivetrain drive;
  

  /** Creates a new DriveForwardAndTurn. */
  public DriveForwardAndTurn(double nDistance, double nDegrees, Drivetrain nDrive) {
    distance = nDistance;
    degrees = nDegrees;
    drive = nDrive;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize()
  {
    drive.arcadeDrive(0, 0);
    drive.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    drive.arcadeDrive(distance, 0);
    boolean doneDriving = (Math.abs(drive.getAverageDistanceInch()) >= distance);
    if (doneDriving = true)
    {
      drive.arcadeDrive(0, degrees);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
