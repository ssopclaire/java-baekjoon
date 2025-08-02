package dynamic_programming1;

import java.util.Scanner;

public class Ex24416 {
    static int cnt1 = 0;
    static int cnt2 = 0;

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt1++;
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            cnt2++;
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        fib(n);
        fibonacci(n);

        System.out.println(cnt1 + " " + cnt2);
    }
}