package OOP.ec22532.MP;

class House_ec22851 extends House {
    private Room firstRoom;
    private Room_ec22851 secondRoom;
    private Room thirdRoom;
    private Item Suit = new Item("Ant-Man Suit");
    
    public House_ec22851() 
    {
        firstRoom = new Room_ec22828();
        secondRoom = new Room_ec22851();
        thirdRoom = new Room_ec22678();
    }
    
    public Direction visit(Visitor visitor, Direction direction) 
    {
        boolean exit = false;
        boolean helicopter = true;
        final char[] RoomPosition = new char[]{'A','B','C','H','L'};
        char RoomIn = RoomPosition[3];
        char RoomFrom = RoomPosition[3];
        
        while(!exit){
            
            if((RoomIn == 'H')&&(RoomFrom == 'H')){
                
                visitor.tell("You are on a mission to infiltrate the avengers base");
                visitor.tell("Accept the Ant-Man suit to begin the mission");
                visitor.giveItem(Suit);
                if (visitor.hasEqualItem(Suit)){
                    
                    visitor.tell("You entered the room after diving 15000 feet");
                    RoomIn = 'A';
                    RoomFrom = 'H';
                }
                else{
                    visitor.tell("You have chosen to decline the mission");
                    exit = true;
                 }
            }
            else if ((RoomIn == 'A')&&(RoomFrom == 'H')){
                secondRoom.TonyStarkAlive = true;
                direction = firstRoom.visit(visitor, Direction.TO_NORTH);
                RoomIn = 'B';
                RoomFrom = 'A';
            }
            else if ((RoomIn == 'A')&&(RoomFrom == 'L')){
                direction = firstRoom.visit(visitor, Direction.TO_NORTH);
                RoomIn = 'B';
                RoomFrom = 'A';
                }
            else if ((RoomIn == 'B')&&(RoomFrom == 'A')){
                visitor.tell("You enter the nether realm");
                visitor.tell("Your spirit has detached from your body");
                visitor.tell("You are going through one of the portal");
                direction = secondRoom.visit(visitor, direction);
                if(direction == Direction.TO_WEST){
                RoomIn = 'L';
                RoomFrom = 'B';
                }
                else if(direction == Direction.TO_EAST){
                RoomIn = 'C';
                RoomFrom = 'B';
                }
            }
               else if ((RoomIn == 'C')&&(RoomFrom == 'B')){   
               visitor.tell("You regain your body and end up in another room");
               direction = thirdRoom.visit(visitor, direction);
                   RoomIn = 'B';
                RoomFrom = 'C';
               }
            else if ((RoomIn == 'B')&&(RoomFrom == 'C')){ 
               visitor.tell("You regain your body and end up in another room");
               direction = secondRoom.visit(visitor, direction);
                 RoomIn = 'L';
                RoomFrom = 'B';
            }
               else if ((RoomIn == 'L')&&(RoomFrom == 'B')){
               visitor.tell("While going back to the portal, the soul stone sucks your spirit and you get trapped in the limbo");
               visitor.tell("You have an option to travel to any room or restart the mission");
               char choiceSelected  = visitor.getChoice("Press A to go back to the spooky room or Press C to go to the dark room and press H to restart mission or E to exit",new char[]{'A','C','H','E'});
                if (choiceSelected == 'A'){
                    RoomIn = 'A';
                    RoomFrom = 'L';
                        
                }
                if (choiceSelected == 'C'){
                    RoomIn = 'C';
                    RoomFrom = 'B';
                }
                if ( choiceSelected == 'H'){
                    RoomIn = 'H';
                    RoomFrom = 'H';
                }
                   if(choiceSelected == 'E'){
                       exit = true;
                   }
            }
        }
        return direction;
    }
}
