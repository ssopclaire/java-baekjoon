package advanced1;

import java.util.Scanner;

public class Ex3003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] correctPieces = {1, 1, 2, 2, 2, 8};
        int[] inputPieces = new int[6];

        for (int i = 0; i < 6; i++) {
            inputPieces[i] = sc.nextInt();
        }

        sc.close();

        for (int i = 0; i < 6; i++) {
            System.out.print((correctPieces[i] - inputPieces[i]) + " ");
        }
    }
}