package OOP.ec22532.MP;

import java.awt.*;
import java.util.Scanner;
class House_ec22532 extends House {

    Room roomOne;
    Room roomTwo;
    Room roomThree;
    
    House_ec22532(){
    
        roomOne = new Room_ec22532();
        roomTwo = new Room_ec22842();
        roomThree = new Room_ec22929();
        
    }
    
    
    public Direction visit(Visitor v, Direction d) {

        int housePos = 0;
        Direction directionGoing;
        Direction directionFrom;


        directionFrom = d;
        directionGoing = Direction.UNDEFINED;

        while(housePos != -1){

            if (housePos == 0){
                
                if (hallwayChoice(v) == true){break;}
                else{
                    v.changeCol(Color.MAGENTA);
                    directionGoing = roomOne.visit(v,directionFrom);
                    //directionGoing = directionGoing.opposite(directionGoing); //must be done as room ec22532 returns a "FROM" direction //changed april 7th 2023
                    directionFrom = directionGoing.opposite(directionGoing);
                    
                    if (directionGoing == Direction.TO_NORTH || directionGoing == Direction.TO_EAST || directionGoing == Direction.TO_WEST){housePos = 1;}
                    else if (directionGoing == Direction.TO_SOUTH){housePos = -1; v.tell("You have left the house through the front exit"); break;}
                    
                    }} //going into room 1
            
            else if (housePos == 1){
                
                if (hallwayChoice(v) == true){break;}
                else{
                    v.changeCol(Color.blue);
                    directionGoing = roomTwo.visit(v,directionFrom);
                    directionFrom = directionGoing.opposite(directionGoing);
                    
                    if (directionGoing == Direction.TO_SOUTH || directionGoing == Direction.TO_EAST){housePos = 0;}
                    else if (directionGoing == Direction.TO_NORTH){housePos = 2;}
                    else if (directionGoing == Direction.TO_WEST){housePos = -1; v.tell("You have left the house through the secret exit"); break;}
                    
                    
                    
                    }} //going into room 2
            
            else if (housePos == 2){
                
                if (hallwayChoice(v) == true){break;}
                else{
                    Color darkgreen = new Color(43, 105, 31);
                    v.changeCol(darkgreen);
                    directionGoing = roomThree.visit(v,directionFrom);
                    directionFrom = directionGoing.opposite(directionGoing);
                    
                    if (directionGoing == Direction.TO_WEST || directionGoing == Direction.TO_EAST){housePos = 0;}
                    else if (directionGoing == Direction.TO_SOUTH){housePos = 1;}
                    else if (directionGoing == Direction.TO_NORTH){housePos = -1; v.tell("You have left the house through the back exit"); break;}
                    
                    
                    }} //going into room 3
            
            
        }

            return directionFrom;
    }    

    
    
    public boolean hallwayChoice(Visitor v){
        //v.tell("Do you a) leave the house or b) try to go to the next room ?");
        //String userChoice = inputString();
        char[] possibleChoices = {'a','b'};
        char userChoice = v.getChoice("Do you a) leave the house or b) try to go to the next room ?", possibleChoices);
        if (userChoice == 'a'){
            return true;
        }
        else {
            return false;
        }
        
    }
    
//    public String inputString(Visitor v){
//        String s = v.getInputText();
//        return s;
//
////        Scanner scanner = new Scanner(System.in);
////        String input = scanner.nextLine();
////        return input;
//    }

}
