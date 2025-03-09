package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2562 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] numbers = new int[9];
            int max = 0;
            int index = 0;

            for (int i = 0; i < 9; i++) {
                numbers[i] = Integer.parseInt(br.readLine());

                if (numbers[i] > max) {
                    max = numbers[i];
                    index = i + 1;
                }
            }

            System.out.println(max);
            System.out.println(index);
        } catch (IOException e) {
        }
    }
}