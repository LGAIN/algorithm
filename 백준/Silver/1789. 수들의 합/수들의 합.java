import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		long s = Long.parseLong(br.readLine());
		long n = 0;
		long i = 1;
		while (s >= i) {
			s -= i;
			n++;
			i++;
		}
		System.out.println(n);
	}
}
