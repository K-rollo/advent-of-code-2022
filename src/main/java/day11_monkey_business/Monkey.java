package day11_monkey_business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Monkey {

    private int number;
    private Queue<Item> queueOfItems = new ArrayDeque<>();
    private final OperationType operationType;
    private final BigDecimal operationRatio;
    private final BigDecimal divisionRatio;
    private final int monkeyIfTrue;
    private final int monkeyIfFalse;


    private int itemsInspected;


    public Monkey(int number, OperationType operationType, BigDecimal operationRatio, BigDecimal divisionRatio, int monkeyIfTrue, int monkeyIfFalse) {
        this.number = number;
        this.operationType = operationType;
        this.operationRatio = operationRatio;
        this.divisionRatio = divisionRatio;
        this.monkeyIfTrue = monkeyIfTrue;
        this.monkeyIfFalse = monkeyIfFalse;
    }

    public Queue<Item> inspect() {
        int repeatition = queueOfItems.size();

        Queue<Item> localQueueOfItems = new ArrayDeque<>();

        for (int i = 0; i < repeatition; i++) {
            itemsInspected++;
            var inspectedItem = queueOfItems.poll();
            var currentWorryLevel = inspectedItem.getWorryLevel();

            switch (operationType) {
                case ADDITION -> {
                    currentWorryLevel = currentWorryLevel.add(operationRatio);
                }
                case SUBTRACTION -> {
                    currentWorryLevel = currentWorryLevel.subtract(operationRatio);
                }
                case MULTIPLICATION -> {
                    if (operationRatio.equals(BigDecimal.valueOf(-1L))) {
                        currentWorryLevel = currentWorryLevel.multiply(currentWorryLevel);
                    } else {
                        currentWorryLevel = currentWorryLevel.multiply(operationRatio);
                    }
                }
                case DIVISION -> {
                    currentWorryLevel = currentWorryLevel.divide(operationRatio, RoundingMode.HALF_EVEN);
                }
            }
//            currentWorryLevel /= 3;
//            currentWorryLevel = currentWorryLevel.divide(BigDecimal.valueOf(3), RoundingMode.DOWN);
            inspectedItem.setWorryLevel(currentWorryLevel);

            boolean isDivisible = isDivisible(currentWorryLevel, divisionRatio);

            int chosenMonkey = isDivisible ? monkeyIfTrue : monkeyIfFalse;
            inspectedItem.setMonkeyNumber(chosenMonkey);

            localQueueOfItems.offer(inspectedItem);
        }
        return localQueueOfItems;
    }

    public int getItemsInspected() {
        return itemsInspected;
    }

    public void setQueueOfItems(List<Item> listOfItems) {
        for (int i = 0; i < listOfItems.size(); i++) {
            var localItem = listOfItems.get(i);
            this.queueOfItems.offer(localItem);
        }
    }


    public void addItemToMonkeysQueue(Item item) {
        queueOfItems.offer(item);
    }

    public void printItemsWorryLevels() {
        System.out.print("Monkey " + number + ": ");
        queueOfItems.forEach(item -> System.out.print(item.getWorryLevel() + ", "));
        System.out.println(" Inspected items: " + itemsInspected);
    }

    public static boolean isDivisible(BigDecimal num1, BigDecimal num2) {
        BigDecimal result = remainder(num1, num2);
        return result.compareTo(BigDecimal.ZERO) == 0 ? true : false;
    } /*from  w ww . j  a  va 2  s .  c  o m*/

    public static BigDecimal remainder(BigDecimal num1, BigDecimal num2) {
        if (null == num2 || BigDecimal.ZERO.compareTo(num2) == 0) {
            return null;
        }
        if (null == num1 || BigDecimal.ZERO.compareTo(num1) == 0) {
            return BigDecimal.ZERO;
        }
        return num1.remainder(num2);
    }
}

