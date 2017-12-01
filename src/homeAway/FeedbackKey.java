package homeAway;

import java.io.Serializable;

class FeedbackKey implements Comparable<FeedbackKey>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int feedback;
	
	public FeedbackKey(int value) {
		feedback = value;
	}
	
	public int getValue(){
		return feedback;
	}
	
	@Override
	public int compareTo(FeedbackKey arg0) {
		//return feedback - arg0.getValue();
		return arg0.getValue() - feedback;
	}

}
