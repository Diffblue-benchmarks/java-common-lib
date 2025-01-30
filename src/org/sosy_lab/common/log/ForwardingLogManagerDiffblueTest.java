package org.sosy_lab.common.log;

import static org.junit.Assert.assertFalse;
import java.util.logging.Level;
import org.junit.Test;

public class ForwardingLogManagerDiffblueTest {
  /**
   * Test {@link ForwardingLogManager#wouldBeLogged(Level)}.
   * <p>
   * Method under test: {@link ForwardingLogManager#wouldBeLogged(Level)}
   */
  @Test
  public void testWouldBeLogged() {
    // Arrange, Act and Assert
    assertFalse((new LogManagerWithoutDuplicates(new LogManagerWithoutDuplicates(NullLogManager.INSTANCE)))
        .wouldBeLogged(null));
  }

  /**
   * Test {@link ForwardingLogManager#wouldBeLogged(Level)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForwardingLogManager#wouldBeLogged(Level)}
   */
  @Test
  public void testWouldBeLogged_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LogManagerWithoutDuplicates(NullLogManager.INSTANCE)).wouldBeLogged(null));
  }
}
