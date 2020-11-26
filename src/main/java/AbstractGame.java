public abstract class AbstractGame
{
	int handSize ;
	// instantiate Deck and Player
	Player player = new Player();
	Card[] hand;

	/*I have made it abstract to forced the user to specify the handsize
	as this will determine the type of the game to be played.
	 */
	abstract int setGameType(int handSize);

	/* This method enables the user to play the game.*/

	public abstract String play();

	/*I made the makehand method abstract to allow
	 it to be customized for different poker types(Specialization)*/
	public abstract void makeHand();

	/*The rest of the methods below are standard, common methods for a
	poker game hence I did not make them abstract.
	 */

	// tells player cards in hand
	public String checkHand(Card[] hand)
	{
		StringBuilder handStringBuilder = new StringBuilder();
		for (int handCounter = 0; handCounter < handSize; handCounter++)
		{
			handStringBuilder.append(this.display(hand[handCounter]));
		}
		return handStringBuilder.toString();
	}
	
	// evaluates the hand
	public String evaluate(Card[] hand)
	{
		String evaluation = null;
		if (this.royalFlush(hand) == 1)
		{
			evaluation = "\n\t\t\tYou have a royal flush!";
		}
		else if (this.straightFlush(hand) == 1)
		{
			evaluation = "\n\t\t\tYou have a straight flush!";
		}
		else if (this.fourOfaKind(hand) == 1)
		{
			evaluation = "\n\t\t\tYou have four of a kind!";
		}
		else if (this.fullHouse(hand) == 1)
		{
			evaluation = "\n\t\t\tYou have a full house!";
		}
		else if (this.flush(hand) == 1)
		{
			evaluation = "\n\t\t\tYou have a flush!";
		}
		else if (this.straight(hand) == 1)
		{
			evaluation = "\n\t\t\tYou have a straight!";
		}
		else if (this.triple(hand) == 1)
		{
			evaluation = "\n\t\t\tYou have a triple!";
		}
		else if (this.twoPairs(hand) == 1)
		{
			evaluation = "\n\t\t\tYou have two pairs!";
		}
		else if (this.pair(hand) == 1)
		{
			evaluation = "\n\t\t\tYou have a pair!";
		}
		else
		{
			int highCard = this.highCard(hand);
			evaluation = "\n\t\t\tYour highest card is " + highCard;
		}
		return evaluation;
	}
	
	// checks for a royal flush
	public int royalFlush(Card[] hand)
	{
		if (hand[0].rank == 1 && hand[1].rank == 10 && hand[2].rank == 11 &&
				hand[3].rank == 12 && hand[4].rank == 13)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	// checks for a straight flush
	public int straightFlush(Card[] hand)
	{
		for (int counter = 1; counter < handSize; counter++)
		{
			if (hand[0].suit != hand[counter].suit)
			{
				return 0;
			}
		}
		for (int counter2 = 1; counter2 < handSize; counter2++)
		{
			if (hand[counter2 - 1].rank != (hand[counter2].rank - 1))
			{
				return 0;
			}
				
		}
		return 1;
		
	}
	
	// checks for four of a kind
	public int fourOfaKind(Card[] hand)
	{
		if (hand[0].rank != hand[3].rank && hand[1].rank != hand[4].rank)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	// checks for full house
	public int fullHouse(Card[] hand)
	{
		int comparison = 0;
		for (int counter = 1; counter < handSize; counter++)
		{
			if (hand[counter - 1].rank == hand[counter].rank)
			{
				comparison++;
			}
		}
		if (comparison == 3)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	// checks for flush
	public int flush(Card[] hand)
	{
		for (int counter = 1; counter < handSize; counter++)
		{
			if (hand[0].suit != hand[counter].suit)
			{
				return 0;
			}
		}
		return 1;
	}
	
	// check for straight
	public int straight(Card[] hand)
	{
		for (int counter2 = 1; counter2 < handSize; counter2++)
		{
			if (hand[counter2 - 1].rank != (hand[counter2].rank - 1))
			{
				return 0;
			}
		}
		return 1;
	}
	
	// checks for triple
	public int triple(Card[] hand)
	{
		if (hand[0].rank == hand[2].rank || hand[2].rank == hand[4].rank)
		{
			return 1;
		}
		return 0;
	}
	
	// checks for two pairs
	public int twoPairs(Card[] hand)
	{
		int check = 0;
		for(int counter = 1; counter < handSize; counter++)
		{
			if (hand[counter - 1].rank == hand[counter].rank)
			{
				check++;
			}
		}
		if (check == 2)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	// check for pair
	public int pair(Card[] hand)
	{
		int check = 0;
		for(int counter = 1; counter < handSize; counter++)
		{
			if (hand[counter - 1].rank == hand[counter].rank)
			{
				check++;
			}
		}
		if (check == 1)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	// find highest card
	public int highCard(Card[] hand)
	{
		int highCard = 0;
		for (int counter = 0; counter < handSize; counter++)
		{
			if (hand[counter].rank > highCard)
			{
				highCard = hand[counter].rank;
			}
		}
		return highCard;
	}

	// generates string for each card in hand
	public String display(Card card)
	{
		String cardRank = null;
		String cardSuite = null;

		if (card.rank == 1)
		{
			cardRank = "A";
		}
		if (card.rank == 2)
		{
			cardRank = "2";
		}
		if (card.rank == 3)
		{
			cardRank = "3";
		}
		if (card.rank == 4)
		{
			cardRank = "4";
		}
		if (card.rank == 5)
		{
			cardRank = "5";
		}
		if (card.rank == 6)
		{
			cardRank = "6";
		}
		if (card.rank == 7)
		{
			cardRank = "7";
		}
		if (card.rank == 8)
		{
			cardRank = "8";
		}
		if (card.rank == 9)
		{
			cardRank =  "9";
		}
		if (card.rank == 10)
		{
			cardRank = "10";
		}
		if (card.rank == 11)
		{
			cardRank = "J";
		}
		if (card.rank == 12)
		{
			cardRank = "Q";
		}
		if (card.rank == 13)
		{
			cardRank = "K";
		}

		/*For the card suites I had added the ASCII codes
		to print out the actual card graphics but the console seems to not support these
		kind of ASCII codes so ? marks were just printed.
		* */

		if (card.suit == 1)
		{
			cardSuite = "Spade";//'\u2660';
		}
		if (card.suit == 2)
		{
			cardSuite = "Heart";//'\u2665';
		}
		if (card.suit == 3)
		{
			cardSuite = "Diamond";//'\u2666';
		}
		if (card.suit == 4)
		{
			cardSuite = "Club";//'\u2663';
		}
		if (cardRank!=null && cardSuite!=null)
		{
			return "\n\t\t\t"+cardRank +"-"+cardSuite+" ";
		}
		else
		{
			return null;
		}
	}
}
