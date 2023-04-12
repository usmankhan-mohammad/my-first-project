package OOP.ec22532.MP;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Room_ec22419 extends Room {
    private boolean isDark = false;
    private Item key = new Item("Key");
    private Item gem = new Item("Gem");
    // private Item map = new Item("Map");
    private List<Item> items = new ArrayList<>();

    private int goldPieces;
    private boolean hasSecret = false;
    private boolean isDoorLocked = false;

    public Direction visit(Visitor visitor, Direction direction) {

        visitor.tell("Welcome to Room_ec22419! \n" + directionString(direction) + "\nWe hope you enjoy your stay!");
        while (!(items.contains(gem) & items.contains(key))) {
            visitor.tell("You can only leave this room once you have collected everything!! :-) ");
            char choice1 = visitor.getChoice("Please pick a choice....(choose smartly (-: ))", new char[] { 'A', 'B' });
            char choice2;
            if (choice1 == 'A') {
                callRandomMethods(visitor);
            } else if (choice1 == 'B') {
                callRandomMethods(visitor);
            }

            items = nextChoice(visitor);
            if (items.size() > 0) {
                visitor.giveGold(2);
            } else {
                visitor.takeGold(5);
            }
        }
        // displayItems(visitor, items);
        displayItemCount(visitor, countItems(items));
        visitor.tell("Thats everything! GOODBYE!!");
        return Direction.opposite(direction);
    }

    public String directionString(Direction direction) {
        String message = "";
        if (direction == Direction.FROM_NORTH) {
            message = "You entered the room from the North Side";
        } else if (direction == Direction.FROM_EAST) {
            message = "You entered the room from the East Side";
        } else if (direction == Direction.FROM_SOUTH) {
            message = "You entered the room from the South Side";
        } else if (direction == Direction.FROM_WEST) {
            message = "You entered the room from the West Side";
        }
        return message;
    }

    public char choiceA(Visitor visitor) {

        visitor.tell(
                "Well that was a bold move...you just told the friendly ghost that he's scary & now he doesn't like you )-: ");
        visitor.takeGold(2);
        char choice2 = visitor.getChoice("Would you like....", new char[] { 'A', 'B' });
        return choice2;

    }

    public int choiceB(Visitor visitor) {

        visitor.tell(
                "Smart move you made there...The friendly ghost has now presented you with a chest of gold coins. Take as many as you would like. ");
        char choice2 = visitor.getChoice("The choice you make will determine the coins you get.",
                new char[] { 'A', 'B' });
        if (choice2 == 'A') {

            visitor.giveGold(10);
            goldPieces = 10;
            visitor.tell("AWESOME! You got 10 coins!");
        } else if (choice2 == 'B') {
            visitor.giveGold(0);
            goldPieces = 0;
            visitor.tell("UNLUCKY! You got nothing!");
        }
        return goldPieces;

    }

    public List<Item> nextChoice(Visitor visitor) {
        char choice = visitor.getChoice("Let's make this more interesting...wanna explore further into the room?",
                new char[] { 'Y', 'N' });

        if (choice == 'Y') {
            char choice2 = visitor.getChoice("You spot an shiny item! Wanna pick it up? ;)", new char[] { 'Y', 'N' });
            if (choice2 == 'Y') {

                Item itemSelected = getRandomItem();

                boolean answer = visitor.giveItem(itemSelected);
                if (answer) {
                    items.add(itemSelected);
                } else {
                    visitor.hasEqualItem(itemSelected);
                }
                // items.add(gem);
            } else if (choice2 == 'N') {
                visitor.tell("Me & Friendly Ghost think You're BORING!");

            }
        }
        return items;
    }

    public List<Item> displayItems(Visitor visitor, List<Item> items) {
        visitor.tell("You possess: ");
        for (Item item : items) {
            visitor.tell(item.name);
        }
        return items;
    }

    public int amountOfGoldPieces(int goldPieces, int amount) {
        return (goldPieces - amount);
    }

    public Item getRandomItem() {
        Item[] items = new Item[2];
        items[0] = gem;
        // items[1] = map;
        items[1] = key;

        Random random = new Random();
        int index = random.nextInt(items.length);
        return items[index];
    }

    public void callRandomMethods(Visitor visitor) {
        Random random = new Random();
        int method1 = random.nextInt(2);
        switch (method1) {
            case 0:
                choiceA(visitor);
                break;
            case 1:
                choiceB(visitor);
                break;
        }

    }

    public Hashtable<Item, Integer> countItems(List<Item> items2) {
        Hashtable<Item, Integer> itemTable = new Hashtable<Item, Integer>();
        for (Item item : items2) {
            if (itemTable.containsKey(item)) {
                int count = itemTable.get(item);
                itemTable.put(item, count + 1);
            } else {
                itemTable.put(item, 1);
            }
        }
        return itemTable;
    }

    public static void displayItemCount(Visitor visitor, Hashtable<Item, Integer> itemCount) {
        visitor.tell("Item Count:");
        for (Item item : itemCount.keySet()) {
            int count = itemCount.get(item);
            visitor.tell(item.name + ": " + count);
        }
    }

}
