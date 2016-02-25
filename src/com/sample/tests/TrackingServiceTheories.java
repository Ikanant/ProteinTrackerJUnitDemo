package com.sample.tests;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.junit.Assume;

import com.sample.proteintracker.TrackingService;

@RunWith(Theories.class)
public class TrackingServiceTheories {

	@DataPoints
	public static int[] data () {
		return new int[] {
				1,
				5,
				10,
				20,
				50,
				-12,
				-100
		};
	}
	
	@Theory
	public void positiveValuesShouldAlwaysHavePositiveTotals(int value){
		TrackingService service = new TrackingService();
		service.addProtein(value);
		
		//Ignore any values that don't meet this assumption
		Assume.assumeTrue(value > 0);
		
		assertTrue(service.getTotal() > 0);
	}
}
