package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex14215 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] sticks = new int[3];
            for (int i = 0; i < 3; i++) {
                sticks[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(sticks);
            int a = sticks[0], b = sticks[1], c = sticks[2];

            int result = (a + b > c) ? (a + b + c) : (a + b) * 2 - 1;
            System.out.println(result);
        } catch (IOException e) {
        }
    }
}