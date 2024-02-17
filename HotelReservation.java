package TravelAgency;
public class HotelReservation extends Reservation{
    private Hotel hotel;
    private String room_type;
    private int nights;
    private int night_price;
    public HotelReservation(String res_name, Hotel hotel, String room_type, int nights){
        super(res_name);
        night_price = hotel.reserveRoom(room_type);
        this.hotel = hotel;
        this.room_type= room_type;
        this.nights= nights;
    }
    public int getNumOfNights(){
        return this.nights;
    }
    public int getCost(){
        return night_price*nights;
    }
    public boolean equals(Object object){
        if(object == this) {
            return true;
        }
        if(!(object instanceof HotelReservation)) {
            return false;
        }
        HotelReservation res = (HotelReservation)object;
        int cost = res.getCost();
        int num_nights = res.getNumOfNights();
        String name = res.reservationName();
        String type = res.room_type;
        if(type.equals(this.room_type) == false) {
            return false;
        }
        if(cost==this.getCost() && nights==this.nights && name.equals(this.reservationName())) {
            return true;
        }
        return false;
    }
}
