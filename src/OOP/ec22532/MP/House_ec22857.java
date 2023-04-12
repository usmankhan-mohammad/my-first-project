package OOP.ec22532.MP;

class House_ec22857 extends House {

    Room[] rooms = {new Room_ec22468(), new Room_ec22476(), new Room_ec221218(), new Room_ec22995()};
    private final Item Sword = new Item("Sword");
    private final Item Meat = new Item("Meat");
    private final Item Shield = new Item("Shield");
    private final Item Jacket = new Item("Jacket");

    public Direction visit(Visitor visitor, Direction d) {

        visitor.tell("Welcome, Challenger. You have entered a haunted house.");
        visitor.tell("Eerie whispers and distant footsteps surround you. An unsettling feeling embraces you.");

        boolean move = true;
        char[] yesNo = {'y', 'n'};
        char[] options = {'a', 'b', 'c', 'd'};

        while (move) {

            visitor.tell("Now choose where you want to go..");
            char place = visitor.getChoice("Go to (a) the first room (b) the second room (c) the third room (d) the secret room", options);

            if (place == 'a') {
                visitor.tell("You find yourself in the first room. A chill runs down your spine. Cobwebs cover every corner of the room. Proceed? (y/n)");
                char decision = visitor.getChoice("", yesNo);

                if (decision == 'y') {
                    visitor.tell("Brace yourself; the air grows colder.");
                    rooms[0].visit(visitor, d);
                    visitor.tell("As you leave the room, you find a sword near the door.");
                    visitor.giveItem(Sword);
                } else {
                    visitor.tell("That's a shame. Maybe next time you visit.");
                }
            } else if (place == 'b') {
                visitor.tell("You proceed to the second room, where you feel a sudden cold breeze.");
                visitor.tell("A ghostly figure appears before you, warning you to leave this place. Proceed? (y/n)");
                char decision = visitor.getChoice("", yesNo);

                if (decision == 'y') {
                    visitor.tell("Brace yourself; the ghostly figure watches you.");
                    rooms[1].visit(visitor, d);
                    visitor.tell("The ghostly figure vanishes, leaving behind a warm jacket.");
                    visitor.giveItem(Jacket);
                } else {
                    visitor.tell("That's a shame. Maybe next time you visit.");
                }
            } else if (place == 'c') {
                visitor.tell("You proceed to the third room, where you see a flickering candle on a dusty table.");
                visitor.tell("An old, wooden chest sits ominously in the corner. Do you dare proceed? (y/n)");
                char decision = visitor.getChoice("", yesNo);

                if (decision == 'y') {
                    visitor.tell("Brace yourself; the room's darkness grows deeper.");
                    rooms[2].visit(visitor, d);
                    visitor.tell("You find a piece of meat on a plate. You're not sure if it's safe to eat, but you take it anyway.");
                    visitor.giveItem(Meat);
                } else {
                    visitor.tell("That's a shame. Maybe next time you visit.");
                }
            } else {
                visitor.tell("You discover a hidden door that leads to a secret room.");
                visitor.tell("The room is filled with old books, strange artifacts, and a mysterious aura. Do you dare proceed? (y/n)");
                char decision = visitor.getChoice("", yesNo);

                if (decision == 'y') {
                    visitor.tell("Brace yourself; the air is thick with ancient secrets.");

                    rooms[3].visit(visitor, d);
                    visitor.tell("You notice a shield resting against a bookshelf. You pick it up and feel a sense of protection.");
                    visitor.giveItem(Shield);
                } else {
                    visitor.tell("That's a shame. Maybe next time you visit.");
                }
            }
            visitor.tell("You're back! I hope you had a thrilling visit.");
            char decision = visitor.getChoice("Would you like to continue exploring the house? (y/n)", yesNo);

            if (decision == 'n') {
                move = false;
            }
        }

        visitor.tell("Exhausted and frightened, you decide to leave the haunted house, carrying your newfound items. Farewell!");
        return d;
    }
}
