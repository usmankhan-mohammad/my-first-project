package OOP.ec22532.MP;

import java.util.Scanner;

public class House_ec22736 extends House {
    Room room1;
    Room room2;
    Room room3;
    boolean hasLeaved;
    public House_ec22736(){
        room1= new Room_ec22893();
        room2= new Room_ec22894();
        room3= new Room_ec22895();
    }
    @Override
    public Direction visit(Visitor visitor, Direction from) {
        hasLeaved = false;
        Direction d = room1.visit(visitor, from);
        Room r=room1;

        while (!hasLeaved){
            if (r == room1){
                visitor.tell("You are in room1 and you can choose to go to west or east to enter other room ");
                if(d == Direction.TO_WEST){
                    d=room2.visit(visitor,d);
                    r=room2;
                }
                else if(d == Direction.TO_EAST){
                    d=room3.visit(visitor,d);
                    r=room3;
                }
                else{
                    visitor.tell("You can not go this way, so stay room1.");
                }
            }

            else if(r == room2){
                visitor.tell("You are in room2 and you can choose to go west to enter room1 or go east to exit ");
                if(d == Direction.TO_WEST){
                    d=room1.visit(visitor,d);
                    r=room1;
                }
                else if(d == Direction.TO_EAST){
                    visitor.tell("You exit this house");
                    hasLeaved=true;
                    return d.TO_EAST;
                }
                else{
                    visitor.tell("You can not go this way, so stay room2.");
                }
            }

            else if(r == room3){
                visitor.tell("You are in room3 and you can choose to go west to exit the house or go east to enter room1 ");
                if(d == Direction.TO_WEST){
                    visitor.tell("You exit this house");
                    hasLeaved=true;
                    return d.TO_WEST;
                }
                else if(d == Direction.TO_EAST){
                    d=room1.visit(visitor,d);
                    r=room1;
                }
                else{
                    visitor.tell("You can not go this way, so stay room3.");
                }
            }
        }
        return d;
    }
}
