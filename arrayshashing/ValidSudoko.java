package neetcode.arrayshashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoko {

    Set<String> seen = new HashSet<>();
    public boolean isValidSudoko(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if(!seen.add(num + " at row " + i) ||
                       !seen.add(num + "at row " + j) ||
                       !seen.add(num + " at box " + i/3 +"-"+j/3)) {
                        return false;
                    }
                }

            }
        }
        return true;
    }



}
