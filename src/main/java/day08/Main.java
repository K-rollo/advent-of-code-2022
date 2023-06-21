package day08;

public class Main {
    public static void main(String[] args) {

        final String path = "src/main/resources/day-8-input.txt";
        var result = DataFileReader.readFile(path);

//        System.out.println(VisibleTreesCounter.howManyTreesAreVisibleFromOuside(result));
        System.out.println(MaximumScenicViewCounter.howMaximumTreesAreVisibleFromTreeHouse(result));

    }
}
