package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9461 {
    static long[] dp = new long[101];

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());

            dp[1] = dp[2] = dp[3] = 1;

            for (int i = 4; i <= 100; i++) {
                dp[i] = dp[i - 2] + dp[i - 3];
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());

                sb.append(dp[n]).append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}