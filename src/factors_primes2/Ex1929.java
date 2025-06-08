package factors_primes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1929 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            boolean[] isPrime = getPrimeArray(n);

            StringBuilder sb = new StringBuilder();

            for (int i = m; i <= n; i++) {
                if (isPrime[i]) {
                    sb.append(i).append('\n');
                }
            }

            System.out.println(sb);
        } catch (IOException e) {
        }
    }

    private static boolean[] getPrimeArray(int limit) {
        boolean[] isPrime = new boolean[limit + 1];

        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}