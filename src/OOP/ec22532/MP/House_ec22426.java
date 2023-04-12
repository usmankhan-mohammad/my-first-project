package OOP.ec22532.MP;

//The class which is a subclass of house
class House_ec22426 extends House {

    //key and sword item for the user
    static final Item key = new Item("Key_ec22426");
    static final Item sword = new Item("Sword_ec22426");


    //array which will contain the rooms
    private Room rooms[];
    
    //constructor which adds the rooms to the array
    public House_ec22426(){
        rooms = new Room[4];
        rooms[0]= new Room_ec22426();
        rooms[1]= new Room_ec22547();
        rooms[2]= new Room_ec22982();
        rooms[3]= new Room_ec22885();
    }

    //when the visitor enters the house
    public Direction visit(Visitor newVisitor, Direction currentDirection){

        //boolean variables used to check if certain actions have been completed
        Boolean chestOpened = false;

        Boolean openTrapDoor = false;
        
        //user can decide if they want to enter the house
        newVisitor.tell("You are standing outside a large house with an open door...");
        char[] option = {'a','b'};
        char choice = newVisitor.getChoice("Do you want to a) go inside or b) walk away from the house",option);

        //if they dont want to
        if (choice == 'b'){
            return Direction.opposite(currentDirection);
        }
        
        //User can decide to turn on lights
        newVisitor.tell("You enter a dark hallway and you can see a room at the end.");
        choice = newVisitor.getChoice("Do you want to turn on the lights a)yes or b)no",option);

        //if they choose to turn on lights
        if (choice == 'a'){
            //they can collect gold
            newVisitor.tell("You turn on the light and see some gold on the floor and a key.");
            newVisitor.giveGold(5);
            //user finds a key and checks they take it
            Boolean accepted =  newVisitor.giveItem(key);
            //the key is only taken if true is returned
            if (accepted == true) {
                newVisitor.tell("You pick up the key.");
            }
        }

        //starting index for rooms array
        int index = 0;
        //boolean variable for leaving house
        boolean finished = false;

        //keeps repeating until finished is true
        while(!finished) {
            //enter a room
            newVisitor.tell("You are entering a room.");
            Room currentRoom = rooms[index];
            currentDirection = currentRoom.visit(newVisitor, currentDirection);

            //if the direction is to the north do this
            if (currentDirection == Direction.TO_NORTH ) {
                //user interacts with trap door if its isnt open
                if (openTrapDoor==false) {
                    newVisitor.tell("You are walking along a corridor towards the next room.");
                    newVisitor.tell("On the ground you see a locked trap door.");
                    //if they have the key item they can open it if they want to
                    if (newVisitor.hasIdenticalItem(key) == true) {
                        choice = newVisitor.getChoice("Do you want to a) open the door b) continue on", option);

                        //user find gold and a sword item
                        if (choice == 'a') {
                            newVisitor.tell("You use the key to open the door.");
                            newVisitor.tell("Inside is some gold and a sword.");
                            newVisitor.giveGold(10);
                            //checks if user can take item
                            Boolean collect = newVisitor.giveItem(sword);
                            if (collect == true){
                                newVisitor.tell("You take the sword and gold.");
                            }
                            else{
                                newVisitor.tell("You only take the gold.");
                            }
                            //sets boolean to true
                            openTrapDoor = true;
                        }
                        //if the user doesnt open the door
                        else {
                            newVisitor.tell("You walk past the trap door.");
                        }
                    }
                    //if the user does not have the key item
                    else {
                        newVisitor.tell("You can not open the trap door continue forward.");
                    }
                }
                //trap door is already open
                else{
                    newVisitor.tell("You are walking along a corridor towards the next room.");
                    newVisitor.tell("On the ground you see an open trap door.");
                    newVisitor.tell("You continue forward.");
                }
                //changes current direction
                currentDirection = Direction.TO_EAST;
            }
            //does this action if current direction is south
            else if (currentDirection == Direction.TO_SOUTH) {

                //allows the user to interact with a chest
                newVisitor.tell("You walk into a deadend.");
                newVisitor.tell("You turn around and see a chest on the floor.");
                //if the chest is closed
                if (chestOpened == false) {
                    choice = newVisitor.getChoice("Do you want to a) leave it or b) open the chest", option);

                    //if they want to open the chest
                    if (choice == 'b') {
                        chestOpened = true;
                        newVisitor.tell("You open the chest inside is a book.");
                    }
                    //if they dont
                    else {
                        newVisitor.tell("You walk past the chest.");
                    }
                }
                //already open
                else {
                    newVisitor.tell("The chest is already open.");
                }
                //changes current direction to west
                currentDirection = Direction.TO_WEST;

            }
            //if the current direction is west
            else if (currentDirection == Direction.TO_WEST) {
                //user finds gold
                newVisitor.tell("As you walk along you find a pile of gold on the floor.");
                newVisitor.tell("You take 5 gold.");
                newVisitor.giveGold(5);

                //changes direction to north
                currentDirection = Direction.TO_NORTH;
            }
            //if the direction is east
            else if (currentDirection == Direction.TO_EAST) {

                //user enters area they shouldnt be and can make choise
                newVisitor.tell("You are not allowed to go in this direction.");
                choice = newVisitor.getChoice("Do you want to a) continue or b) turn around", option);

                //if they continue they are attacked
                if (choice == 'a') {
                    newVisitor.tell("You continue walking and you are attacked by a dog.");
                    //if they have sword item they can fight
                    if (newVisitor.hasIdenticalItem(sword) == true) {
                        newVisitor.tell("You use the sword to fight the dog and scare it off.");
                    }
                    //if not gold is taken
                    else{
                        newVisitor.tell("Gold is taken from you.");
                        int take = newVisitor.takeGold(9);
                    }
                }
                //if they dont continue
                else {
                    newVisitor.tell("You turn around.");
                }
                //the direction changes to west
                currentDirection = Direction.TO_WEST;
            }

            //increases index for room array
            index++;
            //checks index hasnt gone over
            if (index == 4) {
                //if it has user can choose to leave the house or return
                newVisitor.tell("You have left the house.");
                choice = newVisitor.getChoice("Do you want to a) leave or b) go back inside the house", option);

                //the boolean variable finished becomes true.
                if (choice == 'a') {
                    finished = true;
                }
                //resets the index
                else {
                    index = 0;
                }
            }

        }
        return Direction.opposite(currentDirection);
    }
}
