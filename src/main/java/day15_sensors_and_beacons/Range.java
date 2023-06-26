package day15_sensors_and_beacons;

public class Range {

    private final long start;

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    private final long end;

    public Range(long start, long end) {
        this.start = start;
        this.end = end;
    }
}
