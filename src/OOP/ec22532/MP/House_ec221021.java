package OOP.ec22532.MP;

class House_ec221021 extends House {
    
    // Room R_One;
    Room R_Two;
    Room R_Three;
    Room R_Four;
    
    House_ec221021() {
  
        R_Two = new Room_ec221021();
        R_Three = new Room_ec221006();
        R_Four = new Room_ec22587();

        }
    
    public Direction visit(Visitor vis, Direction dir) {
            char[] options = {'b','c','d'};

            vis.tell("You enter a an alley. Now, you can decide either you can go North or South or East or West.");
        char choice = vis.getChoice(" South (b), East(c), West(d)?", options);

       
        
         if(choice == 'b') {
                dir = R_Two.visit(vis, Direction.TO_SOUTH);
            }

        else if (choice == 'c'){
            dir = R_Three.visit(vis, Direction.TO_EAST);
        }

        else if (choice == 'd'){
            dir = R_Four.visit(vis, Direction.TO_WEST);
        }

            
        return Direction.opposite(dir); //new
    }
    
    public static void main (String [] args){
        //
    }
}
