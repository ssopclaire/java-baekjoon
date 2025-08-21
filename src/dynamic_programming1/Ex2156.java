package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2156 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            long[] a = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                a[i] = Long.parseLong(br.readLine());
            }

            if (n == 1) {
                System.out.println(a[1]);
                return;
            }

            long[] dp = new long[n + 1];
            dp[1] = a[1];
            dp[2] = a[1] + a[2];

            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + a[i], dp[i - 3] + a[i - 1] + a[i]));
            }

            System.out.println(dp[n]);
        } catch (IOException e) {
        }
    }
}