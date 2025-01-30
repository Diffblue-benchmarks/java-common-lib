package org.sosy_lab.common.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.io.CharSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.InvalidPathException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.sosy_lab.common.configuration.converters.TypeConverter;
import org.sosy_lab.common.log.LogManager;
import org.sosy_lab.common.log.NullLogManager;

public class ConfigurationBuilderDiffblueTest {
  /**
   * Test {@link ConfigurationBuilder#build()}.
   * <p>
   * Method under test: {@link ConfigurationBuilder#build()}
   */
  @Test
  public void testBuild() throws InvalidConfigurationException {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();

    // Act
    Configuration actualBuildResult = builderResult.copyFrom(Configuration.defaultConfiguration())
        .setPrefix("New Prefix")
        .build();

    // Assert
    LogManager logger = actualBuildResult.getLogger();
    assertTrue(logger instanceof NullLogManager);
    assertEquals("New Prefix.", actualBuildResult.prefix);
    assertNull(actualBuildResult.getUsedOptionsPrintStream());
    assertEquals(NullLogManager.INSTANCE, logger);
    assertTrue(actualBuildResult.getDeprecatedProperties().isEmpty());
    assertTrue(actualBuildResult.getUnusedProperties().isEmpty());
    assertTrue(actualBuildResult.deprecatedProperties.isEmpty());
    assertTrue(actualBuildResult.unusedProperties.isEmpty());
  }

  /**
   * Test {@link ConfigurationBuilder#setOption(String, String)}.
   * <ul>
   *   <li>Given builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#setOption(String, String)}
   */
  @Test
  public void testSetOption_givenBuilder() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.setOption("Name", "42"));
  }

  /**
   * Test {@link ConfigurationBuilder#setOption(String, String)}.
   * <ul>
   *   <li>Given builder copyFrom defaultConfiguration.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#setOption(String, String)}
   */
  @Test
  public void testSetOption_givenBuilderCopyFromDefaultConfiguration() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();
    builderResult.copyFrom(Configuration.defaultConfiguration());

    // Act and Assert
    assertSame(builderResult, builderResult.setOption("Name", "42"));
  }

  /**
   * Test {@link ConfigurationBuilder#clearOption(String)}.
   * <ul>
   *   <li>Given builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#clearOption(String)}
   */
  @Test
  public void testClearOption_givenBuilder() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.clearOption("Name"));
  }

  /**
   * Test {@link ConfigurationBuilder#clearOption(String)}.
   * <ul>
   *   <li>Given builder copyFrom defaultConfiguration.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#clearOption(String)}
   */
  @Test
  public void testClearOption_givenBuilderCopyFromDefaultConfiguration() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();
    builderResult.copyFrom(Configuration.defaultConfiguration());

    // Act and Assert
    assertSame(builderResult, builderResult.clearOption("Name"));
  }

  /**
   * Test {@link ConfigurationBuilder#setOptions(Map)}.
   * <ul>
   *   <li>Given builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#setOptions(Map)}
   */
  @Test
  public void testSetOptions_givenBuilder() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.setOptions(new HashMap<>()));
  }

  /**
   * Test {@link ConfigurationBuilder#setOptions(Map)}.
   * <ul>
   *   <li>Given builder copyFrom defaultConfiguration.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#setOptions(Map)}
   */
  @Test
  public void testSetOptions_givenBuilderCopyFromDefaultConfiguration() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();
    builderResult.copyFrom(Configuration.defaultConfiguration());

    // Act and Assert
    assertSame(builderResult, builderResult.setOptions(new HashMap<>()));
  }

  /**
   * Test {@link ConfigurationBuilder#setPrefix(String)}.
   * <ul>
   *   <li>When {@code New Prefix}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#setPrefix(String)}
   */
  @Test
  public void testSetPrefix_whenNewPrefix_thenReturnBuilder() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.setPrefix("New Prefix"));
  }

  /**
   * Test {@link ConfigurationBuilder#copyFrom(Configuration)}.
   * <ul>
   *   <li>Given builder.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#copyFrom(Configuration)}
   */
  @Test
  public void testCopyFrom_givenBuilder_thenReturnBuilder() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.copyFrom(Configuration.defaultConfiguration()));
  }

  /**
   * Test {@link ConfigurationBuilder#copyOptionFromIfPresent(Configuration, String)}.
   * <p>
   * Method under test: {@link ConfigurationBuilder#copyOptionFromIfPresent(Configuration, String)}
   */
  @Test
  public void testCopyOptionFromIfPresent() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.copyOptionFromIfPresent(Configuration.defaultConfiguration(), "Option"));
  }

  /**
   * Test {@link ConfigurationBuilder#loadFromSource(CharSource, String, String)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code #}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#loadFromSource(CharSource, String, String)}
   */
  @Test
  public void testLoadFromSource_givenStringReaderWithNumberSign_thenReturnBuilder()
      throws IOException, InvalidConfigurationException {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();
    CharSource source = mock(CharSource.class);
    when(source.openBufferedStream()).thenReturn(new BufferedReader(new StringReader("#"), 1));

    // Act
    ConfigurationBuilder actualLoadFromSourceResult = builderResult.loadFromSource(source, "Base Path", "Source Name");

    // Assert
    verify(source).openBufferedStream();
    assertSame(builderResult, actualLoadFromSourceResult);
  }

  /**
   * Test {@link ConfigurationBuilder#loadFromSource(CharSource, String, String)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code //}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#loadFromSource(CharSource, String, String)}
   */
  @Test
  public void testLoadFromSource_givenStringReaderWithSlashSlash_thenReturnBuilder()
      throws IOException, InvalidConfigurationException {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();
    CharSource source = mock(CharSource.class);
    when(source.openBufferedStream()).thenReturn(new BufferedReader(new StringReader("//"), 1));

    // Act
    ConfigurationBuilder actualLoadFromSourceResult = builderResult.loadFromSource(source, "Base Path", "Source Name");

    // Assert
    verify(source).openBufferedStream();
    assertSame(builderResult, actualLoadFromSourceResult);
  }

  /**
   * Test {@link ConfigurationBuilder#loadFromSource(CharSource, String, String)}.
   * <ul>
   *   <li>Then throw {@link InvalidPathException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#loadFromSource(CharSource, String, String)}
   */
  @Test
  public void testLoadFromSource_thenThrowInvalidPathException() throws IOException, InvalidConfigurationException {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();
    CharSource source = mock(CharSource.class);
    when(source.openBufferedStream()).thenThrow(new InvalidPathException("0123456789ABCDEF", "0123456789ABCDEF"));

    // Act and Assert
    assertThrows(InvalidPathException.class, () -> builderResult.loadFromSource(source, "Base Path", "Source Name"));
    verify(source).openBufferedStream();
  }

  /**
   * Test {@link ConfigurationBuilder#loadFromResource(Class, String)}.
   * <ul>
   *   <li>Given builder copyFrom defaultConfiguration.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#loadFromResource(Class, String)}
   */
  @Test
  public void testLoadFromResource_givenBuilderCopyFromDefaultConfiguration() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();
    builderResult.copyFrom(Configuration.defaultConfiguration());
    Class<ConfigurationBuilder> contextClass = ConfigurationBuilder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builderResult.loadFromResource(contextClass, ""));
  }

  /**
   * Test {@link ConfigurationBuilder#loadFromResource(Class, String)}.
   * <ul>
   *   <li>Given builder.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#loadFromResource(Class, String)}
   */
  @Test
  public void testLoadFromResource_givenBuilder_thenThrowIllegalArgumentException() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();
    Class<ConfigurationBuilder> contextClass = ConfigurationBuilder.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builderResult.loadFromResource(contextClass, ""));
  }

  /**
   * Test {@link ConfigurationBuilder#addConverter(Class, TypeConverter)}.
   * <ul>
   *   <li>Given builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#addConverter(Class, TypeConverter)}
   */
  @Test
  public void testAddConverter_givenBuilder() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();
    Class<Object> cls = Object.class;

    // Act and Assert
    assertSame(builderResult, builderResult.addConverter(cls, mock(TypeConverter.class)));
  }

  /**
   * Test {@link ConfigurationBuilder#addConverter(Class, TypeConverter)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurationBuilder#addConverter(Class, TypeConverter)}
   */
  @Test
  public void testAddConverter_givenJavaLangObject() {
    // Arrange
    ConfigurationBuilder builderResult = Configuration.builder();
    Class<Object> cls = Object.class;
    builderResult.addConverter(cls, mock(TypeConverter.class));
    Class<Object> cls2 = Object.class;

    // Act and Assert
    assertSame(builderResult, builderResult.addConverter(cls2, mock(TypeConverter.class)));
  }
}
