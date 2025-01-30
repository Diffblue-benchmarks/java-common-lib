package org.sosy_lab.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MoreStringsDiffblueTest {
  /**
   * Test {@link MoreStrings#startsWithIgnoreCase(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoreStrings#startsWithIgnoreCase(String, String)}
   */
  @Test
  public void testStartsWithIgnoreCase_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MoreStrings.startsWithIgnoreCase("foo", "42"));
  }

  /**
   * Test {@link MoreStrings#startsWithIgnoreCase(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoreStrings#startsWithIgnoreCase(String, String)}
   */
  @Test
  public void testStartsWithIgnoreCase_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MoreStrings.startsWithIgnoreCase("foo", ""));
  }

  /**
   * Test {@link MoreStrings#startsWithIgnoreCase(String, String)}.
   * <ul>
   *   <li>When {@code Prefix}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoreStrings#startsWithIgnoreCase(String, String)}
   */
  @Test
  public void testStartsWithIgnoreCase_whenPrefix_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MoreStrings.startsWithIgnoreCase("foo", "Prefix"));
  }
}
