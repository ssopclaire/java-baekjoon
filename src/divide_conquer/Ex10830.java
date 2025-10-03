package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10830 {
    static final int MOD = 1000;
    static int n;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken()) % MOD;
                }
            }

            int[][] r = pow(a, b);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(r[i][j]).append(' ');
                }

                sb.append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }

    static int[][] pow(int[][] a, long e) {
        if (e == 1) return a;

        int[][] half = pow(a, e / 2);
        int[][] sq = mul(half, half);

        return (e % 2 == 0) ? sq : mul(sq, a);
    }

    static int[][] mul(int[][] x, int[][] y) {
        int[][] z = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    z[i][j] = (int) ((z[i][j] + (long) x[i][k] * y[k][j]) % MOD);
                }
            }
        }

        return z;
    }
}