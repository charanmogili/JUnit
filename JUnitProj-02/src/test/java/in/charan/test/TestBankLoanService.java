package in.charan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import in.charan.service.BankLoanService;

@DisplayName("Testing Bank Loan Service")
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class TestBankLoanService {

	private static BankLoanService bs;
	
//	@BeforeEach
	@BeforeAll
	public static void setUp() {
		System.out.println("\nInside SetUp Method");
		bs=new BankLoanService();
	}

	@Tag("uat")
	@Order(3)
	@Test
	@DisplayName("Testing With Small Numbers")
	public void testCalulateSimpleInterestWithSmallNumbers() {
		System.out.println("testCalulateSimpleInterestWithSmallNumbers");
		float actualOutput = bs.calculateSimpleInterest(100000, 2, 12);
		float expectedOutput=24000.0f;
		
		assertEquals(expectedOutput, actualOutput);
	}
	@Tag("dev")
	@Order(1)
	@Test
	@DisplayName("Testing with Big numbers")
    public void testCalulateSimpleInterestWithBigNumbers() {
		System.out.println("testCalulateSimpleInterestWithBigNumbers");
		
		
		float actualOutput = bs.calculateSimpleInterest(10000000, 2, 12);
		float expectedOutput=2400000.345f;//In Scientific calculations digits after point is also considered 
		                                  //so neglect that we use 0.5f in the method arg parameter
//		float expectedOutput=240.0f;
		
		
		assertEquals(expectedOutput,0.5f, actualOutput);
	}
	@Disabled
	@Test
	@DisplayName("Testing with Invalid Input")
	 public void testCalulateSimpleInterestWithInValidInputs() {
			System.out.println("testCalulateSimpleInterestWithInValidInputs");
			
			assertThrows(IllegalArgumentException.class, ()->bs.calculateSimpleInterest(0, 0, 0));
//			assertThrows(ArithmeticException.class, ()->bs.calculateSimpleInterest(0, 0, 0));
		}
	
	@Tag("uat")
	@Tag("dev")
	@Order(2)
	@Test
	 public void testCalulateSimpleInterestWithInValidInpts() {
			System.out.println("testCalulateSimpleInterestWithInValidInpts");
			
			assertThrows(ArithmeticException.class, ()->bs.calculateSimpleInterest(0, 0, 0),"Exception not Handled properly");
		}
	
	//try this test case with all the other test cases commented
	@Disabled
	@Test
	 public void testCalulateSimpleInterestWithError() {
			System.out.println("testCalulateSimpleInterestWithInValidInpts");

			float actualOutput = bs.calculateSimpleInterest(0,0,0);
			float expectedOutput=24000.0f;
			
			assertEquals(expectedOutput, actualOutput);//Exception generated in service class is not handled in
			                                          //Test case,so it is "ERROR"
		}
	
	@Disabled
	@Test
	public void testCalcaulateSimpleInterestWithinTimeDuration(){
		System.out.println("testCalcaulateSimpleInterestWithinTimeDuration");
		
		assertTimeout(Duration.ofMillis(6000), ()->bs.calculateSimpleInterest(10000, 3, 5));
	}
	
//	@AfterEach
	@AfterAll
	public static void cleanUp() {
		System.out.println("Inside CleanUP method\n");
		bs=null;
	}
}
