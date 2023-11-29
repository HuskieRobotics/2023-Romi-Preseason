package frc.robot.subsystems.LEDs;

public interface LEDsIO 
{
    public static class LEDsIOInputs 
    {
        //DATA YOU WANT TO KEEP TRACK OF GOES HERE:
        public boolean isRedOn;
        public boolean isGreenOn;
        public boolean isYellowOn;
    }

    /**
     * This method is called periodically by the LEDs subsystem. Use it to update the LEDsIOInputs object.
     * 
     * @param inputs The LEDsIOInputs object to be updated.
     */

    public default void updateInputs(LEDsIOInputs inputs) {}

    //SUSYSTEM METHODS ARE DEFINED HERE:

    public void turnOffRed();
    public void turnOffGreen();
    public void turnOffYellow();

    public void turnOnRed();
    public void turnOnGreen();
    public void turnOnYellow();
}
