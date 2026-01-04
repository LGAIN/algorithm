import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int toPos(int dir, int d, int w, int h) {
		if (dir == 1) return d;
		if (dir == 2) return w + h + (w - d);
		if (dir == 3) return 2 * w + h + (h - d);
		if (dir == 4) return w + d;
		return 0;
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		int[] store = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			store[i] = toPos(dir, d, w, h);
		}
		st = new StringTokenizer(br.readLine());
		int dongDir = Integer.parseInt(st.nextToken());
		int dongD = Integer.parseInt(st.nextToken());
		int dong = toPos(dongDir, dongD, w, h);

		int P = 2 * (w + h);
		int ans = 0;

		for (int s : store) {
			int diff = Math.abs(dong - s);
			ans += Math.min(diff, P - diff);
		}
		System.out.println(ans);
	}
}
