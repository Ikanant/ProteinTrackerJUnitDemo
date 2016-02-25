package com.sample.tests;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.sample.proteintracker.TrackingService;

@RunWith(Parameterized.class)
public class ParameterizedTests {
	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][]{
			{5, 5}, // This means if we add 5 protein, the total should be 5
			{5, 10}, // Then after 5 more, the total should be 10 ...
			{-12, 0},
			{50, 50},
			{1, 51}
		});
	}
	
	//By making it static we ensure that the object will not be initliazed multiple times during the test
	private static TrackingService service = new TrackingService();
	private int input;
	private int expected;

	public ParameterizedTests(int input, int expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Test
	public void test(){
		if(input >= 0){
			service.addProtein(input);
		}
		else {
			service.removeProtein(-input);
		}
		
		assertEquals(expected, service.getTotal());
	}
}
