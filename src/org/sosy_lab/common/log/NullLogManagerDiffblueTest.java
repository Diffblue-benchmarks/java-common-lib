package org.sosy_lab.common.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.logging.Level;
import org.junit.Test;

public class NullLogManagerDiffblueTest {
  /**
   * Test {@link NullLogManager#withComponentName(String)}.
   * <p>
   * Method under test: {@link NullLogManager#withComponentName(String)}
   */
  @Test
  public void testWithComponentName() {
    // Arrange and Act
    LogManager actualWithComponentNameResult = NullLogManager.INSTANCE.withComponentName("P Name");

    // Assert
    assertTrue(actualWithComponentNameResult instanceof NullLogManager);
    assertEquals(NullLogManager.INSTANCE, actualWithComponentNameResult);
  }

  /**
   * Test {@link NullLogManager#wouldBeLogged(Level)}.
   * <p>
   * Method under test: {@link NullLogManager#wouldBeLogged(Level)}
   */
  @Test
  public void testWouldBeLogged() {
    // Arrange, Act and Assert
    assertFalse(NullLogManager.INSTANCE.wouldBeLogged(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NullLogManager#flush()}
   *   <li>{@link NullLogManager#logDebugException(Throwable)}
   *   <li>{@link NullLogManager#logDebugException(Throwable, String)}
   *   <li>{@link NullLogManager#logfDebugException(Throwable, String, Object[])}
   *   <li>{@link NullLogManager#getInstance()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    NullLogManager valueOfResult = NullLogManager.valueOf("INSTANCE");

    // Act
    valueOfResult.flush();
    valueOfResult.logDebugException(new Throwable());
    valueOfResult.logDebugException(new Throwable(), "An error occurred");
    valueOfResult.logfDebugException(new Throwable(), "P Format", "P Args");
    LogManager actualInstance = valueOfResult.getInstance();

    // Assert
    assertTrue(actualInstance instanceof NullLogManager);
    assertEquals(NullLogManager.INSTANCE, actualInstance);
  }
}
