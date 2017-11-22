package baothd;

import java.util.List;
import java.util.Scanner;

public class Hand {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String cont = "";
		while (!cont.equals("N")) {
			System.out.println("Please input your card!");
			String input = scanner.nextLine();
			CardProcess cardProcess = new CardProcess();
			List<Card> cards = cardProcess.changeInputToCards(input);
			if (cards != null) {
				String result = cardProcess.showResult(cards, input);
				System.out.println("Result: " + result);
			} else {
				System.out.println("Your cards is invalid!");
			}
			System.out.println("Continue? Y/N");
			cont = scanner.nextLine();
		}
		scanner.close();
	}
}
