package OOP.ec22532.MP;

import java.util.Set;
import java.util.HashSet;

class House_ec22573 extends House {
    
    //array of rooms within the house 
    Room[] rooms = {new Room_ec22573(), new Room_ec22583(), new Room_ec22579(), new Room_ec22760()};
    
    //set to keep track of visited rooms
    Set<Room> visitedRooms = new HashSet<>();
    
    
    public Direction visit(Visitor v, Direction d) {
        char[] options = {'a', 'b'};
        v.tell("You hear noises coming from this house yet you slowly walk towards it");
        int choice = v.getChoice("a) Enter The House b) Exit", options);
        
        //until the user chooses to exit
        while (choice != 'b') {
            if (d == Direction.FROM_SOUTH) {
    
                //if the user hasn't visited before
                if(!visitedRooms.contains(rooms[0])){
                    v.tell("You find a new room but theres a problem");
                    v.tell("You have to crawl through a tunnel to get to this room. Do you still wish to enter");
                    choice = v.getChoice("a) Enter The House b) Exit", options);
                    if(choice == 'a'){
                        d = rooms[0].visit(v, d);
                        visitedRooms.add(rooms[0]);
                    }
                    
                }else{
                    v.tell("It seems you have already been here before. Fancy another look?");
                    choice = v.getChoice("a) Enter the Room b) Exit", options);
                    if(choice == 'a'){
                        d = rooms[0].visit(v, d);
                        visitedRooms.add(rooms[0]);
                    }
                }
                    
            } else if (d == Direction.FROM_WEST) {
                

                d = rooms[1].visit(v, d);
                v.tell("You find a hole in the ceiling and a ladder leading up towards it. Do you want to climb it?");
                choice = v.getChoice("1. Enter Room\n2. Exit", options);
                
                if(choice == 'a'){
                    visitedRooms.add(rooms[1]);
                }
                
            } else if (d == Direction.FROM_NORTH) {
                
                d = rooms[2].visit(v, d);
                v.tell("The door has no door handle. Do you wish to enter - you will have to kick the door down? ");
                choice = v.getChoice("1. Enter Room\n2. Exit", options);
                
                if(choice == 'a'){
                    visitedRooms.add(rooms[2]);
                }
                
            } else if (d == Direction.FROM_EAST) {
                
                d = rooms[3].visit(v, d);
                v.tell("You hear a strange noise coming from this room, it's intriguing but also quite eerie.Do you wish to enter?");
                choice = v.getChoice("1. Enter Room\n2. Exit", options);
                
                if(choice == 'a'){
                    visitedRooms.add(rooms[3]);
                }
            }
        }
        v.tell("Thanks for visiting.");
        
        return d;
    }
}

