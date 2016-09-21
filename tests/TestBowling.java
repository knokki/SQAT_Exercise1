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
		Frame frame = new Frame(10,0);
		this.game.addFrame(frame);
		for (int i=0; i <9; i++){
			frame = new Frame(2,2);
			this.game.addFrame(frame);
		}
		assertEquals(50, this.game.score());
	}
	@Test
	public void TestSimpleGameWithASinglesSpare() throws BowlingException{
		Frame frame = new Frame(5,5);
		this.game.addFrame(frame);
		for (int i=0; i <9; i++){
			frame = new Frame(2,2);
			this.game.addFrame(frame);
		}
		assertEquals(48, this.game.score());
	}
	@Test 
	public void TestSimpleGameWithSpareAfterStrike() throws BowlingException{
		Frame frame = new Frame(10,0);
		this.game.addFrame(frame);
		frame = new Frame(5,5);
		this.game.addFrame(frame);
		for (int i=0; i <8; i++){
			frame = new Frame(2,2);
			this.game.addFrame(frame);
		}
		assertEquals(64, this.game.score());
	}
	@Test
	public void TestMultipleStrikesInGame() throws BowlingException{
		Frame frame = new Frame(10,0);
		this.game.addFrame(frame);
		frame = new Frame(10,0);
		this.game.addFrame(frame);
		for (int i=0; i <8; i++){
			frame = new Frame(2,2);
			this.game.addFrame(frame);
		}
		assertEquals(68, this.game.score());
	}
	@Test
	public void TestMultipleSparesInAGame() throws BowlingException{
		Frame frame = new Frame(5,5);
		this.game.addFrame(frame);
		frame = new Frame(5,5);
		this.game.addFrame(frame);
		for (int i=0; i <8; i++){
			frame = new Frame(2,2);
			this.game.addFrame(frame);
		}
		assertEquals(59, this.game.score());
	}
	@Test
	public void TestLastFrameAsSpare() throws BowlingException{
		
		for (int i=0; i <9; i++){
			Frame frame = new Frame(2,2);
			this.game.addFrame(frame);
		}
		Frame frame = new Frame(5,5);
		this.game.addFrame(frame);
		this.game.setBonus(2,0);
		assertEquals(48, this.game.score());
	}
	@Test
	public void TestLastFrameAsStrike() throws BowlingException{
		
		for (int i=0; i <9; i++){
			Frame frame = new Frame(2,2);
			this.game.addFrame(frame);
		}
		Frame frame = new Frame(10,0);
		this.game.addFrame(frame);
		this.game.setBonus(2,0);
		assertEquals(48, this.game.score());
	}


}
