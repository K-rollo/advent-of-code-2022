package day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveManager {

    public static List<Move> createSequenceOfCrateMoves(List<String> sequenceOfMoves) {
        List<Move> moves = new ArrayList<>();

        for (String line : sequenceOfMoves) {
            moves.add(decodeMove(line));
        }
        return moves;
    }

    private static Move decodeMove(String line) {
        String substr = line.substring(5);
        var splitedLine = substr.split(" from ");
        var splitedAllLine = Arrays.stream(splitedLine)
                .map(str -> str.split(" to "))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::decode)
                .toArray();
        return new Move(splitedAllLine[0],splitedAllLine[1], splitedAllLine[2]);
    }
}
