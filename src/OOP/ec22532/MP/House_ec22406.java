package OOP.ec22532.MP;

// Define a class called House_ec22406 that extends the House class
class House_ec22406 extends House {
    // Define three rooms as Room objects
    Room r1;
    Room r2;
    Room r3;

    // Define two static final Item objects
    final static Item RemoteHackingDevice = new Item("Remote Hacking Device");
    final static Item dessert = new Item("Carrot Cake");

    // Constructor for House_ec22406 class that initializes the three Room objects
    House_ec22406() {
        r1 = new Room_ec22406();
        r2 = new Room_ec22468();
        r3 = new Room_ec22764();
    }

    // Override the visit method of House class
    public Direction visit(Visitor v, Direction d) {
        // Greet the visitor with some message
        v.tell("So, you've arrived at my humble abode, then.");
        v.tell("In truth, that's just my humility speaking. This place is far from humble.");
        v.tell("You'll know what I mean soon enough. No need to spoil the surprise.");
        v.tell("In any case, you should equip yourself with these. They'll come in handy.");

        // Give the visitor a static Item object and some gold
        v.giveItem(RemoteHackingDevice);
        v.giveGold(5);

        // Give some instructions to the visitor about each room
        v.tell("In the first room to the west, you will find my room: the batcave. There, you can purchase a variety of technical gadgets. The world is yours.");
        v.tell("Then, to the north we have another person's room. Be warned, you may be met with the empty promise of a cake. Say hello to GLaDOS from me.");
        v.tell("Finally, to the east is yet again someone else's room. It's undeniably pretty mysterious in there. ");

        // Initialize a character variable and use it to control the flow of the visit
        char choice = 'X';
        while (choice != 'S') {
            // Ask the visitor for their choice and give them a list of available options
            choice = v.getChoice("Well then, what will it be, citizen? the room to the west(W), the room to the east(E) or that of the North? (N). Or, you know, you could always leave the house. Just head south(S).", new char[]{'W','E','N','S'});

            // Use a switch statement to perform actions based on the visitor's choice
            switch (choice) {
                case 'W':
                    r1.visit(v, Direction.FROM_EAST);
                    break;
                case 'E':
                    r3.visit(v, Direction.FROM_WEST);
                    break;
                case 'N':
                    r2.visit(v, Direction.FROM_SOUTH);
                    break;
                case 'S':
                    v.tell("Perhaps that's for the better. Be seeing you, citizen.");
                    break;
                case '?':
                    // If the visitor enters '?', give them some gold and a static Item object
                    v.tell("What in tarnation? How did you gain access to here? Well, I suppose I should reward you. Take it. It's carrot cake.");
                    v.giveGold(5);
                    v.giveItem(dessert);
                    break;
                default:
                    // If the visitor enters any other character, take some of their gold and remind them to make a choice
                    v.tell("Come on! What will it be?! I haven't got all day, you know.");
                    v.takeGold(1);
            }
            v.tell("");
        }

        // Send a farewell message to the visitor and return the Direction object
        v.tell("Here's hoping our paths cross once again, adventurer.");
        return Direction.TO_SOUTH;
    }

    // This section of code is for testing purposes
    public static void main (String[] a) {
        // Create an IOVisitor object
        Visitor v = new IOVisitor(System.out, System.in);

        // Set the direction and create a House_ec22406 object
        Direction d = Direction.FROM_SOUTH;
        House h = new House_ec22406();

        // Call the visit method of House_ec22406 object
        h.visit(v,d);
        return;
    }
}
