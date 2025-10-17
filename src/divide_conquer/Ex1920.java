package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1920 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());

            int[] a = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);

            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());

                sb.append(binarySearch(a, x) ? 1 : 0).append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }

    static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) return true;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}