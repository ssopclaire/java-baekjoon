package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2798 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] cardNumbers = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                cardNumbers[i] = Integer.parseInt(st.nextToken());
            }

            int maxSum = 0;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int sum = cardNumbers[i] + cardNumbers[j] + cardNumbers[k];
                        if (sum <= m) {
                            maxSum = Math.max(maxSum, sum);
                        }
                    }
                }
            }

            System.out.println(maxSum);
        } catch (IOException e) {
        }
    }
}