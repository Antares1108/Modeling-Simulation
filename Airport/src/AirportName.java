/**
 * Created by Huanli_Wang on 09/02/2017.
 */
public enum AirportName {
    JFK("JFK", 0),
    ATL("ATL", 1),
    SFO("SFO", 2),
    SJC("SJC", 3),
    LHR("LHR", 4);

    private final String name;
    private final int id;

    AirportName(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return name;
    }
}
