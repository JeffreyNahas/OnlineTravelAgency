package assignment1;
public abstract class Reservation {
    private String name;
    public Reservation(String clientname){
        name= clientname;
    }
    public final String reservationName(){
        return name;
    }
    public abstract int getCost();
    public abstract boolean equals(Object object);
    public static void main(String[] args) {

    }
}
