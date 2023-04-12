package OOP.ec22532.MP;

public class House_ec22704 extends House {

    private final int numberRooms = 3;

    int currentAmountGold;
    Room[] rooms;

    // Assigns rooms to the house version 2
    public House_ec22704() {
        rooms = new Room[numberRooms];
        rooms[0] = new Room_ec22897();
        rooms[1] = new Room_ec22748();
        rooms[2] = new Room_ec22704();
    }

    public Direction visit(Visitor visitor, Direction direction) {

        boolean escape = false;

        int currentIndex = 0;

        Room currentRoom = rooms[currentIndex];

        // Greet the visitor and welcome them to the house
        visitor.tell("Welcome to the house! You are currently in Room " + currentIndex);

        Direction wayPoint = currentRoom.visit(visitor, Direction.TO_EAST);




        while (!escape) {

//            // Allow north way
            if (wayPoint == Direction.TO_NORTH) {
                // Inform the visitor that the door is fake and they have left the house


                if (currentIndex==2)
                {
                    visitor.tell("HAHAHA YOU CANT TURN BACK GO SOUTH");


                } else if (currentIndex==0) {

                    visitor.tell("Hey Woah Why You Leaving So Early? Here Is Some Gold To Make You Stay");
                    visitor.giveGold(4);


                }
                
                else
                {

                    visitor.tell("Oops! That door is fake...you have now left the house");
                    escape = true;
                    break;
                }


            }


            // Allow west way
            else if (wayPoint == Direction.TO_WEST) {
                if (currentIndex == 0) {
                    // Inform the visitor that there is no door on this side
                    visitor.tell("Sorry, there is no door on this side");
                } else {
                    currentIndex--;
                    currentRoom = rooms[currentIndex];
                    // Inform the visitor which room they have entered
                    visitor.tell("You are now entering Room " + currentIndex);
                }
            }

            // Allow east way
            else if (wayPoint == Direction.TO_EAST) {
                if (currentIndex == numberRooms - 1) {
                    // Inform the visitor that there is no door on this side
                    visitor.tell("Sorry, there is no door on this side");
                }

                else {
                    currentIndex++;
                    currentRoom = rooms[currentIndex];
                    // Inform the visitor which room they have entered
                    visitor.tell("You are now entering Room " + currentIndex);
                }
            }

            // Allow south way
            else if (wayPoint == Direction.TO_SOUTH) {
                if (currentIndex == 0) {
                    // Inform the visitor that they have discovered a secret door and lead them to room 1
                    visitor.tell("Congratulations! You have discovered a secret door to Room 1.");
                    currentRoom = rooms[1];
                    currentIndex = 1;
                    //adding second secret room
                } else if (currentIndex == 1) {
                    // Inform the visitor that they have discovered a secret door and lead them to room 2
                    visitor.tell("Congratulations! You have discovered a secret door to Room 2.");
                    currentRoom = rooms[2];
                    currentIndex = 2;

                }
                else if (currentIndex == 2) {
                    // Inform the visitor that they have discovered a secret door and lead them to room 2
                    visitor.tell("Sad To See You Go,Come Back Soon ");
                    break;
                }
                else {

                    // Inform the visitor that the door is stuck
                    visitor.tell("Oops! This door is stuck, sorry!");
                }
            }

            wayPoint = currentRoom.visit(visitor, wayPoint);

        }


        // Return the opposite direction of the last wayPoint visited
        return wayPoint.opposite(direction);
    }
}
