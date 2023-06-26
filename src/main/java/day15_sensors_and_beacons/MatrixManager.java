package day15_sensors_and_beacons;

import java.util.*;

import static day15_sensors_and_beacons.Main.PATH;


public class MatrixManager {

    DataFileReader dataFileReader = new DataFileReader();
    List<Sensor> sensors;
    List<Range> listOfRanges = new ArrayList<>();
    List<Long> newRanges = new ArrayList<>();

    public MatrixManager() {
        this.sensors = dataFileReader.readFile(PATH);
    }


    public long checkExclusionsAmountInStrictLine(int lineNumber) {

        // for each sensor set point where is sensor, beacon and ad points, where beacon location is impossible
        sensors.stream().parallel().forEach(sensor -> {
//        sensors.forEach(sensor -> {
            long sensorX = sensor.locationXY().x();
            long sensorY = sensor.locationXY().y();

            // range in Manhattan distance
            final int range = sensor.deltaX() + sensor.deltaY();

            long minY = sensorY - range;
            long maxY = sensorY + range;

            // check condition that chosen y is in range of sensor scanning area
            if ((lineNumber >= minY) && (lineNumber <= maxY)) {

                // vertical distance from sensor y to strict line
                long sensorDeltaYToStrictLine = Math.abs(sensorY - lineNumber);

                // min and max x value in strict line
                long lineXMinValueForStrictLineNumber = sensorX - (range - sensorDeltaYToStrictLine);
                long lineXMaxValueForStrictLineNumber = sensorX + (range - sensorDeltaYToStrictLine);

                System.out.println("Sensor analyzed: " + dataFileReader.listOfSensors.indexOf(sensor));

                listOfRanges.add(new Range(lineXMinValueForStrictLineNumber, lineXMaxValueForStrictLineNumber));
            }
        });

        listOfRanges.sort(Comparator.comparing(Range::getStart));
        long start = listOfRanges.get(0).getStart();
        long end = listOfRanges.get(0).getEnd();

        for (int i = 1; i <= listOfRanges.size(); i++) {

            if (i == listOfRanges.size()) {
                newRanges.add(end - start);
            }

            // range starts in scope of previous range and end farther than ends previous - extends range
            else if ((listOfRanges.get(i).getStart() <= end) && (listOfRanges.get(i).getEnd() > end)) {
                end = listOfRanges.get(i).getEnd();
            }

            // range starts after end of previous range - adds range and starts new range
            else if (listOfRanges.get(i).getStart() > end) {
                newRanges.add(end - start);
                start = listOfRanges.get(i).getStart();
                end = listOfRanges.get(i).getEnd();
            }
        }

        return newRanges.stream()
                .reduce(Long::sum)
                .orElse(0L);
    }

    // ----------------------------------------------------------------------------------------------------------------------
    public long searchLine(int limit) {

        // for each sensor set point where is sensor, beacon and ad points, where beacon location is impossible

        int counter = 0;
        for (int k = 0; k < limit; k++) {
            final int lineNumber = counter;
//        sensors.stream().parallel().forEach(sensor -> {
            sensors.forEach(sensor -> {
                long sensorX = sensor.locationXY().x();
            long sensorY = sensor.locationXY().y();

                // range in Manhattan distance
                final long range = sensor.deltaX() + sensor.deltaY();

            long minY = sensorY - range;
            long maxY = sensorY + range;

                // check condition that chosen y is in range of sensor scanning area
                if ((lineNumber >= minY) && (lineNumber <= maxY)) {

                    // vertical distance from sensor y to strict line
                    long sensorDeltaYToStrictLine = Math.abs(sensorY - lineNumber);

                    // min and max x value in strict line
                    long lineXMinValueForStrictLineNumber = Math.max(sensorX - (range - sensorDeltaYToStrictLine), 0);
                    long lineXMaxValueForStrictLineNumber = Math.min(sensorX + (range - sensorDeltaYToStrictLine), limit);

//                    System.out.println("Sensor analyzed: " + dataFileReader.listOfSensors.indexOf(sensor));

                    listOfRanges.add(new Range(lineXMinValueForStrictLineNumber, lineXMaxValueForStrictLineNumber));
                }
            });

            listOfRanges.sort(Comparator.comparing(Range::getStart));
            long start = listOfRanges.get(0).getStart();
            long end = listOfRanges.get(0).getEnd();

            for (int i = 1; i <= listOfRanges.size(); i++) {

                if (i == listOfRanges.size()) {
                    newRanges.add(end - start);
                }

                // range starts in scope of previous range and end farther than ends previous - extends range
                else if ((listOfRanges.get(i).getStart() <= end) && (listOfRanges.get(i).getEnd() > end)) {
                    end = listOfRanges.get(i).getEnd();
                }

                // range starts after end of previous range - adds range and starts new range
                else if (listOfRanges.get(i).getStart() > end) {
                    newRanges.add(end - start);
                    start = listOfRanges.get(i).getStart();
                    end = listOfRanges.get(i).getEnd();
                }
            }

            var uncheckedLocationsInLine = newRanges.stream()
                    .reduce(Long::sum)
                    .orElse(0L);

            if (uncheckedLocationsInLine < limit) {
                long foundX = newRanges.get(0) + 1;
                long foundY = counter;
                System.out.println("Found unchecked location :");
                System.out.println("x = " + foundX + ", y = " + foundY);

                return foundX * 4000000 + foundY;
            }
            System.out.println("Analysed line :" + counter );
            listOfRanges.clear();
            newRanges.clear();
            counter++;
        }
        return -1;
    }
}
