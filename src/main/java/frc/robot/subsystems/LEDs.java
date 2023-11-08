package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDs extends SubsystemBase 
{

  /*
   * LED's are of the DigitalOutput class
   *  Constructor:
   *    DigitalOutput​(int channel)
   *  Channels:
   *    1 - Green
   *    2 - Red
   *    3 - Yellow
   *  e.g. DigitalOutput greenLED = new DigitalOutput(1);
   */

  //Create component instance variables:
  private DigitalOutput greenLED;
  private DigitalOutput redLED;
  private DigitalOutput yellowLED;

  //instantiate component variables in the constructor
  public LEDs() 
  {
    this.greenLED = new DigitalOutput(1);
    this.redLED = new DigitalOutput(2);
    this.yellowLED = new DigitalOutput(3);
  }

  public void setGreenOn() { this.greenLED.set(true); }
  public void setRedOn() { this.redLED.set(true); }
  public void setYellowOn() { this.yellowLED.set(true); }

  public void setGreenOff() { this.greenLED.set(false); }
  public void setRedOff() { this.redLED.set(false); }
  public void setYellowOff() { this.yellowLED.set(false); }

  public boolean getGreenState() { return this.greenLED.get(); }
  public boolean getRedState() { return this.redLED.get(); }
  public boolean getYellowState() { return this.yellowLED.get(); }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
