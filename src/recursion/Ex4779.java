package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4779 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            int len = 1;
            for (int i = 0; i < n; i++) len *= 3;

            char[] arr = new char[len];
            Arrays.fill(arr, '-');

            cantor(arr, 0, len);

            System.out.println(arr);
        }

        sc.close();
    }

    static void cantor(char[] arr, int start, int len) {
        if (len == 1) return;

        int part = len / 3;

        for (int i = start + part; i < start + 2 * part; i++) {
            arr[i] = ' ';
        }

        cantor(arr, start, part);
        cantor(arr, start + 2 * part, part);
    }
}