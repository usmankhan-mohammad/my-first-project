package OOP.ec22532.MP;

import java.util.ArrayList;


public class House_ec22881 extends House implements Visitable {
    Room room3;
    Room room2;
    Room room1;
    Room temproom;
    char[] options = {'1', '2', '3', '4'};
    char choice = 'a';
    boolean leave = false;

    House_ec22881(){
        room3= new Room_ec221003();
        room2 = new Room_ec22551();
        room1= new Room_ec22881();
    }

    ArrayList<Room> rooms = new ArrayList<Room>();

    public Direction visit(Visitor visitor, Direction dFrom) {

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        while (!leave){

            choice = visitor.getChoice("You enter a house with three rooms that you can see. Which would you like to enter first?\n a)Haunted Room\n b)The BIG room\n c)Fountain room\n d)Leave the house",options);

            if(choice == 'a'){
                temproom = rooms.get(0);
                temproom.visit(visitor, dFrom);
            }
            else if (choice == 'b'){
                temproom = rooms.get(1);
                temproom.visit(visitor, dFrom);
            }
            else if(choice == 'c'){
                temproom = rooms.get(2);
                temproom.visit(visitor, dFrom);
            }
            else if(choice == 'd'){
                visitor.tell("You leave the house the same way you came in.");
                leave = true;
            }
            else{
                visitor.tell("That is not a valid option.");
            }
        }

        return dFrom;
    }
}
