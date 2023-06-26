package day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataFileReaderBis {
    List<List<String>> listOfReadSignals = new ArrayList<>();

    public List<List<String>> readFile(String inputPath) {


        try {
            var fileReader = new BufferedReader(new FileReader(inputPath));

            for (; ; ) {
                final var readLine1 = fileReader.readLine();
                final var readLine2 = fileReader.readLine();
                final var readLine3 = fileReader.readLine();


                List<String> pairOfSignal = new ArrayList<>();
                pairOfSignal.add(readLine1);
                pairOfSignal.add(readLine2);

                listOfReadSignals.add(pairOfSignal);
                if (readLine3 == null) break;

            }
            fileReader.close();
        } catch (
                Exception e) {
            System.out.println(e);
        }
        return listOfReadSignals;
    }


    public void printPairOfLists() {
        for (List<String> pairOfSignals : listOfReadSignals) {
            System.out.println(pairOfSignals.get(0));
            System.out.println(pairOfSignals.get(1));
            System.out.println();
        }
    }

    public List<String> splitString(String line) {
        List<String> splitedStrings = new ArrayList<>();

        var currentLine = line.substring(1, line.length());
        int endIndex = 0;
        int controlIndex = 0;

        for (int i = 1; i < currentLine.length() - 1; i++) {
            var charI = currentLine.charAt(i);
            if (charI == '[') {
                controlIndex++;
                continue;
            } else if ((charI == ']') && (controlIndex > 0)) {
                controlIndex--;
            } else if ((charI == ']') && (controlIndex == 0)) {
                endIndex = Integer.valueOf(i);
                break;
            }
        }
        String body = currentLine.substring(1, endIndex);
        String tail = currentLine.substring(endIndex + 1);
        splitedStrings.add(body);
        splitedStrings.add(tail);

        return splitedStrings;
    }
}
