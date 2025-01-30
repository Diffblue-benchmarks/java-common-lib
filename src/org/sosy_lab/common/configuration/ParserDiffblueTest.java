package org.sosy_lab.common.configuration;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.io.CharSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.junit.Test;
import org.sosy_lab.common.configuration.Parser.InvalidConfigurationFileException;

public class ParserDiffblueTest {
  /**
   * Test {@link Parser#parse(CharSource, Optional, Path)} with {@code source}, {@code basePath}, {@code sourcePath}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Parser#parse(CharSource, Optional, Path)}
   */
  @Test
  public void testParseWithSourceBasePathSourcePath_givenStringReaderWithFoo()
      throws IOException, InvalidConfigurationException {
    // Arrange
    CharSource source = mock(CharSource.class);
    when(source.openBufferedStream()).thenReturn(new BufferedReader(new StringReader("foo"), 1));
    Optional<Path> basePath = Optional.of(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act and Assert
    assertThrows(InvalidConfigurationFileException.class,
        () -> Parser.parse(source, basePath, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
    verify(source).openBufferedStream();
  }

  /**
   * Test {@link Parser#parse(CharSource, Optional, Path)} with {@code source}, {@code basePath}, {@code sourcePath}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Parser#parse(CharSource, Optional, Path)}
   */
  @Test
  public void testParseWithSourceBasePathSourcePath_givenStringReaderWithLeftSquareBracket()
      throws IOException, InvalidConfigurationException {
    // Arrange
    CharSource source = mock(CharSource.class);
    when(source.openBufferedStream()).thenReturn(new BufferedReader(new StringReader("["), 1));
    Optional<Path> basePath = Optional.of(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act and Assert
    assertThrows(InvalidConfigurationFileException.class,
        () -> Parser.parse(source, basePath, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
    verify(source).openBufferedStream();
  }

  /**
   * Test {@link Parser#parse(CharSource, Optional, Path)} with {@code source}, {@code basePath}, {@code sourcePath}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Parser#parse(CharSource, Optional, Path)}
   */
  @Test
  public void testParseWithSourceBasePathSourcePath_givenStringReaderWithNumberSign()
      throws IOException, InvalidConfigurationException {
    // Arrange
    CharSource source = mock(CharSource.class);
    when(source.openBufferedStream()).thenReturn(new BufferedReader(new StringReader("#"), 1));
    Optional<Path> basePath = Optional.of(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act
    Parser actualParseResult = Parser.parse(source, basePath,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Assert
    verify(source).openBufferedStream();
    assertTrue(actualParseResult.getOptions().isEmpty());
    assertTrue(actualParseResult.getSources().isEmpty());
  }

  /**
   * Test {@link Parser#parse(CharSource, Optional, Path)} with {@code source}, {@code basePath}, {@code sourcePath}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code ##}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Parser#parse(CharSource, Optional, Path)}
   */
  @Test
  public void testParseWithSourceBasePathSourcePath_givenStringReaderWithNumberSignNumberSign()
      throws IOException, InvalidConfigurationException {
    // Arrange
    CharSource source = mock(CharSource.class);
    when(source.openBufferedStream()).thenReturn(new BufferedReader(new StringReader("##"), 1));
    Optional<Path> basePath = Optional.of(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act and Assert
    assertThrows(InvalidConfigurationFileException.class,
        () -> Parser.parse(source, basePath, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
    verify(source).openBufferedStream();
  }

  /**
   * Test {@link Parser#parse(CharSource, Optional, Path)} with {@code source}, {@code basePath}, {@code sourcePath}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code //}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Parser#parse(CharSource, Optional, Path)}
   */
  @Test
  public void testParseWithSourceBasePathSourcePath_givenStringReaderWithSlashSlash()
      throws IOException, InvalidConfigurationException {
    // Arrange
    CharSource source = mock(CharSource.class);
    when(source.openBufferedStream()).thenReturn(new BufferedReader(new StringReader("//"), 1));
    Optional<Path> basePath = Optional.of(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act
    Parser actualParseResult = Parser.parse(source, basePath,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Assert
    verify(source).openBufferedStream();
    assertTrue(actualParseResult.getOptions().isEmpty());
    assertTrue(actualParseResult.getSources().isEmpty());
  }

  /**
   * Test {@link Parser#parse(CharSource, Optional, Path)} with {@code source}, {@code basePath}, {@code sourcePath}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Parser#parse(CharSource, Optional, Path)}
   */
  @Test
  public void testParseWithSourceBasePathSourcePath_thenThrowIOException()
      throws IOException, InvalidConfigurationException {
    // Arrange
    CharSource source = mock(CharSource.class);
    when(source.openBufferedStream()).thenThrow(new IOException("foo"));
    Optional<Path> basePath = Optional.of(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> Parser.parse(source, basePath, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
    verify(source).openBufferedStream();
  }
}
