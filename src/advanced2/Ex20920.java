package advanced2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex20920 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Map<String, Integer> freqMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String word = br.readLine();

                if (word.length() >= m) {
                    freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
                }
            }

            List<String> words = new ArrayList<>(freqMap.keySet());

            words.sort((w1, w2) -> {
                int freq1 = freqMap.get(w1);
                int freq2 = freqMap.get(w2);

                if (freq1 != freq2) {
                    return freq2 - freq1;
                }
                if (w1.length() != w2.length()) {
                    return w2.length() - w1.length();
                }
                return w1.compareTo(w2);
            });

            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                sb.append(word).append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}