package Generic_Utility;

import java.util.Random;

public class Java_Utility {
	
	/**
	 * this method is used to avoid Duplicate
	 * @return
	 * @author Shesh
	 */
	
	public int getRandomNum() {
		Random ram=new Random();
		int ranNum=ram.nextInt(1000);
		return ranNum;
	}

}
