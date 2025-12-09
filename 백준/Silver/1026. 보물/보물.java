import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		Integer[] b = new Integer[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());

		int s = 0;
		for (int i = 0; i < n; i++) {
			s += a[i] * b[i];
		}

		System.out.println(s);
	}
}
