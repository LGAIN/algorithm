import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int cost = Integer.parseInt(br.readLine());
		int n = 1000 - cost;
		int answer = 0;
		int cnt_500 = n / 500;
		answer += cnt_500;
		int cnt_100 = (n % 500) / 100;
		answer += cnt_100;
		int cnt_50 = (n % 100) / 50;
		answer += cnt_50;
		int cnt_10 = (n % 50) / 10;
		answer += cnt_10;
		int cnt_5 = (n % 10) / 5;
		answer += cnt_5;
		int cnt_1 = n % 5;
		answer += cnt_1;
		System.out.println(answer);
	}
}
