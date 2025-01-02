package sort;

import java.util.Scanner;

public class Ex2750 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numberCount = scanner.nextInt();
		int[] arr = new int[numberCount];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		for (int val : arr) {
			System.out.println(val);
		}
	}
}