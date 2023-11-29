// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.AutonomousDistance;
import frc.robot.commands.AutonomousTime;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.DriveForwardAndTurn;
import frc.robot.commands.TurnDegrees;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LEDs.LEDs;
import frc.robot.subsystems.LEDs.LEDsIODigitalOutput;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final LEDs leds = new LEDs(new LEDsIODigitalOutput());

  // Assumes a gamepad plugged into channel 0
  private final Joystick m_controller = new Joystick(0);

  // Create SmartDashboard chooser for autonomous routines
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Default command is arcade drive. This will run unless another command
    // is scheduled over it.
    m_drivetrain.setDefaultCommand(getArcadeDriveCommand());

    // Buttons
    
    Trigger button1 = new Trigger(() -> m_controller.getRawButton(1));
    Trigger button2 = new Trigger(() -> m_controller.getRawButton(2));
    Trigger button3 = new Trigger(() -> m_controller.getRawButton(3));

    // Example of how to use the onboard IO
    /*
    onboardButtonA.onTrue(Commands.sequence(Commands.waitSeconds(3), new DriveDistance(.5, 6, m_drivetrain)));
    */

    button1.onTrue(
      Commands.either(
        Commands.runOnce(leds::greenOff), 
        Commands.runOnce(leds::greenOn),
        leds::getGreen));

    button2.onTrue(
      Commands.either(
        Commands.runOnce(leds::redOff), 
        Commands.runOnce(leds::redOn),
        leds::getRed));

    button3.onTrue(
      Commands.either(
        Commands.runOnce(leds::yellowOff), 
        Commands.runOnce(leds::yellowOn),
        leds::getYellow));
    
    /*
     * Useful pre-written commands:
     *  Commands.sequence(Command... commands) - Returns a command that runs a list of commands in sequence
     *  Commands.parallel(Command... commands) - Returns a command that runs a list of commands in parallel
     *  Commands.waitSeconds(double seconds) - Returns a command that waits for a specified number of seconds to finish
     *  Commands.runOnce(Runnable runnable) - Returns a command that runs a runnable (aka a lambda) once
     *  Commands.either(Command onTrue, Command onFalse, BooleanSupplier selector) - Returns one of two commands based on a boolean
     */

    // Setup SmartDashboard options
    m_chooser.setDefaultOption("Example Auto Command", getExampleAutoCommand());
    m_chooser.addOption("Custom Auto Command", getCustomAutoCommand());
    SmartDashboard.putData(m_chooser);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

  /**
   * Use this to pass the teleop command to the main {@link Robot} class.
   *
   * @return the command to run in teleop
   */
  public Command getArcadeDriveCommand() {
    return new ArcadeDrive(
        m_drivetrain, () -> -0.75*m_controller.getRawAxis(1), () -> -0.75*m_controller.getRawAxis(2));
  }

  /**
   * This returns the example sequential command the romi will follow
   * 
   * @return the example command
   */
  public Command getExampleAutoCommand() {
    return Commands.sequence( 
      new DriveForwardAndTurn(50, 90, m_drivetrain)
    );
  }

  public Command getCustomAutoCommand() {
    return Commands.sequence( 
      //The list of commands goes below here
      
    );
  }
}