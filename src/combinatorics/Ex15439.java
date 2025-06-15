package combinatorics;

import java.util.Scanner;

public class Ex15439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(n * (n - 1));
    }
}