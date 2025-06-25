package com.ebill.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import com.ebill.service.EbillService;

@RunWith(Parameterized.class)
public class EbillTest {
	// Write your JUNIT Test Code here

	EbillService bill = null;
	
	@Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
            {0,0.0},
            {50, 130},
            {100, 292.5},
            {200, 818.5},
            {1000, 7018.5},
            {6000, 61018.5},
            {-1,0.0}
            
        });
    }
	
    int initVal;
    double expectedValue;
    
    public EbillTest(int initVal, double expectedValue) {
        this.initVal = initVal;
        this.expectedValue = expectedValue;
        
    }
    
	@BeforeClass
	public static void first() {
		//bill = new EbillService();
		System.out.println("Before All");
	}

	@AfterClass
	public static void last() {
		//bill = new EbillService();
		System.out.println("After All");
	}
	
	@Before
	public void firstEvery() {
		//bill = new EbillService();
		System.out.println("Before");
	}

	@After
	public void lastEvery() {
		//bill = new EbillService();
		System.out.println("After");
	}
	
	@Test
	public void testCalculateBillAmount_Input_0() {

		System.out.println("First Test");
		bill = new EbillService(initVal);

		//assertNull(bill);
		assertEquals(expectedValue, bill.calculateBillAmount(), 0.001);
	}

	/*@Test
	public void testCalculateBillAmount_Input_50() {
		bill = new EbillService(50);
		assertEquals(130, bill.calculateBillAmount(), 0.001);
	}

	@Test
	public void testCalculateBillAmount_Input_100() {
		bill = new EbillService(100);
		assertEquals(292.5, bill.calculateBillAmount(), 0.001);
	}

	@Test
	public void testCalculateBillAmount_Input_200() {
		bill = new EbillService(200);
		assertEquals(818.5, bill.calculateBillAmount(), 0.001);
	}

	@Test
	public void testCalculateBillAmount_Input_1000() {
		bill = new EbillService(1000);
		assertEquals(7018.5, bill.calculateBillAmount(), 0.001);
	}

	@Test
	public void testCalculateBillAmount_Input_5000() {
		bill = new EbillService(5000);
		assertEquals(47018.5, bill.calculateBillAmount(), 0.001);
	}*/

}
