package greedy_algorithm1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex11399 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] p = new int[n];

            int i = 0;

            while (i < n) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens() && i < n) {
                    p[i++] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.sort(p);

            int sum = 0;
            int answer = 0;

            for (int x : p) {
                sum += x;
                answer += sum;
            }

            System.out.println(answer);
        } catch (IOException e) {
        }
    }
}