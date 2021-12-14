package objects;

import objects.Location;
import objects.Route;
import objects.Trip;
import objects.Trips;

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
    public Data() {
        Location location = new Location("Amersfoort");
        locationMap.put(location.getName(), location);
        location = new Location("Utrecht");
        locationMap.put(location.getName(), location);
        location = new Location("Amsterdam Zuid");
        locationMap.put(location.getName(), location);
        location = new Location("Amsterdam");
        locationMap.put(location.getName(), location);
        location = new Location("Schiphol Airport");
        locationMap.put(location.getName(), location);
        location = new Location("Apeldoorn");
        locationMap.put(location.getName(), location);
        location = new Location("Rotterdam");
        locationMap.put(location.getName(), location);
        location = new Location("Den Haag");
        locationMap.put(location.getName(), location);
        location = new Location("Gouda");
        locationMap.put(location.getName(), location);
        location = new Location("Tilburg");
        locationMap.put(location.getName(), location);
        location = new Location("Breda");
        locationMap.put(location.getName(), location);
        location = new Location("Eindhoven");
        locationMap.put(location.getName(), location);
        location = new Location("Enschede");
        locationMap.put(location.getName(), location);
        location = new Location("Almelo");
        locationMap.put(location.getName(), location);
        location = new Location("Hengelo");
        locationMap.put(location.getName(), location);
        location = new Location("Deventer");
        locationMap.put(location.getName(), location);


        // Amersfoort----Schipjol Aiport
        for (int hour = 7; hour <= 19; hour += 1) {
            var route = new Route(locationMap.get("Amersfoort"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Utrecht"), LocalTime.of(hour, 15), LocalTime.of(hour, 16));
            route.addStopOver(locationMap.get("Amsterdam Zuid"), LocalTime.of(hour, 31), LocalTime.of(hour, 31));
            route.addEndPoint(locationMap.get("Schiphol Airport"), LocalTime.of(hour, 46));
            addRoute(route);
        }
        // Schiphol Aiport----Amersfoort
        for (int hour = 7; hour <= 19; hour += 1) {
            ////////////
            var route = new Route(locationMap.get("Schiphol Airport"), LocalTime.of(hour, 30));
            route.addStopOver(locationMap.get("Amsterdam Zuid"), LocalTime.of(hour, 45), LocalTime.of(hour, 45));
            route.addStopOver(locationMap.get("Utrecht"), LocalTime.of(hour + 1, 0), LocalTime.of(hour + 1, 0));
            route.addEndPoint(locationMap.get("Amersfoort"), LocalTime.of(hour + 1, 15));
            addRoute(route);
        }
        // Apeldoorn----Den Haag
        for (int hour = 7; hour <= 19; hour += 1) {
            var route = new Route(locationMap.get("Apeldoorn"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Amersfoort"), LocalTime.of(hour, 15), LocalTime.of(hour, 16));
            route.addStopOver(locationMap.get("Utrecht"), LocalTime.of(hour, 31), LocalTime.of(hour, 31));
            route.addStopOver(locationMap.get("Gouda"), LocalTime.of(hour, 46), LocalTime.of(hour, 47));
            route.addEndPoint(locationMap.get("Den Haag"), LocalTime.of(hour, 59));
            addRoute(route);
        }
        // Schiphol Aiport----Amersfoort
        for (int hour = 7; hour <= 19; hour += 1) {
            var route = new Route(locationMap.get("Den Haag"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Gouda"), LocalTime.of(hour, 15), LocalTime.of(hour, 16));
            route.addStopOver(locationMap.get("Utrecht"), LocalTime.of(hour, 31), LocalTime.of(hour, 31));
            route.addStopOver(locationMap.get("Amersfoort"), LocalTime.of(hour, 46), LocalTime.of(hour, 47));
            route.addEndPoint(locationMap.get("Apeldoorn"), LocalTime.of(hour, 59));
            addRoute(route);
        }
        // Amsterdam----Rotterdam
        for (int hour = 7; hour <= 19; hour += 1) {
            var route = new Route(locationMap.get("Amsterdam"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Schiphol Airport"), LocalTime.of(hour, 15), LocalTime.of(hour, 16));
            route.addEndPoint(locationMap.get("Rotterdam"), LocalTime.of(hour, 42));
            addRoute(route);
        }
        //  Rotterdam----Amsterdam
        for (int hour = 7; hour <= 19; hour += 1) {
            ////////////
            var route = new Route(locationMap.get("Rotterdam"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Schiphol Airport"), LocalTime.of(hour, 15), LocalTime.of(hour, 16));
            route.addEndPoint(locationMap.get("Amsterdam"), LocalTime.of(hour, 38));
            addRoute(route);
        }
        // Breda---Eindhoven
        for (int hour = 7; hour <= 19; hour += 1) {
            var route = new Route(locationMap.get("Breda"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Tilburg"), LocalTime.of(hour, 15), LocalTime.of(hour, 16));
            route.addEndPoint(locationMap.get("Eindhoven"), LocalTime.of(hour, 40));
            addRoute(route);
        }
        // Eindhoven---Brede
        for (int hour = 7; hour <= 19; hour += 1) {
            var route = new Route(locationMap.get("Eindhoven"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Tilburg"), LocalTime.of(hour, 24), LocalTime.of(hour, 25));
            route.addEndPoint(locationMap.get("Breda"), LocalTime.of(hour, 40));
            addRoute(route);
        }

        // Enschede---Utrecht centraal
        for (int hour = 7; hour <= 19; hour += 1) {
            var route = new Route(locationMap.get("Enschede"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Hengelo"), LocalTime.of(hour, 18), LocalTime.of(hour, 19));
            route.addStopOver(locationMap.get("Almelo"), LocalTime.of(hour, 31), LocalTime.of(hour, 31));
            route.addStopOver(locationMap.get("Deventer"), LocalTime.of(hour, 53), LocalTime.of(hour, 54));
            route.addStopOver(locationMap.get("Apeldoorn"), LocalTime.of(hour + 1, 6), LocalTime.of(hour, 7));
            route.addStopOver(locationMap.get("Amersfoort"), LocalTime.of(hour + 1, 32), LocalTime.of(hour, 33));
            route.addEndPoint(locationMap.get("Utrecht"), LocalTime.of(hour + 1, 46));
            addRoute(route);
        }
        // Utrecht centraal---Enschede
        for (int hour = 7; hour <= 19; hour += 1) {
            var route = new Route(locationMap.get("Utrecht"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Amersfoort"), LocalTime.of(hour, 18), LocalTime.of(hour, 19));
            route.addStopOver(locationMap.get("Apeldoorn"), LocalTime.of(hour, 31), LocalTime.of(hour, 31));
            route.addStopOver(locationMap.get("Deventer"), LocalTime.of(hour, 53), LocalTime.of(hour, 54));
            route.addStopOver(locationMap.get("Almelo"), LocalTime.of(hour + 1, 6), LocalTime.of(hour, 7));
            route.addStopOver(locationMap.get("Hengelo"), LocalTime.of(hour + 1, 32), LocalTime.of(hour, 33));
            route.addEndPoint(locationMap.get("Enschede"), LocalTime.of(hour + 1, 46));
            addRoute(route);
        }

    }
    public HashMap<String, Location> getLocationMap() {
        return locationMap;
    }

    public SortedMap<String, HashSet<Route>> getRouteMap() {
        return routeMap;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public Trips getTrips(String keyA, String keyB, LocalTime departure)
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

