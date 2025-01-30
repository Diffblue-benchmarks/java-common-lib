package org.sosy_lab.common.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.google.common.collect.ImmutableList;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class NestedTimerDiffblueTest {
  /**
   * Test {@link NestedTimer#startOuter()}.
   * <p>
   * Method under test: {@link NestedTimer#startOuter()}
   */
  @Test
  public void testStartOuter() {
    // Arrange
    NestedTimer nestedTimer = new NestedTimer();

    // Act
    nestedTimer.startOuter();

    // Assert
    Timer curentInnerTimer = nestedTimer.getCurentInnerTimer();
    assertEquals(0, curentInnerTimer.getNumberOfIntervals());
    assertEquals(0L, curentInnerTimer.minTime());
    assertEquals(1, nestedTimer.getNumberOfIntervals());
    assertFalse(curentInnerTimer.isRunning());
    assertTrue(nestedTimer.isOnlyOuterRunning());
    assertTrue(nestedTimer.isRunning());
  }

  /**
   * Test {@link NestedTimer#startBoth()}.
   * <p>
   * Method under test: {@link NestedTimer#startBoth()}
   */
  @Test
  public void testStartBoth() {
    // Arrange
    NestedTimer nestedTimer = new NestedTimer();

    // Act
    nestedTimer.startBoth();

    // Assert
    Timer curentInnerTimer = nestedTimer.getCurentInnerTimer();
    assertEquals(0L, curentInnerTimer.minTime());
    assertEquals(1, nestedTimer.getNumberOfIntervals());
    assertEquals(1, curentInnerTimer.getNumberOfIntervals());
    assertTrue(nestedTimer.isRunning());
    assertTrue(curentInnerTimer.isRunning());
  }

  /**
   * Test {@link NestedTimer#isRunning()}.
   * <p>
   * Method under test: {@link NestedTimer#isRunning()}
   */
  @Test
  public void testIsRunning() {
    // Arrange, Act and Assert
    assertFalse((new NestedTimer()).isRunning());
  }

  /**
   * Test {@link NestedTimer#isOnlyOuterRunning()}.
   * <p>
   * Method under test: {@link NestedTimer#isOnlyOuterRunning()}
   */
  @Test
  public void testIsOnlyOuterRunning() {
    // Arrange, Act and Assert
    assertFalse((new NestedTimer()).isOnlyOuterRunning());
  }

  /**
   * Test {@link NestedTimer#getOuterSumTime()}.
   * <p>
   * Method under test: {@link NestedTimer#getOuterSumTime()}
   */
  @Test
  public void testGetOuterSumTime() {
    // Arrange and Act
    TimeSpan actualOuterSumTime = (new NestedTimer()).getOuterSumTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualOuterSumTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualOuterSumTime.getUnit());
    assertTrue(actualOuterSumTime.isEmpty());
  }

  /**
   * Test {@link NestedTimer#getInnerSumTime()}.
   * <p>
   * Method under test: {@link NestedTimer#getInnerSumTime()}
   */
  @Test
  public void testGetInnerSumTime() {
    // Arrange and Act
    TimeSpan actualInnerSumTime = (new NestedTimer()).getInnerSumTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualInnerSumTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualInnerSumTime.getUnit());
    assertTrue(actualInnerSumTime.isEmpty());
  }

  /**
   * Test {@link NestedTimer#getTotalSumTime()}.
   * <p>
   * Method under test: {@link NestedTimer#getTotalSumTime()}
   */
  @Test
  public void testGetTotalSumTime() {
    // Arrange and Act
    TimeSpan actualTotalSumTime = (new NestedTimer()).getTotalSumTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualTotalSumTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualTotalSumTime.getUnit());
    assertTrue(actualTotalSumTime.isEmpty());
  }

  /**
   * Test {@link NestedTimer#getOuterMaxTime()}.
   * <p>
   * Method under test: {@link NestedTimer#getOuterMaxTime()}
   */
  @Test
  public void testGetOuterMaxTime() {
    // Arrange and Act
    TimeSpan actualOuterMaxTime = (new NestedTimer()).getOuterMaxTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualOuterMaxTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualOuterMaxTime.getUnit());
    assertTrue(actualOuterMaxTime.isEmpty());
  }

  /**
   * Test {@link NestedTimer#getInnerMaxTime()}.
   * <p>
   * Method under test: {@link NestedTimer#getInnerMaxTime()}
   */
  @Test
  public void testGetInnerMaxTime() {
    // Arrange and Act
    TimeSpan actualInnerMaxTime = (new NestedTimer()).getInnerMaxTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualInnerMaxTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualInnerMaxTime.getUnit());
    assertTrue(actualInnerMaxTime.isEmpty());
  }

  /**
   * Test {@link NestedTimer#getTotalMaxTime()}.
   * <p>
   * Method under test: {@link NestedTimer#getTotalMaxTime()}
   */
  @Test
  public void testGetTotalMaxTime() {
    // Arrange and Act
    TimeSpan actualTotalMaxTime = (new NestedTimer()).getTotalMaxTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualTotalMaxTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualTotalMaxTime.getUnit());
    assertTrue(actualTotalMaxTime.isEmpty());
  }

  /**
   * Test {@link NestedTimer#getNumberOfIntervals()}.
   * <p>
   * Method under test: {@link NestedTimer#getNumberOfIntervals()}
   */
  @Test
  public void testGetNumberOfIntervals() {
    // Arrange, Act and Assert
    assertEquals(0, (new NestedTimer()).getNumberOfIntervals());
  }

  /**
   * Test {@link NestedTimer#getLengthOfLastOuterInterval()}.
   * <p>
   * Method under test: {@link NestedTimer#getLengthOfLastOuterInterval()}
   */
  @Test
  public void testGetLengthOfLastOuterInterval() {
    // Arrange and Act
    TimeSpan actualLengthOfLastOuterInterval = (new NestedTimer()).getLengthOfLastOuterInterval();

    // Assert
    ImmutableList<TemporalUnit> units = actualLengthOfLastOuterInterval.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualLengthOfLastOuterInterval.getUnit());
    assertTrue(actualLengthOfLastOuterInterval.isEmpty());
  }

  /**
   * Test {@link NestedTimer#getLengthOfLastTotalInterval()}.
   * <p>
   * Method under test: {@link NestedTimer#getLengthOfLastTotalInterval()}
   */
  @Test
  public void testGetLengthOfLastTotalInterval() {
    // Arrange and Act
    TimeSpan actualLengthOfLastTotalInterval = (new NestedTimer()).getLengthOfLastTotalInterval();

    // Assert
    ImmutableList<TemporalUnit> units = actualLengthOfLastTotalInterval.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualLengthOfLastTotalInterval.getUnit());
    assertTrue(actualLengthOfLastTotalInterval.isEmpty());
  }

  /**
   * Test {@link NestedTimer#getOuterAvgTime()}.
   * <p>
   * Method under test: {@link NestedTimer#getOuterAvgTime()}
   */
  @Test
  public void testGetOuterAvgTime() {
    // Arrange and Act
    TimeSpan actualOuterAvgTime = (new NestedTimer()).getOuterAvgTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualOuterAvgTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualOuterAvgTime.getUnit());
    assertTrue(actualOuterAvgTime.isEmpty());
  }

  /**
   * Test {@link NestedTimer#getInnerAvgSumTime()}.
   * <p>
   * Method under test: {@link NestedTimer#getInnerAvgSumTime()}
   */
  @Test
  public void testGetInnerAvgSumTime() {
    // Arrange and Act
    TimeSpan actualInnerAvgSumTime = (new NestedTimer()).getInnerAvgSumTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualInnerAvgSumTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualInnerAvgSumTime.getUnit());
    assertTrue(actualInnerAvgSumTime.isEmpty());
  }

  /**
   * Test {@link NestedTimer#getTotalAvgTime()}.
   * <p>
   * Method under test: {@link NestedTimer#getTotalAvgTime()}
   */
  @Test
  public void testGetTotalAvgTime() {
    // Arrange and Act
    TimeSpan actualTotalAvgTime = (new NestedTimer()).getTotalAvgTime();

    // Assert
    ImmutableList<TemporalUnit> units = actualTotalAvgTime.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualTotalAvgTime.getUnit());
    assertTrue(actualTotalAvgTime.isEmpty());
  }

  /**
   * Test new {@link NestedTimer} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link NestedTimer}
   */
  @Test
  public void testNewNestedTimer() {
    // Arrange and Act
    NestedTimer actualNestedTimer = new NestedTimer();

    // Assert
    assertEquals(0, actualNestedTimer.getNumberOfIntervals());
    assertFalse(actualNestedTimer.isOnlyOuterRunning());
    assertFalse(actualNestedTimer.isRunning());
  }

  /**
   * Test {@link NestedTimer#toString()}.
   * <p>
   * Method under test: {@link NestedTimer#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("    0.000s", (new NestedTimer()).toString());
  }
}
