import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Airport {
    private AirportName m_airportName;
    private int m_inTheAir;
    private int m_onTheGround;


    private double m_runwayTimeToLand;
    private double m_runwayTimeToLeft;
    private double m_requiredTimeOnGround;
    private int numOfArrive;
    private int numOfDepart;
    private double circleTime;
    private double preFreeTime;

    private Queue<Airplane> inTheAir;
    private Queue<Airplane> onTheGround;

    public Airport(AirportName name, double runwayTimeToLand, double requiredTimeOnGround, double runwayTimeToLeft) {
        m_airportName = name;
        m_inTheAir =  0;
        m_onTheGround = 0;
        m_runwayTimeToLand = runwayTimeToLand;
        m_requiredTimeOnGround = requiredTimeOnGround;
        m_runwayTimeToLeft = runwayTimeToLeft;
        inTheAir = new LinkedList<>();
        onTheGround = new LinkedList<>();
        circleTime = 0;
        preFreeTime = 0;
    }

    public void addNewAirplane(Airplane airplane) {
        inTheAir.add(airplane);
        m_inTheAir++;
    }

    public Airplane nextAirplaneToLand() {
        m_inTheAir--;
        return inTheAir.poll();
    }

    public Airplane nextAirplaneToLeft() {
        m_onTheGround--;
        return onTheGround.poll();
    }

    public void addGround(Airplane airplane) {
        onTheGround.add(airplane);
        m_onTheGround++;
    }

    public Airplane leaveGround() {
        Airplane leave = null;
        if (onTheGround.size() != 0) {
            leave = onTheGround.poll();
            m_onTheGround--;
        }
        return leave;
    }

    public void updateCircleTime(double time) {
        circleTime += time;
    }

    public void setEmptyTime(double time) {
        preFreeTime = time;
    }

    public double getCircleTime() {
        return circleTime;
    }

    public void addArrive(int num) {
        numOfArrive += num;
    }

    public void addDepart(int num) {
        numOfDepart += num;
    }

    public int getNumOfArrive() {
        return numOfArrive;
    }

    public int getNumOfDepart() {
        return numOfDepart;
    }


    public AirportName getM_airportName() {
        return m_airportName;
    }


    public int getM_inTheAir() {
        return m_inTheAir;
    }


    public int getM_onTheGround() {
        return m_onTheGround;
    }


    public boolean isRunwayFree(double curTime) {
        int cmp = Double.compare(preFreeTime, curTime);
        if (cmp > 0) {
            return false;
        } else {
            preFreeTime = curTime;
            return true;
        }
    }

    public void addCapturedTime(double time) {
        preFreeTime += time;
    }

    public double getEmptyTime() {
        return preFreeTime;
    }

    public double getM_runwayTimeToLeft() { return m_runwayTimeToLeft; }


    public double getM_runwayTimeToLand() {
        return m_runwayTimeToLand;
    }


    public double getM_requiredTimeOnGround() {
        return m_requiredTimeOnGround;
    }

}
