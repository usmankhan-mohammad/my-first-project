package OOP.ec22532.MP;

class House_eey577 extends House {
    Room roomOne;
    Room roomTwo;

    House_eey577() {
        roomOne = new Room_ec22636();
        roomTwo = new Room_ec22636();
    }

    public Direction visit(Visitor V, Direction d) {
        V.tell("You've entered the house");
        int location = 1;
        while (location != 0) {
            if (location == 1) {
                d = roomOne.visit(V, d);
                if (d == Direction.TO_NORTH) {
                    V.tell("You're'going to Room 2");
                    location = 2;
                }
            } else if (location == 2) {
                d = roomTwo.visit(V, d);
                if (d == Direction.TO_SOUTH) {
                    V.tell("You're' going to Room 1");
                    location = 1;
                } else if (d == Direction.TO_EAST) {
                    location = 0;
                }
            }
        }
        V.tell("You're leaving the House!");
        return d;
    }

    public static void main(String[] args) {
        House house = new House_eey577();
        Visitor visitor = new IOVisitor(System.out, System.in);
        house.visit(visitor, Direction.FROM_SOUTH);
    }
}
