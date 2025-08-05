package dynamic_programming1;

import java.util.Scanner;

public class Ex1904 {
    static final int MOD = 15746;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int a = 1;
        int b = 2;

        for (int i = 3; i <= n; i++) {
            int temp = (a + b) % MOD;
            a = b;
            b = temp;
        }

        System.out.println(b);
    }
}