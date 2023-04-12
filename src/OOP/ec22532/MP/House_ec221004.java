package OOP.ec22532.MP;

class House_ec221004 extends House {
    int gold = 0; 
	Item[] inventory = new Item[99];
   private Room room1;
   private Room room2;
   private Room room3;

      public House_ec221004() {
        room1 = new Room_ec22867();
        room2 = new Room_ec221004();
        room3 = new Room_ec22987(); 
    }
    
    public Direction visit(Visitor visitor, Direction directionOfArrival) {
        visitor.tell("Welcome to House ec221004!");
        visitor.tell("You enter the hallway and are faced with 3 doors ");
        
        char choice = visitor.getChoice("Which would you like to enter? 1)Room 1, 2)Room 2, 3)Room 3, or 4)Exit", new char[]{'1', '2', '3','4'});
        
         while (choice != '4') {
             
             if (choice == '1') {
                 visitor.tell("You entered the room on the left");
                 directionOfArrival = Direction.TO_EAST;
                 directionOfArrival = room1.visit(visitor, directionOfArrival);
                 visitor.tell("You go back in the hallway.");
             }
             
             if (choice == '2') {
                 visitor.tell("You entered the room in front of you");
                 directionOfArrival = Direction.TO_SOUTH;
                 directionOfArrival = room2.visit(visitor, directionOfArrival);
                 visitor.tell("You go back in the hallway.");
             }
             
             if (choice == '3') {
                 visitor.tell("You entered the room on the right");
                 directionOfArrival = Direction.TO_WEST;
                 directionOfArrival = room3.visit(visitor, directionOfArrival);
                 visitor.tell("You go back in the hallway.");
             }
                 
             
             choice = visitor.getChoice("Which would you like to enter next? 1) Room 1, 2) Room 2, 3) Room 3, or 4)Exit", new char[]{'1', '2', '3','4'});
         }
        
        visitor.tell("You have left");
        return directionOfArrival;
    }
    
   
}
