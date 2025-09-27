package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11444 {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long n = Long.parseLong(br.readLine());

            System.out.println(fib(n)[0]);
        } catch (IOException e) {
        }
    }

    static long[] fib(long n) {
        if (n == 0) return new long[]{0, 1};

        long[] f = fib(n >> 1);

        long a = f[0];
        long b = f[1];

        long c = (a * ((2 * b % MOD - a + MOD) % MOD)) % MOD;
        long d = (a * a % MOD + b * b % MOD) % MOD;

        long[] result = (n & 1) == 0 ? new long[]{c, d} : new long[]{d, (c + d) % MOD};

        return result;
    }
}