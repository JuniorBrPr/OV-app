import java.time.LocalTime;

public class BusData extends Data
{
    public BusData() {
        Location location = new Location("Halte station Putten");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Stationsstraat, Putten");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Dorpsstraat, Putten");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Kerkstraat, Putten");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Centrum, Putten");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Bosrand, Putten");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Landgoed Groot Spriel, Putten");
        locationMap.put(location.getName(), location);
        location = new Location("Halte De Hertshoorn, Putten");
        locationMap.put(location.getName(), location);
        location = new Location("Halte De Rusthoeve, Putten");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Heidenheuvel, Garderen");
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



        for (int hour = 7; hour <= 19; hour += 1) {

            //Putten-----Apeldoorn
            var route = new Route(locationMap.get("Halte station Putten"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Halte Stationsstraat, Putten"), LocalTime.of(hour, 2), LocalTime.of(hour, 2));
            route.addStopOver(locationMap.get("Halte Dorpsstraat, Putten"), LocalTime.of(hour, 6), LocalTime.of(hour, 6));
            route.addStopOver(locationMap.get("Halte Kerkstraat, Putten"), LocalTime.of(hour, 8), LocalTime.of(hour, 8));
            route.addStopOver(locationMap.get("Halte Centrum, Putten"), LocalTime.of(hour, 10), LocalTime.of(hour, 10));
            route.addStopOver(locationMap.get("Halte Bosrand, Putten"), LocalTime.of(hour, 11), LocalTime.of(hour, 11));
            route.addStopOver(locationMap.get("Halte Landgoed Schovenhorst, Putten"), LocalTime.of(hour, 11), LocalTime.of(hour, 11));
            route.addStopOver(locationMap.get("Halte School Shovenhorst, Putten"), LocalTime.of(hour, 13), LocalTime.of(hour, 13));
            route.addStopOver(locationMap.get("Halte Landgoed Groot Spriel, Putten"), LocalTime.of(hour, 14), LocalTime.of(hour, 14));
            route.addStopOver(locationMap.get("Halte Mooi Veluwe, Putten"), LocalTime.of(hour, 15), LocalTime.of(hour, 15));
            route.addStopOver(locationMap.get("Halte De Rusthoeve, Putten"), LocalTime.of(hour, 15), LocalTime.of(hour, 15));
            route.addStopOver(locationMap.get("Halte Veluw Hul, Garderen"), LocalTime.of(hour, 17), LocalTime.of(hour, 17));
            route.addStopOver(locationMap.get("Halte De Hertshoorn, Garderen"), LocalTime.of(hour, 17), LocalTime.of(hour, 17));
            route.addStopOver(locationMap.get("Halte Heidenheuvel, Garderen"), LocalTime.of(hour, 18), LocalTime.of(hour, 18));
            route.addEndPoint(locationMap.get("Schiphol airport"), LocalTime.of(hour, 46));
            addRoute(route);
        }
    }
}
