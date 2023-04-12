package OOP.ec22532.MP;

public class House_ec22494 extends House {
    Room room1;
    
    public House_ec22494() {
        room1 = new Room_ec22494();
    }
    
    public Direction visit(Visitor v, Direction d) {
        return d;
    }
}
