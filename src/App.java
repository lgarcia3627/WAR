import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class App {
List<String> names = List.of("Lisbeth", "Emmanuel", "Sebastian", "Fernanda", "Kevin"); 
 Random random = new Random();  
	
		public static void main(String[] args) {
			new App().playGame();
		}
		private void playGame() {
			Deck deck = new Deck();
			List<String> classPeople = new LinkedList<>(names);
			//System.out.println(deck);
			
			Player player1 = findPlayer(classPeople);
			Player player2 = findPlayer(classPeople); 
	
			System.out.println(player1 + " and " + player2 + " are playing the App game");
			
				//System.out.println("Player1 = " + player1 + " , player2 = " + player2);
				//System.out.println(deck.size());
			shuffleDeck(deck); 
				//System.out.println(deck);
				//System.out.println(deck.size());
			dealTheCards(deck, player1, player2); 
			
			playWar(player1, player2);
			
			findTheWinner(player1,player2); 
		
		}
		
		private void findTheWinner(Player player1, Player player2) {
			if(player1.getScore() > player2.getScore()) {
				System.out.println(player1 + " is the winner with the score of " + player1.getScore());
				System.out.println(player2 + " is the loser with the score of " + player2.getScore());
			}
			else if (player2.getScore() > player1.getScore()) {
				System.out.println(player2 + " is the winner with the score of " + player2.getScore());
				System.out.println(player1 + " is the loser with the score of " + player1.getScore());
			}
			else {
				System.out.println("Both" + player1 + "and" + player2 + "are big fat losers!!!");
			}
		}
		private void playWar(Player player1, Player player2) {
			int numCards = player1.getHand().size();
			
			for (int turn = 0; turn < numCards; turn++) {
				Card card1 = player1.flip(); 
				Card card2 = player2.flip();
				
			if(card1.getRank() > card2.getRank()) {
				player1.incrementScore();
			}
			else if(card2.getRank() > card1.getRank()) {
				player2.incrementScore();
			}
			}
			
		}
		private void dealTheCards(Deck deck, Player player1, Player player2) {
			int deckSize = deck.size();
			for(int index = 0; index < deckSize; index++) {
				if(index % 2 == 0) {
					player1.draw(deck);
					
					}
				else {
					player2.draw(deck); 
				}
			}
			
		}
		private void shuffleDeck(Deck deck) {
			deck.shuffle();
				//Collections.shuffle(deck.getCards());
			
		}
		private Player findPlayer(List<String> names) {
			int pos = random.nextInt(names.size());
			String name = names.remove(pos); 
			return new Player(name);
		}
	}


