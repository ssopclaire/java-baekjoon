package factors_primes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex17103 {
    static final int MAX = 1000000;
    static boolean[] isNotPrime = new boolean[MAX + 1];

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());

            sieve();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < t; i++) {
                int n = Integer.parseInt(br.readLine());
                int count = countGoldbachPartitions(n);

                sb.append(count).append('\n');
            }

            System.out.print(sb);
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
    }

    private static int countGoldbachPartitions(int n) {
        int count = 0;

        for (int i = 2; i <= n / 2; i++) {
            if (!isNotPrime[i] && !isNotPrime[n - i]) {
                count++;
            }
        }

        return count;
    }
}