package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestSuite;

public class NaiveOrderStatisticSetTestDiffblueTest {
  /**
   * Test {@link NaiveOrderStatisticSetTest#suite()}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticSetTest#suite()}
   */
  @org.junit.Test
  public void testSuite() {
    // Arrange and Act
    Test actualSuiteResult = NaiveOrderStatisticSetTest.suite();

    // Assert
    assertTrue(actualSuiteResult instanceof TestSuite);
    assertEquals("NaiveOrderStatisticSet", ((TestSuite) actualSuiteResult).getName());
  }
}
