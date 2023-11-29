package frc.robot.subsystems.LEDs;

public interface LEDsIO {
    public static class LEDsIOInputs {
        //DATA YOU WANT TO KEEP TRACK OF GOES HERE:

    }

    /**
     * This method is called periodically by the LEDs subsystem. Use it to update the LEDsIOInputs object.
     * 
     * @param inputs The LEDsIOInputs object to be updated.
     */

    public default void updateInputs(LEDsIOInputs inputs) {}

    //SUSYSTEM METHODS ARE DEFINED HERE:


}
