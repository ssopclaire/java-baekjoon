package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex11650 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {

			int n = scanner.nextInt();

			List<int[]> points = new ArrayList<int[]>();

			for (int i = 0; i < n; i++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				points.add(new int[] { x, y });
			}

			points.sort((p1, p2) -> {
				if (p1[0] != p2[0]) {
					return Integer.compare(p1[0], p2[0]);
				}
				return Integer.compare(p1[1], p2[1]);
			});

			for (int[] point : points) {
				System.out.println(point[0] + " " + point[1]);
			}
		} catch (Exception e) {
		}
	}
}