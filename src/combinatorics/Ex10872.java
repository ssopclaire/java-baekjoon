package combinatorics;

import java.util.Scanner;

public class Ex10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        System.out.println(result);
    }
}