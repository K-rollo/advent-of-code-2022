package day02;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamesRegister {

    private final String path;

    public GamesRegister(String path) {
        this.path = path;
    }

    public List<Game> getListOfAllGamesPartOne() {
        Map<Character, Item> RPSDictionary = new HashMap<>();
        RPSDictionary.put('A', Item.ROCK);
        RPSDictionary.put('B', Item.PAPER);
        RPSDictionary.put('C', Item.SCISSORS);
        RPSDictionary.put('X', Item.ROCK);
        RPSDictionary.put('Y', Item.PAPER);
        RPSDictionary.put('Z', Item.SCISSORS);

        List<Game> listOfGames = new ArrayList<>();
        try {
            var fileReader = new BufferedReader(new FileReader(path));
            for (; ; ) {
                final var readLine = fileReader.readLine();
                if (readLine == null) break;

                char charInFirstColumn = readLine.charAt(0);
                char charInSecondColumn = readLine.charAt(2);

                listOfGames.add(new Game(charInFirstColumn,
                        charInSecondColumn,
                        RPSDictionary.get(charInFirstColumn),
                        RPSDictionary.get(charInSecondColumn)));
            }
            fileReader.close();
        } catch (
                Exception e) {
            System.out.println(e);
        }
        return listOfGames;

    }

    public List<Game> getListOfAllGamesPartTwo() {
        Map<Character, Item> RPSDictionary = new HashMap<>();
        RPSDictionary.put('A', Item.ROCK);
        RPSDictionary.put('B', Item.PAPER);
        RPSDictionary.put('C', Item.SCISSORS);


        List<Game> listOfGames = new ArrayList<>();
        try {
            var fileReader = new BufferedReader(new FileReader(path));
            for (; ; ) {
                final var readLine = fileReader.readLine();
                if (readLine == null) break;

                char charInFirstColumn = readLine.charAt(0);
                char charInSecondColumn = readLine.charAt(2);

                listOfGames.add(new Game(charInFirstColumn,
                        charInSecondColumn,
                        RPSDictionary.get(charInFirstColumn),
                        getItemByFirstColumnItemAndResultType(RPSDictionary.get(charInFirstColumn), charInSecondColumn)));
            }
            fileReader.close();
        } catch (
                Exception e) {
            System.out.println(e);
        }
        return listOfGames;

    }

    private Item getItemByFirstColumnItemAndResultType(Item itemInFirstColumn, char charInSecondColumn) {
        // X lose
        // Y draw
        // Z win

        Item result = Item.ROCK;

        switch (charInSecondColumn) {
            case 'X': {
                if (itemInFirstColumn.equals(Item.ROCK)) result = Item.SCISSORS;
                else if (itemInFirstColumn.equals(Item.PAPER)) result = Item.ROCK;
                else result = Item.PAPER;
                break;
            }
            case 'Y': {
                if (itemInFirstColumn.equals(Item.ROCK)) result = Item.ROCK;
                else if (itemInFirstColumn.equals(Item.PAPER)) result = Item.PAPER;
                else result = Item.SCISSORS;
                break;
            }
            case 'Z': {
                if (itemInFirstColumn.equals(Item.ROCK)) result = Item.PAPER;
                else if (itemInFirstColumn.equals(Item.PAPER)) result = Item.SCISSORS;
                else result = Item.ROCK;
                break;
            }
        }

        return result;
    }


}
