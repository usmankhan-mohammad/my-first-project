package OOP.ec22532.MP;

public class House_cb21793 extends House {
    Room[][] house = {
            {new Room_ec21413(), new Room_ec22409()},
            {new Room_ec21645(), new Room_ec22406()},
            {new Room_ec21403(), new Room_cb21793()}
    };

    int posX;
    int posY;
    boolean exitHouse;
    Direction dir;

    public Direction visit(Visitor visitor, Direction visitorDirection) {
        exitHouse = false;

        if (visitorDirection.toString().equals(Direction.FROM_NORTH.toString())) {
            posX = 0;
            posY = house.length - 1;
        } else if (visitorDirection.toString().equals(Direction.FROM_EAST.toString())) {
            posX = 0;
            posY = 1;
        } else if (visitorDirection.toString().equals(Direction.FROM_SOUTH.toString())) {
            posX = 1;
            posY = 0;
        } else {
            posX = house[0].length - 1;
            posY = 0;
        }

        while (!exitHouse) {
            dir = house[posY][posX].visit(visitor, visitorDirection);

            if (dir.toString().equals(Direction.FROM_NORTH.toString())) {
                posY -= 1;
            } else if (dir.toString().equals(Direction.FROM_EAST.toString())) {
                posX += 1;
            } else if (dir.toString().equals(Direction.FROM_SOUTH.toString())) {
                posY += 1;
            } else {
                posX -= 1;
            }

            if (posX >= house[0].length || posY >= house.length || posX < 0 || posY < 0) {
                exitHouse = true;
            }
        }

        return dir;
    }

    public static void main(String[] a) {
        House houseInstance = new House_cb21793();
        Visitor visitorInstance = new IOVisitor(System.out, System.in);
        houseInstance.visit(visitorInstance, Direction.FROM_WEST);
    }
}