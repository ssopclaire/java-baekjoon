package greedy_algorithm1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex13305 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            long[] distances = new long[n - 1];
            long[] prices = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n - 1; i++) {
                distances[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                prices[i] = Long.parseLong(st.nextToken());
            }

            long minPrice = prices[0];
            long total = 0;

            for (int i = 0; i < n - 1; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                }

                total += minPrice * distances[i];
            }

            System.out.println(total);
        } catch (IOException e) {
        }
    }
}