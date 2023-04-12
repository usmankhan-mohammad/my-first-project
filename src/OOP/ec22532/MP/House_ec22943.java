package OOP.ec22532.MP;

class House_ec22943 extends House
{
    private Room northRoom;
    private Room eastRoom;
    private Room westRoom;
    private Room southRoom;

    House_ec22943() 
    {
        northRoom = new Room_ex21247();
        eastRoom = new Room_ec22798();
        westRoom = new Room_ec22943();
        southRoom = new Room_ec22740();
    }

    public Direction visit(Visitor v, Direction d)
    {
        boolean inHouse = true;

        v.tell("Welcome to House_ec22943");

        while (inHouse)
        {
            v.tell("You have now entered the house and are in the hallway. There are four rooms with three doors which lead to the west, south, north and east. ");

            char[] roomOptions = {'W', 'N', 'E','S', 'L'};

            char corridor = v.getChoice("Would you like to enter the (W)est, (S)outh, (E)ast or N)orth room, or (L)eave the house", roomOptions);

            Boolean northRoomVisit = false;

            if (corridor == 'N')
            {
                northRoomVisit = true;
                d = northRoom.visit(v, d);
            }
            else if (corridor == 'W')
            { 
                if (northRoomVisit)
                {
                    d = westRoom.visit(v, d);
                }
                else if (!northRoomVisit)
                {
                    d = westRoom.visit(v, d);
                }
                else
                {
                    v.tell("Error");
                }
            }
            else if (corridor == 'E')
            {
                d = eastRoom.visit(v, d);
            }
            else if (corridor == 'S')
            {
                d = southRoom.visit(v, d);
            }
            else if (corridor == 'L')
            {
                v.tell("You have now left the house.");
                inHouse = false;
            }
            else
            {
                v.tell("Error. Try Again");
            } 
        }
        return d;
    }
}
