import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] charge = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			charge[i] = Integer.parseInt(br.readLine());
		}

		int[] weight = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			weight[i] = Integer.parseInt(br.readLine());
		}

		PriorityQueue<Integer> empty = new PriorityQueue<>();

		for (int i = 1; i <= n; i++) {
			empty.add(i);
		}

		Queue<Integer> wait = new ArrayDeque<>();

		int[] parkAt = new int[m + 1];

		int income = 0;

		for (int i = 0; i < 2 * m; i++) {
			int car = Integer.parseInt(br.readLine());
			if (car > 0) {
				if (!empty.isEmpty()) {
					int spot = empty.poll();
					parkAt[car] = spot;
					income += weight[car] * charge[spot];
				} else {
					wait.add(car);
				}
			} else {
				int currCar = -car;
				int spot = parkAt[currCar];

				if (!wait.isEmpty()) {
					int nextCar = wait.poll();
					parkAt[nextCar] = spot;
					income += weight[nextCar] * charge[spot];
				} else {
					empty.add(spot);
				}
			}
		}

		System.out.println(income);

	}
}
