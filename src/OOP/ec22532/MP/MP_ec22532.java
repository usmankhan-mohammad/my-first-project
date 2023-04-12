package OOP.ec22532.MP;

public class MP_ec22532 {

    public static void main(String[] args) {
        Visitable h = new House_ec22532();
        Visitor v = new GUIVisitor(System.out, System.in);
        h.visit(v, Direction.FROM_NORTH);
    }

}

//majority of mini project code is done in GUIVisitor
//program may bug if you click yes or no too fast
//could not implement a scrollbar in time, if the console is too full, it is editable, you can remove some text to make room
//had to slightly change visitor, the rooms and the houses to accomodate for certain changes