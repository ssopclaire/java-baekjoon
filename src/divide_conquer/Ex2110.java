package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex2110 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] x = new int[n];

            for (int i = 0; i < n; i++) {
                x[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(x);

            long lo = 1;
            long hi = x[n - 1] - x[0];
            long ans = 0;

            while (lo <= hi) {
                long mid = (lo + hi) >>> 1;

                if (canPlace(x, c, mid)) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            System.out.println(ans);
        } catch (IOException e) {
        }
    }

    private static boolean canPlace(int[] x, int c, long mid) {
        int cnt = 1;
        int last = x[0];

        for (int i = 1; i < x.length; i++) {
            if (x[i] - last >= mid) {
                cnt++;
                last = x[i];
            }
        }

        return cnt >= c;
    }
}