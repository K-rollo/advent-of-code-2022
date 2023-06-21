package day09;

public class Main {
    public static void main(String[] args) {
        final String path = "src/main/resources/day-9-input.txt";
        var result = DataFileReader.readFile(path);

//        result
//                .forEach(System.out::println);

        MoveController moveController = new MoveController(result);
        System.out.println(moveController.getNumberOfVisitedByTailPositions());
    }
}
