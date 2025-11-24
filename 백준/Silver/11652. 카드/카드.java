import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> cards = new HashMap<>();
		int max = 0;
		long maxCard = 0;
		for (int i = 1; i <= n; i++) {
			long card = Long.parseLong(br.readLine());
			cards.put(card, cards.getOrDefault(card, 0) + 1);
			int count = cards.get(card);
			if (max < count || (max == count && maxCard > card)){
				max = count;
				maxCard = card;
			}
		}

		System.out.println(maxCard);
	}
}
