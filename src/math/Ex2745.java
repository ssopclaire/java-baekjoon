package math;

import java.util.Scanner;

public class Ex2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int b = sc.nextInt();

        System.out.println(Integer.parseInt(n, b));
    }
}