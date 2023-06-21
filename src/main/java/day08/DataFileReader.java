package day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader {

    public static int[][] readFile(String inputPath) {
        List<int[]> listOfRows = new ArrayList<>();

        try {
            var fileReader = new BufferedReader(new FileReader(inputPath));

            for (; ; ) {
                final var readLine = fileReader.readLine();
                if (readLine == null) break;

                int[] singleRow = new int[readLine.length()];
                for (int i = 0; i < readLine.length(); i++) {
                    singleRow[i] = Integer.parseInt(String.valueOf(readLine.charAt(i)));
                }
                listOfRows.add(singleRow);
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        int x = listOfRows.size();
        int y = listOfRows.get(0).length;
        // int[row][column]
        int[][] tableOfDigits = new int[x][y];
        for (int i = 0; i < x; i++) {
            var localRow = listOfRows.get(i);

            for (int j = 0; j < y; j++) {
                tableOfDigits[i][j] = localRow[j];
            }
        }
//  printer to control if is correctly filled
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < y; j++) {
//                System.out.print(tableOfDigits[i][j]);
//            }
//            System.out.println("");
//        }
        return tableOfDigits;
    }
}
