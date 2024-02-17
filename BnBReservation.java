package assignment1;
public class BnBReservation extends HotelReservation{
    public BnBReservation(String res_name, Hotel hotel, String room_type, int num_nights){
        super(res_name, hotel, room_type,num_nights);
    }
    public int getCost(){
        return super.getCost()+ 1000*super.getNumOfNights();
    }

    public static void main(String[] args) {

    }
}
