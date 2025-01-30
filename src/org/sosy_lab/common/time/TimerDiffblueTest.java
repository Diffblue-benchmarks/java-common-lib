package org.sosy_lab.common.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.collect.ImmutableList;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.sosy_lab.common.time.Tickers.TickerWithUnit;

public class TimerDiffblueTest {
  /**
   * Test {@link Timer#Timer()}.
   * <p>
   * Method under test: {@link Timer#Timer()}
   */
  @Test
  public void testNewTimer() {
    // Arrange and Act
    Timer actualTimer = new Timer();

    // Assert
    assertEquals(0, actualTimer.getNumberOfIntervals());
    assertEquals(0L, actualTimer.minTime());
    assertFalse(actualTimer.isRunning());
  }

  /**
   * Test {@link Timer#Timer(TickerWithUnit)}.
   * <ul>
   *   <li>When {@link TickerWithUnit}.</li>
   *   <li>Then return NumberOfIntervals is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#Timer(TickerWithUnit)}
   */
  @Test
  public void testNewTimer_whenTickerWithUnit_thenReturnNumberOfIntervalsIsZero() {
    // Arrange and Act
    Timer actualTimer = new Timer(mock(TickerWithUnit.class));

    // Assert
    assertEquals(0, actualTimer.getNumberOfIntervals());
    assertEquals(0L, actualTimer.minTime());
    assertFalse(actualTimer.isRunning());
  }

  /**
   * Test {@link Timer#start(long)} with {@code long}.
   * <p>
   * Method under test: {@link Timer#start(long)}
   */
  @Test
  public void testStartWithLong() {
    // Arrange
    Timer timer = new Timer();

    // Act
    timer.start(1L);

    // Assert
    assertEquals(1, timer.getNumberOfIntervals());
    assertFalse(timer.getAvgTime().isEmpty());
    assertFalse(timer.getLengthOfLastInterval().isEmpty());
    assertFalse(timer.getSumTime().isEmpty());
    assertTrue(timer.isRunning());
  }

  /**
   * Test {@link Timer#start()}.
   * <ul>
   *   <li>Given {@link Timer#Timer()}.</li>
   *   <li>Then {@link Timer#Timer()} NumberOfIntervals is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#start()}
   */
  @Test
  public void testStart_givenTimer_thenTimerNumberOfIntervalsIsOne() {
    // Arrange
    Timer timer = new Timer();

    // Act
    timer.start();

    // Assert
    assertEquals(1, timer.getNumberOfIntervals());
    assertTrue(timer.isRunning());
  }

  /**
   * Test {@link Timer#start()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#start()}
   */
  @Test
  public void testStart_thenThrowIllegalArgumentException() {
    // Arrange
    TickerWithUnit pClock = mock(TickerWithUnit.class);
    when(pClock.read()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Timer(pClock)).start());
    verify(pClock).read();
  }

  /**
   * Test {@link Timer#stop()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#stop()}
   */
  @Test
  public void testStop_thenThrowIllegalArgumentException() {
    // Arrange
    TickerWithUnit pClock = mock(TickerWithUnit.class);
    when(pClock.read()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Timer(pClock)).stop());
    verify(pClock).read();
  }

  /**
   * Test {@link Timer#export(long)}.
   * <ul>
   *   <li>Given {@link Timer#Timer()}.</li>
   *   <li>Then return Units size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#export(long)}
   */
  @Test
  public void testExport_givenTimer_thenReturnUnitsSizeIsOne() {
    // Arrange and Act
    TimeSpan actualExportResult = (new Timer()).export(10L);

    // Assert
    ImmutableList<TemporalUnit> units = actualExportResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualExportResult.getUnit());
    assertFalse(actualExportResult.isEmpty());
  }

  /**
   * Test {@link Timer#export(long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#export(long)}
   */
  @Test
  public void testExport_thenThrowIllegalArgumentException() {
    // Arrange
    TickerWithUnit pClock = mock(TickerWithUnit.class);
    when(pClock.unit()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Timer(pClock)).export(10L));
    verify(pClock).unit();
  }

  /**
   * Test {@link Timer#currentInterval()}.
   * <p>
   * Method under test: {@link Timer#currentInterval()}
   */
  @Test
  public void testCurrentInterval() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Timer()).currentInterval());
  }

  /**
   * Test {@link Timer#getSumTime()}.
   * <ul>
   *   <li>Given {@link Timer#Timer()}.</li>
   *   <li>Then return Units size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#getSumTime()}
   */
  @Test
  public void testGetSumTime_givenTimer_thenReturnUnitsSizeIsOne() {
    // Arrange and Act
    TimeSpan actualSumTime = (new Timer()).getSumTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualSumTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualSumTime.getUnit());
    assertTrue(actualSumTime.isEmpty());
  }

  /**
   * Test {@link Timer#getSumTime()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#getSumTime()}
   */
  @Test
  public void testGetSumTime_thenThrowIllegalArgumentException() {
    // Arrange
    TickerWithUnit pClock = mock(TickerWithUnit.class);
    when(pClock.unit()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Timer(pClock)).getSumTime());
    verify(pClock).unit();
  }

  /**
   * Test {@link Timer#sumTime()}.
   * <p>
   * Method under test: {@link Timer#sumTime()}
   */
  @Test
  public void testSumTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Timer()).sumTime());
  }

  /**
   * Test {@link Timer#getMaxTime()}.
   * <ul>
   *   <li>Given {@link Timer#Timer()}.</li>
   *   <li>Then return Units size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#getMaxTime()}
   */
  @Test
  public void testGetMaxTime_givenTimer_thenReturnUnitsSizeIsOne() {
    // Arrange and Act
    TimeSpan actualMaxTime = (new Timer()).getMaxTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualMaxTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualMaxTime.getUnit());
    assertTrue(actualMaxTime.isEmpty());
  }

  /**
   * Test {@link Timer#getMaxTime()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#getMaxTime()}
   */
  @Test
  public void testGetMaxTime_thenThrowIllegalArgumentException() {
    // Arrange
    TickerWithUnit pClock = mock(TickerWithUnit.class);
    when(pClock.unit()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Timer(pClock)).getMaxTime());
    verify(pClock).unit();
  }

  /**
   * Test {@link Timer#getMinTime()}.
   * <ul>
   *   <li>Given {@link Timer#Timer()}.</li>
   *   <li>Then return Units size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#getMinTime()}
   */
  @Test
  public void testGetMinTime_givenTimer_thenReturnUnitsSizeIsOne() {
    // Arrange and Act
    TimeSpan actualMinTime = (new Timer()).getMinTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualMinTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualMinTime.getUnit());
    assertTrue(actualMinTime.isEmpty());
  }

  /**
   * Test {@link Timer#getMinTime()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#getMinTime()}
   */
  @Test
  public void testGetMinTime_thenThrowIllegalArgumentException() {
    // Arrange
    TickerWithUnit pClock = mock(TickerWithUnit.class);
    when(pClock.unit()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Timer(pClock)).getMinTime());
    verify(pClock).unit();
  }

  /**
   * Test {@link Timer#maxTime()}.
   * <p>
   * Method under test: {@link Timer#maxTime()}
   */
  @Test
  public void testMaxTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Timer()).maxTime());
  }

  /**
   * Test {@link Timer#minTime()}.
   * <p>
   * Method under test: {@link Timer#minTime()}
   */
  @Test
  public void testMinTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Timer()).minTime());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Timer#toString()}
   *   <li>{@link Timer#getNumberOfIntervals()}
   *   <li>{@link Timer#isRunning()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Timer timer = new Timer();

    // Act
    String actualToStringResult = timer.toString();
    int actualNumberOfIntervals = timer.getNumberOfIntervals();

    // Assert
    assertEquals("    0.000s", actualToStringResult);
    assertEquals(0, actualNumberOfIntervals);
    assertFalse(timer.isRunning());
  }

  /**
   * Test {@link Timer#getLengthOfLastInterval()}.
   * <ul>
   *   <li>Given {@link Timer#Timer()}.</li>
   *   <li>Then return Units size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#getLengthOfLastInterval()}
   */
  @Test
  public void testGetLengthOfLastInterval_givenTimer_thenReturnUnitsSizeIsOne() {
    // Arrange and Act
    TimeSpan actualLengthOfLastInterval = (new Timer()).getLengthOfLastInterval();

    // Assert
    ImmutableList<TemporalUnit> units = actualLengthOfLastInterval.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualLengthOfLastInterval.getUnit());
    assertTrue(actualLengthOfLastInterval.isEmpty());
  }

  /**
   * Test {@link Timer#getLengthOfLastInterval()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#getLengthOfLastInterval()}
   */
  @Test
  public void testGetLengthOfLastInterval_thenThrowIllegalArgumentException() {
    // Arrange
    TickerWithUnit pClock = mock(TickerWithUnit.class);
    when(pClock.unit()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Timer(pClock)).getLengthOfLastInterval());
    verify(pClock).unit();
  }

  /**
   * Test {@link Timer#lengthOfLastInterval()}.
   * <p>
   * Method under test: {@link Timer#lengthOfLastInterval()}
   */
  @Test
  public void testLengthOfLastInterval() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Timer()).lengthOfLastInterval());
  }

  /**
   * Test {@link Timer#getAvgTime()}.
   * <ul>
   *   <li>Given {@link Timer#Timer()}.</li>
   *   <li>Then return Units size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#getAvgTime()}
   */
  @Test
  public void testGetAvgTime_givenTimer_thenReturnUnitsSizeIsOne() {
    // Arrange and Act
    TimeSpan actualAvgTime = (new Timer()).getAvgTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualAvgTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualAvgTime.getUnit());
    assertTrue(actualAvgTime.isEmpty());
  }

  /**
   * Test {@link Timer#getAvgTime()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#getAvgTime()}
   */
  @Test
  public void testGetAvgTime_thenThrowIllegalArgumentException() {
    // Arrange
    TickerWithUnit pClock = mock(TickerWithUnit.class);
    when(pClock.unit()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Timer(pClock)).getAvgTime());
    verify(pClock).unit();
  }

  /**
   * Test {@link Timer#prettyFormat()}.
   * <ul>
   *   <li>Given {@link TickerWithUnit} {@link TickerWithUnit#unit()} return {@code MINUTES}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#prettyFormat()}
   */
  @Test
  public void testPrettyFormat_givenTickerWithUnitUnitReturnMinutes() {
    // Arrange
    TickerWithUnit pClock = mock(TickerWithUnit.class);
    when(pClock.unit()).thenReturn(TimeUnit.MINUTES);

    // Act
    String actualPrettyFormatResult = (new Timer(pClock)).prettyFormat();

    // Assert
    verify(pClock, atLeast(1)).unit();
    assertEquals("0s (Max: 0s), (Avg: 0s), (#intervals = 0)", actualPrettyFormatResult);
  }

  /**
   * Test {@link Timer#prettyFormat()}.
   * <ul>
   *   <li>Given {@link TickerWithUnit} {@link TickerWithUnit#unit()} return {@code SECONDS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#prettyFormat()}
   */
  @Test
  public void testPrettyFormat_givenTickerWithUnitUnitReturnSeconds() {
    // Arrange
    TickerWithUnit pClock = mock(TickerWithUnit.class);
    when(pClock.unit()).thenReturn(TimeUnit.SECONDS);

    // Act
    String actualPrettyFormatResult = (new Timer(pClock)).prettyFormat();

    // Assert
    verify(pClock, atLeast(1)).unit();
    assertEquals("0s (Max: 0s), (Avg: 0s), (#intervals = 0)", actualPrettyFormatResult);
  }

  /**
   * Test {@link Timer#prettyFormat()}.
   * <ul>
   *   <li>Given {@link Timer#Timer()}.</li>
   *   <li>Then return {@code 0.000s (Max: 0.000s), (Avg: 0.000s), (#intervals = 0)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#prettyFormat()}
   */
  @Test
  public void testPrettyFormat_givenTimer_thenReturn0000sMax0000sAvg0000sIntervals0() {
    // Arrange, Act and Assert
    assertEquals("    0.000s (Max:     0.000s), (Avg:     0.000s), (#intervals = 0)", (new Timer()).prettyFormat());
  }

  /**
   * Test {@link Timer#prettyFormat()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Timer#prettyFormat()}
   */
  @Test
  public void testPrettyFormat_thenThrowIllegalArgumentException() {
    // Arrange
    TickerWithUnit pClock = mock(TickerWithUnit.class);
    when(pClock.unit()).thenThrow(new IllegalArgumentException("%s (Max: %s), (Avg: %s), (#intervals = %s)"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Timer(pClock)).prettyFormat());
    verify(pClock).unit();
  }
}
