package baothd;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardProcess {
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
	
	public String showResult(List<Card> cards, String input) {
		Result result = cardProcess(cards, input);
		//System.out.println(result);
		String resultString = "";
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
		} else {
			resultString = "4C";
		}
		return resultString;
	}
	
}
