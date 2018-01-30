/**
 * Created by Huanli_Wang on 09/02/2017.
 */
public class GeoMap {
    private static int[][] geoMap = {{0 , 300, 900, 950, 1200},
                                    {300,   0, 630, 660, 1450},
                                    {900, 630,   0, 100, 2000},
                                    {950, 660, 100,   0, 2100},
                                    {1200, 1450, 2000, 2100, 0}};

    /*
    private static AirportName[] airportList = {AirportName.JFK, AirportName.ATL, AirportName.SFO, AirportName.SJC, AirportName.LHR};
    */

    public static int getDistance(AirportName a1, AirportName a2) {
        return geoMap[a1.getId()][a2.getId()];
    }
}
