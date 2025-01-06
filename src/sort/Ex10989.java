package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex10989 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int numberCount = Integer.parseInt(br.readLine());

			int[] arr = new int[10001];

			for (int i = 0; i < numberCount; i++) {
				arr[Integer.parseInt(br.readLine())]++;
			}

			for (int i = 1; i < arr.length; i++) {
				while (arr[i]-- > 0) {
					bw.write(i + "\n");
				}
			}

			bw.flush();
			bw.close();
			br.close();

		} catch (Exception e) {
		}
	}
}