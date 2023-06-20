package day05;

import java.util.ArrayList;
import java.util.List;

public class StackManager {

    public List<StackOfCrates> stacks = new ArrayList<>();

    public static List<StackOfCrates> initialFillStacks(List<StackOfCrates> stacksOfCrates, List<String> initialStackStructure) {
        for (int i = initialStackStructure.size() - 2; i >= 0; i--) {
            int j = 1;
            int stackNumber = 1;
            while (j <= initialStackStructure.get(i).length()) {
                char crateIndex = initialStackStructure.get(i).charAt(j);
                if (crateIndex != ' ') {
                    stacksOfCrates.get(stackNumber - 1).putOnStack(crateIndex);
                }
                j += 4;
                stackNumber++;

            }
        }
        return stacksOfCrates;
    }
}
