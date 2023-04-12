package OOP.ec22532.MP;

import java.util.Scanner;

public class House_ec22669 extends House {
    Room room_1;
    Room room_2;
    Room room_3;
    boolean hasLeft;
    public House_ec22669(){
        room_1= new Room_ec22952();
        room_2= new Room_ec22944();
        room_3= new Room_ec22929();
    }
    @Override
    public Direction visit(Visitor visitor, Direction from) {
        hasLeft = false;
        Direction d = room_1.visit(visitor, from);
        Room r=room_1;

        while (!hasLeft){
            if (r == room_1){
                visitor.tell("You are in room1 and you can choose to go to west or east to enter other rooms ");
                if(d == Direction.TO_WEST){
                    d=room_2.visit(visitor,d);
                    r=room_2;
                }
                else if(d == Direction.TO_EAST){
                    d=room_3.visit(visitor,d);
                    r=room_3;
                }
                else{
                    visitor.tell("Go stay in room1, you can't come here.");
                }
            }

            else if(r == room_2){
                visitor.tell("You are in room2 and you can choose to go west to enter room1 or go east to exit ");
                if(d == Direction.TO_WEST){
                    d=room_1.visit(visitor,d);
                    r=room_1;
                }
                else if(d == Direction.TO_EAST){
                    visitor.tell("You exit this house");
                    hasLeft=true;
                    return d.TO_EAST;
                }
                else{
                    visitor.tell("You can not go this way, so stay in room2.");
                }
            }

            else if(r == room_3){
                visitor.tell("You are in room3 and you can choose to go west to exit the house or go east to enter room1 ");
                if(d == Direction.TO_WEST){
                    visitor.tell("You exit this house");
                    hasLeft=true;
                    return d.TO_WEST;
                }
                else if(d == Direction.TO_EAST){
                    d=room_1.visit(visitor,d);
                    r=room_1;
                }
                else{
                    visitor.tell("You can not go this way, so stay in room3.");
                }
            }
        }
        return d;
    }
}
