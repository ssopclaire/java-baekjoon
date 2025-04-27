package factors_primes;

import java.util.Scanner;

public class Ex2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        sc.close();

        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int sum = 0;
        int min = -1;

        for (int i = m; i <= n; i++) {
            if (!isNotPrime[i]) {
                sum += i;
                if (min == -1) {
                    min = i;
                }
            }
        }

        if (min == -1) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}