package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10810 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] baskets = new int[n];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                int ball = Integer.parseInt(st.nextToken());

                for (int j = start; j <= end; j++) {
                    baskets[j] = ball;
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