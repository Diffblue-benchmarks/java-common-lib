package org.sosy_lab.common.log;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;
import org.junit.Test;

public class LogLevelFilterDiffblueTest {
  /**
   * Test {@link LogLevelFilter#LogLevelFilter(List)}.
   * <p>
   * Method under test: {@link LogLevelFilter#LogLevelFilter(List)}
   */
  @Test
  public void testNewLogLevelFilter() {
    // Arrange and Act
    LogLevelFilter actualLogLevelFilter = new LogLevelFilter(new ArrayList<>());
    ExtendedLogRecord pRecord = mock(ExtendedLogRecord.class);
    when(pRecord.getLevel()).thenReturn(null);
    boolean actualIsLoggableResult = actualLogLevelFilter.isLoggable(pRecord);

    // Assert
    verify(pRecord).getLevel();
    assertTrue(actualIsLoggableResult);
  }

  /**
   * Test {@link LogLevelFilter#isLoggable(LogRecord)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ExtendedLogRecord} {@link LogRecord#getLevel()} return {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogLevelFilter#isLoggable(LogRecord)}
   */
  @Test
  public void testIsLoggable_givenNull_whenExtendedLogRecordGetLevelReturnNull_thenReturnTrue() {
    // Arrange
    LogLevelFilter logLevelFilter = new LogLevelFilter(new ArrayList<>());
    ExtendedLogRecord pRecord = mock(ExtendedLogRecord.class);
    when(pRecord.getLevel()).thenReturn(null);

    // Act
    boolean actualIsLoggableResult = logLevelFilter.isLoggable(pRecord);

    // Assert
    verify(pRecord).getLevel();
    assertTrue(actualIsLoggableResult);
  }
}
