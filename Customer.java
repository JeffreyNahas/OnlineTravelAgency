package assignment1;
public class Customer {
    private String name;
    private int balance;
    private Basket customer_res;

    public Customer(String name, int i_balance){
        this.name= name;
        customer_res= new Basket();;
        balance= i_balance;
    }
    public String getName(){
        return name;
    }
    public int getBalance(){
        return balance;
    }
    public Basket getBasket(){
        return this.customer_res;
    }
    public int addFunds(int amount_added){
        if(amount_added<0){
            throw new IllegalArgumentException("The input is not in the correct format");
        }
        balance+= amount_added;
        return balance;
    }
    public int addToBasket(Reservation res){
        if(res.reservationName().equals(this.name)){
            customer_res.add(res);
        }else{
            throw new IllegalArgumentException("The name on the reservation does not match the name of the customer");
        }
        return customer_res.getNumOfReservations();
    }
    public int addToBasket(Hotel hotel, String room_type, int num_nights, boolean breakfast){
        if(breakfast){
            BnBReservation res= new BnBReservation(name, hotel,room_type, num_nights );
            customer_res.add(res);
        }else{
            HotelReservation res= new HotelReservation(name, hotel, room_type, num_nights);
            customer_res.add(res);
        }
        return customer_res.getNumOfReservations();
    }
    public int addToBasket(Airport airport1, Airport airport2){
        try {
            FlightReservation res = new FlightReservation(name, airport1, airport2);
            customer_res.add(res);
            return customer_res.getNumOfReservations();
        }catch(IllegalArgumentException exception){
            return customer_res.getNumOfReservations();
        }
    }
    public boolean removeFromBasket(Reservation res){
        if(res== null|| customer_res == null){
            return false;
        }
        return customer_res.remove(res);
    }
    public int checkOut(){
        if(customer_res.getTotalCost()>balance){
            throw new IllegalStateException("The customer's balance is not enough.");
        }else{
            balance-= customer_res.getTotalCost();
            customer_res= null;
            return balance;
        }
    }

    public static void main(String[] args) {

    }
}
