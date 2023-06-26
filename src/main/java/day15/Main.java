package day15;


public class Main {

    public final static String PATH = "src/main/resources/day-15-input.txt";

    public static void main(String[] args) {

        MatrixManager matrixManager = new MatrixManager();
        matrixManager.createMatrix();
        matrixManager.fillMatrix();
        matrixManager.printCave();
//        System.out.println(matrixManager.getResult());

    }
}
