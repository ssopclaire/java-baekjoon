package advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex25206 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, Double> gradeMap = new HashMap<>();
            gradeMap.put("A+", 4.5);
            gradeMap.put("A0", 4.0);
            gradeMap.put("B+", 3.5);
            gradeMap.put("B0", 3.0);
            gradeMap.put("C+", 2.5);
            gradeMap.put("C0", 2.0);
            gradeMap.put("D+", 1.5);
            gradeMap.put("D0", 1.0);
            gradeMap.put("F", 0.0);

            double totalScore = 0, totalCredits = 0;

            for (int i = 0; i < 20; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();

                double credit = Double.parseDouble(st.nextToken());
                String grade = st.nextToken();

                if (grade.equals("P")) continue;

                totalScore += credit * gradeMap.get(grade);
                totalCredits += credit;
            }

            System.out.printf("%.6f\n", totalScore / totalCredits);
        } catch (IOException e) {
        }
    }
}