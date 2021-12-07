package objects;

import java.util.ArrayList;

public class Station {
    String name;
    ArrayList<String> facilities;

    public Station(String name, ArrayList<String> facilities) {
        this.name = name;
        this.facilities = facilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(ArrayList<String> facilities) {
        this.facilities = facilities;
    }
}
