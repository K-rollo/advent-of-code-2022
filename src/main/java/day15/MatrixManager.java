package day15;

import java.util.ArrayList;
import java.util.List;


import static day15.Main.PATH;

public class MatrixManager {

    private int leftX;
    private int rightX;
    private int topY;
    private int bottomY;
    int dimensionX;
    int dimensionY;

    DataFileReader dataFileReader = new DataFileReader();
    List<Sensor> sensors;
    List<PointInCave> pointsInCave = new ArrayList<>();

    public MatrixManager() {
        // read input data
        this.sensors = dataFileReader.readFile(PATH);
        // set matrix limit
        this.leftX = dataFileReader.minX;
        this.rightX = dataFileReader.maxX;
        this.topY = dataFileReader.maxY;
        this.bottomY = dataFileReader.minY;
        // define matrix dimensions
        this.dimensionX = rightX - leftX + 1;
        this.dimensionY = topY - bottomY + 1;
    }


    public void createMatrix() {
        for (int x = leftX; x <= rightX; x++) {
            for (int y = bottomY; y <= topY; y++) {
                var point = new PointInCave(x, y, Status.POSSIBLE_BEACON);
                pointsInCave.add(point);
            }
        }
    }

    public void fillMatrix() {

        int limit;
        int deviationInYDirection;
        int x;
        int y;

        for (Sensor sensor : dataFileReader.listOfSensors) {

            var pointToBeSetAsSensor = findPointByXY(sensor.x(), sensor.y());
            pointToBeSetAsSensor.updateStatus(Status.SENSOR);
            var pointToBeSetAsBeacon = findPointByXY(sensor.closestBeaconX(), sensor.closestBeaconY());
            pointToBeSetAsBeacon.updateStatus(Status.BEACON);

            limit = sensor.deltaX() + sensor.deltaY();

            // block surrounding area
            for (int i = -limit; i <= limit; i++) {

                deviationInYDirection = limit - Math.abs(i);

                for (int j = sensor.y() - deviationInYDirection; j <= sensor.y() + deviationInYDirection; j++) {

                    x = sensor.x() + i;
                    y = sensor.y() + j;

                    var pointToBlock = findPointByXY(x, y);

                    if (pointToBlock.getStatus() == Status.POSSIBLE_BEACON) {
                        pointToBlock.updateStatus(Status.IMPOSSIBLE_BEACON);
                    }

                }
            }
        }
    }

    public PointInCave findPointByXY(int x, int y) {
        var foundPoint = pointsInCave.stream()
                .filter(pnt -> pnt.getX() == x)
                .filter(pnt -> pnt.getY() == y)
                .toList();

        return foundPoint.get(0);

    }

    public void printCave() {

        char[][] caveView = new char[dimensionY][dimensionX];

        for (int i = 0; i < dimensionY; i++) {
            for (int j = 0; j < dimensionX; j++) {
                char sign = '?';
                var point = findPointByXY(leftX + j, bottomY + i);
                var status = point.getStatus();
                switch (status) {
                    case POSSIBLE_BEACON -> sign = '.';
                    case IMPOSSIBLE_BEACON -> sign = '#';
                    case SENSOR -> sign = 'S';
                    case BEACON -> sign = 'B';
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
