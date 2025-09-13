package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1780 {
    static int n;
    static int[][] a;
    static int[] cnt = new int[3];

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            a = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve(0, 0, n);

            System.out.printf("%d%n%d%n%d%n", cnt[0], cnt[1], cnt[2]);
        } catch (IOException e) {
        }
    }

    static void solve(int r, int c, int size) {
        if (isUniform(r, c, size)) {
            cnt[a[r][c] + 1]++;

            return;
        }

        int sub = size / 3;

        for (int dr = 0; dr < 3; dr++) {
            for (int dc = 0; dc < 3; dc++) {
                solve(r + dr * sub, c + dc * sub, sub);
            }
        }
    }

    static boolean isUniform(int r, int c, int size) {
        int v = a[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (a[i][j] != v) {
                    return false;
                }
            }
        }

        return true;
    }
}