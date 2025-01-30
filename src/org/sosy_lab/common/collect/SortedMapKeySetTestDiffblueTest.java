package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SortedMapKeySetTestDiffblueTest {
  /**
   * Test {@link SortedMapKeySetTest#suite()}.
   * <p>
   * Method under test: {@link SortedMapKeySetTest#suite()}
   */
  @org.junit.Test
  public void testSuite() {
    // Arrange and Act
    Test actualSuiteResult = SortedMapKeySetTest.suite();

    // Assert
    assertTrue(actualSuiteResult instanceof TestSuite);
    assertEquals("SortedMapKeySet", ((TestSuite) actualSuiteResult).getName());
  }
}
