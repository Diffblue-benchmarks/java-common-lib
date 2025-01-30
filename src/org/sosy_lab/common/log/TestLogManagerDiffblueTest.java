package org.sosy_lab.common.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestLogManagerDiffblueTest {
  /**
   * Test {@link TestLogManager#withComponentName(String)}.
   * <ul>
   *   <li>When {@code P Name}.</li>
   *   <li>Then return {@link TestLogManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TestLogManager#withComponentName(String)}
   */
  @Test
  public void testWithComponentName_whenPName_thenReturnTestLogManager() {
    // Arrange and Act
    LogManager actualWithComponentNameResult = TestLogManager.INSTANCE.withComponentName("P Name");

    // Assert
    assertTrue(actualWithComponentNameResult instanceof TestLogManager);
    assertEquals(TestLogManager.INSTANCE, actualWithComponentNameResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TestLogManager#flush()}
   *   <li>{@link TestLogManager#getInstance()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    TestLogManager valueOfResult = TestLogManager.valueOf("INSTANCE");

    // Act
    valueOfResult.flush();
    LogManager actualInstance = valueOfResult.getInstance();

    // Assert
    assertTrue(actualInstance instanceof TestLogManager);
    assertEquals(TestLogManager.INSTANCE, actualInstance);
  }
}
