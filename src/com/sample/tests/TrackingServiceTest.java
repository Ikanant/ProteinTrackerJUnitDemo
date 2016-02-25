package com.sample.tests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.sample.proteintracker.InvalidGoalException;
import com.sample.proteintracker.TrackingService;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

public class TrackingServiceTest {

	private TrackingService service;

	@Before
	public void setUp() {
		service = new TrackingService();
	}

	@Test
	public void NewTrackingServiceTotalIsZero() {
		assertEquals("Tracking Service Total was NOT 0", 0, service.getTotal());
	}

	@Test
	@Category(GoodTestCategory.class)
	public void WhenAddingProteinTotalIncreases() {
		int val = 5;
		service.addProtein(val);
		assertEquals("Total was not added correctly", val, service.getTotal());
	}

	@Test
	@Category(GoodTestCategory.class)
	public void WhenRemovingProteinTotalRemainsZero() {
		service.removeProtein(5);
		assertEquals("Total Remaining Porteins Was Negative", 0, service.getTotal());
	}
	
	@Test(expected=InvalidGoalException.class)
	@Category(BadTestCategory.class)
	public void CheckForInvalidGoalException() throws InvalidGoalException{
		service.setGoal(-1);
	}
	
	@Test(timeout= 200)
	@Category({
		GoodTestCategory.class,
		BadTestCategory.class
	})
	public void BadTest(){
		for(int i=0; i<1000000000; i++){
			service.addProtein(1);
		}
	}
}
