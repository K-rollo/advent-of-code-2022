package day15;

public final class PointInCave {
    private final int x;
    private final int y;
    private Status status;

    public PointInCave(int x, int y, Status status) {
        this.x = x;
        this.y = y;
        this.status = status;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Status getStatus() {
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
