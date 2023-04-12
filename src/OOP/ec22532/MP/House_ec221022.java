package OOP.ec22532.MP;

abstract class House implements Visitable { }
class House_ec221022 extends House{ 

    private Room room1;
    private Room room2;
    private Room room3;
    
    public House_ec221022(){
        room1 = new Room_ec22764();
        room2 = new Room_ec21582();
        room3 = new Room_ec22494();
    }
    
    
    public Direction visit(Visitor visitor, Direction d){
    
        visitor.tell("Welcome to my house!");
        visitor.tell("In the hallway you see three doors one pink, blue and yellow");
        char[] Options = {'1', '2', '3', '4'};
        char Choice = visitor.getChoice("Enter 1) pink 2) blue 3) yellow 4) to exit to go to the corresponding rooms", Options);
        

            while(Choice!='4'){

                if(Choice == '1'){
                    visitor.tell("You open the pink door, entering the room");
                    d = room1.visit(visitor,d);
                    
                }
                else if(Choice == '2'){
                    visitor.tell("You open the blue door, entering the room");
                    d = room2.visit(visitor,d);
                    
                }
                else if(Choice == '3'){
                    visitor.tell("You open the yellow door, entering the room");
                    d = room3.visit(visitor,d);
                    
                }
                else{
                    System.out.println("Please enter a option");
                
                }
                
                Choice = visitor.getChoice("Enter 1) pink 2) blue 3) yellow 4) to exit to go to the corresponding rooms", Options);

            }
        
        return d;
    }







}