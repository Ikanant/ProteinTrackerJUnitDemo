package com.sample.tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(GoodTestCategory.class)
public class HelloJUnitTest {

	@Test
	public void simpleTest(){
		assertEquals("This is not going to error", 0, 0);
	}
}
