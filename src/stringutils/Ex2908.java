package stringutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2908 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int reversedA = reverseNumber(a);
            int reversedB = reverseNumber(b);

            System.out.println(Math.max(reversedA, reversedB));
        } catch (IOException | NumberFormatException e) {
        }
    }

    public static int reverseNumber(int num) {
        int reversed = 0;

        while (num > 0) {
            reversed = reversed * 10 + (num % 10);
            num /= 10;
        }

        return reversed;
    }
}