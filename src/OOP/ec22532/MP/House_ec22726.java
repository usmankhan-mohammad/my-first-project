package OOP.ec22532.MP;

class House_ec22726 extends House {

    Room r1;
    Room r2;
    Room r3;

    House_ec22726() {
        r1 = new Room_ec22726();
        r2 = new Room_ec22412();
        r3 = new Room_ec22446();
    }

    public Direction visit(Visitor v, Direction d) {
        v.tell("Welcome to the house! You can choose a room to explore or leave the house.");

        int loc = 0;

        while (true) {
            if (loc == 0) {
                char choice = v.getChoice("Which room would you like to enter or would you like to leave the house?\n" +
                        "1. Enter Room 1\n" +
                        "2. Enter Room 2\n" +
                        "3. Enter Room 3\n" +
                        "4. Leave the house", new char[]{'1', '2', '3', '4'});

                if (choice == '1') {
                    loc = 1;
                } else if (choice == '2') {
                    loc = 2;
                } else if (choice == '3') {
                    loc = 3;
                } else if (choice == '4') {
                    v.tell("You decide to leave the house. Farewell!");
                    return Direction.UNDEFINED;
                }
            } else {
                v.tell("You enter room " + loc + ".");
                if (loc == 1) {
                    d = r1.visit(v, d);
                } else if (loc == 2) {
                    d = r2.visit(v, d);
                } else if (loc == 3) {
                    d = r3.visit(v, d);
                }
                v.tell("You leave room " + loc + " and return to the entrance.");
                loc = 0;
            }
        }
    }

    public static void main(String[] args) {
        House h = new House_ec22726();
        Visitor guy = new IOVisitor(System.out, System.in);
        h.visit(guy, Direction.FROM_SOUTH);
    }
}
