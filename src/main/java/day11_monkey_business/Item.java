package day11_monkey_business;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Item {
    private int number;
    private BigInteger worryLevel;
    private int monkeyNumber;
    public Item(int number, BigInteger worryLevel, int monkeyNumber) {
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
    public BigInteger getWorryLevel() {
        return worryLevel;
    }
    public void setWorryLevel(BigInteger worryLevel) {
        this.worryLevel = worryLevel;
    }
    public int getMonkeyNumber() {
        return monkeyNumber;
    }
    public void setMonkeyNumber(int monkeyNumber) {
        this.monkeyNumber = monkeyNumber;
    }
}
