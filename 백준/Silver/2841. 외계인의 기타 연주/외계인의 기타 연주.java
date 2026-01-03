import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int count = 0;
		Stack<Integer>[] melody = new Stack[n + 1];
		for (int i = 1; i <= n; i++) {
			melody[i] = new Stack<>();
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());

			while (!melody[s].isEmpty() && melody[s].peek() > f) {
				melody[s].pop();
				count++;
			}

			if (!melody[s].isEmpty() && melody[s].peek() == f) {
				continue;
			}

			melody[s].push(f);
			count++;
		}
		System.out.println(count);
	}
}
