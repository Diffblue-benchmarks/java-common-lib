package org.sosy_lab.common.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.logging.LogRecord;
import org.junit.Test;
import org.mockito.Mockito;

public class TimestampedLogFormatterDiffblueTest {
  /**
   * Test {@link TimestampedLogFormatter#format(LogRecord, StringBuilder)} with {@code lr}, {@code sb}.
   * <p>
   * Method under test: {@link TimestampedLogFormatter#format(LogRecord, StringBuilder)}
   */
  @Test
  public void testFormatWithLrSb() {
    // Arrange
    TimestampedLogFormatter timestampedLogFormatter = new TimestampedLogFormatter(true);
    ExtendedLogRecord lr = mock(ExtendedLogRecord.class);
    when(lr.getMessage()).thenReturn("Not all who wander are lost");
    when(lr.getSourceClassName()).thenReturn("Source Class Name");
    when(lr.getSourceMethodName()).thenReturn("Source Method Name");
    when(lr.getSourceComponentName()).thenReturn("");
    when(lr.getLevel()).thenReturn(null);
    when(lr.getInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    doNothing().when(lr).setSourceComponentName(Mockito.<String>any());
    lr.setSourceComponentName("");
    StringBuilder sb = new StringBuilder("foo");

    // Act
    timestampedLogFormatter.format(lr, sb);

    // Assert
    verify(lr).getInstant();
    verify(lr).getLevel();
    verify(lr).getMessage();
    verify(lr).getSourceClassName();
    verify(lr).getSourceMethodName();
    verify(lr).getSourceComponentName();
    verify(lr).setSourceComponentName(eq(""));
    assertEquals(
        "foo1970-01-01 00:00:00:000\tnull\tSource Class Name.Source Method Name\tNot all who wander are lost\n\n",
        sb.toString());
  }

  /**
   * Test {@link TimestampedLogFormatter#format(LogRecord, StringBuilder)} with {@code lr}, {@code sb}.
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimestampedLogFormatter#format(LogRecord, StringBuilder)}
   */
  @Test
  public void testFormatWithLrSb_thenStringBuilderWithFooToStringIsAString() {
    // Arrange
    TimestampedLogFormatter timestampedLogFormatter = new TimestampedLogFormatter(true);
    ExtendedLogRecord lr = mock(ExtendedLogRecord.class);
    when(lr.getMessage()).thenReturn("Not all who wander are lost");
    when(lr.getSourceClassName()).thenReturn("Source Class Name");
    when(lr.getSourceMethodName()).thenReturn("Source Method Name");
    when(lr.getSourceComponentName()).thenReturn("Source Component Name");
    when(lr.getLevel()).thenReturn(null);
    when(lr.getInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    doNothing().when(lr).setSourceComponentName(Mockito.<String>any());
    lr.setSourceComponentName("");
    StringBuilder sb = new StringBuilder("foo");

    // Act
    timestampedLogFormatter.format(lr, sb);

    // Assert
    verify(lr).getInstant();
    verify(lr).getLevel();
    verify(lr).getMessage();
    verify(lr).getSourceClassName();
    verify(lr).getSourceMethodName();
    verify(lr).getSourceComponentName();
    verify(lr).setSourceComponentName(eq(""));
    assertEquals(
        "foo1970-01-01 00:00:00:000\tnull\tSource Component Name:Source Class Name.Source Method Name\tNot all who"
            + " wander are lost\n" + "\n",
        sb.toString());
  }

  /**
   * Test {@link TimestampedLogFormatter#withoutColors()}.
   * <p>
   * Method under test: {@link TimestampedLogFormatter#withoutColors()}
   */
  @Test
  public void testWithoutColors() {
    // Arrange, Act and Assert
    assertTrue(TimestampedLogFormatter.withoutColors() instanceof TimestampedLogFormatter);
  }

  /**
   * Test {@link TimestampedLogFormatter#withColorsIfPossible()}.
   * <p>
   * Method under test: {@link TimestampedLogFormatter#withColorsIfPossible()}
   */
  @Test
  public void testWithColorsIfPossible() {
    // Arrange, Act and Assert
    assertTrue(TimestampedLogFormatter.withColorsIfPossible() instanceof TimestampedLogFormatter);
  }
}
