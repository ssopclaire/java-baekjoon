package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex2565 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (a, b) -> a[0] - b[0]);

            int[] lis = new int[n];

            int len = 0;

            for (int i = 0; i < n; i++) {
                int x = arr[i][1];

                int idx = Arrays.binarySearch(lis, 0, len, x);

                if (idx < 0) {
                    idx = -idx - 1;
                }

                lis[idx] = x;

                if (idx == len) {
                    len++;
                }
            }

            System.out.println(n - len);
        } catch (IOException e) {
        }
    }
}