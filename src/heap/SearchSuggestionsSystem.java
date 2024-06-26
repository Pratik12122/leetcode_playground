package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// Link : https://leetcode.com/problems/search-suggestions-system/description/
public class SearchSuggestionsSystem {

	public static void main(String[] args) {
		String[] products = { "mobile", "mouse", "moneypot", "monitor", "havana", "zebra", "ant" };

		String searchWord = "havana";

		suggestedProducts(products, searchWord).forEach(System.out::println);
	}

	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		PriorityQueue<String> productHeap = new PriorityQueue<String>();
		productHeap.addAll(Arrays.asList(products));
		var queryResult = new ArrayList<List<String>>();

		for (int i = 1; i <= searchWord.length(); i++) {
			String search = searchWord.substring(0, i);
			var searchResult = new ArrayList<String>();

			while (!productHeap.isEmpty() && !productHeap.peek().startsWith(search)) {
				productHeap.poll();
			}

			int productCount = 1;

			while (!productHeap.isEmpty() && productCount < 4) {
				if (productHeap.peek().startsWith(search)) {
					searchResult.add(productHeap.poll());
					productCount++;
				} else {
					break;
				}

			}

			queryResult.add(searchResult);
			productHeap.addAll(searchResult);
		}

		return queryResult;
	}

}
