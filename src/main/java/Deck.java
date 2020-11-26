import java.util.Random;

public class Deck 
{
	private final int DECK_SIZE = 52;
	private final int SHUFFLE_EXCHANGES = 2000;
	int handSize;
	public int restOfDeck = 6;
	
	Card[] deck = new Card[DECK_SIZE];
	Random r = new Random();

	/* I created this constructor with an argument of in handsize so
	* that the user can have the flexibility to change the deck to meet
	* their requirements.
	*  */
	public Deck(int handSize)
		{
			this.handSize = handSize;
		}

	// fill deck with cards
	public void fillDeck()
	{
		int counter = 0;
		for (int suit = 1; suit <= 4; suit++)
		{
			for (int rank = 1; rank <= 13; rank++)
			{
				deck[counter] = new Card();
				deck[counter].suit = suit;
				deck[counter].rank = rank;
				counter++;
			}
		}
	}
	
	// shuffle deck
	public String shuffle()
	{
		String action = "Shuffle ...Shuffle ...Shuffle ...";
		for (int x = 0; x <= SHUFFLE_EXCHANGES; x++)
		{
			int number1 = r.nextInt(DECK_SIZE);
			int number2 = r.nextInt(DECK_SIZE);
			Card temp = deck[number1];
			deck[number1] = deck[number2];
			deck[number2] = temp;

		}
		return action;
	}
	
	// deals number of cards specified in the constructor
	public Card[] deal()
	{
		Card[] hand = new Card[handSize];
		for (int deckPosition = 0; deckPosition < handSize; deckPosition++)
		{
			hand[deckPosition] = deck[deckPosition];
		}
		return hand;
	}
	
	// deals cards for redraw
	public Card redeal()
	{
		Card nextCard = deck[restOfDeck];
		restOfDeck++;
		return nextCard;
	}
	
	// refreshes deck position to 6 for next hand
	public void refreshDeckPosition()
	{
		restOfDeck = 6;
	}

}
