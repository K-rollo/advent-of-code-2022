package day09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MoveController {

    List<Character> listOfMoves = new ArrayList<>();
    Head head = new Head();
    Tail tail = new Tail();
    Set<PositionXY> setWithVisitedLocations = new HashSet<>();
    PositionXY previousHeadPosition = new PositionXY(0,0);

    public MoveController(List<Character> listOfMoves) {
        this.listOfMoves = listOfMoves;
    }

    public int getNumberOfVisitedByTailPositions() {
        for (int i = 0; i < listOfMoves.size(); i++) {

            var direction = listOfMoves.get(i);
            previousHeadPosition = head.getLocation();

            // head moves
            head.move(direction);

            //tail moves
            var ropeLength = Rope.getRopeLength(head, tail);
            if (ropeLength == 2.0) {
                tail.move(direction);
            } else if (ropeLength > 2.0) {
                tail.setPosition(previousHeadPosition);
            }

            setWithVisitedLocations.add(tail.getLocation());
            System.out.println(tail.getLocation());

        }
//        setWithVisitedLocations.forEach(System.out::println);


        return setWithVisitedLocations.size();
    }

}
