import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		Queue<String>[] s = new LinkedList[n];
		Deque<String> q = new LinkedList<>();

		// 앵무새들이 가져온 단어 저장
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = new LinkedList<>();
			while (st.hasMoreTokens()) {
				s[i].add(st.nextToken());
			}
		}

		// 만들 수 있는 지 궁금한 문장 저장
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			q.add(st.nextToken());
		}


		while (!q.isEmpty()) {
			boolean matched = false;
			String word = q.peek();

			for (int i = 0; i < s.length; i++) {
				if (!s[i].isEmpty() && s[i].peek().equals(word)) {
					s[i].poll();
					q.poll();
					matched = true;
					break;
				}
			}
			if (!matched) {
				System.out.println("Impossible");
				return;
			}
		}

		for (int i = 0; i < n; i++) {
			if (!s[i].isEmpty()) {
				System.out.println("Impossible");
				return;
			}
		}

		System.out.println("Possible");

	}
}
