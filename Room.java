package TravelAgency;
public class Room {
    private String type;
    private int price;
    private boolean availability;

    public static void main(String[] args) {

    }

    public Room(String roomtype) {
        type = roomtype;
        if (roomtype.equals("double")) {
            this.price = 9000;
        } else if (roomtype.equals("queen")) {
            this.price = 11000;
        } else if (roomtype.equals("king")) {
            this.price = 15000;
        } else {
            throw new IllegalArgumentException("No room of such type can be created");
        }
        this.availability = true;
    }

    public Room(Room room1) {
        type = room1.type;
        price = room1.price;
        availability = room1.availability;
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }

    public void changeAvailability() {
        availability = !availability;
    }

    public static Room findAvailableRoom(Room[] rooms, String roomtype) {
        for (int i = 0; i < rooms.length; i++) {
            if(rooms[i]== null){
                continue;
            }
            if (rooms[i].type.equals(roomtype) && rooms[i].availability == true) {
                return rooms[i];
            }
        }
        return (null);
    }
    public static boolean makeRoomAvailable(Room[] rooms, String roomtype) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i]== null){
                continue;
            }
            if (rooms[i].type == roomtype && rooms[i].availability == false) {
                rooms[i].availability = true;
                return true;
            }
        }
        return false;
    }
}
