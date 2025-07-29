package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex2580 {
    static int[][] board = new int[9][9];
    static boolean finished = false;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            boolean[][] rowCheck = new boolean[9][10];
            boolean[][] colCheck = new boolean[9][10];
            boolean[][] boxCheck = new boolean[9][10];

            List<int[]> blanks = new ArrayList<>();

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < 9; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[i][j] = num;

                    if (num == 0) {
                        blanks.add(new int[]{i, j});
                    } else {
                        int boxIdx = (i / 3) * 3 + (j / 3);

                        rowCheck[i][num] = true;
                        colCheck[j][num] = true;
                        boxCheck[boxIdx][num] = true;
                    }
                }
            }

            dfs(0, blanks, rowCheck, colCheck, boxCheck);
        } catch (IOException e) {
        }
    }

    static void dfs(int idx, List<int[]> blanks, boolean[][] rowCheck, boolean[][] colCheck, boolean[][] boxCheck) {
        if (finished) return;

        if (idx == blanks.size()) {
            printBoard();

            finished = true;

            return;
        }

        int[] pos = blanks.get(idx);
        int r = pos[0], c = pos[1];
        int boxIdx = (r / 3) * 3 + (c / 3);

        for (int num = 1; num <= 9; num++) {
            if (!rowCheck[r][num] && !colCheck[c][num] && !boxCheck[boxIdx][num]) {
                board[r][c] = num;
                rowCheck[r][num] = colCheck[c][num] = boxCheck[boxIdx][num] = true;

                dfs(idx + 1, blanks, rowCheck, colCheck, boxCheck);

                board[r][c] = 0;
                rowCheck[r][num] = colCheck[c][num] = boxCheck[boxIdx][num] = false;
            }
        }
    }

    static void printBoard() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}