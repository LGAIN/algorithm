import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		HashSet<String> log = new HashSet<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();

			if (status.equals("enter")) {
				log.add(name);
			} else if (status.equals("leave")) {
				log.remove(name);
			}
		}

		List<String> list = new ArrayList<>(log);
		Collections.sort(list, Collections.reverseOrder());
		for (int i = 0; i < log.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
