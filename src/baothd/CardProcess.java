package baothd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author USER
 *
 */
/**
 * @author USER
 *
 */
public class CardProcess {
	
	/**
	 * @param input
	 * @return List<Card> or Null if input is invalid
	 */
	public List<Card> changeInputToCards(String input) {
		String regex = "(S|H|D|C)([2-9]|10|J|Q|K|A)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		List<Card> cards = new ArrayList<Card>();
		while (matcher.find()) {
			String str = matcher.group();
			Card card = new Card(str.substring(0, 1), str.split(str.substring(0, 1))[1]);
			// System.out.println(card);
			cards.add(card);
		}
		cards = (cards.size() != 5) ? null : cards;
		return cards;
	}
	
	/**
	 * Use to determine how many pair, three same cards and four same cards the input have.
	 * @param cards
	 * @param input
	 * @return Result
	 */
	public Result cardProcess(List<Card> cards, String input) {
		String regex = "";
		int pair = 0, threeCards = 0, fourCards = 0;
		for (int index = 0, condition = cards.size(); index < condition; index++) {
			regex = "(" + cards.get(index).getRank() + ")";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(input);
			//return the number of matching String
			int counter = matcher.replaceAll("\0").split("\0", -1).length - 1;
			if(counter == 4) {
				fourCards++;
			} else if (counter == 3) {
				threeCards++;
			} else if (counter == 2) {
				pair++;
			}
			input = input.replace(cards.get(index).getRank(), "");
		}
		Result result = new Result(pair, threeCards, fourCards);
		return result;
	}
	
	
	/**
	 * Determine the string after get result.
	 * @param cards
	 * @param input
	 * @return String
	 */
	public String showResult(List<Card> cards, String input) {
		Result result = cardProcess(cards, input);
		//System.out.println(result);
		String resultString = "--";
		if(result.getFourCards() == 0) {
			if(result.getThreeCards() == 1){
				resultString = (result.getPair() == 1) ? "FH" : "3C";
			} else {
				if(result.getPair() == 2) {
					resultString = "2P";
				} else if (result.getPair() == 1) {
					resultString = "1P";
				}
			}
		} else if (result.getFourCards() == 1){
			resultString = "4C";
		}
		return resultString;
	}
	
}
