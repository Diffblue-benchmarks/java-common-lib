package org.sosy_lab.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mockStatic;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import javax.swing.text.Segment;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class JSONDiffblueTest {
  /**
   * Test {@link JSON#writeJSONString(Object, Path)} with {@code value}, {@code file}.
   * <ul>
   *   <li>Then throw {@link NotSerializableException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Path)}
   */
  @Test
  public void testWriteJSONStringWithValueFile_thenThrowNotSerializableException() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)))
          .thenThrow(new NotSerializableException("foo"));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

      // Act and Assert
      assertThrows(NotSerializableException.class,
          () -> JSON.writeJSONString("Value", Paths.get(System.getProperty("java.io.tmpdir"), "")));
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Path)} with {@code value}, {@code file}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then calls {@link Files#isDirectory(Path, LinkOption[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Path)}
   */
  @Test
  public void testWriteJSONStringWithValueFile_whenFortyTwo_thenCallsIsDirectory() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)))
          .thenReturn(new ByteArrayOutputStream(1));
      mockFiles.when(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.createDirectories(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

      // Act
      JSON.writeJSONString(42, Paths.get(System.getProperty("java.io.tmpdir"), ""));

      // Assert
      mockFiles.verify(() -> Files.isDirectory(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.newOutputStream(Mockito.<Path>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut() throws IOException {
    // Arrange
    Segment segment = new Segment("\u0001\"\u0001\"".toCharArray(), 1, 1);

    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(segment, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut2() throws IOException {
    // Arrange
    Segment segment = new Segment("\u0001\b\u0001\"".toCharArray(), 1, 1);

    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(segment, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut3() throws IOException {
    // Arrange
    Segment segment = new Segment("\u0001\t\u0001\"".toCharArray(), 1, 1);

    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(segment, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut4() throws IOException {
    // Arrange
    Segment segment = new Segment("\u0001\n\u0001\"".toCharArray(), 1, 1);

    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(segment, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut5() throws IOException {
    // Arrange
    Segment segment = new Segment("\u0001\f\u0001\"".toCharArray(), 1, 1);

    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(segment, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut6() throws IOException {
    // Arrange
    Segment segment = new Segment("\u0001\r\u0001\"".toCharArray(), 1, 1);

    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(segment, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut7() throws IOException {
    // Arrange
    Segment segment = new Segment("\u0001/\u0001\"".toCharArray(), 1, 1);

    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(segment, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut8() throws IOException {
    // Arrange
    Segment segment = new Segment("\u0001\\\u0001\"".toCharArray(), 1, 1);

    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(segment, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <ul>
   *   <li>Then {@link CharArrayWriter#CharArrayWriter(int)} with one size is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut_thenCharArrayWriterWithOneSizeIsEight() throws IOException {
    // Arrange
    Segment segment = new Segment("\u0001\u0001\u0001\"".toCharArray(), 1, 1);

    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(segment, out);

    // Assert
    assertEquals(8, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then {@link CharArrayWriter#CharArrayWriter(int)} with one size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut_whenFortyTwo_thenCharArrayWriterWithOneSizeIsTwo() throws IOException {
    // Arrange
    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(42, out);

    // Assert
    assertEquals(2, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <ul>
   *   <li>When {@link Double#NaN}.</li>
   *   <li>Then {@link CharArrayWriter#CharArrayWriter(int)} with one size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut_whenNaN_thenCharArrayWriterWithOneSizeIsFour() throws IOException {
    // Arrange
    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(Double.NaN, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <ul>
   *   <li>When {@link Float#NaN}.</li>
   *   <li>Then {@link CharArrayWriter#CharArrayWriter(int)} with one size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut_whenNaN_thenCharArrayWriterWithOneSizeIsFour2() throws IOException {
    // Arrange
    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(Float.NaN, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link CharArrayWriter#CharArrayWriter(int)} with one size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut_whenNull_thenCharArrayWriterWithOneSizeIsFour() throws IOException {
    // Arrange
    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(null, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then {@link CharArrayWriter#CharArrayWriter(int)} with one size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut_whenTen_thenCharArrayWriterWithOneSizeIsFour() throws IOException {
    // Arrange
    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(10.0d, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then {@link CharArrayWriter#CharArrayWriter(int)} with one size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut_whenTen_thenCharArrayWriterWithOneSizeIsFour2() throws IOException {
    // Arrange
    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString(10.0f, out);

    // Assert
    assertEquals(4, out.size());
  }

  /**
   * Test {@link JSON#writeJSONString(Object, Appendable)} with {@code value}, {@code out}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then {@link CharArrayWriter#CharArrayWriter(int)} with one size is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSON#writeJSONString(Object, Appendable)}
   */
  @Test
  public void testWriteJSONStringWithValueOut_whenValue_thenCharArrayWriterWithOneSizeIsSeven() throws IOException {
    // Arrange
    CharArrayWriter out = new CharArrayWriter(1);

    // Act
    JSON.writeJSONString("Value", out);

    // Assert
    assertEquals(7, out.size());
  }
}
