package day05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StackCreator {
       public static List<StackOfCrates> createStacks(List<String> initialStackStructure) {
        List<StackOfCrates> stacksOfCrates = new ArrayList<>();

        var amountOfStacks = initialStackStructure.stream()
                .map(str -> str.length() + 1)
                .map(intgr -> intgr / 4)
                .max(Integer::compare)
                .orElse(0);

        for (int i = 0; i < amountOfStacks; i++) {
            stacksOfCrates.add(new StackOfCrates());
        }

        return stacksOfCrates;

    }
}
