package day14_falling_sand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataFileReader {

    List<List<String>> obstacles = new ArrayList<>();

    public List<List<String>> readFile(String inputPath) {
        try {
            var fileReader = new BufferedReader(new FileReader(inputPath));
            for (; ; ) {
                final var readLine = fileReader.readLine();
                if (readLine == null) break;
                var singleObstacleAsArray = readLine.split(" -> ");
                var singleObstacle = Arrays.asList(singleObstacleAsArray);
                obstacles.add(singleObstacle);
            }
            fileReader.close();
        } catch (
                Exception e) {
            System.out.println(e);
        }
        return obstacles;
    }

    public void printObstacles() {
        obstacles.forEach(System.out::println);
    }
}