package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex3009 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] x = new int[3];
            int[] y = new int[3];

            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
            }

            int fourthX = (x[0] == x[1]) ? x[2] : (x[0] == x[2]) ? x[1] : x[0];
            int fourthY = (y[0] == y[1]) ? y[2] : (y[0] == y[2]) ? y[1] : y[0];

            System.out.println(fourthX + " " + fourthY);
        } catch (IOException e) {
        }
    }
}