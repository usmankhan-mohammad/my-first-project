package OOP.ec22532.MP;

class Room_ec22471 extends Room {
    public Direction visit (Visitor visitor, Direction Dir){
        visitor.tell ("Welcome to EC22471, enjoy!");
        visitor.tell ("Have some gold!");
        visitor.giveGold(4);
        return Direction.opposite (Dir);
    }
}
