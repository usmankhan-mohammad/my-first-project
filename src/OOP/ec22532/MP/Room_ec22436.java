package OOP.ec22532.MP;

class House_ec22436 extends House {
    Room roomOne;
    Room roomTwo;
    Room roomThree;
    boolean exit = false;

    House_ec22436(){
        roomOne= new Room_ec221003();
        roomTwo= new Room_ec22432();
        roomThree= new Room_ec221022();
    }

    public Direction visit(Visitor v, Direction d) {
        char[] choices = {'N', 'E', 'S', 'W'};
        char choiceSelected  = v.getChoice("Press (N) to go North, (E) East, (S) South, (W) West", choices);
        while(exit!=true){
            if(choiceSelected=='N'){
                v.tell("You stub your toe on the way in...");
                d = roomTwo.visit(v, d);
                exit=true;
            }else if(choiceSelected=='E'){
                v.tell("You hit your head on the way through the door...");
                d = roomThree.visit(v, d);
                exit=true;
            }else if(choiceSelected=='S'){
                v.tell("You realise your trousers are unbuckled, so you buckle them before heading in...");
                d = roomOne.visit(v, d);
                exit=true;
            }else if(choiceSelected=='W'){
                System.out.println("Exit");
                exit=true;
            }else{
                System.out.println("Invalid input");
                choiceSelected  = v.getChoice("Press (N) to go North, (E) East, (S) South, (W) West", choices);
            }
        }
        return d;
    }
    public static void main(String[] args){
        House h = new House_ec22436();
        Visitor guy = new IOVisitor(System.out,System.in);
        h.visit(guy,Direction.FROM_SOUTH);
    }

}
