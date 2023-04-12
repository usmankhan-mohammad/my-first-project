package OOP.ec22532.MP;

class House_ec22596 extends House {
    int goldCount = 5;
    private Room northRoom;
    private Room east_Room;
    private Room westRoom;

    // creating rooms
    House_ec22596() {
        northRoom = new Room_ec22798();
        east_Room = new Room_ec22943();
        westRoom = new Room_ec22451();
    }

    public Direction visit(Visitor v, Direction d) {

        // if alive or dead, set as alive naturally
        boolean In_House = true;

        v.tell("Welcome To My House");

        while (In_House) {

            v.tell(
                    "There are three doors to the north, east and west.");
            char[] directionChoices = { 'N', 'E', 'W', 'L' };

            char hallway = v.getChoice(
                    "Would you like to enter the (N)orth, (E)ast or (W)est room, or (L)eave",
                    directionChoices);

            boolean eastVisited = false;

            // OPtions

            //Hint for user

            if (hallway == 'E') {
                v.tell("Tread lightly! You've entered a dangerous place. Keep your valuables secure.");
                v.tell("Oh no! You were robbed! The thief took 3 gold pieces!");
                v.tell("You have " + (this.goldCount-3)+ " gold pieces remaining.");
                this.takeGold(3);
                eastVisited = true;
                d = east_Room.visit(v, d);
            }

            else if (hallway == 'W') {
                if (eastVisited) {
                    v.tell("You try to avoid drawing attention to yourself.");
                    this.giveGold(7);
                    v.tell("You found 7 gold pieces on the ground! Lucky day!You now have " + (this.goldCount) + " gold pieces.");

                    d = westRoom.visit(v, d);

                }

                else if (!eastVisited) {
                    v.tell(
                            "You opened but you got robbed");
                    v.tell("Tread lightly! You've entered a dangerous place. Keep your valuables secure.");
                    v.tell("Oh no! You were robbed! The thief took 3 gold pieces!");
                    v.tell("You have " + (this.goldCount-3)+ " gold pieces remaining.");
                    this.takeGold(3);

                    In_House = false;
                }

                else {
                    v.tell("The destitute man chases you and causes you to trip.");
                    v.tell("You dropped 2 coins, and the destitute man runs away with them.");
                    this.takeGold(2);
                }
            }

            else if (hallway == 'N') {
                d = northRoom.visit(v, d);
            }

            else if (hallway == 'L') {
                v.tell("You left the house");
                In_House = false;
            }

            else {
                v.tell("Invalid");
            }
        }
        return d;
    }
    public void giveGold(int NumberOfPiecesToGive){
        if (this.goldCount+NumberOfPiecesToGive > 10){
            System.out.println("You are targetted by a couple rat thiefs for how much gold you have. You now have only 10 pieces of gold. ");
            this.goldCount = 10;

        }

        else{
            this.goldCount+=NumberOfPiecesToGive;
        }
    }

    public int takeGold(int NumberOfPiecesToTake) {
        if (this.goldCount - NumberOfPiecesToTake < 1) {
            System.out.println("A homeless man feels bad for how poor you are and you now have 1 coin. ");
        } else {
            this.goldCount -= NumberOfPiecesToTake;
        }
        return NumberOfPiecesToTake;
    }
    
}
