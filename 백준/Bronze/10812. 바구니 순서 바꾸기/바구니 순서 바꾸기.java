import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] basket = new int [n+1];
		int[] new_basket = new int [n+1];
		for (int i = 1; i <= n; i++) {
			basket[i] = i;
			new_basket[i] = i;
		}
		for (int a = 0; a < m; a++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()); // begin
			int j = Integer.parseInt(st.nextToken()); // end
			int k = Integer.parseInt(st.nextToken()); // mid
			// 회전
			for (int b = i; b <= j; b++) {
				if (b + (k - i) <= j)
					new_basket[b] = basket[b + (k - i)];
				else
					new_basket[b] = basket[b + (k - i) - (j - i + 1)];
			}

			// 누적 반영
			for (int b = 1; b <= n; b++) {
				basket[b] = new_basket[b];
			}

		}

		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(new_basket[i]).append(" ");
		}
		System.out.println(sb);
	}
}
