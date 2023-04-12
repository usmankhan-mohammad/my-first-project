package OOP.ec22532.MP;

import java.util.Random;

class Room_ec22508 extends Room {

    Item torch = new Item("Torch");
    Item magnet = new Item("Magnet");
    Item sweets = new Item("Sweets");

    boolean ghost = new Random().nextBoolean();
    boolean lights = new Random().nextBoolean();

    @Override
    public Direction visit(Visitor visitor, Direction direction){
        if ((visitor.hasIdenticalItem(torch) || visitor.hasEqualItem(torch)) || (visitor.hasIdenticalItem(magnet) || visitor.hasEqualItem(magnet))) {
            visitor.tell("You've already been here...");
            visitor.takeGold(5);
        }

        char answer = visitor.getChoice("Do you like sweets?", new char[]{'Y', 'N'});
        if (answer == 'Y' || answer == 'y') {
            visitor.giveItem(sweets);
            visitor.giveItem(sweets);
            visitor.giveItem(sweets);
        } else {
            visitor.tell("You take no sweets...");
        }


        ghost = new Random().nextBoolean();
        lights = new Random().nextBoolean();

        visitor.tell("You pick up some gold entering the room...");
        visitor.giveGold(5);

        if(!lights) {
            visitor.tell("The lights are off...");
            visitor.giveItem(torch);
            visitor.tell("You pick up a torch to light the way...");
        }

        if(ghost) {
            visitor.tell("A ghost spooked you...");
            if(visitor.hasEqualItem(sweets) || visitor.hasIdenticalItem(sweets)) {
                visitor.tell("You give the ghost a sweet!");
                visitor.tell("The ghost leaves you alone....");
            } else {
                visitor.tell("You run away!");
                visitor.tell("During your hasty exit, you picked up a magnet!");
                visitor.giveItem(magnet);
            }
        }
        return Direction.opposite(direction);
    }
}
