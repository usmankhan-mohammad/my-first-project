package OOP.ec22532.MP;

class House_ec22993 extends House {

    private Room RoomOne;
    private Room RoomTwo;
    private Room RoomThree;

    House_ec22993() {
        RoomOne = new Room_ec22616();
        RoomTwo = new Room_ec22430();
        RoomThree = new Room_ec22466();
    }

    public Direction visit(Visitor v, Direction d) {

        v.tell("Welcome to the house");
        v.tell("You have been guided into the central room");
        v.tell("There are four ways that you could go to");

        if(d==Direction.FROM_SOUTH){
            v.tell("You face the room ahead, this shuld be no issue");
            RoomOne.visit(v,d);
        }
        else if(d==Direction.FROM_EAST){
            v.tell("you face the room to your right, good luck");
        }
        else if(d==Direction.FROM_WEST){
            v.tell("You face the room to your left, that is a difficult one");
        }


        return d;
    }
}
