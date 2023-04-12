package OOP.ec22532.MP;

class Room_ec22598 extends Room
{ 
    static boolean vault_open = false;
    static Item my_map = new Item("ec22598's map");
    public Direction visit(Visitor v, Direction d) 
    {
        v.tell("you entered ec22598's room");
        char choice = v.getChoice("Would you like to look inside the vault?", new char[]{'y', 'n'});
       
        if(choice == 'y')
        {
            v.tell("high risk, high reward") ;  
            if (!vault_open)
            {
                v.tell("you just found a compass and ec22598's map") ;
                choice = v.getChoice("You can only choose one (c or m)", new char[]{'m', 'c'});
                          
                if(choice == 'c') 
                { 
                    v.giveItem(new Item("compass"));
                    v.takeGold(3); 
                    v.tell("no luck today for gold but with your compass where would you like to exit (N or S)? ") ;
                    choice = v.getChoice("You can only choose one (N or S)", new char[]{'S', 'N'});
                    if (choice == 'N') 
                    {
                        return Direction.TO_NORTH;    
                    }
                    else if (choice == 'S') 
                    {
                        return Direction.TO_SOUTH;
                    } 
                }
                else if(choice == 'm')
                { 
                    if (!v.hasEqualItem(my_map))
                    {
                        v.giveItem(my_map);
                        v.tell("you just took ec22598's map + 3 gold");
                    }
                    else if (v.hasIdenticalItem(new Item("map")))
                    {
                        v.tell("item already obtained");
                    }
                    v.giveGold(3);
                }
                
            }
        } 
        else if(choice == 'n')
        { 
            v.tell("no risk, no reward"); 
            v.takeGold(5);
        } 
        return Direction.opposite(d);
   }
}
