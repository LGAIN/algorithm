import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		long n = Integer.parseInt(st.nextToken());

		int[] arr = new int[k];

		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		long left = 1;
		long right = arr[k-1];

		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;
			for (long x : arr) {
				cnt += x / mid;
			}

			if (cnt >= n) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(right);
	}
}
