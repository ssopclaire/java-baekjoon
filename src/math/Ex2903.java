package math;

import java.util.Scanner;

public class Ex2903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int pointsPerSide = (1 << n) + 1;
        int totalPoints = pointsPerSide * pointsPerSide;

        System.out.println(totalPoints);

        sc.close();
    }
}