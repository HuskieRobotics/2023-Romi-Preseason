package frc.robot.subsystems.LEDs;

public interface LEDsIO {
    public static class LEDsIOInputs {
        //DATA YOU WANT TO KEEP TRACK OF GOES HERE:
        public boolean redOn;
        public boolean greenOn;
        public boolean yellowOn;

    }

    /**
     * This method is called periodically by the LEDs subsystem. Use it to update the LEDsIOInputs object.
     * 
     * @param inputs The LEDsIOInputs object to be updated.
     */

    public default void updateInputs(LEDsIOInputs inputs) {}

    //SUSYSTEM METHODS ARE DEFINED HERE:
    public void setRed(boolean on);

    public void setYellow(boolean on);

    public void setGreen(boolean on);

}
