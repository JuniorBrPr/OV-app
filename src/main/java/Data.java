import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedMap;
import java.util.TreeMap;

public class Data {
    private final HashMap<String, Location> locationMap = new HashMap<>();
    private SortedMap<String, HashSet<Route>> routeMap = new TreeMap<>();

    public Data() {
        Location location = new Location("Amersfoort");
        locationMap.put(location.getName(), location);

        location = new Location("Hilversum");
        locationMap.put(location.getName(), location);

        location = new Location("Amsterdam Zuid ");
        locationMap.put(location.getName(), location);

        location = new Location("Shiphol airport");
        locationMap.put(location.getName(), location);

        location = new Location("Utrecht");
        locationMap.put(location.getName(), location);

        location = new Location("Apeldoorn");
        locationMap.put(location.getName(), location);

        ///////////////
        Route amersfoortSchipholAirport = new Route(locationMap.get("Amersfoort"), LocalTime.of(7, 0));
        amersfoortSchipholAirport.addStopOver(locationMap.get("Hilversum"), LocalTime.of(7,15), LocalTime.of(7,16));
        amersfoortSchipholAirport.addStopOver(locationMap.get("Amsterdam zuid"), LocalTime.of(7,31), LocalTime.of(7,31));
        amersfoortSchipholAirport.addEndPoint(locationMap.get("Schiphol airport"), LocalTime.of(7,46));

        Route schipholAirportAmersfoort = new Route(locationMap.get("Schiphol airport"), LocalTime.of(7,0));
        schipholAirportAmersfoort.addStopOver(locationMap.get("Amsterdam zuid"), LocalTime.of(7,15), LocalTime.of(7,16));
        schipholAirportAmersfoort.addStopOver(locationMap.get("Hilversum"), LocalTime.of(7,31), LocalTime.of(7,32));
        schipholAirportAmersfoort.addEndPoint(locationMap.get("Amersfoort"), LocalTime.of(7,46));




        addRoute(amersfoortSchipholAirport);
        addRoute(schipholAirportAmersfoort);
    }
    private void addRoute(Route route)
    {
        var routeKey = route.getKey();

        var set= routeMap.get(routeKey);
        if(null==set){
            set = new HashSet<>();
            routeMap.put(routeKey, set);
        }
            set.add(route);
        }
    }



