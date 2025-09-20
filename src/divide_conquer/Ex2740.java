package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2740 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            int m2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] b = new int[m2][k];
            for (int i = 0; i < m2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < k; j++) {
                    b[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    if (j > 0) sb.append(' ');
                    long sum = 0;
                    for (int t = 0; t < m; t++) {
                        sum += (long) a[i][t] * b[t][j];
                    }
                    sb.append(sum);
                }
                sb.append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}