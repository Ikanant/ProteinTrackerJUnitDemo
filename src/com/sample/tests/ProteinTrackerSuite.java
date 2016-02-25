package com.sample.tests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	HelloJUnitTest.class, 
	TrackingServiceTest.class
}) // This is going to tell us what classes this particular suite is going to made of

public class ProteinTrackerSuite {

}
