package advanced2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2447 {
    static char[][] arr;

    static final int CENTER_BLOCK = 5;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            arr = new char[n][n];

            drawStar(0, 0, n, false);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }

    static void drawStar(int x, int y, int n, boolean isBlank) {
        if (isBlank) {
            fillBlank(x, y, n);
            return;
        }

        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = n / 3;
        int count = 0;

        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                count++;

                if (count == CENTER_BLOCK) {
                    drawStar(i, j, size, true);
                } else {
                    drawStar(i, j, size, false);
                }
            }
        }
    }

    static void fillBlank(int x, int y, int N) {
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                arr[i][j] = ' ';
            }
        }
    }
}