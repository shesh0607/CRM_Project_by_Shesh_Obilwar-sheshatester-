package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertHard {

	@Test
	public void h1() {
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		Assert.assertEquals(false, true);
		System.out.println("step4");
		System.out.println("step5");
	}
	@Test
	public void h2() {
		String exp="Shesh";
		String act="Shesh";
		Assert.assertEquals(act,exp);
	}

}
