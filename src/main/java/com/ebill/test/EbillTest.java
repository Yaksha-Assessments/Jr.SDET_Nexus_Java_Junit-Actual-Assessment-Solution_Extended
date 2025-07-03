package com.ebill.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.ebill.service.EbillService;

@RunWith(Parameterized.class)
public class EbillTest {
	// Write your JUNIT Test Code here

	EbillService bill = null;
	
	@Parameters
    public static Collection<Object[]> testData() {
    	List<Object[]> rawData =  Arrays.asList(new Object[][] {
            {0,0.0},
            {50, 130.0},
            {100, 292.5},
            {200, 818.5},
            {1000, 7018.5},
            {4000,37018.50},
            {5000,47018.50},
            {6000, 61018.5},
            {-1,0.0},
            {"100",292.5}
            
        });
        List<Object[]> validData = new ArrayList<>();
        for (Object[] row : rawData) {
            if (isValid(row)) {
                validData.add(row);
            } else {
                System.err.println("Skipping invalid dataset: " + Arrays.toString(row));
            }
        }
        return validData;
    }
	
    private static boolean isValid(Object[] row) {
        if (row.length != 2) return false;
        if (!(row[0] instanceof Integer)) return false;
        if (!(row[1] instanceof Double)) return false;
        return true;
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
		
		bill = new EbillService(this.initVal);
		System.out.println("Before");
	}

	@After
	public void lastEvery() {
		bill = null;
		System.out.println("After");
	}
	
	@Test
	public void testCalculateBillAmount_Input_0() {
		
		//assertNull(bill);
		//assertThrows(expectedValue, Exception.class);
		
		//assertThrows(bill.calculateBillAmount(), null)
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
