import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int numberOfPiles = scanner.nextInt();
			int numberOfChipsAtPile = 0;

			for (int j = 0; j < numberOfPiles; j++) {
				int element = scanner.nextInt();
				/**
				 * If the number of chips at a pile is even, a removal from the pile by one
				 * player can be negated by the other through making the same removal 
				 * (placing the removed chip on the same pile as the other player). 
				 * Therefore, if the number of elements in a pile is even, it has no influence 
				 * on the results.
				 * 
				 * Only piles with an odd number of chips have to be taken into account. 
				 * Thus, the problem can be looked upon as the standard Nim Game 
				 * (at each turn, removing one or more elements from a pile), where the number 
				 * of piles is equal to the piles with an odd number of chips, and the actual 
				 * number of chips per pile is equal to the number piles preceding a pile 
				 * with an odd number of chips.
				 * 
				 * In this way, XOR operations for the standard Nim Game can be applied.
				 */
				if (element % 2 != 0) {
					numberOfChipsAtPile = numberOfChipsAtPile ^ j;
				}
			}

			if (numberOfChipsAtPile != 0) {
				System.out.println("First");
			} else {
				System.out.println("Second");
			}
		}
		scanner.close();
	}
}
