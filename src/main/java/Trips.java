import java.util.ArrayList;

public class Trips
{
    private final ArrayList<Trip> trips = new ArrayList<>();

    public void addTrip(Trip trip)
    {
        trips.add(trip);
    }

    public void print()
    {
        int count = 0;
        for (var t : trips)
        {
            System.out.println(" " + ++count);
            t.print();
        }
    }

}
