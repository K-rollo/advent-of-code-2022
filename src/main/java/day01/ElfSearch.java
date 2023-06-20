package day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ElfSearch {

    private int elfNo = 1;
    private int elfWithMaxCaloriesNo = 1;
    private long sumOfCalories = 0L;
    private long maxSumOfCalories = 0L;


    public Elf findElfWithMaximumValueOfCalories(String path) {

        try {
            var fileReader = new BufferedReader(new FileReader(path));

            for (; ; ) {
                String readLine = fileReader.readLine();

                if (readLine == null) {
                    if (sumOfCalories > maxSumOfCalories) {
                        maxSumOfCalories = sumOfCalories;
                        elfWithMaxCaloriesNo = elfNo;
                    }
                    break;

                } else if (readLine.isBlank()) {
                    if (sumOfCalories > maxSumOfCalories) {
                        maxSumOfCalories = sumOfCalories;
                        elfWithMaxCaloriesNo = elfNo;
                    }
                    elfNo++;
                    sumOfCalories = 0L;

                } else {
                    sumOfCalories += Long.parseLong(readLine);
                }
            }
            fileReader.close();
        } catch (
                Exception e) {
            System.out.println(e);
        }
        return new Elf(elfWithMaxCaloriesNo, maxSumOfCalories);
    }

    public Map<Integer, Long> getMapOfAllElvesWithCalories(String path) {
        sumOfCalories = 0L;
        elfNo = 1;
        Map<Integer, Long> mapOfElves = new HashMap<>();
        try {
            var fileReader = new BufferedReader(new FileReader(path));

            for (; ; ) {
                String readLine = fileReader.readLine();

                if (readLine == null) {
                    mapOfElves.put(elfNo, sumOfCalories);
                    break;

                } else if (readLine.isBlank()) {
                    mapOfElves.put(elfNo, sumOfCalories);
                    elfNo++;
                    sumOfCalories = 0L;

                } else {
                    sumOfCalories += Long.parseLong(readLine);
                }
            }
            fileReader.close();
        } catch (
                Exception e) {
            System.out.println(e);
        }
        return mapOfElves;

    }




}
