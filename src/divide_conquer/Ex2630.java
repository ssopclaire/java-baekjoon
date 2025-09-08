package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2630 {
    static int[][] A;
    static int white, blue;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            A = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cut(0, 0, n);

            System.out.println(white);
            System.out.println(blue);
        } catch (IOException e) {
        }
    }

    static void cut(int r, int c, int size) {
        int color = A[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (A[i][j] != color) {
                    int h = size / 2;

                    cut(r, c, h);
                    cut(r, c + h, h);
                    cut(r + h, c, h);
                    cut(r + h, c + h, h);

                    return;
                }
            }
        }

        if (color == 0) {
            white++;
        } else {
            blue++;
        }
    }
}