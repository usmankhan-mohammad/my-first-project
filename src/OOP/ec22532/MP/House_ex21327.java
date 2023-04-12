package OOP.ec22532.MP;

class House_ex21327 extends House {
    
    Room[] roomList = new Room[4];
    private Item a = new Item("Mug");
    private Item b = new Item("Key");
    private Item c = new Item("Stick");
     
    char current_room;
    char choice;
    
    public House_ex21327() { 
        roomList[0] = new Room_ex21329(); // Room D
        roomList[1] = new Room_ex21405(); // Room C
        roomList[2] = new Room_ex21566(); // Room B
        roomList[3] = new Room_ex21541(); // Room A
    }
        
    public Direction visit(Visitor v, Direction d) {
        v.tell("You are at the entrance of the house.");
        v.tell("You find a mug");
        v.giveItem(a);
        
        v.tell("You are going into the first room");
        Direction direction = roomList[0].visit(v, Direction.FROM_SOUTH);
        
        current_room = 'D';
        
        while(true) {

            switch (current_room) {
                case 'A':
                    
                    if (direction == Direction.TO_NORTH) {
                        current_room = ' ';
                        v.tell("You have left the house.");
                        return Direction.TO_NORTH;
                    }
                    else if (direction == Direction.TO_SOUTH) {
                        current_room = 'D';
                        v.tell("You have entered room D");
                        direction = roomList[0].visit(v, Direction.FROM_NORTH);
                        
                    }
                    
                    else if (direction == Direction.TO_WEST) {
                        current_room = 'B';
                        v.tell("You have entered room B and find a key - do you take it?");
                        choice = v.getChoice("Y/N", new char[]{'Y', 'N'});
                        
                        if (choice == 'Y') {
                            v.tell("You found 1 piece of gold!!");
                            v.giveGold(1);
                        }
                            
                        direction = roomList[2].visit(v, Direction.FROM_EAST);
                        
                    }
                    
                    else  {
                        current_room = 'B';
                        v.tell("You are in room B and find a chest.");
                        choice = v.getChoice("Do you open it? Y/N.", new char[]{'Y', 'N'});
                        if (choice == 'Y') {
                            v.tell("You find a key inside the chest");
                            v.giveItem(b);
                        }
                        direction = roomList[2].visit(v, Direction.FROM_WEST);
                        
                    }
                    
                    break;
                    
                case 'B':
                    
                    if (direction == Direction.TO_NORTH) {
                        current_room = 'C';
                        v.tell("You have entered Room C");
                        direction = roomList[1].visit(v, Direction.FROM_SOUTH);
                        
                    }
                    else if (direction == Direction.TO_SOUTH) {
                        current_room = 'D';
                        v.tell("You are entering Room D. There is another chest.");
                        choice = v.getChoice("Do you open the chest? Y/N", new char[]{'Y','N'});
                        if (choice == 'Y') { 
                            v.tell("There is nothing inside the chest. Try another room.");
                        }                            

                        direction = roomList[1].visit(v, Direction.FROM_NORTH);
                        
                    }
                    else if(direction == Direction.TO_WEST) {
                        v.tell("You are inside a passageway.");
                        choice = v.getChoice("Do you continue through the passage? Y/N", new char[]{'Y', 'N'});
                        if (choice == 'a') {
                            v.tell("You find a key at the end of the passage - but it is a dead end.");
                            v.giveItem(b);
                        }
                        v.tell("You enter another room - Room A."); 
                        direction = roomList[3].visit(v, Direction.FROM_EAST);
                        
                    }
                    
                    else {
                        current_room = 'A';
                        v.tell("You are in Room A. There is a key on the floor.");
                        choice = v.getChoice("Do you take the key? Y/N.", new char[]{'Y', 'N'});
                        
                        if (choice == 'Y') {
                            v.tell("You found more gold! 2 pieces earnt.");
                            v.giveGold(2);
                        }
                        direction = roomList[3].visit(v, Direction.FROM_WEST);
                        
                    }
                    break;
                    
                case 'C': 
                    
                    if(direction == Direction.TO_NORTH) {
                        v.tell("You have entered another passageway.");
                        choice = v.getChoice("Do you enter it? Y/N.", new char[] {'Y', 'N'});
                        if (choice == 'Y') {
                            v.tell("The passage is a deadend. You turn back.");
                        }
                        v.tell("You are back in Room C");
                        current_room = 'C';
                        direction = roomList[2].visit(v, Direction.FROM_SOUTH);
                    }
                    
                    else if(direction == Direction.TO_SOUTH) {
                        current_room = 'B';
                        v.tell("You are in Room B.");
                        direction = roomList[2].visit(v, Direction.FROM_NORTH);
                    }
                    else if(direction == Direction.TO_WEST) {
                        current_room = 'D';
                        v.tell("You are in room D");
                        direction = roomList[0].visit(v, Direction.FROM_EAST);
                    }
                    
                    else {
                        v.tell("You have entered another passageway full of cobwebs..");
                        choice = v.getChoice("Do you want to continue down the passageway? Y/N", new char[] {'Y', 'N'});
                        
                        if(choice == 'Y') {
                            v.tell("You find a Stick.");
                            choice = v.getChoice("Do you want to take the stick? Y/N", new char[]{'Y','N'});
                            if (choice == 'Y') {
                                v.giveItem(c);
                            }
                        }
                        v.tell("You are back in Room C.");
                    }
                    break;
                
                case 'D': 
                    if(direction == Direction.TO_NORTH) {
                        current_room = 'A';
                        v.tell("You are in room A");
                        direction = roomList[3].visit(v, Direction.FROM_SOUTH);
                    }
                    
                    else if(direction == Direction.TO_SOUTH) { 
                        v.tell("This is the house exit.");
                        choice = v.getChoice("Are you sure you want to exit? Y/N.", new char[] {'Y', 'N'});
                        
                        if (choice == 'Y') {
                            return Direction.TO_SOUTH;
                        } 
                        else {
                            v.tell("Do you want to go in Room A or C?");
                            choice = v.getChoice("A/C", new char[] {'A','C'});
                            if (choice == 'A') {
                                direction = Direction.TO_NORTH;
                            } 
                            else {
                                direction = Direction.TO_EAST;
                            }
                        }
                    }
                    
                    else {
                        current_room = 'C';
                        v.tell("You are in Room C");
                        direction = roomList[1].visit(v, Direction.FROM_SOUTH);
                    }
                                               
                    
            }
             
        }
    }
 
 }
