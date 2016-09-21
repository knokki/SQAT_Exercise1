import java.util.ArrayList;
import java.util.List;

//Finish time:
//ID:

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	// adds a frame to the game
	public void addFrame(Frame frame){
		this.frames.add(frame);
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	// Returns the game score
	public int score(){
		int totalScore = 0;
		for (int i=0; i<10; i++){
			Frame frame = frames.get(i);
			if (frame.isStrike()){
				Frame fr = frames.get(i+1);
				int strikeScore = 10;
				if (fr != null){
					 strikeScore += fr.score();
					 if (fr.isStrike()){
						 Frame sfr = frames.get(i+2);
						 if (sfr != null){
							 strikeScore += sfr.getFirstThrow();
						 }
					 }
				}
				totalScore += strikeScore;
			}
			else if (frame.isSpare()){
				int spareScore = 10;
				if (frames.get(i+1) != null){
					spareScore += frames.get(i+1).getFirstThrow();
				}
				totalScore += spareScore;
			}
			else {
				totalScore += frame.score();
			}
			
		}
		return totalScore;
	}
}
