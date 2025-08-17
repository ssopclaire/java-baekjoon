package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1463 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            if (n <= 1) {
                System.out.println(0);
                return;
            }

            int[] minOps = new int[n + 1];
            minOps[1] = 0;

            for (int i = 2; i <= n; i++) {
                int minCount = minOps[i - 1] + 1;

                if (i % 2 == 0) minCount = Math.min(minCount, minOps[i / 2] + 1);
                if (i % 3 == 0) minCount = Math.min(minCount, minOps[i / 3] + 1);

                minOps[i] = minCount;
            }

            System.out.println(minOps[n]);
        } catch (IOException e) {
        }
    }
}