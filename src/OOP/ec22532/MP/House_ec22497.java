package OOP.ec22532.MP;

import java.util.ArrayList;
import java.util.Random;
class RoomDetails {
    Room r;
    Direction d;
}
public class House_ec22497 extends House {

    // public static void main(String[] args) {
    //     Visitor v = new IOVisitor(System.out,System.in);
    //     Direction d = Direction.FROM_SOUTH;
    //     House h = new House_ec22497(v, d);
    // }
    
    ArrayList <RoomDetails> rooms = new ArrayList<RoomDetails>();
    RoomDetails r1;
    RoomDetails r2;
    RoomDetails r3;
    RoomDetails r4;
    Direction currentDirection;
    Random rand;

    public House_ec22497 (Visitor visitor, Direction direction) {
        r1 = new RoomDetails();
        r2 = new RoomDetails();
        r3 = new RoomDetails();
        r4 = new RoomDetails();

        r1.r = new Room_ec22497();
        r1.d = r1.r.visit(visitor, direction);
        rooms.add(r1);

        r2.r = new Room_ec22479();
        r2.d = r2.r.visit(visitor, direction);
        rooms.add(r2);

        r3.r = new Room_ec22771();
        r3.d = r3.r.visit(visitor, direction);
        rooms.add(r3);

        r4.r = new Room_ec22828();
        r4.d = r4.r.visit(visitor, direction);
        rooms.add(r4);
        
        currentDirection = r1.d;
        rand = new Random();
    }

    public Direction visit (Visitor visitor, Direction direction) {
        visitor.tell("You spawn in room ec22497. You have been given the free will to explore several rooms and collect items, as well as gold. Have fun!");
        while(currentDirection.equals(Direction.TO_SOUTH)) {
            currentDirection =  rooms.get(rand.nextInt(4)).r.visit(visitor, direction);
        }
        while(!currentDirection.equals(Direction.TO_SOUTH)) { 
            if(currentDirection.equals(Direction.TO_NORTH)){
                
                currentDirection = rooms.get(1).r.visit(visitor, direction);    

            }
            if(currentDirection.equals(Direction.TO_EAST)){
                
                currentDirection = rooms.get(2).r.visit(visitor, direction);    

            }
            if(currentDirection.equals(Direction.TO_WEST)){
                
                currentDirection = rooms.get(3).r.visit(visitor, direction);    

            }
        }
        visitor.tell("You have found the exit of the house. Goodbye!");
        return Direction.TO_SOUTH;
    }
}