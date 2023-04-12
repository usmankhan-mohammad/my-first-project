package OOP.ec22532.MP;

// Define a Room class that extends the Room class
class Room_ec22406 extends Room {

    // Define the available items to purchase
    Item batarang = new Item("Batarang");
    Item grappleGun = new Item("Grapple Gun");
    Item smokeBomb = new Item("Smoke Bomb");
    Item batmobile = new Item("Batmobile");
    Item utilityBelt = new Item("Utility Belt");

    // Override the visit() method from the parent Room class
    public Direction visit(Visitor visitor, Direction direction) {

        // Define an array of options for the visitor's choice
        char[] options = {'a', 'b', 'c', 'd', 'e', 'f'};

        // Greet the visitor and provide information about the Batcave
        visitor.tell("'Welcome to the Batcave, the home of the Dark Knight!'");
        visitor.tell("Undoubtedly, Batman has some of the most advanced tech in the world.");
        visitor.tell("'So, how may I assist you, citizen?'");

        // Provide context based on which direction the visitor is coming from
        if (direction == Direction.FROM_NORTH) {
            visitor.tell("You came from The Narrows, it seems...");
        } else if (direction == Direction.FROM_EAST) {
            visitor.tell("You came from Metropolis, it seems...");
        } else if (direction == Direction.FROM_SOUTH) {
            visitor.tell("You came from Miagani, it seems...");
        } else if (direction == Direction.FROM_WEST) {
            visitor.tell("You came from Founders' Island, it seems...");
        }

        // Display the available items for purchase
        String message = "Would you like to acquire one of Batman's tools?\n"
                + "a) Batarang (5 WayneTech points), \n"
                + "b) Grapple Gun (4 WayneTech points), \n"
                + "c) Smoke Bomb (3 WayneTech points), \n"
                + "d) Batmobile (5 WayneTech points), \n"
                + "e) Utility Belt (1 WayneTech point), \n"
                + "f) Leave without any gadget.";

        // Get the visitor's choice
        char choice = visitor.getChoice(message, options);

        // Take the visitor's currency and give them the item they purchased
        switch (choice) {
            case 'a':
                visitor.tell("The Batarang, one of the most iconic weapons of the Dark Knight. You cannot go wrong with it.");
                visitor.takeGold(5);
                visitor.giveItem(batarang);
                break;

            case 'b':
                visitor.tell("The Grapple Gun, one of Batman's most versatile gadgets. Ideal for on-foot mobility.");
                visitor.takeGold(4);
                visitor.giveItem(grappleGun);
                break;

            case 'c':
                visitor.tell("The Smoke Bomb, used to create distractions and cover escapes. Perfect for theatrics and deception.");
                visitor.takeGold(3);
                visitor.giveItem(smokeBomb);
                break;

            case 'd':
                visitor.tell("The Batmobile, one of the most advanced vehicles in the world. Good thinking.");
                visitor.takeGold(5);
                visitor.giveItem(batmobile);
                break;

            case 'e':
                visitor.tell("The Utility Belt, a key part of Batman's equipment. It contains various useful gadgets.");
                visitor.takeGold(1);
                visitor.giveItem(utilityBelt);
                break;

            case 'f':
                visitor.tell("Understood, citizen. If you need anything in the future, don't hesitate to return.");
                break;

            default:
                visitor.tell("I do not understand. I'm afraid you must leave.");
        }

        // Send the visitor off with a farewell message
        visitor.tell("Stay safe out there, citizen. Gotham is a dangerous city.");

        // Return the opposite direction to where the visitor came from
        return direction.opposite(direction);
    }
}
