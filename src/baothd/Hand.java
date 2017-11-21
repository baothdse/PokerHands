package baothd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hand {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String cont = "";
		while (!cont.equals("N")) {
			System.out.println("Please input your card!");
			String input = scanner.nextLine();
			String regex = "(S|H|D|C)([2-9]|10|J|Q|K|A)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(input);
			List<Card> cards = new ArrayList<Card>();
			CardProcess cardProcess = new CardProcess();
			while (matcher.find()) {
				String str = matcher.group();
				Card card = new Card(str.substring(0, 1), str.split(str.substring(0, 1))[1]);
				// System.out.println(card);
				cards.add(card);
			}
			boolean isValid = (cards.size() != 5) ? false : true;
			if (isValid == true) {
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
