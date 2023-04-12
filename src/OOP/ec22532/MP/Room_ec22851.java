package OOP.ec22532.MP;

class Room_ec22851 extends Room
{//class start
static final Item is = new Item("infinty stones");
boolean TonyStarkAlive = true;
public Direction visit(Visitor m, Direction entrance){//visit start
        if (TonyStarkAlive == true){//if 1 start
        
            m.tell("The Avengers are fighting Thanos");
            m.tell("You have possessed TonyStark");
            m.tell("You are trying to snatch the infinity stones off of Thanos");
            m.tell("He then throws you away and turns around to see he lost the infinity stones");
            m.giveItem(is);
            if(m.hasEqualItem(is)){//if 2 start
            m.tell("You have a choice at hand");
            char choiceSelected = m.getChoice("Press A to kill Thanos or Press B to bring half of humanity back or Press C to do both", new char[]{'A','B','C'});

            if (choiceSelected == 'A'){//if 3 start
               m.tell("Congrats, you have killed Thanos, you died of bleeding");
             }//if 3 end 
            else if (choiceSelected == 'B'){
               m.tell("Well done, you have revived half of the humanity back but you died because hulk landed on you");
             }
            else if (choiceSelected == 'C'){
                 m.tell("Loki steals the infinty stones and revives Thanos and you die");
                }
                TonyStarkAlive=false;
                return Direction.TO_EAST;
                }//if 2 end
                 else{//else 2 start
        m.tell("You dont have the infinity stones and you die of bleeding");
        return Direction.TO_EAST;
        }//else 2 end
        }//if 1 end
        
                else{//else 1 start
                m.tell("The body of Tony Stark you possessed is dead and now you are going back to the portal");
                return Direction.TO_WEST;
        }//else 1 end
       }//visit end
}//class end
