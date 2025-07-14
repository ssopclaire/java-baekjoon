package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9663 {
    static int n, count;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());

            col = new boolean[n];
            diag1 = new boolean[2 * n - 1];
            diag2 = new boolean[2 * n - 1];

            count = 0;

            dfs(0);

            System.out.println(count);
        } catch (IOException e) {
        }
    }

    static void dfs(int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = row + c;
            int d2 = row - c + n - 1;

            if (!col[c] && !diag1[d1] && !diag2[d2]) {
                col[c] = diag1[d1] = diag2[d2] = true;

                dfs(row + 1);

                col[c] = diag1[d1] = diag2[d2] = false;
            }
        }
    }
}