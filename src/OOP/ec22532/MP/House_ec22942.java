package OOP.ec22532.MP;

class House_ec22942 extends House {
    
        public House_ec22942() {

        RoomA = new Room_ec221021();
        RoomB = new Room_ec221183();
        RoomC = new Room_ec22632();
        RoomD = new Room_ec22900();
    }

    public Direction visit(Visitor v, Direction d) {
        goToRoomC = true;
        Direction d1 = RoomC.visit(v, d);
        while(!leaveHouse) {
            if(goToRoomA) {
                if(Direction.opposite(d1) == Direction.TO_NORTH) {
                    System.out.println(d1.toString());
                    System.out.println("You have exited the Haunted Spooky Mansion.Well Done!");
                    goToRoomA = false;
                    leaveHouse = true;
                }
                else if(Direction.opposite(d1) == Direction.TO_EAST) {
                    System.out.println(d1.toString());
                    System.out.println("You have exited the Haunted Spooky Mansion.Well Done!");
                    goToRoomA = false;
                    leaveHouse = true;
                }
                else if(Direction.opposite(d1) == Direction.TO_SOUTH) {
                    goToRoomA = false;
                    goToRoomC = true;
                    System.out.println(d1.toString());
                    RoomC.visit(v, Direction.opposite(d1));
                }
                else {
                    System.out.println(d1.toString());
                    System.out.println("You have exited the Haunted Spooky Mansion.Well Done!");
                    goToRoomA = false;
                    leaveHouse = true;
                }
            }
            else if(goToRoomB) {
                if(d1 == Direction.TO_NORTH) {
                    System.out.println(d1.toString());
                    System.out.println("You have exited the Haunted Spooky Mansion.Well Done!");
                    goToRoomB = false;
                    leaveHouse = true;
                }
                else if(d1 == Direction.TO_EAST) {
                    System.out.println(d1.toString());
                    System.out.println("You have exited the Haunted Spooky Mansion.Well Done!");
                    goToRoomB = false;
                    leaveHouse = true;
                }
                else if(d1 == Direction.TO_SOUTH) {
                    System.out.println(d1.toString());
                    System.out.println("You have exited the Haunted Spooky Mansion.Well Done!");
                    goToRoomB = false;
                    leaveHouse = true;
                }
                else {
                    goToRoomB = false;
                    goToRoomC = true;
                    System.out.println(d1.toString());
                    RoomC.visit(v, Direction.opposite(d1));
                }
            }
            else if(goToRoomC) {
                if(d1 == Direction.TO_NORTH) {
                    goToRoomC = false;
                    goToRoomA = true;
                    System.out.println(d1.toString());
                    d1 = RoomA.visit(v, Direction.opposite(d1));
                }
                else if(d1 == Direction.TO_EAST) {
                    goToRoomC = false;
                    goToRoomB = true;
                    System.out.println(d1.toString());
                    d1 = RoomB.visit(v, Direction.opposite(d1));
                }
                else if(d1 == Direction.TO_SOUTH) {
                    System.out.println("You are stuck in the Spider Room!");
                    System.out.println("I'm sending you to the east!");
                    goToRoomC = false;
                    goToRoomB = true;
                    System.out.println(d1.toString());
                    d1 = RoomB.visit(v, Direction.opposite(d1));
                }
                else {
                    goToRoomC = false;
                    goToRoomD = true;
                    System.out.println(d1.toString());
                    d1 = RoomD.visit(v, Direction.opposite(d1));
                }
                
            }
            else if(goToRoomD) {

                if(d1 == Direction.TO_NORTH) {
                    System.out.println(d1.toString());
                    System.out.println("You have exited the Haunted Spooky Mansion.Well Done!");
                    goToRoomD = false;
                    leaveHouse = true;
                }
                else if(d1 == Direction.TO_EAST) {
                    goToRoomD = false;
                    goToRoomC = true;
                    System.out.println(d1.toString());
                    RoomC.visit(v, Direction.opposite(d1));
                }
                else if(d1 == Direction.TO_SOUTH) {
                    System.out.println(d1.toString());
                    System.out.println("You have exited the Haunted Spooky Mansion.Well Done!");
                    goToRoomD = false;
                    leaveHouse = true;
                }
                else {
                    System.out.println(d1.toString());
                    System.out.println("You have exited the Haunted Spooky Mansion.Well Done!");
                    goToRoomD = false;
                    leaveHouse = true;
                }
            }
        }
        return d;
    }
    Room RoomA, RoomB, RoomC, RoomD;
    boolean goToRoomA, goToRoomB, goToRoomC, goToRoomD = false;
    boolean leaveHouse = false;

}
