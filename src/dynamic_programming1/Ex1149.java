package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1149 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[3];
            int[] prev = new int[3];

            StringTokenizer st = new StringTokenizer(br.readLine());

            dp[0] = Integer.parseInt(st.nextToken());
            dp[1] = Integer.parseInt(st.nextToken());
            dp[2] = Integer.parseInt(st.nextToken());

            for (int i = 1; i < n; i++) {
                prev[0] = dp[0];
                prev[1] = dp[1];
                prev[2] = dp[2];

                st = new StringTokenizer(br.readLine());

                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                dp[0] = r + Math.min(prev[1], prev[2]);
                dp[1] = g + Math.min(prev[0], prev[2]);
                dp[2] = b + Math.min(prev[0], prev[1]);
            }

            int ans = Math.min(dp[0], Math.min(dp[1], dp[2]));

            System.out.println(ans);
        } catch (IOException e) {
        }
    }
}