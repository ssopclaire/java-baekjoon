package cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex25682 {
    static int[][] buildPrefixSum(char[][] board, int n, int m, boolean startWhite) {
        int[][] prefixSum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                boolean shouldBeWhite = ((i + j) % 2 == 0);
                char expected = (startWhite == shouldBeWhite) ? 'W' : 'B';
                int mismatch = (board[i][j] == expected) ? 0 : 1;

                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + mismatch;
            }
        }
        return prefixSum;
    }

    static int rangeSum(int[][] prefixSum, int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            char[][] board = new char[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                String line = br.readLine();

                for (int j = 1; j <= m; j++) {
                    board[i][j] = line.charAt(j - 1);
                }
            }

            int[][] whiteStart = buildPrefixSum(board, n, m, true);
            int[][] blackStart = buildPrefixSum(board, n, m, false);

            int minRepaint = Integer.MAX_VALUE;

            for (int i = k; i <= n; i++) {
                for (int j = k; j <= m; j++) {
                    int x1 = i - k + 1, y1 = j - k + 1;
                    int x2 = i, y2 = j;

                    int repaintW = rangeSum(whiteStart, x1, y1, x2, y2);
                    int repaintB = rangeSum(blackStart, x1, y1, x2, y2);

                    minRepaint = Math.min(minRepaint, Math.min(repaintW, repaintB));
                }
            }

            System.out.println(minRepaint);
        } catch (IOException e) {
        }
    }
}