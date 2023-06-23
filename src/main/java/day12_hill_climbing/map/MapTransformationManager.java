package day12_hill_climbing.map;

import day12_hill_climbing.preparation.CharacterDecryptor;
import day12_hill_climbing.preparation.DataFileReader;

public class MapTransformationManager {


    private final int[][] matrixOfLocationHeights;
    CharacterDecryptor characterDecryptor = new CharacterDecryptor();

    public int[][] getMatrixOfLocationHeights() {
        return matrixOfLocationHeights;
    }

    public MapTransformationManager(String path) {
        var matrixOfChars = DataFileReader.readFileAndGenerateHeightsMatrix(path);
        this.matrixOfLocationHeights = characterDecryptor.decryptCharacter(matrixOfChars);
    }
}
