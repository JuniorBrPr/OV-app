import java.time.LocalTime;
import java.util.Locale;

public class StopOver extends Location
{
    //Declarations
    LocalTime arrival;
    LocalTime departure;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Constructor
    public StopOver(String name, LocalTime departure, LocalTime arrival) {
        super(name);
        this.arrival = arrival;
        this.departure = departure;
    }

    public LocalTime getDeparture() {
        return departure;
    }
}



