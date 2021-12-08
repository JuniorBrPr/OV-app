import java.time.LocalTime;

public class TrainData extends Data {
    public TrainData() {

        // Amersfoort----Schipjol Aiport
        for (int hour = 7; hour <= 19; hour += 1) {
            var route = new Route(locationMap.get("Amersfoort"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Utrecht"), LocalTime.of(hour, 15), LocalTime.of(hour, 16));
            route.addStopOver(locationMap.get("Amsterdam zuid"), LocalTime.of(hour, 31), LocalTime.of(hour, 31));
            route.addEndPoint(locationMap.get("Schiphol airport"), LocalTime.of(hour, 46));
            addRoute(route);
        }
        // Schiphol Aiport----Amersfoort
        for (int hour = 7; hour <= 19; hour += 1) {
            ////////////
            var route = new Route(locationMap.get("Schiphol airport"), LocalTime.of(hour, 30));
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
            route.addStopOver(locationMap.get("Schiphol airport"), LocalTime.of(hour, 15), LocalTime.of(hour, 16));
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
    }
}