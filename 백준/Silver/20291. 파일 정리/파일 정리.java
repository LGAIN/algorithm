import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String[] file = br.readLine().split("\\.");
			map.put(file[1], map.getOrDefault(file[1], 0) + 1);
		}
		List<String> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		for (String key : keys) {
			System.out.println(key + " " + map.get(key));
		}

	}
}
