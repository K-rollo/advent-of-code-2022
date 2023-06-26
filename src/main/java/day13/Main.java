package day13;

public class Main {
    public final static String PATH = "src/main/resources/day-13-input.txt";

    public static void main(String[] args) {

//        DataFileReader dataFileReader = new DataFileReader();
//        var listOfSignals = dataFileReader.readFile(PATH);
//        dataFileReader.printList();

        DataFileReaderBis dataFileReaderBis = new DataFileReaderBis();
        var result1 = dataFileReaderBis.readFile(PATH);
        var firstSignal = result1.get(0).get(0);
        var splited = dataFileReaderBis.splitString(firstSignal);

//        StringSeparationAndAggregationManager stringSeparationAndAggregationManager = new StringSeparationAndAggregationManager();
//        var result1 = stringSeparationAndAggregationManager
//                .generateStringsWithAggregationLevelsList(listOfSignals.get(1).get(0));
//        var result2 = stringSeparationAndAggregationManager
//                .generateStringsWithAggregationLevelsList(listOfSignals.get(1).get(1));
    }

}
