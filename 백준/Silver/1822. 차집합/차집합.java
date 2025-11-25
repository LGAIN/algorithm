import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		HashSet<Integer> setA = new HashSet<>();
		HashSet<Integer> setB = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}
		for (int x : setA) {
			if (!setB.contains(x)) {
				list.add(x);
			}
		}
		Collections.sort(list);
		if (list.size() == 0) {
			System.out.println(0);
		} else {
			System.out.println(list.size());
			for (int x : list) {
				System.out.print(x + " ");
			}
		}
	}
}
