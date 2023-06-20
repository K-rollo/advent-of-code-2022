package day01;

public class Main {
    public static void main(String[] args) {

        final String path = "src/main/resources/day-1-input.txt";
        ElfSearch elfSearch = new ElfSearch();

        final var elfWithMaximumValueOfCalories = elfSearch.findElfWithMaximumValueOfCalories(path);
        System.out.println("Elf with highest sum of calories nas number: " + elfWithMaximumValueOfCalories.number());
        System.out.println("Highest sum of calories is: " + elfWithMaximumValueOfCalories.amountOfCalories());

        final var mapOfElves = elfSearch.getMapOfAllElvesWithCalories(path);
        for (int i = 0; i < mapOfElves.size() - 1; i++) {
            System.out.println(i + " " + mapOfElves.get(i));
        }
        final var sortedValues = mapOfElves.values().stream().sorted().toList();
        System.out.println(sortedValues);

        final var sum = sortedValues.get(sortedValues.size()-1) + sortedValues.get(sortedValues.size()-2) + sortedValues.get(sortedValues.size()-3) ;
        System.out.println(sum);
    }
}