package org.sosy_lab.common.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class InvalidConfigurationExceptionDiffblueTest {
  /**
   * Test {@link InvalidConfigurationException#InvalidConfigurationException(String)}.
   * <ul>
   *   <li>When {@code Msg}.</li>
   *   <li>Then return LocalizedMessage is {@code Msg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InvalidConfigurationException#InvalidConfigurationException(String)}
   */
  @Test
  public void testNewInvalidConfigurationException_whenMsg_thenReturnLocalizedMessageIsMsg() {
    // Arrange and Act
    InvalidConfigurationException actualInvalidConfigurationException = new InvalidConfigurationException("Msg");

    // Assert
    assertEquals("Msg", actualInvalidConfigurationException.getLocalizedMessage());
    assertEquals("Msg", actualInvalidConfigurationException.getMessage());
    assertNull(actualInvalidConfigurationException.getCause());
    assertEquals(0, actualInvalidConfigurationException.getSuppressed().length);
  }

  /**
   * Test {@link InvalidConfigurationException#InvalidConfigurationException(String, Throwable)}.
   * <ul>
   *   <li>When {@code Msg}.</li>
   *   <li>Then return LocalizedMessage is {@code Msg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InvalidConfigurationException#InvalidConfigurationException(String, Throwable)}
   */
  @Test
  public void testNewInvalidConfigurationException_whenMsg_thenReturnLocalizedMessageIsMsg2() {
    // Arrange
    Throwable source = new Throwable();

    // Act
    InvalidConfigurationException actualInvalidConfigurationException = new InvalidConfigurationException("Msg",
        source);

    // Assert
    assertEquals("Msg", actualInvalidConfigurationException.getLocalizedMessage());
    assertEquals("Msg", actualInvalidConfigurationException.getMessage());
    assertEquals(0, actualInvalidConfigurationException.getSuppressed().length);
    assertSame(source, actualInvalidConfigurationException.getCause());
  }
}
