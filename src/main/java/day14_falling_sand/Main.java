package day14_falling_sand;

public class Main {

    public final static String PATH = "src/main/resources/day-14-input.txt";

    public static void main(String[] args) {

        DataFileReader dataFileReader = new DataFileReader();
        var result = dataFileReader.readFile(PATH);
//        dataFileReader.printObstacles();
        ViewManager viewManager = new ViewManager();
        viewManager.setObstacles(result);
//        viewManager.printCave();
        SandFallingManager sandFallingManager = new SandFallingManager(viewManager);
       var howManySands = sandFallingManager.run();
        viewManager.printCave();
        System.out.println(howManySands);

    }


}
