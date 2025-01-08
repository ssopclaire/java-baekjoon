package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex1181 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int countWords = Integer.parseInt(br.readLine());

			Set<String> words = new HashSet<String>();

			for (int i = 0; i < countWords; i++) {
				words.add(br.readLine());
			}

			List<String> sortedWords = new ArrayList<String>(words);

			sortedWords.sort((a, b) -> {
				if (a.length() == b.length()) {
					return a.compareTo(b);
				} else {
					return Integer.compare(a.length(), b.length());
				}
			});

			for (String word : sortedWords) {
				bw.write(word + "\n");
			}

			bw.flush();
			bw.close();
			br.close();

		} catch (Exception e) {
		}
	}
}