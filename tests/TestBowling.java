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

}
