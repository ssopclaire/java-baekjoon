package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex2470 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int left = 0;
            int right = n - 1;

            int answer1 = arr[left];
            int answer2 = arr[right];

            long minAbs = Long.MAX_VALUE;

            while (left < right) {
                long sum = (long) arr[left] + arr[right];
                long absSum = Math.abs(sum);

                if (absSum < minAbs) {
                    minAbs = absSum;
                    answer1 = arr[left];
                    answer2 = arr[right];
                }

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    break;
                }
            }

            System.out.println(answer1 + " " + answer2);
        } catch (IOException e) {
        }
    }
}