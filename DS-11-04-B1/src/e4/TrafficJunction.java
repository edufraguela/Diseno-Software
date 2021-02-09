package e4;

public class TrafficJunction {
    private TrafficLights north = new TrafficLights(LightColor.VERDE, "NORTH", 0, 4);
    private TrafficLights south = new TrafficLights(LightColor.ROJO, "SOUTH", 66, 4);
    private TrafficLights east = new TrafficLights(LightColor.ROJO, "EAST", 44, 4);
    private TrafficLights west = new TrafficLights(LightColor.ROJO, "WEST", 22, 4);

    public TrafficJunction () {

    }

    /**
     * Indicates that a second of time has passed , so the traffic light with
     * the green or amber light should add 1 to its counter . If the counter
     * passes its maximum value the color of the traffic light must change .
     * If it changes to red then the following traffic light changes to green .
     * The order is: north , south , east , west and then again north .
     */
    public void timesGoesBy (){
         north.incrementar();
         south.incrementar();
         east.incrementar();
         west.incrementar();
    }


    /**
     * If active is true all the traffic lights of the junction must change to
     * blinking amber ( meaning a non - controlled junction ).
     * If active is false it resets the traffic lights cycle and started again
     * with north at green and the rest at red.
     * @param active true or false
     */
    public void amberJunction ( boolean active ) {
        if (active){
            north.setActivated();
            south.setActivated();
            east.setActivated();
            west.setActivated();
        }
        else{
            north.resetTrafficLight();
            south.resetTrafficLight();
            east.resetTrafficLight();
            west.resetTrafficLight();
        }
    }




    /**
     * Returns a String with the state of the traffic lights .
     * The format for each traffic light is the following :
     * - For red colors : "[ name : RED ]"
     * - For green colors : "[ name : GREEN counter ]"
     * - For yellow colors with blink at OFF : "[ name : YELLOW OFF counter ]
     * - For yellow colors with blink at ON: "[ name : YELLOW ON]
     * Examples :
     * [ NORTH : GREEN 2][ SOUTH : RED ][ EAST : RED ][ WEST : RED ]
     * [ NORTH : AMBER OFF 5][ SOUTH : RED ][ EAST : RED ][ WEST : RED ]
     * [ NORTH : AMBER ON ][ SOUTH : AMBER ON ][ EAST : AMBER ON ][ WEST : AMBER ON]
     * @return String that represents the state of the traffic lights
     */
    @Override
    public String toString () {
        return north.toString() + south.toString() + east.toString() + west.toString();
    }
}
