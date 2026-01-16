import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Queue<Integer>[] order = new ArrayDeque[200001];

		for (int i = 0; i < 200001; i++) {
			order[i] = new ArrayDeque<>();
		}


		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				int a = Integer.parseInt(st.nextToken());
				order[a].add(i);
			}
		}

		int[] ans = new int[n+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (!order[a].isEmpty()) {
				int who = order[a].poll();
				ans[who]++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
	}
}
