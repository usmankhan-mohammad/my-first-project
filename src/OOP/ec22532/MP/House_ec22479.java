package OOP.ec22532.MP;

public class House_ec22479 extends House {

    // First Room - Fahim Miah
    private Room room1 = new Room_ec22717(); // North, East, South, West
    // Second Room - Mine :D
    private Room room2 = new Room_ec22479(); // Leavin this room leads north
    // Third Room - Tuddin
    private Room room3 = new Room_ec22944(); // North, East, South, West
    // Fourth Room - Zubair >B)
    private Room room4 = new Room_ec22480(); // Leaves opposite direction they came from
    String currentRoom;

    // Room Order: Room2, Room3, Room1, Room4

    public Direction visit(Visitor v, Direction d) {
        v.tell("Welcome to the humble abode.");
        v.tell("This is quite a small house, but please make yourself comfortable");
        v.tell("Also, please leave through a door.. I can't keep on fixing windows");
        // FIRST ROOM - MINE
        room2.visit(v, d); // They will ALWAYS leave North
        v.tell("That was quite a weird room.. wasn't it?");
        currentRoom = "mosRoom";
        boolean hasTmansWisdomTooth = false;
        while (true) {

            // MOHAMED
            if (currentRoom.equals("mosRoom")) {
                currentRoom = "tanvirsRoom";
                d = room3.visit(v, d);
            }

            // TANVIR -- ENTERING FROM THE SOUTH
            if (currentRoom.equals("tanvirsRoom")) {
                if (d == Direction.TO_NORTH) {
                    if (!hasTmansWisdomTooth) {
                        currentRoom = "zubairsRoom";
                        d = room4.visit(v, d); // LEAVES TO ZUBAIRS
                        if (v.hasEqualItem(new Item("T Man's Wisdom Tooth"))) {
                            hasTmansWisdomTooth = true;
                        }
                    } else {
                        String exitDirections = "a) North, b) East, c) South, d) West";
                        char[] exitChoices = { 'a', 'b', 'c', 'd' };
                        v.tell("This room seems to be just rubble now.. please try another exit");
                        char visitorExitChoice = v.getChoice(exitDirections, exitChoices);
                        if (visitorExitChoice == 'a') {
                            d = Direction.TO_NORTH;
                        }

                        else if (visitorExitChoice == 'b') {
                            d = Direction.TO_EAST;
                        }

                        else if (visitorExitChoice == 'c') {
                            d = Direction.TO_SOUTH;
                        }

                        else {
                            d = Direction.TO_WEST;
                        }

                    }

                } else if (d == Direction.TO_SOUTH) {
                    currentRoom = "mosRoom";
                    d = room2.visit(v, d); // BACK TO MINE
                } else if (d == Direction.TO_EAST) {
                    currentRoom = "fahimsRoom";
                    d = room1.visit(v, d); // TO FAHIM'S
                } else if (d == Direction.TO_WEST) {
                    v.tell("THIS GLASS ISN'T GOING TO FIX ITSELF! GIVE ME 10 GOLD!!");
                    v.takeGold(10);
                    return d;
                }
            }

            // ZUBAIR
            if (currentRoom.equals("zubairsRoom")) {
                currentRoom = "tanvirsRoom";
                d = room3.visit(v, d);
            }

            // FAHIM
            if (currentRoom.equals("fahimsRoom")) {
                if (d == Direction.TO_EAST) {
                    v.tell("You left through the back door.");
                    v.tell("I hope you enjoyed your stay! :)");
                    v.giveGold(10);
                    v.tell("Have a safe journey!");
                    return d;
                } else if (d == Direction.TO_WEST) {
                    currentRoom = "tanvirsRoom";
                    d = room3.visit(v, d); // GOES BACK TO TANVIR'S ROOM
                }

                else if (d == Direction.TO_NORTH || d == Direction.TO_SOUTH) {
                    v.tell("THIS GLASS ISN'T GOING TO FIX ITSELF! GIVE ME 10 GOLD!!");
                    v.takeGold(10);
                    return d;
                }
            }
        }
    }
}
