package OOP.ec22532.MP;

abstract class House implements Visitable { }
class House_ec22597 extends House{ 

    private Room room1;
    private Room room2;
    private Room room3;

    public House_ec22597(){
        room1 = new Room_ec22597();
        room2 = new Room_ec22582();
        room3 = new Room_ec22434();
    }


    public Direction visit(Visitor visitor, Direction d){

        visitor.tell("You've entered pooley house... there's no around so you look around to try to find someone");
        visitor.tell("You hear a smash come from the front door, what door will you try and hide in?");
        char[] Options = {'1', '2', '3', '4'};
        char Choice = visitor.getChoice("Enter 1) the dirty door 2) the door with packages outside 3) the clean door 4) to exit to go to the corresponding rooms", Options);


            while(Choice!='4'){

                if(Choice == '1'){
                    visitor.tell("You go through the dirty door...");
                    d = room1.visit(visitor,d);

                }
                else if(Choice == '2'){
                    visitor.tell("You go through the door with the packages outside and bring them in...");
                    d = room2.visit(visitor,d);

                }
                else if(Choice == '3'){
                    visitor.tell("You go through the clean door...");
                    d = room3.visit(visitor,d);

                }
                else{
                    System.out.println("Please enter a number between 1-3 or press 4 to exit");

                }

                Choice = visitor.getChoice("Enter 1) the dirty door 2) the door with packages outside 3) the clean door 4) to exit to go to the corresponding rooms", Options);

            }

        return d;
    }







}
