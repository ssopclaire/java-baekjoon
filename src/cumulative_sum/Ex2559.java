package cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2559 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int windowSum = 0;

            for (int i = 0; i < k; i++) {
                windowSum += arr[i];
            }

            int max = windowSum;

            for (int i = k; i < n; i++) {
                windowSum = windowSum - arr[i - k] + arr[i];
                max = Math.max(max, windowSum);
            }

            System.out.println(max);
        } catch (IOException e) {
        }
    }
}