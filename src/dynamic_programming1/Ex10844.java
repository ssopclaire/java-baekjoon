package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10844 {
    static final long MOD = 1_000_000_000L;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            long[] cur = new long[10];
            long[] nxt = new long[10];

            for (int d = 1; d <= 9; d++) {
                cur[d] = 1;
            }

            for (int len = 2; len <= n; len++) {
                for (int d = 0; d <= 9; d++) {
                    long left = (d > 0) ? cur[d - 1] : 0;
                    long right = (d < 9) ? cur[d + 1] : 0;

                    nxt[d] = (left + right) % MOD;
                }

                long[] tmp = cur;
                cur = nxt;
                nxt = tmp;
            }

            long ans = 0;

            for (long v : cur) {
                ans = (ans + v) % MOD;
            }

            System.out.println(ans);
        } catch (IOException e) {
        }
    }
}