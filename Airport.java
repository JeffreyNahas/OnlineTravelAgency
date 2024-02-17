package assignment1;
public class Airport {
    private int Xcoordinate;
    private int Ycoordinate;
    private int Fees;
    public static void main(String[] args){

    }
    public Airport(int Xcoordinate, int Ycoordinate, int Fees) {
        this.Xcoordinate = Xcoordinate;
        this.Ycoordinate= Ycoordinate;
        this.Fees= Fees;
    }
    public int getFees() {

        return this.Fees;
    }
    public static int getDistance(Airport airport1 ,Airport airport2) {
        double Xdistance= airport1.Xcoordinate - airport2.Xcoordinate;
        double Ydistance= airport1.Ycoordinate - airport2.Ycoordinate;
        double distance = Math.ceil(Math.sqrt(Math.pow(Xdistance, 2) + Math.pow(Ydistance, 2)));
        return (int) distance;

    }
}
