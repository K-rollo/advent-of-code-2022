package day14_falling_sand;

public class SandFallingManager {

    private final ViewManager viewManager;
    int counter = 0;

    Sand currentSand;

    public SandFallingManager(ViewManager viewManager) {
        this.viewManager = viewManager;
        this.currentSand = new Sand(viewManager.dropPoint.x(), viewManager.dropPoint.y(), false);
    }

    public int run() {

        drop_loop:
        for (; ; ) {

            currentSand.setX(viewManager.dropPoint.x());
            currentSand.setY(viewManager.dropPoint.y());
            currentSand.releaseFromStuck();
            counter++;

            while (!currentSand.isStuck()) {

                int sandCurrentX = currentSand.x();
//                System.out.println(sandCurrentX);
                int sandCurrentY = currentSand.y();
//                System.out.println(sandCurrentY);

//                if (sandCurrentY == viewManager.bottomY -1 ) {
//                    break drop_loop;
//                }

                if (viewManager.findPointByXY(sandCurrentX, sandCurrentY + 1).status().equals(Status.AIR)) {
                    currentSand.fall();
                } else if (viewManager.findPointByXY(sandCurrentX - 1, sandCurrentY + 1).status().equals(Status.AIR)) {
                    currentSand.rollDownLeft();
                } else if (viewManager.findPointByXY(sandCurrentX + 1, sandCurrentY + 1).status().equals(Status.AIR)) {
                    currentSand.rollDownRight();
                } else {
                    currentSand.stuck();
                    var changeStatusAndVerifySand = viewManager.findPointByXY(sandCurrentX, sandCurrentY);
                    changeStatusAndVerifySand.updateStatus(Status.SAND);
                    if ((changeStatusAndVerifySand.x() == 500)
                            && (changeStatusAndVerifySand.y() == 0)
                            && (changeStatusAndVerifySand.status().equals(Status.SAND))){
                        break drop_loop;
                    }
                }

            }
//            if (counter > 674) viewManager.printCave();
//            System.out.println("New sand released : " + counter);
//            System.out.println("Current sand stuck on : " + currentSand.x() + " " + currentSand.y());
        }
        return counter;
    }
}

