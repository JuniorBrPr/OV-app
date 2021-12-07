package objects;

import java.time.LocalTime;
import java.util.ArrayList;

public class MeanOfTransport {
    String type;
    ArrayList<Station> route;
    ArrayList<LocalTime> departureTime;

    public MeanOfTransport(String type, ArrayList<Station> route, ArrayList<LocalTime> departureTime) {
        this.type = type;
        this.route = route;
        this.departureTime = departureTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Station> getRoute() {
        return route;
    }

    public void setRoute(ArrayList<Station> route) {
        this.route = route;
    }

    public ArrayList<LocalTime> getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(ArrayList<LocalTime> departureTime) {
        this.departureTime = departureTime;
    }
}

