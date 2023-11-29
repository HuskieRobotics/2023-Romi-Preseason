package frc.robot.subsystems.LEDs;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.LEDs.LEDsIO.LEDsIOInputs;

public class LEDs extends SubsystemBase {

  LEDsIO io;
  LEDsIOInputs inputs;

  public LEDs(LEDsIO io) {
    this.io = io;
    inputs = new LEDsIOInputs();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  // SHELL METHODS ARE DEFINED HERE:

  
}