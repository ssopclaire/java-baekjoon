package factors_primes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4948 {
    static final int MAX = 123456 * 2;
    static boolean[] isNotPrime = new boolean[MAX + 1];
    static int[] primeCount = new int[MAX + 1];

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            sieve();

            while (true) {
                int n = Integer.parseInt(br.readLine());
                if (n == 0) break;

                int result = primeCount[2 * n] - primeCount[n];

                System.out.println(result);
            }
        } catch (IOException e) {
        }
    }

    private static void sieve() {
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i * i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = 1; i <= MAX; i++) {
            primeCount[i] = primeCount[i - 1] + (isNotPrime[i] ? 0 : 1);
        }
    }
}