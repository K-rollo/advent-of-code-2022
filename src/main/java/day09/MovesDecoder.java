package day09;

import java.util.ArrayList;
import java.util.List;

public class MovesDecoder {

    public static List<Character> decodeMoves(List<HeadMove> headMoves){
        List<Character> sequenceOfHeadMoves = new ArrayList<>();

        for (HeadMove headMove : headMoves) {
            for (int i = 0; i < headMove.amountOfSteps(); i++)  {
                sequenceOfHeadMoves.add(headMove.direction());
            }
        }
        return sequenceOfHeadMoves;
    }
}
