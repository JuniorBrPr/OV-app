import java.time.LocalTime;
import java.util.Locale;

public class StopOver extends Location
{
    LocalTime arrival;
    LocalTime departure;

    public StopOver(String name, LocalTime departure, LocalTime arrival) {
        super(name);
        this.arrival = arrival;
        this.departure = departure;
    }
}



