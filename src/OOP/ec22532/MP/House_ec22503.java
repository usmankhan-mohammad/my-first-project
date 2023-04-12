package OOP.ec22532.MP;

class House_ec22503 extends House {

    Room r1;
    Room r2;
    Room r3;
    boolean close;

    House_ec22503() {

        r1 = new Room_ec22503();
        r2 = new Room_ec22569();
        r3 = new Room_ec22562();

    }

    public Direction visit(Visitor visitor, Direction direction) {
        char choices_yn = '0'; // get users choice yes or no (sub choices)
        char choices_la = '0'; // get users choice the letters (main choices)
        close = false; // default

        char[] visitorChoiceLa = { 'a', 'b', 'c', }; // create char array for letters options
        char[] visitorChoiceYn = { 'Y', 'N' }; // create char array for yes and no options

        while (!close) {

            direction = r1.visit(visitor, direction); // start my room

            choices_la = visitor.getChoice(
                    " You're out of the room do you want a) go to anthore room b) look around c) leave the house ",
                    visitorChoiceLa); // the hallway

            if (choices_la == ('a')) {

                direction = r3.visit(visitor, direction); // visting room 3

            }

            else if (choices_la == ('b')) {

                visitor.tell(" It's such an old house, with alot of mistries don't you think that ?");

                choices_la = visitor.getChoice(" don yo want a) go to anthore room or b) leave the house ? ",
                        visitorChoiceLa); // the hallway

                if (choices_la == ('a')) {

                    direction = r2.visit(visitor, direction); // visting room 2

                }

                else {
                    close = true; // close is true, leave the house

                    break;
                }
            }

            if (choices_la == ('c')) { // close is true, leave the house
                close = true;

                break;

            }

        }
        return direction;

    }
}
