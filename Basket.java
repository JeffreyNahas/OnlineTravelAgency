package assignment1;
public class Basket {
    private Reservation[] reservations;
    public Basket(){
        reservations = null;
    }
    public Reservation[] getProducts(){
        Reservation[] shallowcopy;
        if(reservations== null){
            shallowcopy= new Reservation[0];
        }else{
            shallowcopy= reservations.clone();
        }
        return shallowcopy;
    }
    public int add(Reservation res){
        Reservation[] reservations_bis = getProducts();
        reservations= new Reservation[reservations_bis.length + 1];
        for(int i=0; i< reservations_bis.length; i++ ){
            reservations[i]= reservations_bis[i];
        }
        reservations[reservations_bis.length] = res ;
        return (reservations.length);
    }
    public boolean remove(Reservation res) {
        if (reservations == null || reservations.length == 0  ) {
            return false;
        }
        if (reservations.length == 1) {
            if (reservations[0].equals(res)) {
                this.clear();
                return true;
            }
        }
        int len = reservations.length;
        Reservation[] changed = new Reservation[len - 1];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (reservations[i].equals(res) && index == 0) {
                index = 1;
                continue;
            }
            changed[i - index] = reservations[i];

        }
        reservations= changed;
        return index== 1;
    }
    public void clear(){
        this.reservations= null;
    }
    public int getNumOfReservations(){
        if(reservations== null){
            return 0;
        }
        return this.reservations.length;
    }
    public int getTotalCost(){
        int len = reservations.length;
        int cost = 0;
        for(int i=0; i<len; i++)
            cost += reservations[i].getCost();
        return cost;
    }

    public static void main(String[] args) {

    }
}
