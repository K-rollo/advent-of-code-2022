package day14_falling_sand;

import java.util.*;

public class ViewManager {

    List<PointInCave> points = new ArrayList<>();

    private int leftX = 330;
    private int rightX = 670;
    private int topY = 0;
    int bottomY = 170;

    PointInCave dropPoint;

    public ViewManager() {
        for (int x = leftX; x < rightX; x++) {
            for (int y = topY; y < bottomY; y++) {
                var point = new PointInCave(x, y, Status.AIR);
                points.add(point);
            }
        }
        dropPoint = findPointByXY(500, 0);
        dropPoint.updateStatus(Status.START_POINT);

    }

    public List<PointInCave> setObstacles(List<List<String>> obstaclesDescription) {

        for (List<String> singleObstacle : obstaclesDescription) {
            var obstacle = singleObstacle.stream()
                    .map(str -> str.split(","))
                    .map(list -> Arrays.stream(list)
                            .map(Integer::valueOf).toList())
                    .toList();

            for (int i = 0; i < obstacle.size() - 1; i++) {
                var startX = obstacle.get(i).get(0);
                var startY = obstacle.get(i).get(1);
                var endX = obstacle.get(i + 1).get(0);
                var endY = obstacle.get(i + 1).get(1);

                if (!Objects.equals(startX, endX)) {
                    for (int j = 0; j <= Math.abs(endX - startX); j++) {
                        int directionFactor = (endX - startX) / Math.abs(endX - startX); // +1 if right direction   and -1 if left direction
                        int newX = startX  + directionFactor * j;
                        var pt = findPointByXY(newX, startY);
                        pt.updateStatus(Status.ROCK);
                    }
                } else {
                    for (int k = 0; k <= Math.abs(endY - startY); k++) {
                        int directionFactor = (endY - startY) / Math.abs(endY - startY); // +1 if right direction   and -1 if left direction
                        int newY = startY + directionFactor * k;
                        var pt = findPointByXY(startX, newY);
                        pt.updateStatus(Status.ROCK);
                    }
                }
            }
        }
        return points;
    }


    public PointInCave findPointByXY(int x, int y) {
        var foundPoint = points.stream()
                .filter(pnt -> pnt.x() == x)
                .filter(pnt -> pnt.y() == y)
                .toList();

        return foundPoint.get(0);

    }

    public void printCave() {
        int dimensionX = rightX - leftX;
        int dimensionY = bottomY - topY;

        char[][] caveView = new char[dimensionY][dimensionX];

        for (int i = 0; i < dimensionY; i++) {
            for (int j = 0; j < dimensionX; j++) {
                char sign = '?';
                var point = findPointByXY(leftX + j, topY + i);
                var status = point.status();
                switch (status) {
                    case AIR -> sign = '.';
                    case ROCK -> sign = '#';
                    case SAND -> sign = 'o';
                    case START_POINT -> sign = '+';
                }
                caveView[i][j] = sign;

            }
        }
        for (int i = 0; i < dimensionY; i++) {
            for (int j = 0; j < dimensionX; j++) {
                System.out.print(caveView[i][j]);
            }
            System.out.println("");
        }
    }
}
