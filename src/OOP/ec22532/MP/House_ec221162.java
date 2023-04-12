package OOP.ec22532.MP;

class House_ec221162 extends House {

    private final int numberRooms = 3;

    private Room[] rooms;


    House_ec221162() {
        rooms = new Room[numberRooms];
        rooms[0] = new Room_ec22430();
        rooms[1] = new Room_ec22808();
        rooms[2] = new Room_ec22704();
    }

    public Direction visit(Visitor visitor, Direction direction) {

          boolean escape = false;

        int currentIndex = 0;

        Room currentRoom = rooms[currentIndex];


        visitor.tell("You are in the house. You are in room:" + currentIndex);

        Direction wayPoint = currentRoom.visit(visitor, Direction.TO_EAST);


        while (!escape) {


            if (wayPoint == Direction.TO_NORTH) {

                visitor.tell("That door is fake! You have left the house");
                escape = true;
            }


            else if (wayPoint == Direction.TO_WEST) {
                if (currentIndex == 0) {

                    visitor.tell("There is no door on this side.");
                } else {
                    currentIndex--;
                    currentRoom = rooms[currentIndex];

                    visitor.tell("You have no entered the room: " + currentIndex);
                }
            }


            else if (wayPoint == Direction.TO_EAST) {
                if (currentIndex == numberRooms - 1) {

                    visitor.tell("There is no door on this side.");
                } else {
                    currentIndex++;
                    currentRoom = rooms[currentIndex];

                    visitor.tell("You have no entered the room: " + currentIndex);
                }
            }


            else if (wayPoint == Direction.TO_SOUTH) {
                if (currentRoom == rooms[1]) {

                    visitor.tell("The door is jammed!");
                } else {

                    visitor.tell("You have discovered a secret door to Room 1!");
                    currentRoom = rooms[1];
                    currentIndex = 1;
                }
            }

            wayPoint = currentRoom.visit(visitor, wayPoint);
        }


        return wayPoint.opposite(direction);
    }
}