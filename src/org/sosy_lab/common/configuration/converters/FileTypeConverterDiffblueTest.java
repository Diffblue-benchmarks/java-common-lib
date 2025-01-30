package org.sosy_lab.common.configuration.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.reflect.TypeToken;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.sosy_lab.common.configuration.Configuration;
import org.sosy_lab.common.configuration.InvalidConfigurationException;
import org.sosy_lab.common.log.LogManager;
import org.sosy_lab.common.log.TestLogManager;

public class FileTypeConverterDiffblueTest {
  /**
   * Test {@link FileTypeConverter#create(Configuration)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#create(Configuration)}
   */
  @Test
  public void testCreate_givenByteArrayOutputStreamWithOne() throws InvalidConfigurationException {
    // Arrange
    Configuration config = Configuration.defaultConfiguration();
    config.dumpUsedOptionsTo(new PrintStream(new ByteArrayOutputStream(1)));

    // Act
    FileTypeConverter actualCreateResult = FileTypeConverter.create(config);

    // Assert
    File toFileResult = actualCreateResult.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualCreateResult.getOutputDirectory());
    File toFileResult2 = actualCreateResult.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(actualCreateResult.safePathsOnly);
  }

  /**
   * Test {@link FileTypeConverter#create(Configuration)}.
   * <ul>
   *   <li>Given {@link TestLogManager#INSTANCE}.</li>
   *   <li>When defaultConfiguration enableLogging {@link TestLogManager#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#create(Configuration)}
   */
  @Test
  public void testCreate_givenInstance_whenDefaultConfigurationEnableLoggingInstance()
      throws InvalidConfigurationException {
    // Arrange
    Configuration config = Configuration.defaultConfiguration();
    config.enableLogging(TestLogManager.INSTANCE);

    // Act
    FileTypeConverter actualCreateResult = FileTypeConverter.create(config);

    // Assert
    File toFileResult = actualCreateResult.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualCreateResult.getOutputDirectory());
    File toFileResult2 = actualCreateResult.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(actualCreateResult.safePathsOnly);
  }

  /**
   * Test {@link FileTypeConverter#create(Configuration)}.
   * <ul>
   *   <li>When defaultConfiguration.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#create(Configuration)}
   */
  @Test
  public void testCreate_whenDefaultConfiguration() throws InvalidConfigurationException {
    // Arrange and Act
    FileTypeConverter actualCreateResult = FileTypeConverter.create(Configuration.defaultConfiguration());

    // Assert
    File toFileResult = actualCreateResult.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualCreateResult.getOutputDirectory());
    File toFileResult2 = actualCreateResult.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(actualCreateResult.safePathsOnly);
  }

  /**
   * Test {@link FileTypeConverter#createWithSafePathsOnly(Configuration)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#createWithSafePathsOnly(Configuration)}
   */
  @Test
  public void testCreateWithSafePathsOnly_givenByteArrayOutputStreamWithOne() throws InvalidConfigurationException {
    // Arrange
    Configuration config = Configuration.defaultConfiguration();
    config.dumpUsedOptionsTo(new PrintStream(new ByteArrayOutputStream(1)));

    // Act
    FileTypeConverter actualCreateWithSafePathsOnlyResult = FileTypeConverter.createWithSafePathsOnly(config);

    // Assert
    File toFileResult = actualCreateWithSafePathsOnlyResult.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualCreateWithSafePathsOnlyResult.getOutputDirectory());
    File toFileResult2 = actualCreateWithSafePathsOnlyResult.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertTrue(actualCreateWithSafePathsOnlyResult.safePathsOnly);
  }

  /**
   * Test {@link FileTypeConverter#createWithSafePathsOnly(Configuration)}.
   * <ul>
   *   <li>Given {@link TestLogManager#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#createWithSafePathsOnly(Configuration)}
   */
  @Test
  public void testCreateWithSafePathsOnly_givenInstance() throws InvalidConfigurationException {
    // Arrange
    Configuration config = Configuration.defaultConfiguration();
    config.enableLogging(TestLogManager.INSTANCE);

    // Act
    FileTypeConverter actualCreateWithSafePathsOnlyResult = FileTypeConverter.createWithSafePathsOnly(config);

    // Assert
    File toFileResult = actualCreateWithSafePathsOnlyResult.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualCreateWithSafePathsOnlyResult.getOutputDirectory());
    File toFileResult2 = actualCreateWithSafePathsOnlyResult.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertTrue(actualCreateWithSafePathsOnlyResult.safePathsOnly);
  }

  /**
   * Test {@link FileTypeConverter#createWithSafePathsOnly(Configuration)}.
   * <ul>
   *   <li>When defaultConfiguration.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#createWithSafePathsOnly(Configuration)}
   */
  @Test
  public void testCreateWithSafePathsOnly_whenDefaultConfiguration() throws InvalidConfigurationException {
    // Arrange and Act
    FileTypeConverter actualCreateWithSafePathsOnlyResult = FileTypeConverter
        .createWithSafePathsOnly(Configuration.defaultConfiguration());

    // Assert
    File toFileResult = actualCreateWithSafePathsOnlyResult.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualCreateWithSafePathsOnlyResult.getOutputDirectory());
    File toFileResult2 = actualCreateWithSafePathsOnlyResult.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertTrue(actualCreateWithSafePathsOnlyResult.safePathsOnly);
  }

  /**
   * Test {@link FileTypeConverter#getInstanceForNewConfiguration(Configuration)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#getInstanceForNewConfiguration(Configuration)}
   */
  @Test
  public void testGetInstanceForNewConfiguration_givenByteArrayOutputStreamWithOne()
      throws InvalidConfigurationException {
    // Arrange
    FileTypeConverter createResult = FileTypeConverter.create(Configuration.defaultConfiguration());
    Configuration pNewConfiguration = Configuration.defaultConfiguration();
    pNewConfiguration.dumpUsedOptionsTo(new PrintStream(new ByteArrayOutputStream(1)));

    // Act
    FileTypeConverter actualInstanceForNewConfiguration = createResult
        .getInstanceForNewConfiguration(pNewConfiguration);

    // Assert
    File toFileResult = actualInstanceForNewConfiguration.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualInstanceForNewConfiguration.getOutputDirectory());
    File toFileResult2 = actualInstanceForNewConfiguration.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(actualInstanceForNewConfiguration.safePathsOnly);
  }

  /**
   * Test {@link FileTypeConverter#getInstanceForNewConfiguration(Configuration)}.
   * <ul>
   *   <li>Given {@link TestLogManager#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#getInstanceForNewConfiguration(Configuration)}
   */
  @Test
  public void testGetInstanceForNewConfiguration_givenInstance() throws InvalidConfigurationException {
    // Arrange
    FileTypeConverter createResult = FileTypeConverter.create(Configuration.defaultConfiguration());
    Configuration pNewConfiguration = Configuration.defaultConfiguration();
    pNewConfiguration.enableLogging(TestLogManager.INSTANCE);

    // Act
    FileTypeConverter actualInstanceForNewConfiguration = createResult
        .getInstanceForNewConfiguration(pNewConfiguration);

    // Assert
    File toFileResult = actualInstanceForNewConfiguration.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualInstanceForNewConfiguration.getOutputDirectory());
    File toFileResult2 = actualInstanceForNewConfiguration.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(actualInstanceForNewConfiguration.safePathsOnly);
  }

  /**
   * Test {@link FileTypeConverter#getInstanceForNewConfiguration(Configuration)}.
   * <ul>
   *   <li>Then return {@link FileTypeConverter#safePathsOnly}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#getInstanceForNewConfiguration(Configuration)}
   */
  @Test
  public void testGetInstanceForNewConfiguration_thenReturnSafePathsOnly() throws InvalidConfigurationException {
    // Arrange
    FileTypeConverter createWithSafePathsOnlyResult = FileTypeConverter
        .createWithSafePathsOnly(Configuration.defaultConfiguration());

    // Act
    FileTypeConverter actualInstanceForNewConfiguration = createWithSafePathsOnlyResult
        .getInstanceForNewConfiguration(Configuration.defaultConfiguration());

    // Assert
    File toFileResult = actualInstanceForNewConfiguration.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualInstanceForNewConfiguration.getOutputDirectory());
    File toFileResult2 = actualInstanceForNewConfiguration.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertTrue(actualInstanceForNewConfiguration.safePathsOnly);
  }

  /**
   * Test {@link FileTypeConverter#getInstanceForNewConfiguration(Configuration)}.
   * <ul>
   *   <li>When defaultConfiguration.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#getInstanceForNewConfiguration(Configuration)}
   */
  @Test
  public void testGetInstanceForNewConfiguration_whenDefaultConfiguration() throws InvalidConfigurationException {
    // Arrange
    FileTypeConverter createResult = FileTypeConverter.create(Configuration.defaultConfiguration());

    // Act
    FileTypeConverter actualInstanceForNewConfiguration = createResult
        .getInstanceForNewConfiguration(Configuration.defaultConfiguration());

    // Assert
    File toFileResult = actualInstanceForNewConfiguration.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualInstanceForNewConfiguration.getOutputDirectory());
    File toFileResult2 = actualInstanceForNewConfiguration.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(actualInstanceForNewConfiguration.safePathsOnly);
  }

  /**
   * Test {@link FileTypeConverter#checkSafePath(Path, String)}.
   * <ul>
   *   <li>Given create defaultConfiguration.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#checkSafePath(Path, String)}
   */
  @Test
  public void testCheckSafePath_givenCreateDefaultConfiguration() throws InvalidConfigurationException {
    // Arrange
    Path pPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertSame(pPath,
        FileTypeConverter.create(Configuration.defaultConfiguration()).checkSafePath(pPath, "Option Name"));
  }

  /**
   * Test {@link FileTypeConverter#checkSafePath(Path, String)}.
   * <ul>
   *   <li>Then return Property is {@code java.io.tmpdir} is {@code foo} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#checkSafePath(Path, String)}
   */
  @Test
  public void testCheckSafePath_thenReturnPropertyIsJavaIoTmpdirIsFooAnd42() throws InvalidConfigurationException {
    // Arrange
    Path pPath = Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");

    // Act and Assert
    assertSame(pPath, FileTypeConverter.createWithSafePathsOnly(Configuration.defaultConfiguration())
        .checkSafePath(pPath, "Option Name"));
  }

  /**
   * Test {@link FileTypeConverter#checkSafePath(Path, String)}.
   * <ul>
   *   <li>Then return Property is {@code java.io.tmpdir} is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#checkSafePath(Path, String)}
   */
  @Test
  public void testCheckSafePath_thenReturnPropertyIsJavaIoTmpdirIsTestTxt() throws InvalidConfigurationException {
    // Arrange
    Path pPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertSame(pPath, FileTypeConverter.createWithSafePathsOnly(Configuration.defaultConfiguration())
        .checkSafePath(pPath, "Option Name"));
  }

  /**
   * Test {@link FileTypeConverter#getOutputDirectory()}.
   * <p>
   * Method under test: {@link FileTypeConverter#getOutputDirectory()}
   */
  @Test
  public void testGetOutputDirectory() throws InvalidConfigurationException {
    // Arrange, Act and Assert
    assertEquals("./output", FileTypeConverter.create(Configuration.defaultConfiguration()).getOutputDirectory());
  }

  /**
   * Test {@link FileTypeConverter#getOutputPath()}.
   * <p>
   * Method under test: {@link FileTypeConverter#getOutputPath()}
   */
  @Test
  public void testGetOutputPath() throws InvalidConfigurationException {
    // Arrange
    FileTypeConverter createResult = FileTypeConverter.create(Configuration.defaultConfiguration());

    // Act and Assert
    assertSame(createResult.outputPath, createResult.getOutputPath());
  }

  /**
   * Test {@link FileTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@link TypeToken} {@link TypeToken#getRawType()} return {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}
   */
  @Test
  public void testConvert_givenJavaLangObject_whenTypeTokenGetRawTypeReturnObject()
      throws InvalidConfigurationException {
    // Arrange
    FileTypeConverter createResult = FileTypeConverter.create(Configuration.defaultConfiguration());
    TypeToken<Object> pType = mock(TypeToken.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> createResult.convert("Option Name", "42", pType,
            new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), mock(LogManager.class)));
    verify(pType).getRawType();
  }

  /**
   * Test {@link FileTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}.
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}
   */
  @Test
  public void testConvert_givenUnsupportedOperationExceptionWithFoo() throws InvalidConfigurationException {
    // Arrange
    FileTypeConverter createResult = FileTypeConverter.create(Configuration.defaultConfiguration());
    TypeToken<Object> pType = mock(TypeToken.class);
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType())
        .thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> createResult.convert("Option Name", "42", pType,
            new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), mock(LogManager.class)));
    verify(pType).getRawType();
  }

  /**
   * Test {@link FileTypeConverter#convertDefaultValue(String, Object, TypeToken, Annotation)} with {@code optionName}, {@code pDefaultValue}, {@code pType}, {@code secondaryOption}.
   * <p>
   * Method under test: {@link FileTypeConverter#convertDefaultValue(String, Object, TypeToken, Annotation)}
   */
  @Test
  public void testConvertDefaultValueWithOptionNamePDefaultValuePTypeSecondaryOption()
      throws InvalidConfigurationException {
    // Arrange
    FileTypeConverter createResult = FileTypeConverter.create(Configuration.defaultConfiguration());
    TypeToken<Object> pType = mock(TypeToken.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> createResult.convertDefaultValue("Option Name", "P Default Value", pType,
            new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS)));
    verify(pType).getRawType();
  }

  /**
   * Test {@link FileTypeConverter#convertDefaultValue(String, Object, TypeToken, Annotation)} with {@code optionName}, {@code pDefaultValue}, {@code pType}, {@code secondaryOption}.
   * <p>
   * Method under test: {@link FileTypeConverter#convertDefaultValue(String, Object, TypeToken, Annotation)}
   */
  @Test
  public void testConvertDefaultValueWithOptionNamePDefaultValuePTypeSecondaryOption2()
      throws InvalidConfigurationException {
    // Arrange
    FileTypeConverter createResult = FileTypeConverter.create(Configuration.defaultConfiguration());
    TypeToken<Object> pType = mock(TypeToken.class);
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType())
        .thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> createResult.convertDefaultValue("Option Name", "P Default Value", pType,
            new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS)));
    verify(pType).getRawType();
  }

  /**
   * Test {@link FileTypeConverter#convertDefaultValueFromOtherInstance(String, Object, TypeToken, Annotation)}.
   * <p>
   * Method under test: {@link FileTypeConverter#convertDefaultValueFromOtherInstance(String, Object, TypeToken, Annotation)}
   */
  @Test
  public void testConvertDefaultValueFromOtherInstance() throws InvalidConfigurationException {
    // Arrange
    FileTypeConverter createResult = FileTypeConverter.create(Configuration.defaultConfiguration());
    TypeToken<Object> pType = mock(TypeToken.class);
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType())
        .thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> createResult.convertDefaultValueFromOtherInstance("Option Name", "P Default Value", pType,
            new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS)));
    verify(pType).getRawType();
  }

  /**
   * Test {@link FileTypeConverter#convertDefaultValueFromOtherInstance(String, Object, TypeToken, Annotation)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#convertDefaultValueFromOtherInstance(String, Object, TypeToken, Annotation)}
   */
  @Test
  public void testConvertDefaultValueFromOtherInstance_givenJavaLangObject() throws InvalidConfigurationException {
    // Arrange
    FileTypeConverter createResult = FileTypeConverter.create(Configuration.defaultConfiguration());
    TypeToken<Object> pType = mock(TypeToken.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> createResult.convertDefaultValueFromOtherInstance("Option Name", "P Default Value", pType,
            new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS)));
    verify(pType).getRawType();
  }

  /**
   * Test {@link FileTypeConverter#stripTrailingSeparator(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#stripTrailingSeparator(String)}
   */
  @Test
  public void testStripTrailingSeparator_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", FileTypeConverter.stripTrailingSeparator(""));
  }

  /**
   * Test {@link FileTypeConverter#stripTrailingSeparator(String)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#stripTrailingSeparator(String)}
   */
  @Test
  public void testStripTrailingSeparator_whenInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", FileTypeConverter.stripTrailingSeparator("Input"));
  }

  /**
   * Test {@link FileTypeConverter#stripTrailingSeparator(String)}.
   * <ul>
   *   <li>When {@code Input/}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverter#stripTrailingSeparator(String)}
   */
  @Test
  public void testStripTrailingSeparator_whenInput_thenReturnInput2() {
    // Arrange, Act and Assert
    assertEquals("Input", FileTypeConverter.stripTrailingSeparator("Input/"));
  }
}
