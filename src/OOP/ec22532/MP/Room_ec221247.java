package OOP.ec22532.MP;/* ***********************************
 Winchester Mystery House: Room_ec221247 by Bala Siva
 Student ID: 220349336
 Version 3 amended: 24 March 2023
 1. Visitor get or loss things according to their choice
 2. Visitors get gold coins if they have a pen otherwise they get a pen
 3. Visitor always take a right turn in this room
 ************************************ */


class Room_ec221247 extends Room {

    private boolean candleLight = true;
    final Item PEN = new Item("Pen");
    final Item SKETCH_BOOK = new Item("Sketch Book");
    final Item KEY = new Item("Key");

    public Direction visit(Visitor visitor, Direction arrivesFrom){

        int goldEarned = 0;
        Direction rDirection = Direction.opposite(arrivesFrom); // will be changed later
        char [] choices = {'a', 'b', 'c', 'd'};

        // tell about the room and the state it is in
        visitor.tell("\n   Welcome to the ART & CRAFT ROOM! \n §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");
        if(candleLight) visitor.tell("+++++   The room is bright. Thanks to candles. +++++");
        else visitor.tell("----- The room is dark -----");


        // Game 1: get choice
        visitor.tell("\nYou can");
        String options = "a: Open the cupboard\t b: Look inside the chest \t c: pull the drawer";
        if(candleLight) options += "\t d: blow out the candles";
        else options += "\t d: light candles";
        char choice = visitor.getChoice(options, choices);


        // give items according to visitors choices
        switch (choice){
            case 'a': {
                if(visitor.hasEqualItem(KEY) && candleLight){
                    visitor.giveGold(5);
                    goldEarned += 5;
                }
                else if(visitor.hasEqualItem(KEY)) {
                    visitor.tell("You have keys but you can't open the cupboard when it is dark");
                }
                else visitor.tell("You need keys to open the cupboard");
                break;
            }
            case 'b':{
                if(candleLight)
                    if(visitor.giveItem(PEN))
                        visitor.tell("Use your pen to earn gold");
                break;
            }
            case 'c': {
                if (candleLight)
                    if (visitor.giveItem(KEY))
                        goldEarned -= visitor.takeGold(1);
                break;
            }
            case 'd': {
                candleLight = !candleLight;
                break;
            }
            default:
                visitor.tell("Sorry, you lost your chance.");

        }


        // Game 2: present gift
        visitor.tell("\n Choose one gift:");
        options = "a: Pen\t b: Sketch book \t c: Key \t d: Gold:";
        choice = visitor.getChoice(options, choices);
        switch (choice){
            case 'a':
                if (visitor.giveItem(PEN))
                    visitor.tell("Collect pens to earn gold");
                break;
            case 'b':
                if (visitor.giveItem(SKETCH_BOOK))
                        visitor.tell("Happy drawing");
                break;
            case 'c':
                if (visitor.giveItem(KEY))
                    visitor.tell("This is a gift you don loose gold for keys this time");
                break;
            case 'd':
                visitor.giveGold(1);
                goldEarned += 1;
                break;
            default:
                visitor.tell("You dont earn any gift");
                break;
        }

     
        // Having pen earn gold
        if(visitor.hasEqualItem(PEN) && goldEarned>0) visitor.giveGold((10-goldEarned));

        // visitor always takes a right turn
        if(arrivesFrom == Direction.FROM_NORTH){ rDirection = Direction.TO_WEST; }
        else if(arrivesFrom == Direction.FROM_SOUTH){ rDirection = Direction.TO_EAST; }
        else if(arrivesFrom == Direction.FROM_EAST){ rDirection = Direction.TO_NORTH; }
        else if (arrivesFrom == Direction.FROM_WEST) { rDirection = Direction.TO_SOUTH; }

        // tell visitor where he/she heading
        visitor.tell(rDirection.toString());
        return rDirection;

    }
}
