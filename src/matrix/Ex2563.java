package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2563 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            boolean[][] paper = new boolean[100][100];
            int area = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                for (int row = x; row < x + 10; row++) {
                    for (int col = y; col < y + 10; col++) {
                        if (!paper[row][col]) {
                            paper[row][col] = true;
                            area++;
                        }
                    }
                }
            }

            System.out.println(area);
        } catch (IOException e) {
        }
    }
}