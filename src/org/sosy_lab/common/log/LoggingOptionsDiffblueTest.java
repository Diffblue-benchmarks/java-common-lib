package org.sosy_lab.common.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import org.junit.Test;
import org.sosy_lab.common.configuration.Configuration;
import org.sosy_lab.common.configuration.InvalidConfigurationException;

public class LoggingOptionsDiffblueTest {
  /**
   * Test {@link LoggingOptions#LoggingOptions()}.
   * <p>
   * Method under test: {@link LoggingOptions#LoggingOptions()}
   */
  @Test
  public void testNewLoggingOptions() {
    // Arrange and Act
    LoggingOptions actualLoggingOptions = new LoggingOptions();

    // Assert
    Level consoleLevel = actualLoggingOptions.getConsoleLevel();
    assertEquals("INFO", consoleLevel.getLocalizedName());
    assertEquals("INFO", consoleLevel.getName());
    assertEquals("INFO", consoleLevel.toString());
    Level fileLevel = actualLoggingOptions.getFileLevel();
    assertEquals("OFF", fileLevel.getLocalizedName());
    assertEquals("OFF", fileLevel.getName());
    assertEquals("OFF", fileLevel.toString());
    assertEquals("sun.util.logging.resources.logging", consoleLevel.getResourceBundleName());
    assertEquals("sun.util.logging.resources.logging", fileLevel.getResourceBundleName());
    assertEquals(10000, actualLoggingOptions.getTruncateSize());
    List<Level> consoleExclude = actualLoggingOptions.getConsoleExclude();
    assertTrue(consoleExclude.isEmpty());
    assertTrue(actualLoggingOptions.useColors());
    assertSame(consoleExclude, actualLoggingOptions.getFileExclude());
  }

  /**
   * Test {@link LoggingOptions#LoggingOptions(Configuration)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with {@code 10000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LoggingOptions#LoggingOptions(Configuration)}
   */
  @Test
  public void testNewLoggingOptions_givenByteArrayOutputStreamWith10000() throws InvalidConfigurationException {
    // Arrange
    Configuration config = Configuration.defaultConfiguration();
    config.dumpUsedOptionsTo(new PrintStream(new ByteArrayOutputStream(10000)));

    // Act
    LoggingOptions actualLoggingOptions = new LoggingOptions(config);

    // Assert
    Level consoleLevel = actualLoggingOptions.getConsoleLevel();
    assertEquals("INFO", consoleLevel.getLocalizedName());
    assertEquals("INFO", consoleLevel.getName());
    assertEquals("INFO", consoleLevel.toString());
    Level fileLevel = actualLoggingOptions.getFileLevel();
    assertEquals("OFF", fileLevel.getLocalizedName());
    assertEquals("OFF", fileLevel.getName());
    assertEquals("OFF", fileLevel.toString());
    assertEquals("sun.util.logging.resources.logging", consoleLevel.getResourceBundleName());
    assertEquals("sun.util.logging.resources.logging", fileLevel.getResourceBundleName());
    assertEquals(10000, actualLoggingOptions.getTruncateSize());
    List<Level> consoleExclude = actualLoggingOptions.getConsoleExclude();
    assertTrue(consoleExclude.isEmpty());
    assertTrue(actualLoggingOptions.useColors());
    assertSame(consoleExclude, actualLoggingOptions.getFileExclude());
  }

  /**
   * Test {@link LoggingOptions#LoggingOptions(Configuration)}.
   * <ul>
   *   <li>Given {@link TestLogManager#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LoggingOptions#LoggingOptions(Configuration)}
   */
  @Test
  public void testNewLoggingOptions_givenInstance() throws InvalidConfigurationException {
    // Arrange
    Configuration config = Configuration.defaultConfiguration();
    config.enableLogging(TestLogManager.INSTANCE);

    // Act
    LoggingOptions actualLoggingOptions = new LoggingOptions(config);

    // Assert
    Level consoleLevel = actualLoggingOptions.getConsoleLevel();
    assertEquals("INFO", consoleLevel.getLocalizedName());
    assertEquals("INFO", consoleLevel.getName());
    assertEquals("INFO", consoleLevel.toString());
    Level fileLevel = actualLoggingOptions.getFileLevel();
    assertEquals("OFF", fileLevel.getLocalizedName());
    assertEquals("OFF", fileLevel.getName());
    assertEquals("OFF", fileLevel.toString());
    assertEquals("sun.util.logging.resources.logging", consoleLevel.getResourceBundleName());
    assertEquals("sun.util.logging.resources.logging", fileLevel.getResourceBundleName());
    assertEquals(10000, actualLoggingOptions.getTruncateSize());
    List<Level> consoleExclude = actualLoggingOptions.getConsoleExclude();
    assertTrue(consoleExclude.isEmpty());
    assertTrue(actualLoggingOptions.useColors());
    assertSame(consoleExclude, actualLoggingOptions.getFileExclude());
  }

  /**
   * Test {@link LoggingOptions#LoggingOptions(Configuration)}.
   * <ul>
   *   <li>When defaultConfiguration.</li>
   * </ul>
   * <p>
   * Method under test: {@link LoggingOptions#LoggingOptions(Configuration)}
   */
  @Test
  public void testNewLoggingOptions_whenDefaultConfiguration() throws InvalidConfigurationException {
    // Arrange and Act
    LoggingOptions actualLoggingOptions = new LoggingOptions(Configuration.defaultConfiguration());

    // Assert
    Level consoleLevel = actualLoggingOptions.getConsoleLevel();
    assertEquals("INFO", consoleLevel.getLocalizedName());
    assertEquals("INFO", consoleLevel.getName());
    assertEquals("INFO", consoleLevel.toString());
    Level fileLevel = actualLoggingOptions.getFileLevel();
    assertEquals("OFF", fileLevel.getLocalizedName());
    assertEquals("OFF", fileLevel.getName());
    assertEquals("OFF", fileLevel.toString());
    assertEquals("sun.util.logging.resources.logging", consoleLevel.getResourceBundleName());
    assertEquals("sun.util.logging.resources.logging", fileLevel.getResourceBundleName());
    assertEquals(10000, actualLoggingOptions.getTruncateSize());
    List<Level> consoleExclude = actualLoggingOptions.getConsoleExclude();
    assertTrue(consoleExclude.isEmpty());
    assertTrue(actualLoggingOptions.useColors());
    assertSame(consoleExclude, actualLoggingOptions.getFileExclude());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LoggingOptions#getConsoleExclude()}
   *   <li>{@link LoggingOptions#getConsoleLevel()}
   *   <li>{@link LoggingOptions#getFileExclude()}
   *   <li>{@link LoggingOptions#getFileLevel()}
   *   <li>{@link LoggingOptions#getOutputFile()}
   *   <li>{@link LoggingOptions#getTruncateSize()}
   *   <li>{@link LoggingOptions#useColors()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LoggingOptions loggingOptions = new LoggingOptions();

    // Act
    List<Level> actualConsoleExclude = loggingOptions.getConsoleExclude();
    Level actualConsoleLevel = loggingOptions.getConsoleLevel();
    List<Level> actualFileExclude = loggingOptions.getFileExclude();
    Level actualFileLevel = loggingOptions.getFileLevel();
    Path actualOutputFile = loggingOptions.getOutputFile();
    int actualTruncateSize = loggingOptions.getTruncateSize();
    boolean actualUseColorsResult = loggingOptions.useColors();

    // Assert
    File toFileResult = actualOutputFile.toFile();
    assertEquals("CPALog.txt", toFileResult.getName());
    assertEquals(10000, actualTruncateSize);
    assertFalse(toFileResult.isAbsolute());
    assertTrue(actualConsoleExclude.isEmpty());
    assertTrue(actualUseColorsResult);
    assertSame(actualConsoleExclude, actualFileExclude);
    assertSame(actualFileLevel.INFO, actualConsoleLevel);
    assertSame(actualFileLevel.OFF, actualFileLevel);
  }
}
