package com.airwallex.rpncalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void tesToDouble() {
		Double d1 = Utils.toDouble("0.1");
		Double d2 = Utils.toDouble("abc");
		
		assertEquals(new Double(0.1), d1);
		assertEquals(null, d2);
	}
	
	@Test
	public void testFormatNumber() {
		assertEquals("123.1234567891", Utils.formatNumber(123.123456789112345));
		assertEquals("123.1234567891", Utils.formatNumber(123.123456789162345));
		
		assertEquals("0.123456789", Utils.formatNumber(0.123456789012345));
		assertEquals("0.123456789", Utils.formatNumber(0.123456789062345));
		
		assertEquals("0.1", Utils.formatNumber(0.100));
	}
}
