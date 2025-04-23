package math;

import java.util.Scanner;

public class Ex1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int line = 1;

        while (n > line) {
            n -= line;
            line++;
        }

        int numerator = (line % 2 == 0) ? n : (line - n + 1);
        int denominator = (line % 2 == 0) ? (line - n + 1) : n;

        System.out.println(numerator + "/" + denominator);
    }
}