import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] gem = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			gem[i][0] = Integer.parseInt(st.nextToken()); // 무게
			gem[i][1] = Integer.parseInt(st.nextToken()); // 가치
		}

		int[] bags = new int[k];
		for (int i = 0; i < k; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(gem, (a, b) -> a[0] - b[0]); // 무게에 대한 오름차순 정렬
		Arrays.sort(bags);

		// 무게만 넣는 최대 힙
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		long answer = 0;
		int index = 0;

		for (int bag : bags){

			while (index < n && gem[index][0] <= bag) {
				pq.add(gem[index][1]);
				index++;
			}

			if (!pq.isEmpty()) {
				answer += pq.poll();
			}

		}

		System.out.println(answer);

	}
}
