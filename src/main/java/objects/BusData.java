package objects;

import objects.Data;
import objects.Location;
import objects.Route;

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
        location = new Location("Halte Landgoed Schovenhorst, Putten");
        locationMap.put(location.getName(), location);
        location = new Location("Halte School Shovenhorst, Putten");
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
        location = new Location("Halte West End, Garderen");
        locationMap.put(location.getName(), location);
        location = new Location("Halte West End, Garderen");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Hooiweg, Garderen");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Busstation Wittenberg, Stroe");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Hoeve Oud Milligen, Garderen");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Ouwendroperweg, Garderen");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Koningklijke Luchtmacht, Garderen");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Kruispunt, Uddel");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Ouwendroperweg, Garderen");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Koningklijke Luchtmacht, Garderen");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Het Aardhuis, Hoog Soeren");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Oranjeoord, Hoog Soeren");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Echoput, Hoog Soeren");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Koningin Julianatoren, Apeldoorn");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Paleis het Loo, Apeldoorn");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Gedenknaald, Apeldoorn");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Bosweg, Apeldoorn");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Grote Kerk, Apeldoorn");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Oranjepark, Apeldoorn");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Marktplein, Apeldoorn");
        locationMap.put(location.getName(), location);
        location = new Location("Halte Station Apeldoorn, Apeldoorn");
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
            route.addStopOver(locationMap.get("Halte West End, Garderen"), LocalTime.of(hour, 19), LocalTime.of(hour, 19));
            route.addStopOver(locationMap.get("Halte Bakkerstraat, Garderen"), LocalTime.of(hour, 20), LocalTime.of(hour, 20));
            route.addStopOver(locationMap.get("Halte Hooiweg, Garderen"), LocalTime.of(hour, 22), LocalTime.of(hour, 22));
            route.addStopOver(locationMap.get("Halte Busstation Wittenberg, Stroe"), LocalTime.of(hour, 22), LocalTime.of(hour, 27));
            //bus pauze
            route.addStopOver(locationMap.get("Halte Hoeve Oud Milligen, Garderen"), LocalTime.of(hour, 28), LocalTime.of(hour, 28));
            route.addStopOver(locationMap.get("Halte Ouwendroperweg, Garderen"), LocalTime.of(hour, 29), LocalTime.of(hour, 29));
            route.addStopOver(locationMap.get("Halte Koningklijke Luchtmacht, Garderen"), LocalTime.of(hour, 30), LocalTime.of(hour, 30));
            route.addStopOver(locationMap.get("Halte Kruispunt, Uddel"), LocalTime.of(hour, 32), LocalTime.of(hour, 32));
            route.addStopOver(locationMap.get("Halte Het Aardhuis, Hoog Soeren"), LocalTime.of(hour, 37), LocalTime.of(hour, 37));
            route.addStopOver(locationMap.get("Halte Oranjeoord, Hoog Soeren"), LocalTime.of(hour, 38), LocalTime.of(hour, 38));
            route.addStopOver(locationMap.get("Halte Echoput, Hoog Soeren"), LocalTime.of(hour, 39), LocalTime.of(hour, 39));
            route.addStopOver(locationMap.get("Halte Koningin Julianatoren, Apeldoorn"), LocalTime.of(hour, 43), LocalTime.of(hour, 43));
            route.addStopOver(locationMap.get("Halte Paleis het Loo, Apeldoorn"), LocalTime.of(hour, 45), LocalTime.of(hour, 45));
            route.addStopOver(locationMap.get("Halte Gedenknaald, Apeldoorn"), LocalTime.of(hour, 47), LocalTime.of(hour, 47));
            route.addStopOver(locationMap.get("Halte Bosweg, Apeldoorn"), LocalTime.of(hour, 47), LocalTime.of(hour, 47));
            route.addStopOver(locationMap.get("Halte Grote Kerk, Apeldoorn"), LocalTime.of(hour, 48), LocalTime.of(hour, 48));
            route.addStopOver(locationMap.get("Halte Oranjepark, Apeldoorn"), LocalTime.of(hour, 49), LocalTime.of(hour, 49));
            route.addStopOver(locationMap.get("Halte Marktplein, Apeldoorn"), LocalTime.of(hour, 50), LocalTime.of(hour, 50));
            route.addEndPoint(locationMap.get("Halte Station Apeldoorn, Apeldoorn"), LocalTime.of(hour, 53));


            //Apeldoorn Putten
            route = new Route(locationMap.get("Halte station Apeldoorn, Apeldoorn"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Halte Marktplein, Apeldoorn"), LocalTime.of(hour, 2), LocalTime.of(hour, 2));
            route.addStopOver(locationMap.get("Halte Oranjepark, Apeldoorn"), LocalTime.of(hour, 6), LocalTime.of(hour, 6));
            route.addStopOver(locationMap.get("Halte Grote Kerk, Apeldoorn"), LocalTime.of(hour, 8), LocalTime.of(hour, 8));
            route.addStopOver(locationMap.get("Halte Bosweg, Apeldoorn"), LocalTime.of(hour, 10), LocalTime.of(hour, 10));
            route.addStopOver(locationMap.get("Halte Gedenknaald, Apeldoorn"), LocalTime.of(hour, 11), LocalTime.of(hour, 11));
            route.addStopOver(locationMap.get("Halte Paleis het Loo, Apeldoorn"), LocalTime.of(hour, 11), LocalTime.of(hour, 11));
            route.addStopOver(locationMap.get("Halte Koningin Julianatoren, Apeldoorn"), LocalTime.of(hour, 13), LocalTime.of(hour, 13));
            route.addStopOver(locationMap.get("Halte Echoput, Hoog Soeren"), LocalTime.of(hour, 14), LocalTime.of(hour, 14));
            route.addStopOver(locationMap.get("Halte Oranjeoord, Hoog Soeren"), LocalTime.of(hour, 15), LocalTime.of(hour, 15));
            route.addStopOver(locationMap.get("Halte Het Aardhuis, Hoog Soeren"), LocalTime.of(hour, 15), LocalTime.of(hour, 15));
            route.addStopOver(locationMap.get("Halte Kruispunt, Uddel"), LocalTime.of(hour, 17), LocalTime.of(hour, 17));
            route.addStopOver(locationMap.get("Halte Koningklijke Luchtmacht, Garderen"), LocalTime.of(hour, 17), LocalTime.of(hour, 17));
            route.addStopOver(locationMap.get("Halte De Hertshoorn, Garderen"), LocalTime.of(hour, 17), LocalTime.of(hour, 17));
            route.addStopOver(locationMap.get("Halte Heidenheuvel, Garderen"), LocalTime.of(hour, 18), LocalTime.of(hour, 18));
            route.addStopOver(locationMap.get("Halte Ouwendroperweg, Garderen"), LocalTime.of(hour, 19), LocalTime.of(hour, 19));
            route.addStopOver(locationMap.get("Halte Hoeve Oud Milligen, Garderen"), LocalTime.of(hour, 20), LocalTime.of(hour, 20));
            route.addStopOver(locationMap.get("Halte Busstation Wittenberg, Stroe"), LocalTime.of(hour, 22), LocalTime.of(hour, 22));

            //Bus pauze
            route = new Route(locationMap.get("Halte Busstation Wittenberg, Stroe"), LocalTime.of(hour, 0));
            route.addStopOver(locationMap.get("Halte Hooiweg, Garderen"), LocalTime.of(hour, 22), LocalTime.of(hour, 22));
            route.addStopOver(locationMap.get("Halte Bakkerstraat, Garderen"), LocalTime.of(hour, 26), LocalTime.of(hour, 26));
            route.addStopOver(locationMap.get("Halte Kerkstraat, Putten"), LocalTime.of(hour, 28), LocalTime.of(hour, 28));
            route.addStopOver(locationMap.get("Halte West End, Garderen"), LocalTime.of(hour, 30), LocalTime.of(hour, 30));
            route.addStopOver(locationMap.get("Halte Heidenheuvel, Garderen"), LocalTime.of(hour, 31), LocalTime.of(hour, 31));
            route.addStopOver(locationMap.get("Halte De Hertshoorn, Garderen"), LocalTime.of(hour, 31), LocalTime.of(hour, 31));
            route.addStopOver(locationMap.get("Halte Veluw Hul, Garderen"), LocalTime.of(hour, 33), LocalTime.of(hour, 33));
            route.addStopOver(locationMap.get("Halte De Rusthoeve, Putten"), LocalTime.of(hour, 34), LocalTime.of(hour, 34));
            route.addStopOver(locationMap.get("Halte Mooi Veluwe, Putten"), LocalTime.of(hour, 35), LocalTime.of(hour, 36));
            route.addStopOver(locationMap.get("Halte Landgoed Groot Spriel, Putten"), LocalTime.of(hour, 37), LocalTime.of(hour, 37));
            route.addStopOver(locationMap.get("Halte School Shovenhorst, Putten"), LocalTime.of(hour, 38), LocalTime.of(hour, 38));
            route.addStopOver(locationMap.get("Halte Landgoed Schovenhorst, Putten"), LocalTime.of(hour, 38), LocalTime.of(hour, 38));
            route.addStopOver(locationMap.get("Halte Bosrand, Putten"), LocalTime.of(hour, 39), LocalTime.of(hour, 39));
            route.addStopOver(locationMap.get("Halte Centrum, Putten"), LocalTime.of(hour, 40), LocalTime.of(hour, 40));
            route.addStopOver(locationMap.get("Halte Kerkstraat, Putten"), LocalTime.of(hour, 41), LocalTime.of(hour, 41));
            route.addStopOver(locationMap.get("Halte Dorpsstraat, Putten"), LocalTime.of(hour, 42), LocalTime.of(hour, 42));
            route.addStopOver(locationMap.get("Halte Stationsstraat, Putten"), LocalTime.of(hour, 44), LocalTime.of(hour, 44));
            route.addEndPoint(locationMap.get("Halte station Putten"), LocalTime.of(hour, 48));

            addRoute(route);
        }
    }
}
