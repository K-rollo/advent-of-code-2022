package day11_monkey_business;

import java.math.BigDecimal;

public class Item {
    private int number;
    private BigDecimal worryLevel;
    private int monkeyNumber;
    public Item(int number, BigDecimal worryLevel, int monkeyNumber) {
        this.number = number;
        this.worryLevel = worryLevel;
        this.monkeyNumber = monkeyNumber;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public BigDecimal getWorryLevel() {
        return worryLevel;
    }
    public void setWorryLevel(BigDecimal worryLevel) {
        this.worryLevel = worryLevel;
    }
    public int getMonkeyNumber() {
        return monkeyNumber;
    }
    public void setMonkeyNumber(int monkeyNumber) {
        this.monkeyNumber = monkeyNumber;
    }
}
