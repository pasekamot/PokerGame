import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JUnitTest {

    @Test
        public void testCardSuitesAndRanks()
            {
                Deck deck = new Deck(5);
                Player player = new Player();
                FiveCardDrawGame fiveCardDrawGame = new FiveCardDrawGame();

                deck.fillDeck();

				Card[] hand = player.draw(deck);

                assertEquals(1, hand[0].rank);

                assertEquals(2, hand[1].rank);

                assertEquals(3, hand[2].rank);

                assertEquals(4, hand[3].rank);

                assertEquals(5, hand[4].rank);

                assertEquals(1, hand[0].suit);

                assertEquals(1, hand[1].suit);

                assertEquals(1, hand[2].suit);

                assertEquals(1, hand[3].suit);

                assertEquals(1, hand[4].suit);
            }
}
