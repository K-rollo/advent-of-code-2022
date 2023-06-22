package day11_monkey_business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class DataFileReader {

    public static List<Monkey> readFileAndGenerateMonkeyList(String inputPath) {
        List<Monkey> listOfMonkeys = new ArrayList<>();
        List<Item> listOfItems = new ArrayList<>();
        int itemNumber = 1;

        try {
            var fileReader = new BufferedReader(new FileReader(inputPath));

            for (; ; ) {

                final var readLineMonkeyNumber = fileReader.readLine();
                final var readLineItemsNumbers = fileReader.readLine();
                final var readLineOperationDetails = fileReader.readLine();
                final var readLineDivisionRatio = fileReader.readLine();
                final var readLineMonkeyIfTrue = fileReader.readLine();
                final var readLineMonkeyIfFalse = fileReader.readLine();



                // decoding monkey number
                var monkeyNumberAsChar = String.valueOf(readLineMonkeyNumber.charAt(7));
                var monkeyNumber = Integer.parseInt(monkeyNumberAsChar);

                // decoding items
                if (readLineItemsNumbers.length() > 17) {
                    var itemsWorryLevelsAsString = readLineItemsNumbers.substring(18);
                    var itemsWorryLevelsAsStringsArray = itemsWorryLevelsAsString.split(", ");
                    List<BigInteger> itemsWorryLevelsAsLongs = new ArrayList<>();

                    for (String str : itemsWorryLevelsAsStringsArray)
                        itemsWorryLevelsAsLongs.add(BigInteger.valueOf(Long.parseLong(str)));

                    if (itemsWorryLevelsAsLongs.size() > 0) {
                        for (BigInteger itemsWorryLevelsAsLong : itemsWorryLevelsAsLongs) {
                            var localItem = new Item(itemNumber++, itemsWorryLevelsAsLong, monkeyNumber);
                            listOfItems.add(localItem);
                        }
                    }
                }
                //decoding operation
                OperationType operationType = OperationType.NOT_DEFINED;
                var operationDetailsAsString = readLineOperationDetails.substring(23);
                var operationTypeIndicator = operationDetailsAsString.charAt(0);
                switch (operationTypeIndicator) {
                    case '+' -> operationType = OperationType.ADDITION;
                    case '-' -> operationType = OperationType.SUBTRACTION;
                    case '*' -> operationType = OperationType.MULTIPLICATION;
                    case '/' -> operationType = OperationType.DIVISION;
                }
                var operationRatio = BigInteger.valueOf(-1);
                var operationRatioAsString = operationDetailsAsString.substring(2);
                if (!operationRatioAsString.equals("old")) operationRatio = BigInteger.valueOf(Integer.parseInt(operationRatioAsString));

                // decoding division ratio
                var divisionRatioAsString = readLineDivisionRatio.substring(21);
                var divisionRatio = BigInteger.valueOf(Long.parseLong(divisionRatioAsString));

                // decoding monkey number if true
                var monkeyIfTrueAsString = readLineMonkeyIfTrue.substring(29);
                int monkeyIfTrue = Integer.parseInt(monkeyIfTrueAsString);
                var monkeyIfFalseAsString = readLineMonkeyIfFalse.substring(30);
                int monkeyIfFalse= Integer.parseInt(monkeyIfFalseAsString);

                var localMonkey = new Monkey(monkeyNumber, operationType, operationRatio, divisionRatio, monkeyIfTrue, monkeyIfFalse);
                localMonkey.setQueueOfItems(listOfItems);

                listOfMonkeys.add(localMonkey);

                listOfItems.clear();

                final var readLine = fileReader.readLine();
                if (readLine == null) break;

            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return listOfMonkeys;
    }
}


