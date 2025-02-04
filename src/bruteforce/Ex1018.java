package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1018 {
    public static int getMinCount(int startRow, int startCol, String[] board) {
        String[] boardPattern = {"WBWBWBWB", "BWBWBWBW"};

        int whiteStartCount = 0;

        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                if (board[row].charAt(col) != boardPattern[row % 2].charAt(j)) {
                    whiteStartCount++;
                }
            }
        }

        return Math.min(whiteStartCount, 64 - whiteStartCount);
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String[] board = new String[n];

            for (int i = 0; i < n; i++) {
                board[i] = br.readLine();
            }

            int result = Integer.MAX_VALUE;

            for (int i = 0; i <= n - 8; i++) {
                for (int j = 0; j <= m - 8; j++) {
                    result = Math.min(result, getMinCount(i, j, board));
                }
            }

            System.out.println(result);
        } catch (IOException e) {
        }
    }
}