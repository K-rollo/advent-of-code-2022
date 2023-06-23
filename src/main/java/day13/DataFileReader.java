package day13;

public class DataFileReader {



        public static char[][] readFileAndGenerateHeightsMatrix(String inputPath) {
            List<String> listOfReadLines = new ArrayList<>();

            try {
                var fileReader = new BufferedReader(new FileReader(inputPath));

                for (; ; ) {
                    final var readLine = fileReader.readLine();
                    if (readLine == null) break;
                    listOfReadLines.add(readLine);
                }
                fileReader.close();
            } catch (
                    Exception e) {
                System.out.println(e);
            }

            // creates table/array of height in direct location
            int dimensionX = listOfReadLines.get(0).length();
            int dimensionY = listOfReadLines.size();
            char[][] matrixOfChars = new char[dimensionY][dimensionX];

            for (int r = 0; r < dimensionY; r++) {
                var readLine = listOfReadLines.get(r);
                for (int c = 0; c < dimensionX; c++) {
                    matrixOfChars[r][c] = readLine.charAt(c);
                }
            }
            return matrixOfChars;
        }
    }

}
