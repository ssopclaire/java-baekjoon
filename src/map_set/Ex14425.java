package map_set;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex14425 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Set<String> stringSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                stringSet.add(br.readLine());
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                if (stringSet.contains(br.readLine())) count++;
            }

            bw.write(String.valueOf(count));
            bw.flush();

            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}