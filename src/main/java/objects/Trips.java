package objects;

import objects.Trip;

import java.util.*;

public class Trips
{
    private final ArrayList<Trip> trips = new ArrayList<>();



    public ArrayList<Trip> getTrips() {
        return trips;
    }

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
