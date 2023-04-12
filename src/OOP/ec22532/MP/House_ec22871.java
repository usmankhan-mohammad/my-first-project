package OOP.ec22532.MP;

class House_ec22871 extends House {
    //three rooms including mine taken from contributions
    Room room1=new Room_ec22871();
    Room room2=new Room_ec22858();
    Room room3=new Room_ec22862();
    
    public Direction visit(Visitor vis, Direction d){
        vis.tell("Welcome to Varey House- the most terrifying place you could ever imagine! You walk inside to slowly enter the first room...");
        d=room1.visit(vis, d);
        if(d==Direction.TO_NORTH||d==Direction.TO_EAST){
            vis.tell("You move on to the second chamber through a cold, humid corridor...");
            d=room2.visit(vis, d);
            vis.tell("Frightened, you almost trip while escaping to the final room...");
            d=room3.visit(vis, d);
        }
        else{
            vis.tell("You feel the water dripping onto your shoulders as you move on to the second chamber...");
            d=room3.visit(vis, d);
            vis.tell("That was a close one! Determined, yet fatigued, you make your way to the final room...");
            d=room2.visit(vis, d);
        }
        return d;
    }
}
