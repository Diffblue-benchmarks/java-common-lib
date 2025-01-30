package org.sosy_lab.common.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LogManagerDiffblueTest {
  /**
   * Test {@link LogManager#createNullLogManager()}.
   * <p>
   * Method under test: {@link LogManager#createNullLogManager()}
   */
  @Test
  public void testCreateNullLogManager() {
    // Arrange and Act
    LogManager actualCreateNullLogManagerResult = LogManager.createNullLogManager();

    // Assert
    assertTrue(actualCreateNullLogManagerResult instanceof NullLogManager);
    assertEquals(NullLogManager.INSTANCE, actualCreateNullLogManagerResult);
  }

  /**
   * Test {@link LogManager#createTestLogManager()}.
   * <p>
   * Method under test: {@link LogManager#createTestLogManager()}
   */
  @Test
  public void testCreateTestLogManager() {
    // Arrange and Act
    LogManager actualCreateTestLogManagerResult = LogManager.createTestLogManager();

    // Assert
    assertTrue(actualCreateTestLogManagerResult instanceof TestLogManager);
    assertEquals(TestLogManager.INSTANCE, actualCreateTestLogManagerResult);
  }
}
