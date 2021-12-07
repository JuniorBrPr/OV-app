package objects;

public class Trip {
    Station startingPoint;
    Station endPoint;

    public Trip(Station startingPoint, Station endPoint) {
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
    }

    public Station getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Station startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Station getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Station endPoint) {
        this.endPoint = endPoint;
    }
}
