package combinatorics;

import java.util.Scanner;

public class Ex24723 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(1 << n);
    }
}