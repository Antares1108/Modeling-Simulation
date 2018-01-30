/**
 * Modified by Huanli_Wang on 04/02/2017.
 */


public class SimulatorEvent extends Event {
    public static final int STOP_EVENT = 0;

    SimulatorEvent(double delay, EventHandler handler, int eventType) {
        super(delay, handler, eventType);
    }
}
