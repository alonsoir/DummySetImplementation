package com.alonso.TestConjuntos;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	
	private MySetData<Object> mySet = new MySetData<Object>();
	
	/**
	   * Sets up the test fixture. 
	   * (Called before every test case method.)
	   */
	  public void setUp() {
		  mySet = new MySetData<Object>();
	  }

	  /**
	   * Tears down the test fixture. 
	   * (Called after every test case method.)
	   */
	  public void tearDown() {
		  mySet = null;
	  }
	  
	  
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}
	
	public void testfirstTest() {
		System.out.println("hello world, Alonso");
	}
	
	public void testwhenAddingValueItInserts() {
		Object someObject = "first";
		boolean isAdded = mySet.add(someObject );
		assertTrue("added",isAdded);
		
		Object anotherObject = mySet.get(someObject);
		assertEquals(anotherObject, someObject);
	}
	
	public void testwhen_Adding_Value_I_can_delete_It() {
		
		Object someObject = "first";
		boolean isAdded = mySet.add(someObject );
		assertTrue("added",isAdded);
		assertTrue(mySet.size() == 1);
		
		boolean isDeleted = mySet.drop(someObject);
		assertTrue(isDeleted);
		
		assertTrue(mySet.size() == 0);
	}
	
	public void testwhen_NotKeyIsPresent_I_cannot_delete_It() {
	
		Object someObject = "first";
		boolean isDeleted = mySet.drop(someObject);
		assertFalse(isDeleted);
		
		assertTrue(mySet.size() == 0);
	}
	
	public void testwhen_AddedSameValue_OnlyOneValueRemains() {
		boolean isAdded = mySet.add("first");
		assertTrue("added",isAdded);
		int actualSize = mySet.size();
		assertEquals(1, actualSize);
		isAdded = mySet.add("first");
		assertFalse("Not added",isAdded);
		assertEquals(1, actualSize);
		
	}
	
	public void testwhen_AddedTwoDifferentValues_IHaveTwoDifferentValues() {
		boolean isAdded = mySet.add("first");
		assertTrue("added",isAdded);
		int actualSize = mySet.size();
		assertEquals(1, actualSize);
		
		isAdded = mySet.add("second");
		assertTrue("added too",isAdded);
		actualSize = mySet.size();
		assertEquals(2, actualSize);
	}
	
	public void testwhen_AddedTwoDifferentValues_ICanSortThem() {
		boolean isAdded = mySet.add("first");
		assertTrue("added",isAdded);
		
		isAdded = mySet.add("second");
		assertTrue("added too",isAdded);
		
		isAdded = mySet.add("alonso");
		assertTrue("added too",isAdded);
		
		mySet.sorted();
	}
	
	public void testwhen_AddedDifferentTypesOfValues_I_have_the_correct_count() {
		boolean isAdded = mySet.add("first");
		assertTrue("added",isAdded);
		
		isAdded = mySet.add(1l);
		assertTrue("added too a long primitive value",isAdded);
		
		isAdded = mySet.add(1.1f);
		assertTrue("added too a float primitive value",isAdded);
		
		isAdded = mySet.add(1.2f);
		assertTrue("added another float primitive value",isAdded);
		
		isAdded = mySet.add(Boolean.TRUE);
		assertTrue("added a boolean!",isAdded);
		
		isAdded = mySet.add(Boolean.FALSE);
		assertTrue("added a boolean!",isAdded);
		
		System.out.println("Unsorted...");
		mySet.unsorted();
		
		System.out.println("sorted...");

		mySet.sorted();
		
		int actualSize = mySet.size();
		assertTrue("should be six",6 == actualSize);

	}
	
	public void testwhen_Added_I_can_recoverIt() {
		
		Object some = "first";
		boolean isAdded = mySet.add(some);
		assertTrue("added",isAdded);
		
		Object Anothersome = mySet.get(some);
		assertEquals(Anothersome ,some);
	}
	
	public void testwhen_notAdded_I_Cannot_recoverIt() {
		
		Object some = "first";
		
		Object Anothersome = mySet.get(some);
		assertNotSame(Anothersome ,some);
		assertTrue(mySet.size() == 0);
	}
	
	public void testis_EmptyTheDataSet() {
		assertTrue("should be true",mySet.isEmpty());
	}
	
	public void testis_NotEmptyTheDataSet() {
		
		Object some = "first";
		boolean isAdded = mySet.add(some);
		assertTrue("added",isAdded);
		
		assertFalse("should be false",mySet.isEmpty());

	}
}
