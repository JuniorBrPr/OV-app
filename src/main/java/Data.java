import java.time.LocalTime;
import java.util.*;

public class Data {
    protected final HashMap<String, Location> locationMap = new HashMap<>();
    protected final SortedMap<String, HashSet<Route>> routeMap = new TreeMap<>();

    public Data() {

        Location location = new Location("Amersfoort");
        locationMap.put(location.getName(), location);

        location = new Location("Utrecht");
        locationMap.put(location.getName(), location);

        location = new Location("Amsterdam zuid");
        locationMap.put(location.getName(), location);

        location = new Location("Amsterdam");
        locationMap.put(location.getName(), location);

        location = new Location("Schiphol airport");
        locationMap.put(location.getName(), location);

        location = new Location("Apeldoorn");
        locationMap.put(location.getName(), location);

        location = new Location("Rotterdam");
        locationMap.put(location.getName(), location);

        location = new Location("Den Haag");
        locationMap.put(location.getName(), location);

        location = new Location("Gouda");
        locationMap.put(location.getName(), location);

    }

    protected Trips getTrips(String keyA, String keyB, LocalTime departure)
    {
        Trips trips = new Trips();
        int count = 0;
        for (var e : routeMap.entrySet())
        {
            var routeKey = e.getKey(); //vb: Amersterdam-Utrecht-Arnhem-Nijmegen
            var posA = routeKey.indexOf(keyA); //indexOf("Utrecht") = 10
            if (posA>=0)
            {
                var posB = routeKey.indexOf(keyB);
                if (posB > posA) //Als posB groter is dan posA dan a-->B
                {
                    var set = e.getValue();
                    for (var r : set)
                    {
                        var candidate = new Trip(r, getLocation(keyA), getLocation(keyB),departure);
                        if (candidate.getDeparture().isAfter(departure));
                        {
                            trips.addTrip(candidate);
                        }
                    }
                }

            }
        }
        return trips;
    }

    public Location getLocation(String key)
    {
        return locationMap.get(key);
    }
    void addRoute(Route route)
    {
        var routeKey = route.getKey();

        var set = routeMap.get(routeKey);
        if (set == null) {
            set = new HashSet<Route>();
            routeMap.put(routeKey, set);
        }

        set.add(route);
    }
}

