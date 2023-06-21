package day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFileReader {


    public static List<List<DataStructure>> readFile(String inputPath) {
        List<DataStructure> advDirectories = new ArrayList<>();
        List<DataStructure> advFiles = new ArrayList<>();
        List<List<DataStructure>> listOfAllDataStructures = new ArrayList<>();
        List<String> path = new ArrayList<>();

        advDirectories.add(new AdvDirectory("/", List.of()));

        try {
            var fileReader = new BufferedReader(new FileReader(inputPath));

            for (; ; ) {
                final var readLine = fileReader.readLine();
                if (readLine == null) break;

                // manage path
                if (readLine.startsWith("$ cd ..")) {
                    path.remove(path.size() - 1);
                } else if (readLine.startsWith("$ cd ")) {
                    path.add(readLine.substring(5));
                }
//                System.out.println(path);

                // creates directories
                if (readLine.startsWith("dir ")) {
                    List<String> currentPath = List.copyOf(path);
                    advDirectories.add(new AdvDirectory(readLine.substring(4), currentPath));
                }


                // creates files
                if (doesStartsWithDigit("^[1-9]", readLine)) {
                    var splitedLine = readLine.split(" ");
                    List<String> currentPath = List.copyOf(path);
                    advFiles.add(new AdvFile(splitedLine[1], currentPath, Integer.parseInt(splitedLine[0])));
                }

            }
//            for (AdvDirectory advDirectory : advDirectories) {
//                System.out.println(advDirectory);
//            }
//            System.out.println(advDirectories.size());

            for (DataStructure advFile : advFiles) {
                AdvFile localAdvFile = (AdvFile) advFile;
                System.out.println(localAdvFile.getSize());
            }
            System.out.println("-----------------------------------");
            System.out.println(advFiles.size());

            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        listOfAllDataStructures.add(advDirectories);
        listOfAllDataStructures.add(advFiles);

        return listOfAllDataStructures;
    }

    public static boolean doesStartsWithDigit(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        return matcher.find();
    }
}



