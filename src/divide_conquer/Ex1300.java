package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1300 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            long k = Long.parseLong(br.readLine());

            long lo = 1, hi = (long) n * n;

            while (lo < hi) {
                long mid = (lo + hi) / 2;

                if (count(n, mid) >= k) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            System.out.println(lo);
        } catch (IOException e) {
        }
    }

    static long count(int n, long x) {
        long cnt = 0;

        for (int i = 1; i <= n; i++) {
            cnt += Math.min(n, x / i);
        }

        return cnt;
    }
}