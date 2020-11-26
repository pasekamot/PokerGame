import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class FiveCardDrawGame extends AbstractGame
{
  	// instantiate Deck and Player
	Deck deck;
	Player player = new Player();
	Card[] hand;
	private int HAND_SIZE = 5;

	public  FiveCardDrawGame()
		{
			setGameType(HAND_SIZE);
			deck = new Deck(HAND_SIZE);
		}

	@Override
	int setGameType(int handSize) {
		this.handSize = handSize;
		return handSize;
	}

	@Override
	public String play()
	{
		StringBuilder resultStringBuilder = new StringBuilder();

		try
			{
				// fill deck
				deck.fillDeck();

				// shuffle
				String shuffleResult = deck.shuffle();
				resultStringBuilder.append(shuffleResult+"\n");

				// player draws
				hand = player.draw(deck);

				// sort hand
				Arrays.sort(hand);

				// player redraws
				String handString = this.checkHand(hand);

				resultStringBuilder.append(handString);

				String evaluationResult = this.evaluate(hand);
				resultStringBuilder.append(evaluationResult);

				resultStringBuilder.append("\n\t\t\tThanks for playing! =]");
			}
		catch(Exception exc)
			{
				resultStringBuilder.append("\n\n\n\t\t\tFailed to start game:"+exc);
			}

		return resultStringBuilder.toString();
	}

	@Override
    public void makeHand()
	{
		hand[0].rank = 1;

		hand[1].rank = 2;

		hand[2].rank = 3;

		hand[3].rank = 4;

		hand[4].rank = 5;

		hand[0].suit = 1;

		hand[1].suit = 1;

		hand[2].suit = 1;

		hand[3].suit = 1;

		hand[4].suit = 1;

	}

}
