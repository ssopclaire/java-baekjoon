package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex1450 {
    static int n;
    static long c;
    static long[] arr;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            arr = new long[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            ArrayList<Long> left = new ArrayList<>();
            ArrayList<Long> right = new ArrayList<>();

            dfs(0, n / 2, 0L, left);
            dfs(n / 2, n, 0L, right);

            Collections.sort(right);

            long count = 0;

            for (long x : left) {
                count += upperBound(right, c - x);
            }

            System.out.println(count);
        } catch (IOException e) {
        }
    }

    static void dfs(int start, int end, long sum, ArrayList<Long> list) {
        if (sum > c) return;

        if (start == end) {
            list.add(sum);
            return;
        }

        dfs(start + 1, end, sum, list);
        dfs(start + 1, end, sum + arr[start], list);
    }

    static int upperBound(ArrayList<Long> list, long target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}