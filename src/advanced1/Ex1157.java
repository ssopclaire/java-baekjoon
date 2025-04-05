package advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1157 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine().toUpperCase();

            int[] alphaCount = new int[26];
            int maxCount = 0;
            char maxChar = '?';

            for (char c : input.toCharArray()) {
                int index = c - 'A';
                alphaCount[index]++;

                if (alphaCount[index] > maxCount) {
                    maxCount = alphaCount[index];
                    maxChar = c;
                } else if (alphaCount[index] == maxCount) {
                    maxChar = '?';
                }
            }

            System.out.println(maxChar);
        } catch (IOException e) {
        }
    }
}