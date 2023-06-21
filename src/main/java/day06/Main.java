package day06;

import java.util.Queue;

public class Main {
    public static void main(String[] args) {

       DatastreamAnalysis datastreamAnalysis = new DatastreamAnalysis();
//       var result = datastreamAnalysis.getFirstMarkerIndex();
       var result = datastreamAnalysis.getFirstMarkerIndexForMessage();

        System.out.println(result);
    }
}
