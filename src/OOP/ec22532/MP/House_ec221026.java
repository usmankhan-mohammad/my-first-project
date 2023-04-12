package OOP.ec22532.MP;

class House_ec221026 extends House {

    private final int numberRooms = 3;
    private Room[] rooms;

    House_ec221026() {
        rooms = new Room[numberRooms];
        rooms[0] = new Room_ec22430();
        rooms[1] = new Room_ec22808();
        rooms[2] = new Room_ec22704();
    }

    public Direction visit(Visitor x, Direction y) {
        boolean escape = false;
        int currI = 0;
        Room currentRoom = rooms[currI];
        x.tell("You are in the house. You are in room:" + currI);

        Direction wayPoint = currentRoom.visit(x, Direction.TO_EAST);
        while (!escape) {


            if (wayPoint == Direction.TO_NORTH) {

                x.tell("You have found the secret tunnel");
                x.tell("Well done for finding the exit, you should walk through");
                escape = true;
            }


            else if (wayPoint == Direction.TO_WEST) {
                if (currI == 0) {

                    x.tell("Welcome to not the exit");
                    x.tell("Unfortunately not the way out, you wanna grab a snack though ?");
                } 
                else {
                    currI--;
                    currentRoom = rooms[currI];

                    x.tell("You have now entered the room: " + currI);
                }
            }


            else if (wayPoint == Direction.TO_EAST) {
                if (currI == numberRooms - 1) {

                    x.tell("No door here....");
                    x.tell("Better keep moving");
                } 
                else {
                    currI++;
                    currentRoom = rooms[currI];

                    x.tell("You have no entered the room: " + currI);
                }
            }


            else if (wayPoint == Direction.TO_SOUTH) {
                if (currentRoom == rooms[1]) {

                    x.tell("The door handle is broken..");
                    x.tell("You need to find another door!");
                } 
                else {

                    x.tell("You have discovered a secret door to Room 1!");
                    currentRoom = rooms[1];
                    currI = 1;
                }
            }

            wayPoint = currentRoom.visit(x, wayPoint);
        }


        return wayPoint.opposite(y);
    }
}
