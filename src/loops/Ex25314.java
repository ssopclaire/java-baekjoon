package loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex25314 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n / 4; i++) {
                sb.append("long ");
            }
            sb.append("int");

            System.out.println(sb);
        } catch (IOException e) {
        }
    }
}