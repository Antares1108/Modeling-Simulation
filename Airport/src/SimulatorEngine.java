/**
 * Modified by Huanli_Wang on 04/02/2017.
 */

import java.util.TreeSet;

public class SimulatorEngine implements EventHandler {

    private double m_currentTime;
    private TreeSet<Event> m_eventList;
    private boolean m_running;

    SimulatorEngine() {
        m_running = false;
        m_currentTime = 0.0;
        m_eventList = new TreeSet<Event>();
    }

    void run() {
        m_running = true;
        while(m_running && !m_eventList.isEmpty()) {
            Event ev = m_eventList.pollFirst();
            m_currentTime = ev.getTime();
            ev.getHandler().handle(ev);
        }
    }

    public void handle(Event event) {
        SimulatorEvent ev = (SimulatorEvent)event;

        switch(ev.getType()) {
            case SimulatorEvent.STOP_EVENT:
                m_running = false;
                System.out.println("Simulator stopping at time: " + ev.getTime());
                for(Airport airport : AirportSim.airports) {
                    System.out.println("----------- " + airport.getM_airportName() + " ------------");
                    System.out.println("Arrive passagers are: " + airport.getNumOfArrive());
                    System.out.println("Depart passagers are: " + airport.getNumOfDepart());
                    System.out.println("All circle time is " + String.format("%.2f", airport.getCircleTime()));
//                    System.out.println(airport.getNumOfArrive() + airport.getNumOfDepart());
//                    System.out.println(airport.getNumOfDepart());
//                    System.out.println(String.format("%.2f", airport.getCircleTime()));
                }
                break;
            default:
                System.out.println("Invalid event type");
        }
    }

    public void schedule(Event event) {
        m_eventList.add(event);
    }

    public void stop() {
        m_running = false;
    }

    public double getCurrentTime() {
        return m_currentTime;
    }
}
