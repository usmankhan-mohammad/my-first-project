package OOP.ec22532.MP;

class Room_ec22426 extends Room
{
    //variables to check what the user had done
    static String chestOpened = "closed";
    static String ghostGone = "here";

    //item in the room
    static final Item knife = new Item("Knife_ec22426");

    //when the visitor visits the room
    public Direction visit(Visitor roomVisitor, Direction directionEntered) {

        //creates room
        Room_ec22426 room = new Room_ec22426();

        //turns true when visitor wants to leave
        boolean leave = false;
        //repeats until user leaves
        while (!leave) {

            //There is nothing else to do in the room
            if (room.ghostGone.equals("gone")) {
                roomVisitor.tell("You are in an empty room with an open chest.");
                roomVisitor.tell("There is nothing for you to do. Please leave and enter another room.");
            }
            //If the user hasn't opened the chest they can chose to interact with the chest or ghost
            else if (room.chestOpened.equals("closed")) {
                roomVisitor.tell("You are in a room with a ghost and a closed chest.");
                roomVisitor.tell("Do you want to...");
                char[] option = {'a', 'b'};
                char choice = roomVisitor.getChoice("a) Open the chest b) Talk to the ghost", option);

                if (choice == 'a') {
                    openChest(roomVisitor, room);
                } else if (choice == 'b') {
                    talkToGhost(roomVisitor, room);
                }
            }
            //If the ghost is there but the chest is open
            else {
                roomVisitor.tell("You are in a with a ghost and an open chest.");
                roomVisitor.tell("Do you want to...");
                char[] option = {'a', 'b'};
                char choice = roomVisitor.getChoice("a)do nothing b) Talk to the ghost", option);
                if (choice == 'b'){
                    talkToGhost(roomVisitor, room);
                }
            }
            //asks the user if they want to leave
            roomVisitor.tell("Do you want to leave?");
            char[] option = {'a', 'b'};
            char choice = roomVisitor.getChoice("a) yes b) no", option);
            if (choice == 'a') {
                leave = true;
            }
        }
        //makes sure the user goes in the opposite direction of where they entered
        return Direction.opposite(directionEntered);
    }

    //the user interacts with the chest if it is closed
    void openChest (Visitor roomVisitor, Room_ec22426 room)
    {
        roomVisitor.tell("You walk towards the chest and open it.");
        roomVisitor.tell("Inside is a knife covered in blood.");

        //user finds a knife and checks they take it
        boolean accepted = roomVisitor.giveItem(knife);
        //the chest remains open if the user accepts a knife
        if (accepted == true) {
            roomVisitor.tell("You take the knife.");
            room.chestOpened = "opened";
        }
        //the user doesnt accept the knife and the chest closes
        else {
            roomVisitor.tell("You do not take the knife and closes the chest.");
        }
        return;
    }

    //the user interacts with the ghost
    void talkToGhost (Visitor roomVisitor, Room_ec22426 room)
    {
        roomVisitor.tell("You walk towards the ghost.");
        roomVisitor.tell("The ghost holds out a hand.");
        //checks if the user has the knife item
        if (roomVisitor.hasIdenticalItem(knife) == true) {
            giveGhost(roomVisitor, room);
        }
        //if not the ghost takes two gold
        else {
            roomVisitor.tell("The ghost shakes it's head and screams.");
            roomVisitor.tell("The ghost takes two pieces of gold from you.");
            roomVisitor.takeGold(2);
        }
        return;
    }

    //if the user does have the knife give it to the ghost then the ghost gives you 10 gold
    //the string value ghostGone is changed
    void giveGhost (Visitor roomVisitor, Room_ec22426 room)
    {
        roomVisitor.tell("You place the bloodstained knife in the ghosts hand.");
        roomVisitor.tell("The ghosts takes the knife and then gives you ten pieces of gold.");
        roomVisitor.giveGold(10);
        roomVisitor.tell("The ghost disappears from  the room.");
        room.ghostGone = "gone";
        return;
    }

}
