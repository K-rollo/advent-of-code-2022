package day05;

import java.util.ArrayList;
import java.util.List;

public class Main {

//    StackManager stackManager = new StackManager();

    public static void main(String[] args) {
        final String path = "src/main/resources/day-5-input.txt";
        List<List<String>> list = DataFileReader.readFile(path);

        List<String> initialStackStructure = list.get(0);
        List<String> sequenceOfMoves = list.get(1);

        List<StackOfCrates> stacksOfCrates = StackCreator.createStacks(initialStackStructure);
        var filledStacksOfCrates = StackManager.initialFillStacks(stacksOfCrates, initialStackStructure);

        List<Move> moves = MoveManager.createSequenceOfCrateMoves(sequenceOfMoves);

//        for (Move move : moves) {
//            move9000(filledStacksOfCrates, move);
//        }
//        for (StackOfCrates stackOfCrates : filledStacksOfCrates) {
//            System.out.print(stackOfCrates.getFromStack());
//        }

        System.out.println("\n");
        for (Move move : moves) {
            move9001(filledStacksOfCrates, move);
        }
        for (StackOfCrates stackOfCrates : filledStacksOfCrates) {
            System.out.print(stackOfCrates.getFromStack());
        }

    }

    private static void move9000(List<StackOfCrates> filledStacksOfCrates, Move move) {
        for (int i = 0; i < move.amountOfCratesToMove(); i++) {
            var takenCrate = filledStacksOfCrates.get(move.numberOfStackFromWhichCrateIsTaken() - 1).getFromStack();
            filledStacksOfCrates.get(move.numberOfStackOnWhichCrateIsPut() - 1).putOnStack(takenCrate);
        }
    }

    private static void move9001(List<StackOfCrates> filledStacksOfCrates, Move move) {
        List<Character> towerOfCrates = new ArrayList<>();
        int numberOfCratesToMove = move.amountOfCratesToMove();
        int stackToGet = move.numberOfStackFromWhichCrateIsTaken() - 1;
        int stackToPut = move.numberOfStackOnWhichCrateIsPut() - 1;

        for (int i = 0; i < numberOfCratesToMove; i++) {
            var temp1 = filledStacksOfCrates.get(stackToGet).getFromStack();
            towerOfCrates.add(temp1);
        }
        for (int i = numberOfCratesToMove; i > 0 ; i--) {
            var temp2 = towerOfCrates.get(i-1);
            filledStacksOfCrates.get(stackToPut).putOnStack(temp2);
        }
    }
}
