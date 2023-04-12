package OOP.ec22532.MP;

public class House_ec21413 extends House {

    Room[] rooms = new Room[4];    //4 rooms

    public Direction visit(Visitor v, Direction d) {

        Direction leavingDirection = Direction.opposite(d);

        rooms[0] = new Room_ec21413();
        rooms[1] = new Room_ec21413();
        rooms[2] = new Room_ec21413();
        rooms[3] = new Room_ec21413();

        v.tell("------------------------------");
        v.tell("   Welcome to House_ec21413   ");

        boolean exit = false;   //default to false

        while(!exit) {
            v.tell("------------------------------");
            v.tell("  Choose a room to enter:     ");
            v.tell("  (1) Kitchen                 ");
            v.tell("  (2) Living Room             ");
            v.tell("  (3) Bedroom                 ");
            v.tell("  (4) Storage room            ");
            v.tell("------------------------------");

            char roomChoice = v.getChoice("", new char[] {'1','2','3','4'});

            if (roomChoice == '1') {
                leavingDirection = rooms[0].visit(v,d);
            }
            else if (roomChoice == '2') {
                leavingDirection = rooms[1].visit(v,d);
            }
            else if (roomChoice == '3') {
                leavingDirection = rooms[2].visit(v,d);
            }
            else if (roomChoice == '4') {
                leavingDirection = rooms[3].visit(v,d);
            }
            else {
                v.tell("Invalid option");
            }
            exit = exitHouse(v);
        }
        
        return leavingDirection;
    }


    public boolean exitHouse(Visitor v) {

        boolean leave = false;
        char choice = v.getChoice("Exit House? (y/n)", new char[] {'y','n'});

        if (choice == 'y'){
            leave = true;
        }
        return leave;
    }
    
}
