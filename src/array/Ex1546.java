package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1546 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            double[] scores = new double[n];
            double m = 0, sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                scores[i] = Double.parseDouble(st.nextToken());
                m = Math.max(m, scores[i]);
            }

            for (int i = 0; i < n; i++) {
                sum += (scores[i] / m) * 100;
            }

            System.out.println(sum / n);
        } catch (IOException e) {
        }
    }
}