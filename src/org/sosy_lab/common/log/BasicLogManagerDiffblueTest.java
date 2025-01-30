package org.sosy_lab.common.log;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Handler;
import java.util.logging.Logger;
import org.junit.Test;
import org.sosy_lab.common.configuration.Configuration;
import org.sosy_lab.common.configuration.InvalidConfigurationException;

public class BasicLogManagerDiffblueTest {
  /**
   * Test {@link BasicLogManager#BasicLogManager(Logger)}.
   * <ul>
   *   <li>Then withComponentName {@code P Name} return {@link BasicLogManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#BasicLogManager(Logger)}
   */
  @Test
  public void testNewBasicLogManager_thenWithComponentNamePNameReturnBasicLogManager() {
    // Arrange, Act and Assert
    assertTrue((new BasicLogManager(Logger.getGlobal())).withComponentName("P Name") instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#BasicLogManager(Logger, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#BasicLogManager(Logger, int)}
   */
  @Test
  public void testNewBasicLogManager_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new BasicLogManager(Logger.getGlobal(), -1));

  }

  /**
   * Test {@link BasicLogManager#BasicLogManager(Logger, int)}.
   * <ul>
   *   <li>When one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#BasicLogManager(Logger, int)}
   */
  @Test
  public void testNewBasicLogManager_whenOneHundred() {
    // Arrange, Act and Assert
    assertTrue((new BasicLogManager(Logger.getGlobal(), 100)).withComponentName("P Name") instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#BasicLogManager(Logger, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then withComponentName {@code P Name} return {@link BasicLogManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#BasicLogManager(Logger, int)}
   */
  @Test
  public void testNewBasicLogManager_whenThree_thenWithComponentNamePNameReturnBasicLogManager() {
    // Arrange, Act and Assert
    assertTrue((new BasicLogManager(Logger.getGlobal(), 3)).withComponentName("P Name") instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#BasicLogManager(Logger, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then withComponentName {@code P Name} return {@link BasicLogManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#BasicLogManager(Logger, int)}
   */
  @Test
  public void testNewBasicLogManager_whenZero_thenWithComponentNamePNameReturnBasicLogManager() {
    // Arrange, Act and Assert
    assertTrue((new BasicLogManager(Logger.getGlobal(), 0)).withComponentName("P Name") instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#withComponentName(String)}.
   * <ul>
   *   <li>When {@code P Name}.</li>
   *   <li>Then return {@link BasicLogManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#withComponentName(String)}
   */
  @Test
  public void testWithComponentName_whenPName_thenReturnBasicLogManager() {
    // Arrange, Act and Assert
    assertTrue((new BasicLogManager(Logger.getGlobal())).withComponentName("P Name") instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#createWithHandler(Handler)} with {@code handler}.
   * <p>
   * Method under test: {@link BasicLogManager#createWithHandler(Handler)}
   */
  @Test
  public void testCreateWithHandlerWithHandler() {
    // Arrange and Act
    LogManager actualCreateWithHandlerResult = BasicLogManager.createWithHandler(new StringBuildingLogHandler());

    // Assert
    assertTrue(actualCreateWithHandlerResult.withComponentName("P Name") instanceof BasicLogManager);
    assertTrue(actualCreateWithHandlerResult instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#createWithHandler(Handler, int)} with {@code handler}, {@code truncateSize}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#createWithHandler(Handler, int)}
   */
  @Test
  public void testCreateWithHandlerWithHandlerTruncateSize_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> BasicLogManager.createWithHandler(new StringBuildingLogHandler(), -1));
  }

  /**
   * Test {@link BasicLogManager#createWithHandler(Handler, int)} with {@code handler}, {@code truncateSize}.
   * <ul>
   *   <li>When one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#createWithHandler(Handler, int)}
   */
  @Test
  public void testCreateWithHandlerWithHandlerTruncateSize_whenOneHundred() {
    // Arrange and Act
    LogManager actualCreateWithHandlerResult = BasicLogManager.createWithHandler(new StringBuildingLogHandler(), 100);

    // Assert
    assertTrue(actualCreateWithHandlerResult.withComponentName("P Name") instanceof BasicLogManager);
    assertTrue(actualCreateWithHandlerResult instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#createWithHandler(Handler, int)} with {@code handler}, {@code truncateSize}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#createWithHandler(Handler, int)}
   */
  @Test
  public void testCreateWithHandlerWithHandlerTruncateSize_whenThree() {
    // Arrange and Act
    LogManager actualCreateWithHandlerResult = BasicLogManager.createWithHandler(new StringBuildingLogHandler(), 3);

    // Assert
    assertTrue(actualCreateWithHandlerResult.withComponentName("P Name") instanceof BasicLogManager);
    assertTrue(actualCreateWithHandlerResult instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#createWithHandler(Handler, int)} with {@code handler}, {@code truncateSize}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#createWithHandler(Handler, int)}
   */
  @Test
  public void testCreateWithHandlerWithHandlerTruncateSize_whenZero() {
    // Arrange and Act
    LogManager actualCreateWithHandlerResult = BasicLogManager.createWithHandler(new StringBuildingLogHandler(), 0);

    // Assert
    assertTrue(actualCreateWithHandlerResult.withComponentName("P Name") instanceof BasicLogManager);
    assertTrue(actualCreateWithHandlerResult instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#create(Configuration)} with {@code config}.
   * <ul>
   *   <li>Given {@link BasicLogManager#BasicLogManager(Logger)} with pLogger is Global.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#create(Configuration)}
   */
  @Test
  public void testCreateWithConfig_givenBasicLogManagerWithPLoggerIsGlobal() throws InvalidConfigurationException {
    // Arrange
    Configuration config = Configuration.defaultConfiguration();
    config.enableLogging(new BasicLogManager(Logger.getGlobal()));

    // Act
    LogManager actualCreateResult = BasicLogManager.create(config);

    // Assert
    assertTrue(actualCreateResult.withComponentName("P Name") instanceof BasicLogManager);
    assertTrue(actualCreateResult instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#create(Configuration)} with {@code config}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with {@code 10000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#create(Configuration)}
   */
  @Test
  public void testCreateWithConfig_givenByteArrayOutputStreamWith10000() throws InvalidConfigurationException {
    // Arrange
    Configuration config = Configuration.defaultConfiguration();
    config.dumpUsedOptionsTo(new PrintStream(new ByteArrayOutputStream(10000)));

    // Act
    LogManager actualCreateResult = BasicLogManager.create(config);

    // Assert
    assertTrue(actualCreateResult.withComponentName("P Name") instanceof BasicLogManager);
    assertTrue(actualCreateResult instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#create(Configuration)} with {@code config}.
   * <ul>
   *   <li>Given {@link NullLogManager#INSTANCE}.</li>
   *   <li>When defaultConfiguration enableLogging {@link NullLogManager#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#create(Configuration)}
   */
  @Test
  public void testCreateWithConfig_givenInstance_whenDefaultConfigurationEnableLoggingInstance()
      throws InvalidConfigurationException {
    // Arrange
    Configuration config = Configuration.defaultConfiguration();
    config.enableLogging(NullLogManager.INSTANCE);

    // Act
    LogManager actualCreateResult = BasicLogManager.create(config);

    // Assert
    assertTrue(actualCreateResult.withComponentName("P Name") instanceof BasicLogManager);
    assertTrue(actualCreateResult instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#create(Configuration)} with {@code config}.
   * <ul>
   *   <li>Given {@link TestLogManager#INSTANCE}.</li>
   *   <li>When defaultConfiguration enableLogging {@link TestLogManager#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#create(Configuration)}
   */
  @Test
  public void testCreateWithConfig_givenInstance_whenDefaultConfigurationEnableLoggingInstance2()
      throws InvalidConfigurationException {
    // Arrange
    Configuration config = Configuration.defaultConfiguration();
    config.enableLogging(TestLogManager.INSTANCE);

    // Act
    LogManager actualCreateResult = BasicLogManager.create(config);

    // Assert
    assertTrue(actualCreateResult.withComponentName("P Name") instanceof BasicLogManager);
    assertTrue(actualCreateResult instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#create(Configuration)} with {@code config}.
   * <ul>
   *   <li>When defaultConfiguration.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicLogManager#create(Configuration)}
   */
  @Test
  public void testCreateWithConfig_whenDefaultConfiguration() throws InvalidConfigurationException {
    // Arrange and Act
    LogManager actualCreateResult = BasicLogManager.create(Configuration.defaultConfiguration());

    // Assert
    assertTrue(actualCreateResult.withComponentName("P Name") instanceof BasicLogManager);
    assertTrue(actualCreateResult instanceof BasicLogManager);
  }

  /**
   * Test {@link BasicLogManager#create(LoggingOptions)} with {@code options}.
   * <p>
   * Method under test: {@link BasicLogManager#create(LoggingOptions)}
   */
  @Test
  public void testCreateWithOptions() {
    // Arrange and Act
    LogManager actualCreateResult = BasicLogManager.create(new LoggingOptions());

    // Assert
    assertTrue(actualCreateResult.withComponentName("P Name") instanceof BasicLogManager);
    assertTrue(actualCreateResult instanceof BasicLogManager);
  }
}
