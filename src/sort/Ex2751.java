package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Ex2751 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int numberCount = Integer.parseInt(br.readLine());

			int[] arr = new int[numberCount];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(arr);

			for (int number : arr) {
				bw.write(number + "\n");
			}

			bw.flush();
			bw.close();
			br.close();

		} catch (Exception e) {
		}
	}
}