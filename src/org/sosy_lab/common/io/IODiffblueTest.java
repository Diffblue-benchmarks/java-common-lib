package org.sosy_lab.common.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.io.CharSource;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class IODiffblueTest {
  /**
   * Test {@link IO#toStringBuilder(CharSource)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return toString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IO#toStringBuilder(CharSource)}
   */
  @Test
  public void testToStringBuilder_givenOne_thenReturnToStringIsEmptyString() throws IOException {
    // Arrange
    CharSource source = mock(CharSource.class);
    when(source.copyTo(Mockito.<Appendable>any())).thenReturn(1L);

    // Act
    StringBuilder actualToStringBuilderResult = IO.toStringBuilder(source);

    // Assert
    verify(source).copyTo(isA(Appendable.class));
    assertEquals("", actualToStringBuilderResult.toString());
  }

  /**
   * Test {@link IO#toStringBuilder(CharSource)}.
   * <ul>
   *   <li>Then throw {@link FileNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IO#toStringBuilder(CharSource)}
   */
  @Test
  public void testToStringBuilder_thenThrowFileNotFoundException() throws IOException {
    // Arrange
    CharSource source = mock(CharSource.class);
    when(source.copyTo(Mockito.<Appendable>any())).thenThrow(new FileNotFoundException("foo"));

    // Act and Assert
    assertThrows(FileNotFoundException.class, () -> IO.toStringBuilder(source));
    verify(source).copyTo(isA(Appendable.class));
  }

  /**
   * Test {@link IO#toCharArray(CharSource)}.
   * <ul>
   *   <li>Given {@link FileNotFoundException#FileNotFoundException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link FileNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IO#toCharArray(CharSource)}
   */
  @Test
  public void testToCharArray_givenFileNotFoundExceptionWithFoo_thenThrowFileNotFoundException() throws IOException {
    // Arrange
    CharSource source = mock(CharSource.class);
    when(source.copyTo(Mockito.<Appendable>any())).thenThrow(new FileNotFoundException("foo"));

    // Act and Assert
    assertThrows(FileNotFoundException.class, () -> IO.toCharArray(source));
    verify(source).copyTo(isA(Appendable.class));
  }

  /**
   * Test {@link IO#toCharArray(CharSource)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return empty array of {@code char}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IO#toCharArray(CharSource)}
   */
  @Test
  public void testToCharArray_givenOne_thenReturnEmptyArrayOfChar() throws IOException {
    // Arrange
    CharSource source = mock(CharSource.class);
    when(source.copyTo(Mockito.<Appendable>any())).thenReturn(1L);

    // Act
    char[] actualToCharArrayResult = IO.toCharArray(source);

    // Assert
    verify(source).copyTo(isA(Appendable.class));
    assertArrayEquals(new char[]{}, actualToCharArrayResult);
  }

  /**
   * Test {@link IO#writeFile(Path, Charset, Object)}.
   * <ul>
   *   <li>Then throw {@link FileNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IO#writeFile(Path, Charset, Object)}
   */
  @Test
  public void testWriteFile_thenThrowFileNotFoundException() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)))
          .thenThrow(new FileNotFoundException("foo"));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Path file = Paths.get(System.getProperty("java.io.tmpdir"), "foo");

      // Act and Assert
      assertThrows(FileNotFoundException.class, () -> IO.writeFile(file, Charset.forName("UTF-8"), "Content"));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Test {@link IO#writeGZIPFile(Path, Charset, Object)}.
   * <ul>
   *   <li>Then throw {@link FileNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IO#writeGZIPFile(Path, Charset, Object)}
   */
  @Test
  public void testWriteGZIPFile_thenThrowFileNotFoundException() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)))
          .thenThrow(new FileNotFoundException("foo"));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Path file = Paths.get(System.getProperty("java.io.tmpdir"), "foo");

      // Act and Assert
      assertThrows(FileNotFoundException.class, () -> IO.writeGZIPFile(file, Charset.forName("UTF-8"), "Content"));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Test {@link IO#appendToFile(Path, Charset, Object)}.
   * <ul>
   *   <li>Given {@link Files} {@link Files#isDirectory(Path, LinkOption[])} return {@code true}.</li>
   *   <li>Then calls {@link Files#isDirectory(Path, LinkOption[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IO#appendToFile(Path, Charset, Object)}
   */
  @Test
  public void testAppendToFile_givenFilesIsDirectoryReturnTrue_thenCallsIsDirectory() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)))
          .thenReturn(new ByteArrayOutputStream(1));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Path file = Paths.get(System.getProperty("java.io.tmpdir"), "");

      // Act
      IO.appendToFile(file, Charset.forName("UTF-8"), "Content");

      // Assert
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Test {@link IO#checkReadableFile(Path)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IO#checkReadableFile(Path)}
   */
  @Test
  public void testCheckReadableFile_whenPropertyIsJavaIoTmpdirIsEmptyString() throws FileNotFoundException {
    // Arrange, Act and Assert
    assertThrows(FileNotFoundException.class,
        () -> IO.checkReadableFile(Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test {@link IO#checkReadableFile(Path)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IO#checkReadableFile(Path)}
   */
  @Test
  public void testCheckReadableFile_whenPropertyIsJavaIoTmpdirIsTestTxt() throws FileNotFoundException {
    // Arrange, Act and Assert
    assertThrows(FileNotFoundException.class,
        () -> IO.checkReadableFile(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }
}
