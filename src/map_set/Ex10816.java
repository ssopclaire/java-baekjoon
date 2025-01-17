package map_set;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex10816 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Map<Integer, Integer> cardCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            cardCount.put(num, cardCount.getOrDefault(num, 0) + 1);
        }

        int m = scanner.nextInt();
        int[] queries = new int[m];

        for (int i = 0; i < m; i++) {
            queries[i] = scanner.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int query : queries) {
            sb.append(cardCount.getOrDefault(query, 0)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}