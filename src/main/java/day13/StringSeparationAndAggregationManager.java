package day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StringSeparationAndAggregationManager {


    public List<StringWithAggregationLevel> generateStringsWithAggregationLevelsList(String lineOfChars) {

        List<StringWithAggregationLevel> stringsWithAggregationLevels = new ArrayList<>();
        int openedBraces = 0;
        Stack<Integer> indexOfOpeningBraces = new Stack<>();

        for (int i = 0; i < lineOfChars.length(); i++) {

            var currentChar = lineOfChars.charAt(i);
            if (currentChar == '[') {
                indexOfOpeningBraces.push(i);
                openedBraces++;
            } else if (currentChar == ']') {
                var indexOfLastOpeningBrace = indexOfOpeningBraces.pop();
                var currentSubstring = lineOfChars.substring(indexOfLastOpeningBrace, i+1);
                stringsWithAggregationLevels.add(new StringWithAggregationLevel(currentSubstring, openedBraces));
                openedBraces--;
            }


        }

        return stringsWithAggregationLevels;


    }


}
