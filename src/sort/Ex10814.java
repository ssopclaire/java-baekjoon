package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10814 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder sb = new StringBuilder();

			int n = Integer.parseInt(br.readLine());

			StringBuilder[] ageGroups = new StringBuilder[201];

			for (int i = 0; i <= 200; i++) {
				ageGroups[i] = new StringBuilder();
			}

			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split(" ");
				int age = Integer.parseInt(input[0]);
				String name = input[1];
				ageGroups[age].append(age).append(" ").append(name).append("\n");
			}

			for (int i = 1; i <= 200; i++) {
				if (ageGroups[i].length() > 0) {
					sb.append(ageGroups[i]);
				}
			}

			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}