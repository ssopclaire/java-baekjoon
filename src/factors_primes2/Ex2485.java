package factors_primes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex2485 {
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] trees = new int[n];
            for (int i = 0; i < n; i++) {
                trees[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(trees);

            int gapGCD = trees[1] - trees[0];
            for (int i = 2; i < n; i++) {
                int gap = trees[i] - trees[i - 1];
                gapGCD = gcd(gapGCD, gap);
            }

            int result = 0;
            for (int i = 1; i < n; i++) {
                result += (trees[i] - trees[i - 1]) / gapGCD - 1;
            }

            System.out.println(result);
        } catch (IOException e) {
        }
    }
}