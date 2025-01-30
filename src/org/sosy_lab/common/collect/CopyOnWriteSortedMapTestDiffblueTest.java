package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestSuite;

public class CopyOnWriteSortedMapTestDiffblueTest {
  /**
   * Test {@link CopyOnWriteSortedMapTest#suite()}.
   * <p>
   * Method under test: {@link CopyOnWriteSortedMapTest#suite()}
   */
  @org.junit.Test
  public void testSuite() throws NoSuchMethodException {
    // Arrange and Act
    Test actualSuiteResult = CopyOnWriteSortedMapTest.suite();

    // Assert
    assertTrue(actualSuiteResult instanceof TestSuite);
    assertEquals("CopyOnWriteSortedMap", ((TestSuite) actualSuiteResult).getName());
  }
}
