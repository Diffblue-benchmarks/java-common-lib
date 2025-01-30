package org.sosy_lab.common.log;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.logging.LogRecord;
import org.junit.Test;

public class AbstractColoredLogFormatterDiffblueTest {
  /**
   * Test {@link AbstractColoredLogFormatter#format(LogRecord)} with {@code LogRecord}.
   * <ul>
   *   <li>Given {@code Not all who wander are lost}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractColoredLogFormatter#format(LogRecord)}
   */
  @Test
  public void testFormatWithLogRecord_givenNotAllWhoWanderAreLost_thenReturnAString() {
    // Arrange
    FileLogFormatter fileLogFormatter = new FileLogFormatter();
    ExtendedLogRecord lr = mock(ExtendedLogRecord.class);
    when(lr.getMessage()).thenReturn("Not all who wander are lost");
    when(lr.getSourceClassName()).thenReturn("Source Class Name");
    when(lr.getSourceMethodName()).thenReturn("Source Method Name");
    when(lr.getSourceComponentName()).thenReturn("Source Component Name");
    when(lr.getLevel()).thenReturn(null);
    when(lr.getInstant()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    String actualFormatResult = fileLogFormatter.format(lr);

    // Assert
    verify(lr).getInstant();
    verify(lr).getLevel();
    verify(lr).getMessage();
    verify(lr).getSourceClassName();
    verify(lr).getSourceMethodName();
    verify(lr).getSourceComponentName();
    assertEquals(
        "1970-01-01 00:00:00:000\tnull\tSource Component Name:Source Class Name.Source Method Name\tNot all who"
            + " wander are lost\n" + "\n",
        actualFormatResult);
  }

  /**
   * Test {@link AbstractColoredLogFormatter#toString()}.
   * <p>
   * Method under test: {@link AbstractColoredLogFormatter#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("FileLogFormatter{useColors=false}", (new FileLogFormatter()).toString());
  }
}
