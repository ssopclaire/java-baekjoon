package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1806 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int left = 0;
            int minLen = Integer.MAX_VALUE;
            long sum = 0;

            for (int right = 0; right < n; right++) {
                sum += arr[right];

                while (sum >= s) {
                    minLen = Math.min(minLen, right - left + 1);

                    sum -= arr[left];
                    left++;
                }
            }

            if (minLen == Integer.MAX_VALUE) {
                System.out.println(0);
            } else {
                System.out.println(minLen);
            }
        } catch (IOException e) {
        }
    }
}