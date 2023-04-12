package OOP.ec22532.MP;

class House_ec22793 extends House {
    Room room1;
    Room room2;
    Room room3;

    public House_ec22793() {
        room1 = new Room_ec22791();
        room2 = new Room_ec22792();
        room3 = new Room_ec22793();
    }

    public Direction visit(Visitor v, Direction d){
        Direction newDirection = Direction.TO_EAST;
        char visitorChoice = v.getChoice("Welcome to my house. Here are three different rooms.... do you enter a room? Y/N", new char[] { 'Y', 'N' });
        if(visitorChoice == 'Y'){
            v.tell("You enter room 1...");
            newDirection = room1.visit(v,d);
        }
        while(visitorChoice == 'Y'){
            
            visitorChoice = v.getChoice("Do you wish to keep exploring or leave? Y/N", new char[] { 'Y', 'N' });

            if(newDirection == Direction.TO_SOUTH || newDirection == Direction.TO_NORTH){
                v.tell("You enter room 3...");
                newDirection = room3.visit(v,d);
            } else if(newDirection == Direction.TO_EAST){
                v.tell("You enter room 2...");
                newDirection = room2.visit(v,d);
            } else {
                v.tell("You enter room 1...AGAIN");
                newDirection = room1.visit(v,d);
            }

        }

        v.tell("bye!");
        return Direction.TO_SOUTH;
    }
    
    public static void main(String[] args){
        House h = new House_ec22793();
        Visitor joe = new IOVisitor(System.out, System.in);
        h.visit(joe, Direction.FROM_NORTH);
    }
}
