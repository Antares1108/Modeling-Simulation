import java.util.Random;

/**
 * Modified by Huanli_Wang on 04/02/2017.
 */

//TODO add number of passengers, speed

public class Airplane {
    private String m_name;
    private int m_numberPassengers;
    private double speed;
    private double arriveTime;
    private double takeoffTime;
    private Airport source;
    private Airport target;
    private int capacity;
    private double flightTime;

    public Airplane(String m_name, int m_capacity, double speed, double arriveTime, double takeoffTime, Airport source, Airport target) {
        this.m_name = m_name;
        this.m_numberPassengers = 0;
        this.capacity = m_capacity;
        this.speed = speed;
        this.arriveTime = arriveTime;
        this.takeoffTime = takeoffTime;
        this.source = source;
        this.target = target;
        flightTime = 0;
        setPassenger();
    }

    public Airplane(String name, int num, double speed) {
        this(name, num, speed, 0, 0, null, null);
    }


    public Airplane(String name) {
        this(name, 100, 50, 0, 0, null, null);
    }

    public boolean setNewTarget() {
        Random random = new Random();
        if (source == null) {
            return false;
        } else {
            int curAirportId = source.getM_airportName().getId();
            int nextAirportId = random.nextInt(5);
            if (nextAirportId == curAirportId) {
                if (nextAirportId == 0) {
                    nextAirportId++;
                } else {
                    nextAirportId--;
                }
            }
            target = AirportSim.airports[nextAirportId];
            flightTime = GeoMap.getDistance(source.getM_airportName(), target.getM_airportName()) * 1.0 / speed;
            return true;
        }
    }

    public void setPassenger() {
        Random random = new Random();
        m_numberPassengers = (int) (random.nextGaussian() * 20 + capacity * 0.8);
    }

    public double getFlightTime() {
        return flightTime;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String m_name) {
        this.m_name = m_name;
    }

    public int getNumberPassengers() {
        return m_numberPassengers;
    }

    public void setNumberPassengers(int m_numberPassengers) {
        this.m_numberPassengers = m_numberPassengers;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public double getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(double arriveTime) {
        this.arriveTime = arriveTime;
    }

    public double getTakeoffTime() {
        return takeoffTime;
    }

    public void setTakeoffTime(double takeoffTime) {
        this.takeoffTime = takeoffTime;
    }

    public Airport getSource() {
        return source;
    }

    public void setSource(Airport source) {
        this.source = source;
    }

    public Airport getTarget() {
        return target;
    }

    public void setTarget(Airport target) {
        this.target = target;
    }
}
