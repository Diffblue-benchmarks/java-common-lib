package org.sosy_lab.common.configuration.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.List;
import org.junit.Test;
import org.sosy_lab.common.configuration.Configuration;
import org.sosy_lab.common.configuration.InvalidConfigurationException;
import org.sosy_lab.common.configuration.converters.FileTypeConverterTest.FileInjectionTestOptions;
import org.sosy_lab.common.configuration.converters.FileTypeConverterTest.FileTypeConverterSafeModeTest;
import org.sosy_lab.common.configuration.converters.FileTypeConverterTest.FileTypeConverterTestBase;
import org.sosy_lab.common.configuration.converters.FileTypeConverterTest.FileTypeConverterUnsafeModeTest;
import org.sosy_lab.common.log.TestLogManager;

public class FileTypeConverterTestDiffblueTest {
  /**
   * Test FileInjectionTestOptions new {@link FileInjectionTestOptions} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link FileInjectionTestOptions}
   */
  @Test
  public void testFileInjectionTestOptionsNewFileInjectionTestOptions() {
    // Arrange, Act and Assert
    assertNull((new FileInjectionTestOptions()).path);
  }

  /**
   * Test FileTypeConverterSafeModeTest {@link FileTypeConverterSafeModeTest#createFileTypeConverter(Configuration)}.
   * <p>
   * Method under test: {@link FileTypeConverterSafeModeTest#createFileTypeConverter(Configuration)}
   */
  @Test
  public void testFileTypeConverterSafeModeTestCreateFileTypeConverter() throws InvalidConfigurationException {
    // Arrange
    FileTypeConverterSafeModeTest fileTypeConverterSafeModeTest = new FileTypeConverterSafeModeTest();

    // Act
    FileTypeConverter actualCreateFileTypeConverterResult = fileTypeConverterSafeModeTest
        .createFileTypeConverter(Configuration.defaultConfiguration());

    // Assert
    File toFileResult = actualCreateFileTypeConverterResult.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualCreateFileTypeConverterResult.getOutputDirectory());
    File toFileResult2 = actualCreateFileTypeConverterResult.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertTrue(actualCreateFileTypeConverterResult.safePathsOnly);
  }

  /**
   * Test FileTypeConverterSafeModeTest {@link FileTypeConverterSafeModeTest#createFileTypeConverter(Configuration)}.
   * <p>
   * Method under test: {@link FileTypeConverterSafeModeTest#createFileTypeConverter(Configuration)}
   */
  @Test
  public void testFileTypeConverterSafeModeTestCreateFileTypeConverter2() throws InvalidConfigurationException {
    // Arrange
    FileTypeConverterSafeModeTest fileTypeConverterSafeModeTest = new FileTypeConverterSafeModeTest();
    Configuration pConfig = Configuration.defaultConfiguration();
    pConfig.dumpUsedOptionsTo(new PrintStream(new ByteArrayOutputStream(1)));

    // Act
    FileTypeConverter actualCreateFileTypeConverterResult = fileTypeConverterSafeModeTest
        .createFileTypeConverter(pConfig);

    // Assert
    File toFileResult = actualCreateFileTypeConverterResult.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualCreateFileTypeConverterResult.getOutputDirectory());
    File toFileResult2 = actualCreateFileTypeConverterResult.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertTrue(actualCreateFileTypeConverterResult.safePathsOnly);
  }

  /**
   * Test FileTypeConverterSafeModeTest {@link FileTypeConverterSafeModeTest#createFileTypeConverter(Configuration)}.
   * <ul>
   *   <li>Given {@link TestLogManager#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverterSafeModeTest#createFileTypeConverter(Configuration)}
   */
  @Test
  public void testFileTypeConverterSafeModeTestCreateFileTypeConverter_givenInstance()
      throws InvalidConfigurationException {
    // Arrange
    FileTypeConverterSafeModeTest fileTypeConverterSafeModeTest = new FileTypeConverterSafeModeTest();
    Configuration pConfig = Configuration.defaultConfiguration();
    pConfig.enableLogging(TestLogManager.INSTANCE);

    // Act
    FileTypeConverter actualCreateFileTypeConverterResult = fileTypeConverterSafeModeTest
        .createFileTypeConverter(pConfig);

    // Assert
    File toFileResult = actualCreateFileTypeConverterResult.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualCreateFileTypeConverterResult.getOutputDirectory());
    File toFileResult2 = actualCreateFileTypeConverterResult.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertTrue(actualCreateFileTypeConverterResult.safePathsOnly);
  }

  /**
   * Test FileTypeConverterSafeModeTest {@link FileTypeConverterSafeModeTest#isAllowed(boolean)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverterSafeModeTest#isAllowed(boolean)}
   */
  @Test
  public void testFileTypeConverterSafeModeTestIsAllowed_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FileTypeConverterSafeModeTest()).isAllowed(false));
  }

  /**
   * Test FileTypeConverterSafeModeTest {@link FileTypeConverterSafeModeTest#isAllowed(boolean)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverterSafeModeTest#isAllowed(boolean)}
   */
  @Test
  public void testFileTypeConverterSafeModeTestIsAllowed_thenReturnTrue() {
    // Arrange
    FileTypeConverterSafeModeTest fileTypeConverterSafeModeTest = new FileTypeConverterSafeModeTest();
    fileTypeConverterSafeModeTest.isSafe = true;

    // Act and Assert
    assertTrue(fileTypeConverterSafeModeTest.isAllowed(false));
  }

  /**
   * Test FileTypeConverterSafeModeTest {@link FileTypeConverterSafeModeTest#isAllowed(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverterSafeModeTest#isAllowed(boolean)}
   */
  @Test
  public void testFileTypeConverterSafeModeTestIsAllowed_whenTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FileTypeConverterSafeModeTest()).isAllowed(true));
  }

  /**
   * Test FileTypeConverterSafeModeTest new {@link FileTypeConverterSafeModeTest} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link FileTypeConverterSafeModeTest}
   */
  @Test
  public void testFileTypeConverterSafeModeTestNewFileTypeConverterSafeModeTest() {
    // Arrange and Act
    FileTypeConverterSafeModeTest actualFileTypeConverterSafeModeTest = new FileTypeConverterSafeModeTest();

    // Assert
    assertNull(actualFileTypeConverterSafeModeTest.testPath);
    assertFalse(actualFileTypeConverterSafeModeTest.isSafe);
    assertFalse(actualFileTypeConverterSafeModeTest.isSafeWhenInConfigFile);
  }

  /**
   * Test FileTypeConverterTestBase {@link FileTypeConverterTestBase#isWindows()}.
   * <p>
   * Method under test: {@link FileTypeConverterTestBase#isWindows()}
   */
  @Test
  public void testFileTypeConverterTestBaseIsWindows() {
    // Arrange, Act and Assert
    assertFalse(FileTypeConverterTestBase.isWindows());
  }

  /**
   * Test FileTypeConverterTestBase {@link FileTypeConverterTestBase#testPaths()}.
   * <p>
   * Method under test: {@link FileTypeConverterTestBase#testPaths()}
   */
  @Test
  public void testFileTypeConverterTestBaseTestPaths() {
    // Arrange and Act
    List<Object[]> actualTestPathsResult = FileTypeConverterTestBase.testPaths();

    // Assert
    assertEquals(19, actualTestPathsResult.size());
    assertEquals(3, actualTestPathsResult.get(0).length);
    assertEquals(3, actualTestPathsResult.get(1).length);
    assertEquals(3, actualTestPathsResult.get(13).length);
    assertEquals(3, actualTestPathsResult.get(14).length);
    assertEquals(3, actualTestPathsResult.get(15).length);
    assertEquals(3, actualTestPathsResult.get(17).length);
    assertEquals(3, actualTestPathsResult.get(18).length);
    assertEquals(3, actualTestPathsResult.get(2).length);
    assertEquals(3, actualTestPathsResult.get(3).length);
    assertEquals(3, actualTestPathsResult.get(4).length);
    assertEquals(3, actualTestPathsResult.get(5).length);
    assertEquals(3, actualTestPathsResult.get(Short.SIZE).length);
  }

  /**
   * Test FileTypeConverterTestBase_FileInjectionTestOptions new {@link FileTypeConverterTestBase.FileInjectionTestOptions} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link FileTypeConverterTestBase.FileInjectionTestOptions}
   */
  @Test
  public void testFileTypeConverterTestBase_FileInjectionTestOptionsNewFileInjectionTestOptions() {
    // Arrange, Act and Assert
    assertNull((new FileTypeConverterTestBase.FileInjectionTestOptions()).path);
  }

  /**
   * Test FileTypeConverterUnsafeModeTest {@link FileTypeConverterUnsafeModeTest#createFileTypeConverter(Configuration)}.
   * <p>
   * Method under test: {@link FileTypeConverterUnsafeModeTest#createFileTypeConverter(Configuration)}
   */
  @Test
  public void testFileTypeConverterUnsafeModeTestCreateFileTypeConverter() throws InvalidConfigurationException {
    // Arrange
    FileTypeConverterUnsafeModeTest fileTypeConverterUnsafeModeTest = new FileTypeConverterUnsafeModeTest();

    // Act
    FileTypeConverter actualCreateFileTypeConverterResult = fileTypeConverterUnsafeModeTest
        .createFileTypeConverter(Configuration.defaultConfiguration());

    // Assert
    File toFileResult = actualCreateFileTypeConverterResult.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualCreateFileTypeConverterResult.getOutputDirectory());
    File toFileResult2 = actualCreateFileTypeConverterResult.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(actualCreateFileTypeConverterResult.safePathsOnly);
  }

  /**
   * Test FileTypeConverterUnsafeModeTest {@link FileTypeConverterUnsafeModeTest#createFileTypeConverter(Configuration)}.
   * <p>
   * Method under test: {@link FileTypeConverterUnsafeModeTest#createFileTypeConverter(Configuration)}
   */
  @Test
  public void testFileTypeConverterUnsafeModeTestCreateFileTypeConverter2() throws InvalidConfigurationException {
    // Arrange
    FileTypeConverterUnsafeModeTest fileTypeConverterUnsafeModeTest = new FileTypeConverterUnsafeModeTest();
    Configuration pConfig = Configuration.defaultConfiguration();
    pConfig.dumpUsedOptionsTo(new PrintStream(new ByteArrayOutputStream(1)));

    // Act
    FileTypeConverter actualCreateFileTypeConverterResult = fileTypeConverterUnsafeModeTest
        .createFileTypeConverter(pConfig);

    // Assert
    File toFileResult = actualCreateFileTypeConverterResult.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualCreateFileTypeConverterResult.getOutputDirectory());
    File toFileResult2 = actualCreateFileTypeConverterResult.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(actualCreateFileTypeConverterResult.safePathsOnly);
  }

  /**
   * Test FileTypeConverterUnsafeModeTest {@link FileTypeConverterUnsafeModeTest#createFileTypeConverter(Configuration)}.
   * <ul>
   *   <li>Given {@link TestLogManager#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileTypeConverterUnsafeModeTest#createFileTypeConverter(Configuration)}
   */
  @Test
  public void testFileTypeConverterUnsafeModeTestCreateFileTypeConverter_givenInstance()
      throws InvalidConfigurationException {
    // Arrange
    FileTypeConverterUnsafeModeTest fileTypeConverterUnsafeModeTest = new FileTypeConverterUnsafeModeTest();
    Configuration pConfig = Configuration.defaultConfiguration();
    pConfig.enableLogging(TestLogManager.INSTANCE);

    // Act
    FileTypeConverter actualCreateFileTypeConverterResult = fileTypeConverterUnsafeModeTest
        .createFileTypeConverter(pConfig);

    // Assert
    File toFileResult = actualCreateFileTypeConverterResult.rootPath.toFile();
    assertEquals(".", toFileResult.getName());
    assertEquals("./output", actualCreateFileTypeConverterResult.getOutputDirectory());
    File toFileResult2 = actualCreateFileTypeConverterResult.getOutputPath().toFile();
    assertEquals("output", toFileResult2.getName());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(actualCreateFileTypeConverterResult.safePathsOnly);
  }

  /**
   * Test FileTypeConverterUnsafeModeTest {@link FileTypeConverterUnsafeModeTest#isAllowed(boolean)}.
   * <p>
   * Method under test: {@link FileTypeConverterUnsafeModeTest#isAllowed(boolean)}
   */
  @Test
  public void testFileTypeConverterUnsafeModeTestIsAllowed() {
    // Arrange, Act and Assert
    assertTrue((new FileTypeConverterUnsafeModeTest()).isAllowed(true));
  }

  /**
   * Test FileTypeConverterUnsafeModeTest new {@link FileTypeConverterUnsafeModeTest} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link FileTypeConverterUnsafeModeTest}
   */
  @Test
  public void testFileTypeConverterUnsafeModeTestNewFileTypeConverterUnsafeModeTest() {
    // Arrange and Act
    FileTypeConverterUnsafeModeTest actualFileTypeConverterUnsafeModeTest = new FileTypeConverterUnsafeModeTest();

    // Assert
    assertNull(actualFileTypeConverterUnsafeModeTest.testPath);
    assertFalse(actualFileTypeConverterUnsafeModeTest.isSafe);
    assertFalse(actualFileTypeConverterUnsafeModeTest.isSafeWhenInConfigFile);
  }
}
