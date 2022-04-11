package twentyFortyEight.exercise.gameobject;

public class GameSquareFactory {

    /*
        You must create a method on the factory which handles creating the new game square.
        You must make sure that the new game square is the next logical value in 2048
     */
    public GameSquare createNextSquare(double x, double y, GameSquareNumber previousNumber) {
        throw new UnsupportedOperationException("You must implement the new createNewSquare method");
    }

    public GameSquare createNewSquare(double x, double y) {
        return new GameSquare(x, y);
    }
}
