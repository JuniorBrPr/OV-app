import java.time.LocalTime;
import java.util.ArrayList;

public class Route {
    private final ArrayList<StopOver> stopOvers = new ArrayList<>();

    Route(Location location, LocalTime departure) {
        var stopover = new StopOver(location.getName(), LocalTime.MAX, departure);
        stopOvers.add(stopover);
    }

    public void addStopOver(Location location, LocalTime arrival, LocalTime departure) {
        var stopover = new StopOver(location.getName(), arrival, departure);
        stopOvers.add(stopover);
    }

    public LocalTime getSoonestAvailable(LocalTime timeInput, String start, String end){
        int i;
        LocalTime time = null;
        for(i=0; i<stopOvers.size(); i++){
            if(timeInput.isAfter(stopOvers.get(i).departure))   continue;   //time not valid
            if(start.equals(stopOvers.get(i).getName()))        continue;   //does not match location

            time=stopOvers.get(i).departure;
        }

        for (;i<stopOvers.size(); i++){                   //continues where you left off with i on the last for loop
            if(end.equals(stopOvers.get(i).getName()))          continue;   //does not match location
            return time;                                  //Returns first available departure time
        }
        return null;
    }

    public void addEndPoint(Location location, LocalTime arrival) {
        var stopover = new StopOver(location.getName(), arrival, LocalTime.MIN);
        stopOvers.add(stopover);
    }

    public String getKey() {
        String key = stopOvers.get(0).getName();

        for (int i = 0; i < stopOvers.size(); i++) {
            key += "-";
            key += stopOvers.get(i).getName();
        }
        return key;
    }
}
