import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(p); // 오름차순 정렬

		int[] wait = new int[n + 1];
		wait[0] = p[0];
		int total = p[0];
		for (int i = 1; i < n; i++) {
			wait[i] = p[i] + wait[i - 1];
			total += wait[i];
		}

		System.out.println(total);
	}
}
