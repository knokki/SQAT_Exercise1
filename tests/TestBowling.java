import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBowling {
	private BowlingGame game;
	
	@Before
	public void setUp(){
		this.game = new BowlingGame();
	}

	@Test(expected = BowlingException.class)
	public void TestFrameInWithCorrectValues() throws BowlingException{
		Frame frame = new Frame(5,11);
	}
	@Test (expected = BowlingException.class)
	public void TestFrameWithTooHighScore() throws BowlingException{
		Frame frame = new Frame(9,9);
	}
	@Test
	public void TestFrameScoreWithCorrectValues() throws BowlingException{
		Frame frame = new Frame(4,5);
		assertEquals(9, frame.score());
	}
	@Test
	public void TestSimpleWholeGame() throws BowlingException{
		for (int i=0; i <10; i++){
			Frame frame = new Frame(2,2);
			this.game.addFrame(frame);
		}
		assertEquals(40, this.game.score());
	}
	@Test
	public void TestSimpleWholeGameWithASingleStrike() throws BowlingException{
		for (int i=0; i <10; i++){
			Frame frame = new Frame(2,2);
			this.game.addFrame(frame);
		}
		assertEquals(40, this.game.score());
	}

}
