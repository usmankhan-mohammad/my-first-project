package OOP.ec22532.MP;

class House_ec22866 extends House {
  Room r1;
  Room r2;
  Room r3;
  
  House_ec22866() {
        r1 = new Room_ec22562();
        r2 = new Room_ec21582();
        r3 = new Room_ec221156();
  }
  
  public Direction visit(Visitor v, Direction d){
    v.tell("You have entered home");
    char[] choices = { 'a', 'b', 'c' };
    String roomChoice = ("Many scary place you can choose from, pick which one you think will help you escape. Room a, b or c");
    char userChoice = v.getChoice(roomChoice, choices);
    
    if (userChoice == 1){
      v.tell("You chose Room1, HAHAHAHAH");
      r1.visit(v,d);
      }
             
    else if (userChoice == 2){
      v.tell("Room2??, YOUR DEAD...OR ARE YOU?");
      r2.visit(v,d);
      }
             
    else if (userChoice == 3){
      v.tell("BAD CHOCIE.VERY BAD, HEHEHEH");
      r3.visit(v,d);
      }
    
    else{
      v.tell("Please pick one of the 3 rooms");
    }
    
    return d;
  }
  
}
