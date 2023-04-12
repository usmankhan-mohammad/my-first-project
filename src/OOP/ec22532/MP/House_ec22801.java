package OOP.ec22532.MP;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class House_ec22801 extends House {

    // Creating objects
    Room myRoom = new Room_ec22801();

    public int gold = 0;
    List<Item> myItemList = new ArrayList<Item>();
    Room friendRoom1 = new Room_ec22795();
    Room friendRoom2 = new Room_ec22804();
    Room friendRoom3 = new Room_ec22814();
    Room hallway = new Room_ec19389();
    Room window = new Room_ec21403();
    Room kitchen = new Room_ec21494();
    Room garden = new Room_ec21499();
    Room livingRoom = new Room_ec21645();
    Room bathroom = new Room_ec22418();
    private Direction FROM_SOUTH = Direction.FROM_SOUTH;
    private Direction FROM_EAST = Direction.FROM_EAST;
    private Direction FROM_WEST = Direction.FROM_WEST;
    private Direction FROM_NORTH = Direction.FROM_NORTH;
    private Direction TO_SOUTH = Direction.TO_SOUTH;
    private Direction TO_NORTH = Direction.TO_NORTH;
    private Direction TO_WEST = Direction.TO_WEST;
    private Direction TO_EAST = Direction.TO_EAST;
    public char getChoice(String descriptionOfChoices, char[] arrayOfPossibleChoices) {
        System.out.println(descriptionOfChoices);
        //System.out.println("OLD VERSION EXECUTED");
        char choice = ' ';
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNext()) {
                choice = sc.next().charAt(0);
                for (char c : arrayOfPossibleChoices) {
                    if (c == choice) {
                        // sc.close();
                        return choice;
                    }
                }
            } else {
                System.out.println("No such choice!");
            }
        }
    }

    public int getNumberOfGold() {
        return gold;
    }
    public boolean hasIdenticalItem(Item itemToCheckFor) {
        for (Item i : myItemList) {
            if (i == itemToCheckFor) {
                return true;
            }
        }
        return false;
    }

    public boolean hasEqualItem(Item itemToCheckFor) {
        for (Item i : myItemList) {
            if (i.equals(itemToCheckFor)) {
                return true;
            }
        }
        return false;
    }
    public void checkingPrize(Visitor v) {
        System.out.println("Another prize is coming! Let's see if you accepting it.");
        String[] prize = { "A book", "A pen", "A pencil", "A cup", "A bottle", "A key", "A phone", "A watch", "A bag",
                "A wallet" };
        int random = new Random().nextInt(10);
        Item newPrize = new Item(prize[random]);
        System.out.println("You get " + newPrize.name + ".");
        char chars2[] = { '1', '2' };
        char choice2 = v.getChoice("Do you want to accept it?\n1. Yes\n2. No", chars2);
        switch (choice2) {
            case '1':
                if (hasEqualItem(newPrize)) {
                    System.out.println("You already have " + newPrize.name + ".");
                    break;
                } else if (hasIdenticalItem(newPrize)) {
                    System.out.println("You already have " + newPrize.name + ".");
                    break;
                } else {
                    v.giveItem(newPrize);
                    break;
                }
            case '2':
                System.out.println("You don't accept it.");
                break;

            default:
                System.out.println("No such choice!");
                break;
        }
    }

    public Room windowOption(Room currentRoom, Visitor v) {
        char[] choices = { '1', '2', '3' };
        char choice = v.getChoice("What do you want to do?\n1. Open the window\n2. Close the window\n3. Jump to garden",
                choices);
        if (choice == '1') {
            System.out.println("You opened the window!");
            checkingPrize(v);
            return currentRoom;
        } else if (choice == '2') {
            System.out.println("You closed the window!");
            return currentRoom;
        } else if (choice == '3') {
            System.out.println("You jumped to garden!");
            return garden;
        } else {
            return null;
        }
    }

    public Room kitchenOption(Room currentRoom, Visitor v) {
        char[] choices = { '1', '2', '3' };
        char choice = v.getChoice(
                "What do you want to do?\n1. Open the fridge\n2. Close the fridge\n3. Go to the hallway", choices);
        if (choice == '1') {
            System.out.println("You opened the fridge!");
            checkingPrize(v);
            return currentRoom;
        } else if (choice == '2') {
            System.out.println("You closed the fridge!");
            return currentRoom;
        } else if (choice == '3') {
            System.out.println("You went to the hallway!");
            return hallway;
        } else {
            return null;
        }
    }

    public Room gardenOption(Room curreRoom, Visitor v) {
        char[] choices = { '1', '2', '3' };
        char choice = v.getChoice("What do you want to do?\n1. Open the gate\n2. Close the gate\n3. Go to the Kitchen",
                choices);
        if (choice == '1') {
            System.out.println("You opened the gate!");
            checkingPrize(v);
            return curreRoom;
        } else if (choice == '2') {
            System.out.println("You closed the gate!");
            return curreRoom;
        } else if (choice == '3') {
            System.out.println("You went to the kitchen!");
            return kitchen;
        } else {
            return null;
        }
    }

    public Room livingroomOption(Room currentRoom, Visitor v) {
        char[] choices = { '1', '2', '3' };
        char choice = v.getChoice("What do you want to do?\n1. Open the door\n2. Close the door\n3. Go to the hallway",
                choices);
        if (choice == '1') {
            System.out.println("You opened the door!");
            checkingPrize(v);
            return currentRoom;
        } else if (choice == '2') {
            System.out.println("You closed the door!");
            return currentRoom;
        } else if (choice == '3') {
            System.out.println("You went to the hallway!");
            return hallway;
        } else {
            return null;
        }
    }

    public Room bathroomOption(Room currentRoom, Room previous, Visitor v) {
        char[] choices = { '1', '2', '3' };
        char choice = v.getChoice("What do you want to do?\n1. Open the door\n2. Close the door\n3. Go back", choices);
        if (choice == '1') {
            System.out.println("You opened the door!");
            return currentRoom;
        } else if (choice == '2') {
            System.out.println("You closed the door!");
            return currentRoom;
        } else if (choice == '3') {
            System.out.println("You went to the hallway!");
            return previous;
        } else {
            return null;
        }
    }

    public Direction convertDirection(Direction d) {
        if (d == TO_EAST) {
            d = FROM_EAST;
        } else if (d == TO_NORTH) {
            d = FROM_NORTH;
        } else if (d == TO_SOUTH) {
            d = FROM_SOUTH;
        } else if (d == TO_WEST) {
            d = FROM_WEST;
        }
        return d;
    }

    public Room getRoom(Direction d, Room currentRoom) {
        System.out.println(d);
        System.out.println(currentRoom);
        if (currentRoom == hallway) {
            if (d == FROM_SOUTH) {
                return myRoom;
            } else if (d == FROM_EAST) {
                return friendRoom1;
            } else if (d == FROM_WEST) {
                return friendRoom2;
            } else if (d == FROM_NORTH) {
                return friendRoom3;
            } else {
                return null;
            }
        } else if (currentRoom == myRoom) {
            if (d == FROM_NORTH) {
                System.out.println("Back to the hallway!");
                return hallway;
            } else if (d == FROM_EAST) {
                System.out.println("You are at the window!");
                return window;
            } else if (d == FROM_WEST) {
                System.out.println("Go for a bath?");
                return bathroom;
            } else if (d == FROM_SOUTH) {
                System.out.println("Just a wall!");
                return myRoom;
            } else {
                return null;
            }
        } else if (currentRoom == friendRoom1) {
            if (d == FROM_SOUTH) {
                System.out.println("Need some food? Here's the kitchen!");
                return kitchen;
            } else if (d == FROM_NORTH) {
                System.out.println("Fancy some movie? Living room is right here!");
                return livingRoom;
            } else if (d == FROM_WEST) {
                System.out.println("Back to the hallway!");
                return hallway;
            } else if (d == FROM_EAST) {
                System.out.println("Just a boring wall!");
                return friendRoom1;
            } else {
                return null;
            }
        } else if (currentRoom == friendRoom2) {
            if (d == FROM_SOUTH) {
                System.out.println("Go to the bathroom?");
                return bathroom;
            } else if (d == FROM_EAST) {
                System.out.println("Back to the hallway!");
                return hallway;
            } else if (d == FROM_WEST) {
                System.out.println("You are in the garden!");
                return garden;
            } else if (d == FROM_NORTH) {
                System.out.println("Just a wall!");
                return friendRoom2;
            } else {
                return null;
            }
        } else if (currentRoom == friendRoom3) {
            if (d == FROM_NORTH) {
                System.out.println("Just a wall!");
                return friendRoom3;
            } else if (d == FROM_EAST) {
                System.out.println("Go to living room?");
                return livingRoom;
            } else if (d == FROM_WEST) {
                System.out.println("Go to the garden?");
                return garden;
            } else if (d == FROM_SOUTH) {
                System.out.println("Back to the hallway!");
                return hallway;
            } else {
                return null;
            }
        } else if (currentRoom == window) {
            System.out.println("You cannot go anywhere, enjoy the view!");
            return myRoom;
        } else if (currentRoom == kitchen) {
            if (d == FROM_EAST) {
                System.out.println("Just a wall!");
                return kitchen;
            } else if (d == FROM_SOUTH) {
                System.out.println("Go to my room?");
                return livingRoom;
            } else if (d == FROM_WEST) {
                System.out.println("Go to the hallway?");
                return garden;
            } else if (d == FROM_NORTH) {
                System.out.println("Back to the friend's room!");
                return friendRoom1;
            } else {
                return null;
            }
        } else if (currentRoom == garden) {
            if (d == FROM_WEST) {
                System.out.println("Back to the friend's room!");
                return friendRoom2;
            } else {
                System.out.println("Playing here!");
                return garden;
            }
        } else if (currentRoom == livingRoom) {
            if (d == FROM_NORTH || d == FROM_EAST) {
                System.out.println("Just a wall!");
                return bathroom;
            } else if (d == FROM_SOUTH || d == FROM_WEST) {
                System.out.println("Back to the friend's room!");
                return friendRoom1;
            } else {
                return null;
            }
        } else if (currentRoom == bathroom) {
            if (d == FROM_SOUTH) {
                System.out.println("Just a wall!");
                return bathroom;
            } else if (d == FROM_NORTH || d == FROM_SOUTH) {
                System.out.println("Back to the bedroom!");
                return myRoom;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    public Room visitRoom(Room currentRoom, Visitor v, Direction d, Room previous) {
        if (currentRoom == myRoom || currentRoom == friendRoom1 || currentRoom == friendRoom2
                || currentRoom == friendRoom3) {
            System.out.println("Visiting " + currentRoom.toString());
            d = convertDirection(currentRoom.visit(v, d));
            gold = gold + 5;
            if (gold < 0) {
                gold = 0;
            }
            System.out.println(d.toString());
            currentRoom = getRoom(d, currentRoom);
        } else if (currentRoom == window) {
            System.out.println("Window!");
            currentRoom = windowOption(currentRoom, v);
        } else if (currentRoom == hallway) {
            System.out.println("Visiting hallway!");
            d = convertDirection(currentRoom.visit(v, d));
            currentRoom = hallway;//getRoom(d, currentRoom);
        } else if (currentRoom == kitchen) {
            System.out.println("Visiting kitchen!");
            currentRoom = kitchenOption(currentRoom, v);
        } else if (currentRoom == garden) {
            System.out.println("Visiting garden!");
            currentRoom = gardenOption(currentRoom, v);
        } else if (currentRoom == livingRoom) {
            System.out.println("Visiting livingroom!");
            currentRoom = livingroomOption(currentRoom, v);
        } else if (currentRoom == bathroom) {
            System.out.println("Visiting bathroom!");
            currentRoom = bathroomOption(currentRoom, previous, v);
        } else {
            System.out.println("You can't go there!");
        }
        return currentRoom;
    }
    public Direction visit(Visitor v, Direction d) {
        Room previous;
        Room currentRoom = hallway;
        boolean isNext = true;
        while (isNext) {
            char[] choices = { '1', '2', '3', '4', '5' };
            //v.tell("Where do you want to go?\n1. Go to the North\n2. Go to the East\n3. Go to the West\n4. Go to the South\n5. Exit");
            char choice = v.getChoice(
                    "Where do you want to go?\n1. Go to the North\n2. Go to the East\n3. Go to the West\n4. Go to the South\n5. Exit",
                    choices);
            switch (choice) {
                case '1':
                    d = FROM_NORTH;
                    previous = currentRoom;
                    currentRoom = getRoom(d, currentRoom);
                    currentRoom = visitRoom(currentRoom, v, d, previous);
                    System.out.println("Current gold you have: "+ gold);
                    System.out.println("Current gold you have: "+ gold);
                    System.out.println("Current gold you have: "+ gold);
                    break;
                case '2':
                    d = FROM_EAST;
                    previous = currentRoom;
                    currentRoom = getRoom(d, currentRoom);
                    currentRoom = visitRoom(currentRoom, v, d, previous);
                    System.out.println("Current gold you have: "+ gold);
                    System.out.println("Current gold you have: "+ gold);
                    System.out.println("Current gold you have: "+ gold);
                    break;
                case '3':
                    d = FROM_WEST;
                    previous = currentRoom;
                    currentRoom = getRoom(d, currentRoom);
                    currentRoom = visitRoom(currentRoom, v, d, previous);
                    System.out.println("Current gold you have: "+ gold);
                    System.out.println("Current gold you have: "+ gold);
                    System.out.println("Current gold you have: "+ gold);
                    break;
                case '4':
                    d = FROM_SOUTH;
                    previous = currentRoom;
                    currentRoom = getRoom(d, currentRoom);
                    currentRoom = visitRoom(currentRoom, v, d, previous);
                    System.out.println("Current gold you have: "+ gold);
                    System.out.println("Current gold you have: "+ gold);
                    System.out.println("Current gold you have: "+ gold);
                    break;
                case '5':
                    System.out.println("Bye!");
                    isNext = false;
                    break;
            }
        }
        return d;
    }
    public static void main(String[] args) {
        House h = new House_ec22801();
        Visitor viet = new IOVisitor(System.out, System.in);
        Direction d = Direction.FROM_EAST;
        h.visit(viet, d);
    }

}