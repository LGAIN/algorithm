import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 트럭 수
		int w = Integer.parseInt(st.nextToken()); // 다리 길이
		int l = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

		st = new StringTokenizer(br.readLine());
		Queue<Integer> bridge = new LinkedList<>();
		Queue<Integer> wait = new LinkedList<>();

		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}

		for (int i = 0; i < n; i++) {
			wait.add(Integer.parseInt(st.nextToken()));
		}
		int weight = 0;
		int time = 0;

		while (!bridge.isEmpty()) {
			time++;

			weight -= bridge.poll();

			if (!wait.isEmpty()) {
				if (wait.peek() + weight <= l) {
					int truck = wait.poll();
					bridge.add(truck);
					weight += truck;
				} else {
					bridge.add(0);
				}
			}
		}
		System.out.println(time);
	}
}
