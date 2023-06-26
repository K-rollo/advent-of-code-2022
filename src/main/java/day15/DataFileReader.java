package day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader {

    int minX;
    int maxX;
    int minY;
    int maxY;

    List<Sensor> listOfSensors = new ArrayList<>();

    public List<Sensor> readFile(String inputPath) {
        try {
            var fileReader = new BufferedReader(new FileReader(inputPath));
            for (; ; ) {
                final var readLine = fileReader.readLine();
                if (readLine == null) break;
                int startSensorX = readLine.indexOf("x=");
                int endSensorX = readLine.indexOf(",");

                int startSensorY = readLine.indexOf("y=");
                int endSensorY = readLine.indexOf(":");

                int startBeaconX = readLine.lastIndexOf("x=");
                int endBeaconX = readLine.lastIndexOf(",");

                int startBeaconY = readLine.lastIndexOf("y=");
                int endBeaconY = readLine.length();

                var sensorX = Integer.valueOf(readLine.substring(startSensorX + 2, endSensorX));
                var sensorY = Integer.valueOf(readLine.substring(startSensorY + 2, endSensorY));
                var beaconX = Integer.valueOf(readLine.substring(startBeaconX + 2, endBeaconX));
                var beaconY = Integer.valueOf(readLine.substring(startBeaconY + 2));

                listOfSensors.add(new Sensor(sensorX, sensorY, beaconX, beaconY, Math.abs(sensorX - beaconX), Math.abs(sensorY - beaconY)));
            }
            fileReader.close();

            minX = listOfSensors.stream()
                    .map(sensor -> sensor.x() - (sensor.deltaX() + sensor.deltaY()))
                    .min(Integer::compare)
                    .orElse(-1);


            maxX = listOfSensors.stream()
                    .map(sensor -> sensor.x() + (sensor.deltaX() + sensor.deltaY()))
                    .max(Integer::compare)
                    .orElse(-1);

            minY = listOfSensors.stream()
                    .map(sensor -> sensor.y() - (sensor.deltaX() + sensor.deltaY()))
                    .min(Integer::compare)
                    .orElse(-1);

            maxY = listOfSensors.stream()
                    .map(sensor -> sensor.y() + (sensor.deltaX() + sensor.deltaY()))
                    .max(Integer::compare)
                    .orElse(-1);


        } catch (
                Exception e) {
            System.out.println(e);
        }
        return listOfSensors;
    }
}