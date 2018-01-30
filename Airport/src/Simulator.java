/**
 * Modified by Huanli_Wang on 04/02/2017.
 */

import java.util.TreeSet;

//singleton
public class Simulator {

    //singleton
    private static SimulatorEngine instance = null;

    public static SimulatorEngine getSim() {
        if(instance == null) {
            instance = new SimulatorEngine();
        }
        return instance;
    }

    public static void stopAt(double time) {
        Event stopEvent = new SimulatorEvent(time, getSim(), SimulatorEvent.STOP_EVENT);
        schedule(stopEvent);
    }

    public static void run() {
        getSim().run();
    }

    public static double getCurrentTime() {
        return getSim().getCurrentTime();
    }

    public static void schedule(Event event) {
        //event.setTime(event.getTime() + getSim().getCurrentTime());
        getSim().schedule(event);
    }
}
