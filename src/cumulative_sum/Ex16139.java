package cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex16139 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();

            int n = s.length();

            int[][] count = new int[26][n + 1];

            for (int i = 0; i < n; i++) {
                int ch = s.charAt(i) - 'a';

                for (int j = 0; j < 26; j++) {
                    count[j][i + 1] = count[j][i];
                }

                count[ch][i + 1]++;
            }

            int q = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < q; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                char c = st.nextToken().charAt(0);

                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                int idx = c - 'a';

                sb.append(count[idx][r + 1] - count[idx][l]).append('\n');
            }

            System.out.println(sb);
        } catch (IOException e) {
        }
    }
}