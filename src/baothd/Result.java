package baothd;

public class Result {
	private int pair;
	private int threeCards; 
	private int fourCards;
	
	public Result(int pair, int threeCards, int fourCards) {
		super();
		this.pair = pair;
		this.threeCards = threeCards;
		this.fourCards = fourCards;
	}
	public Result() {

	}
	public int getPair() {
		return pair;
	}
	public void setPair(int pair) {
		this.pair = pair;
	}
	public int getThreeCards() {
		return threeCards;
	}
	public void setThreeCards(int threeCards) {
		this.threeCards = threeCards;
	}
	public int getFourCards() {
		return fourCards;
	}
	public void setFourCards(int fourCards) {
		this.fourCards = fourCards;
	}
	@Override
	public String toString() {
		return "[pair=" + pair + ", threeCards=" + threeCards + ", fourCards=" + fourCards + "]";
	}
	
	
}
