import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {
	//Card type 
List<String> cardType = List.of("Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King");
	//Suits: Diamond, Club
List<String> suits = List.of("Hearts", "Clubs", "Diamonds", "Spades");

List<Card> cards = new LinkedList<>();    //Deck has a list of cards


public Deck() {
	for(int index = 0; index < cardType.size(); index++) {
		String cardName = cardType.get(index); 
		int rank = index +1;
		
		for(String suit : suits) { 
			cards.add(new Card(cardName, suit, rank));
		}
	}
}
@Override
public String toString() {
	StringBuilder b = new StringBuilder();
	b.append("Cards in deck:\n"); 
	//print one card for each line
	// for in cards 
	for(Card card: cards) {
		b.append("  ").append(card).append("\n");
	}
	return b.toString(); 

}
public List<Card> getCards() {
	return cards;
}
public void shuffle() {
	Random random = new Random();
	List<Card> tempCards = new LinkedList<>(cards); 
	
	cards.clear();
	
	while(!tempCards.isEmpty()) {
		int pos = random.nextInt(tempCards.size());
		cards.add(tempCards.remove(pos));
		
	}
}
public int size() {
	return cards.size();
}
}

