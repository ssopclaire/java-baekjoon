package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9251 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String a = br.readLine();
            String b = br.readLine();

            if (a.length() < b.length()) {
                String t = a;
                a = b;
                b = t;
            }

            char[] A = a.toCharArray();
            char[] B = b.toCharArray();

            int n = A.length;
            int m = B.length;

            int[] dp = new int[m + 1];

            for (int i = 1; i <= n; i++) {
                int prevDiagonal = 0;

                char ai = A[i - 1];

                for (int j = 1; j <= m; j++) {
                    int temp = dp[j];

                    if (ai == B[j - 1]) {
                        dp[j] = prevDiagonal + 1;
                    } else {
                        dp[j] = Math.max(dp[j], dp[j - 1]);
                    }

                    prevDiagonal = temp;
                }
            }

            System.out.println(dp[m]);
        } catch (IOException e) {
        }
    }
}