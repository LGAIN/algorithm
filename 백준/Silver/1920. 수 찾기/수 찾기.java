import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);

		int m = Integer.parseInt(br.readLine());
		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			int left = 0;
			int right = n-1;
			int mid = 0;
			int res = 0;
			while (left <= right) {
				mid = (left + right) / 2;
				if (arr[i] == a[mid]) {
					res = 1;
					break;
				} else if (a[mid] > arr[i]) {
					right = mid - 1;
				} else if (a[mid] < arr[i]) {
					left = mid + 1;
				}
			}
			System.out.println(res);
		}

	}

}
