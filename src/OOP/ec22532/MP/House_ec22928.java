package OOP.ec22532.MP;

class House_ec22928 extends House {

    Room r1;
    Room r2;
    Room r3;
    Room r4;
    
    House_ec22928() {
        //create rooms
        r1 = new Room_ec22928();
        r2 = new Room_ec22830();
        r3 = new Room_ec22838();
        r4 = new Room_ec22628();
        
        
    }


    public Direction visit(Visitor v, Direction d)
    {
        int loc=1;
        char[] dir = {'n', 'e', 's', 'w'};
        v.tell("Welcome to the house");
        while (loc!=0)
        {
            if (loc==1){
                
                v.tell("You enter Room 1.");
                d = r1.visit(v,d);
                if (d == Direction.TO_EAST){
                    v.tell("You are going to Room 3");
                    loc=2;
                }
                else if (d == Direction.TO_SOUTH){
                    v.tell("You are going to Room 3");
                    loc=3;
                }
                else{
                    v.tell("You're stuck, try going another direction next time");
                }
            }
            else if (loc==2){
                
                v.tell("You enter Room 2.");
                d = r2.visit(v,d);
                if (d == Direction.TO_WEST){
                    v.tell("You are going to Room 1");
                    loc=1;
                }
                else if (d == Direction.TO_SOUTH){
                    v.tell("You are going to Room 4");
                    loc=4;
                }
                else{
                    v.tell("You're stuck, try going another direction next time");
                }
            }
            else if (loc==3){
                
                v.tell("You enter Room 3.");
                d = r3.visit(v,d);
                if (d == Direction.TO_EAST){
                    v.tell("You are going to Room 4");
                    loc=4;
                }
                else if (d == Direction.TO_NORTH){
                    v.tell("You are going to Room 1");
                    loc=1;
                }
                else{
                    v.tell("You're stuck, try going another direction next time");
                }
            }
            
            else if (loc==4){
                
                v.tell("You enter Room 4.");
                d = r4.visit(v,d);
                if (d == Direction.TO_WEST){
                    v.tell("You are going to Room 3");
                    loc=3;
                }
                else if (d == Direction.TO_NORTH){
                    v.tell("You are going to Room 2");
                    loc=2;
                }
                else if (d == Direction.TO_SOUTH){
                    //leaves the house from room 4 
                    loc=0;
                }
                
                else{
                    v.tell("You're stuck, try going another direction next time");
                }
            }
        }
        v.tell("You are leaving the house!");
        return d;

    }
    
    public static void main(String[] args){
        House h= new House_ec22928();
        Visitor g= new IOVisitor(System.out,System.in);
        h.visit(g,Direction.FROM_SOUTH);
    }
    
}

