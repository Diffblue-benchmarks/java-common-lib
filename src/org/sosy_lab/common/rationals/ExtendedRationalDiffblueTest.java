package org.sosy_lab.common.rationals;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import org.junit.Test;

public class ExtendedRationalDiffblueTest {
  /**
   * Test {@link ExtendedRational#ExtendedRational(Rational)}.
   * <ul>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return Rational.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#ExtendedRational(Rational)}
   */
  @Test
  public void testNewExtendedRational_whenNeg_one_thenReturnRational() {
    // Arrange
    Rational pRational = Rational.NEG_ONE;

    // Act
    ExtendedRational actualExtendedRational = new ExtendedRational(pRational);

    // Assert
    assertTrue(actualExtendedRational.isRational());
    assertEquals(actualExtendedRational, actualExtendedRational.reciprocal());
    Rational expectedRational = pRational.NEG_ONE;
    assertSame(expectedRational, actualExtendedRational.getRational());
  }

  /**
   * Test {@link ExtendedRational#toDouble()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link Double#POSITIVE_INFINITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#toDouble()}
   */
  @Test
  public void testToDouble_givenInfty_thenReturnPositive_infinity() {
    // Arrange, Act and Assert
    assertEquals(Double.POSITIVE_INFINITY, ExtendedRational.INFTY.toDouble(), 0.0);
  }

  /**
   * Test {@link ExtendedRational#toDouble()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NaN}.</li>
   *   <li>Then return {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#toDouble()}
   */
  @Test
  public void testToDouble_givenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Double.NaN, ExtendedRational.NaN.toDouble(), 0.0);
  }

  /**
   * Test {@link ExtendedRational#toDouble()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then return {@link Double#NEGATIVE_INFINITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#toDouble()}
   */
  @Test
  public void testToDouble_givenNeg_infty_thenReturnNegative_infinity() {
    // Arrange, Act and Assert
    assertEquals(Double.NEGATIVE_INFINITY, ExtendedRational.NEG_INFTY.toDouble(), 0.0);
  }

  /**
   * Test {@link ExtendedRational#toDouble()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#toDouble()}
   */
  @Test
  public void testToDouble_givenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, ExtendedRational.ZERO.toDouble(), 0.0);
  }

  /**
   * Test {@link ExtendedRational#toString()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@code Infinity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#toString()}
   */
  @Test
  public void testToString_givenInfty_thenReturnInfinity() {
    // Arrange, Act and Assert
    assertEquals("Infinity", ExtendedRational.INFTY.toString());
  }

  /**
   * Test {@link ExtendedRational#toString()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NaN}.</li>
   *   <li>Then return {@code NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#toString()}
   */
  @Test
  public void testToString_givenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals("NaN", ExtendedRational.NaN.toString());
  }

  /**
   * Test {@link ExtendedRational#toString()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then return {@code -Infinity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#toString()}
   */
  @Test
  public void testToString_givenNeg_infty_thenReturnInfinity() {
    // Arrange, Act and Assert
    assertEquals("-Infinity", ExtendedRational.NEG_INFTY.toString());
  }

  /**
   * Test {@link ExtendedRational#toString()}.
   * <ul>
   *   <li>Given ofString {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#toString()}
   */
  @Test
  public void testToString_givenOfString42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", ExtendedRational.ofString("42").toString());
  }

  /**
   * Test {@link ExtendedRational#toString()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>Then return {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#toString()}
   */
  @Test
  public void testToString_givenZero_thenReturn0() {
    // Arrange, Act and Assert
    assertEquals("0", ExtendedRational.ZERO.toString());
  }

  /**
   * Test {@link ExtendedRational#ofString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Rational Den toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#ofString(String)}
   */
  @Test
  public void testOfString_when42_thenReturnRationalDenToStringIs1() {
    // Arrange and Act
    ExtendedRational actualOfStringResult = ExtendedRational.ofString("42");

    // Assert
    Rational rational = actualOfStringResult.getRational();
    BigInteger den = rational.getDen();
    assertEquals("1", den.toString());
    BigInteger num = rational.getNum();
    assertEquals("42", num.toString());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(1, num.getLowestSetBit());
    assertEquals(1, den.signum());
    assertEquals(1, num.signum());
    ExtendedRational reciprocalResult = actualOfStringResult.reciprocal();
    Rational rational2 = reciprocalResult.getRational();
    assertEquals(1, rational2.signum());
    assertEquals(1, rational.signum());
    assertFalse(rational2.isIntegral());
    assertTrue(reciprocalResult.reciprocal().isRational());
    assertTrue(actualOfStringResult.isRational());
    assertTrue(rational.isIntegral());
    assertEquals(den, rational2.getNum());
    assertEquals(num, rational2.getDen());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
    assertArrayEquals(new byte[]{'*'}, num.toByteArray());
  }

  /**
   * Test {@link ExtendedRational#ofString(String)}.
   * <ul>
   *   <li>When {@code -Infinity}.</li>
   *   <li>Then return reciprocal is {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#ofString(String)}
   */
  @Test
  public void testOfString_whenInfinity_thenReturnReciprocalIsZero() {
    // Arrange and Act
    ExtendedRational actualOfStringResult = ExtendedRational.ofString("-Infinity");

    // Assert
    ExtendedRational expectedReciprocalResult = actualOfStringResult.ZERO;
    assertEquals(expectedReciprocalResult, actualOfStringResult.reciprocal());
  }

  /**
   * Test {@link ExtendedRational#ofString(String)}.
   * <ul>
   *   <li>When {@code Infinity}.</li>
   *   <li>Then return reciprocal is {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#ofString(String)}
   */
  @Test
  public void testOfString_whenInfinity_thenReturnReciprocalIsZero2() {
    // Arrange and Act
    ExtendedRational actualOfStringResult = ExtendedRational.ofString("Infinity");

    // Assert
    ExtendedRational expectedReciprocalResult = actualOfStringResult.ZERO;
    assertEquals(expectedReciprocalResult, actualOfStringResult.reciprocal());
  }

  /**
   * Test {@link ExtendedRational#ofString(String)}.
   * <ul>
   *   <li>When {@code NaN}.</li>
   *   <li>Then return not Rational.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#ofString(String)}
   */
  @Test
  public void testOfString_whenNaN_thenReturnNotRational() {
    // Arrange and Act
    ExtendedRational actualOfStringResult = ExtendedRational.ofString("NaN");

    // Assert
    assertFalse(actualOfStringResult.isRational());
    ExtendedRational expectedReciprocalResult = actualOfStringResult.NaN;
    assertSame(expectedReciprocalResult, actualOfStringResult.reciprocal());
  }

  /**
   * Test {@link ExtendedRational#isRational()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#isRational()}
   */
  @Test
  public void testIsRational_givenInfty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ExtendedRational.INFTY.isRational());
  }

  /**
   * Test {@link ExtendedRational#isRational()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#isRational()}
   */
  @Test
  public void testIsRational_givenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ExtendedRational.ZERO.isRational());
  }

  /**
   * Test {@link ExtendedRational#getRational()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#getRational()}
   */
  @Test
  public void testGetRational_givenInfty_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ExtendedRational.INFTY.getRational());
  }

  /**
   * Test {@link ExtendedRational#getRational()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>Then return {@link Rational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#getRational()}
   */
  @Test
  public void testGetRational_givenZero_thenReturnZero() {
    // Arrange and Act
    Rational actualRational = ExtendedRational.ZERO.getRational();

    // Assert
    assertSame(actualRational.ZERO, actualRational);
  }

  /**
   * Test {@link ExtendedRational#compareTo(ExtendedRational)} with {@code b}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#compareTo(ExtendedRational)}
   */
  @Test
  public void testCompareToWithB_givenInfty_whenInfty_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ExtendedRational.INFTY.compareTo(ExtendedRational.INFTY));
  }

  /**
   * Test {@link ExtendedRational#compareTo(ExtendedRational)} with {@code b}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return minus two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#compareTo(ExtendedRational)}
   */
  @Test
  public void testCompareToWithB_givenNeg_infty_whenInfty_thenReturnMinusTwo() {
    // Arrange, Act and Assert
    assertEquals(-2, ExtendedRational.NEG_INFTY.compareTo(ExtendedRational.INFTY));
  }

  /**
   * Test {@link ExtendedRational#compareTo(ExtendedRational)} with {@code b}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>When {@link ExtendedRational#ZERO}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#compareTo(ExtendedRational)}
   */
  @Test
  public void testCompareToWithB_givenZero_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ExtendedRational.ZERO.compareTo(ExtendedRational.ZERO));
  }

  /**
   * Test {@link ExtendedRational#equals(Object)}, and {@link ExtendedRational#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExtendedRational#equals(Object)}
   *   <li>{@link ExtendedRational#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;
    ExtendedRational extendedRational2 = ExtendedRational.INFTY;

    // Act and Assert
    assertEquals(extendedRational, extendedRational2);
    int expectedHashCodeResult = extendedRational.hashCode();
    assertEquals(expectedHashCodeResult, extendedRational2.hashCode());
  }

  /**
   * Test {@link ExtendedRational#equals(Object)}, and {@link ExtendedRational#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExtendedRational#equals(Object)}
   *   <li>{@link ExtendedRational#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.ZERO);
    ExtendedRational extendedRational2 = ExtendedRational.ZERO;

    // Act and Assert
    assertEquals(extendedRational, extendedRational2);
    int expectedHashCodeResult = extendedRational.hashCode();
    assertEquals(expectedHashCodeResult, extendedRational2.hashCode());
  }

  /**
   * Test {@link ExtendedRational#equals(Object)}, and {@link ExtendedRational#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExtendedRational#equals(Object)}
   *   <li>{@link ExtendedRational#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;

    // Act and Assert
    assertEquals(extendedRational, extendedRational);
    int expectedHashCodeResult = extendedRational.hashCode();
    assertEquals(expectedHashCodeResult, extendedRational.hashCode());
  }

  /**
   * Test {@link ExtendedRational#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExtendedRational.NEG_INFTY, ExtendedRational.INFTY);
  }

  /**
   * Test {@link ExtendedRational#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ExtendedRational(Rational.NEG_ONE), ExtendedRational.ZERO);
  }

  /**
   * Test {@link ExtendedRational#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExtendedRational.INFTY, null);
  }

  /**
   * Test {@link ExtendedRational#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExtendedRational.INFTY, "Different type to ExtendedRational");
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#NEG_ONE}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_givenExtendedRationalWithPRationalIsNeg_one_whenInfty_thenReturnInfty() {
    // Arrange
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualTimesResult = (new ExtendedRational(Rational.NEG_ONE)).times(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualTimesResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    assertSame(actualTimesResult.INFTY, actualTimesResult);
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_givenExtendedRationalWithPRationalIsOne() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.ONE);

    // Act
    ExtendedRational actualTimesResult = extendedRational.times(new ExtendedRational(Rational.NEG_ONE));

    // Assert
    Rational rational = actualTimesResult.getRational();
    ExtendedRational reciprocalResult = actualTimesResult.reciprocal();
    ExtendedRational reciprocalResult2 = reciprocalResult.reciprocal();
    ExtendedRational reciprocalResult3 = reciprocalResult2.reciprocal();
    ExtendedRational reciprocalResult4 = reciprocalResult3.reciprocal();
    ExtendedRational reciprocalResult5 = reciprocalResult4.reciprocal();
    ExtendedRational reciprocalResult6 = reciprocalResult5.reciprocal();
    ExtendedRational reciprocalResult7 = reciprocalResult6.reciprocal();
    assertSame(rational, reciprocalResult7.reciprocal().getRational());
    assertSame(rational, reciprocalResult7.getRational());
    assertSame(rational, reciprocalResult6.getRational());
    assertSame(rational, reciprocalResult5.getRational());
    assertSame(rational, reciprocalResult4.getRational());
    assertSame(rational, reciprocalResult3.getRational());
    assertSame(rational, reciprocalResult2.getRational());
    assertSame(rational, reciprocalResult.getRational());
    assertArrayEquals(new byte[]{-1}, rational.getNum().toByteArray());
    assertArrayEquals(new byte[]{1}, rational.getDen().toByteArray());
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#ZERO}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_givenExtendedRationalWithPRationalIsZero_whenInfty_thenReturnZero() {
    // Arrange and Act
    ExtendedRational actualTimesResult = (new ExtendedRational(Rational.ZERO)).times(ExtendedRational.INFTY);

    // Assert
    assertSame(actualTimesResult.ZERO, actualTimesResult);
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_givenInfty_whenInfty_thenReturnInfty() {
    // Arrange
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualTimesResult = ExtendedRational.INFTY.times(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualTimesResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    assertSame(actualTimesResult.INFTY, actualTimesResult);
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#NaN}.</li>
   *   <li>Then {@link ExtendedRational#NaN} reciprocal is {@link ExtendedRational#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_givenInfty_whenNaN_thenNaNReciprocalIsNaN() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;
    ExtendedRational b = ExtendedRational.NaN;

    // Act
    ExtendedRational actualTimesResult = extendedRational.times(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualTimesResult.ZERO;
    assertEquals(expectedReciprocalResult, extendedRational.reciprocal());
    ExtendedRational extendedRational2 = actualTimesResult.NaN;
    assertSame(extendedRational2, b.reciprocal());
    assertSame(extendedRational2, actualTimesResult);
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#NEG_INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_givenInfty_whenNeg_infty_thenReturnNeg_infty() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;
    ExtendedRational b = ExtendedRational.NEG_INFTY;

    // Act
    ExtendedRational actualTimesResult = extendedRational.times(b);

    // Assert
    ExtendedRational extendedRational2 = actualTimesResult.ZERO;
    assertEquals(extendedRational2, extendedRational.reciprocal());
    assertEquals(extendedRational2, b.reciprocal());
    assertSame(actualTimesResult.NEG_INFTY, actualTimesResult);
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#ZERO}.</li>
   *   <li>Then return {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_givenInfty_whenZero_thenReturnZero() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualTimesResult = extendedRational.times(ExtendedRational.ZERO);

    // Assert
    ExtendedRational extendedRational2 = actualTimesResult.ZERO;
    assertEquals(extendedRational2, extendedRational.reciprocal());
    assertSame(extendedRational2, actualTimesResult);
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NaN}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then {@link ExtendedRational#NaN} reciprocal is {@link ExtendedRational#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_givenNaN_whenInfty_thenNaNReciprocalIsNaN() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.NaN;
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualTimesResult = extendedRational.times(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualTimesResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    ExtendedRational extendedRational2 = actualTimesResult.NaN;
    assertSame(extendedRational2, extendedRational.reciprocal());
    assertSame(extendedRational2, actualTimesResult);
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#NEG_INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_givenNeg_infty_whenInfty_thenReturnNeg_infty() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.NEG_INFTY;
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualTimesResult = extendedRational.times(b);

    // Assert
    ExtendedRational extendedRational2 = actualTimesResult.ZERO;
    assertEquals(extendedRational2, b.reciprocal());
    assertEquals(extendedRational2, extendedRational.reciprocal());
    assertSame(actualTimesResult.NEG_INFTY, actualTimesResult);
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>When {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then {@link ExtendedRational#NEG_INFTY} reciprocal is {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_givenNeg_infty_whenNeg_infty_thenNeg_inftyReciprocalIsZero() {
    // Arrange
    ExtendedRational b = ExtendedRational.NEG_INFTY;

    // Act
    ExtendedRational actualTimesResult = ExtendedRational.NEG_INFTY.times(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualTimesResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    assertSame(actualTimesResult.INFTY, actualTimesResult);
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_givenZero_whenInfty_thenReturnZero() {
    // Arrange
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualTimesResult = ExtendedRational.ZERO.times(b);

    // Assert
    ExtendedRational extendedRational = actualTimesResult.ZERO;
    assertEquals(extendedRational, b.reciprocal());
    assertSame(extendedRational, actualTimesResult);
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>Then return Rational signum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_thenReturnRationalSignumIsOne() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.NEG_ONE);

    // Act
    ExtendedRational actualTimesResult = extendedRational.times(new ExtendedRational(Rational.NEG_ONE));

    // Assert
    Rational rational = actualTimesResult.getRational();
    assertEquals(1, rational.signum());
    assertEquals(actualTimesResult, actualTimesResult.reciprocal());
    BigInteger den = rational.getDen();
    assertSame(den, rational.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>When {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_whenExtendedRationalWithPRationalIsOne() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.NEG_ONE);

    // Act
    ExtendedRational actualTimesResult = extendedRational.times(new ExtendedRational(Rational.ONE));

    // Assert
    Rational rational = actualTimesResult.getRational();
    ExtendedRational reciprocalResult = actualTimesResult.reciprocal();
    ExtendedRational reciprocalResult2 = reciprocalResult.reciprocal();
    ExtendedRational reciprocalResult3 = reciprocalResult2.reciprocal();
    ExtendedRational reciprocalResult4 = reciprocalResult3.reciprocal();
    ExtendedRational reciprocalResult5 = reciprocalResult4.reciprocal();
    ExtendedRational reciprocalResult6 = reciprocalResult5.reciprocal();
    ExtendedRational reciprocalResult7 = reciprocalResult6.reciprocal();
    assertSame(rational, reciprocalResult7.reciprocal().getRational());
    assertSame(rational, reciprocalResult7.getRational());
    assertSame(rational, reciprocalResult6.getRational());
    assertSame(rational, reciprocalResult5.getRational());
    assertSame(rational, reciprocalResult4.getRational());
    assertSame(rational, reciprocalResult3.getRational());
    assertSame(rational, reciprocalResult2.getRational());
    assertSame(rational, reciprocalResult.getRational());
    assertArrayEquals(new byte[]{-1}, rational.getNum().toByteArray());
    assertArrayEquals(new byte[]{1}, rational.getDen().toByteArray());
  }

  /**
   * Test {@link ExtendedRational#times(ExtendedRational)}.
   * <ul>
   *   <li>When ofString {@code 42}.</li>
   *   <li>Then return Rational Num toString is {@code -42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#times(ExtendedRational)}
   */
  @Test
  public void testTimes_whenOfString42_thenReturnRationalNumToStringIs42() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.NEG_ONE);

    // Act
    ExtendedRational actualTimesResult = extendedRational.times(ExtendedRational.ofString("42"));

    // Assert
    Rational rational = actualTimesResult.getRational();
    BigInteger num = rational.getNum();
    assertEquals("-42", num.toString());
    ExtendedRational reciprocalResult = actualTimesResult.reciprocal();
    Rational rational2 = reciprocalResult.getRational();
    assertEquals(-1, rational2.signum());
    assertEquals(1, num.getLowestSetBit());
    assertFalse(rational2.isIntegral());
    assertEquals(actualTimesResult, reciprocalResult.reciprocal());
    assertArrayEquals(new byte[]{-42}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, rational.getDen().toByteArray());
  }

  /**
   * Test {@link ExtendedRational#plus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#ONE}.</li>
   *   <li>Then return {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#plus(ExtendedRational)}
   */
  @Test
  public void testPlus_givenExtendedRationalWithPRationalIsOne_thenReturnZero() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.ONE);

    // Act
    ExtendedRational actualPlusResult = extendedRational.plus(new ExtendedRational(Rational.NEG_ONE));

    // Assert
    assertEquals(actualPlusResult.ZERO, actualPlusResult);
  }

  /**
   * Test {@link ExtendedRational#plus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#plus(ExtendedRational)}
   */
  @Test
  public void testPlus_givenInfty_whenInfty_thenReturnInfty() {
    // Arrange
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualPlusResult = ExtendedRational.INFTY.plus(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualPlusResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    assertSame(actualPlusResult.INFTY, actualPlusResult);
  }

  /**
   * Test {@link ExtendedRational#plus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#NaN}.</li>
   *   <li>Then {@link ExtendedRational#NaN} reciprocal is {@link ExtendedRational#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#plus(ExtendedRational)}
   */
  @Test
  public void testPlus_givenInfty_whenNaN_thenNaNReciprocalIsNaN() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;
    ExtendedRational b = ExtendedRational.NaN;

    // Act
    ExtendedRational actualPlusResult = extendedRational.plus(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualPlusResult.ZERO;
    assertEquals(expectedReciprocalResult, extendedRational.reciprocal());
    ExtendedRational extendedRational2 = actualPlusResult.NaN;
    assertSame(extendedRational2, actualPlusResult);
    assertSame(extendedRational2, b.reciprocal());
  }

  /**
   * Test {@link ExtendedRational#plus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then {@link ExtendedRational#NEG_INFTY} reciprocal is {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#plus(ExtendedRational)}
   */
  @Test
  public void testPlus_givenInfty_whenNeg_infty_thenNeg_inftyReciprocalIsZero() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;
    ExtendedRational b = ExtendedRational.NEG_INFTY;

    // Act
    ExtendedRational actualPlusResult = extendedRational.plus(b);

    // Assert
    ExtendedRational extendedRational2 = actualPlusResult.ZERO;
    assertEquals(extendedRational2, extendedRational.reciprocal());
    assertEquals(extendedRational2, b.reciprocal());
    assertSame(actualPlusResult.NaN, actualPlusResult);
  }

  /**
   * Test {@link ExtendedRational#plus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NaN}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then {@link ExtendedRational#NaN} reciprocal is {@link ExtendedRational#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#plus(ExtendedRational)}
   */
  @Test
  public void testPlus_givenNaN_whenInfty_thenNaNReciprocalIsNaN() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.NaN;
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualPlusResult = extendedRational.plus(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualPlusResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    ExtendedRational extendedRational2 = actualPlusResult.NaN;
    assertSame(extendedRational2, actualPlusResult);
    assertSame(extendedRational2, extendedRational.reciprocal());
  }

  /**
   * Test {@link ExtendedRational#plus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then {@link ExtendedRational#NEG_INFTY} reciprocal is {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#plus(ExtendedRational)}
   */
  @Test
  public void testPlus_givenNeg_infty_whenInfty_thenNeg_inftyReciprocalIsZero() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.NEG_INFTY;
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualPlusResult = extendedRational.plus(b);

    // Assert
    ExtendedRational extendedRational2 = actualPlusResult.ZERO;
    assertEquals(extendedRational2, b.reciprocal());
    assertEquals(extendedRational2, extendedRational.reciprocal());
    assertSame(actualPlusResult.NaN, actualPlusResult);
  }

  /**
   * Test {@link ExtendedRational#plus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>When {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#NEG_INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#plus(ExtendedRational)}
   */
  @Test
  public void testPlus_givenNeg_infty_whenNeg_infty_thenReturnNeg_infty() {
    // Arrange
    ExtendedRational b = ExtendedRational.NEG_INFTY;

    // Act
    ExtendedRational actualPlusResult = ExtendedRational.NEG_INFTY.plus(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualPlusResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    assertSame(actualPlusResult.NEG_INFTY, actualPlusResult);
  }

  /**
   * Test {@link ExtendedRational#plus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#plus(ExtendedRational)}
   */
  @Test
  public void testPlus_givenZero_whenInfty_thenReturnInfty() {
    // Arrange
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualPlusResult = ExtendedRational.ZERO.plus(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualPlusResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    assertSame(actualPlusResult.INFTY, actualPlusResult);
  }

  /**
   * Test {@link ExtendedRational#plus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>When {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#NEG_INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#plus(ExtendedRational)}
   */
  @Test
  public void testPlus_givenZero_whenNeg_infty_thenReturnNeg_infty() {
    // Arrange
    ExtendedRational b = ExtendedRational.NEG_INFTY;

    // Act
    ExtendedRational actualPlusResult = ExtendedRational.ZERO.plus(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualPlusResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    assertSame(actualPlusResult.NEG_INFTY, actualPlusResult);
  }

  /**
   * Test {@link ExtendedRational#plus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>When {@link ExtendedRational#ZERO}.</li>
   *   <li>Then return {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#plus(ExtendedRational)}
   */
  @Test
  public void testPlus_givenZero_whenZero_thenReturnZero() {
    // Arrange and Act
    ExtendedRational actualPlusResult = ExtendedRational.ZERO.plus(ExtendedRational.ZERO);

    // Assert
    assertEquals(actualPlusResult.ZERO, actualPlusResult);
  }

  /**
   * Test {@link ExtendedRational#plus(ExtendedRational)}.
   * <ul>
   *   <li>Then return {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#plus(ExtendedRational)}
   */
  @Test
  public void testPlus_thenReturnExtendedRationalWithPRationalIsNeg_one() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.NEG_ONE);

    // Act and Assert
    assertEquals(extendedRational, extendedRational.plus(ExtendedRational.ZERO));
  }

  /**
   * Test {@link ExtendedRational#plus(ExtendedRational)}.
   * <ul>
   *   <li>Then return Rational Num toString is {@code -2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#plus(ExtendedRational)}
   */
  @Test
  public void testPlus_thenReturnRationalNumToStringIs2() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.NEG_ONE);

    // Act
    ExtendedRational actualPlusResult = extendedRational.plus(new ExtendedRational(Rational.NEG_ONE));

    // Assert
    Rational rational = actualPlusResult.getRational();
    BigInteger num = rational.getNum();
    assertEquals("-2", num.toString());
    ExtendedRational reciprocalResult = actualPlusResult.reciprocal();
    Rational rational2 = reciprocalResult.getRational();
    assertEquals(-1, rational2.signum());
    assertEquals(1, num.getLowestSetBit());
    assertFalse(rational2.isIntegral());
    assertEquals(actualPlusResult, reciprocalResult.reciprocal());
    assertArrayEquals(new byte[]{-2}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, rational.getDen().toByteArray());
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenExtendedRationalWithPRationalIsNeg_one_thenReturnZero() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.NEG_ONE);

    // Act
    ExtendedRational actualMinusResult = extendedRational.minus(new ExtendedRational(Rational.NEG_ONE));

    // Assert
    assertEquals(actualMinusResult.ZERO, actualMinusResult);
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link ExtendedRational#INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenInfty_whenExtendedRationalWithPRationalIsNeg_one_thenReturnInfty() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualMinusResult = extendedRational.minus(new ExtendedRational(Rational.NEG_ONE));

    // Assert
    ExtendedRational expectedReciprocalResult = actualMinusResult.ZERO;
    assertEquals(expectedReciprocalResult, extendedRational.reciprocal());
    assertSame(actualMinusResult.INFTY, actualMinusResult);
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#ONE}.</li>
   *   <li>Then return {@link ExtendedRational#INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenInfty_whenExtendedRationalWithPRationalIsOne_thenReturnInfty() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualMinusResult = extendedRational.minus(new ExtendedRational(Rational.ONE));

    // Assert
    ExtendedRational expectedReciprocalResult = actualMinusResult.ZERO;
    assertEquals(expectedReciprocalResult, extendedRational.reciprocal());
    assertSame(actualMinusResult.INFTY, actualMinusResult);
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenInfty_whenInfty_thenReturnNaN() {
    // Arrange
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualMinusResult = ExtendedRational.INFTY.minus(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualMinusResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    assertSame(actualMinusResult.NaN, actualMinusResult);
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#NaN}.</li>
   *   <li>Then {@link ExtendedRational#NaN} reciprocal is {@link ExtendedRational#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenInfty_whenNaN_thenNaNReciprocalIsNaN() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;
    ExtendedRational b = ExtendedRational.NaN;

    // Act
    ExtendedRational actualMinusResult = extendedRational.minus(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualMinusResult.ZERO;
    assertEquals(expectedReciprocalResult, extendedRational.reciprocal());
    ExtendedRational extendedRational2 = actualMinusResult.NaN;
    assertSame(extendedRational2, actualMinusResult);
    assertSame(extendedRational2, b.reciprocal());
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then {@link ExtendedRational#NEG_INFTY} reciprocal is {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenInfty_whenNeg_infty_thenNeg_inftyReciprocalIsZero() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;
    ExtendedRational b = ExtendedRational.NEG_INFTY;

    // Act
    ExtendedRational actualMinusResult = extendedRational.minus(b);

    // Assert
    ExtendedRational extendedRational2 = actualMinusResult.ZERO;
    assertEquals(extendedRational2, extendedRational.reciprocal());
    assertEquals(extendedRational2, b.reciprocal());
    assertSame(actualMinusResult.INFTY, actualMinusResult);
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#ZERO}.</li>
   *   <li>Then return {@link ExtendedRational#INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenInfty_whenZero_thenReturnInfty() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualMinusResult = extendedRational.minus(ExtendedRational.ZERO);

    // Assert
    ExtendedRational expectedReciprocalResult = actualMinusResult.ZERO;
    assertEquals(expectedReciprocalResult, extendedRational.reciprocal());
    assertSame(actualMinusResult.INFTY, actualMinusResult);
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NaN}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then {@link ExtendedRational#NaN} reciprocal is {@link ExtendedRational#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenNaN_whenInfty_thenNaNReciprocalIsNaN() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.NaN;
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualMinusResult = extendedRational.minus(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualMinusResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    ExtendedRational extendedRational2 = actualMinusResult.NaN;
    assertSame(extendedRational2, actualMinusResult);
    assertSame(extendedRational2, extendedRational.reciprocal());
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#NEG_INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenNeg_infty_whenInfty_thenReturnNeg_infty() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.NEG_INFTY;
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualMinusResult = extendedRational.minus(b);

    // Assert
    ExtendedRational extendedRational2 = actualMinusResult.ZERO;
    assertEquals(extendedRational2, b.reciprocal());
    assertEquals(extendedRational2, extendedRational.reciprocal());
    assertSame(actualMinusResult.NEG_INFTY, actualMinusResult);
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>When {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then {@link ExtendedRational#NEG_INFTY} reciprocal is {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenNeg_infty_whenNeg_infty_thenNeg_inftyReciprocalIsZero() {
    // Arrange
    ExtendedRational b = ExtendedRational.NEG_INFTY;

    // Act
    ExtendedRational actualMinusResult = ExtendedRational.NEG_INFTY.minus(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualMinusResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    assertSame(actualMinusResult.NaN, actualMinusResult);
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#NEG_INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenZero_whenInfty_thenReturnNeg_infty() {
    // Arrange
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualMinusResult = ExtendedRational.ZERO.minus(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualMinusResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    assertSame(actualMinusResult.NEG_INFTY, actualMinusResult);
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>When {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then {@link ExtendedRational#NEG_INFTY} reciprocal is {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenZero_whenNeg_infty_thenNeg_inftyReciprocalIsZero() {
    // Arrange
    ExtendedRational b = ExtendedRational.NEG_INFTY;

    // Act
    ExtendedRational actualMinusResult = ExtendedRational.ZERO.minus(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualMinusResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    assertSame(actualMinusResult.INFTY, actualMinusResult);
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>When {@link ExtendedRational#ZERO}.</li>
   *   <li>Then return {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_givenZero_whenZero_thenReturnZero() {
    // Arrange and Act
    ExtendedRational actualMinusResult = ExtendedRational.ZERO.minus(ExtendedRational.ZERO);

    // Assert
    assertEquals(actualMinusResult.ZERO, actualMinusResult);
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Then return {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_thenReturnExtendedRationalWithPRationalIsNeg_one() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.NEG_ONE);

    // Act and Assert
    assertEquals(extendedRational, extendedRational.minus(ExtendedRational.ZERO));
  }

  /**
   * Test {@link ExtendedRational#minus(ExtendedRational)}.
   * <ul>
   *   <li>Then return Rational Num toString is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#minus(ExtendedRational)}
   */
  @Test
  public void testMinus_thenReturnRationalNumToStringIs2() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.ONE);

    // Act
    ExtendedRational actualMinusResult = extendedRational.minus(new ExtendedRational(Rational.NEG_ONE));

    // Assert
    Rational rational = actualMinusResult.getRational();
    BigInteger num = rational.getNum();
    assertEquals("2", num.toString());
    assertEquals(1, num.getLowestSetBit());
    assertEquals(1, num.signum());
    assertEquals(1, rational.signum());
    ExtendedRational reciprocalResult = actualMinusResult.reciprocal();
    Rational rational2 = reciprocalResult.getRational();
    assertEquals(1, rational2.signum());
    assertFalse(rational2.isIntegral());
    assertEquals(actualMinusResult, reciprocalResult.reciprocal());
    BigInteger den = rational.getDen();
    assertEquals(den, rational2.getNum());
    assertEquals(num, rational2.getDen());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
    assertArrayEquals(new byte[]{2}, num.toByteArray());
  }

  /**
   * Test {@link ExtendedRational#divides(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#divides(ExtendedRational)}
   */
  @Test
  public void testDivides_givenExtendedRationalWithPRationalIsOne() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.ONE);

    // Act
    ExtendedRational actualDividesResult = extendedRational.divides(new ExtendedRational(Rational.NEG_ONE));

    // Assert
    Rational rational = actualDividesResult.getRational();
    ExtendedRational reciprocalResult = actualDividesResult.reciprocal();
    assertSame(rational, reciprocalResult.getRational());
    ExtendedRational reciprocalResult2 = reciprocalResult.reciprocal();
    assertSame(rational, reciprocalResult2.getRational());
    ExtendedRational reciprocalResult3 = reciprocalResult2.reciprocal();
    assertSame(rational, reciprocalResult3.getRational());
    ExtendedRational reciprocalResult4 = reciprocalResult3.reciprocal();
    assertSame(rational, reciprocalResult4.getRational());
    ExtendedRational reciprocalResult5 = reciprocalResult4.reciprocal();
    assertSame(rational, reciprocalResult5.getRational());
    ExtendedRational reciprocalResult6 = reciprocalResult5.reciprocal();
    assertSame(rational, reciprocalResult6.getRational());
    ExtendedRational reciprocalResult7 = reciprocalResult6.reciprocal();
    assertSame(rational, reciprocalResult7.getRational());
    assertSame(rational, reciprocalResult7.reciprocal().getRational());
    assertArrayEquals(new byte[]{-1}, rational.getNum().toByteArray());
    assertArrayEquals(new byte[]{1}, rational.getDen().toByteArray());
  }

  /**
   * Test {@link ExtendedRational#divides(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#divides(ExtendedRational)}
   */
  @Test
  public void testDivides_givenInfty_whenInfty_thenReturnZero() {
    // Arrange
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualDividesResult = ExtendedRational.INFTY.divides(b);

    // Assert
    ExtendedRational extendedRational = actualDividesResult.ZERO;
    assertEquals(extendedRational, b.reciprocal());
    assertSame(extendedRational, actualDividesResult);
  }

  /**
   * Test {@link ExtendedRational#divides(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#NaN}.</li>
   *   <li>Then return {@link ExtendedRational#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#divides(ExtendedRational)}
   */
  @Test
  public void testDivides_givenInfty_whenNaN_thenReturnNaN() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;
    ExtendedRational b = ExtendedRational.NaN;

    // Act
    ExtendedRational actualDividesResult = extendedRational.divides(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualDividesResult.ZERO;
    assertEquals(expectedReciprocalResult, extendedRational.reciprocal());
    ExtendedRational extendedRational2 = actualDividesResult.NaN;
    assertSame(extendedRational2, actualDividesResult);
    assertSame(extendedRational2, b.reciprocal());
  }

  /**
   * Test {@link ExtendedRational#divides(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then {@link ExtendedRational#NEG_INFTY} reciprocal is {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#divides(ExtendedRational)}
   */
  @Test
  public void testDivides_givenInfty_whenNeg_infty_thenNeg_inftyReciprocalIsZero() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;
    ExtendedRational b = ExtendedRational.NEG_INFTY;

    // Act
    ExtendedRational actualDividesResult = extendedRational.divides(b);

    // Assert
    ExtendedRational extendedRational2 = actualDividesResult.ZERO;
    assertEquals(extendedRational2, extendedRational.reciprocal());
    assertEquals(extendedRational2, b.reciprocal());
    assertSame(extendedRational2, actualDividesResult);
  }

  /**
   * Test {@link ExtendedRational#divides(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>When ofString {@code 42}.</li>
   *   <li>Then return {@link ExtendedRational#INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#divides(ExtendedRational)}
   */
  @Test
  public void testDivides_givenInfty_whenOfString42_thenReturnInfty() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualDividesResult = extendedRational.divides(ExtendedRational.ofString("42"));

    // Assert
    ExtendedRational expectedReciprocalResult = actualDividesResult.ZERO;
    assertEquals(expectedReciprocalResult, extendedRational.reciprocal());
    assertSame(actualDividesResult.INFTY, actualDividesResult);
  }

  /**
   * Test {@link ExtendedRational#divides(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NaN}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#divides(ExtendedRational)}
   */
  @Test
  public void testDivides_givenNaN_whenInfty_thenReturnNaN() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.NaN;
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualDividesResult = extendedRational.divides(b);

    // Assert
    ExtendedRational expectedReciprocalResult = actualDividesResult.ZERO;
    assertEquals(expectedReciprocalResult, b.reciprocal());
    ExtendedRational extendedRational2 = actualDividesResult.NaN;
    assertSame(extendedRational2, actualDividesResult);
    assertSame(extendedRational2, extendedRational.reciprocal());
  }

  /**
   * Test {@link ExtendedRational#divides(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#NEG_INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#divides(ExtendedRational)}
   */
  @Test
  public void testDivides_givenNeg_infty_thenReturnNeg_infty() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.NEG_INFTY;

    // Act
    ExtendedRational actualDividesResult = extendedRational.divides(new ExtendedRational(Rational.NEG_ONE));

    // Assert
    ExtendedRational expectedReciprocalResult = actualDividesResult.ZERO;
    assertEquals(expectedReciprocalResult, extendedRational.reciprocal());
    assertSame(actualDividesResult.NEG_INFTY, actualDividesResult);
  }

  /**
   * Test {@link ExtendedRational#divides(ExtendedRational)}.
   * <ul>
   *   <li>Given ofString {@code 42}.</li>
   *   <li>Then return Rational Num toString is {@code -42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#divides(ExtendedRational)}
   */
  @Test
  public void testDivides_givenOfString42_thenReturnRationalNumToStringIs42() {
    // Arrange
    ExtendedRational ofStringResult = ExtendedRational.ofString("42");

    // Act
    ExtendedRational actualDividesResult = ofStringResult.divides(new ExtendedRational(Rational.NEG_ONE));

    // Assert
    Rational rational = actualDividesResult.getRational();
    BigInteger num = rational.getNum();
    assertEquals("-42", num.toString());
    ExtendedRational reciprocalResult = actualDividesResult.reciprocal();
    Rational rational2 = reciprocalResult.getRational();
    assertEquals(-1, rational2.signum());
    assertEquals(1, num.getLowestSetBit());
    assertFalse(rational2.isIntegral());
    assertEquals(actualDividesResult, reciprocalResult.reciprocal());
    assertArrayEquals(new byte[]{-42}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, rational.getDen().toByteArray());
  }

  /**
   * Test {@link ExtendedRational#divides(ExtendedRational)}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>When {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#divides(ExtendedRational)}
   */
  @Test
  public void testDivides_givenZero_whenInfty_thenReturnZero() {
    // Arrange
    ExtendedRational b = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualDividesResult = ExtendedRational.ZERO.divides(b);

    // Assert
    ExtendedRational extendedRational = actualDividesResult.ZERO;
    assertEquals(extendedRational, b.reciprocal());
    assertSame(extendedRational, actualDividesResult);
  }

  /**
   * Test {@link ExtendedRational#divides(ExtendedRational)}.
   * <ul>
   *   <li>Then return Rational signum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#divides(ExtendedRational)}
   */
  @Test
  public void testDivides_thenReturnRationalSignumIsOne() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.NEG_ONE);

    // Act
    ExtendedRational actualDividesResult = extendedRational.divides(new ExtendedRational(Rational.NEG_ONE));

    // Assert
    Rational rational = actualDividesResult.getRational();
    assertEquals(1, rational.signum());
    assertEquals(actualDividesResult, actualDividesResult.reciprocal());
    BigInteger den = rational.getDen();
    assertSame(den, rational.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link ExtendedRational#divides(ExtendedRational)}.
   * <ul>
   *   <li>When {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@link ExtendedRational#INFTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#divides(ExtendedRational)}
   */
  @Test
  public void testDivides_whenExtendedRationalWithPRationalIsNeg_one_thenReturnInfty() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualDividesResult = extendedRational.divides(new ExtendedRational(Rational.NEG_ONE));

    // Assert
    ExtendedRational expectedReciprocalResult = actualDividesResult.ZERO;
    assertEquals(expectedReciprocalResult, extendedRational.reciprocal());
    assertSame(actualDividesResult.INFTY, actualDividesResult);
  }

  /**
   * Test {@link ExtendedRational#divides(ExtendedRational)}.
   * <ul>
   *   <li>When {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#divides(ExtendedRational)}
   */
  @Test
  public void testDivides_whenExtendedRationalWithPRationalIsOne() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.NEG_ONE);

    // Act
    ExtendedRational actualDividesResult = extendedRational.divides(new ExtendedRational(Rational.ONE));

    // Assert
    Rational rational = actualDividesResult.getRational();
    ExtendedRational reciprocalResult = actualDividesResult.reciprocal();
    assertSame(rational, reciprocalResult.getRational());
    ExtendedRational reciprocalResult2 = reciprocalResult.reciprocal();
    assertSame(rational, reciprocalResult2.getRational());
    ExtendedRational reciprocalResult3 = reciprocalResult2.reciprocal();
    assertSame(rational, reciprocalResult3.getRational());
    ExtendedRational reciprocalResult4 = reciprocalResult3.reciprocal();
    assertSame(rational, reciprocalResult4.getRational());
    ExtendedRational reciprocalResult5 = reciprocalResult4.reciprocal();
    assertSame(rational, reciprocalResult5.getRational());
    ExtendedRational reciprocalResult6 = reciprocalResult5.reciprocal();
    assertSame(rational, reciprocalResult6.getRational());
    ExtendedRational reciprocalResult7 = reciprocalResult6.reciprocal();
    assertSame(rational, reciprocalResult7.getRational());
    assertSame(rational, reciprocalResult7.reciprocal().getRational());
    assertArrayEquals(new byte[]{-1}, rational.getNum().toByteArray());
    assertArrayEquals(new byte[]{1}, rational.getDen().toByteArray());
  }

  /**
   * Test {@link ExtendedRational#reciprocal()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#reciprocal()}
   */
  @Test
  public void testReciprocal_givenInfty_thenReturnZero() {
    // Arrange and Act
    ExtendedRational actualReciprocalResult = ExtendedRational.INFTY.reciprocal();

    // Assert
    assertEquals(actualReciprocalResult.ZERO, actualReciprocalResult);
  }

  /**
   * Test {@link ExtendedRational#reciprocal()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NaN}.</li>
   *   <li>Then return {@link ExtendedRational#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#reciprocal()}
   */
  @Test
  public void testReciprocal_givenNaN_thenReturnNaN() {
    // Arrange and Act
    ExtendedRational actualReciprocalResult = ExtendedRational.NaN.reciprocal();

    // Assert
    assertSame(actualReciprocalResult.NaN, actualReciprocalResult);
  }

  /**
   * Test {@link ExtendedRational#reciprocal()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then return {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#reciprocal()}
   */
  @Test
  public void testReciprocal_givenNeg_infty_thenReturnZero() {
    // Arrange and Act
    ExtendedRational actualReciprocalResult = ExtendedRational.NEG_INFTY.reciprocal();

    // Assert
    assertEquals(actualReciprocalResult.ZERO, actualReciprocalResult);
  }

  /**
   * Test {@link ExtendedRational#reciprocal()}.
   * <ul>
   *   <li>Given ofString {@code 42}.</li>
   *   <li>Then return Rational Num toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#reciprocal()}
   */
  @Test
  public void testReciprocal_givenOfString42_thenReturnRationalNumToStringIs1() {
    // Arrange, Act and Assert
    Rational rational = ExtendedRational.ofString("42").reciprocal().getRational();
    BigInteger num = rational.getNum();
    assertEquals("1", num.toString());
    BigInteger den = rational.getDen();
    assertEquals("42", den.toString());
    assertEquals(1, den.getLowestSetBit());
    assertEquals(1, num.signum());
    assertFalse(rational.isIntegral());
    assertArrayEquals(new byte[]{1}, num.toByteArray());
    assertArrayEquals(new byte[]{'*'}, den.toByteArray());
  }

  /**
   * Test {@link ExtendedRational#reciprocal()}.
   * <ul>
   *   <li>Then return {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#reciprocal()}
   */
  @Test
  public void testReciprocal_thenReturnExtendedRationalWithPRationalIsNeg_one() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.NEG_ONE);

    // Act and Assert
    assertEquals(extendedRational, extendedRational.reciprocal());
  }

  /**
   * Test {@link ExtendedRational#reciprocal()}.
   * <ul>
   *   <li>Then return {@link ExtendedRational#ExtendedRational(Rational)} with pRational is {@link Rational#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#reciprocal()}
   */
  @Test
  public void testReciprocal_thenReturnExtendedRationalWithPRationalIsOne() {
    // Arrange
    ExtendedRational extendedRational = new ExtendedRational(Rational.ONE);

    // Act and Assert
    assertEquals(extendedRational, extendedRational.reciprocal());
  }

  /**
   * Test {@link ExtendedRational#negate()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#INFTY}.</li>
   *   <li>Then {@link ExtendedRational#INFTY} reciprocal is {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#negate()}
   */
  @Test
  public void testNegate_givenInfty_thenInftyReciprocalIsZero() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.INFTY;

    // Act
    ExtendedRational actualNegateResult = extendedRational.negate();

    // Assert
    ExtendedRational expectedReciprocalResult = actualNegateResult.ZERO;
    assertEquals(expectedReciprocalResult, extendedRational.reciprocal());
    assertSame(actualNegateResult.NEG_INFTY, actualNegateResult);
  }

  /**
   * Test {@link ExtendedRational#negate()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NaN}.</li>
   *   <li>Then return {@link ExtendedRational#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#negate()}
   */
  @Test
  public void testNegate_givenNaN_thenReturnNaN() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.NaN;

    // Act
    ExtendedRational actualNegateResult = extendedRational.negate();

    // Assert
    ExtendedRational extendedRational2 = actualNegateResult.NaN;
    assertSame(extendedRational2, actualNegateResult);
    assertSame(extendedRational2, extendedRational.reciprocal());
  }

  /**
   * Test {@link ExtendedRational#negate()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#NEG_INFTY}.</li>
   *   <li>Then {@link ExtendedRational#NEG_INFTY} reciprocal is {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#negate()}
   */
  @Test
  public void testNegate_givenNeg_infty_thenNeg_inftyReciprocalIsZero() {
    // Arrange
    ExtendedRational extendedRational = ExtendedRational.NEG_INFTY;

    // Act
    ExtendedRational actualNegateResult = extendedRational.negate();

    // Assert
    ExtendedRational expectedReciprocalResult = actualNegateResult.ZERO;
    assertEquals(expectedReciprocalResult, extendedRational.reciprocal());
    assertSame(actualNegateResult.INFTY, actualNegateResult);
  }

  /**
   * Test {@link ExtendedRational#negate()}.
   * <ul>
   *   <li>Given ofString {@code 42}.</li>
   *   <li>Then return Rational Num toString is {@code -42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#negate()}
   */
  @Test
  public void testNegate_givenOfString42_thenReturnRationalNumToStringIs42() {
    // Arrange and Act
    ExtendedRational actualNegateResult = ExtendedRational.ofString("42").negate();

    // Assert
    Rational rational = actualNegateResult.getRational();
    BigInteger num = rational.getNum();
    assertEquals("-42", num.toString());
    ExtendedRational reciprocalResult = actualNegateResult.reciprocal();
    Rational rational2 = reciprocalResult.getRational();
    assertEquals(-1, rational2.signum());
    assertEquals(1, num.getLowestSetBit());
    assertFalse(rational2.isIntegral());
    assertEquals(actualNegateResult, reciprocalResult.reciprocal());
    assertArrayEquals(new byte[]{-42}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, rational.getDen().toByteArray());
  }

  /**
   * Test {@link ExtendedRational#negate()}.
   * <ul>
   *   <li>Given {@link ExtendedRational#ZERO}.</li>
   *   <li>Then return {@link ExtendedRational#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#negate()}
   */
  @Test
  public void testNegate_givenZero_thenReturnZero() {
    // Arrange and Act
    ExtendedRational actualNegateResult = ExtendedRational.ZERO.negate();

    // Assert
    assertEquals(actualNegateResult.ZERO, actualNegateResult);
  }

  /**
   * Test {@link ExtendedRational#negate()}.
   * <ul>
   *   <li>Then return Rational Num toString is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#negate()}
   */
  @Test
  public void testNegate_thenReturnRationalNumToStringIs1() {
    // Arrange and Act
    ExtendedRational actualNegateResult = (new ExtendedRational(Rational.ONE)).negate();

    // Assert
    Rational rational = actualNegateResult.getRational();
    BigInteger num = rational.getNum();
    assertEquals("-1", num.toString());
    assertEquals(0, num.getLowestSetBit());
    assertEquals(actualNegateResult, actualNegateResult.reciprocal());
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, rational.getDen().toByteArray());
  }

  /**
   * Test {@link ExtendedRational#negate()}.
   * <ul>
   *   <li>Then return Rational signum is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExtendedRational#negate()}
   */
  @Test
  public void testNegate_thenReturnRationalSignumIsOne() {
    // Arrange and Act
    ExtendedRational actualNegateResult = (new ExtendedRational(Rational.NEG_ONE)).negate();

    // Assert
    Rational rational = actualNegateResult.getRational();
    assertEquals(1, rational.signum());
    assertEquals(actualNegateResult, actualNegateResult.reciprocal());
    BigInteger den = rational.getDen();
    assertSame(den, rational.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }
}
