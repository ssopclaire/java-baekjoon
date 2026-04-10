package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex1644 {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            if (n < 2) {
                System.out.println(0);
                return;
            }

            boolean[] isComposite = new boolean[n + 1];

            List<Integer> primes = new ArrayList<>();

            for (int i = 2; i * i <= n; i++) {
                if (!isComposite[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        isComposite[j] = true;
                    }
                }
            }

            for (int i = 2; i <= n; i++) {
                if (!isComposite[i]) {
                    primes.add(i);
                }
            }

            int left = 0, right = 0;
            int sum = 0;
            int count = 0;

            while (true) {
                if (sum >= n) {
                    if (sum == n) count++;

                    sum -= primes.get(left++);
                } else {
                    if (right == primes.size()) break;

                    sum += primes.get(right++);
                }
            }

            System.out.println(count);
        } catch (IOException e) {
        }
    }
}