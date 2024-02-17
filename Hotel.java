package TravelAgency;
public class Hotel {
    private String name;
    private Room[] rooms;
    public Hotel(String hotelname, Room[] hotelrooms) {
        name = hotelname;
        rooms = new Room[hotelrooms.length];
        for (int i = 0; i < hotelrooms.length; i++) {
            rooms[i]= new Room(hotelrooms[i]);
        }
    }
    public int reserveRoom(String roomtype){
        if(Room.findAvailableRoom(rooms, roomtype)!= null){
            int roomPrice= Room.findAvailableRoom(rooms, roomtype).getPrice();
            Room.findAvailableRoom(rooms, roomtype).changeAvailability();
            return (roomPrice);
        } else{
           throw new IllegalArgumentException("No rooms are available in the hotel.");
        }
    }
    public boolean cancelRoom(String roomtype) {
        return (Room.makeRoomAvailable(rooms, roomtype));
    }
    public static void main(String[] args){
    }
}
