package advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println(input.equals(reversed) ? 1 : 0);
    }
}