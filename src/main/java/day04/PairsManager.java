package day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsManager {

    public static List<List<Integer>> getPairsFromFile(String path) {
        List<List<Integer>> ranges = new ArrayList<>();
        try {
            var fileReader = new BufferedReader(new FileReader(path));
            for (; ; ) {
                final var readLine = fileReader.readLine();
                if (readLine == null) break;
                List<Integer> range = parseRangeValues(readLine);
                ranges.add(range);
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    return ranges;
    }

    private static List<Integer> parseRangeValues(String readLine) {
        var splitedLine = readLine.split(",");
        return Arrays.stream(splitedLine)
                .map(str -> str.split("-"))
                .flatMap(Arrays::stream)
                .map(Integer::valueOf)
                .toList();
    }
}
