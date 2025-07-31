package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14888 {
    static int n;
    static int[] nums;
    static int[] ops = new int[4];
    static int maxAns = Integer.MIN_VALUE;
    static int minAns = Integer.MAX_VALUE;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            nums = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                ops[i] = Integer.parseInt(st.nextToken());
            }

            dfs(nums[0], 1);

            System.out.println(maxAns);
            System.out.println(minAns);
        } catch (IOException e) {
        }
    }

    static void dfs(int current, int idx) {
        if (idx == n) {
            maxAns = Math.max(maxAns, current);
            minAns = Math.min(minAns, current);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--;

                int next = applyOp(current, nums[idx], i);
                dfs(next, idx + 1);

                ops[i]++;
            }
        }
    }

    static int applyOp(int a, int b, int op) {
        switch (op) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                if (a < 0) {
                    return -(Math.abs(a) / b);
                } else {
                    return a / b;
                }
            default:
                throw new IllegalArgumentException();
        }
    }
}