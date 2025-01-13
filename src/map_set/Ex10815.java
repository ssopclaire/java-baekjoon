package map_set;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex10815 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            Set<Integer> cardSet = new HashSet<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                cardSet.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            int[] results = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int query = Integer.parseInt(st.nextToken());
                results[i] = cardSet.contains(query) ? 1 : 0;
            }

            for (int result : results) {
                bw.write(result + " ");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}