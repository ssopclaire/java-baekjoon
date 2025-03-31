package stringutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1152 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine().trim();

            if (input.isEmpty()) {
                System.out.println(0);
                return;
            }

            StringTokenizer st = new StringTokenizer(input);

            System.out.println(st.countTokens());
        } catch (IOException e) {
        }
    }
}