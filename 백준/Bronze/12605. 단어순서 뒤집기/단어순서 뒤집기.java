import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			Stack<String> stack = new Stack<>();
			while (st.hasMoreTokens()) {
				stack.add(st.nextToken());
			}
			StringBuilder sb = new StringBuilder("");
			sb.append("Case #").append(i).append(": ");
			while (!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
			System.out.println(sb);
		}
	}
}
