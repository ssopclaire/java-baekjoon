package dynamic_programming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11049 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] r = new int[n];
            int[] c = new int[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                r[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }

            long[][] dp = new long[n][n];

            for (int len = 2; len <= n; len++) {
                for (int i = 0; i + len - 1 < n; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Long.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                        long mulCost = (long) r[i] * c[k] * c[j];
                        long cost = dp[i][k] + dp[k + 1][j] + mulCost;

                        if (cost < dp[i][j]) {
                            dp[i][j] = cost;
                        }
                    }
                }
            }

            System.out.println(dp[0][n - 1]);
        } catch (IOException e) {
        }
    }
}