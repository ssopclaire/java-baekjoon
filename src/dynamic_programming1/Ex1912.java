package dynamic_programming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1912 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int currentSum = Integer.parseInt(st.nextToken());
            int maxSum = currentSum;

            for (int i = 1; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());

                currentSum = Math.max(num, currentSum + num);
                maxSum = Math.max(maxSum, currentSum);
            }

            System.out.println(maxSum);
        } catch (IOException e) {
        }
    }
}