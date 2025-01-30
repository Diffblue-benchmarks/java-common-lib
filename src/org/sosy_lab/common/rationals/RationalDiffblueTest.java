package org.sosy_lab.common.rationals;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;

public class RationalDiffblueTest {
  /**
   * Test {@link Rational#of(long)} with {@code l}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return Num toString is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#of(long)}
   */
  @Test
  public void testOfWithL_whenMax_value_thenReturnNumToStringIs9223372036854775807() {
    // Arrange and Act
    Rational actualOfResult = Rational.of(Long.MAX_VALUE);

    // Assert
    BigInteger num = actualOfResult.getNum();
    assertEquals("9223372036854775807", num.toString());
    assertEquals(1, num.signum());
    assertArrayEquals(new byte[]{1}, actualOfResult.getDen().toByteArray());
    assertArrayEquals(new byte[]{Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1}, num.toByteArray());
  }

  /**
   * Test {@link Rational#of(long)} with {@code l}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return Num toString is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#of(long)}
   */
  @Test
  public void testOfWithL_whenMinusOne_thenReturnNumToStringIs1() {
    // Arrange and Act
    Rational actualOfResult = Rational.of(-1L);

    // Assert
    BigInteger num = actualOfResult.getNum();
    assertEquals("-1", num.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, actualOfResult.signum());
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualOfResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#of(long)} with {@code l}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Den toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#of(long)}
   */
  @Test
  public void testOfWithL_whenOne_thenReturnDenToStringIs1() {
    // Arrange and Act
    Rational actualOfResult = Rational.of(1L);

    // Assert
    BigInteger den = actualOfResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(1, den.signum());
    assertEquals(1, actualOfResult.signum());
    assertTrue(actualOfResult.isIntegral());
    assertSame(den, actualOfResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link Rational#of(long)} with {@code l}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return Num toString is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#of(long)}
   */
  @Test
  public void testOfWithL_whenZero_thenReturnNumToStringIs0() {
    // Arrange and Act
    Rational actualOfResult = Rational.of(0L);

    // Assert
    BigInteger num = actualOfResult.getNum();
    assertEquals("0", num.toString());
    assertEquals(-1, num.getLowestSetBit());
    assertEquals(0, num.signum());
    assertEquals(0, actualOfResult.signum());
    assertArrayEquals(new byte[]{0}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualOfResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#of(BigInteger, BigInteger)} with {@code numerator}, {@code denominator}.
   * <ul>
   *   <li>When valueOf five.</li>
   *   <li>Then return Den is valueOf five {@link BigInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#of(BigInteger, BigInteger)}
   */
  @Test
  public void testOfWithNumeratorDenominator_whenValueOfFive_thenReturnDenIsValueOfFiveOne() {
    // Arrange
    BigInteger numerator = BigInteger.valueOf(5L);
    BigInteger denominator = BigInteger.valueOf(5L);

    // Act
    Rational actualOfResult = Rational.of(numerator, denominator);

    // Assert
    BigInteger bigInteger = denominator.ONE;
    BigInteger den = actualOfResult.getDen();
    assertSame(bigInteger, den);
    assertSame(bigInteger, actualOfResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link Rational#of(BigInteger, BigInteger)} with {@code numerator}, {@code denominator}.
   * <ul>
   *   <li>When valueOf minus one.</li>
   *   <li>Then return Num toString is {@code -5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#of(BigInteger, BigInteger)}
   */
  @Test
  public void testOfWithNumeratorDenominator_whenValueOfMinusOne_thenReturnNumToStringIs5() {
    // Arrange
    BigInteger numerator = BigInteger.valueOf(5L);

    // Act
    Rational actualOfResult = Rational.of(numerator, BigInteger.valueOf(-1L));

    // Assert
    BigInteger num = actualOfResult.getNum();
    assertEquals("-5", num.toString());
    assertEquals(-1, num.signum());
    assertEquals(0, num.getLowestSetBit());
    assertArrayEquals(new byte[]{-5}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualOfResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#of(BigInteger, BigInteger)} with {@code numerator}, {@code denominator}.
   * <ul>
   *   <li>When valueOf minus one.</li>
   *   <li>Then return signum is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#of(BigInteger, BigInteger)}
   */
  @Test
  public void testOfWithNumeratorDenominator_whenValueOfMinusOne_thenReturnSignumIsMinusOne() {
    // Arrange
    BigInteger numerator = BigInteger.valueOf(-1L);
    BigInteger denominator = BigInteger.valueOf(5L);

    // Act
    Rational actualOfResult = Rational.of(numerator, denominator);

    // Assert
    assertEquals(-1, actualOfResult.signum());
    assertFalse(actualOfResult.isIntegral());
    assertEquals(numerator, actualOfResult.getNum());
    assertEquals(denominator, actualOfResult.getDen());
  }

  /**
   * Test {@link Rational#of(BigInteger, BigInteger)} with {@code numerator}, {@code denominator}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then return Den is valueOf minus one {@link BigInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#of(BigInteger, BigInteger)}
   */
  @Test
  public void testOfWithNumeratorDenominator_whenValueOfOne_thenReturnDenIsValueOfMinusOneOne() {
    // Arrange
    BigInteger numerator = BigInteger.valueOf(1L);
    BigInteger denominator = BigInteger.valueOf(-1L);

    // Act
    Rational actualOfResult = Rational.of(numerator, denominator);

    // Assert
    assertEquals(denominator, actualOfResult.getNum());
    BigInteger expectedDen = denominator.ONE;
    assertSame(expectedDen, actualOfResult.getDen());
  }

  /**
   * Test {@link Rational#of(BigInteger, BigInteger)} with {@code numerator}, {@code denominator}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then return not Integral.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#of(BigInteger, BigInteger)}
   */
  @Test
  public void testOfWithNumeratorDenominator_whenValueOfOne_thenReturnNotIntegral() {
    // Arrange
    BigInteger numerator = BigInteger.valueOf(1L);
    BigInteger denominator = BigInteger.valueOf(5L);

    // Act
    Rational actualOfResult = Rational.of(numerator, denominator);

    // Assert
    assertFalse(actualOfResult.isIntegral());
    assertEquals(denominator, actualOfResult.getDen());
  }

  /**
   * Test {@link Rational#of(BigInteger, BigInteger)} with {@code numerator}, {@code denominator}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then return Num is valueOf five.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#of(BigInteger, BigInteger)}
   */
  @Test
  public void testOfWithNumeratorDenominator_whenValueOfOne_thenReturnNumIsValueOfFive() {
    // Arrange
    BigInteger numerator = BigInteger.valueOf(5L);
    BigInteger denominator = BigInteger.valueOf(1L);

    // Act
    Rational actualOfResult = Rational.of(numerator, denominator);

    // Assert
    assertEquals(numerator, actualOfResult.getNum());
    BigInteger expectedDen = denominator.ONE;
    assertEquals(expectedDen, actualOfResult.getDen());
  }

  /**
   * Test {@link Rational#of(BigInteger, BigInteger)} with {@code numerator}, {@code denominator}.
   * <ul>
   *   <li>When valueOf zero.</li>
   *   <li>Then return signum is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#of(BigInteger, BigInteger)}
   */
  @Test
  public void testOfWithNumeratorDenominator_whenValueOfZero_thenReturnSignumIsZero() {
    // Arrange
    BigInteger numerator = BigInteger.valueOf(0L);
    BigInteger denominator = BigInteger.valueOf(5L);

    // Act
    Rational actualOfResult = Rational.of(numerator, denominator);

    // Assert
    assertEquals(0, actualOfResult.signum());
    BigInteger expectedDen = numerator.ONE;
    BigInteger den = actualOfResult.getDen();
    assertSame(expectedDen, den);
    BigInteger expectedNum = denominator.ZERO;
    assertSame(expectedNum, actualOfResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link Rational#of(String)} with {@code s}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Den toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#of(String)}
   */
  @Test
  public void testOfWithS_when42_thenReturnDenToStringIs1() {
    // Arrange and Act
    Rational actualOfResult = Rational.of("42");

    // Assert
    BigInteger den = actualOfResult.getDen();
    assertEquals("1", den.toString());
    BigInteger num = actualOfResult.getNum();
    assertEquals("42", num.toString());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(1, num.getLowestSetBit());
    assertEquals(1, den.signum());
    assertEquals(1, num.signum());
    assertEquals(1, actualOfResult.signum());
    assertTrue(actualOfResult.isIntegral());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
    assertArrayEquals(new byte[]{'*'}, num.toByteArray());
  }

  /**
   * Test {@link Rational#ofLongs(long, long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return Den toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofLongs(long, long)}
   */
  @Test
  public void testOfLongs_whenFive_thenReturnDenToStringIs1() {
    // Arrange and Act
    Rational actualOfLongsResult = Rational.ofLongs(5L, 5L);

    // Assert
    BigInteger den = actualOfLongsResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(1, actualOfLongsResult.signum());
    assertTrue(actualOfLongsResult.isIntegral());
    assertSame(den, actualOfLongsResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link Rational#ofLongs(long, long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return Num toString is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofLongs(long, long)}
   */
  @Test
  public void testOfLongs_whenMinusOne_thenReturnNumToStringIs1() {
    // Arrange and Act
    Rational actualOfLongsResult = Rational.ofLongs(-1L, 5L);

    // Assert
    BigInteger num = actualOfLongsResult.getNum();
    assertEquals("-1", num.toString());
    BigInteger den = actualOfLongsResult.getDen();
    assertEquals("5", den.toString());
    assertFalse(actualOfLongsResult.isIntegral());
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{5}, den.toByteArray());
  }

  /**
   * Test {@link Rational#ofLongs(long, long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return Num toString is {@code -5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofLongs(long, long)}
   */
  @Test
  public void testOfLongs_whenMinusOne_thenReturnNumToStringIs5() {
    // Arrange and Act
    Rational actualOfLongsResult = Rational.ofLongs(5L, -1L);

    // Assert
    BigInteger num = actualOfLongsResult.getNum();
    assertEquals("-5", num.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, actualOfLongsResult.signum());
    assertArrayEquals(new byte[]{-5}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualOfLongsResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#ofLongs(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Num toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofLongs(long, long)}
   */
  @Test
  public void testOfLongs_whenOne_thenReturnNumToStringIs1() {
    // Arrange and Act
    Rational actualOfLongsResult = Rational.ofLongs(1L, 5L);

    // Assert
    BigInteger num = actualOfLongsResult.getNum();
    assertEquals("1", num.toString());
    BigInteger den = actualOfLongsResult.getDen();
    assertEquals("5", den.toString());
    assertEquals(1, num.signum());
    assertFalse(actualOfLongsResult.isIntegral());
    assertArrayEquals(new byte[]{1}, num.toByteArray());
    assertArrayEquals(new byte[]{5}, den.toByteArray());
  }

  /**
   * Test {@link Rational#ofLongs(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Num toString is {@code 5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofLongs(long, long)}
   */
  @Test
  public void testOfLongs_whenOne_thenReturnNumToStringIs5() {
    // Arrange and Act
    Rational actualOfLongsResult = Rational.ofLongs(5L, 1L);

    // Assert
    BigInteger num = actualOfLongsResult.getNum();
    assertEquals("5", num.toString());
    assertEquals(1, num.signum());
    assertArrayEquals(new byte[]{1}, actualOfLongsResult.getDen().toByteArray());
    assertArrayEquals(new byte[]{5}, num.toByteArray());
  }

  /**
   * Test {@link Rational#ofLongs(long, long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Num toString is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofLongs(long, long)}
   */
  @Test
  public void testOfLongs_whenOne_thenReturnNumToStringIs12() {
    // Arrange and Act
    Rational actualOfLongsResult = Rational.ofLongs(1L, -1L);

    // Assert
    BigInteger num = actualOfLongsResult.getNum();
    assertEquals("-1", num.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, actualOfLongsResult.signum());
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualOfLongsResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#ofLongs(long, long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return Num toString is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofLongs(long, long)}
   */
  @Test
  public void testOfLongs_whenZero_thenReturnNumToStringIs0() {
    // Arrange and Act
    Rational actualOfLongsResult = Rational.ofLongs(0L, 5L);

    // Assert
    BigInteger num = actualOfLongsResult.getNum();
    assertEquals("0", num.toString());
    assertEquals(-1, num.getLowestSetBit());
    assertEquals(0, num.signum());
    assertEquals(0, actualOfLongsResult.signum());
    assertArrayEquals(new byte[]{0}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualOfLongsResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#ofLong(long)}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return Num toString is {@code 9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofLong(long)}
   */
  @Test
  public void testOfLong_whenMax_value_thenReturnNumToStringIs9223372036854775807() {
    // Arrange and Act
    Rational actualOfLongResult = Rational.ofLong(Long.MAX_VALUE);

    // Assert
    BigInteger num = actualOfLongResult.getNum();
    assertEquals("9223372036854775807", num.toString());
    assertEquals(1, num.signum());
    assertArrayEquals(new byte[]{1}, actualOfLongResult.getDen().toByteArray());
    assertArrayEquals(new byte[]{Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1}, num.toByteArray());
  }

  /**
   * Test {@link Rational#ofLong(long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return Num toString is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofLong(long)}
   */
  @Test
  public void testOfLong_whenMinusOne_thenReturnNumToStringIs1() {
    // Arrange and Act
    Rational actualOfLongResult = Rational.ofLong(-1L);

    // Assert
    BigInteger num = actualOfLongResult.getNum();
    assertEquals("-1", num.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, actualOfLongResult.signum());
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualOfLongResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#ofLong(long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Den toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofLong(long)}
   */
  @Test
  public void testOfLong_whenOne_thenReturnDenToStringIs1() {
    // Arrange and Act
    Rational actualOfLongResult = Rational.ofLong(1L);

    // Assert
    BigInteger den = actualOfLongResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(1, den.signum());
    assertEquals(1, actualOfLongResult.signum());
    assertTrue(actualOfLongResult.isIntegral());
    assertSame(den, actualOfLongResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link Rational#ofLong(long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return Num toString is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofLong(long)}
   */
  @Test
  public void testOfLong_whenZero_thenReturnNumToStringIs0() {
    // Arrange and Act
    Rational actualOfLongResult = Rational.ofLong(0L);

    // Assert
    BigInteger num = actualOfLongResult.getNum();
    assertEquals("0", num.toString());
    assertEquals(-1, num.getLowestSetBit());
    assertEquals(0, num.signum());
    assertEquals(0, actualOfLongResult.signum());
    assertArrayEquals(new byte[]{0}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualOfLongResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#ofBigInteger(BigInteger)}.
   * <ul>
   *   <li>When valueOf {@link Long#MAX_VALUE}.</li>
   *   <li>Then return signum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofBigInteger(BigInteger)}
   */
  @Test
  public void testOfBigInteger_whenValueOfMax_value_thenReturnSignumIsOne() {
    // Arrange
    BigInteger numerator = BigInteger.valueOf(Long.MAX_VALUE);

    // Act
    Rational actualOfBigIntegerResult = Rational.ofBigInteger(numerator);

    // Assert
    assertEquals(1, actualOfBigIntegerResult.signum());
    assertEquals(numerator, actualOfBigIntegerResult.getNum());
    assertArrayEquals(new byte[]{1}, actualOfBigIntegerResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#ofBigInteger(BigInteger)}.
   * <ul>
   *   <li>When valueOf minus one.</li>
   *   <li>Then return signum is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofBigInteger(BigInteger)}
   */
  @Test
  public void testOfBigInteger_whenValueOfMinusOne_thenReturnSignumIsMinusOne() {
    // Arrange
    BigInteger numerator = BigInteger.valueOf(-1L);

    // Act
    Rational actualOfBigIntegerResult = Rational.ofBigInteger(numerator);

    // Assert
    assertEquals(-1, actualOfBigIntegerResult.signum());
    assertEquals(numerator, actualOfBigIntegerResult.getNum());
    BigInteger expectedDen = numerator.ONE;
    BigInteger den = actualOfBigIntegerResult.getDen();
    assertSame(expectedDen, den);
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link Rational#ofBigInteger(BigInteger)}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then return Den is valueOf one {@link BigInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofBigInteger(BigInteger)}
   */
  @Test
  public void testOfBigInteger_whenValueOfOne_thenReturnDenIsValueOfOneOne() {
    // Arrange
    BigInteger numerator = BigInteger.valueOf(1L);

    // Act
    Rational actualOfBigIntegerResult = Rational.ofBigInteger(numerator);

    // Assert
    BigInteger bigInteger = numerator.ONE;
    assertSame(bigInteger, actualOfBigIntegerResult.getDen());
    assertSame(bigInteger, actualOfBigIntegerResult.getNum());
  }

  /**
   * Test {@link Rational#ofBigInteger(BigInteger)}.
   * <ul>
   *   <li>When valueOf zero.</li>
   *   <li>Then return signum is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofBigInteger(BigInteger)}
   */
  @Test
  public void testOfBigInteger_whenValueOfZero_thenReturnSignumIsZero() {
    // Arrange
    BigInteger numerator = BigInteger.valueOf(0L);

    // Act
    Rational actualOfBigIntegerResult = Rational.ofBigInteger(numerator);

    // Assert
    assertEquals(0, actualOfBigIntegerResult.signum());
    BigInteger expectedDen = numerator.ONE;
    BigInteger den = actualOfBigIntegerResult.getDen();
    assertSame(expectedDen, den);
    BigInteger expectedNum = numerator.ZERO;
    assertSame(expectedNum, actualOfBigIntegerResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link Rational#ofString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Den toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofString(String)}
   */
  @Test
  public void testOfString_when42_thenReturnDenToStringIs1() {
    // Arrange and Act
    Rational actualOfStringResult = Rational.ofString("42");

    // Assert
    BigInteger den = actualOfStringResult.getDen();
    assertEquals("1", den.toString());
    BigInteger num = actualOfStringResult.getNum();
    assertEquals("42", num.toString());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(1, num.getLowestSetBit());
    assertEquals(1, den.signum());
    assertEquals(1, num.signum());
    assertEquals(1, actualOfStringResult.signum());
    assertTrue(actualOfStringResult.isIntegral());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
    assertArrayEquals(new byte[]{'*'}, num.toByteArray());
  }

  /**
   * Test {@link Rational#ofBigDecimal(BigDecimal)}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return Den toString is {@code 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofBigDecimal(BigDecimal)}
   */
  @Test
  public void testOfBigDecimal_whenBigDecimalWith23_thenReturnDenToStringIs10() {
    // Arrange and Act
    Rational actualOfBigDecimalResult = Rational.ofBigDecimal(new BigDecimal("2.3"));

    // Assert
    BigInteger den = actualOfBigDecimalResult.getDen();
    assertEquals("10", den.toString());
    BigInteger num = actualOfBigDecimalResult.getNum();
    assertEquals("23", num.toString());
    assertEquals(1, den.getLowestSetBit());
    assertFalse(actualOfBigDecimalResult.isIntegral());
    assertArrayEquals(new byte[]{23}, num.toByteArray());
    assertArrayEquals(new byte[]{'\n'}, den.toByteArray());
  }

  /**
   * Test {@link Rational#ofBigDecimal(BigDecimal)}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 42}.</li>
   *   <li>Then return Num toString is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofBigDecimal(BigDecimal)}
   */
  @Test
  public void testOfBigDecimal_whenBigDecimalWith42_thenReturnNumToStringIs42() {
    // Arrange and Act
    Rational actualOfBigDecimalResult = Rational.ofBigDecimal(new BigDecimal("42"));

    // Assert
    BigInteger num = actualOfBigDecimalResult.getNum();
    assertEquals("42", num.toString());
    assertEquals(1, num.getLowestSetBit());
    assertArrayEquals(new byte[]{1}, actualOfBigDecimalResult.getDen().toByteArray());
    assertArrayEquals(new byte[]{'*'}, num.toByteArray());
  }

  /**
   * Test {@link Rational#ofBigDecimal(BigDecimal)}.
   * <ul>
   *   <li>When valueOf minus one.</li>
   *   <li>Then return Num toString is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofBigDecimal(BigDecimal)}
   */
  @Test
  public void testOfBigDecimal_whenValueOfMinusOne_thenReturnNumToStringIs1() {
    // Arrange and Act
    Rational actualOfBigDecimalResult = Rational.ofBigDecimal(BigDecimal.valueOf(-1L));

    // Assert
    BigInteger num = actualOfBigDecimalResult.getNum();
    assertEquals("-1", num.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, actualOfBigDecimalResult.signum());
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualOfBigDecimalResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#ofBigDecimal(BigDecimal)}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then return Den toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofBigDecimal(BigDecimal)}
   */
  @Test
  public void testOfBigDecimal_whenValueOfOne_thenReturnDenToStringIs1() {
    // Arrange and Act
    Rational actualOfBigDecimalResult = Rational.ofBigDecimal(BigDecimal.valueOf(1L));

    // Assert
    BigInteger den = actualOfBigDecimalResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(1, actualOfBigDecimalResult.signum());
    assertTrue(actualOfBigDecimalResult.isIntegral());
    assertSame(den, actualOfBigDecimalResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link Rational#ofBigDecimal(BigDecimal)}.
   * <ul>
   *   <li>When valueOf zero.</li>
   *   <li>Then return Num toString is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#ofBigDecimal(BigDecimal)}
   */
  @Test
  public void testOfBigDecimal_whenValueOfZero_thenReturnNumToStringIs0() {
    // Arrange and Act
    Rational actualOfBigDecimalResult = Rational.ofBigDecimal(BigDecimal.valueOf(0L));

    // Assert
    BigInteger num = actualOfBigDecimalResult.getNum();
    assertEquals("0", num.toString());
    assertEquals(-1, num.getLowestSetBit());
    assertEquals(0, num.signum());
    assertEquals(0, actualOfBigDecimalResult.signum());
    assertArrayEquals(new byte[]{0}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualOfBigDecimalResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#times(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link Rational#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#times(Rational)}
   */
  @Test
  public void testTimes_givenNeg_one_whenNeg_one_thenReturnOne() {
    // Arrange and Act
    Rational actualTimesResult = Rational.NEG_ONE.times(Rational.NEG_ONE);

    // Assert
    assertSame(actualTimesResult.ONE, actualTimesResult);
  }

  /**
   * Test {@link Rational#times(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   *   <li>When {@link Rational#ONE}.</li>
   *   <li>Then return {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#times(Rational)}
   */
  @Test
  public void testTimes_givenNeg_one_whenOne_thenReturnNeg_one() {
    // Arrange and Act
    Rational actualTimesResult = Rational.NEG_ONE.times(Rational.ONE);

    // Assert
    assertSame(actualTimesResult.NEG_ONE, actualTimesResult);
  }

  /**
   * Test {@link Rational#times(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   *   <li>When {@link Rational#ZERO}.</li>
   *   <li>Then return {@link Rational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#times(Rational)}
   */
  @Test
  public void testTimes_givenNeg_one_whenZero_thenReturnZero() {
    // Arrange and Act
    Rational actualTimesResult = Rational.NEG_ONE.times(Rational.ZERO);

    // Assert
    assertSame(actualTimesResult.ZERO, actualTimesResult);
  }

  /**
   * Test {@link Rational#times(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#ONE}.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#times(Rational)}
   */
  @Test
  public void testTimes_givenOne_whenNeg_one_thenReturnNeg_one() {
    // Arrange and Act
    Rational actualTimesResult = Rational.ONE.times(Rational.NEG_ONE);

    // Assert
    assertSame(actualTimesResult.NEG_ONE, actualTimesResult);
  }

  /**
   * Test {@link Rational#times(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#ZERO}.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link Rational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#times(Rational)}
   */
  @Test
  public void testTimes_givenZero_whenNeg_one_thenReturnZero() {
    // Arrange and Act
    Rational actualTimesResult = Rational.ZERO.times(Rational.NEG_ONE);

    // Assert
    assertSame(actualTimesResult.ZERO, actualTimesResult);
  }

  /**
   * Test {@link Rational#plus(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return Num toString is {@code -2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#plus(Rational)}
   */
  @Test
  public void testPlus_givenNeg_one_whenNeg_one_thenReturnNumToStringIs2() {
    // Arrange and Act
    Rational actualPlusResult = Rational.NEG_ONE.plus(Rational.NEG_ONE);

    // Assert
    BigInteger num = actualPlusResult.getNum();
    assertEquals("-2", num.toString());
    assertEquals(1, num.getLowestSetBit());
    assertArrayEquals(new byte[]{-2}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualPlusResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#plus(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   *   <li>When {@link Rational#ZERO}.</li>
   *   <li>Then return {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#plus(Rational)}
   */
  @Test
  public void testPlus_givenNeg_one_whenZero_thenReturnNeg_one() {
    // Arrange and Act
    Rational actualPlusResult = Rational.NEG_ONE.plus(Rational.ZERO);

    // Assert
    assertSame(actualPlusResult.NEG_ONE, actualPlusResult);
  }

  /**
   * Test {@link Rational#plus(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#ONE}.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link Rational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#plus(Rational)}
   */
  @Test
  public void testPlus_givenOne_whenNeg_one_thenReturnZero() {
    // Arrange and Act
    Rational actualPlusResult = Rational.ONE.plus(Rational.NEG_ONE);

    // Assert
    assertSame(actualPlusResult.ZERO, actualPlusResult);
  }

  /**
   * Test {@link Rational#plus(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#ZERO}.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#plus(Rational)}
   */
  @Test
  public void testPlus_givenZero_whenNeg_one_thenReturnNeg_one() {
    // Arrange and Act
    Rational actualPlusResult = Rational.ZERO.plus(Rational.NEG_ONE);

    // Assert
    assertSame(actualPlusResult.NEG_ONE, actualPlusResult);
  }

  /**
   * Test {@link Rational#minus(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link Rational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#minus(Rational)}
   */
  @Test
  public void testMinus_givenNeg_one_whenNeg_one_thenReturnZero() {
    // Arrange and Act
    Rational actualMinusResult = Rational.NEG_ONE.minus(Rational.NEG_ONE);

    // Assert
    assertSame(actualMinusResult.ZERO, actualMinusResult);
  }

  /**
   * Test {@link Rational#minus(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   *   <li>When {@link Rational#ONE}.</li>
   *   <li>Then return Num toString is {@code -2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#minus(Rational)}
   */
  @Test
  public void testMinus_givenNeg_one_whenOne_thenReturnNumToStringIs2() {
    // Arrange and Act
    Rational actualMinusResult = Rational.NEG_ONE.minus(Rational.ONE);

    // Assert
    BigInteger num = actualMinusResult.getNum();
    assertEquals("-2", num.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, actualMinusResult.signum());
    assertEquals(1, num.getLowestSetBit());
    assertArrayEquals(new byte[]{-2}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualMinusResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#minus(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   *   <li>When {@link Rational#ZERO}.</li>
   *   <li>Then return {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#minus(Rational)}
   */
  @Test
  public void testMinus_givenNeg_one_whenZero_thenReturnNeg_one() {
    // Arrange and Act
    Rational actualMinusResult = Rational.NEG_ONE.minus(Rational.ZERO);

    // Assert
    assertSame(actualMinusResult.NEG_ONE, actualMinusResult);
  }

  /**
   * Test {@link Rational#minus(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#ONE}.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return Num toString is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#minus(Rational)}
   */
  @Test
  public void testMinus_givenOne_whenNeg_one_thenReturnNumToStringIs2() {
    // Arrange and Act
    Rational actualMinusResult = Rational.ONE.minus(Rational.NEG_ONE);

    // Assert
    BigInteger num = actualMinusResult.getNum();
    assertEquals("2", num.toString());
    assertEquals(1, num.signum());
    assertArrayEquals(new byte[]{1}, actualMinusResult.getDen().toByteArray());
    assertArrayEquals(new byte[]{2}, num.toByteArray());
  }

  /**
   * Test {@link Rational#minus(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#ZERO}.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link Rational#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#minus(Rational)}
   */
  @Test
  public void testMinus_givenZero_whenNeg_one_thenReturnOne() {
    // Arrange and Act
    Rational actualMinusResult = Rational.ZERO.minus(Rational.NEG_ONE);

    // Assert
    assertSame(actualMinusResult.ONE, actualMinusResult);
  }

  /**
   * Test {@link Rational#divides(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link Rational#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#divides(Rational)}
   */
  @Test
  public void testDivides_givenNeg_one_whenNeg_one_thenReturnOne() {
    // Arrange and Act
    Rational actualDividesResult = Rational.NEG_ONE.divides(Rational.NEG_ONE);

    // Assert
    assertSame(actualDividesResult.ONE, actualDividesResult);
  }

  /**
   * Test {@link Rational#divides(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   *   <li>When {@link Rational#ONE}.</li>
   *   <li>Then return {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#divides(Rational)}
   */
  @Test
  public void testDivides_givenNeg_one_whenOne_thenReturnNeg_one() {
    // Arrange and Act
    Rational actualDividesResult = Rational.NEG_ONE.divides(Rational.ONE);

    // Assert
    assertSame(actualDividesResult.NEG_ONE, actualDividesResult);
  }

  /**
   * Test {@link Rational#divides(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#ONE}.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#divides(Rational)}
   */
  @Test
  public void testDivides_givenOne_whenNeg_one_thenReturnNeg_one() {
    // Arrange and Act
    Rational actualDividesResult = Rational.ONE.divides(Rational.NEG_ONE);

    // Assert
    assertSame(actualDividesResult.NEG_ONE, actualDividesResult);
  }

  /**
   * Test {@link Rational#divides(Rational)}.
   * <ul>
   *   <li>Given {@link Rational#ZERO}.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link Rational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#divides(Rational)}
   */
  @Test
  public void testDivides_givenZero_whenNeg_one_thenReturnZero() {
    // Arrange and Act
    Rational actualDividesResult = Rational.ZERO.divides(Rational.NEG_ONE);

    // Assert
    assertSame(actualDividesResult.ZERO, actualDividesResult);
  }

  /**
   * Test {@link Rational#reciprocal()}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#reciprocal()}
   */
  @Test
  public void testReciprocal_givenNeg_one_thenReturnNeg_one() {
    // Arrange and Act
    Rational actualReciprocalResult = Rational.NEG_ONE.reciprocal();

    // Assert
    assertSame(actualReciprocalResult.NEG_ONE, actualReciprocalResult);
  }

  /**
   * Test {@link Rational#reciprocal()}.
   * <ul>
   *   <li>Given {@link Rational#ONE}.</li>
   *   <li>Then return {@link Rational#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#reciprocal()}
   */
  @Test
  public void testReciprocal_givenOne_thenReturnOne() {
    // Arrange and Act
    Rational actualReciprocalResult = Rational.ONE.reciprocal();

    // Assert
    assertSame(actualReciprocalResult.ONE, actualReciprocalResult);
  }

  /**
   * Test {@link Rational#negate()}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link Rational#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#negate()}
   */
  @Test
  public void testNegate_givenNeg_one_thenReturnOne() {
    // Arrange and Act
    Rational actualNegateResult = Rational.NEG_ONE.negate();

    // Assert
    assertSame(actualNegateResult.ONE, actualNegateResult);
  }

  /**
   * Test {@link Rational#negate()}.
   * <ul>
   *   <li>Given {@link Rational#ONE}.</li>
   *   <li>Then return {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#negate()}
   */
  @Test
  public void testNegate_givenOne_thenReturnNeg_one() {
    // Arrange and Act
    Rational actualNegateResult = Rational.ONE.negate();

    // Assert
    assertSame(actualNegateResult.NEG_ONE, actualNegateResult);
  }

  /**
   * Test {@link Rational#negate()}.
   * <ul>
   *   <li>Given {@link Rational#ZERO}.</li>
   *   <li>Then return {@link Rational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#negate()}
   */
  @Test
  public void testNegate_givenZero_thenReturnZero() {
    // Arrange and Act
    Rational actualNegateResult = Rational.ZERO.negate();

    // Assert
    assertSame(actualNegateResult.ZERO, actualNegateResult);
  }

  /**
   * Test {@link Rational#doubleValue()}.
   * <p>
   * Method under test: {@link Rational#doubleValue()}
   */
  @Test
  public void testDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(-1.0d, Rational.NEG_ONE.doubleValue(), 0.0);
  }

  /**
   * Test {@link Rational#isIntegral()}.
   * <p>
   * Method under test: {@link Rational#isIntegral()}
   */
  @Test
  public void testIsIntegral() {
    // Arrange, Act and Assert
    assertTrue(Rational.NEG_ONE.isIntegral());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Rational#getDen()}
   *   <li>{@link Rational#getNum()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Rational rational = Rational.NEG_ONE;

    // Act
    BigInteger actualDen = rational.getDen();
    BigInteger actualNum = rational.getNum();

    // Assert
    assertEquals("-1", actualNum.toString());
    assertEquals(-1, actualNum.signum());
    assertEquals(0, actualNum.getLowestSetBit());
    assertSame(actualNum.ONE, actualDen);
    assertArrayEquals(new byte[]{-1}, actualNum.toByteArray());
  }

  /**
   * Test {@link Rational#signum()}.
   * <p>
   * Method under test: {@link Rational#signum()}
   */
  @Test
  public void testSignum() {
    // Arrange, Act and Assert
    assertEquals(-1, Rational.NEG_ONE.signum());
  }

  /**
   * Test {@link Rational#abs()}.
   * <ul>
   *   <li>Given {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#abs()}
   */
  @Test
  public void testAbs_givenNeg_one() {
    // Arrange and Act
    Rational actualAbsResult = Rational.NEG_ONE.abs();

    // Assert
    assertSame(actualAbsResult.ONE, actualAbsResult);
  }

  /**
   * Test {@link Rational#abs()}.
   * <ul>
   *   <li>Given {@link Rational#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#abs()}
   */
  @Test
  public void testAbs_givenOne() {
    // Arrange and Act
    Rational actualAbsResult = Rational.ONE.abs();

    // Assert
    assertSame(actualAbsResult.ONE, actualAbsResult);
  }

  /**
   * Test {@link Rational#toString()}.
   * <p>
   * Method under test: {@link Rational#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("-1", Rational.NEG_ONE.toString());
  }

  /**
   * Test {@link Rational#compareTo(Rational)} with {@code b}.
   * <p>
   * Method under test: {@link Rational#compareTo(Rational)}
   */
  @Test
  public void testCompareToWithB() {
    // Arrange, Act and Assert
    assertEquals(0, Rational.NEG_ONE.compareTo(Rational.NEG_ONE));
  }

  /**
   * Test {@link Rational#equals(Object)}, and {@link Rational#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Rational#equals(Object)}
   *   <li>{@link Rational#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Rational rational = Rational.NEG_ONE;
    Rational rational2 = Rational.NEG_ONE;

    // Act and Assert
    assertEquals(rational, rational2);
    int expectedHashCodeResult = rational.hashCode();
    assertEquals(expectedHashCodeResult, rational2.hashCode());
  }

  /**
   * Test {@link Rational#equals(Object)}, and {@link Rational#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Rational#equals(Object)}
   *   <li>{@link Rational#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Rational rational = Rational.NEG_ONE;

    // Act and Assert
    assertEquals(rational, rational);
    int expectedHashCodeResult = rational.hashCode();
    assertEquals(expectedHashCodeResult, rational.hashCode());
  }

  /**
   * Test {@link Rational#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Rational.ONE, Rational.NEG_ONE);
  }

  /**
   * Test {@link Rational#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Rational.NEG_ONE, null);
  }

  /**
   * Test {@link Rational#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Rational.NEG_ONE, "Different type to Rational");
  }

  /**
   * Test {@link Rational#max(Rational, Rational)}.
   * <ul>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return Num toString is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#max(Rational, Rational)}
   */
  @Test
  public void testMax_whenNeg_one_thenReturnNumToStringIs1() {
    // Arrange and Act
    Rational actualMaxResult = Rational.max(Rational.NEG_ONE, Rational.NEG_ONE);

    // Assert
    BigInteger num = actualMaxResult.getNum();
    assertEquals("-1", num.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, actualMaxResult.signum());
    assertEquals(0, num.getLowestSetBit());
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualMaxResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#max(Rational, Rational)}.
   * <ul>
   *   <li>When {@link Rational#ONE}.</li>
   *   <li>Then return Den toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#max(Rational, Rational)}
   */
  @Test
  public void testMax_whenOne_thenReturnDenToStringIs1() {
    // Arrange and Act
    Rational actualMaxResult = Rational.max(Rational.ONE, Rational.NEG_ONE);

    // Assert
    BigInteger den = actualMaxResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(1, den.signum());
    assertEquals(1, actualMaxResult.signum());
    assertTrue(actualMaxResult.isIntegral());
    assertSame(den, actualMaxResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link Rational#max(Rational, Rational)}.
   * <ul>
   *   <li>When {@link Rational#ONE}.</li>
   *   <li>Then return Den toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#max(Rational, Rational)}
   */
  @Test
  public void testMax_whenOne_thenReturnDenToStringIs12() {
    // Arrange and Act
    Rational actualMaxResult = Rational.max(Rational.NEG_ONE, Rational.ONE);

    // Assert
    BigInteger den = actualMaxResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(1, den.signum());
    assertEquals(1, actualMaxResult.signum());
    assertTrue(actualMaxResult.isIntegral());
    assertSame(den, actualMaxResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link Rational#max(Rational, Rational)}.
   * <ul>
   *   <li>When {@link Rational#ONE}.</li>
   *   <li>Then return Den toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#max(Rational, Rational)}
   */
  @Test
  public void testMax_whenOne_thenReturnDenToStringIs13() {
    // Arrange and Act
    Rational actualMaxResult = Rational.max(Rational.ONE, Rational.ONE);

    // Assert
    BigInteger den = actualMaxResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(1, den.signum());
    assertEquals(1, actualMaxResult.signum());
    assertTrue(actualMaxResult.isIntegral());
    assertSame(den, actualMaxResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link Rational#max(Rational, Rational)}.
   * <ul>
   *   <li>When {@link Rational#ZERO}.</li>
   *   <li>Then return Num toString is {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Rational#max(Rational, Rational)}
   */
  @Test
  public void testMax_whenZero_thenReturnNumToStringIs0() {
    // Arrange and Act
    Rational actualMaxResult = Rational.max(Rational.ZERO, Rational.NEG_ONE);

    // Assert
    BigInteger num = actualMaxResult.getNum();
    assertEquals("0", num.toString());
    assertEquals(-1, num.getLowestSetBit());
    assertEquals(0, num.signum());
    assertEquals(0, actualMaxResult.signum());
    assertArrayEquals(new byte[]{0}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, actualMaxResult.getDen().toByteArray());
  }

  /**
   * Test {@link Rational#intValue()}.
   * <p>
   * Method under test: {@link Rational#intValue()}
   */
  @Test
  public void testIntValue() {
    // Arrange, Act and Assert
    assertEquals(-1, Rational.NEG_ONE.intValue());
  }

  /**
   * Test {@link Rational#longValue()}.
   * <p>
   * Method under test: {@link Rational#longValue()}
   */
  @Test
  public void testLongValue() {
    // Arrange, Act and Assert
    assertEquals(-1L, Rational.NEG_ONE.longValue());
  }

  /**
   * Test {@link Rational#floatValue()}.
   * <p>
   * Method under test: {@link Rational#floatValue()}
   */
  @Test
  public void testFloatValue() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, Rational.NEG_ONE.floatValue(), 0.0f);
  }
}
