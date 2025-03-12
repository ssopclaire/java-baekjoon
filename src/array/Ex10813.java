package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10813 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] baskets = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                baskets[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int temp = baskets[a];
                baskets[a] = baskets[b];
                baskets[b] = temp;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(baskets[i]).append(" ");
            }

            System.out.println(sb);
        } catch (IOException e) {
        }
    }
}