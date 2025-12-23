import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			int[] a = new int[4];
			int[] b = new int[4];
			for (int i = 0; i < 4; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 4; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			// 공통 부분이 없음
			if (a[2] < b[0] || a[0] > b[2] || a[3] < b[1] || a[1] > b[3]) {
				System.out.println("d");
			}
			// 점으로 겹치는 경우
			else if ((a[2] == b[0] && a[3] == b[1]) ||
				(a[0] == b[2] && a[3] == b[1]) ||
				(a[2] == b[0] && a[1] == b[3]) ||
				(a[0] == b[2] && a[1] == b[3])) {
				System.out.println("c");
			}
			// 선분으로 겹치는 경우
			else if ((a[2] == b[0] || a[0] == b[2]) ||
				(a[3] == b[1] || a[1] == b[3]) ){
				System.out.println("b");
			}
			// 겹치는 부분이 없음
			else {
				System.out.println("a");
			}

		}
	}
}
