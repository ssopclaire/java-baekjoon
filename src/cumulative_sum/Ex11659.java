package cumulative_sum;

import java.io.*;
import java.util.StringTokenizer;

public class Ex11659 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] prefixSum = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int j = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                bw.write((prefixSum[k] - prefixSum[j - 1]) + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}