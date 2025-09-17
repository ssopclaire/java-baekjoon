package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex12015 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] tails = new int[n];
            int len = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                while (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }

                int x = Integer.parseInt(st.nextToken());

                int pos = lowerBound(tails, len, x);

                tails[pos] = x;
                if (pos == len) {
                    len++;
                }
            }

            System.out.println(len);
        } catch (IOException e) {
        }
    }

    static int lowerBound(int[] tails, int len, int x) {
        int l = 0, r = len;

        while (l < r) {
            int m = (l + r) / 2;

            if (tails[m] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}