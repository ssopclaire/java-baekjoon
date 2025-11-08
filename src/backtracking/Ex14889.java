package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14889 {
    static int n;
    static int[][] s;
    static boolean[] isSelected;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());

            s = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    s[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            isSelected = new boolean[n];

            isSelected[0] = true;

            dfs(1, 1);

            System.out.println(minDiff);
        } catch (IOException e) {
        }
    }

    static void dfs(int idx, int cnt) {
        if (cnt == n / 2) {
            int a = 0, b = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int pair = s[i][j] + s[j][i];

                    if (isSelected[i] && isSelected[j]) {
                        a += pair;
                    } else if (!isSelected[i] && !isSelected[j]) {
                        b += pair;
                    }
                }
            }

            int diff = Math.abs(a - b);

            if (diff < minDiff) minDiff = diff;

            return;
        }

        if (idx == n) return;

        if (cnt + (n - idx) < n / 2) return;

        isSelected[idx] = true;
        dfs(idx + 1, cnt + 1);

        isSelected[idx] = false;
        dfs(idx + 1, cnt);
    }
}