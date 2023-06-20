package day02;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        final String path = "src/main/resources/day-2-input.txt";
        GamesRegister gamesRegister = new GamesRegister(path);

        final var listOfGamesPartOne = gamesRegister.getListOfAllGamesPartOne();
        System.out.println(getPoints(listOfGamesPartOne));

        final var listOfGamesPartTwo = gamesRegister.getListOfAllGamesPartTwo();
        System.out.println(getPoints(listOfGamesPartTwo));

    }

    private static int getPoints(List<Game> listOfGames) {
        int result = 0;
        for (Game game : listOfGames) {

            System.out.println(game.opponentsMove() + " " +
                    game.yoursMove() + " " +
                    game.itemInFirstColumn().name() + " " +
                    game.itemInSecondColumn().name() + "                  " +
                    getResult(game.itemInFirstColumn(), game.itemInSecondColumn()));
            result += getResult(game.itemInFirstColumn(), game.itemInSecondColumn());
        }
        return result;
    }

// A X   Rock       1
// B Y   Paper      2
// C Z   Scissors   3
// WON      6
// DRAW     3
// LOST     0

    static int getResult(Item opponentsItem, Item yourItem) {

        Map<Item, Integer> pointsForItem = new HashMap<>();
        pointsForItem.put(Item.ROCK, 1);
        pointsForItem.put(Item.PAPER, 2);
        pointsForItem.put(Item.SCISSORS, 3);

        Map<GameResult, Integer> pointsForResult = new HashMap<>();
        pointsForResult.put(GameResult.WON, 6);
        pointsForResult.put(GameResult.DRAW, 3);
        pointsForResult.put(GameResult.LOST, 0);

        int points = 0;

        switch (yourItem) {
            case ROCK: {
                points += pointsForItem.get(Item.ROCK);
                if (opponentsItem.equals(Item.ROCK)) {
                    points += pointsForResult.get(GameResult.DRAW);
                } else if (opponentsItem.equals(Item.PAPER)) {
                    points += pointsForResult.get(GameResult.LOST);
                } else {
                    points += pointsForResult.get(GameResult.WON);
                }
                break;
            }
            case PAPER: {
                points += pointsForItem.get(Item.PAPER);
                if (opponentsItem.equals(Item.PAPER)) {
                    points += pointsForResult.get(GameResult.DRAW);
                } else if (opponentsItem.equals(Item.SCISSORS)) {
                    points += pointsForResult.get(GameResult.LOST);
                } else {
                    points += pointsForResult.get(GameResult.WON);
                }
                break;
            }
            case SCISSORS: {
                points += pointsForItem.get(Item.SCISSORS);
                if (opponentsItem.equals(Item.SCISSORS)) {
                    points += pointsForResult.get(GameResult.DRAW);
                } else if (opponentsItem.equals(Item.ROCK)) {
                    points += pointsForResult.get(GameResult.LOST);
                } else {
                    points += pointsForResult.get(GameResult.WON);
                }
                break;
            }
        }
        return points;
    }
}

