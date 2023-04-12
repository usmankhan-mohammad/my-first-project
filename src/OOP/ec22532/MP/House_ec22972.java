package OOP.ec22532.MP;

class House_ec22972 extends House {
    Room room1;
    Room room2;
    
    House_ec22972(){
        room1 = new Room_ex21247();
        room2 = new Room_ec22632();
    }
    
    public Direction visit(Visitor v, Direction d){
        v.tell("You have entered the house!");
        
        int pos = 1;
        
        while(pos != 0){
            if(pos == 1){
                d = room1.visit(v, d);
                if(d == Direction.TO_NORTH){
                    v.tell("You are entering a mysterious room...");
                    pos = 2;
                }
            }
            else if(pos == 2){
                d = room2.visit(v, d);
                if(d == Direction.TO_SOUTH){
                    v.tell("You are entering a mysterious room...");
                    pos = 1;
                }
                else if(d == Direction.TO_EAST){
                    pos = 0;
                }
            }
        }
        v.tell("You are exiting the House!");
        return d;
    }
    
    public static void main(String[] args) {
        House h = new House_ec22972();
        Visitor guy = new IOVisitor(System.out,System.in);
        h.visit(guy,Direction.FROM_SOUTH);
    }
}
