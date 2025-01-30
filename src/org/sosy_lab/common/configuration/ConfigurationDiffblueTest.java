package org.sosy_lab.common.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Member;
import java.util.Map;
import org.junit.Test;
import org.sosy_lab.common.configuration.converters.TypeConverter;
import org.sosy_lab.common.log.LogManager;
import org.sosy_lab.common.log.NullLogManager;

public class ConfigurationDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Configuration#enableSecureModeGlobally()}
   *   <li>{@link Configuration#getDefaultConverters()}
   *   <li>{@link Configuration#getLogger()}
   *   <li>{@link Configuration#getUsedOptionsPrintStream()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Configuration defaultConfigurationResult = Configuration.defaultConfiguration();

    // Act
    defaultConfigurationResult.enableSecureModeGlobally();
    Map<Class<?>, TypeConverter> actualDefaultConverters = defaultConfigurationResult.getDefaultConverters();
    LogManager actualLogger = defaultConfigurationResult.getLogger();

    // Assert
    assertTrue(actualLogger instanceof NullLogManager);
    assertNull(defaultConfigurationResult.getUsedOptionsPrintStream());
    assertEquals(NullLogManager.INSTANCE, actualLogger);
    assertSame(defaultConfigurationResult.DEFAULT_CONVERTERS, actualDefaultConverters);
  }

  /**
   * Test {@link Configuration#defaultConfiguration()}.
   * <p>
   * Method under test: {@link Configuration#defaultConfiguration()}
   */
  @Test
  public void testDefaultConfiguration() {
    // Arrange and Act
    Configuration actualDefaultConfigurationResult = Configuration.defaultConfiguration();

    // Assert
    LogManager logger = actualDefaultConfigurationResult.getLogger();
    assertTrue(logger instanceof NullLogManager);
    assertEquals("", actualDefaultConfigurationResult.prefix);
    assertNull(actualDefaultConfigurationResult.getUsedOptionsPrintStream());
    assertEquals(NullLogManager.INSTANCE, logger);
    assertTrue(actualDefaultConfigurationResult.properties.isEmpty());
    assertTrue(actualDefaultConfigurationResult.sources.isEmpty());
    assertTrue(actualDefaultConfigurationResult.getDeprecatedProperties().isEmpty());
    assertTrue(actualDefaultConfigurationResult.getUnusedProperties().isEmpty());
    assertTrue(actualDefaultConfigurationResult.deprecatedProperties.isEmpty());
    assertTrue(actualDefaultConfigurationResult.unusedProperties.isEmpty());
    assertEquals(actualDefaultConfigurationResult.DEFAULT_CONVERTERS, actualDefaultConfigurationResult.converters);
  }

  /**
   * Test {@link Configuration#copyWithNewPrefix(Configuration, String)}.
   * <ul>
   *   <li>When defaultConfiguration.</li>
   *   <li>Then return {@link Configuration#prefix} is {@code New Prefix.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#copyWithNewPrefix(Configuration, String)}
   */
  @Test
  public void testCopyWithNewPrefix_whenDefaultConfiguration_thenReturnPrefixIsNewPrefix() {
    // Arrange
    Configuration oldConfig = Configuration.defaultConfiguration();

    // Act
    Configuration actualCopyWithNewPrefixResult = Configuration.copyWithNewPrefix(oldConfig, "New Prefix");

    // Assert
    assertEquals("New Prefix.", actualCopyWithNewPrefixResult.prefix);
    assertNull(actualCopyWithNewPrefixResult.getUsedOptionsPrintStream());
    Map<Class<?>, TypeConverter> resultClassTypeConverterMap = actualCopyWithNewPrefixResult.DEFAULT_CONVERTERS;
    assertEquals(resultClassTypeConverterMap, actualCopyWithNewPrefixResult.converters);
    assertEquals(resultClassTypeConverterMap, oldConfig.converters);
  }

  /**
   * Test {@link Configuration#copyWithNewPrefix(Configuration, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link Configuration#prefix} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#copyWithNewPrefix(Configuration, String)}
   */
  @Test
  public void testCopyWithNewPrefix_whenEmptyString_thenReturnPrefixIsEmptyString() {
    // Arrange
    Configuration oldConfig = Configuration.defaultConfiguration();

    // Act
    Configuration actualCopyWithNewPrefixResult = Configuration.copyWithNewPrefix(oldConfig, "");

    // Assert
    assertEquals("", actualCopyWithNewPrefixResult.prefix);
    assertNull(actualCopyWithNewPrefixResult.getUsedOptionsPrintStream());
    Map<Class<?>, TypeConverter> resultClassTypeConverterMap = actualCopyWithNewPrefixResult.DEFAULT_CONVERTERS;
    assertEquals(resultClassTypeConverterMap, actualCopyWithNewPrefixResult.converters);
    assertEquals(resultClassTypeConverterMap, oldConfig.converters);
  }

  /**
   * Test {@link Configuration#createConverterMap()}.
   * <p>
   * Method under test: {@link Configuration#createConverterMap()}
   */
  @Test
  public void testCreateConverterMap() {
    // Arrange and Act
    Map<Class<?>, TypeConverter> actualCreateConverterMapResult = Configuration.createConverterMap();

    // Assert
    assertTrue(actualCreateConverterMapResult.isEmpty());
  }

  /**
   * Test {@link Configuration#dumpUsedOptionsTo(PrintStream)}.
   * <p>
   * Method under test: {@link Configuration#dumpUsedOptionsTo(PrintStream)}
   */
  @Test
  public void testDumpUsedOptionsTo() {
    // Arrange
    Configuration defaultConfigurationResult = Configuration.defaultConfiguration();
    PrintStream out = new PrintStream(new ByteArrayOutputStream(1));

    // Act
    defaultConfigurationResult.dumpUsedOptionsTo(out);

    // Assert
    assertSame(out, defaultConfigurationResult.getUsedOptionsPrintStream());
  }

  /**
   * Test {@link Configuration#getProperty(String)}.
   * <ul>
   *   <li>Given copyWithNewPrefix defaultConfiguration and {@code New Prefix}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#getProperty(String)}
   */
  @Test
  public void testGetProperty_givenCopyWithNewPrefixDefaultConfigurationAndNewPrefix() {
    // Arrange, Act and Assert
    assertNull(Configuration.copyWithNewPrefix(Configuration.defaultConfiguration(), "New Prefix").getProperty("Key"));
  }

  /**
   * Test {@link Configuration#getProperty(String)}.
   * <ul>
   *   <li>Given defaultConfiguration.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#getProperty(String)}
   */
  @Test
  public void testGetProperty_givenDefaultConfiguration() {
    // Arrange, Act and Assert
    assertNull(Configuration.defaultConfiguration().getProperty("Key"));
  }

  /**
   * Test {@link Configuration#hasProperty(String)}.
   * <p>
   * Method under test: {@link Configuration#hasProperty(String)}
   */
  @Test
  public void testHasProperty() {
    // Arrange, Act and Assert
    assertFalse(Configuration.defaultConfiguration().hasProperty("Key"));
  }

  /**
   * Test {@link Configuration#getUnusedProperties()}.
   * <p>
   * Method under test: {@link Configuration#getUnusedProperties()}
   */
  @Test
  public void testGetUnusedProperties() {
    // Arrange, Act and Assert
    assertTrue(Configuration.defaultConfiguration().getUnusedProperties().isEmpty());
  }

  /**
   * Test {@link Configuration#getDeprecatedProperties()}.
   * <p>
   * Method under test: {@link Configuration#getDeprecatedProperties()}
   */
  @Test
  public void testGetDeprecatedProperties() {
    // Arrange, Act and Assert
    assertTrue(Configuration.defaultConfiguration().getDeprecatedProperties().isEmpty());
  }

  /**
   * Test {@link Configuration#asPropertiesString()}.
   * <ul>
   *   <li>Given defaultConfiguration.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#asPropertiesString()}
   */
  @Test
  public void testAsPropertiesString_givenDefaultConfiguration() {
    // Arrange, Act and Assert
    assertEquals("", Configuration.defaultConfiguration().asPropertiesString());
  }

  /**
   * Test {@link Configuration#getOptionName(Options, Member, Option)} with {@code options}, {@code member}, {@code option}.
   * <p>
   * Method under test: {@link Configuration#getOptionName(Options, Member, Option)}
   */
  @Test
  public void testGetOptionNameWithOptionsMemberOption() {
    // Arrange
    Options options = mock(Options.class);
    when(options.prefix()).thenThrow(new UnsupportedOperationException("foo"));
    Option option = mock(Option.class);
    when(option.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> Configuration.getOptionName(options, null, option));
    verify(option).name();
    verify(options).prefix();
  }

  /**
   * Test {@link Configuration#getOptionName(Options, Member, Option, boolean)} with {@code options}, {@code member}, {@code option}, {@code isDeprecated}.
   * <p>
   * Method under test: {@link Configuration#getOptionName(Options, Member, Option, boolean)}
   */
  @Test
  public void testGetOptionNameWithOptionsMemberOptionIsDeprecated() {
    // Arrange
    Options options = mock(Options.class);
    when(options.prefix()).thenThrow(new UnsupportedOperationException("foo"));
    Option option = mock(Option.class);
    when(option.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> Configuration.getOptionName(options, null, option, false));
    verify(option).name();
    verify(options).prefix();
  }

  /**
   * Test {@link Configuration#getOptionName(Options, Member, Option, boolean)} with {@code options}, {@code member}, {@code option}, {@code isDeprecated}.
   * <p>
   * Method under test: {@link Configuration#getOptionName(Options, Member, Option, boolean)}
   */
  @Test
  public void testGetOptionNameWithOptionsMemberOptionIsDeprecated2() {
    // Arrange
    Options options = mock(Options.class);
    when(options.deprecatedPrefix()).thenReturn("Deprecated Prefix");
    Option option = mock(Option.class);
    when(option.deprecatedName()).thenReturn("Deprecated Name");

    // Act
    String actualOptionName = Configuration.getOptionName(options, null, option, true);

    // Assert
    verify(option).deprecatedName();
    verify(options).deprecatedPrefix();
    assertEquals("Deprecated Prefix.Deprecated Name", actualOptionName);
  }

  /**
   * Test {@link Configuration#getOptionName(Options, Member, Option, boolean)} with {@code options}, {@code member}, {@code option}, {@code isDeprecated}.
   * <p>
   * Method under test: {@link Configuration#getOptionName(Options, Member, Option, boolean)}
   */
  @Test
  public void testGetOptionNameWithOptionsMemberOptionIsDeprecated3() {
    // Arrange
    Options options = mock(Options.class);
    when(options.deprecatedPrefix()).thenThrow(new UnsupportedOperationException("foo"));
    Option option = mock(Option.class);
    when(option.deprecatedName()).thenReturn("Deprecated Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> Configuration.getOptionName(options, null, option, true));
    verify(option).deprecatedName();
    verify(options).deprecatedPrefix();
  }

  /**
   * Test {@link Configuration#getOptionName(Options, Member, Option, boolean)} with {@code options}, {@code member}, {@code option}, {@code isDeprecated}.
   * <p>
   * Method under test: {@link Configuration#getOptionName(Options, Member, Option, boolean)}
   */
  @Test
  public void testGetOptionNameWithOptionsMemberOptionIsDeprecated4() {
    // Arrange
    Options options = mock(Options.class);
    when(options.deprecatedPrefix()).thenReturn("");
    when(options.prefix()).thenReturn("Prefix");
    Option option = mock(Option.class);
    when(option.deprecatedName()).thenReturn("Deprecated Name");

    // Act
    String actualOptionName = Configuration.getOptionName(options, null, option, true);

    // Assert
    verify(option).deprecatedName();
    verify(options).deprecatedPrefix();
    verify(options).prefix();
    assertEquals("Prefix.Deprecated Name", actualOptionName);
  }

  /**
   * Test {@link Configuration#getOptionName(Options, Member, Option, boolean)} with {@code options}, {@code member}, {@code option}, {@code isDeprecated}.
   * <p>
   * Method under test: {@link Configuration#getOptionName(Options, Member, Option, boolean)}
   */
  @Test
  public void testGetOptionNameWithOptionsMemberOptionIsDeprecated5() {
    // Arrange
    Options options = mock(Options.class);
    when(options.deprecatedPrefix()).thenReturn("Deprecated Prefix");
    Option option = mock(Option.class);
    when(option.deprecatedName()).thenReturn("");
    when(option.name()).thenReturn("Name");

    // Act
    String actualOptionName = Configuration.getOptionName(options, null, option, true);

    // Assert
    verify(option).deprecatedName();
    verify(option).name();
    verify(options).deprecatedPrefix();
    assertEquals("Deprecated Prefix.Name", actualOptionName);
  }

  /**
   * Test {@link Configuration#getOptionName(Options, Member, Option, boolean)} with {@code options}, {@code member}, {@code option}, {@code isDeprecated}.
   * <ul>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#getOptionName(Options, Member, Option, boolean)}
   */
  @Test
  public void testGetOptionNameWithOptionsMemberOptionIsDeprecated_thenReturnName() {
    // Arrange
    Options options = mock(Options.class);
    when(options.prefix()).thenReturn("");
    Option option = mock(Option.class);
    when(option.name()).thenReturn("Name");

    // Act
    String actualOptionName = Configuration.getOptionName(options, null, option, false);

    // Assert
    verify(option).name();
    verify(options).prefix();
    assertEquals("Name", actualOptionName);
  }

  /**
   * Test {@link Configuration#getOptionName(Options, Member, Option, boolean)} with {@code options}, {@code member}, {@code option}, {@code isDeprecated}.
   * <ul>
   *   <li>Then return {@code Prefix.Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#getOptionName(Options, Member, Option, boolean)}
   */
  @Test
  public void testGetOptionNameWithOptionsMemberOptionIsDeprecated_thenReturnPrefixName() {
    // Arrange
    Options options = mock(Options.class);
    when(options.prefix()).thenReturn("Prefix");
    Option option = mock(Option.class);
    when(option.name()).thenReturn("Name");

    // Act
    String actualOptionName = Configuration.getOptionName(options, null, option, false);

    // Assert
    verify(option).name();
    verify(options).prefix();
    assertEquals("Prefix.Name", actualOptionName);
  }

  /**
   * Test {@link Configuration#getOptionName(Options, Member, Option)} with {@code options}, {@code member}, {@code option}.
   * <ul>
   *   <li>Given {@code Prefix}.</li>
   *   <li>Then return {@code Prefix.Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#getOptionName(Options, Member, Option)}
   */
  @Test
  public void testGetOptionNameWithOptionsMemberOption_givenPrefix_thenReturnPrefixName() {
    // Arrange
    Options options = mock(Options.class);
    when(options.prefix()).thenReturn("Prefix");
    Option option = mock(Option.class);
    when(option.name()).thenReturn("Name");

    // Act
    String actualOptionName = Configuration.getOptionName(options, null, option);

    // Assert
    verify(option).name();
    verify(options).prefix();
    assertEquals("Prefix.Name", actualOptionName);
  }

  /**
   * Test {@link Configuration#getOptionName(Options, Member, Option)} with {@code options}, {@code member}, {@code option}.
   * <ul>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#getOptionName(Options, Member, Option)}
   */
  @Test
  public void testGetOptionNameWithOptionsMemberOption_thenReturnName() {
    // Arrange
    Options options = mock(Options.class);
    when(options.prefix()).thenReturn("");
    Option option = mock(Option.class);
    when(option.name()).thenReturn("Name");

    // Act
    String actualOptionName = Configuration.getOptionName(options, null, option);

    // Assert
    verify(option).name();
    verify(options).prefix();
    assertEquals("Name", actualOptionName);
  }

  /**
   * Test {@link Configuration#getOptionName(Options, Member, Option)} with {@code options}, {@code member}, {@code option}.
   * <ul>
   *   <li>When {@link Options}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#getOptionName(Options, Member, Option)}
   */
  @Test
  public void testGetOptionNameWithOptionsMemberOption_whenOptions() {
    // Arrange
    Options options = mock(Options.class);
    Option option = mock(Option.class);
    when(option.name()).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> Configuration.getOptionName(options, null, option));
    verify(option).name();
  }

  /**
   * Test {@link Configuration#toString()}.
   * <ul>
   *   <li>Given copyWithNewPrefix defaultConfiguration and {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#toString()}
   */
  @Test
  public void testToString_givenCopyWithNewPrefixDefaultConfigurationAndComma() {
    // Arrange, Act and Assert
    assertEquals("Configuration with prefix , .: []",
        Configuration.copyWithNewPrefix(Configuration.defaultConfiguration(), ", ").toString());
  }

  /**
   * Test {@link Configuration#toString()}.
   * <ul>
   *   <li>Given defaultConfiguration.</li>
   *   <li>Then return {@code Configuration: []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#toString()}
   */
  @Test
  public void testToString_givenDefaultConfiguration_thenReturnConfiguration() {
    // Arrange, Act and Assert
    assertEquals("Configuration: []", Configuration.defaultConfiguration().toString());
  }

  /**
   * Test {@link Configuration#fromCmdLineArguments(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code Args}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#fromCmdLineArguments(String[])}
   */
  @Test
  public void testFromCmdLineArguments_whenArrayOfStringWithArgs() throws InvalidConfigurationException {
    // Arrange, Act and Assert
    assertThrows(InvalidConfigurationException.class, () -> Configuration.fromCmdLineArguments(new String[]{"Args"}));
  }

  /**
   * Test {@link Configuration#fromCmdLineArguments(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code --} and {@code --}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#fromCmdLineArguments(String[])}
   */
  @Test
  public void testFromCmdLineArguments_whenArrayOfStringWithDashDashAndDashDash() throws InvalidConfigurationException {
    // Arrange, Act and Assert
    assertThrows(InvalidConfigurationException.class, () -> Configuration.fromCmdLineArguments(new String[]{"--", "--",
        "--", "--", "--", "--", "--", "--", "--", "--", "--", "--", "--", "--", "--", "--", "--", "--"}));
  }

  /**
   * Test {@link Configuration#fromCmdLineArguments(String[])}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   *   <li>Then Logger return {@link NullLogManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#fromCmdLineArguments(String[])}
   */
  @Test
  public void testFromCmdLineArguments_whenEmptyArrayOfString_thenLoggerReturnNullLogManager()
      throws InvalidConfigurationException {
    // Arrange and Act
    Configuration actualFromCmdLineArgumentsResult = Configuration.fromCmdLineArguments(new String[]{});

    // Assert
    LogManager logger = actualFromCmdLineArgumentsResult.getLogger();
    assertTrue(logger instanceof NullLogManager);
    assertEquals("", actualFromCmdLineArgumentsResult.prefix);
    assertNull(actualFromCmdLineArgumentsResult.getUsedOptionsPrintStream());
    assertEquals(NullLogManager.INSTANCE, logger);
    assertTrue(actualFromCmdLineArgumentsResult.properties.isEmpty());
    assertTrue(actualFromCmdLineArgumentsResult.sources.isEmpty());
    assertTrue(actualFromCmdLineArgumentsResult.getDeprecatedProperties().isEmpty());
    assertTrue(actualFromCmdLineArgumentsResult.getUnusedProperties().isEmpty());
    assertTrue(actualFromCmdLineArgumentsResult.deprecatedProperties.isEmpty());
    assertTrue(actualFromCmdLineArgumentsResult.unusedProperties.isEmpty());
    assertEquals(actualFromCmdLineArgumentsResult.DEFAULT_CONVERTERS, actualFromCmdLineArgumentsResult.converters);
  }
}
