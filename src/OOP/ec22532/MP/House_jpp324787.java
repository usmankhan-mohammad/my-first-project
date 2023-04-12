package OOP.ec22532.MP;

public class House_jpp324787 extends House {
    private Room Room1;
    private Room Room2;
    private Room Room3;
    private boolean exit;

    
    public House_jpp324787() {
        Room1 = new Room_ec22414();
        Room2 = new Room_ec22636();
        Room3 = new Room_ec22987(); 
    }

    public Direction visit(Visitor v, Direction d) {
        exit = false;
        v.tell("Welcome to my house, lad!");
        v.giveGold(10);
        v.tell("");
        v.tell("Make sure you enjoy it!");
        v.tell("");

        int spot = 1;

        while (!exit) {
            if (spot == 1) {
                d = Room1.visit(v, d);
                if (d == Direction.TO_NORTH) {
                    v.tell("You're going to Room 2");
                    spot = 2;
                    exit = true;
                } else if (d == Direction.TO_WEST) {
                    v.tell("You're going to Room 3");
                    spot = 3;
                }
            } else if (spot == 2) {
                d = Room2.visit(v, d);
                if (d == Direction.TO_SOUTH) {
                    v.tell("You're going to Room 1");
                    spot = 1;
                } else if (d == Direction.TO_EAST) {
                    v.tell("You're going to Room 3");
                    spot = 3;
                }
            } else if (spot == 3) {
                d = Room3.visit(v, d);
                if (d == Direction.TO_EAST) {
                    v.tell("You're going to Room 1");
                    spot = 1;
                } else if (d == Direction.TO_WEST) {
                    v.tell("You're going to Room 2");
                    spot = 2;
                }
            }
        }

        v.tell("You're leaving the house");
        return d;
    }

    public static void main(String[] args) {
        House house = new House_jpp324787();
        Visitor visitor = new IOVisitor(System.out, System.in);
        house.visit(visitor, Direction.FROM_SOUTH);
    }
}
