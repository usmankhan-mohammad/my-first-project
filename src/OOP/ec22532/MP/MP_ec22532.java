package OOP.ec22532.MP;

public class A8_ec22532 {

    public static void main(String[] args) {
        Visitable r = new Room_ec22532();
        Visitor v = new GUIVisitor(System.out, System.in);
        r.visit(v, Direction.FROM_NORTH);
    }

}
