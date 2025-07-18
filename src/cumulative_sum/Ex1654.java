package cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1654 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            long[] cables = new long[k];

            long max = 0;

            for (int i = 0; i < k; i++) {
                cables[i] = Long.parseLong(br.readLine());

                if (cables[i] > max) {
                    max = cables[i];
                }
            }

            long left = 1;
            long right = max;
            long result = 0;

            while (left <= right) {
                long mid = (left + right) / 2;
                long count = 0;

                for (long cable : cables) {
                    count += (cable / mid);
                }

                if (count >= n) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.println(result);
        } catch (IOException e) {
        }
    }
}