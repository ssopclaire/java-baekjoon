package sort;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex18870 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            int[] coordinates = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                coordinates[i] = Integer.parseInt(st.nextToken());
            }

            int[] sortedUnique = Arrays.stream(coordinates).distinct().sorted().toArray();

            Map<Integer, Integer> compressedMap = new HashMap<>();
            for (int i = 0; i < sortedUnique.length; i++) {
                compressedMap.put(sortedUnique[i], i);
            }

            StringBuilder sb = new StringBuilder();
            for (int coord : coordinates) {
                sb.append(compressedMap.get(coord)).append(" ");
            }

            bw.write(sb.toString().trim());
            bw.flush();

            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}