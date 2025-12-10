import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] cookies = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			cookies[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cookies);

		int left = 1;
		int right = cookies[n];
		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;

			for (int c : cookies) {
				cnt += c / mid;
			}

			if (cnt >= m) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}
}
