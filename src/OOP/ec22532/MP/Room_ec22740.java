package OOP.ec22532.MP;

import java.util.Random;

class Room_ec22740 extends Room {
    
    boolean lightOn = false;
    boolean chestOpenned = false;
    boolean keyTaken = false;
    boolean leave = false;
    final Item Key = new Item("Key_ec22740"); 
    
    public Direction visit(Visitor visitor, Direction directionFrom) {

        // ask the visitor if they want to turn on the light if the light is off
        if (lightOn == false) {
            visitor.tell("You have entered a dark room, there's a light switch on the wall next to you.");
            char[] lightChoices = {'Y', 'y', 'N', 'n'};
            char lightOnChoice = visitor.getChoice("Would you like to turn the light on? y/n", lightChoices);

            // set lightOn to true if visitor choose to
            if (lightOnChoice == 'Y' || lightOnChoice == 'y') {
                lightOn = true;
                visit(visitor, directionFrom);
            }
            // if not, can't find anything and leave the room
            else if (lightOnChoice == 'N' || lightOnChoice == 'n') {
                visitor.tell("You can't find anything in the darkness.");

                return Direction.opposite(directionFrom);
            } else {
                System.out.println("Invalid Input.");
            }
        }

        // if the light is already on
        else {
            // tell what is in the room
            visitor.tell("You look around the room.");
            visitor.tell("There's a book on a desk, a black cat on the window sill, and a wardrobe on the side of room.");
            while (!leave) {
                // ask the visitor to make a choice
                char[] choices = {'a', 'b', 'c', 'd'};
                char choice = visitor.getChoice("Would you like to: a. leave the room; b. check the book, c. open the wardrobe d. stroke the cat", choices);

                // leave the room
                if (choice == 'a') {
                    visitor.tell("You decide to leave the room.");
                    leave = true;
                    return Direction.opposite(directionFrom);
                }

                // given a key in the book
                else if (choice == 'b' && keyTaken == false) {
                    visitor.tell("You decide to look at the book. You found a key inside the book.");
                    keyTaken = true;
                    visitor.giveItem(Key);
                } else if (choice == 'b' && keyTaken == true) {
                    visitor.tell("The item has been taken. ");
                }

                // found a chest in the wardrobe
                else if (choice == 'c') {
                    visitor.tell("You open the wardrobe and found a chest.");

                    // can't open the chest without a key if it's openned
                    if (chestOpenned == false && (visitor.hasIdenticalItem(Key)) == false) {
                        visitor.tell("The chest is locked and you don't have a key.");
                    }

                    // open the chest and get gold if has the key and the chest is not openned
                    else if (chestOpenned == false && visitor.hasIdenticalItem(Key)) {
                        visitor.tell("There are some gold inside the chest.");
                        int goldGiven = (new Random()).nextInt(10);
                        visitor.giveGold(goldGiven);
                        chestOpenned = true;
                    }
                    // nothing inside if the chest is already opened
                    else if (chestOpenned == true) {
                        visitor.tell("The chest is already opened, all gold have been taken.");
                    }
                }
                // gold being snatched by the cat
                else if (choice == 'd') {
                    visitor.tell("You try to stroke the cat, but the cat snatched some gold from you and run away.");
                    int goldTaken = (new Random()).nextInt(10);
                    visitor.takeGold(goldTaken);
                }
            }
        }
        System.out.println(directionFrom);
        // give the direction to leave
        return Direction.opposite(directionFrom);
    }
} 
