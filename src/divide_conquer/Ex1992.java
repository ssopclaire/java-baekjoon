package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1992 {
    static int n;
    static char[][] a;
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            a = new char[n][n];

            for (int i = 0; i < n; i++) {
                a[i] = br.readLine().toCharArray();
            }

            quad(0, 0, n);

            System.out.print(out);
        } catch (IOException e) {
        }
    }

    static void quad(int r, int c, int s) {
        char v = a[r][c];

        for (int i = r; i < r + s; i++) {
            for (int j = c; j < c + s; j++) {
                if (a[i][j] != v) {
                    int h = s >> 1;

                    out.append('(');
                    quad(r, c, h);
                    quad(r, c + h, h);
                    quad(r + h, c, h);
                    quad(r + h, c + h, h);
                    out.append(')');

                    return;
                }
            }
        }

        out.append(v);
    }
}