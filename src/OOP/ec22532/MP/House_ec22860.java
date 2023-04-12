package OOP.ec22532.MP;

public class House_ec22860 extends House {
    //Array of rooms from Alicia, Maks, Gabrielle and Mine's Room_
    Room[] rooms = {new Room_ec22860(),new Room_ec22828(),new Room_ec22741(),new Room_ec22660()};
    public Direction visit(Visitor guest, Direction direction) {
        char[] options = {'1', '2'};
        char choice = guest.getChoice("Type 1 to explore or 2 to leave:", options);
        
        //while user doesn't want to leave, rooms will be visited
        while (choice != '2') {
            if (direction == Direction.FROM_SOUTH) {
                direction = rooms[0].visit(guest, direction);
            } else if (direction == Direction.FROM_WEST) {
                direction = rooms[1].visit(guest, direction);
            } else if (direction == Direction.FROM_NORTH) {
                direction = rooms[2].visit(guest, direction);
            } else if (direction == Direction.FROM_EAST) {
                direction = rooms[3].visit(guest, direction);
            }
            choice = guest.getChoice("Type 1 to explore or 2 to leave:", options);
        }
        return direction;
    }

}
