package com.alonso.TestConjuntos;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test_ for simple App.
 */
public class AppTest extends TestCase {
	
	private MySetData<Object> mySet = new MySetData<Object>();
	
	/**
	   * Sets up the test_ fixture. 
	   * (Called before every test_ case method.)
	   */
	  public void setUp() {
		  mySet = new MySetData<Object>();
	  }

	  /**
	   * Tears down the test_ fixture. 
	   * (Called after every test_ case method.)
	   */
	  public void tearDown() {
		  mySet = null;
	  }
	  
	  
	/**
	 * Create the test_ case
	 *
	 * @param test_Name name of the test_ case
	 */
	public AppTest(String test_Name) {
		super(test_Name);
	}

	/**
	 * @return the suite of test_s being test_ed
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void test_App() {
		assertTrue(true);
	}
	
	public void test_firstTest() {
		System.out.println("hello world, Alonso");
	}
	
	public void test_whenAddingValueItInserts() {
		Object someObject = "first";
		boolean isAdded = mySet.add(someObject );
		assertTrue("added",isAdded);
		
		Object anotherObject = mySet.get(someObject);
		assertEquals(anotherObject, someObject);
	}
	
	public void test_when_Adding_Value_I_can_delete_It() {
		
		Object someObject = "first";
		boolean isAdded = mySet.add(someObject );
		assertTrue("added",isAdded);
		assertTrue(mySet.size() == 1);
		
		boolean isDeleted = mySet.drop(someObject);
		assertTrue(isDeleted);
		
		assertTrue(mySet.size() == 0);
	}
	
	public void test_when_NotKeyIsPresent_I_cannot_delete_It() {
	
		Object someObject = "first";
		boolean isDeleted = mySet.drop(someObject);
		assertFalse(isDeleted);
		
		assertTrue(mySet.size() == 0);
	}
	
	public void test_when_AddedSameValue_OnlyOneValueRemains() {
		boolean isAdded = mySet.add("first");
		assertTrue("added",isAdded);
		int actualSize = mySet.size();
		assertEquals(1, actualSize);
		isAdded = mySet.add("first");
		assertFalse("Not added",isAdded);
		assertEquals(1, actualSize);
		
	}
	
	public void test_when_AddedTwoDifferentValues_IHaveTwoDifferentValues() {
		boolean isAdded = mySet.add("first");
		assertTrue("added",isAdded);
		int actualSize = mySet.size();
		assertEquals(1, actualSize);
		
		isAdded = mySet.add("second");
		assertTrue("added too",isAdded);
		actualSize = mySet.size();
		assertEquals(2, actualSize);
	}
	
	public void test_when_AddedTwoDifferentValues_ICanSortThem() {
		boolean isAdded = mySet.add("first");
		assertTrue("added",isAdded);
		
		isAdded = mySet.add("second");
		assertTrue("added too",isAdded);
		
		isAdded = mySet.add("alonso");
		assertTrue("added too",isAdded);
		
		mySet.sorted();
	}
	
	public void test_when_AddedDifferentTypesOfValues_I_have_the_correct_count() {
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
	
	public void test_when_Added_I_can_recoverIt() {
		
		Object some = "first";
		boolean isAdded = mySet.add(some);
		assertTrue("added",isAdded);
		
		Object Anothersome = mySet.get(some);
		assertEquals(Anothersome ,some);
	}
	
	public void test_when_notAdded_I_Cannot_recoverIt() {
		
		Object some = "first";
		
		Object Anothersome = mySet.get(some);
		assertNotSame(Anothersome ,some);
		assertTrue(mySet.size() == 0);
	}
	
	public void test_is_EmptyTheDataSet() {
		assertTrue("should be true",mySet.isEmpty());
	}
	
	public void test_is_NotEmptyTheDataSet() {
		
		Object some = "first";
		boolean isAdded = mySet.add(some);
		assertTrue("added",isAdded);
		
		assertFalse("should be false",mySet.isEmpty());

	}
}
