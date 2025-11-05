import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		char[] s = br.readLine().toCharArray();
		char[] b = br.readLine().toCharArray();
		boolean isB;

		for (char c : s) {
			sb.append(c);

			if (sb.length() >= b.length) {
				isB = true;
				for (int i = 0; i < b.length; i++) {
					if (sb.charAt(sb.length() - b.length + i) != b[i]) {
						isB = false;
						break;
					}
				}

				if (isB) {
					sb.setLength(sb.length() - b.length);
				}
			}
		}

		if (sb.length() != 0) {
			System.out.println(sb);
		} else {
            System.out.println("FRULA");
		}
	}
}
