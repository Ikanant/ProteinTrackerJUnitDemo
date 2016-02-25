package com.sample.tests;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import com.sample.proteintracker.InvalidGoalException;
import com.sample.proteintracker.TrackingService;

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
		
		//Use AssertThat now...
		int val = 5;
		service.addProtein(val);
		assertEquals("Total was not added correctly", val, service.getTotal());
		
		assertThat(service.getTotal(), is(5));
		
		// allOf checks that every condition inside the parenthesis is true
		assertThat(service.getTotal(), allOf(is(5), instanceOf(Integer.class)));
	}

	@Test
	@Category(GoodTestCategory.class)
	public void WhenRemovingProteinTotalRemainsZero() {
		service.removeProtein(5);
		assertEquals("Total Remaining Porteins Was Negative", 0, service.getTotal());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	@Category(BadTestCategory.class)
	public void CheckForInvalidGoalException() throws InvalidGoalException{
		thrown.expect(InvalidGoalException.class);
		thrown.expectMessage(containsString("Goal"));
		service.setGoal(-1);
	}
	
	@Rule
	public Timeout timeout = new Timeout(20); // 20 milliseconds
	
	@Test
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
