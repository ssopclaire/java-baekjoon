package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15650 {
    static int n, m;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            output = new int[m];

            dfs(1, 0);

            System.out.println(sb);
        } catch (IOException e) {
        }
    }

    static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = start; i <= n; i++) {
            output[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}