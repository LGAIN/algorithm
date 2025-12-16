import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void print(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static void refresh(int[] arr, int[] new_arr) {
		for (int i = 1; i < arr.length; i++) {
			arr[i] = new_arr[i];
		}
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[6];
		int[] new_arr = new int[6];
		for (int i = 1; i <= 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= 5; i++) {
			new_arr[i] = arr[i];
		}

		while (true) {
			if (arr[1] == 1 && arr[2] == 2 && arr[3] == 3 && arr[4] == 4 && arr[5] == 5) {
				break;
			}
			for (int i = 1; i <= 4; i++) {
				if (arr[i] > arr[i + 1]) {
					new_arr[i+1] = arr[i];
					new_arr[i] = arr[i+1];
					print(new_arr);
					refresh(arr, new_arr);
				}
			}
		}

	}
}
