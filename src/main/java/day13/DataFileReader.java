package day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader {
    List<List<String>> listOfReadSignals = new ArrayList<>();

    public List<List<String>> readFile(String inputPath) {


        try {
            var fileReader = new BufferedReader(new FileReader(inputPath));

            for (; ; ) {
                final var readLine1 = fileReader.readLine();
                final var readLine2 = fileReader.readLine();
                final var readLine3 = fileReader.readLine();

                var firstSignal = transformReadLine(readLine1);
                var secondSignal = transformReadLine(readLine2);

                List<String> pairOfSignal = new ArrayList<>();
                pairOfSignal.add(firstSignal);
                pairOfSignal.add(secondSignal);

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

    static String transformReadLine(String readLine) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(readLine.charAt(0));
        if (readLine.length() == 2) stringBuilder.append(" ");

        for (int i = 1; i < readLine.length() - 1; i++) {
            var readPreviousChar = readLine.charAt(i - 1);
            var readChar = readLine.charAt(i);
            var readNextChar = readLine.charAt(i + 1);

            if ((readPreviousChar == '[') && (readChar == ']')) {
                stringBuilder.append(" ]");
            } else if ((readChar == '[') || (readChar == ']')) {
                stringBuilder.append(readChar);
            } else if (readChar == ',') {
                continue;
            } else if (((readPreviousChar == '[') && (readNextChar == ','))
                    || ((readPreviousChar == ',') && (readNextChar == ']'))
                    || ((readPreviousChar == ',') && (readNextChar == ','))) {
                stringBuilder.append("[" + readChar + "]");

                // case where number has 2 digits
            } else if ( (readNextChar != '[') && (readNextChar != ']') && (readNextChar != ',') ) {
                if ( !(readPreviousChar == '[') && (!(readLine.charAt(i+2) == '[') ) ) stringBuilder.append('[');
                stringBuilder.append(readChar);
                stringBuilder.append(readNextChar);
                if ( !(readPreviousChar == ']') && (!(readLine.charAt(i+2) == ']') ) )stringBuilder.append(']');
                i++;
            } else stringBuilder.append(readChar);
        }
        stringBuilder.append(readLine.charAt(readLine.length() - 1));

        return stringBuilder.toString();
    }

    public void printList() {
        for (List<String> pairOfSignals : listOfReadSignals) {
            System.out.println(pairOfSignals.get(0));
            System.out.println(pairOfSignals.get(1));
            System.out.println();
        }
    }
}
