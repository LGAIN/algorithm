import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		HashSet<Integer> setA = new HashSet<>();
		HashSet<Integer> setB = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			int k = Integer.parseInt(st.nextToken());
			setB.add(k);
		}

		int count = 0;
		for (int x : setA) {
			if (setB.contains(x)) {
				count++;
			}
		}

		int result = (a + b) - count * 2 ;
		System.out.println(result);
	}
}
