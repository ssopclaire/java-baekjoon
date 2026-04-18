package dynamic_programming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11066 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder out = new StringBuilder();

            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                int k = Integer.parseInt(br.readLine());

                int[] sum = new int[k + 1];

                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int i = 1; i <= k; i++) {
                    sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
                }

                int[][] dp = new int[k + 1][k + 1];
                int[][] opt = new int[k + 1][k + 1];

                for (int i = 1; i <= k; i++) {
                    opt[i][i] = i;
                }

                for (int len = 2; len <= k; len++) {
                    for (int i = 1; i + len - 1 <= k; i++) {
                        int j = i + len - 1;

                        dp[i][j] = Integer.MAX_VALUE;

                        int start = opt[i][j - 1];
                        int end = opt[i + 1][j];

                        if (start < i) start = i;
                        if (end >= j) end = j - 1;

                        int costSum = sum[j] - sum[i - 1];

                        for (int mid = start; mid <= end; mid++) {
                            int cost = dp[i][mid] + dp[mid + 1][j] + costSum;

                            if (cost < dp[i][j]) {
                                dp[i][j] = cost;
                                opt[i][j] = mid;
                            }
                        }
                    }
                }

                out.append(dp[1][k]).append('\n');
            }

            System.out.print(out);
        } catch (IOException e) {
        }
    }
}