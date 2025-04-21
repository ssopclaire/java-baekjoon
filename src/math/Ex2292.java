package math;

import java.util.Scanner;

public class Ex2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.close();

        int count = 1;
        int range = 1;

        while (n > range) {
            range += 6 * count;
            count++;
        }

        System.out.println(count);
    }
}