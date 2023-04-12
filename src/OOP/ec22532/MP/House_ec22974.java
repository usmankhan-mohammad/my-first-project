package OOP.ec22532.MP;

import java.util.Scanner;

class House_ec22974 extends House {
    Room r0;
    Room r1;
    Room r2;
    Room r3;
    Room current;

    // Constructor
    House_ec22974() {
        // My room
        r0 = new Room_ec22974();
        // Rooms chosen from A5 contributors
        r1 = new Room_ec22662();
        r2 = new Room_ec22446();
        r3 = new Room_ec22439();
    }

    // visit method
    public Direction visit(Visitor v, Direction d) {
        int gold = 0;
        char[] directions = { 'N', 'E', 'S', 'W' };
        boolean running = true;

        start(v);

        // User starts from my room
        v.tell("You are currently in room 0, find your way out the house!");
        d = r0.visit(v, d);
        current = r0;

        while (running) {
            v.tell("Which direction do you wish to go?");
            char choice = getChoice("N, S, E or W?", directions);
            
            if (choice == 'N') {
                if (current == r0) {
                    current = r1;
                    d = current.visit(v, d);
                }
                else if (current == r2) {
                    current = r3;
                    d = current.visit(v, d);
                }
                else {
                    v.tell("You cannot go this way!");
                }
            }
            else if (choice == 'E') {
                if (current == r2) {
                    current = r1;
                    d = current.visit(v, d);
                }
                else if (current == r3) {
                    v.tell("You found the exit!");
                    v.tell("Well Done!");
                    v.giveGold(5);
                    running = false;
                }
                else {
                    v.tell("You cannot go this way!");
                }    
            }
            else if (choice == 'S') {
                if (current == r1) {
                    current = r0;
                    d = current.visit(v, d);
                }
                else if (current == r3) {
                    current = r2;
                    d = current.visit(v, d);
                }
                else {
                    v.tell("You cannot go this way!");
                }
            }
            else {
                if (current == r1) {
                    current = r2;
                    d = current.visit(v, d);
                }
                else {
                    v.tell("You cannot go this way!");
                }
            }
        } 
        return d;
    }

    // Start message
    void start(Visitor v) {
        v.tell("Welcome to the House of Mystery!");
        v.tell("Find your way through the rooms to escape.");
        v.tell("\nHere is the HOUSE LAYOUT:");
        v.tell("----------------");
        v.tell("| Room ec22439 |");
        v.tell("----------------");
        v.tell("----------------  ----------------");
        v.tell("| Room ec22439 |  | Room ec22446  |");
        v.tell("----------------  ----------------");
        v.tell("                  ----------------");
        v.tell("                  | Room ec22446  |");
        v.tell("                  ----------------");
        v.tell("However, the exit from the house, is for YOU to find! :)\n");

        return;
    }

    // Get the user's choice
    char getChoice(String choice, char[] options) {
        String selection = inputString("Choose an option: ");
        selection = selection.toUpperCase();
        char selected = selection.charAt(0);

        boolean valid = validate(selected, options);

        while (!valid) {
            selection = inputString("Invalid choice! Try again: ");
            selection = selection.toUpperCase();
            selected = selection.charAt(0);
            valid = validate(selected, options);
        }
        return selected;
    }

    // Check if a choice is valid
    boolean validate(char choice, char[] options) {
        boolean valid = false;
        for (char x : options) {
            if (x == choice) {
                valid = true;
            }
        }
        return valid;
    }

    // Takes input from users
    String inputString(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.println(s);
        String ans = sc.nextLine();
        return ans;
    }

    // only used for testing purposes
    public static void main (String[] a){
		Visitor v = new IOVisitor(System.out, System.in);
		Direction d = Direction.FROM_SOUTH;
		House h = new House_ec22974();
		h.visit(v,d);
		return;
	}
}
