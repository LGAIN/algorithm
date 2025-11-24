import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> bestseller = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String book = br.readLine();
			bestseller.put(book, bestseller.getOrDefault(book, 0) + 1);
		}

		List<String> list = new ArrayList<>(bestseller.keySet());
		Collections.sort(list);

		int max = 0;
		String top = "";

		for (String x : list) {
			if (bestseller.getOrDefault(x, 0) > max) {
				max = bestseller.get(x);
				top = x;
			}
		}

		System.out.println(top);
	}
}
