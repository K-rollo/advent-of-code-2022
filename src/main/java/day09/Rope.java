package day09;

public class Rope {

    public static double getRopeLength(Head head, Tail tail) {

        var headLocation = head.getLocation();
        var headX = headLocation.x();
        var headY = headLocation.y();

        var tailLocation = tail.getLocation();
        var tailX = tailLocation.x();
        var tailY = tailLocation.y();

        return Math.sqrt(  (headX-tailX)*(headX-tailX) + (headY-tailY)*(headY-tailY) );
    }
}
