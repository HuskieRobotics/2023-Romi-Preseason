package frc.robot.subsystems.LEDs;

import edu.wpi.first.wpilibj.DigitalOutput;
import frc.robot.subsystems.LEDs.LEDsIO;

public class LEDsIODigitalOutput implements LEDsIO {
    // COMPONENTS ARE INSTANTIATED HERE:

    DigitalOutput redLed;
    DigitalOutput yellowLed;
    DigitalOutput greenLed;

    public LEDsIODigitalOutput() {
        // COMPONENTS ARE CONSTRUCTED HERE:
        redLed = new DigitalOutput(1);
        yellowLed = new DigitalOutput(2);
        greenLed = new DigitalOutput(3);

    }

    @Override
    public void updateInputs(LEDsIOInputs inputs) {
        // INPUTS ARE UPDATED HERE:
        inputs.redOn = redLed.get();
        inputs.yellowOn = yellowLed.get();
        inputs.greenOn = greenLed.get();

    }

    // SUBSYSTEM METHODS ARE IMPLEMENTED HERE:
    
    public void setRed(boolean on)
    {
        redLed.set(on);
    }
    public void setYellow(boolean on)
    {
        yellowLed.set(on);
    }
    public void setGreen(boolean on)
    {
        greenLed.set(on);
    }

    
}



