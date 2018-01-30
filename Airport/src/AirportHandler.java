public class AirportHandler implements EventHandler {

    //TODO add landing and takeoff queues, random variables

    private Airport airport;

    public AirportHandler(Airport airport) {
        this.airport = airport;
    }

    public Airport getAirport() {
        return airport;
    }

    public void handle(Event event) {

        AirportEvent airEvent = (AirportEvent)event;
        Airplane airplane = airEvent.getAirplane();

        switch(airEvent.getType()) {
            case AirportEvent.PLANE_ARRIVES:
                airplane.setArriveTime(Simulator.getCurrentTime());
                airport.addNewAirplane(airplane);
                //airport.addInTheAir(airEvent.getAirplane());
                System.out.println(getTime() + " : " + airEvent.getAirplane().getName() + " arrived at   airport " + airport.getM_airportName());
                if(airport.getM_inTheAir() == 1 || airport.isRunwayFree(Simulator.getCurrentTime())) {
                    Airplane newAirplane = airport.nextAirplaneToLand();
                    //AirportEvent landedEvent = new AirportEvent(airport.getM_runwayTimeToLand(), this, AirportEvent.PLANE_LANDED, airplane);
                    AirportEvent landedEvent = new AirportEvent(Math.max(airport.getEmptyTime(), Simulator.getCurrentTime()) + airport.getM_runwayTimeToLand(), this, AirportEvent.PLANE_LANDED, newAirplane);
                    airport.setEmptyTime(landedEvent.getTime());
                    Simulator.schedule(landedEvent);
                }
//                else if (airport.getM_inTheAir() == 1) {
//                    airport.nextAirplaneToLand();
//                    AirportEvent landedEvent = new AirportEvent(Math.max(airport.getEmptyTime(), Simulator.getCurrentTime()) + airport.getM_runwayTimeToLand(), this, AirportEvent.PLANE_LANDED, airplane);
//                    airport.setEmptyTime(landedEvent.getTime());
//                    //System.out.println("Delta 002's land time " + landedEvent.getTime());
//                    //AirportEvent landedEvent = new AirportEvent(Simulator.getCurrentTime() + airport.getM_runwayTimeToLand(), this, AirportEvent.PLANE_LANDED, airplane);
//                    Simulator.schedule(landedEvent);
//                }

                break;

            case AirportEvent.PLANE_DEPARTS:
                System.out.println(getTime() + " : " + airEvent.getAirplane().getName() + " departs from airport " + airport.getM_airportName());
                airplane.setNewTarget();
                airplane.setPassenger();
                airplane.setSource(airport);
                airport.addDepart(airplane.getNumberPassengers());
                airport.leaveGround();
                AirportHandler newHandler = new AirportHandler(airplane.getTarget());
                //AirportEvent takeoffEvent = new AirportEvent(airplane.getFlightTime(), newHandler, AirportEvent.PLANE_ARRIVES, airplane);
                AirportEvent takeoffEvent = new AirportEvent(Simulator.getCurrentTime() + airport.getM_runwayTimeToLeft() + airplane.getFlightTime(), newHandler, AirportEvent.PLANE_ARRIVES, airplane);
                Simulator.schedule(takeoffEvent);
//                if(airport.getM_inTheAir() != 0)
//                {
//                    Airplane next = airport.nextAirplaneToLand();
//                    AirportEvent landingEvent = new AirportEvent(Math.max(airport.getEmptyTime(), Simulator.getCurrentTime()) + airport.getM_runwayTimeToLand(), this, AirportEvent.PLANE_LANDED, next);
//                    airport.setEmptyTime(landingEvent.getTime());
//                    Simulator.schedule(landingEvent);
//                }
                break;

            case AirportEvent.PLANE_LANDED:
                airport.addGround(airplane);
                airport.updateCircleTime(Simulator.getCurrentTime() - airplane.getArriveTime());
                System.out.println(getTime() + " : " + airEvent.getAirplane().getName() + " landed  at   airport " + airport.getM_airportName());
                airport.addArrive(airplane.getNumberPassengers());

                if(airport.getM_onTheGround() == 1 || airport.isRunwayFree(Simulator.getCurrentTime())) {
                    Airplane first = airport.nextAirplaneToLeft();
                    AirportEvent departEvent = new AirportEvent(Math.max(airport.getEmptyTime(), Simulator.getCurrentTime()) + airport.getM_runwayTimeToLeft(), this, AirportEvent.PLANE_DEPARTS, first);
                    airport.setEmptyTime(departEvent.getTime());
                    Simulator.schedule(departEvent);
                }
//                else if (airport.getM_onTheGround() == 1) {
//                    airport.nextAirplaneToLeft();
//                    AirportEvent departEvent = new AirportEvent(Math.max(airport.getEmptyTime(), Simulator.getCurrentTime()) + airport.getM_runwayTimeToLeft(), this, AirportEvent.PLANE_DEPARTS, airplane);
//                    airport.setEmptyTime(departEvent.getTime());
//                    Simulator.schedule(departEvent);
//                }

                if(airport.getM_inTheAir() != 0)
                {
                    Airplane next = airport.nextAirplaneToLand();
                    AirportEvent landingEvent = new AirportEvent(Math.max(airport.getEmptyTime(), Simulator.getCurrentTime()) + airport.getM_runwayTimeToLand(), this, AirportEvent.PLANE_LANDED, next);
                    airport.setEmptyTime(landingEvent.getTime());
                    Simulator.schedule(landingEvent);
                }
                break;
        }
    }

    public String getTime() {
        return String.format("%-6.1f", Simulator.getCurrentTime());
    }
}
