package greedy_algorithm1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ex1931 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[][] meetings = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                meetings[i][0] = Integer.parseInt(st.nextToken());
                meetings[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(meetings,
                    Comparator.<int[]>comparingInt(m -> m[1])
                            .thenComparingInt(m -> m[0]));

            int count = 0, lastEnd = 0;

            for (int i = 0; i < n; i++) {
                if (meetings[i][0] >= lastEnd) {
                    lastEnd = meetings[i][1];

                    count++;
                }
            }

            System.out.println(count);
        } catch (IOException e) {
        }
    }
}