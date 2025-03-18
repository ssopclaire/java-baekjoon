package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10811 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] baskets = new int[n];

            for (int i = 0; i < n; i++) {
                baskets[i] = i + 1;
            }

            for (int t = 0; t < m; t++) {
                st = new StringTokenizer(br.readLine());

                int i = Integer.parseInt(st.nextToken()) - 1;
                int j = Integer.parseInt(st.nextToken()) - 1;

                while (i < j) {
                    int temp = baskets[i];
                    baskets[i] = baskets[j];
                    baskets[j] = temp;
                    i++;
                    j--;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int num : baskets) {
                sb.append(num).append(" ");
            }

            System.out.println(sb);
        } catch (IOException e) {
        }
    }
}