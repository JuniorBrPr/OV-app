package objects;

import java.time.LocalTime;
import java.util.ArrayList;

public class Route {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Declarations
    private final ArrayList<StopOver> stopOvers = new ArrayList<>();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Constructor
    Route(Location location, LocalTime departure) {
        var stopover = new StopOver(location.getName(), LocalTime.MAX, departure);
        stopOvers.add(stopover);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Maakt een halte aan
    public void addStopOver(Location location, LocalTime arrival, LocalTime departure) {
        var stopover = new StopOver(location.getName(), arrival, departure);
        stopOvers.add(stopover);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    //Print de eerstvolgende route
//    public LocalTime getSoonestAvailable(LocalTime timeInput, String start, String end){
//        int i;
//        LocalTime time = null;
//        for(i=0; i<stopOvers.size(); i++){
//            if(timeInput.isAfter(stopOvers.get(i).departure))   continue;   //time not valid
//            if(start.equals(stopOvers.get(i).getName()))        continue;   //does not match location
//
//            time=stopOvers.get(i).departure;
//        }
//
//        for (;i<stopOvers.size(); i++){                   //continues where you left off with i on the last for loop
//            if(end.equals(stopOvers.get(i).getName()))          continue;   //does not match location
//            return time;                                  //Returns first available departure time
//        }
//        return null;
//    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Maakt een eind halte aan
    public void addEndPoint(Location location, LocalTime arrival) {
        var stopover = new StopOver(location.getName(), arrival, LocalTime.MIN);
        stopOvers.add(stopover);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Maakt de objects.Route naam
    public String getKey() {
        String key = stopOvers.get(0).getName();

        for (int i = 0; i < stopOvers.size(); i++) {
            key += "-";
            key += stopOvers.get(i).getName();
        }
        return key;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public LocalTime getDeparture(){return stopOvers.get(0).getDeparture();}

    public LocalTime getDeparture(Location location)
    {
        for (var e: stopOvers)
        {
            if (e.getName().equals(location.getName()))
            {
                return e.getDeparture();
            }
        }
        return null;
    }

    public LocalTime getArrival() {
        return stopOvers.get(stopOvers.size() -1).getArrival();
    }

    public LocalTime getArrival(Location locationB)
    {
    return getArrival();
    }
}

