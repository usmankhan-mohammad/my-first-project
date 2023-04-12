package OOP.ec22532.MP;

import java.util.Random;

/*House has hallway in the middle row and middle column. It also has 'wrap-around' topology in which leaving an East-most room to the East takes the visitor back round to entering a West-most room from the West. 
To leave the house visitor must reach to hallway and choose to leave.
Rooms are stable during the game, however, they will be shuffled for the next game.
Visitor is represented with 'V' on the map.

*/
class House_ec221150 extends House {
        
    public static void main (String[]args) {
    House h = new House_ec221150();
    Visitor v = new IOVisitor(System.out,System.in);
    h.visit(v, Direction.FROM_NORTH);
    }
    
    static Visitable toVisit;
    static Room r;
    
    static final int maxRow = 7; //number of rows in house
    static final int maxColumn = 7; //number of columns in house
    static final int hallwayRow = 3; // row index of hallway
    static final int hallwayColumn = 3; // column index of hallway
    static Room hallway;

    int[] location = new int[]{randomInt(),randomInt()}; //start from a random point that is not hallway

    //Room grid
    static final Room[][] roomIndex = new Room[maxRow][maxColumn]; // 6 rows and 6 columns for rooms. 1 row and 1 column for hallway (+ shaped in the middle)
    
    static class MyVisitor implements Visitor {
        Visitor v;
        Location l;
        MyVisitor(Visitor v, int[] loc) {
            this.v = v;
            this.l = new Location(loc[0],loc[1]);
            }
        
            static class Location{
                int x ;
                int y ;

                //constructor
                Location(int r, int c){
                    this.x=r;
                    this.y=c;
                }

                //calculate next location
                private void nextLoc(Location l, Direction d){

                if(d==Direction.TO_SOUTH){
                    l.x = l.x+1;
                    if(l.x==maxRow){
                        l.x=0;
                        System.out.println("\n[ You walked to North-end side of the house through garden ]");
                    }
                }
                if(d==Direction.TO_NORTH){
                    l.x = l.x-1;
                    if(l.x==-1){
                        l.x=maxRow-1;
                        System.out.println("\n[ You walked to South-end of the house through garden ]");
                    }
                }
                if(d==Direction.TO_EAST){
                    l.y = l.y+1;
                    if(l.y==maxColumn){
                        l.y=0;
                        System.out.println("\n[ You walked to West-end of the house through garden ]");
                    }
                }
                if(d==Direction.TO_WEST){
                    l.y = l.y-1;
                    if(l.y==-1){
                        l.y=maxColumn-1;
                        System.out.println("\n[ You walked to East-end of the house through garden ]");
                    }
                }
                    r = roomIndex[l.x][l.y];
                    if(l.x!=3 && l.y!=3){
                        toVisit = r;
                    }
                }//end nextLoc
            
                private void rUpdate(Location l){
                r = roomIndex[l.x][l.y];
                toVisit = r;
                }//end rUpdate
            
            }//end Location class
        
        public void tell (String s) {v.tell(s);}
        public int takeGold(int n) {return v.takeGold(n);}
        public void giveGold(int n){v.giveGold(n);}
        public boolean hasEqualItem(Item x){return v.hasEqualItem(x);}
        public boolean hasIdenticalItem(Item x){return v.hasIdenticalItem(x);}
        public boolean giveItem(Item x){return v.giveItem(x);}
        public char getChoice(String s,char[] arr){return v.getChoice(s,arr);}
    }//end MyVisitor class
    
    
    public Direction visit(Visitor realVisitor, Direction d) {

        MyVisitor v = new MyVisitor(realVisitor,location);
        v.l.rUpdate(v.l);

        
        boolean leave = false;
        v.tell("\n\n[ You have entered a House containing 36 rooms ]");
        
          while(!leave){
              
            tellLoc();
              
            if(r!=hallway){
                v.tell("\n[ You are entering the room  " + roomIndex[v.l.x][v.l.y] +" ]");
                delay(v);
                d = toVisit.visit(v, d);
                v.tell("[ You just left the Room contributed by "+roomIndex[v.l.x][v.l.y]+" "+d+". ]");
                v.l.nextLoc(v.l, d);
            }
        
            //hallway cases
            while(r==hallway && !leave){
                
                v.tell("\n[ Choose what to do next ]");
                char c1 = v.getChoice("1. Go forward \n2. Look around for other rooms \n3. Leave the house", new char[]{1,2,3});

                switch (c1) {

                    //continue same direction
                    case '1':
                        v.tell("[ You chose to go forward ]");
                        v.l.nextLoc(v.l, d);
                        tellLoc();
                        if (r != hallway) {
                            v.tell("\n[ You are entering the Room " + roomIndex[v.l.x][v.l.y] + " ]");
                            delay(v);
                            toVisit = r;
                            d = toVisit.visit(v, d);
                            v.tell("\n[ You just left the Room " + roomIndex[v.l.x][v.l.y] + " " + d + ". ]");
                            v.l.nextLoc(v.l, d);
                        }
                        break;

                    //walk to anywhere in the house
                    case '2':
                        v.tell("[ You chose to look around for other rooms ]");
                        tellLoc();
                        v.tell("[ Choose which way to go ]");
                        final String A = "1. Rooms in the North-West of the house";
                        final String B = "2. Rooms in the North-East of the house ";
                        final String C = "3. Rooms in the South-West of the house ";
                        final String D = "4. Rooms in the South-East of the house";
                        char c2 = v.getChoice("\n" + A + "\n" + B + "\n" + C + "\n" + D, new char[]{1, 2, 3, 4});
                        int randN;
                        switch (c2) {
                            case '1': {
                                randN = (int) (Math.random() * 3);
                                v.l.x = randN;
                                randN = (int) (Math.random() * 3);
                                v.l.y = randN;
                                v.tell("\n[ You are entering the room " + roomIndex[v.l.x][v.l.y] + " ]");
                                delay(v);
                                d = toVisit.visit(v, d);
                                v.tell("\n[ You just left the Room " + roomIndex[v.l.x][v.l.y] + " " + d + ". ]");
                                v.l.nextLoc(v.l, d);
                                break;
                            }

                            case '2': {
                                randN = (int) (Math.random() * 3);
                                v.l.x = randN;
                                randN = (int) (Math.random() * 3) + 4;
                                v.l.y = randN;
                                v.tell("\n[ You are entering the room " + roomIndex[v.l.x][v.l.y] + " ]");
                                delay(v);
                                d = toVisit.visit(v, d);
                                v.tell("\n[ You just left the Room " + roomIndex[v.l.x][v.l.y] + " " + d + ". ]");
                                v.l.nextLoc(v.l, d);
                                break;
                            }

                            case '3': {
                                randN = (int) (Math.random() * 3) + 4;
                                v.l.x = randN;
                                randN = (int) (Math.random() * 3);
                                v.l.y = randN;
                                v.tell("\n[ You are entering the room " + roomIndex[v.l.x][v.l.y] + " ]");
                                delay(v);
                                d = toVisit.visit(v, d);
                                v.tell("\n[ You just left the Room " + roomIndex[v.l.x][v.l.y] + " " + d + ". ]");
                                v.l.nextLoc(v.l, d);
                                break;
                            }

                            case '4': {
                                randN = (int) (Math.random() * 3) + 4;
                                v.l.x = randN;
                                randN = (int) (Math.random() * 3) + 4;
                                v.l.y = randN;
                                v.tell("\n[ You are entering the room " + roomIndex[v.l.x][v.l.y] + " ]");
                                delay(v);
                                d = toVisit.visit(v, d);
                                v.tell("\n[ You just left the Room " + roomIndex[v.l.x][v.l.y] + " " + d + ". ]");
                                v.l.nextLoc(v.l, d);
                                break;
                            }
                            default: {
                                randN = (int) (Math.random() * 6);
                                v.l.x = randN;
                                randN = (int) (Math.random() * 6);
                                v.l.y = randN;
                                tellLoc();
                                v.tell("\n[ You are entering the room " + roomIndex[v.l.x][v.l.y] + " ]");
                                delay(v);
                                d = toVisit.visit(v, d);
                                v.tell("\n[ You just left the Room " + roomIndex[v.l.x][v.l.y] + " " + d + ". ]");
                                v.l.nextLoc(v.l, d);
                                break;
                            }
                        }
                        break;
                    //leave the house option
                    case '3':
                        leave = true;
                        break;
                    default:
                        v.tell("[ Invalid choice, you are continuing same direction ]");
                        v.l.nextLoc(v.l, d);
                        if (r != hallway) {
                            v.tell("\n[ You are entering the room " + r + " ]");
                            delay(v);
                            toVisit = r;
                            d = toVisit.visit(v, d);
                            v.tell("\n[ You just left the Room " + r + " " + d + ". ]");
                            v.l.nextLoc(v.l, d);
                        }
                        break;
                }//end hallway cases
            }//end hallway
              
              //if not hallway visit next room then go back to loop
              if(r!=hallway){
                  
                    tellLoc();
                    v.tell("\n[ You are entering the room " + r+" ]");
                    delay(v);
                    toVisit = r;
                    d = toVisit.visit(v, d);
                    v.tell("\n[ You just left the Room "+r+" "+d+". ]");
                  v.l.nextLoc(v.l, d);
              }
                  
          }//end while (in house)

        //Leave direction from the house
        v.tell("\nChoose a leaving direction: ");
        char dir = v.getChoice("1. North \n2. East \n3. South \n4. West", new char[]{1, 2, 3, 4});
        switch (dir) {
            case '1':
                d = Direction.TO_NORTH;
                v.tell("You're heading north exit");
                break;
            case '2':
                d = Direction.TO_EAST;
                v.tell("You're heading east exit");
                break;
            case '3':
                d = Direction.TO_SOUTH;
                v.tell("You're heading south exit");
                break;
            case '4':
                d = Direction.TO_WEST;
                v.tell("You're heading west exit");
                break;
        }

        return d;
    }//end visit
    

        //find location of a room
        private int[] getLoc(Room room){
            for(int i=0; i<maxRow; i++){
                
                for(int j=0; j<maxColumn; j++){
                    
                    if(roomIndex[i][j]==room){
                        int[] loc=new int[2];
                        loc[0]= i;
                        loc[1]= j;
                        return loc;
                    }
                }
            }
        return new int[] {-1,-1};
        }//end getLoc
    
        //print location to user
        private void tellLoc(){
            int[] s = getLoc(r);
            if(s[0]==hallwayRow || s[1]==hallwayColumn){
                System.out.print("\n[ You are in the hallway ] \n");
                printBoard();
            }
            else{
                System.out.println("\n[ Your location is ("+(s[0]+1)+","+(s[1]+1)+") ]");
                printBoard();
            }
        }//end tellLoc

        private static void delay(Visitor v) { v.getChoice("[ Press enter to continue ]", new char[] {' '}); }
    
        private void printBoard(){
                    System.out.println("\n");

                    for (int i = 0; i < maxRow; i++){

                        System.out.print("| ");

                        for (int j = 0; j < maxColumn; j++)

                        {
                            if(i==3){
                                System.out.print("HALLWAY |  ");
                            }

                            else if(roomIndex[i][j]==hallway){
                                System.out.print("   HALLWAY  | ");
                            }

                            else if(roomIndex[i][j]==r){
                                System.out.print("   V   | ");
                            }

                            else{
                                //System.out.print(roomIndex[i][j] + " | ");
                                String s = roomIndex[i][j].toString();
                                System.out.print(roomUn(s)+ " | ");


                            }
                        }
                    System.out.println("\n");
                    }
                    System.out.println();
                }//end printBoard

    //return room username as String
    private String roomUn(String s) {
        int end = s.indexOf("@");
        int start = s.indexOf("_");
        String subS=s;
        if(end!=-1) {
            subS = s.substring(start+1, end);
        }
        return subS;
    }

    private int randomInt() {
        int rand;
        do {
            rand = (int) (Math.random() * 7);
        } while (rand == 3);
        return rand;
    }


    //Constructor to assign rooms to indexes
    private House_ec221150(Room r, int row, int c){
            
            //Hallway on 4th row and 4th column
            if(row==hallwayRow || c==hallwayColumn){
                roomIndex[row][c] = hallway;
            }
            else{
                roomIndex[row][c] = r;
            }
    }
    
    
        //Constructor without a parameter (calls other constructor)
    public House_ec221150(){
        
        String[] usernames;
        usernames = roomList(); //create array for usernames
        shuffleArray(usernames); //shuffle rooms each time game is run
        
        int counter = 0; //counter for placed rooms
        
        for(int i=0; i<maxRow; i++){
            for(int j=0; j<maxColumn; j++){

                if(i!=hallwayRow && j!=hallwayColumn){
                    
                    r = newRoom(usernames[counter]);
                    
                    toVisit=r;

                    new House_ec221150(r, i, j);
                    counter++;
                }
            }
        }
    }//end constructor
    
    
    //create new room
    private Room newRoom(String s){

        switch (s) {
            case "ec22450":
                return new Room_ec22450();
            case "ec221247":
                return new Room_ec221247();
            case "ec22789":
                return new Room_ec22789();
            case "ec22476":
                return new Room_ec22476();
            case "ec22967":
                return new Room_ec22967();
            case "ec22614":
                return new Room_ec22614();
            case "ec22586":
                return new Room_ec22586();
            case "ec22452":
                return new Room_ec22452();
            case "ec22748":
                return new Room_ec22748();
            case "ec22923":
                return new Room_ec22923();
            case "ec22898":
                return new Room_ec22898();
            case "ec22890":
                return new Room_ec22890();
            case "ex21299":
                return new Room_ex21299();
            case "ec22576":
                return new Room_ec22576();
            case "ec22519":
                return new Room_ec22519();
            case "ec22551":
                return new Room_ec22551();
            case "ec22692":
                return new Room_ec22692();
            case "ec22790":
                return new Room_ec22790();
            case "ec22441":
                return new Room_ec22441();
            case "ex21213":
                return new Room_ex21213();
            case "ec22945":
                return new Room_ec22945();
            case "ec22415":
                return new Room_ec22415();
            case "ec22591":
                return new Room_ec22591();
            case "ec22738":
                return new Room_ec22738();
            case "ex20539":
                return new Room_ex20539();
            case "ec221024":
                return new Room_ec221024();
            case "ec22717":
                return new Room_ec22717();
            case "ex21247":
                return new Room_ex21247();
            case "ec221099":
                return new Room_ec221099();
            case "ec22872":
                return new Room_ec22872();
            case "ec22621":
                return new Room_ec22621();
            case "ec22927":
                return new Room_ec22927();
            case "ec22496":
                return new Room_ec22496();
            case "ec22937":
                return new Room_ec22937();
            case "ex21423":
                return new Room_ex21423();
            case "ec22992":
                return new Room_ec22992();
            default:
                return null;
        }
    }//end newRoom
    
    private static String[] roomList() {
    String[] a = new String[36];
      
      a[0] = "ec22450";
      a[1] = "ec221247";
      a[2] = "ec22789";
      a[3] = "ec22476";
      a[4] = "ec22967";
      a[5] = "ec22614";
      a[6] = "ec22586";
      a[7] = "ec22452";
      a[8] = "ec22748";
      a[9] = "ec22923";
      a[10] = "ec22898";
      a[11] = "ec22890";
      a[12] = "ex21299";
      a[13] = "ec22576";
      a[14] = "ec22519";
      a[15] = "ec22551";
      a[16] = "ec22692";
      a[17] = "ec22790";
      a[18] = "ec22441";
      a[19] = "ex21213";
      a[20] = "ec22945";
      a[21] = "ec22415";
      a[22] = "ec22591";
      a[23] = "ec22738";
      a[24] = "ex20539";
      a[25] = "ec221024";
      a[26] = "ec22717";
      a[27] = "ex21247";
      a[28] = "ec221099";
      a[29] = "ec22872";
      a[30] = "ec22621";
      a[31] = "ec22927";
      a[32] = "ec22496";
      a[33] = "ec22937";
      a[34] = "ex21423";
      a[35] = "ec22992";
        
    return a;
    }//end roomList

    //method to shuffle rooms before every game
    public void shuffleArray(String[] array){
        
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = rand.nextInt(array.length);
            String temp = array[randomIndex];
            array[randomIndex] = array[i];
            array[i] = temp;
        }
    }//end shuffle
    
}//end class
