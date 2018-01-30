public class AirportEvent extends Event {
    public static final int PLANE_ARRIVES = 0;
    public static final int PLANE_LANDED = 1;
    public static final int PLANE_DEPARTS = 2;

    private Airplane airplane;

    AirportEvent(double delay, EventHandler handler, int eventType) {
        super(delay, handler, eventType);
        airplane = new Airplane("N/A");
        airplane.setSource(((AirportHandler) handler).getAirport());
    }

    AirportEvent(double delay, EventHandler handler, int eventType, Airplane airplane) {
        super(delay, handler, eventType);
        this.airplane = airplane;
        airplane.setSource(((AirportHandler) handler).getAirport());
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public boolean isSameAirportHandler(AirportEvent other) {
        return ((AirportHandler) getHandler()).getAirport().getM_airportName() == ((AirportHandler) other.getHandler()).getAirport().getM_airportName();
    }
}
