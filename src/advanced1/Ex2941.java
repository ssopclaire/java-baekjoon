package advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2941 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();

            String[] croatianAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

            for (String croatian : croatianAlphabets) {
                input = input.replace(croatian, "*");
            }

            System.out.println(input.length());
        } catch (IOException e) {
        }
    }
}