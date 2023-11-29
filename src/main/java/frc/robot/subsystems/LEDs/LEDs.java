package frc.robot.subsystems.LEDs;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.LEDs.LEDsIO.LEDsIOInputs;

public class LEDs extends SubsystemBase 
{
  LEDsIO io;
  LEDsIOInputs inputs;

  public LEDs(LEDsIO io) 
  {
    this.io = io;
    inputs = new LEDsIOInputs();
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
    io.updateInputs(inputs);
  }

  // SHELL METHODS ARE DEFINED HERE:

  public void turnOffRed()
  {
    io.turnOffRed();
  }
  public void turnOffGreen()
  {
    io.turnOffGreen();
  }
  public void turnOffYellow()
  {
    io.turnOffYellow();
  }

  public void turnOnRed()
  {
    io.turnOnRed();
  }
  public void turnOnGreen()
  {
    io.turnOnGreen();
  }
  public void turnOnYellow()
  {
    io.turnOnYellow();
  }

  public boolean getRedState()
  {
    return inputs.isRedOn;
  }
  public boolean getGreenState()
  {
    return inputs.isGreenOn;
  }
  public boolean getYellowState()
  {
    return inputs.isYellowOn;
  }
}