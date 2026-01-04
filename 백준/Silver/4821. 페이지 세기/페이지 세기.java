import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) return;
			String[] line = br.readLine().split(",");
			int count = 0;
			int[] print = new int[n + 1];
			for (String s : line) {
				String[] queue = s.split("-");
				if (queue.length == 1){
					if (Integer.parseInt(queue[0]) <= n)
						print[Integer.parseInt(queue[0])] = 1;
				} else {
					int left = Integer.parseInt(queue[0]);
					int right = Integer.parseInt(queue[1]);

					if (left == right && right <= n) {
						print[left] = 1;
					} else if (left < right) {
						if (left > n) {
							continue;
						}else if (right < n){
							for (int i = left; i <= right; i++) {
								print[i] = 1;
							}
						} else {
							for (int i = left; i <= n; i++) {
								print[i] = 1;
							}
						}
					}
				}
			}
			for (int i = 1; i <= n; i++) {
				if (print[i] == 1) count++;
			}
			System.out.println(count);
		}
	}
}
