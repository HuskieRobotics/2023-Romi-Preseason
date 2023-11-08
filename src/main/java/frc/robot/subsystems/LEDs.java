package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDs extends SubsystemBase {

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
  public LEDs() {
    greenLED = new DigitalOutput(1);
    redLED = new DigitalOutput(2);
    yellowLED = new DigitalOutput(3);
  }

  public void turnGreenOn()
  {
    greenLED.set(true);
  }

  public void turnGreenOff()
  {
    greenLED.set(false);
  }

  public boolean getGreen()
  {
    return greenLED.get();
  }

  public void turnRedOn()
  {
    redLED.set(true);
  }

  public void turnRedOff()
  {
    redLED.set(false);
  }

  public boolean getRed()
  {
    return redLED.get();
  }

  public void turnYellowOn()
  {
    yellowLED.set(true);
  }

  public void turnYellowOff()
  {
    yellowLED.set(false);
  }

  public boolean getYellow()
  {
    return yellowLED.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
