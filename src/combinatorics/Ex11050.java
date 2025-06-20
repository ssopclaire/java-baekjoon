package combinatorics;

import java.util.Scanner;

public class Ex11050 {
    public static int binomial(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }

        int result = 1;

        for (int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        sc.close();

        System.out.println(binomial(n, k));
    }
}