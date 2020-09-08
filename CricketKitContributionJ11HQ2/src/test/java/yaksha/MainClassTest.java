package yaksha;

import static yaksha.TestUtils.businessTestFile;
import static yaksha.TestUtils.currentTest;
import static yaksha.TestUtils.yakshaAssert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class MainClassTest {
	
	@Test
	public void testExceptionConditon() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.boundaryTestFile);
	}

	@Test
	public void testBoundaryCondition() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.exceptionTestFile);
	}

	@Test
	void testObtainPurchaseWithAmount() throws Exception {
		// Test will pass
		List<Purchase> purchases = new ArrayList<Purchase>();
		String str = "1,12-12-2012,John,Bat,1500,5,Ball,60,2,Stump,340,15,helmet,925,8,Pad,600,20,Gloves,450,35,Guard,120,4";
		String str1 = "3,12-12-2012,Jack,Bat,1500,7,Ball,60,1,Stump,340,5,helmet,925,5,Pad,600,15";
		Purchase p = Purchase.obtainPurchaseWithAmount(str);
		purchases.add(p);
		p = Purchase.obtainPurchaseWithAmount(str1);
		purchases.add(p);
		Collections.sort(purchases);
		String result = purchases.toString();
		String expectedEesult = "3          Jack            25885.0\r" + "1          John            48350.0";
		yakshaAssert(currentTest(), (expectedEesult.equals(result) ? "true" : "false"), businessTestFile);
	}
}
