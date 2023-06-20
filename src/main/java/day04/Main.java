package day04;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        final String path = "src/main/resources/day-4-input.txt";
        List<List<Integer>> listOfRanges = PairsManager.getPairsFromFile(path);


        for (List<Integer> listOfRange : listOfRanges) {
            listOfRange.forEach(integer -> System.out.print(integer + " "));
            System.out.print("\n");
            ;

        }
        int counterPartOne = 0;
        for (List<Integer> listOfRange : listOfRanges) {
            if (isContaining(listOfRange)) counterPartOne++;
        }
        System.out.println(counterPartOne);

        int counterPartTwo = 0;
        for (List<Integer> listOfRange : listOfRanges) {
            if (isOverlaping(listOfRange)) counterPartTwo++;
        }
        System.out.println(counterPartTwo);


    }

    private static boolean isContaining(List<Integer> range) {
       return ( ( (range.get(0) <= range.get(2)) && (range.get(1) >= range.get(3)) ) || ( (range.get(0) >= range.get(2)) && (range.get(1) <= range.get(3)) ) );
    }
    private static boolean isOverlaping(List<Integer> range) {
        return ( ( (range.get(0) <= range.get(2)) && (range.get(1) >= range.get(2)) ) || ( (range.get(0) <= range.get(3)) && (range.get(1) >= range.get(3)) ) ) ||
                ( ( (range.get(2) <= range.get(0)) && (range.get(3) >= range.get(0)) ) || ( (range.get(2) <= range.get(1)) && (range.get(3) >= range.get(1)) ) );
    }
}
