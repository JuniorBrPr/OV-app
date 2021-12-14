import java.time.LocalTime;
import java.util.*;

public class Data {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Declarations
    protected final HashMap<String, Location> locationMap = new HashMap<>();
    protected final SortedMap<String, HashSet<Route>> routeMap = new TreeMap<>();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Constructor
    public Data() {}

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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

    //Print de eerstvolgende route
    public void printRoutes( String keyA, String keyB){

        int count = 0;
        for (var e : routeMap.entrySet()) {

            var routeKey  = e.getKey();
            var posA        = routeKey.indexOf(keyA);

            if (posA >= 0){

                var posB    = routeKey.indexOf(keyB);

                if(posB > posA){

                    var set = e.getValue();

                    for (var r : set){
                        System.out.format("%2d. %s: departure %s\n", ++count, r.getKey(),r.getDeparture());
                    }
                }
            }
        }

    }
}

