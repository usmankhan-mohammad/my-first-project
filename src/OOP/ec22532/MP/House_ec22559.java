package OOP.ec22532.MP;

import java.util.Random;
class House_ec22559 extends House {
    
    final int numberOfRooms = 4;
    private boolean lights = false;
    private Room[] rooms = new Room[numberOfRooms];
    Item baseballBat = new Item("Baseball Bat");
    
    House_ec22559(){
        rooms[0] = new Room_ec22559();
        rooms[1] = new Room_ec22414();
        rooms[2] = new Room_ec22558();
        rooms[3] = new Room_ec22424(lights);
    }
    
    public Direction visit(Visitor v, Direction d) {
        v.tell("Welcome to my house!");
        Room currentRoom = rooms[0];
    
        boolean leaveFlag = false;
        Direction newDirection = rooms[0].visit(v, d);
        
        while(!leaveFlag){
            
            if (newDirection == Direction.TO_SOUTH){
                if (currentRoom == rooms[0]){
                    leaveFlag = true;
                }else if (currentRoom == rooms[1]){
                    currentRoom = rooms[0];
                }
            }else if (newDirection == Direction.TO_EAST){
                if (currentRoom == rooms[0]){
                    currentRoom = rooms[2];
                }else if (currentRoom == rooms[2]){
                    currentRoom = rooms[0];
                }else if (currentRoom == rooms[1]){
                    leaveFlag = true;
                }else{
                    currentRoom = rooms[1];
                }
            }else if (newDirection == Direction.TO_NORTH){
                if(currentRoom == rooms[0]){
                    currentRoom = rooms[1];
                }else if (currentRoom == rooms[1]){
                    leaveFlag = true;
                }
            }else{
                if (currentRoom == rooms[0]){
                    leaveFlag = true;
                }else if (currentRoom == rooms[2]){
                    currentRoom = rooms[0];
                }else if (currentRoom == rooms[1]){
                    currentRoom = rooms[3];
                }
            }
            if (leaveFlag != true){
                v = Hallway(v);
                newDirection = currentRoom.visit(v,newDirection);
            }
        }
        v.tell("You have exited the house.");
        return newDirection;
    }
    
    public Visitor Hallway(Visitor v){
        Boolean rgbLights = false;
        v.tell("You have now entered the hallway" );
        char[] choices = {'a', 'b', 'c', 'd'};
        char choice = v.getChoice("Enter 'a' to destroy the hallway with a baseball bat, 'b' to turn the RGB lights on or 'c' to enter the next room.", choices);
        Random rand = new Random();
        
        if (choice == 'a'){
            v.tell("You found my baseball bat!");
            v.giveItem(baseballBat);
            int itemsDestroyed = rand.nextInt(10);
            if(itemsDestroyed < 3){
                v.tell("You destroyed " + itemsDestroyed + " items. Therefore you loose 2 gold ahahaha!");
                v.takeGold(2);
            }else{
                v.tell("You destroyed " + itemsDestroyed + " items. Therefore you loose 5 gold ahahaha!");
                v.takeGold(5);
            }
            
        }else if (choice == 'b'){
            rgbLights = true;
            v.tell("You turned the RBG lights on.");
            char[] choices1 = {'a', 'b'};
            char choice1 = v.getChoice("Select 'a' to turn the RGB lights on Party Mode, or 'b' to turn them on breathe mode.", choices1);
            if (choice1 == 'a'){
                v.tell("It's party time!!! You earned 5 gold!");
                v.giveGold(5);
            }else{
                v.tell("Set to breathe mode");
            }
        }
    
        v.tell("You entered another room.");
        return v;
    }
}
