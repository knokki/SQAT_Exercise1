public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	public Frame(int firstThrow, int secondThrow) throws BowlingException{
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		if (firstThrow > 10 || firstThrow < 0){
			throw new BowlingException("First throw has improper score");
		}
		if (secondThrow > 10 || secondThrow < 0){
			throw new BowlingException("Second throw has improper score");
		}
	}
	
	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	//returns the score of a single frame
	public int score(){
		
		return firstThrow + secondThrow;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		return (this.firstThrow  == 10)? true : false;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		if (!this.isStrike()){
			int value = this.firstThrow + this.secondThrow;
			if (value == 10){
				return true;
			}
		}
		return false;
	}
}
