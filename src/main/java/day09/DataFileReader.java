package day09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader {

    public static List<Character> readFile(String inputPath) {
        List<HeadMove> sequenceOfHeadMoves = new ArrayList<>();

        try {
            var fileReader = new BufferedReader(new FileReader(inputPath));

            for (; ; ) {
                final var readLine = fileReader.readLine();
                if (readLine == null) break;

                String[] singleMove = readLine.split(" ");
                HeadMove currentHeadMove = new HeadMove(singleMove[0].charAt(0), Integer.parseInt(singleMove[1]));
                sequenceOfHeadMoves.add(currentHeadMove);
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        return MovesDecoder.decodeMoves(sequenceOfHeadMoves);
    }
}
