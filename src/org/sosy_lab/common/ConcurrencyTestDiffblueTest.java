package org.sosy_lab.common;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.mockito.internal.junit.JUnitRule;
import org.mockito.junit.MockitoRule;

public class ConcurrencyTestDiffblueTest {
  /**
   * Test new {@link ConcurrencyTest} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ConcurrencyTest}
   */
  @Test
  public void testNewConcurrencyTest() {
    // Arrange and Act
    ConcurrencyTest actualConcurrencyTest = new ConcurrencyTest();

    // Assert
    MockitoRule mockitoRule = actualConcurrencyTest.mockito;
    assertTrue(mockitoRule instanceof JUnitRule);
    MockitoRule expectedSilentResult = actualConcurrencyTest.mockito;
    assertSame(expectedSilentResult, mockitoRule.silent());
  }
}
