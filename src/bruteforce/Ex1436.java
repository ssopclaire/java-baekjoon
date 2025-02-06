package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1436 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int number = 666;
            int count = 1;

            while (count != n) {
                number++;
                if (String.valueOf(number).contains("666")) {
                    count++;
                }
            }

            System.out.println(number);
        } catch (IOException e) {
        }
    }
}