package in.charan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import in.charan.service.CensusService;

public class TestCensusService {

	static CensusService cs;
	
	@BeforeAll
	public static void setUp() {
		cs=new CensusService();
		
	}
	
	@Disabled
	@DisplayName("Testing Census Data Export")
	@RepeatedTest(value=10,name="execution of {displayName} --{currentRepetition}/{currentRepetition}")
	public void testCensusService() {
		assertEquals("Data Exported", cs.exportData());
	}
	
	@Disabled
	@ParameterizedTest
	@ValueSource(ints = {12,27,25,4,10,8,21})
	public void testIsOdd(int data) {
		assertTrue(cs.isOdd(data));
	}
	
	@Disabled
	@ParameterizedTest
	@ValueSource(strings = {"rohit","virat","sachin"})
	public void testSayHello(String name) {
		assertEquals("Hello:"+name, cs.sayHello(name));
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	public void testIsEmpty(String data) {
	System.out.println("CensusServiceTest.testIsEmpty()");
	assertTrue(cs.isEmpty(data));
	}

	
	@AfterAll
	public static void cleanUp() {
		cs=null;
	}
}
