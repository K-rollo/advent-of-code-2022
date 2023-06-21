package day09;

public class Head {
    private int x = 0;
    private int y = 0;

    public void move(Character moveDirection) {

        switch (moveDirection) {
            case 'U' -> {
                y++;
                break;
            }
            case 'D' -> {
                y--;
                break;
            }
            case 'R' -> {
                x++;
                break;
            }
            case 'L' -> {
                x--;
                break;
            }
        }
    }

    public PositionXY getLocation() {
        return new PositionXY(x, y);
    }
}



