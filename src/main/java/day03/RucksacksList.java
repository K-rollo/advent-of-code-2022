package day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class RucksacksList {
    private final String path;

    public RucksacksList(String path) {
        this.path = path;
    }

    public int getSumOfPriorities() {

        List<Rucksack> listOfRucksacks = new ArrayList<>();
        try {
            var fileReader = new BufferedReader(new FileReader(path));
            for (; ; ) {
                final var readLine = fileReader.readLine();
                if (readLine == null) break;
                Rucksack currentRucksack = new Rucksack();
                currentRucksack.setLeftCompartment(readLine.substring(0, readLine.length() / 2));
                currentRucksack.setRightCompartment(readLine.substring(readLine.length() / 2));
                listOfRucksacks.add(currentRucksack);
                //               System.out.println(readLine);
//                System.out.println(currentRucksack.getLeftCompartment() + " " + currentRucksack.getRightCompartment());
//                System.out.println();
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        List<Character> characters = new ArrayList<>();
        for (Rucksack rucksack : listOfRucksacks) {
            for (int i = 0; i < rucksack.getLeftCompartment().length(); i++) {
                String currentCharAsString = String.valueOf(rucksack.getLeftCompartment().charAt(i));
                if (rucksack.getRightCompartment().contains(currentCharAsString)) {
                    characters.add(currentCharAsString.charAt(0));
                    break;
                }
                ;
            }
        }
        System.out.println(((int) 'A') - 65 + 27);
        System.out.println(((int) 'Z') - 65 + 27);
        System.out.println(((int) 'a') - 96);
        System.out.println(((int) 'z') - 96);

        return characters.stream()
                .map(character -> {
                    int indx = (int) character;
                    if (indx < 97) {
                        return indx - 65 + 27;
                    } else {
                        return indx - 96;
                    }
                })
                .reduce(Integer::sum)
                .orElse(0);

    }


    public int getSumOfPrioritiesForTripleElves() {

        List<RucksackTriple> listOfRucksacksTriples = new ArrayList<>();
        try {
            var fileReader = new BufferedReader(new FileReader(path));
            for (; ; ) {
                RucksackTriple currentRucksackTriple = new RucksackTriple();

                final var readLine1 = fileReader.readLine();
                if (readLine1 == null) break;
                currentRucksackTriple.setFirstRucksack(readLine1);

                final var readLine2 = fileReader.readLine();
                if (readLine2 == null) break;
                currentRucksackTriple.setSecondRucksack(readLine2);

                final var readLine3 = fileReader.readLine();
                if (readLine3 == null) break;
                currentRucksackTriple.setThirdRucksack(readLine3);

                listOfRucksacksTriples.add(currentRucksackTriple);
                            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        List<Character> characters = new ArrayList<>();
        for (RucksackTriple rucksackTriple : listOfRucksacksTriples) {
            for (int i = 0; i < rucksackTriple.getFirstRucksack().length(); i++) {
                String currentCharAsString = String.valueOf(rucksackTriple.getFirstRucksack().charAt(i));
                if (rucksackTriple
                        .getSecondRucksack()
                        .contains(currentCharAsString) &&
                        (rucksackTriple
                                .getThirdRucksack()
                                .contains(currentCharAsString))) {
                    characters.add(currentCharAsString.charAt(0));
                    break;
                }
                ;
            }
        }
        System.out.println(((int) 'A') - 65 + 27);
        System.out.println(((int) 'Z') - 65 + 27);
        System.out.println(((int) 'a') - 96);
        System.out.println(((int) 'z') - 96);

        return characters.stream()
                .map(character -> {
                    int indx = (int) character;
                    if (indx < 97) {
                        return indx - 65 + 27;
                    } else {
                        return indx - 96;
                    }
                })
                .reduce(Integer::sum)
                .orElse(0);

    }
}
