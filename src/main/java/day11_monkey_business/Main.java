package day11_monkey_business;

import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        final String path = "src/main/resources/day-11-input.txt";
        final int rounds = 1000;
        var listOfMonkeys = DataFileReader.readFileAndGenerateMonkeyList(path);     // checked
        MonkeyManger monkeyManger = new MonkeyManger(listOfMonkeys);
        GameManager gameManager = new GameManager(monkeyManger, rounds);
        gameManager.startGame();
        listOfMonkeys.sort(Comparator.comparing(Monkey::getItemsInspected));
        Collections.reverse(listOfMonkeys);
        var monkeyBusinessLevel = listOfMonkeys.stream()
                .limit(2)
                .map(Monkey::getItemsInspected)
                .reduce((i,j) -> i * j)
                .orElse(0);

        System.out.println(monkeyBusinessLevel);

    }
}
