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
	public void addFrame(Frame frame) throws BowlingException{
		if (this.frames.size() <= 10){
			this.frames.add(frame);
		}
		else {
			throw new BowlingException("10 frames already entered, game ended");
		}
		
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) throws BowlingException {
		this.bonus = new BonusFrame(firstThrow, secondThrow);
	}
	
	// Returns the game score
	public int score(){
		int totalScore = 0;
		for (int i=0; i<10; i++){
			Frame frame = frames.get(i);
			if (frame.isStrike()){
				int strikeScore = 10;
				if (i+1 < frames.size()){
					Frame fr = frames.get(i+1);
					
					if (fr != null){
						 strikeScore += fr.score();
						 if (fr.isStrike()){
							 if (i+2 < frames.size() ){
								 Frame sfr = frames.get(i+2);
								 if (sfr != null){
									 strikeScore += sfr.getFirstThrow();
								 }
						 	 }
							 else if (i+2 == 12){
								 strikeScore += bonus.getSecondThrow();
							 }
							 else if (i+1 == 11){
								 strikeScore += bonus.getFirstThrow();
							 }
						 }
					}
				}
				else if (i+2 == 11){
					 strikeScore += bonus.getFirstThrow();
				}
			
				totalScore += strikeScore;
			}
			else if (frame.isSpare()){
				int spareScore = 10;
				if (i+1 < frames.size()){
					spareScore += frames.get(i+1).getFirstThrow();
				}
				totalScore += spareScore;
			}
			else {
				totalScore += frame.score();
			}
			
		}
		
		if (frames.get(9).isSpare()){
			totalScore += this.bonus.getFirstThrow();
		}
		
		if (frames.get(9).isStrike()){
			totalScore += this.bonus.score();
		}
		return totalScore;
	}
}
