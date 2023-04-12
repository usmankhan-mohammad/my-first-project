package OOP.ec22532.MP;

class House_ec22978 extends House {
    Room r1;
    Room r2;
    Room r3;
    boolean isFinished = false;

    int tracker = 0;

    House_ec22978() {
        r1 = new Room_ec22615();
        r2 = new Room_ec22712();
        r3 = new Room_ec22880();
    }

    public Direction visit(Visitor visitor, Direction direction) {
        char[] directions = {'n', 's', 'w', 'e'};

        while (tracker!=4) {
            if (tracker == 0){
                visitor.tell("You enter the start");
                char selectedDirection = visitor.getChoice("Which way would you like to go? n/w/s/e ?", directions);
                if (selectedDirection == 'n') {
                    tracker = 1;

                }
                else if (selectedDirection == 's'){
                    visitor.tell("You finish");
                    tracker = 4;
                }
                else {
                    System.out.println("Invalid. Try again");
                    tracker = 0;

                }

            }
            if (tracker == 1) {
                direction = r1.visit(visitor, direction);
                if (direction == Direction.TO_NORTH) {
                    tracker = 2;
                } else if (direction == Direction.TO_SOUTH) {
                    tracker = 0;
                }
            }
            if (tracker == 2) {
                direction = r2.visit(visitor, direction);
                if (direction == Direction.TO_WEST) {
                    tracker = 3;
                } else if (direction == Direction.TO_SOUTH) {
                    tracker = 1;
                }
            }
            if (tracker == 3) {
                direction = direction = r3.visit(visitor, direction);
                if (direction == Direction.TO_WEST) {
                    visitor.tell("You Leave");
                    isFinished = true;
                } else if (direction == Direction.TO_EAST) {
                    tracker = 2;
                }
            }
        }
        return direction;
    }


    public static void main(String[] args) {
        House h = new House_ec22978();
        Visitor guy = new IOVisitor(System.out, System.in);
        h.visit(guy, Direction.FROM_SOUTH);
    }
}

