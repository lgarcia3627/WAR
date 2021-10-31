
public class Card {
	private String cardName; 
	private String suit;
	private int rank; 
public Card(String cardName, String suit, int rank) {
		this.cardName = cardName; 
		this.suit = suit; 
		this.rank = rank; 
		
	}
@Override
public String toString() {
	return getCardType() + ", rank=" + rank;
}
private String getCardType() {
	return cardName + " of " + suit;
	
}
public int getRank() {
	return rank;
}


}
