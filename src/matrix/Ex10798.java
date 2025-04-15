package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10798 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            char[][] board = new char[5][15];

            for (int i = 0; i < 5; i++) {
                String line = br.readLine();
                for (int j = 0; j < line.length(); j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < 15; j++) {
                for (int i = 0; i < 5; i++) {
                    if (board[i][j] != '\0') {
                        sb.append(board[i][j]);
                    }
                }
            }

            System.out.println(sb);
        } catch (IOException e) {
        }
    }
}