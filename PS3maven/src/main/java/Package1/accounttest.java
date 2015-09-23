package Package1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class accounttest {
	static Account acountone;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		acountone = new Account(1122,20000);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		acountone  = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		acountone.deposit(500.00);
		assertTrue(acountone.getBalance()== 20500);
		acountone = new Account(1122,20000);
		try {
			acountone.withdraw(1000);
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(acountone.getBalance()== 19000);
	}

}
