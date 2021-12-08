import java.time.LocalTime;
    public class Trip {
        private final Route route;
        private final Location locationA;
        private final Location locationB;
        private final LocalTime departure;

        public Trip(Route route, Location locationA, Location locationB, LocalTime departure) {
            this.route = route;
            this.locationA = locationA;
            this.locationB = locationB;
            this.departure = route.getDeparture(locationA);
        }

        public LocalTime getDeparture() {
            return departure;
        }

        public void print()
        {
            System.out.println(route.getKey() + departure);
        }
    }

