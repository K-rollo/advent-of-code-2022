package day14_falling_sand;

public final class PointInCave {
    private final int x;
    private final int y;
    private Status status;

    public PointInCave(int x, int y, Status status) {
        this.x = x;
        this.y = y;
        this.status = status;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Status status() {
        return status;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PointInCave[" +
                "x=" + x + ", " +
                "y=" + y + ", " +
                "status=" + status + ']';
    }

}
