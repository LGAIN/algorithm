import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		char[][] sky = new char[h][w];
		int[][] answer = new int[h][w];

		for (int i = 0; i < h; i++) {
			String line = br.readLine();
			for (int j = 0; j < w; j++) {
				sky[i][j] = line.charAt(j);
			}
		}
		for (int i = 0; i < h; i++) {
			int last = -1; // 마지막 구름 위치
			for (int j = 0; j < w; j++) {
				if (sky[i][j] == 'c') {
					last = j;
					answer[i][j] = 0;
				} else {
					if (last == -1) answer[i][j] = -1;
					else answer[i][j] = j - last;
				}
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}

	}
}
