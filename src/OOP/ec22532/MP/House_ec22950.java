package OOP.ec22532.MP;

public class House_ec22950 extends House {
    
    Room baseRoom;
    Room attic;
    boolean completeVisit;

    House_ec22950()
    {
        baseRoom = new Room_ec22413();
        attic = new Room_ec22948();
        completeVisit =  false;
    }

    static void garden(Visitor visitor, Direction left)
    {
        boolean enterGarden = true;
        visitor.tell("You have entered the gardern from the " + left);

        while (enterGarden == true)
        {
            visitor.tell("You are in the garden");
            visitor.tell("1. Return to room");
            visitor.tell("2. Have a look around");
            visitor.tell("3. Enter the house from the back");

            char[] actionTaken = {'1','2','3'};
            char toDo = visitor.getChoice("What will you do?", actionTaken);

            if (toDo == '1')
            {
                visitor.tell("The room is locked from the outside");
            }
            else if (toDo == '2')
            {
                visitor.tell("You find nothing");                
            }
            else if (toDo == '3')
            {
                visitor.tell("You enter the house from the back"); 
                enterGarden = false;               
            }
            else
            {
                visitor.tell("What are you thinking");
            }
        }   
    }

    public Direction visit(Visitor visitor, Direction direction)
    {
        visitor.tell("You have just woken up and you find yourself in a house mysterious house");
      
        while (completeVisit == false)
        {
            visitor.tell("You are in the middle of the house");
            visitor.tell("1. There is a room on the left");
            visitor.tell("2. There is an exit ahead");
            visitor.tell("3. There is a room on the right");

            char[] whereToGo = {'1','2','3'};
            char toGo = visitor.getChoice("Where will you go", whereToGo);

            if (toGo == '1')
            {
                Direction enter = Direction.FROM_WEST;
                Direction left = baseRoom.visit(visitor, enter);
                if (left != (Direction.TO_WEST))
                {
                    garden(visitor, left);
                }
            }
            else if (toGo == '2')
            {
                completeVisit = true;
            }
            else if (toGo == '3')
            {
                Direction enter = Direction.FROM_EAST;
                Direction left = attic.visit(visitor, enter);
                if (left != (Direction.TO_EAST))
                {
                    garden(visitor, left);
                }
            }
            else
            {
                visitor.tell("What are you thinking");
            }
        }

        visitor.tell("You leave the house in the direction you came from");
        return direction;
    }
}
