package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2566 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[][] arr = new int[9][9];
            int max = -1;
            int row = 0, col = 0;

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    if (arr[i][j] > max) {
                        max = arr[i][j];
                        row = i + 1;
                        col = j + 1;
                    }
                }
            }

            System.out.println(max);
            System.out.println(row + " " + col);
        } catch (IOException e) {
        }
    }
}