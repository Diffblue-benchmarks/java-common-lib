package org.sosy_lab.common.log;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;

public class ConsoleLogFormatterDiffblueTest {
  /**
   * Test {@link ConsoleLogFormatter#ConsoleLogFormatter(LoggingOptions)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link LoggingOptions#useColors()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsoleLogFormatter#ConsoleLogFormatter(LoggingOptions)}
   */
  @Test
  public void testNewConsoleLogFormatter_givenFalse_thenCallsUseColors() {
    // Arrange
    LoggingOptions options = mock(LoggingOptions.class);
    when(options.useColors()).thenReturn(false);

    // Act
    new ConsoleLogFormatter(options);

    // Assert
    verify(options).useColors();
  }

  /**
   * Test {@link ConsoleLogFormatter#withoutColors()}.
   * <p>
   * Method under test: {@link ConsoleLogFormatter#withoutColors()}
   */
  @Test
  public void testWithoutColors() {
    // Arrange, Act and Assert
    assertTrue(ConsoleLogFormatter.withoutColors() instanceof ConsoleLogFormatter);
  }

  /**
   * Test {@link ConsoleLogFormatter#withColorsIfPossible()}.
   * <p>
   * Method under test: {@link ConsoleLogFormatter#withColorsIfPossible()}
   */
  @Test
  public void testWithColorsIfPossible() {
    // Arrange, Act and Assert
    assertTrue(ConsoleLogFormatter.withColorsIfPossible() instanceof ConsoleLogFormatter);
  }
}
