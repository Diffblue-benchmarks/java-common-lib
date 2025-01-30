package org.sosy_lab.common.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.google.common.collect.ImmutableList;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class TimeSpanDiffblueTest {
  /**
   * Test {@link TimeSpan#of(long, TimeUnit)}.
   * <ul>
   *   <li>When {@code NANOSECONDS}.</li>
   *   <li>Then return Units size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#of(long, TimeUnit)}
   */
  @Test
  public void testOf_whenNanoseconds_thenReturnUnitsSizeIsOne() {
    // Arrange and Act
    TimeSpan actualOfResult = TimeSpan.of(1L, TimeUnit.NANOSECONDS);

    // Assert
    ImmutableList<TemporalUnit> units = actualOfResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.NANOS, getResult);
    assertEquals(TimeUnit.NANOSECONDS, actualOfResult.getUnit());
    assertFalse(actualOfResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#ofSeconds(long)}.
   * <p>
   * Method under test: {@link TimeSpan#ofSeconds(long)}
   */
  @Test
  public void testOfSeconds() {
    // Arrange and Act
    TimeSpan actualOfSecondsResult = TimeSpan.ofSeconds(1L);

    // Assert
    ImmutableList<TemporalUnit> units = actualOfSecondsResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualOfSecondsResult.getUnit());
    assertFalse(actualOfSecondsResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#ofMillis(long)}.
   * <p>
   * Method under test: {@link TimeSpan#ofMillis(long)}
   */
  @Test
  public void testOfMillis() {
    // Arrange and Act
    TimeSpan actualOfMillisResult = TimeSpan.ofMillis(1L);

    // Assert
    ImmutableList<TemporalUnit> units = actualOfMillisResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualOfMillisResult.getUnit());
    assertFalse(actualOfMillisResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#ofNanos(long)}.
   * <p>
   * Method under test: {@link TimeSpan#ofNanos(long)}
   */
  @Test
  public void testOfNanos() {
    // Arrange and Act
    TimeSpan actualOfNanosResult = TimeSpan.ofNanos(1L);

    // Assert
    ImmutableList<TemporalUnit> units = actualOfNanosResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.NANOS, getResult);
    assertEquals(TimeUnit.NANOSECONDS, actualOfNanosResult.getUnit());
    assertFalse(actualOfNanosResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#empty()}.
   * <p>
   * Method under test: {@link TimeSpan#empty()}
   */
  @Test
  public void testEmpty() {
    // Arrange and Act
    TimeSpan actualEmptyResult = TimeSpan.empty();

    // Assert
    ImmutableList<TemporalUnit> units = actualEmptyResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.DAYS, getResult);
    assertEquals(TimeUnit.DAYS, actualEmptyResult.getUnit());
    assertTrue(actualEmptyResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When {@code 9 d}.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_when9D_thenReturnNotEmpty() {
    // Arrange and Act
    TimeSpan actualValueOfResult = TimeSpan.valueOf(" 9 d");

    // Assert
    ImmutableList<TemporalUnit> units = actualValueOfResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualValueOfResult.getUnit());
    assertFalse(actualValueOfResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When {@code 9 day}.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_when9Day_thenReturnNotEmpty() {
    // Arrange and Act
    TimeSpan actualValueOfResult = TimeSpan.valueOf(" 9 day");

    // Assert
    ImmutableList<TemporalUnit> units = actualValueOfResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualValueOfResult.getUnit());
    assertFalse(actualValueOfResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When {@code 9 days}.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_when9Days_thenReturnNotEmpty() {
    // Arrange and Act
    TimeSpan actualValueOfResult = TimeSpan.valueOf(" 9 days");

    // Assert
    ImmutableList<TemporalUnit> units = actualValueOfResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualValueOfResult.getUnit());
    assertFalse(actualValueOfResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When {@code 9 h}.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_when9H_thenReturnNotEmpty() {
    // Arrange and Act
    TimeSpan actualValueOfResult = TimeSpan.valueOf(" 9 h");

    // Assert
    ImmutableList<TemporalUnit> units = actualValueOfResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualValueOfResult.getUnit());
    assertFalse(actualValueOfResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When {@code 9 hour}.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_when9Hour_thenReturnNotEmpty() {
    // Arrange and Act
    TimeSpan actualValueOfResult = TimeSpan.valueOf(" 9 hour");

    // Assert
    ImmutableList<TemporalUnit> units = actualValueOfResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualValueOfResult.getUnit());
    assertFalse(actualValueOfResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When {@code 9 hours}.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_when9Hours_thenReturnNotEmpty() {
    // Arrange and Act
    TimeSpan actualValueOfResult = TimeSpan.valueOf(" 9 hours");

    // Assert
    ImmutableList<TemporalUnit> units = actualValueOfResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualValueOfResult.getUnit());
    assertFalse(actualValueOfResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When {@code 9 m}.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_when9M_thenReturnNotEmpty() {
    // Arrange and Act
    TimeSpan actualValueOfResult = TimeSpan.valueOf(" 9 m");

    // Assert
    ImmutableList<TemporalUnit> units = actualValueOfResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualValueOfResult.getUnit());
    assertFalse(actualValueOfResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When {@code 9 min}.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_when9Min_thenReturnNotEmpty() {
    // Arrange and Act
    TimeSpan actualValueOfResult = TimeSpan.valueOf(" 9 min");

    // Assert
    ImmutableList<TemporalUnit> units = actualValueOfResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualValueOfResult.getUnit());
    assertFalse(actualValueOfResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When {@code 9 s}.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_when9S_thenReturnNotEmpty() {
    // Arrange and Act
    TimeSpan actualValueOfResult = TimeSpan.valueOf(" 9 s");

    // Assert
    ImmutableList<TemporalUnit> units = actualValueOfResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualValueOfResult.getUnit());
    assertFalse(actualValueOfResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When {@code 9}.</li>
   *   <li>Then return not Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_when9_thenReturnNotEmpty() {
    // Arrange and Act
    TimeSpan actualValueOfResult = TimeSpan.valueOf(" 9 ");

    // Assert
    ImmutableList<TemporalUnit> units = actualValueOfResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualValueOfResult.getUnit());
    assertFalse(actualValueOfResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When {@code 9 9}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_when99_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TimeSpan.valueOf(" 9  9 "));
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    TimeSpan actualValueOfResult = TimeSpan.valueOf("");

    // Assert
    ImmutableList<TemporalUnit> units = actualValueOfResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualValueOfResult.getUnit());
    assertTrue(actualValueOfResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#valueOf(String)}.
   * <ul>
   *   <li>When {@code HUMAN_READABLE_LARGE}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#valueOf(String)}
   */
  @Test
  public void testValueOf_whenHumanReadableLarge_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TimeSpan.valueOf("HUMAN_READABLE_LARGE"));
  }

  /**
   * Test {@link TimeSpan#getChecked(TimeUnit)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#getChecked(TimeUnit)}
   */
  @Test
  public void testGetChecked_givenEmpty_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, TimeSpan.empty().getChecked(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#getChecked(TimeUnit)}.
   * <ul>
   *   <li>Given ofNanos minus six.</li>
   *   <li>Then return minus six.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#getChecked(TimeUnit)}
   */
  @Test
  public void testGetChecked_givenOfNanosMinusSix_thenReturnMinusSix() {
    // Arrange, Act and Assert
    assertEquals(-6L, TimeSpan.ofNanos(-6L).getChecked(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#getSaturated(TimeUnit)}.
   * <p>
   * Method under test: {@link TimeSpan#getSaturated(TimeUnit)}
   */
  @Test
  public void testGetSaturated() {
    // Arrange, Act and Assert
    assertEquals(0L, TimeSpan.empty().getSaturated(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#toChecked(TimeUnit)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@code NANOSECONDS}.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#toChecked(TimeUnit)}
   */
  @Test
  public void testToChecked_givenEmpty_whenNanoseconds_thenReturnEmpty() {
    // Arrange
    TimeSpan emptyResult = TimeSpan.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult.toChecked(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#toChecked(TimeUnit)}.
   * <ul>
   *   <li>Given ofNanos minus six.</li>
   *   <li>When {@code MICROSECONDS}.</li>
   *   <li>Then return Units size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#toChecked(TimeUnit)}
   */
  @Test
  public void testToChecked_givenOfNanosMinusSix_whenMicroseconds_thenReturnUnitsSizeIsOne() {
    // Arrange and Act
    TimeSpan actualToCheckedResult = TimeSpan.ofNanos(-6L).toChecked(TimeUnit.MICROSECONDS);

    // Assert
    ImmutableList<TemporalUnit> units = actualToCheckedResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MICROS, getResult);
    assertEquals(TimeUnit.MICROSECONDS, actualToCheckedResult.getUnit());
    assertTrue(actualToCheckedResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#toChecked(TimeUnit)}.
   * <ul>
   *   <li>Given ofNanos minus six.</li>
   *   <li>When {@code NANOSECONDS}.</li>
   *   <li>Then return ofNanos minus six.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#toChecked(TimeUnit)}
   */
  @Test
  public void testToChecked_givenOfNanosMinusSix_whenNanoseconds_thenReturnOfNanosMinusSix() {
    // Arrange
    TimeSpan ofNanosResult = TimeSpan.ofNanos(-6L);

    // Act and Assert
    assertSame(ofNanosResult, ofNanosResult.toChecked(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#toSaturated(TimeUnit)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#toSaturated(TimeUnit)}
   */
  @Test
  public void testToSaturated_givenEmpty_thenReturnEmpty() {
    // Arrange
    TimeSpan emptyResult = TimeSpan.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult.toSaturated(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#toSaturated(TimeUnit)}.
   * <ul>
   *   <li>Given ofNanos one.</li>
   *   <li>Then return ofNanos one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#toSaturated(TimeUnit)}
   */
  @Test
  public void testToSaturated_givenOfNanosOne_thenReturnOfNanosOne() {
    // Arrange
    TimeSpan ofNanosResult = TimeSpan.ofNanos(1L);

    // Act and Assert
    assertSame(ofNanosResult, ofNanosResult.toSaturated(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#toIfPossible(TimeUnit)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@code NANOSECONDS}.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#toIfPossible(TimeUnit)}
   */
  @Test
  public void testToIfPossible_givenEmpty_whenNanoseconds_thenReturnEmpty() {
    // Arrange
    TimeSpan emptyResult = TimeSpan.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult.toIfPossible(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#toIfPossible(TimeUnit)}.
   * <ul>
   *   <li>Given ofMillis {@link Long#MAX_VALUE}.</li>
   *   <li>Then return ofMillis {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#toIfPossible(TimeUnit)}
   */
  @Test
  public void testToIfPossible_givenOfMillisMax_value_thenReturnOfMillisMax_value() {
    // Arrange
    TimeSpan ofMillisResult = TimeSpan.ofMillis(Long.MAX_VALUE);

    // Act and Assert
    assertSame(ofMillisResult, ofMillisResult.toIfPossible(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#toIfPossible(TimeUnit)}.
   * <ul>
   *   <li>Given ofNanos minus six.</li>
   *   <li>When {@code MICROSECONDS}.</li>
   *   <li>Then return Units size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#toIfPossible(TimeUnit)}
   */
  @Test
  public void testToIfPossible_givenOfNanosMinusSix_whenMicroseconds_thenReturnUnitsSizeIsOne() {
    // Arrange and Act
    TimeSpan actualToIfPossibleResult = TimeSpan.ofNanos(-6L).toIfPossible(TimeUnit.MICROSECONDS);

    // Assert
    ImmutableList<TemporalUnit> units = actualToIfPossibleResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MICROS, getResult);
    assertEquals(TimeUnit.MICROSECONDS, actualToIfPossibleResult.getUnit());
    assertTrue(actualToIfPossibleResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#toIfPossible(TimeUnit)}.
   * <ul>
   *   <li>Given ofNanos minus six.</li>
   *   <li>When {@code NANOSECONDS}.</li>
   *   <li>Then return ofNanos minus six.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#toIfPossible(TimeUnit)}
   */
  @Test
  public void testToIfPossible_givenOfNanosMinusSix_whenNanoseconds_thenReturnOfNanosMinusSix() {
    // Arrange
    TimeSpan ofNanosResult = TimeSpan.ofNanos(-6L);

    // Act and Assert
    assertSame(ofNanosResult, ofNanosResult.toIfPossible(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#asSeconds()}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#asSeconds()}
   */
  @Test
  public void testAsSeconds_givenEmpty() {
    // Arrange, Act and Assert
    assertEquals(0L, TimeSpan.empty().asSeconds());
  }

  /**
   * Test {@link TimeSpan#asSeconds()}.
   * <ul>
   *   <li>Given ofMillis minus three.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#asSeconds()}
   */
  @Test
  public void testAsSeconds_givenOfMillisMinusThree() {
    // Arrange, Act and Assert
    assertEquals(0L, TimeSpan.ofMillis(-3L).asSeconds());
  }

  /**
   * Test {@link TimeSpan#asMillis()}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#asMillis()}
   */
  @Test
  public void testAsMillis_givenEmpty_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, TimeSpan.empty().asMillis());
  }

  /**
   * Test {@link TimeSpan#asMillis()}.
   * <ul>
   *   <li>Given ofMillis minus four.</li>
   *   <li>Then return minus four.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#asMillis()}
   */
  @Test
  public void testAsMillis_givenOfMillisMinusFour_thenReturnMinusFour() {
    // Arrange, Act and Assert
    assertEquals(-4L, TimeSpan.ofMillis(-4L).asMillis());
  }

  /**
   * Test {@link TimeSpan#asNanos()}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#asNanos()}
   */
  @Test
  public void testAsNanos_givenEmpty_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, TimeSpan.empty().asNanos());
  }

  /**
   * Test {@link TimeSpan#asNanos()}.
   * <ul>
   *   <li>Given ofNanos minus six.</li>
   *   <li>Then return minus six.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#asNanos()}
   */
  @Test
  public void testAsNanos_givenOfNanosMinusSix_thenReturnMinusSix() {
    // Arrange, Act and Assert
    assertEquals(-6L, TimeSpan.ofNanos(-6L).asNanos());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeSpan#toString()}
   *   <li>{@link TimeSpan#getUnit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    TimeSpan emptyResult = TimeSpan.empty();

    // Act
    String actualToStringResult = emptyResult.toString();

    // Assert
    assertEquals("0d", actualToStringResult);
    assertEquals(TimeUnit.DAYS, emptyResult.getUnit());
  }

  /**
   * Test {@link TimeSpan#asDuration()}.
   * <p>
   * Method under test: {@link TimeSpan#asDuration()}
   */
  @Test
  public void testAsDuration() {
    // Arrange and Act
    Duration actualAsDurationResult = TimeSpan.empty().asDuration();

    // Assert
    assertEquals(0L, actualAsDurationResult.toNanos());
    assertSame(actualAsDurationResult.ZERO, actualAsDurationResult);
  }

  /**
   * Test {@link TimeSpan#formatAs(TimeUnit)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@code NANOSECONDS}.</li>
   *   <li>Then return {@code 0ns}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#formatAs(TimeUnit)}
   */
  @Test
  public void testFormatAs_givenEmpty_whenNanoseconds_thenReturn0ns() {
    // Arrange, Act and Assert
    assertEquals("0ns", TimeSpan.empty().formatAs(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#formatAs(TimeUnit)}.
   * <ul>
   *   <li>Given ofMillis {@link Long#MAX_VALUE}.</li>
   *   <li>Then return {@code 9223372036854775807ms}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#formatAs(TimeUnit)}
   */
  @Test
  public void testFormatAs_givenOfMillisMax_value_thenReturn9223372036854775807ms() {
    // Arrange, Act and Assert
    assertEquals("9223372036854775807ms", TimeSpan.ofMillis(Long.MAX_VALUE).formatAs(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#formatAs(TimeUnit)}.
   * <ul>
   *   <li>Given ofNanos minus six.</li>
   *   <li>When {@code MICROSECONDS}.</li>
   *   <li>Then return {@code -0.006µs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#formatAs(TimeUnit)}
   */
  @Test
  public void testFormatAs_givenOfNanosMinusSix_whenMicroseconds_thenReturn0006S() {
    // Arrange, Act and Assert
    assertEquals("   -0.006µs", TimeSpan.ofNanos(-6L).formatAs(TimeUnit.MICROSECONDS));
  }

  /**
   * Test {@link TimeSpan#formatAs(TimeUnit)}.
   * <ul>
   *   <li>Given ofNanos minus six.</li>
   *   <li>When {@code NANOSECONDS}.</li>
   *   <li>Then return {@code -6ns}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#formatAs(TimeUnit)}
   */
  @Test
  public void testFormatAs_givenOfNanosMinusSix_whenNanoseconds_thenReturn6ns() {
    // Arrange, Act and Assert
    assertEquals("-6ns", TimeSpan.ofNanos(-6L).formatAs(TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link TimeSpan#isEmpty()}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#isEmpty()}
   */
  @Test
  public void testIsEmpty_givenEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(TimeSpan.empty().isEmpty());
  }

  /**
   * Test {@link TimeSpan#isEmpty()}.
   * <ul>
   *   <li>Given ofMillis one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#isEmpty()}
   */
  @Test
  public void testIsEmpty_givenOfMillisOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TimeSpan.ofMillis(1L).isEmpty());
  }

  /**
   * Test {@link TimeSpan#equals(Object)}, and {@link TimeSpan#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeSpan#equals(Object)}
   *   <li>{@link TimeSpan#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TimeSpan emptyResult = TimeSpan.empty();
    TimeSpan emptyResult2 = TimeSpan.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult2);
    int expectedHashCodeResult = emptyResult.hashCode();
    assertEquals(expectedHashCodeResult, emptyResult2.hashCode());
  }

  /**
   * Test {@link TimeSpan#equals(Object)}, and {@link TimeSpan#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeSpan#equals(Object)}
   *   <li>{@link TimeSpan#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TimeSpan ofMillisResult = TimeSpan.ofMillis(0L);
    TimeSpan emptyResult = TimeSpan.empty();

    // Act and Assert
    assertEquals(ofMillisResult, emptyResult);
    int expectedHashCodeResult = ofMillisResult.hashCode();
    assertEquals(expectedHashCodeResult, emptyResult.hashCode());
  }

  /**
   * Test {@link TimeSpan#equals(Object)}, and {@link TimeSpan#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeSpan#equals(Object)}
   *   <li>{@link TimeSpan#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TimeSpan emptyResult = TimeSpan.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult);
    int expectedHashCodeResult = emptyResult.hashCode();
    assertEquals(expectedHashCodeResult, emptyResult.hashCode());
  }

  /**
   * Test {@link TimeSpan#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TimeSpan ofMillisResult = TimeSpan.ofMillis(1L);

    // Act and Assert
    assertNotEquals(ofMillisResult, TimeSpan.empty());
  }

  /**
   * Test {@link TimeSpan#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TimeSpan ofMillisResult = TimeSpan.ofMillis(0L);

    // Act and Assert
    assertNotEquals(ofMillisResult, TimeSpan.ofMillis(1L));
  }

  /**
   * Test {@link TimeSpan#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TimeSpan.empty(), null);
  }

  /**
   * Test {@link TimeSpan#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TimeSpan.empty(), "Different type to TimeSpan");
  }

  /**
   * Test {@link TimeSpan#compareTo(TimeSpan)} with {@code other}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When empty.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#compareTo(TimeSpan)}
   */
  @Test
  public void testCompareToWithOther_givenEmpty_whenEmpty_thenReturnZero() {
    // Arrange
    TimeSpan emptyResult = TimeSpan.empty();

    // Act and Assert
    assertEquals(0, emptyResult.compareTo(TimeSpan.empty()));
  }

  /**
   * Test {@link TimeSpan#compareTo(TimeSpan)} with {@code other}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When ofMillis one.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#compareTo(TimeSpan)}
   */
  @Test
  public void testCompareToWithOther_givenEmpty_whenOfMillisOne_thenReturnMinusOne() {
    // Arrange
    TimeSpan emptyResult = TimeSpan.empty();

    // Act and Assert
    assertEquals(-1, emptyResult.compareTo(TimeSpan.ofMillis(1L)));
  }

  /**
   * Test {@link TimeSpan#compareTo(TimeSpan)} with {@code other}.
   * <ul>
   *   <li>Given ofMillis {@link Long#MAX_VALUE}.</li>
   *   <li>When ofNanos one.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#compareTo(TimeSpan)}
   */
  @Test
  public void testCompareToWithOther_givenOfMillisMax_value_whenOfNanosOne_thenReturnTwo() {
    // Arrange
    TimeSpan ofMillisResult = TimeSpan.ofMillis(Long.MAX_VALUE);

    // Act and Assert
    assertEquals(2, ofMillisResult.compareTo(TimeSpan.ofNanos(1L)));
  }

  /**
   * Test {@link TimeSpan#compareTo(TimeSpan)} with {@code other}.
   * <ul>
   *   <li>Given ofMillis one.</li>
   *   <li>When empty.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#compareTo(TimeSpan)}
   */
  @Test
  public void testCompareToWithOther_givenOfMillisOne_whenEmpty_thenReturnOne() {
    // Arrange
    TimeSpan ofMillisResult = TimeSpan.ofMillis(1L);

    // Act and Assert
    assertEquals(1, ofMillisResult.compareTo(TimeSpan.empty()));
  }

  /**
   * Test {@link TimeSpan#compareTo(TimeSpan)} with {@code other}.
   * <ul>
   *   <li>Given ofNanos one.</li>
   *   <li>When ofMillis {@link Long#MAX_VALUE}.</li>
   *   <li>Then return minus two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#compareTo(TimeSpan)}
   */
  @Test
  public void testCompareToWithOther_givenOfNanosOne_whenOfMillisMax_value_thenReturnMinusTwo() {
    // Arrange
    TimeSpan ofNanosResult = TimeSpan.ofNanos(1L);

    // Act and Assert
    assertEquals(-2, ofNanosResult.compareTo(TimeSpan.ofMillis(Long.MAX_VALUE)));
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan, TimeSpan)} with {@code a}, {@code b}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan, TimeSpan)}
   */
  @Test
  public void testSumWithAB_whenEmpty_thenReturnEmpty() {
    // Arrange
    TimeSpan a = TimeSpan.empty();

    // Act and Assert
    assertEquals(a, TimeSpan.sum(a, TimeSpan.empty()));
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan, TimeSpan)} with {@code a}, {@code b}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return ofMillis one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan, TimeSpan)}
   */
  @Test
  public void testSumWithAB_whenEmpty_thenReturnOfMillisOne() {
    // Arrange
    TimeSpan a = TimeSpan.empty();
    TimeSpan b = TimeSpan.ofMillis(1L);

    // Act and Assert
    assertEquals(b, TimeSpan.sum(a, b));
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan, TimeSpan)} with {@code a}, {@code b}.
   * <ul>
   *   <li>When ofMillis {@link Long#MAX_VALUE}.</li>
   *   <li>Then return Units size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan, TimeSpan)}
   */
  @Test
  public void testSumWithAB_whenOfMillisMax_value_thenReturnUnitsSizeIsOne() {
    // Arrange
    TimeSpan a = TimeSpan.ofMillis(Long.MAX_VALUE);

    // Act
    TimeSpan actualSumResult = TimeSpan.sum(a, TimeSpan.ofMillis(1L));

    // Assert
    ImmutableList<TemporalUnit> units = actualSumResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualSumResult.getUnit());
    assertFalse(actualSumResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan, TimeSpan)} with {@code a}, {@code b}.
   * <ul>
   *   <li>When ofMillis one.</li>
   *   <li>Then return ofMillis one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan, TimeSpan)}
   */
  @Test
  public void testSumWithAB_whenOfMillisOne_thenReturnOfMillisOne() {
    // Arrange
    TimeSpan a = TimeSpan.ofMillis(1L);

    // Act and Assert
    assertEquals(a, TimeSpan.sum(a, TimeSpan.empty()));
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan, TimeSpan)} with {@code a}, {@code b}.
   * <ul>
   *   <li>When ofNanos one.</li>
   *   <li>Then return ofMillis {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan, TimeSpan)}
   */
  @Test
  public void testSumWithAB_whenOfNanosOne_thenReturnOfMillisMax_value() {
    // Arrange
    TimeSpan a = TimeSpan.ofMillis(Long.MAX_VALUE);

    // Act and Assert
    assertEquals(a, TimeSpan.sum(a, TimeSpan.ofNanos(1L)));
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan, TimeSpan)} with {@code a}, {@code b}.
   * <ul>
   *   <li>When ofNanos one.</li>
   *   <li>Then return ofMillis {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan, TimeSpan)}
   */
  @Test
  public void testSumWithAB_whenOfNanosOne_thenReturnOfMillisMax_value2() {
    // Arrange
    TimeSpan a = TimeSpan.ofNanos(1L);
    TimeSpan b = TimeSpan.ofMillis(Long.MAX_VALUE);

    // Act and Assert
    assertEquals(b, TimeSpan.sum(a, b));
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan[])} with {@code t}.
   * <ul>
   *   <li>When empty and empty.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan[])}
   */
  @Test
  public void testSumWithT_whenEmptyAndEmpty_thenReturnEmpty() {
    // Arrange
    TimeSpan emptyResult = TimeSpan.empty();

    // Act and Assert
    assertEquals(emptyResult, TimeSpan.sum(emptyResult, TimeSpan.empty()));
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan[])} with {@code t}.
   * <ul>
   *   <li>When empty and ofMillis one.</li>
   *   <li>Then return ofMillis one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan[])}
   */
  @Test
  public void testSumWithT_whenEmptyAndOfMillisOne_thenReturnOfMillisOne() {
    // Arrange
    TimeSpan emptyResult = TimeSpan.empty();
    TimeSpan ofMillisResult = TimeSpan.ofMillis(1L);

    // Act and Assert
    assertEquals(ofMillisResult, TimeSpan.sum(emptyResult, ofMillisResult));
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan[])} with {@code t}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return Units first is {@code DAYS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan[])}
   */
  @Test
  public void testSumWithT_whenEmpty_thenReturnUnitsFirstIsDays() {
    // Arrange and Act
    TimeSpan actualSumResult = TimeSpan.sum(TimeSpan.empty());

    // Assert
    ImmutableList<TemporalUnit> units = actualSumResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.DAYS, getResult);
    assertEquals(TimeUnit.DAYS, actualSumResult.getUnit());
    assertTrue(actualSumResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan[])} with {@code t}.
   * <ul>
   *   <li>When ofMillis {@link Long#MAX_VALUE} and ofMillis one.</li>
   *   <li>Then return Units first is {@code SECONDS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan[])}
   */
  @Test
  public void testSumWithT_whenOfMillisMax_valueAndOfMillisOne_thenReturnUnitsFirstIsSeconds() {
    // Arrange
    TimeSpan ofMillisResult = TimeSpan.ofMillis(Long.MAX_VALUE);

    // Act
    TimeSpan actualSumResult = TimeSpan.sum(ofMillisResult, TimeSpan.ofMillis(1L));

    // Assert
    ImmutableList<TemporalUnit> units = actualSumResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualSumResult.getUnit());
    assertFalse(actualSumResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan[])} with {@code t}.
   * <ul>
   *   <li>When ofMillis {@link Long#MAX_VALUE} and ofNanos one.</li>
   *   <li>Then return ofMillis {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan[])}
   */
  @Test
  public void testSumWithT_whenOfMillisMax_valueAndOfNanosOne_thenReturnOfMillisMax_value() {
    // Arrange
    TimeSpan ofMillisResult = TimeSpan.ofMillis(Long.MAX_VALUE);

    // Act and Assert
    assertEquals(ofMillisResult, TimeSpan.sum(ofMillisResult, TimeSpan.ofNanos(1L)));
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan[])} with {@code t}.
   * <ul>
   *   <li>When ofMillis one and empty.</li>
   *   <li>Then return ofMillis one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan[])}
   */
  @Test
  public void testSumWithT_whenOfMillisOneAndEmpty_thenReturnOfMillisOne() {
    // Arrange
    TimeSpan ofMillisResult = TimeSpan.ofMillis(1L);

    // Act and Assert
    assertEquals(ofMillisResult, TimeSpan.sum(ofMillisResult, TimeSpan.empty()));
  }

  /**
   * Test {@link TimeSpan#sum(TimeSpan[])} with {@code t}.
   * <ul>
   *   <li>When ofNanos one and ofMillis {@link Long#MAX_VALUE}.</li>
   *   <li>Then return ofMillis {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(TimeSpan[])}
   */
  @Test
  public void testSumWithT_whenOfNanosOneAndOfMillisMax_value_thenReturnOfMillisMax_value() {
    // Arrange
    TimeSpan ofNanosResult = TimeSpan.ofNanos(1L);
    TimeSpan ofMillisResult = TimeSpan.ofMillis(Long.MAX_VALUE);

    // Act and Assert
    assertEquals(ofMillisResult, TimeSpan.sum(ofNanosResult, ofMillisResult));
  }

  /**
   * Test {@link TimeSpan#sum(Iterable)} with {@code timeSpans}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link ArrayList#ArrayList()} add empty.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(Iterable)}
   */
  @Test
  public void testSumWithTimeSpans_givenEmpty_whenArrayListAddEmpty_thenReturnEmpty() {
    // Arrange
    ArrayList<TimeSpan> timeSpans = new ArrayList<>();
    TimeSpan emptyResult = TimeSpan.empty();
    timeSpans.add(emptyResult);
    timeSpans.add(TimeSpan.empty());

    // Act and Assert
    assertEquals(emptyResult, TimeSpan.sum(timeSpans));
  }

  /**
   * Test {@link TimeSpan#sum(Iterable)} with {@code timeSpans}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link ArrayList#ArrayList()} add empty.</li>
   *   <li>Then return Units first is {@code DAYS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(Iterable)}
   */
  @Test
  public void testSumWithTimeSpans_givenEmpty_whenArrayListAddEmpty_thenReturnUnitsFirstIsDays() {
    // Arrange
    ArrayList<TimeSpan> timeSpans = new ArrayList<>();
    timeSpans.add(TimeSpan.empty());

    // Act
    TimeSpan actualSumResult = TimeSpan.sum(timeSpans);

    // Assert
    ImmutableList<TemporalUnit> units = actualSumResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.DAYS, getResult);
    assertEquals(TimeUnit.DAYS, actualSumResult.getUnit());
    assertTrue(actualSumResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#sum(Iterable)} with {@code timeSpans}.
   * <ul>
   *   <li>Given ofMillis {@link Long#MAX_VALUE}.</li>
   *   <li>Then return Units first is {@code SECONDS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(Iterable)}
   */
  @Test
  public void testSumWithTimeSpans_givenOfMillisMax_value_thenReturnUnitsFirstIsSeconds() {
    // Arrange
    ArrayList<TimeSpan> timeSpans = new ArrayList<>();
    timeSpans.add(TimeSpan.ofMillis(Long.MAX_VALUE));
    timeSpans.add(TimeSpan.ofMillis(1L));

    // Act
    TimeSpan actualSumResult = TimeSpan.sum(timeSpans);

    // Assert
    ImmutableList<TemporalUnit> units = actualSumResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualSumResult.getUnit());
    assertFalse(actualSumResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#sum(Iterable)} with {@code timeSpans}.
   * <ul>
   *   <li>Given ofMillis one.</li>
   *   <li>Then return ofMillis one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(Iterable)}
   */
  @Test
  public void testSumWithTimeSpans_givenOfMillisOne_thenReturnOfMillisOne() {
    // Arrange
    ArrayList<TimeSpan> timeSpans = new ArrayList<>();
    TimeSpan ofMillisResult = TimeSpan.ofMillis(1L);
    timeSpans.add(ofMillisResult);
    timeSpans.add(TimeSpan.empty());

    // Act and Assert
    assertEquals(ofMillisResult, TimeSpan.sum(timeSpans));
  }

  /**
   * Test {@link TimeSpan#sum(Iterable)} with {@code timeSpans}.
   * <ul>
   *   <li>Given ofMillis one.</li>
   *   <li>Then return ofMillis one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(Iterable)}
   */
  @Test
  public void testSumWithTimeSpans_givenOfMillisOne_thenReturnOfMillisOne2() {
    // Arrange
    ArrayList<TimeSpan> timeSpans = new ArrayList<>();
    timeSpans.add(TimeSpan.empty());
    TimeSpan ofMillisResult = TimeSpan.ofMillis(1L);
    timeSpans.add(ofMillisResult);

    // Act and Assert
    assertEquals(ofMillisResult, TimeSpan.sum(timeSpans));
  }

  /**
   * Test {@link TimeSpan#sum(Iterable)} with {@code timeSpans}.
   * <ul>
   *   <li>Given ofNanos one.</li>
   *   <li>Then return ofMillis {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(Iterable)}
   */
  @Test
  public void testSumWithTimeSpans_givenOfNanosOne_thenReturnOfMillisMax_value() {
    // Arrange
    ArrayList<TimeSpan> timeSpans = new ArrayList<>();
    TimeSpan ofMillisResult = TimeSpan.ofMillis(Long.MAX_VALUE);
    timeSpans.add(ofMillisResult);
    timeSpans.add(TimeSpan.ofNanos(1L));

    // Act and Assert
    assertEquals(ofMillisResult, TimeSpan.sum(timeSpans));
  }

  /**
   * Test {@link TimeSpan#sum(Iterable)} with {@code timeSpans}.
   * <ul>
   *   <li>Given ofNanos one.</li>
   *   <li>Then return ofMillis {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#sum(Iterable)}
   */
  @Test
  public void testSumWithTimeSpans_givenOfNanosOne_thenReturnOfMillisMax_value2() {
    // Arrange
    ArrayList<TimeSpan> timeSpans = new ArrayList<>();
    timeSpans.add(TimeSpan.ofNanos(1L));
    TimeSpan ofMillisResult = TimeSpan.ofMillis(Long.MAX_VALUE);
    timeSpans.add(ofMillisResult);

    // Act and Assert
    assertEquals(ofMillisResult, TimeSpan.sum(timeSpans));
  }

  /**
   * Test {@link TimeSpan#difference(TimeSpan, TimeSpan)}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#difference(TimeSpan, TimeSpan)}
   */
  @Test
  public void testDifference_whenEmpty_thenReturnEmpty() {
    // Arrange
    TimeSpan a = TimeSpan.empty();

    // Act and Assert
    assertEquals(a, TimeSpan.difference(a, TimeSpan.empty()));
  }

  /**
   * Test {@link TimeSpan#difference(TimeSpan, TimeSpan)}.
   * <ul>
   *   <li>When ofMillis {@link Long#MAX_VALUE}.</li>
   *   <li>Then return ofMillis {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#difference(TimeSpan, TimeSpan)}
   */
  @Test
  public void testDifference_whenOfMillisMax_value_thenReturnOfMillisMax_value() {
    // Arrange
    TimeSpan a = TimeSpan.ofMillis(Long.MAX_VALUE);

    // Act and Assert
    assertEquals(a, TimeSpan.difference(a, TimeSpan.ofNanos(1L)));
  }

  /**
   * Test {@link TimeSpan#difference(TimeSpan, TimeSpan)}.
   * <ul>
   *   <li>When ofMillis {@link Long#MIN_VALUE}.</li>
   *   <li>Then return Units first is {@code SECONDS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#difference(TimeSpan, TimeSpan)}
   */
  @Test
  public void testDifference_whenOfMillisMin_value_thenReturnUnitsFirstIsSeconds() {
    // Arrange
    TimeSpan a = TimeSpan.empty();

    // Act
    TimeSpan actualDifferenceResult = TimeSpan.difference(a, TimeSpan.ofMillis(Long.MIN_VALUE));

    // Assert
    ImmutableList<TemporalUnit> units = actualDifferenceResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualDifferenceResult.getUnit());
    assertFalse(actualDifferenceResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#difference(TimeSpan, TimeSpan)}.
   * <ul>
   *   <li>When ofMillis one.</li>
   *   <li>Then return ofMillis one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#difference(TimeSpan, TimeSpan)}
   */
  @Test
  public void testDifference_whenOfMillisOne_thenReturnOfMillisOne() {
    // Arrange
    TimeSpan a = TimeSpan.ofMillis(1L);

    // Act and Assert
    assertEquals(a, TimeSpan.difference(a, TimeSpan.empty()));
  }

  /**
   * Test {@link TimeSpan#difference(TimeSpan, TimeSpan)}.
   * <ul>
   *   <li>When ofMillis one.</li>
   *   <li>Then return Units first is {@code MILLIS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#difference(TimeSpan, TimeSpan)}
   */
  @Test
  public void testDifference_whenOfMillisOne_thenReturnUnitsFirstIsMillis() {
    // Arrange
    TimeSpan a = TimeSpan.empty();

    // Act
    TimeSpan actualDifferenceResult = TimeSpan.difference(a, TimeSpan.ofMillis(1L));

    // Assert
    ImmutableList<TemporalUnit> units = actualDifferenceResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.MILLIS, getResult);
    assertEquals(TimeUnit.MILLISECONDS, actualDifferenceResult.getUnit());
    assertFalse(actualDifferenceResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#difference(TimeSpan, TimeSpan)}.
   * <ul>
   *   <li>When ofNanos one.</li>
   *   <li>Then return Units first is {@code SECONDS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#difference(TimeSpan, TimeSpan)}
   */
  @Test
  public void testDifference_whenOfNanosOne_thenReturnUnitsFirstIsSeconds() {
    // Arrange
    TimeSpan a = TimeSpan.ofNanos(1L);

    // Act
    TimeSpan actualDifferenceResult = TimeSpan.difference(a, TimeSpan.ofMillis(Long.MIN_VALUE));

    // Assert
    ImmutableList<TemporalUnit> units = actualDifferenceResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualDifferenceResult.getUnit());
    assertFalse(actualDifferenceResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#multiply(int)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When three.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#multiply(int)}
   */
  @Test
  public void testMultiply_givenEmpty_whenThree_thenReturnEmpty() {
    // Arrange
    TimeSpan emptyResult = TimeSpan.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult.multiply(3));
  }

  /**
   * Test {@link TimeSpan#multiply(int)}.
   * <ul>
   *   <li>Given ofMillis {@link Long#MAX_VALUE}.</li>
   *   <li>When three.</li>
   *   <li>Then return Units size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#multiply(int)}
   */
  @Test
  public void testMultiply_givenOfMillisMax_value_whenThree_thenReturnUnitsSizeIsOne() {
    // Arrange and Act
    TimeSpan actualMultiplyResult = TimeSpan.ofMillis(Long.MAX_VALUE).multiply(3);

    // Assert
    ImmutableList<TemporalUnit> units = actualMultiplyResult.getUnits();
    assertEquals(1, units.size());
    TemporalUnit getResult = units.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.SECONDS, getResult);
    assertEquals(TimeUnit.SECONDS, actualMultiplyResult.getUnit());
    assertFalse(actualMultiplyResult.isEmpty());
  }

  /**
   * Test {@link TimeSpan#divide(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#divide(int)}
   */
  @Test
  public void testDivide_whenOne_thenReturnEmpty() {
    // Arrange
    TimeSpan emptyResult = TimeSpan.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult.divide(1));
  }

  /**
   * Test {@link TimeSpan#getUnits()}.
   * <p>
   * Method under test: {@link TimeSpan#getUnits()}
   */
  @Test
  public void testGetUnits() {
    // Arrange and Act
    ImmutableList<TemporalUnit> actualUnits = TimeSpan.empty().getUnits();

    // Assert
    assertEquals(1, actualUnits.size());
    TemporalUnit getResult = actualUnits.get(0);
    assertTrue(getResult instanceof ChronoUnit);
    assertEquals(ChronoUnit.DAYS, getResult);
  }

  /**
   * Test {@link TimeSpan#addTo(Temporal)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return ofEpochDay one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#addTo(Temporal)}
   */
  @Test
  public void testAddTo_givenEmpty_thenReturnOfEpochDayOne() {
    // Arrange
    LocalDate pTemporal = LocalDate.ofEpochDay(1L);

    // Act and Assert
    assertSame(pTemporal, TimeSpan.empty().addTo(pTemporal));
  }

  /**
   * Test {@link TimeSpan#subtractFrom(Temporal)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return ofEpochDay one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#subtractFrom(Temporal)}
   */
  @Test
  public void testSubtractFrom_givenEmpty_thenReturnOfEpochDayOne() {
    // Arrange
    LocalDate pTemporal = LocalDate.ofEpochDay(1L);

    // Act and Assert
    assertSame(pTemporal, TimeSpan.empty().subtractFrom(pTemporal));
  }

  /**
   * Test {@link TimeSpan#formatHumanReadableLarge()}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#formatHumanReadableLarge()}
   */
  @Test
  public void testFormatHumanReadableLarge_givenEmpty_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", TimeSpan.empty().formatHumanReadableLarge());
  }

  /**
   * Test {@link TimeSpan#formatHumanReadableLarge()}.
   * <ul>
   *   <li>Given ofMillis three hundred sixty-five.</li>
   *   <li>Then return {@code 00s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#formatHumanReadableLarge()}
   */
  @Test
  public void testFormatHumanReadableLarge_givenOfMillisThreeHundredSixtyFive_thenReturn00s() {
    // Arrange, Act and Assert
    assertEquals("00s", TimeSpan.ofMillis(365L).formatHumanReadableLarge());
  }

  /**
   * Test {@link TimeSpan#formatHumanReadableLarge()}.
   * <ul>
   *   <li>Then return {@code 292471208a 247d 07h 12min 55s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpan#formatHumanReadableLarge()}
   */
  @Test
  public void testFormatHumanReadableLarge_thenReturn292471208a247d07h12min55s() {
    // Arrange, Act and Assert
    assertEquals("292471208a 247d 07h 12min 55s", TimeSpan.ofMillis(Long.MAX_VALUE).formatHumanReadableLarge());
  }
}
