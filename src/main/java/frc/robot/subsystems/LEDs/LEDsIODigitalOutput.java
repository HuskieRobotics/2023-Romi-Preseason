package frc.robot.subsystems.LEDs;

import edu.wpi.first.wpilibj.DigitalOutput;
import frc.robot.subsystems.LEDs.LEDsIO;

public class LEDsIODigitalOutput implements LEDsIO 
{
    // COMPONENTS ARE INSTANTIATED HERE:

    DigitalOutput redLed;
    DigitalOutput greenLed;
    DigitalOutput yellowLed;

    public LEDsIODigitalOutput() 
    {
        // COMPONENTS ARE CONSTRUCTED HERE:
        redLed = new DigitalOutput(1);
        greenLed = new DigitalOutput(2);
        yellowLed = new DigitalOutput(3);
    }

    @Override
    public void updateInputs(LEDsIOInputs inputs) 
    {
        // INPUTS ARE UPDATED HERE:
        inputs.isRedOn = redLed.get();
        inputs.isGreenOn = greenLed.get();
        inputs.isYellowOn = yellowLed.get();
    }

    // SUBSYSTEM METHODS ARE IMPLEMENTED HERE:

    public void turnOffRed()
    {
        redLed.set(false);   
    }
    public void turnOffGreen()
    {
        greenLed.set(false);   
    }
    public void turnOffYellow()
    {
        yellowLed.set(false);
    }

    public void turnOnRed()
    {
        redLed.set(true);
    }
    public void turnOnGreen()
    {
        greenLed.set(true);
    }
    public void turnOnYellow()
    {
        yellowLed.set(true);
    }
}