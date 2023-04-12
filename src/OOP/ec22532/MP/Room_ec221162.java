package OOP.ec22532.MP;

public class Room_ec221162 extends Room {
    public Direction visit (Visitor v, Direction d){
        Direction currentDir = d;
        v.tell("You've entered Maxwell's room, it looks good...(Naturally). Want to chill?");
        char fChoice = v.getChoice("Chill? (y/n)", new char[]{'y', 'n'});
        if (fChoice == 'y'){
            v.tell("Bet, +5 gold");
            v.giveGold(5);
        }else{
            v.tell("Tough! (-3 gold) Go North");
            v.takeGold(3);
        }

        v.tell("I have some food");
        char foodChoice = v.getChoice("Pizza or Steak (p/s)", new char[]{'p', 's'});
        Item Pizza = new Item("Pizza");
        if (foodChoice == 'p') {
            v.tell("Very unhealthy bro, no dirty bulk!");
            v.takeGold(4);
            v.giveItem(new Item("Pizza"));

        } else if (foodChoice == 's') {
            v.tell("Good Choice");
            v.giveGold(5);
            v.giveItem(new Item("Steak"));
        } else {
            v.tell("Be gone");
            return Direction.opposite(currentDir);
        }

        if (v.hasEqualItem(new Item("Steak")) || v.hasIdenticalItem(Pizza)) {
            v.tell("twinnem, Go East");
            currentDir = Direction.TO_EAST;
        }
        return currentDir;
    }
    
}