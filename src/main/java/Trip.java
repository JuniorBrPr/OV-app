import java.time.LocalTime;
    public class Trip {
        private final Route route;
        private final Location locationA;
        private final Location locationB;
        private final LocalTime departure;
        private final LocalTime arrival;

        public Trip(Route route, Location locationA, Location locationB, LocalTime departure) {
            this.route = route;
            this.locationA = locationA;
            this.locationB = locationB;
            this.departure = route.getDeparture(locationA);
            this.arrival = route.getArrival(locationB);
        }

        public LocalTime getDeparture() {
            return departure;
        }

        public void print()
        {
            System.out.println(route.getKey() + departure + arrival);
        }
    }

