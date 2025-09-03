import java.util.ArrayList;

public class Day {
    ArrayList<Session> monday = new ArrayList<>();
    ArrayList<Session> tuesday = new ArrayList<>();
    ArrayList<Session> wednesday = new ArrayList<>();
    ArrayList<Session> friday = new ArrayList<>();
    Session cntheory  = new Session("CN","theory");
    Session cnlab = new Session("CN","lab");
    Session cntut = new Session("CN","tut");
    Session daatheory = new Session("DAA","theory");
    Session daalab =  new Session("DAA","lab");
    Session daatut = new Session("DAA","tut");
    Session sdamtheory = new Session("SDAM","theory");
    Session sdamlab = new Session("SDAM","lab");
    Session sdamtut = new Session("SDAM", "tut");

    public void daysessions() {
        monday.add(daatheory);
        monday.add(cntheory);
        monday.add(daalab);

        tuesday.add(sdamtut);
        tuesday.add(cntheory);
        tuesday.add(sdamtheory);

        wednesday.add(sdamtheory);
        wednesday.add(daatheory);
        wednesday.add(cnlab);

        friday.add(sdamlab);
        friday.add(cntut);
        friday.add(daatut);

    }
}
