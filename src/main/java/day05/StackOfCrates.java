package day05;

import java.util.ArrayList;
import java.util.List;

public class StackOfCrates {

    private List<Character> stackOfCrates = new ArrayList<>();
    private int amountOnStack = 0;

    public void putOnStack(Character crate) {
        stackOfCrates.add(crate);
        amountOnStack++;
    }

    public Character getFromStack() {
        if (amountOnStack > 0 ) {
            Character takenCrate = stackOfCrates.get(amountOnStack - 1);
            stackOfCrates.remove(stackOfCrates.size() - 1);
            amountOnStack--;
            return takenCrate;
        } else {
            return null;
        }
    }
}
