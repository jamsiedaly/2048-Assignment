package twentyFortyEight.solution.gameobject;

import java.util.Map;

public class GameSquareFactory {

    private static Map<GameSquareNumber, GameSquareNumber> nextNumberMap= Map.of(
            GameSquareNumber.TWO, GameSquareNumber.FOUR,
            GameSquareNumber.FOUR, GameSquareNumber.EIGHT,
            GameSquareNumber.EIGHT, GameSquareNumber.SIXTEEN,
            GameSquareNumber.SIXTEEN, GameSquareNumber.THIRTY_TWO,
            GameSquareNumber.THIRTY_TWO, GameSquareNumber.SIXTY_FOUR,
            GameSquareNumber.SIXTY_FOUR, GameSquareNumber.ONE_HUNDRED_TWENTY_EIGHT,
            GameSquareNumber.ONE_HUNDRED_TWENTY_EIGHT, GameSquareNumber.TWO_HUNDRED_FIFTY_SIX,
            GameSquareNumber.TWO_HUNDRED_FIFTY_SIX, GameSquareNumber.FIVE_HUNDRED_TWELVE,
            GameSquareNumber.FIVE_HUNDRED_TWELVE, GameSquareNumber.ONE_THOUSAND_TWENTY_FOUR,
            GameSquareNumber.ONE_THOUSAND_TWENTY_FOUR, GameSquareNumber.TWO_THOUSAND_FORTY_EIGHT
    );

    public GameSquare createNextSquare(double x, double y, GameSquareNumber previousNumber) {
        GameSquareNumber newNumber = nextNumberMap.get(previousNumber);
        return new GameSquare(x, y, newNumber);
    }

    public GameSquare createNewSquare(double x, double y) {
        return new GameSquare(x, y);
    }
}
