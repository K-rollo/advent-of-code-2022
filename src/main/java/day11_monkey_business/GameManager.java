package day11_monkey_business;

public class GameManager {

    private final int roundsRepetition;
    MonkeyManger monkeyManger;

    //---------------------------------------------------------------
    public GameManager(MonkeyManger monkeyManger, int roundsRepetition) {
        this.monkeyManger = monkeyManger;
        this.roundsRepetition = roundsRepetition;
    }

    public void startGame() {

        for (int r = 0; r < roundsRepetition; r++) {

            // Round cycle for each monkey
            for (int i = 0; i < monkeyManger.getListOfMonkeys().size(); i++) {

                var returnedQueue = monkeyManger.getListOfMonkeys().get(i).inspect();
                int counter = returnedQueue.size();

                for (int j = 0; j < counter; j++) {
                    var transferredItem = returnedQueue.poll();
                    int monkeyToWhomItemIsTransferred = transferredItem.getMonkeyNumber();
                    monkeyManger.getListOfMonkeys()
                            .get(monkeyToWhomItemIsTransferred)
                            .addItemToMonkeysQueue(transferredItem);
                }
            }
            System.out.println("After round " + (r + 1) + ", the monkeys are holding items these worry levels:");
            monkeyManger.getListOfMonkeys().forEach(Monkey::printItemsWorryLevels);
            System.out.println("");
        }
    }
}

