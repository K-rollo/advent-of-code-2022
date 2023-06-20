package day03;

public class Main {

    public static void main(String[] args) {

        final String path = "src/main/resources/day-3-input.txt";
        RucksacksList rucksacksList = new RucksacksList(path);
        System.out.println(rucksacksList.getSumOfPriorities());
        System.out.println(rucksacksList.getSumOfPrioritiesForTripleElves());

    }
}
