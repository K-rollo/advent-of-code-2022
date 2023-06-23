package day12_hill_climbing.preparation;

import java.util.HashMap;
import java.util.Map;

public class CharacterDecryptor {
    private final Map<Character, Integer> heightDecryptionMap = new HashMap<>();

    public CharacterDecryptor(){
        heightDecryptionMap.put('S', 0);
        int firstCharacterASCIINumber = (int) 'a';
        int lastCharacterASCIINumber = (int) 'z';
        int characterAmount = lastCharacterASCIINumber - firstCharacterASCIINumber + 1;
        heightDecryptionMap.put('E', characterAmount + 1);
        for (int i = 0; i < characterAmount; i++) {
            int index = firstCharacterASCIINumber + i;
            heightDecryptionMap.put((char) index, i + 1);
        }
    }

    public int[][] decryptCharacter(char[][] matrixOfChars) {
        int height = matrixOfChars.length;
        int width = matrixOfChars[0].length;
        int[][] matrixOfLocationHeights = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                var localChar = matrixOfChars[i][j];
                if (!heightDecryptionMap.keySet().contains(localChar)) {
                    System.out.println(localChar);
                    continue;
                }
                matrixOfLocationHeights[i][j] = heightDecryptionMap.get(localChar);
            }
        }
        return matrixOfLocationHeights;
    }
}
