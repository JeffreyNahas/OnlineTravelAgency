package TravelAgency;
public class FlightReservation extends Reservation{
    private Airport departure;
    private Airport arrival;
    public FlightReservation(String name, Airport departure, Airport arrival){
        super(name);
        this.departure= departure;
        this.arrival= arrival;
        if(departure.equals(arrival)){
            throw new IllegalArgumentException("The airports are the same.");
        }

    }
    public int getCost(){
        double cost= departure.getFees() + arrival.getFees() + Airport.getDistance(departure, arrival)* 124/ 167.52+ 5375;
        return (int) Math.ceil(cost);

    }
    public boolean equals(Object object){
        if(object == this) {
            return true;
        }
        if(!(object instanceof FlightReservation)) {
            return false;
        }
        FlightReservation res = (FlightReservation)object;
        int dist_arrival = Airport.getDistance(res.arrival, this.arrival);
        int dist_departure = Airport.getDistance(res.departure, this.departure);
        if(dist_arrival!=0 || dist_departure!=0) {
            return false;
        }
        String name = res.reservationName();
        if(name.equals(this.reservationName()) == false) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
