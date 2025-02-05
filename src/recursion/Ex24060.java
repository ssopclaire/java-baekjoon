package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex24060 {
    static int n, k, count = 0, result = -1;
    static int[] a, tmp;

    public static void merge_sort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(left, mid);
            merge_sort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    public static void merge(int left, int mid, int right) {
        int i = left, j = mid + 1, t = 0;

        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                tmp[t++] = a[i++];
            } else {
                tmp[t++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[t++] = a[i++];
        }
        while (j <= right) {
            tmp[t++] = a[j++];
        }

        i = left;
        t = 0;

        while (i <= right) {
            a[i++] = tmp[t];
            count++;
            if (count == k) {
                result = tmp[t];
            }
            t++;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            a = new int[n];
            tmp = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            merge_sort(0, n - 1);

            System.out.println(result);
        } catch (IOException e) {
        }
    }
}