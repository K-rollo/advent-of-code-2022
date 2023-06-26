package day15_sensors_and_beacons;

public record Sensor(Location locationXY, Location closestBeaconLocationXY, int deltaX, int deltaY) {
}
