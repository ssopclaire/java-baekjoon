package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;

        for (int i = Math.max(1, n - (String.valueOf(n).length() * 9)); i < n; i++) {
            if (i + digitSum(i) == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    private static int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}