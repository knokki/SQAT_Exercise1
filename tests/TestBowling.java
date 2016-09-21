import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBowling {
	
	
	@Before
	public void setUp(){
		
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

}
