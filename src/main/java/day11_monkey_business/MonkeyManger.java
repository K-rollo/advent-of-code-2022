package day11_monkey_business;

import java.util.List;

public class MonkeyManger {
    private final List<Monkey> listOfMonkeys;
    public MonkeyManger(List<Monkey> listOfMonkeys) {
        this.listOfMonkeys = listOfMonkeys;
    }
    public List<Monkey> getListOfMonkeys() {
        return listOfMonkeys;
    }
}
