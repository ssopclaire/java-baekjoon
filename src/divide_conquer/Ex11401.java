package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11401 {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            System.out.println(binomialMod(n, k));
        } catch (IOException e) {
        }
    }

    static long binomialMod(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;

        if (k > n - k) k = n - k;

        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = (invFact[i] * i) % MOD;
        }

        long result = fact[n];
        result = (result * invFact[k]) % MOD;
        result = (result * invFact[n - k]) % MOD;

        return result;
    }

    static long modPow(long base, long exp) {
        long r = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) r = (r * base) % MOD;

            base = (base * base) % MOD;
            exp /= 2;
        }

        return r;
    }
}