package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex5597 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            boolean[] submitted = new boolean[31];

            for (int i = 0; i < 28; i++) {
                int num = Integer.parseInt(br.readLine());
                submitted[num] = true;
            }

            for (int i = 1; i <= 30; i++) {
                if (!submitted[i]) {
                    System.out.println(i);
                }
            }

        } catch (IOException e) {
        }
    }
}