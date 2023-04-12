package OOP.ec22532.MP;

class Room_ex21626 extends Room {

    private static final Item POTION = new Item("Potion");
    private static final int MAX_CHOICES = 8;
    private static final int MAX_GOLD_AMOUNT = 10;
    private static boolean looted = false;

    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {
        if (visitor == null) {
            throw new IllegalArgumentException("Visitor cannot be null");
        }

        if (looted) {
            visitor.tell("You have already looted this room and there's nothing left to take.");
            return null;
        }

        //give the user the choice of actions
        visitor.tell("This room has two chests, one silver and one gold. However, you can only open one of them.");
        char[] chestChoices = {'a', 'b', 'c'};
        char visitorChoice = visitor.getChoice("Which chest do you want to open? a) Silver chest b) Gold chest c) Leave", chestChoices);

        switch (visitorChoice) {
             case 'a':
                visitor.tell("You found a potion in the silver chest!");
                if (!visitor.hasIdenticalItem(POTION)) {
                    visitor.giveItem(POTION);
                } else {
                    visitor.tell("You already have a potion. Good for you!");
                }
                looted = true;
                break;

            case 'b':
                visitor.tell("You found a pile of gold coins in the gold chest!");
                int goldGiven = MAX_GOLD_AMOUNT;
                int goldTaken = visitor.takeGold(goldGiven);
                if (goldTaken == goldGiven) {
                    visitor.tell("You received " + goldGiven + " gold coins.");
                } else {
                    visitor.tell("You took " + goldTaken + " gold coins, as you can't carry any more.");
                }
                looted = true;
                break;

            case 'c':
                visitor.tell("You decided to leave the room.");
                break;

            default:
                visitor.tell("Invalid choice. You decided to leave the room.");
                break;
        }

        //give the user the coice of directions
        char[] directionChoices = {'a', 'b', 'c', 'd'};
        char leaving = visitor.getChoice("Which direction do you want to go? a) North b) East c) South d) West", directionChoices);

        switch (leaving) {
            case 'a':
                return Direction.TO_NORTH;

            case 'b':
                return Direction.TO_EAST;

            case 'c':
                return Direction.TO_SOUTH;

            case 'd':
                return Direction.TO_WEST;

            default:
                return null;
        }
    }
}
