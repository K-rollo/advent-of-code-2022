package day05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader {

    public static List<List<String>> readFile(String path) {
        List<String> initialStackStructure = new ArrayList<>();
        List<String> sequenceOfMoves = new ArrayList<>();
        List<List<String>> inputDataAsList = new ArrayList<>();

        try {
            var fileReader = new BufferedReader(new FileReader(path));

            for (; ; ) {
                final var readLine = fileReader.readLine();
                if (readLine.isBlank()) break;
                initialStackStructure.add(readLine);
            }
            inputDataAsList.add(initialStackStructure);

            for (; ; ) {
                final var readLine = fileReader.readLine();
                if (readLine == null) break;
                sequenceOfMoves.add(readLine);
            }
            inputDataAsList.add(sequenceOfMoves);
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return inputDataAsList;
    }
}
