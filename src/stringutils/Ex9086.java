package stringutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9086 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < t; i++) {
                String str = br.readLine();
                sb.append(str.charAt(0)).append(str.charAt(str.length() - 1)).append("\n");
            }

            System.out.println(sb);
        } catch (IOException e) {
        }
    }
}