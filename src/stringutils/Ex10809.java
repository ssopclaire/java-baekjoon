package stringutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10809 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();

            int[] positions = new int[26];
            for (int i = 0; i < 26; i++) {
                positions[i] = -1;
            }

            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (positions[index] == -1) {
                    positions[index] = i;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int pos : positions) {
                sb.append(pos).append(" ");
            }

            System.out.println(sb);
        } catch (IOException e) {
        }
    }
}