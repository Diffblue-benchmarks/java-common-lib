package org.sosy_lab.common.io;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mockStatic;
import com.google.common.io.FileWriteMode;
import java.io.ByteArrayOutputStream;
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
import org.sosy_lab.common.io.MoreFiles.DeleteOnCloseFile;

public class MoreFilesDiffblueTest {
  /**
   * Test DeleteOnCloseFile {@link DeleteOnCloseFile#close()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteOnCloseFile#close()}
   */
  @Test
  public void testDeleteOnCloseFileClose_thenThrowIOException() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.deleteIfExists(Mockito.<Path>any())).thenThrow(new IOException("foo"));

      // Act and Assert
      assertThrows(IOException.class,
          () -> (new DeleteOnCloseFile(Paths.get(System.getProperty("java.io.tmpdir"), "foo"))).close());
      mockFiles.verify(() -> Files.deleteIfExists(Mockito.<Path>any()));
    }
  }

  /**
   * Test DeleteOnCloseFile getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeleteOnCloseFile#DeleteOnCloseFile(Path)}
   *   <li>{@link DeleteOnCloseFile#toPath()}
   * </ul>
   */
  @Test
  public void testDeleteOnCloseFileGettersAndSetters() {
    // Arrange
    Path pFile = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act and Assert
    assertSame(pFile, (new DeleteOnCloseFile(pFile)).toPath());
  }

  /**
   * Test {@link MoreFiles#writeFile(Path, Charset, Object)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoreFiles#writeFile(Path, Charset, Object)}
   */
  @Test
  public void testWriteFile_thenThrowIOException() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)))
          .thenThrow(new IOException("foo"));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Path file = Paths.get(System.getProperty("java.io.tmpdir"), "foo");

      // Act and Assert
      assertThrows(IOException.class, () -> MoreFiles.writeFile(file, Charset.forName("UTF-8"), "Content"));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Test {@link MoreFiles#writeGZIPFile(Path, Charset, Object)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoreFiles#writeGZIPFile(Path, Charset, Object)}
   */
  @Test
  public void testWriteGZIPFile_thenThrowIOException() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)))
          .thenThrow(new IOException("foo"));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Path file = Paths.get(System.getProperty("java.io.tmpdir"), "foo");

      // Act and Assert
      assertThrows(IOException.class, () -> MoreFiles.writeGZIPFile(file, Charset.forName("UTF-8"), "Content"));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Test {@link MoreFiles#openOutputFile(Path, Charset, FileWriteMode[])}.
   * <ul>
   *   <li>Given {@link Files} {@link Files#isDirectory(Path, LinkOption[])} return {@code true}.</li>
   *   <li>Then calls {@link Files#isDirectory(Path, LinkOption[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoreFiles#openOutputFile(Path, Charset, FileWriteMode[])}
   */
  @Test
  public void testOpenOutputFile_givenFilesIsDirectoryReturnTrue_thenCallsIsDirectory() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)))
          .thenReturn(new ByteArrayOutputStream(1));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Path file = Paths.get(System.getProperty("java.io.tmpdir"), "foo");

      // Act
      MoreFiles.openOutputFile(file, Charset.forName("UTF-8"), FileWriteMode.APPEND);

      // Assert
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Test {@link MoreFiles#openOutputFile(Path, Charset, FileWriteMode[])}.
   * <ul>
   *   <li>Given {@link Files} {@link Files#isDirectory(Path, LinkOption[])} return {@code true}.</li>
   *   <li>Then calls {@link Files#isDirectory(Path, LinkOption[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoreFiles#openOutputFile(Path, Charset, FileWriteMode[])}
   */
  @Test
  public void testOpenOutputFile_givenFilesIsDirectoryReturnTrue_thenCallsIsDirectory2() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)))
          .thenReturn(new ByteArrayOutputStream(1));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      Path file = Paths.get(System.getProperty("java.io.tmpdir"), "foo");

      // Act
      MoreFiles.openOutputFile(file, Charset.forName("UTF-8"));

      // Assert
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Test {@link MoreFiles#appendToFile(Path, Charset, Object)}.
   * <ul>
   *   <li>Given {@link Files} {@link Files#isDirectory(Path, LinkOption[])} return {@code true}.</li>
   *   <li>Then calls {@link Files#isDirectory(Path, LinkOption[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MoreFiles#appendToFile(Path, Charset, Object)}
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
      Path file = Paths.get(System.getProperty("java.io.tmpdir"), "foo");

      // Act
      MoreFiles.appendToFile(file, Charset.forName("UTF-8"), "Content");

      // Assert
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)));
    }
  }
}
