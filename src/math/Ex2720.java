package math;

import java.util.Scanner;

public class Ex2720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int change = sc.nextInt();

            int quarter = change / 25;
            change %= 25;

            int dime = change / 10;
            change %= 10;

            int nickel = change / 5;
            change %= 5;

            int penny = change;

            System.out.printf("%d %d %d %d\n", quarter, dime, nickel, penny);
        }

        sc.close();
    }
}