package debugtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import debug.Calculator;

public class CalculatorTest {
	Calculator calculator;
	
	@Before
	private void setup() {
		calculator = new Calculator();

	}

	@Test
	public void testPlus() {
		assertTrue(calculator.plus(8, 4) == 12);
		
		int a = 8, b = 8;
		assertEquals(a, b); // 변수의 값이 같은지 확인
		
		int[] arr = {0, 1};
		int arr2[] = new int[2];
		assertArrayEquals(arr, arr2);
		
	}

	@Ignore
	@Test
	public void testMulti() {
		fail("Not yet implemented");
	}

	@Test(timeout = 1000)  // 1초 단위로 수행시간 검사
 	public void testDivide() {
		assertTrue(calculator.divide(8, 4) == 2);
	//  assertTrue(calculator.divide(10, 4) == 2.5);
		
		for(int i = 0; i < 1000; i ++) {
			System.out.println(i + " " );
		}
	}

}


