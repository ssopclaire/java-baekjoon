package sort;

import java.util.Scanner;

public class Ex2587 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] arr = { 100, 100, 100 };
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			int num = scanner.nextInt();

			if (arr[0] > num) {
				arr[2] = arr[1];
				arr[1] = arr[0];
				arr[0] = num;
			} else if (arr[1] > num) {
				arr[2] = arr[1];
				arr[1] = num;
			} else if (arr[2] > num) {
				arr[2] = num;
			}

			sum += num;
		}

		int average = sum / 5;

		System.out.println(average);
		System.out.println(arr[2]);
	}
}