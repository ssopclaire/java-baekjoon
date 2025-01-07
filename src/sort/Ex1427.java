package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex1427 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			char[] digits = br.readLine().toCharArray();

			Arrays.sort(digits);

			StringBuilder sb = new StringBuilder();

			for (int i = digits.length - 1; i >= 0; i--) {
				sb.append(digits[i]);
			}

			System.out.println(sb);
		} catch (IOException e) {
		}
	}
}