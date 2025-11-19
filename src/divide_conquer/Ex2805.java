package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2805 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            int[] trees = new int[n];

            st = new StringTokenizer(br.readLine());

            int max = 0;

            for (int i = 0; i < n; i++) {
                trees[i] = Integer.parseInt(st.nextToken());

                if (trees[i] > max) {
                    max = trees[i];
                }
            }

            long left = 0;
            long right = max;
            long answer = 0;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                long sum = 0;

                for (int h : trees) {
                    if (h > mid) {
                        sum += (h - mid);
                    }
                }

                if (sum >= m) {
                    answer = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.println(answer);
        } catch (IOException e) {
        }
    }
}