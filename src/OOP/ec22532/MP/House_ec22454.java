package OOP.ec22532.MP;

public class House_ec22454 extends House {
    private Room northRoom;
    private Room eastRoom;
    private Room westRoom;

    House_ec22454(){
    northRoom = new Room_ec22599();
    eastRoom = new Room_ec22448();
    westRoom = new Room_ec22743();
    }


    public Direction visit(Visitor visitor, Direction visitorDirection) {

        boolean inside = true;
            char [] options = {'N', 'E', 'W', 'L'};
            
        while (inside) {
            visitor.tell("Ghost; Hello I am the keeper of this hallway,there is 3 different room you can enter. Choose wisely. ");

            char choice = visitor.getChoice("you can either enter the (N)orth, (E)ast or (W)est room or you can (L)eave", options);


            boolean westVisited = false;
            
            if (choice == 'W') {
                westVisited = true;
                visitorDirection = westRoom.visit(visitor, visitorDirection);
            }
            
            else if (choice == 'E') {
                if (westVisited) {
                    visitorDirection = eastRoom.visit(visitor,visitorDirection);
                }
                
                else if (!westVisited) {
                    visitor.tell("Door led to a animal room. You got eaten by a tiger");
                    inside = false;
                }
                else {
                    visitor.tell("Somthing went wrong");
                }
            }

            else if (choice == 'N') {
                visitorDirection = northRoom.visit(visitor, visitorDirection);
            }


            else if(choice == 'L') {
                visitor.tell("You have left the house");
                inside = false;
            }
            else {
                visitor.tell("Try again");
            }

        }
        return visitorDirection;
    }
}
