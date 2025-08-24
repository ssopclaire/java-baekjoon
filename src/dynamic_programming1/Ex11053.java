package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex11053 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] a = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                while (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }

                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] tails = new int[n];

            int len = 0;

            for (int x : a) {
                int i = Arrays.binarySearch(tails, 0, len, x);

                if (i < 0) {
                    i = -i - 1;
                }

                tails[i] = x;

                if (i == len) {
                    len++;
                }
            }

            System.out.println(len);
        } catch (IOException e) {
        }
    }
}