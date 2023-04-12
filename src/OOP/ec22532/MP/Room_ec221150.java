package OOP.ec22532.MP;

class Room_ec221150 extends Room {

    public Direction visit(Visitor v, Direction d) {

        //declare a direction variable to return later
        Direction rDirection = d;
        
        //Item that may be used by friends
        final Item Pen = new Item("Pen"); 

        //states of the room
        boolean lights = false;

        char[] options = {1, 2};

        //tells visitor about the room and state it is in
        v.tell("You have entered Cengiz's room!");
        v.tell("You will get 1 gold for entering this room. That can be used to play a game." +
                "\nIf you play at least 1 game you can choose your leaving direction" +
                " If you lose all of your golds you will be kicked out of the room.");
        v.giveGold(2);

        if (!lights)
            v.tell("Lights are off switch them on to continue and don't forget to switch off when you leave");
        char a1 = v.getChoice("1. Turn lights on " +
                "\n2. Leave the room", options);
        if (a1 == '1') lights = true;
        
        
        switch (a1) {
            //if lights on describe the game
            case '1':
                v.tell("Game 1: There are 2 boxes in front of you," +
                        " \none of them has a ball inside. If you find the ball you will earn 2 golds and a pen,\nif you can't you lose 1 gold.");
                char a2 = v.getChoice("1. Play \n2. Leave the room",options);
                
                //if user choose to play
                if(a2=='1') {
                    int box1 = (int) (Math.random() * 2) + 1;
                    String b1 = "";
                    if (box1 == 1) b1 = "Red box";
                    else if (box1 == 2) b1 = "Blue box";
                    //ANSWER CAN BE PRINTED BY ACTIVATING THE COMMENT BELOW FOR TESTING
                    //System.out.println("ball is in " + b1);

                    char q1 = v.getChoice("1. Red box \n2. Blue box", options);
                    int answer1 = Integer.parseInt(String.valueOf(q1));
                    if (box1 == answer1) {
                        v.tell("Congratulations! The ball was in the " + b1);
                        v.giveGold(2);

                        // check if visitor already has a pen, if yes continue, if no give them a pen
                        if (!v.hasEqualItem(Pen)) v.giveItem(Pen);

                        v.tell("\nGame 2: There are 3 boxes this time, If you find the ball you will earn 3 golds," +
                                "\nif you can't find you lose 2 golds");

                        char a4 = v.getChoice("1. Play \n2. Leave the room", options);

                        if (a4 == '1') {
                            int box2 = (int) (Math.random() * 3) + 1;
                            String b2 = "";
                            if (box2 == 1) b2 = "Red box";
                            else if (box2 == 2) b2 = "Blue box";
                            else if (box2 == 3) b2 = "Green box";
                            //ANSWER CAN BE PRINTED BY ACTIVATING THE COMMENT BELOW FOR TESTING
                            //System.out.println("ball is in " + b2);
                            char q2 = v.getChoice("1. Red box \n2. Blue box \n3. Green box", new char[]{1, 2, 3});
                            int answer2 = Integer.parseInt(String.valueOf(q2));
                            if (box2 == answer2) {
                                v.tell("Congratulations! The ball was in the " + b2);
                                v.giveGold(3);

                                v.tell("\nGame 3: There are 3 boxes again, If you find the ball you will earn 4 golds," +
                                        "\nif you can't find you lose 2 golds");
                                char a5 = v.getChoice("1. Play \n2. Leave the room", options);

                                if (a5 == '1') {
                                    int box3 = (int) (Math.random() * 3) + 1;
                                    String b3 = "";
                                    if (box3 == 1) b3 = "Red box";
                                    else if (box3 == 2) b3 = "Blue box";
                                    else if (box3 == 3) b3 = "Green box";
                                    //ANSWER CAN BE PRINTED BY ACTIVATING THE COMMENT BELOW FOR TESTING
                                    //System.out.println("ball is in " + b3);
                                    char q3 = v.getChoice("1. Red box \n2. Blue box \n3. Green box", new char[]{1, 2, 3});
                                    int answer3 = Integer.parseInt(String.valueOf(q3));
                                    if (box3 == answer3) {
                                        v.tell("Congratulations! The ball was in the " + b3);
                                        v.giveGold(4);

                                        v.tell("You won maximum amount of gold (10) in this room!");
                                    } else {
                                        v.tell("The ball was in the " + b3);
                                        v.takeGold(2);
                                    }

                                } else {
                                    v.tell("The ball was in the " + b2 + ", better luck next time!");
                                    v.takeGold(2);

                                }
                            } else {
                                v.tell("The ball was in the " + b1 + ", better luck next time!");
                                v.takeGold(2);
                            }
                        }
                        
                            //user can choose a direction to leave after playing at least 1 game
                            v.tell("\nChoose a leaving direction: ");
                            char dir = v.getChoice("1. North \n2. East \n3. South \n4. West", new char[]{1, 2, 3, 4});
                            switch (dir) {
                                case '1':
                                    rDirection = Direction.TO_NORTH;
                                    v.tell("You're heading north exit");
                                    break;
                                case '2':
                                    rDirection = Direction.TO_EAST;
                                    v.tell("You're heading east exit");
                                    break;
                                case '3':
                                    rDirection = Direction.TO_SOUTH;
                                    v.tell("You're heading south exit");
                                    break;
                                case '4':
                                    rDirection = Direction.TO_WEST;
                                    v.tell("You're heading west exit");
                                    break;
                            }
                            return rDirection;

                    }
                    break;
                }
                else {
                    //give user option to turn the lights off
                    char ans3 = v.getChoice("1.Turn lights off \n2.Leave lights on", options);
                    if (ans3 == '1') lights = false;
                    
                    //if lights left on take 2 gold from user
                    if (lights) {
                        v.tell("You have left the lights on, that cost you 2 golds");
                        v.takeGold(2);
                    }
                }
                
                //if user choose to leave from the beginning, running this code
                case '2':
                    
                    v.tell("\nYou're leaving the room with a random direction");
    
                    // generate a random leaving direction
                    int randN2 = (int) (Math.random() * 4) + 1;
    
                    if (randN2 == 1) {
                        rDirection = Direction.TO_NORTH;
                        v.tell("You're heading north exit");
                    }
    
                    if (randN2 == 2) {
                        rDirection = Direction.TO_EAST;
                        v.tell("You're heading east exit");
                    }
                    if (randN2 == 3) {
                        rDirection = Direction.TO_SOUTH;
                        v.tell("You're heading south exit");
                    }
                    if (randN2 == 4) {
                        rDirection = Direction.TO_WEST;
                        v.tell("You're heading west exit");
                    }
                    break;
        }
        return rDirection;
    }
}
