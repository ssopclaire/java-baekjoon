package dynamic_programming1;

import java.util.Scanner;

public class Ex12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();

            if (w > k) {
                continue;
            }

            for (int j = k; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }

        System.out.println(dp[k]);

        sc.close();
    }
}