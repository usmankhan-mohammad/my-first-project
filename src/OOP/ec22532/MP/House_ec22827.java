package OOP.ec22532.MP;

import java.beans.Visibility;

public class House_ec22827 extends House {

    Room Room1;
    Room Room2;
    Room Room3;

    House_ec22827(){


        this.Room1 = new Room_ec22479();
        this.Room2 = new Room_ec22496();
        this.Room3 = new Room_ec22827();


    }

    public Direction visit(Visitor v, Direction d){

        v.tell("Welcome to this boring house.");
        v.tell("Have some gold since i'm a nice guy. ");
        v.giveGold(5);

        char [] directions = {'n' , 's' , 'w' , 'e'};

        char choice1 = v.getChoice("Chose which direction to go to: n for north, s for south, w for west and e for east", directions);
        boolean exit = false;

        while (exit==false){

            switch (choice1){

                case 'n':
                    v.tell("Ok, South, got it");
                    v.tell("Have some more gold since i'm a nice guy. ");
                    v.giveGold(5);
                    Room3.visit(v, Direction.FROM_SOUTH);


                case 's':
                    v.tell("Ok, North, got it");
                    v.tell("Take this, hope it helps you!");
                    final Item beanie = new Item("Beanie");
                    v.giveItem(beanie);
                    Room1.visit(v, Direction.FROM_NORTH);


                case 'e':
                    v.tell("Ok, west got it");
                    v.tell("Taking the gold back i don't feel nice anymore");
                    v.takeGold(5);
                    Room3.visit(v, Direction.FROM_WEST);

                case 'w':
                    v.tell("That was the exit goodbye");
                    exit = true;
                    return d;
                    
                    
            }
        }
        
        return d;
    }
    
}
