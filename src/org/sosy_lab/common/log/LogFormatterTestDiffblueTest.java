package org.sosy_lab.common.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.google.common.collect.ImmutableList;
import java.util.logging.Formatter;
import org.junit.Test;

public class LogFormatterTestDiffblueTest {
  /**
   * Test {@link LogFormatterTest#formatters()}.
   * <p>
   * Method under test: {@link LogFormatterTest#formatters()}
   */
  @Test
  public void testFormatters() {
    // Arrange and Act
    ImmutableList<Formatter> actualFormattersResult = LogFormatterTest.formatters();

    // Assert
    assertEquals(4, actualFormattersResult.size());
    assertTrue(actualFormattersResult.get(0) instanceof ConsoleLogFormatter);
    assertTrue(actualFormattersResult.get(1) instanceof ConsoleLogFormatter);
    assertTrue(actualFormattersResult.get(2) instanceof TimestampedLogFormatter);
    assertTrue(actualFormattersResult.get(3) instanceof TimestampedLogFormatter);
  }

  /**
   * Test {@link LogFormatterTest#setup()}.
   * <p>
   * Method under test: {@link LogFormatterTest#setup()}
   */
  @Test
  public void testSetup() {
    // Arrange
    LogFormatterTest logFormatterTest = new LogFormatterTest();

    // Act
    logFormatterTest.setup();

    // Assert
    assertTrue(logFormatterTest.formatter instanceof ConsoleLogFormatter);
  }

  /**
   * Test new {@link LogFormatterTest} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link LogFormatterTest}
   */
  @Test
  public void testNewLogFormatterTest() {
    // Arrange, Act and Assert
    assertNull((new LogFormatterTest()).formatter);
  }
}
