package in.charan.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import in.charan.service.Printer;


public class TestPrinter {

	@Test
	public void singletonTest() {
	     Printer p1 = Printer.getInstance();
	     Printer p2 = Printer.getInstance();
	     assertNotNull(p1);
	     assertNotNull(p2);
	     if (p1 == null || p2 == null)
	         fail("p1,p2 should not be null");
	     assertSame(p1, p2);
	}

}
