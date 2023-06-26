package day14_falling_sand;

public final class Sand {
    private int x;
    private int y;
    private boolean isStuck;

    public Sand(int x, int y, boolean isStuck) {
        this.x = x;
        this.y = y;
        this.isStuck = isStuck;
    }

    public void fall() {
        y++;
    }

    public void rollDownLeft() {
        x--;
        y++;
    }

    public void rollDownRight() {
        x++;
        y++;
    }

    public void stuck() {
        this.isStuck = true;
    }

    public void releaseFromStuck(){
        isStuck = false;
    }

    public int x() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int y() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isStuck() {
        return isStuck;
    }

    @Override
    public String toString() {
        return "Sand[" +
                "x=" + x + ", " +
                "y=" + y + ", " +
                "isStuck=" + isStuck + ']';
    }

}
