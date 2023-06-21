package day08;

public class MaximumScenicViewCounter {
    public static int howMaximumTreesAreVisibleFromTreeHouse(int[][] tableOfTrees) {

        int numberOfMaximumVisibleTrees = 0;

        int numberOfRows = tableOfTrees.length;
        int numberOfColumns = tableOfTrees[0].length;

        throughRows:
        for (int i = 1; i < numberOfRows - 1; i++) {

            throughColumns:
            for (int j = 1; j < numberOfColumns - 1; j++) {

                int isVisibleTop = 0;
                int isVisibleBottom = 0;
                int isVisibleRight = 0;
                int isVisibleLeft = 0;

                // check trees in column
                for (int k = i - 1; k >= 0; k--) {
                    if (tableOfTrees[k][j] < tableOfTrees[i][j]) {
                        isVisibleTop++;
                    } else {
                        isVisibleTop++;
                        break;
                    }
                }

                for (int k = i + 1; k < numberOfRows; k++) {
                    if (tableOfTrees[k][j] < tableOfTrees[i][j]) {
                        isVisibleBottom++;
                    } else if (tableOfTrees[k][j] >= tableOfTrees[i][j]) {
                        isVisibleBottom++;
                        break;
                    }
                }

                // check trees in row
                for (int l = j - 1; l >= 0; l--) {
                    if (tableOfTrees[i][l] < tableOfTrees[i][j]) {
                        isVisibleLeft++;
                    } else if (
                            tableOfTrees[i][l] >= tableOfTrees[i][j]) {
                        isVisibleLeft++;
                        break;
                    }
                }


                for (int l = j + 1; l < numberOfColumns; l++) {
                    if (tableOfTrees[i][l] < tableOfTrees[i][j]) {
                        isVisibleRight++;
                    } else if (
                            tableOfTrees[i][l] >= tableOfTrees[i][j]) {
                        isVisibleRight++;
                        break;
                    }
                }
                int isVisible = isVisibleTop * isVisibleBottom * isVisibleLeft * isVisibleRight;
                if (isVisible > numberOfMaximumVisibleTrees) numberOfMaximumVisibleTrees = isVisible;
            }
        }

        return numberOfMaximumVisibleTrees;
    }

}
