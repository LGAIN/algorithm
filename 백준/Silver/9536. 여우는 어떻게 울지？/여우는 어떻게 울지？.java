import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			List<String> sounds = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));

			Set<String> known = new HashSet<>();

			while (true) {
				String line = br.readLine();
				if (line.equals("what does the fox say?")) {
					break;
				}

				String[] parts = line.split(" ");
				known.add(parts[2]);
			}

			StringBuilder sb = new StringBuilder();
			for (String s: sounds) {
				if (!known.contains(s)) {
					sb.append(s).append(" ");
				}
			}
			System.out.println(sb);
		}
	}
}
