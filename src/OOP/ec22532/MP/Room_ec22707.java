package OOP.ec22532.MP;

import java.util.Random;

class Room_ec22707 extends Room {
    static final Item glowingOrb = new Item("Glowing Orb");
    static final Item enchantedCollar = new Item("Enchanted Collar");

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(5)+1;
        int randomNumber2 = rand.nextInt(5)+1;
        int rpsChoice =rand.nextInt(3)+1;
        char[] possibleChoices = {'y', 'n'};
        char[] rockPaperScissors = {'r', 'p', 's'};
        char laplusRPS;
        String laplusRPSFinal;
        visitor.tell("Welcome to Laplus's Den");
        if(randomNumber==randomNumber2){
            visitor.tell("Today is your lucky day, the lord of darkness is at home.");
            visitor.tell("She approaches you and challenges you to a game of rock, paper, scissors.");
            char choice = visitor.getChoice("Do you accept? (y/n)", possibleChoices);
            if (choice == 'y') {
                visitor.tell("ROCK! PAPER! SCISSORS!");
                char userRPS = visitor.getChoice("What are you going to choose? (r/p/s)", rockPaperScissors);
                if(rpsChoice==1){
                    laplusRPS = 'r';
                    laplusRPSFinal = "rock";
                } else if (rpsChoice==2) {
                    laplusRPS = 'p';
                    laplusRPSFinal = "paper";
                } else {
                    laplusRPS = 's';
                    laplusRPSFinal = "scissors";
                }
                if (userRPS==laplusRPS) {
                    visitor.tell("Laplus throws " + laplusRPSFinal);
                    visitor.tell("It's a tie.");
                    visitor.tell("Laplus is surprised you can hold up to her power level.");
                    visitor.tell("She gives you a gift.");
                    visitor.giveItem(enchantedCollar);
                } else if (userRPS=='p' && laplusRPS=='r' || userRPS=='r' && laplusRPS=='s' || userRPS=='s' && laplusRPS=='p') {
                    visitor.tell("Laplus throws " + laplusRPSFinal);
                    visitor.tell("You have won!");
                    visitor.tell("Laplus is surprised you can hold up to her power level.");
                    visitor.tell("She gives you a gift and some gold, lucky!");
                    visitor.giveItem(enchantedCollar);
                    visitor.giveGold(3);
                } else {
                    visitor.tell("Laplus throws " + laplusRPSFinal);
                    visitor.tell("You have lost!");
                    visitor.tell("hahahaha - she laughs in your face and tells you to pay up");
                    visitor.takeGold(3);
                }
            } else if (choice == 'n') {
                visitor.tell("She throws a tantrum!");
                visitor.tell("Consider yourself lucky that she hasn't killed you.");
                visitor.takeGold(3);
            }
        } else {
            visitor.tell("Laplus doesn't seem to be home. \nYou look around and find her companion, a crow. \nYou feel a sense of unease.");
            char itemPickup = visitor.getChoice("Would you like to talk to the crow? (y/n)", possibleChoices);
            if (itemPickup == 'y') {
                visitor.giveItem(glowingOrb);
                visitor.giveGold(3);
                visitor.tell("You talk to the crow and it offers you a gift");
            } else if (itemPickup == 'n') {
                visitor.tell("It seems that the crow is angry");
                visitor.tell("You notice that your pockets have gotten lighter");
                visitor.takeGold(3);
            }
        }
        return Direction.opposite(directionVistorArrivesFrom);
    }
}
