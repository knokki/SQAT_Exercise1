
public class BowlingException extends Exception {
	private String msg;

	public BowlingException(String string) {
		this.msg = string;
	}
	@Override
	public String getMessage(){
		return msg;
	}

}
