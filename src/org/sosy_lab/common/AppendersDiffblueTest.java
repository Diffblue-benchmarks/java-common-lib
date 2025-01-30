package org.sosy_lab.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.base.Joiner;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import org.mockito.Mockito;

public class AppendersDiffblueTest {
  /**
   * Test {@link Appenders#createAppender(Object)}.
   * <ul>
   *   <li>Then {@link CharArrayWriter#CharArrayWriter(int)} with one size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Appenders#createAppender(Object)}
   */
  @Test
  public void testCreateAppender_thenCharArrayWriterWithOneSizeIsTwo() throws IOException {
    // Arrange and Act
    Appender actualCreateAppenderResult = Appenders.createAppender("42");
    CharArrayWriter charArrayWriter = new CharArrayWriter(1);
    actualCreateAppenderResult.appendTo(charArrayWriter);

    // Assert
    assertEquals(2, charArrayWriter.size());
  }

  /**
   * Test {@link Appenders#appendTo(Appendable, Object)} with {@code output}, {@code o}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Appenders#appendTo(Appendable, Object)}
   */
  @Test
  public void testAppendToWithOutputO_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    CharArrayWriter output = new CharArrayWriter(1);
    Appender appender = mock(Appender.class);
    doThrow(new IOException("foo")).when(appender).appendTo(Mockito.<Appendable>any());

    // Act and Assert
    assertThrows(IOException.class, () -> Appenders.appendTo(output, appender));
    verify(appender).appendTo(isA(Appendable.class));
  }

  /**
   * Test {@link Appenders#appendTo(Appendable, Object)} with {@code output}, {@code o}.
   * <ul>
   *   <li>Then {@link CharArrayWriter#CharArrayWriter(int)} with one size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Appenders#appendTo(Appendable, Object)}
   */
  @Test
  public void testAppendToWithOutputO_thenCharArrayWriterWithOneSizeIsZero() throws IOException {
    // Arrange
    CharArrayWriter output = new CharArrayWriter(1);
    Appender appender = mock(Appender.class);
    doNothing().when(appender).appendTo(Mockito.<Appendable>any());

    // Act
    Appenders.appendTo(output, appender);

    // Assert that nothing has changed
    verify(appender).appendTo(isA(Appendable.class));
    assertEquals(0, output.size());
  }

  /**
   * Test {@link Appenders#appendTo(Appendable, Object)} with {@code output}, {@code o}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link CharArrayWriter#CharArrayWriter(int)} with one size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Appenders#appendTo(Appendable, Object)}
   */
  @Test
  public void testAppendToWithOutputO_when42_thenCharArrayWriterWithOneSizeIsTwo() throws IOException {
    // Arrange
    CharArrayWriter output = new CharArrayWriter(1);

    // Act
    Appenders.appendTo(output, "42");

    // Assert
    assertEquals(2, output.size());
  }

  /**
   * Test {@link Appenders#appendTo(StringBuilder, Appender)} with {@code sb}, {@code a}.
   * <ul>
   *   <li>When {@link StringBuilder#StringBuilder(String)} with {@code foo}.</li>
   *   <li>Then return toString is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Appenders#appendTo(StringBuilder, Appender)}
   */
  @Test
  public void testAppendToWithSbA_whenStringBuilderWithFoo_thenReturnToStringIsFoo() throws IOException {
    // Arrange
    StringBuilder sb = new StringBuilder("foo");
    Appender a = mock(Appender.class);
    doNothing().when(a).appendTo(Mockito.<Appendable>any());

    // Act
    StringBuilder actualAppendToResult = Appenders.appendTo(sb, a);

    // Assert
    verify(a).appendTo(isA(Appendable.class));
    assertEquals("foo", actualAppendToResult.toString());
  }

  /**
   * Test {@link Appenders#forIterable(Joiner, Iterable)}.
   * <ul>
   *   <li>Given {@link CharArrayWriter#CharArrayWriter(int)} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Appenders#forIterable(Joiner, Iterable)}
   */
  @Test
  public void testForIterable_givenCharArrayWriterWithOne() throws IOException {
    // Arrange
    Joiner joiner = mock(Joiner.class);
    when(joiner.appendTo(Mockito.<Appendable>any(), Mockito.<Iterable<Object>>any()))
        .thenReturn(new CharArrayWriter(1));

    // Act
    Appender actualForIterableResult = Appenders.forIterable(joiner, new ArrayList<>());
    actualForIterableResult.appendTo(new CharArrayWriter(1));

    // Assert
    verify(joiner).appendTo(isA(Appendable.class), isA(Iterable.class));
  }

  /**
   * Test {@link Appenders#forIterable(Joiner, Iterable)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Appenders#forIterable(Joiner, Iterable)}
   */
  @Test
  public void testForIterable_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    Joiner joiner = mock(Joiner.class);
    when(joiner.appendTo(Mockito.<Appendable>any(), Mockito.<Iterable<Object>>any())).thenThrow(new IOException("foo"));

    // Act
    Appender actualForIterableResult = Appenders.forIterable(joiner, new ArrayList<>());

    // Assert
    assertThrows(IOException.class, () -> actualForIterableResult.appendTo(new CharArrayWriter(1)));
    verify(joiner).appendTo(isA(Appendable.class), isA(Iterable.class));
  }

  /**
   * Test {@link Appenders#fromToStringMethod(Object)}.
   * <ul>
   *   <li>Then {@link CharArrayWriter#CharArrayWriter(int)} with one size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Appenders#fromToStringMethod(Object)}
   */
  @Test
  public void testFromToStringMethod_thenCharArrayWriterWithOneSizeIsTwo() throws IOException {
    // Arrange and Act
    Appender actualFromToStringMethodResult = Appenders.fromToStringMethod("42");
    CharArrayWriter charArrayWriter = new CharArrayWriter(1);
    actualFromToStringMethodResult.appendTo(charArrayWriter);

    // Assert
    assertEquals(2, charArrayWriter.size());
  }

  /**
   * Test {@link Appenders#concat(Appender[])} with {@code Appender[]}.
   * <ul>
   *   <li>When {@link Appender} {@link Appender#appendTo(Appendable)} does nothing.</li>
   *   <li>Then calls {@link Appender#appendTo(Appendable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Appenders#concat(Appender[])}
   */
  @Test
  public void testConcatWithAppender_whenAppenderAppendToDoesNothing_thenCallsAppendTo() throws IOException {
    // Arrange
    Appender appender = mock(Appender.class);
    doNothing().when(appender).appendTo(Mockito.<Appendable>any());

    // Act
    Appender actualConcatResult = Appenders.concat(appender);
    actualConcatResult.appendTo(new CharArrayWriter(1));

    // Assert
    verify(appender).appendTo(isA(Appendable.class));
  }

  /**
   * Test {@link Appenders#concat(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Given {@link Appender} {@link Appender#appendTo(Appendable)} does nothing.</li>
   *   <li>Then calls {@link Appender#appendTo(Appendable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Appenders#concat(Iterable)}
   */
  @Test
  public void testConcatWithIterable_givenAppenderAppendToDoesNothing_thenCallsAppendTo() throws IOException {
    // Arrange
    Appender appender = mock(Appender.class);
    doNothing().when(appender).appendTo(Mockito.<Appendable>any());

    ArrayList<Appender> pAppenders = new ArrayList<>();
    pAppenders.add(appender);

    // Act
    Appender actualConcatResult = Appenders.concat(pAppenders);
    actualConcatResult.appendTo(new CharArrayWriter(1));

    // Assert
    verify(appender).appendTo(isA(Appendable.class));
  }

  /**
   * Test {@link Appenders#toString(Appender)} with {@code Appender}.
   * <p>
   * Method under test: {@link Appenders#toString(Appender)}
   */
  @Test
  public void testToStringWithAppender() throws IOException {
    // Arrange
    Appender a = mock(Appender.class);
    doNothing().when(a).appendTo(Mockito.<Appendable>any());

    // Act
    String actualToStringResult = Appenders.toString(a);

    // Assert
    verify(a).appendTo(isA(Appendable.class));
    assertEquals("", actualToStringResult);
  }

  /**
   * Test {@link Appenders#toStringWithTruncation(Appender, int)}.
   * <ul>
   *   <li>When {@link Appender} {@link Appender#appendTo(Appendable)} does nothing.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Appenders#toStringWithTruncation(Appender, int)}
   */
  @Test
  public void testToStringWithTruncation_whenAppenderAppendToDoesNothing_thenReturnEmptyString() throws IOException {
    // Arrange
    Appender a = mock(Appender.class);
    doNothing().when(a).appendTo(Mockito.<Appendable>any());

    // Act
    String actualToStringWithTruncationResult = Appenders.toStringWithTruncation(a, 1);

    // Assert
    verify(a).appendTo(isA(Appendable.class));
    assertEquals("", actualToStringWithTruncationResult);
  }
}
