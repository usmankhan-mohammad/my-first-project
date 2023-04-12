package OOP.ec22532.MP;

interface Visitable {
    
    Direction visit( // Returns direction the visitor leaves towards.
        Visitor visitor,
        Direction directionVistorArrivesFrom);
}