package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1010 {
    public static long combination(int east, int west) {
        if (west > east - west) {
            west = east - west;
        }

        long result = 1;

        for (int i = 1; i <= west; i++) {
            result *= (east - i + 1);
            result /= i;
        }

        return result;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                System.out.println(combination(m, n));
            }
        } catch (IOException e) {
        }
    }
}