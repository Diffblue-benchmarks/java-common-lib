package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestSuite;

public class NaiveOrderStatisticMapTestDiffblueTest {
  /**
   * Test {@link NaiveOrderStatisticMapTest#suite()}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticMapTest#suite()}
   */
  @org.junit.Test
  public void testSuite() {
    // Arrange and Act
    Test actualSuiteResult = NaiveOrderStatisticMapTest.suite();

    // Assert
    assertTrue(actualSuiteResult instanceof TestSuite);
    assertEquals("NaiveOrderStatisticMap", ((TestSuite) actualSuiteResult).getName());
  }
}
