package org.mfh114.chashi.test.testng;

import org.mfh114.chashi.App;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	@Test
	public void test(){
		App app = new App();
		
		Assert.assertEquals(app.toString(), "App [app=Test]");
	}
	
}
