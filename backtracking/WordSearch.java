package neetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    private char[][] board;
    private int ROWS;
    private int COLS;
    private String word;
    private Set<String> path = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(r,c,0)) {
                    return true;
                }
            }

        }

        return false;
    }

    private boolean dfs(int r, int c, int cur) {

        if(cur == word.length()) return true;

        if(r < 0 ||
           c < 0 ||
           r >= ROWS ||
           c >= COLS ||
           word.charAt(cur) != board[r][c] ||
           path.contains(r + "," + c) ) return false;

        path.add(r + "," + c);
        boolean res = dfs (r + 1, c, cur + 1) || dfs(r - 1, c, cur + 1) || dfs(r, c + 1, cur + 1) || dfs(r, c - 1, cur + 1);
        path.remove(r + "," + c);
        return res;
    }


}
