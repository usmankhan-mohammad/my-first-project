package OOP.ec22532.MP;

import java.util.Scanner;

class House_ec22501 extends House {
    private Scanner scanner;

    public House_ec22501() {
        scanner = new Scanner(System.in);
    }

    // This method is to get string inputs from the user
    public String inputString(String message) {
        String choice;

        System.out.println(message);
        choice = scanner.nextLine();

        return choice;
    }

    public Direction visit(Visitor adventurer, Direction directionFrom) {
        Boolean inHouse = true;
        
        Room_ec22501 roomA = new Room_ec22501();
        Room_ec22433 roomB = new Room_ec22433();
        Room_ec22573 roomC = new Room_ec22573();

        Direction newDirection;

        System.out.println("Hello welcome to my mansion!");
        System.out.println("Explore as you please, what would you like to do?");
        String userChoice = inputString("(A) Enter Room A  (B) Enter Room B  (C) Enter Room C  (D)Exit");
        
        while (inHouse=true) {
            
            while (!userChoice.equals("D")) {
                if (userChoice.equals("A")) {
                    newDirection = roomA.visit(adventurer, directionFrom);
                    adventurer.tell("That room is off limits! STOP! STOP!");
                } 
                if (userChoice.equals("B")) {
                    newDirection = roomB.visit(adventurer, directionFrom);
                    adventurer.tell("This is Room B, please close the door when you enter.");
                } 
                else if (userChoice.equals("C")) {
                    newDirection = roomC.visit(adventurer, directionFrom);
                    adventurer.tell("This is Room C, please... close the door when you enter.");
                }

                userChoice = inputString("(A) Enter Room A  (B) Enter Room B  (C) Enter Room C  (E) Exit");
            }
            
            inHouse = false;
            
            System.out.println("Leaving so soon? You'll be missed.");
            System.out.println("Bye");
        }
        return directionFrom;
    }
}