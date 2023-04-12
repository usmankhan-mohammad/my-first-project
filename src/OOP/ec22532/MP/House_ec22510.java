package OOP.ec22532.MP;

class House_ec22510 extends House {
    Room e;
    Room s;
    Room j;
    public House_ec22510()
    {
        e= new Room_ec22510();
        s = new Room_ec22522();
        j = new Room_ec22952();
    }
    public Direction visit(Visitor v, Direction d){
        v.tell("");
        v.tell("");
        boolean set = true;
        char[] op = {'n','w','e'};
        char[] op2 = {'y','n'};
        char choice;
        char cho1;
        while(set){
            choice = v.getChoice("Which room would you like to go to?(n) or (w) or (e)",op);
            switch (choice)
            {
                case 'n':
                    v.tell("entering north room.....");
                    e.visit(v,d.TO_NORTH);
                    break;
                case 'w':
                    v.tell("entering west room.....");
                    s.visit(v,d.TO_WEST);
                    break;
                case 'e':
                    v.tell("entering east room.....");
                    j.visit(v,d.TO_EAST);
                    break;
            }
            cho1 = v.getChoice("Would you like to leave? Yes(y) or No(n)",op);
            switch (cho1)
            {
                case 'y':
                    v.tell("GOODBYE!!!!");
                    set = false;
                    break;
                case 'n':
                    v.tell("well ok then...");
                    break;
            }
        }
        return Direction.opposite(d);
    }
}
 
