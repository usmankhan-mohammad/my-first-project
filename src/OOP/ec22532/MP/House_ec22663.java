package OOP.ec22532.MP;

// adapted from adams code
class House_ec22663 extends House { 
    
    Room r1; 
    Room r2;
    
    House_ec22663() { 
        r1 = new Room_ec22599();
        r2 = new Room_ec22425();
    }
    
    public Direction visit(Visitor v, Direction d) { 
        char options[] = {'a', 'b', 'c'}; 
        
        v.tell("Ahoy there, brave adventurer!");
        v.tell("Welcome to this mysterious house, where there's plenty of secrets and surprises waiting for you.");
        
        int location = 1; 
        
        while(location != 0) { 
            if (location == 1) { 
                d = r1.visit(v,d);
                if (d == Direction.TO_NORTH) { 
                    v.tell("You have entered room 1");
                    location = 2;
                }
            }
            else if (location == 2) { 
                d = r2.visit(v,d);
                if (d == Direction.TO_SOUTH) { 
                    v.tell("You have entered room 1");
                    location = 1; 
                }
                else if(d == Direction.TO_EAST) { 
                    location = 3;
                }
            }
            else if (location == 3) { 
                
            }
        }
                
        return d;
    }
    
    public static void main(String[] args) { 
        House h = new House_ec22663(); 
        Visitor man = new IOVisitor(System.out,System.in); 
        h.visit(man,Direction.FROM_SOUTH);
    }
}
