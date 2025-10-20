package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex11054 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] a = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] lis = new int[n];
            int[] lds = new int[n];

            Arrays.fill(lis, 1);
            Arrays.fill(lds, 1);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i]) {
                        lis[i] = Math.max(lis[i], lis[j] + 1);
                    }
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j > i; j--) {
                    if (a[j] < a[i]) {
                        lds[i] = Math.max(lds[i], lds[j] + 1);
                    }
                }
            }

            int ans = 0;

            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, lis[i] + lds[i] - 1);
            }

            System.out.println(ans);
        } catch (IOException e) {
        }
    }
}