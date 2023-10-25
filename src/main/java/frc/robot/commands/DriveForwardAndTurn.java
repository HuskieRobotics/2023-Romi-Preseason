// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveForwardAndTurn extends CommandBase {

  private double distance;
  private double degrees;

  private final Drivetrain m_drive;

  private boolean finishedMoving;

  /** Creates a new DriveForwardAndTurn. */
  public DriveForwardAndTurn(double nDistance, double nDegrees, Drivetrain drive) {
    this.distance = nDistance;
    this.degrees = nDegrees;
    this.m_drive = drive;

    this.finishedMoving = false;

    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.arcadeDrive(0, 0);
    m_drive.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!this.finishedMoving)
    {
      m_drive.arcadeDrive(1, 0);

      if(Math.abs(m_drive.getAverageDistanceInch()) >= this.distance)
        finishedMoving = true;
    }
    else
      m_drive.arcadeDrive(0, 1);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double inchPerDegree = Math.PI * 5.551 / 360;
    // Compare distance travelled from start to distance based on degree turn
    return getAverageTurningDistance() >= (inchPerDegree * this.degrees);
  }

  private double getAverageTurningDistance() {
    double leftDistance = Math.abs(m_drive.getLeftDistanceInch());
    double rightDistance = Math.abs(m_drive.getRightDistanceInch());
    return (leftDistance + rightDistance) / 2.0;
  }
}
