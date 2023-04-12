package OOP.ec22532.MP;

class Room_ec22978 extends Room {

    
    boolean recalled = false;
    boolean looted = false;
    char[] options = {'y', 'n'};
    char[] directions = {'n', 's', 'w', 'e'};

    public String directionFrom(Direction a) {
        if (a == Direction.FROM_NORTH) {
            return "North";
        } else if (a == Direction.FROM_SOUTH) {
            return "South";
        } else if (a == Direction.FROM_WEST) {
            return "West";
        } else if (a == Direction.FROM_EAST) {
            return "East";
        } else {
            return "Invalid Input";
        }
    }

    public String directionTo(Direction a) {
        if (a == Direction.TO_NORTH) {
            return "North";
        } else if (a == Direction.TO_SOUTH) {
            return "South";
        } else if (a == Direction.TO_WEST) {
            return "South";
        } else if (a == Direction.TO_EAST) {
            return "East";
        } else {
            return "Invalid Input";
        }

    }


    public Direction visit(Visitor visitor, Direction direction) {
        visitor.tell("You have entered from the" + directionFrom(direction));
        visitor.tell("You have entered a lobby with a nostalgic scent despite you having no memories of this location");

        //if the user doesn't remember the room he will get the option to try and recall
        if (!recalled) {
            visitor.tell("You cant piece the room together, the items seems blurred and you constantly feel like you are looking at this room for the first time");
            char lightChoice = visitor.getChoice("Would you like to focus on your surroundings?", options);
            if (lightChoice == 'y') {
                visitor.tell("You decide to take a moment to take in one object at a time, and with it you slowly build this room together with random objects from your childhood memories");
                recalled = true;
            } else {
                visitor.tell("You decide to just leave it at the back of your mind");
            }
        } else if (recalled) {
            visitor.tell("You recall this room and even recognise some of the items");
        }

        //if the user remembers the room, they will be able to see a picture that holds value to the person in the room which they can interact with
        if (recalled) {
            visitor.tell("The room hits you with wave of nostalgia, you begin remembering all your days running around this room when you were younger");
            visitor.tell("There is an opened toy box full of random toys each with their own story, like a toy figurine you got from seemingly nowhere that had more worth than any giant lego set");
            visitor.tell("The room is also decorated with all your childhood furniture like a spongebob blanket covered bed and a wardrobe full of your tiny little clothes and other toys");
            visitor.tell("Besides those something catches your eye, a picture frame laying face down on the desk, you don't recognise it initially but feel tempted by it ");
            char chestChoice = visitor.getChoice("Do you approach the picture? y/n", options);
            if (chestChoice == 'y') {
                visitor.tell("You decided to approach the picture frame");
                if (looted) {
                    visitor.tell("You walk up to the picture and notice that the picture that was meant to be held within has been ripped out");
                } else if (!looted) {
                    visitor.tell("You approach the picture frame and pick it up");
                    visitor.tell("You are confused, as you cant recognise the child in the picture nor the parents of the child in it.");
                    visitor.tell("You decide to take the picture and notice 5 gold pieces fell out from behind the picture");
                    visitor.giveGold(5);
                    visitor.giveItem(new Item("Childhood Memory"));
                    looted = true;
                } else {
                    visitor.tell("You feel that you are better of without knowing");
                }
            }
        } else {
            visitor.tell("You can hear random voices of children giggling in the darkness");
        }

        //The user will have the choice of forgetting the room
        if (recalled) {
            char lights_choice = visitor.getChoice("Do you want to forget this room? this might save you down the line y/n", options);
            if (lights_choice == ('y')) {
                recalled = false;
                ;
                visitor.tell("The room scrambles to its previous state of confusion");
            } else {
                visitor.tell("You find value in this room and decide to remember it");
            }
        }

        visitor.tell("Before you leave you hear a child cry out from behind you");
        visitor.tell("Leave us alone!");
        visitor.tell("Don't come back!");
        char newDirection = visitor.getChoice("Which way would you like to go? (N/S/W/E)", directions);
        Direction leaving = Direction.UNDEFINED;
        String directionPicked = "";
        if (newDirection == 'n') {
            directionPicked = "North";
            leaving = Direction.TO_NORTH;

        } else if (newDirection == 's') {
            directionPicked = "South";
            leaving = Direction.TO_SOUTH;

        } else if (newDirection == 'w') {
            directionPicked = "West";
            leaving = Direction.TO_WEST;

        } else if (newDirection == 'e') {
            directionPicked = "East";
            leaving = Direction.TO_EAST;
        }

        visitor.tell("You enter the " + directionTo(leaving) + " door.");

        return leaving;
    }
}
