package OOP.ec22532.MP;

class Room_jpp335448 extends Room {
    
    public Direction visit(Visitor v, Direction d) {
        Boolean goblin = false;
        Boolean lights = false;
        char[] choices = {'Y', 'N'};
        char[] options = {'r', 'l', 'm'};
        Item goldenHammer = new Item("Golden Hammer");
        
        v.tell("Here is some gold you can have with your travel");
        v.giveGold(10);
        
        if (lights == false){
            v.tell("You have to spend some gold on our oil!");
            char light = v.getChoice("Do you want to spend your gold on light?", choices);
            if (light == 'Y'){
                v.takeGold(1);
                lights = true;
            }else if (light == 'N'){
                v.tell("Nothing happened");
                lights = false;
            }
        }
        v.tell("There are 3 choices you can make in this room");
        char roomchoice = v.getChoice("Which way would you choose?", options);
        
        if (roomchoice == 'r'){
            if (goblin == true){
                v.tell("Goblin took your gold");
                v.takeGold(1);
                goblin = false;
            }
            else if (goblin == false){
                v.tell("You found 1 gold");
                v.giveGold(1);
            }
        }
        else if (roomchoice == 'l'){
            v.tell("You found 5 gold!");
            v.giveGold(5);
        }
        else if (roomchoice == 'm'){
            v.tell("You found an item to kill the goblin");
            v.giveItem(goldenHammer);
            char kill = v.getChoice("Do you want to kill the goblin?", choices);
            if(kill == 'Y'){
                v.tell("You are a hero!");
                v.giveGold(1);
                
            }
            else if (kill == 'N'){
                v.tell("The goblin shares its fortune with you");
                v.giveGold(3);
            }
        }
       
        v.tell("You return to the starting point");
        return Direction.opposite(d);
    }
}
