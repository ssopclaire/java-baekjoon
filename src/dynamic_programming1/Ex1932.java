package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1932 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine().trim());

            int[] dp = new int[n];
            int[] row = new int[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int k = 0; k <= i; k++) {
                    row[k] = Integer.parseInt(st.nextToken());
                }

                for (int j = i; j >= 0; j--) {
                    if (j == 0) {
                        dp[0] += row[0];
                    } else if (j == i) {
                        dp[j] = dp[j - 1] + row[j];
                    } else {
                        dp[j] = Math.max(dp[j], dp[j - 1]) + row[j];
                    }
                }
            }

            int ans = 0;

            for (int v : dp) {
                ans = Math.max(ans, v);
            }

            System.out.println(ans);
        } catch (IOException e) {
        }
    }
}