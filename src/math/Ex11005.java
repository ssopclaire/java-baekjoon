package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11005 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");

            int n = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            StringBuilder sb = new StringBuilder();

            while (n > 0) {
                int remainder = n % b;
                sb.append(remainder < 10 ? (char) ('0' + remainder) : (char) ('A' + (remainder - 10)));
                n /= b;
            }

            System.out.println(sb.reverse());
        } catch (IOException e) {
        }
    }
}