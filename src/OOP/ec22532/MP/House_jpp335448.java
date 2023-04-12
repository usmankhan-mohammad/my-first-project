package OOP.ec22532.MP;

class House_jpp335448 extends House {
    Room r1, r2, r3;
    
    House_jpp335448(){
        r1 = new Room_ec22414();
        r2 = new Room_ec22446();
        r3 = new Room_ec22479();
    }
    
    public Direction visit(Visitor v, Direction d) {
        v.tell("You are in the house");
        char[] choices = {'a', 'b', 'c'};
        char userChoice = v.getChoice("Choose between a, b, or c", choices);
        
        if(userChoice == 'a'){
            v.tell("You chose Room1");
            r1.visit(v,d);
            
        }
        else if (userChoice == 'b'){
            v.tell("You chose Room2");
            r2.visit(v,d);            
        }
        else if (userChoice == 'c'){
            v.tell("You chose Room3");
            r3.visit(v,d);            
        }
        else{
            v.tell("Please pick one of them");
        }
      
        return d;
    }
}
