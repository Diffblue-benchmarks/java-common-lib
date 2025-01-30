package org.sosy_lab.common.collect;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestSuite;

public class PersistentLinkedListTestDiffblueTest {
  /**
   * Test {@link PersistentLinkedListTest#suite()}.
   * <p>
   * Method under test: {@link PersistentLinkedListTest#suite()}
   */
  @org.junit.Test
  public void testSuite() throws NoSuchMethodException {
    // Arrange and Act
    Test actualSuiteResult = PersistentLinkedListTest.suite();

    // Assert
    assertTrue(actualSuiteResult instanceof TestSuite);
    assertNull(((TestSuite) actualSuiteResult).getName());
  }
}
