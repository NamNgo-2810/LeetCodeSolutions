import java.util.*;

class ValidSudoku {
    // Problem 36: Valid Sudoku
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer> [] cols = new HashSet[9];
        Set<Integer> [] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if (curr == '.') continue;
                int num = (int) curr, idx = 3 * (i / 3) + j / 3;

                if (rows[i].contains(num) || cols[j].contains(num) || boxes[idx].contains(num))
                    return false;

                rows[i].add(num);
                cols[j].add(num);
                boxes[idx].add(num);
            }

        return true;
    }
}
