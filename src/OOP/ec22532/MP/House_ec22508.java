package OOP.ec22532.MP;

class House_ec22508 extends House {

    Room[][] house;
    int[] current;
    boolean atExit = false;

    class Hallway extends Room {
        @Override
        public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
            Direction direction = Direction.TO_NORTH;

            visitor.tell("This is a hallway.");
            visitor.tell("You can continue down this hallway, or visit a room.");
            visitor.tell("Choose an option");
            char answer = visitor.getChoice("[A] Continue down the hallway \n" +
                                            "[B] Visit the room to your right\n" +
                                            "[C] Visit the room to your left ", new char[]{'A', 'B', 'C'});

            if (answer == 'A' || answer == 'a') {
                direction = Direction.TO_NORTH;
            }

            if (answer == 'B' || answer == 'b') {
                direction = Direction.TO_WEST;
            }

            if (answer == 'C' || answer == 'c') {
                direction = Direction.TO_EAST;
            }
            return direction;
        }
    }


    public House_ec22508() {
        Room_ec22508 roomEc22508 = new Room_ec22508();
        Room_ec22507 roomEc22507 = new Room_ec22507();
        Room_ec22510 roomEc22510 = new Room_ec22510();

        Hallway hallway = new Hallway();


        house = new Room[][]{
                {roomEc22507, hallway, roomEc22507},
                {roomEc22508, hallway, roomEc22508},
                {roomEc22507, hallway, roomEc22510}
        };

        current = new int[]{2, 1};
    }

    @Override
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {
        Direction direction = Direction.TO_NORTH;

        /*
            current[0][0]     current[0][1]     current[0][2]
            current[1][0]     current[1][1]     current[1][2]
            current[2][0]     current[2][1]     current[2][2]
         */

        Room currentRoom = house[current[0]][current[1]];

        while (!atExit) {

            System.out.println("Current position: " + current[0] + ", " + current[1]);

            if ((current[0] > 2 || current[0] < 0) && (current[1] > 2 || current[1] < 0)) {
                visitor.tell("It seems you've wandered to far...");
                visitor.tell("Let me put you back in your place...");
                current[0] = 1; current[1] = 1;
            }
            // The visitor enters a room
            Direction newDirection = currentRoom.visit(visitor, direction);

            if ((current[0] == 0 && current[1] == 1) && newDirection == Direction.TO_NORTH) {
                atExit = true;
                visitor.tell("Well Done! You've reached the exit.");
                break;
            }

            System.out.println("New direction: " + newDirection);

            // Update the direction of the visitor
            if (newDirection == Direction.TO_EAST) {
                current[1] -= 1;
            }
            if (newDirection == Direction.TO_NORTH) {
                current[0] -= 1;
            }
            if (newDirection == Direction.TO_WEST) {
                current[1] += 1;
            }
            if (newDirection == Direction.TO_SOUTH) {
                visitor.tell("We don't look back...");
                visitor.tell("Let me help you find your way...");
                current[0] = 2;
                current[1] = 1;
            }

            // Update the current room
            currentRoom = house[current[0]][current[1]];
        }
        return direction;
    }
}
