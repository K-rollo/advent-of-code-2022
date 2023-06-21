package day08;

public class VisibleTreesCounter {

    public static int howManyTreesAreVisibleFromOuside(int[][] tableOfTrees) {

        int numberOfVisibleTrees = 0;

        int numberOfRows = tableOfTrees.length;
        int numberOfColumns = tableOfTrees[0].length;

        int treesInFrame = (2 * numberOfRows + 2 * numberOfColumns) - 4;
        System.out.println(treesInFrame);

        throughRows:
        for (int i = 1; i < numberOfRows - 1; i++) {

            throughColumns:
            for (int j = 1; j < numberOfColumns - 1; j++) {

                boolean isVisibleTop = true;
                boolean isVisibleBottom= true;
                boolean isVisibleRight= true;
                boolean isVisibleLeft = true;

                // check trees in row
                for (int k = 0; k < i; k++) {
                    if (tableOfTrees[k][j] >= tableOfTrees[i][j]) {
                        isVisibleTop = false;
                        break;
                    }
                 }
                for (int k = i + 1; k < numberOfRows; k++) {
                    if (tableOfTrees[k][j] >= tableOfTrees[i][j]) {
                        isVisibleBottom = false;
                        break;
                    }
                }

                // check trees in column
                for (int l = 0; l < j; l++) {
                    if (tableOfTrees[i][l] >= tableOfTrees[i][j]){
                        isVisibleLeft = false;
                        break;
                    }

                }
                for (int l = j + 1; l < numberOfColumns; l++) {
                    if (tableOfTrees[i][l] >= tableOfTrees[i][j]) {
                        isVisibleRight = false;
                        break;
                    }
                }
                boolean isVisible = (isVisibleTop || isVisibleBottom || isVisibleLeft || isVisibleRight);
                if (isVisible) numberOfVisibleTrees++;
            }
        }

        numberOfVisibleTrees += treesInFrame;
        return numberOfVisibleTrees;
    }

}
