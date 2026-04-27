package dynamic_programming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1520 {
    static int m, n;
    static int[][] height;
    static int[][] dp;

    static final int[] DR = {-1, 1, 0, 0};
    static final int[] DC = {0, 0, -1, 1};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            height = new int[m][n];
            dp = new int[m][n];

            for (int row = 0; row < m; row++) {
                Arrays.fill(dp[row], -1);

                st = new StringTokenizer(br.readLine());

                for (int col = 0; col < n; col++) {
                    height[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(countPath(0, 0));
        } catch (IOException e) {
        }
    }

    static int countPath(int row, int col) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = 0;

        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + DR[direction];
            int nextCol = col + DC[direction];

            if (nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n) {
                continue;
            }

            if (height[nextRow][nextCol] < height[row][col]) {
                dp[row][col] += countPath(nextRow, nextCol);
            }
        }

        return dp[row][col];
    }
}