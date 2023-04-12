package OOP.ec22532.MP;

class House_221185 extends House {
     private Room room1;
     private Room room2;
     private Room room3;
     House_221185() {
         room1 = new Room_ec22507(); // East
         room2 = new Room_ec221185(); // West
         room3 = new Room_ec22680(); // North
     }

     public Direction visit(Visitor visitor, Direction direction) {
         visitor.tell("You approach the world tree");
         char[] options = {'N', 'S', 'W', 'E'};
         char choices = visitor.getChoice("Make your decision! Go south if you want to leave. Or maybe its east hahaha", options);
         char choice = visitor.getChoice("Make your decision! Go south if you want to leave. Or maybe its east hahaha", options);

         while (choice != 'S') {
             if (choice == 'N') {
                 visitor.tell("Welcome to the realm that is most north, Niflheim");
                 direction = room1.visit(visitor, direction);
             }
             if (choice == 'E') {
                 visitor.tell("Welcome to the room thats most east, Asgard!");
                 direction = room2.visit(visitor, direction);
             }
             if (choice == 'W') {
                 visitor.tell("Welcome to the room thats most west, Svartalheim!");
                 direction = room3.visit(visitor, direction);
             }
             else {
                 choice = visitor.getChoice("Let us surf the world tree again shall we?", options);
             }
             choice = visitor.getChoice("Onto the next Realm!", options);
         }
         return direction;
     }
 }
