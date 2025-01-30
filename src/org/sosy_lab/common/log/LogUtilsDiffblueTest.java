package org.sosy_lab.common.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.logging.LogRecord;
import org.junit.Test;

public class LogUtilsDiffblueTest {
  /**
   * Test {@link LogUtils#extractSimpleClassName(LogRecord)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogUtils#extractSimpleClassName(LogRecord)}
   */
  @Test
  public void testExtractSimpleClassName_givenNull_thenReturnNull() {
    // Arrange
    ExtendedLogRecord lr = mock(ExtendedLogRecord.class);
    when(lr.getSourceClassName()).thenReturn(null);

    // Act
    String actualExtractSimpleClassNameResult = LogUtils.extractSimpleClassName(lr);

    // Assert
    verify(lr).getSourceClassName();
    assertNull(actualExtractSimpleClassNameResult);
  }

  /**
   * Test {@link LogUtils#extractSimpleClassName(LogRecord)}.
   * <ul>
   *   <li>Given {@code Source Class Name}.</li>
   *   <li>Then return {@code Source Class Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogUtils#extractSimpleClassName(LogRecord)}
   */
  @Test
  public void testExtractSimpleClassName_givenSourceClassName_thenReturnSourceClassName() {
    // Arrange
    ExtendedLogRecord lr = mock(ExtendedLogRecord.class);
    when(lr.getSourceClassName()).thenReturn("Source Class Name");

    // Act
    String actualExtractSimpleClassNameResult = LogUtils.extractSimpleClassName(lr);

    // Assert
    verify(lr).getSourceClassName();
    assertEquals("Source Class Name", actualExtractSimpleClassNameResult);
  }
}
