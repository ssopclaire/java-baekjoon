package stringutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex5622 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String word = br.readLine();

            Map<Character, Integer> dialMap = new HashMap<>();

            String[] dial = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

            for (int i = 0; i < dial.length; i++) {
                for (char c : dial[i].toCharArray()) {
                    dialMap.put(c, i + 3);
                }
            }

            int totalTime = 0;

            for (char c : word.toCharArray()) {
                totalTime += dialMap.get(c);
            }

            System.out.println(totalTime);
        } catch (IOException e) {
        }
    }
}