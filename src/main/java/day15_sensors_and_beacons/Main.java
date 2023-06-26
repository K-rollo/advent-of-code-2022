package day15_sensors_and_beacons;


public class Main {

    public final static String PATH = "src/main/resources/day-15-input.txt";

    public static void main(String[] args) {

        MatrixManager matrixManager = new MatrixManager();
        // Part one
//        var result1 = matrixManager.checkExclusionsAmountInStrictLine(2000000);
//        System.out.println(result1);

        // Part two
        var result2 = matrixManager.searchLine(4000000);
        System.out.println(result2);

    }
}
