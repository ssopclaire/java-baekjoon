package greedy_algorithm1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1541 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String expr = br.readLine();

            StringTokenizer minusTok = new StringTokenizer(expr, "-");

            int result = 0;
            boolean isFirst = true;

            while (minusTok.hasMoreTokens()) {
                String group = minusTok.nextToken();

                int groupSum = 0;

                StringTokenizer plusTok = new StringTokenizer(group, "+");

                while (plusTok.hasMoreTokens()) {
                    groupSum += Integer.parseInt(plusTok.nextToken());
                }

                if (isFirst) {
                    result += groupSum;
                    isFirst = false;
                } else {
                    result -= groupSum;
                }
            }

            System.out.println(result);
        } catch (IOException e) {
        }
    }
}