public class AirportSim {
    public static Airport[] airports = new Airport[5];
    public static void main(String[] args) {

        airports[0] = new Airport(AirportName.JFK, 3, 4, 3);
        airports[1] = new Airport(AirportName.ATL, 3, 4, 3);
        airports[2] = new Airport(AirportName.SFO, 3, 4, 3);
        airports[3] = new Airport(AirportName.SJC, 3, 4, 3);
        airports[4] = new Airport(AirportName.LHR, 3, 4, 3);

        AirportHandler jfk = new AirportHandler(airports[0]);
        AirportHandler atl = new AirportHandler(airports[1]);
        AirportHandler sfo = new AirportHandler(airports[2]);
        AirportHandler sjc = new AirportHandler(airports[3]);
        AirportHandler lhr = new AirportHandler(airports[4]);

        Airplane airplane1 = new Airplane("Delta 001  ", 200, 50);
        Airplane airplane2 = new Airplane("Delta 002  ", 200, 50);
        Airplane airplane3 = new Airplane("Delta 003  ", 200, 50);
        Airplane airplane4 = new Airplane("AA 004     ", 250, 45);
        Airplane airplane5 = new Airplane("AA 005     ", 250, 40);
        Airplane airplane6 = new Airplane("AA 006     ", 250, 50);
        Airplane airplane7 = new Airplane("UA 007     ", 200, 45);
        Airplane airplane8 = new Airplane("UA 008     ", 200, 45);

//        AirportEvent landingEvent1 = new AirportEvent(5, jfk, AirportEvent.PLANE_ARRIVES, airplane1);
//        AirportEvent landingEvent2 = new AirportEvent(5, atl, AirportEvent.PLANE_ARRIVES, airplane2);
//        AirportEvent landingEvent3 = new AirportEvent(5, sfo, AirportEvent.PLANE_ARRIVES, airplane3);
//        AirportEvent landingEvent4 = new AirportEvent(5, sjc, AirportEvent.PLANE_ARRIVES, airplane4);
//        AirportEvent landingEvent5 = new AirportEvent(5, lhr, AirportEvent.PLANE_ARRIVES, airplane5);
//        Simulator.schedule(landingEvent1);
//        Simulator.schedule(landingEvent2);
//        Simulator.schedule(landingEvent3);
//        Simulator.schedule(landingEvent4);
//        Simulator.schedule(landingEvent5);

        for (int i = 0; i < 5; i++) {
            Simulator.schedule(new AirportEvent(5, jfk, AirportEvent.PLANE_ARRIVES, new Airplane("No." + String.format("%2d", i) + "001", 200, 50)));
            Simulator.schedule(new AirportEvent(5, atl, AirportEvent.PLANE_ARRIVES, new Airplane("No." + String.format("%2d", i) + "002", 200, 50)));
            Simulator.schedule(new AirportEvent(5, sfo, AirportEvent.PLANE_ARRIVES, new Airplane("No." + String.format("%2d", i) + "003", 200, 50)));
            Simulator.schedule(new AirportEvent(5, sjc, AirportEvent.PLANE_ARRIVES, new Airplane("No." + String.format("%2d", i) + "004", 200, 50)));
            Simulator.schedule(new AirportEvent(5, lhr, AirportEvent.PLANE_ARRIVES, new Airplane("No." + String.format("%2d", i) + "005", 200, 50)));
        }

        Simulator.stopAt(1000);
        Simulator.run();

    }
}
