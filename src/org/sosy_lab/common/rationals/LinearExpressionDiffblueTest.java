package org.sosy_lab.common.rationals;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.google.common.collect.ImmutableMap;
import java.math.BigInteger;
import org.junit.Test;

public class LinearExpressionDiffblueTest {
  /**
   * Test {@link LinearExpression#empty()}.
   * <p>
   * Method under test: {@link LinearExpression#empty()}
   */
  @Test
  public void testEmpty() {
    // Arrange and Act
    LinearExpression<Object> actualEmptyResult = LinearExpression.empty();

    // Assert
    assertEquals(0, actualEmptyResult.size());
    assertTrue(actualEmptyResult.getMap().isEmpty());
    assertTrue(actualEmptyResult.isEmpty());
  }

  /**
   * Test {@link LinearExpression#pair(Object, Rational)}.
   * <ul>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return Map size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#pair(Object, Rational)}
   */
  @Test
  public void testPair_whenNeg_one_thenReturnMapSizeIsOne() {
    // Arrange
    Rational coeff = Rational.NEG_ONE;

    // Act
    LinearExpression<Object> actualPairResult = LinearExpression.pair("Var", coeff);

    // Assert
    ImmutableMap<Object, Rational> map = actualPairResult.getMap();
    assertEquals(1, map.size());
    assertEquals(1, actualPairResult.size());
    assertFalse(actualPairResult.isEmpty());
    Rational expectedGetResult = coeff.NEG_ONE;
    assertSame(expectedGetResult, map.get("Var"));
  }

  /**
   * Test {@link LinearExpression#pair(Object, Rational)}.
   * <ul>
   *   <li>When {@link Rational#ZERO}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#pair(Object, Rational)}
   */
  @Test
  public void testPair_whenZero_thenReturnSizeIsZero() {
    // Arrange and Act
    LinearExpression<Object> actualPairResult = LinearExpression.pair("Var", Rational.ZERO);

    // Assert
    assertEquals(0, actualPairResult.size());
    assertTrue(actualPairResult.getMap().isEmpty());
    assertTrue(actualPairResult.isEmpty());
  }

  /**
   * Test {@link LinearExpression#monomial(Object, Rational)}.
   * <ul>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return Map size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#monomial(Object, Rational)}
   */
  @Test
  public void testMonomial_whenNeg_one_thenReturnMapSizeIsOne() {
    // Arrange
    Rational coeff = Rational.NEG_ONE;

    // Act
    LinearExpression<Object> actualMonomialResult = LinearExpression.monomial("Var", coeff);

    // Assert
    ImmutableMap<Object, Rational> map = actualMonomialResult.getMap();
    assertEquals(1, map.size());
    assertEquals(1, actualMonomialResult.size());
    assertFalse(actualMonomialResult.isEmpty());
    Rational expectedGetResult = coeff.NEG_ONE;
    assertSame(expectedGetResult, map.get("Var"));
  }

  /**
   * Test {@link LinearExpression#monomial(Object, Rational)}.
   * <ul>
   *   <li>When {@link Rational#ZERO}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#monomial(Object, Rational)}
   */
  @Test
  public void testMonomial_whenZero_thenReturnSizeIsZero() {
    // Arrange and Act
    LinearExpression<Object> actualMonomialResult = LinearExpression.monomial("Var", Rational.ZERO);

    // Assert
    assertEquals(0, actualMonomialResult.size());
    assertTrue(actualMonomialResult.getMap().isEmpty());
    assertTrue(actualMonomialResult.isEmpty());
  }

  /**
   * Test {@link LinearExpression#ofVariable(Object)}.
   * <p>
   * Method under test: {@link LinearExpression#ofVariable(Object)}
   */
  @Test
  public void testOfVariable() {
    // Arrange and Act
    LinearExpression<Object> actualOfVariableResult = LinearExpression.ofVariable("Var");

    // Assert
    ImmutableMap<Object, Rational> map = actualOfVariableResult.getMap();
    assertEquals(1, map.size());
    Rational getResult = map.get("Var");
    BigInteger den = getResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(1, den.signum());
    assertEquals(1, actualOfVariableResult.size());
    assertEquals(1, getResult.signum());
    assertFalse(actualOfVariableResult.isEmpty());
    assertTrue(getResult.isIntegral());
    assertSame(den, getResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link LinearExpression#add(LinearExpression)}.
   * <p>
   * Method under test: {@link LinearExpression#add(LinearExpression)}
   */
  @Test
  public void testAdd() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression
        .monomial("Infinity is not supported, use ExtendedRational instead", Rational.NEG_ONE);
    LinearExpression<Object> other = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act and Assert
    ImmutableMap<Object, Rational> map = monomialResult.add(other).getMap();
    assertEquals(2, map.size());
    Rational getResult = map.get("Infinity is not supported, use ExtendedRational instead");
    BigInteger num = getResult.getNum();
    assertEquals("-1", num.toString());
    BigInteger den = getResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, getResult.signum());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(0, num.getLowestSetBit());
    assertEquals(1, den.signum());
    assertTrue(getResult.isIntegral());
    assertSame(getResult, map.get("Var"));
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link LinearExpression#add(LinearExpression)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When empty.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#add(LinearExpression)}
   */
  @Test
  public void testAdd_givenEmpty_whenEmpty_thenReturnEmpty() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();
    LinearExpression<Object> other = LinearExpression.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult.add(other));
  }

  /**
   * Test {@link LinearExpression#add(LinearExpression)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   *   <li>Then return monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#add(LinearExpression)}
   */
  @Test
  public void testAdd_givenEmpty_whenMonomialVarAndNeg_one_thenReturnMonomialVarAndNeg_one() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();
    LinearExpression<Object> other = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act and Assert
    assertEquals(other, emptyResult.add(other));
  }

  /**
   * Test {@link LinearExpression#add(LinearExpression)}.
   * <ul>
   *   <li>Given monomial one and {@link Rational#NEG_ONE}.</li>
   *   <li>Then return Map one Num toString is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#add(LinearExpression)}
   */
  @Test
  public void testAdd_givenMonomialOneAndNeg_one_thenReturnMapOneNumToStringIs1() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.<Object>monomial(1, Rational.NEG_ONE);
    LinearExpression<Object> other = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act and Assert
    ImmutableMap<Object, Rational> map = monomialResult.add(other).getMap();
    assertEquals(2, map.size());
    Rational getResult = map.get(1);
    BigInteger num = getResult.getNum();
    assertEquals("-1", num.toString());
    BigInteger den = getResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, getResult.signum());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(0, num.getLowestSetBit());
    assertEquals(1, den.signum());
    assertTrue(getResult.isIntegral());
    assertSame(getResult, map.get("Var"));
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link LinearExpression#add(LinearExpression)}.
   * <ul>
   *   <li>Given monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   *   <li>Then return Map size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#add(LinearExpression)}
   */
  @Test
  public void testAdd_givenMonomialVarAndNeg_one_thenReturnMapSizeIsOne() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.NEG_ONE);
    LinearExpression<Object> other = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act and Assert
    ImmutableMap<Object, Rational> map = monomialResult.add(other).getMap();
    assertEquals(1, map.size());
    Rational getResult = map.get("Var");
    BigInteger num = getResult.getNum();
    assertEquals("-2", num.toString());
    assertEquals(1, num.getLowestSetBit());
    assertArrayEquals(new byte[]{-2}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, getResult.getDen().toByteArray());
  }

  /**
   * Test {@link LinearExpression#add(LinearExpression)}.
   * <ul>
   *   <li>Given monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   *   <li>When empty.</li>
   *   <li>Then return monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#add(LinearExpression)}
   */
  @Test
  public void testAdd_givenMonomialVarAndNeg_one_whenEmpty_thenReturnMonomialVarAndNeg_one() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.NEG_ONE);
    LinearExpression<Object> other = LinearExpression.empty();

    // Act and Assert
    assertEquals(monomialResult, monomialResult.add(other));
  }

  /**
   * Test {@link LinearExpression#add(LinearExpression)}.
   * <ul>
   *   <li>Given monomial {@code Var} and {@link Rational#ONE}.</li>
   *   <li>When monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#add(LinearExpression)}
   */
  @Test
  public void testAdd_givenMonomialVarAndOne_whenMonomialVarAndNeg_one_thenReturnSizeIsZero() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.ONE);
    LinearExpression<Object> other = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act
    LinearExpression<Object> actualAddResult = monomialResult.add(other);

    // Assert
    assertEquals(0, actualAddResult.size());
    assertTrue(actualAddResult.getMap().isEmpty());
    assertTrue(actualAddResult.isEmpty());
  }

  /**
   * Test {@link LinearExpression#sub(LinearExpression)}.
   * <p>
   * Method under test: {@link LinearExpression#sub(LinearExpression)}
   */
  @Test
  public void testSub() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression
        .monomial("Infinity is not supported, use ExtendedRational instead", Rational.NEG_ONE);
    LinearExpression<Object> other = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act and Assert
    ImmutableMap<Object, Rational> map = monomialResult.sub(other).getMap();
    assertEquals(2, map.size());
    Rational getResult = map.get("Infinity is not supported, use ExtendedRational instead");
    BigInteger num = getResult.getNum();
    assertEquals("-1", num.toString());
    BigInteger den = getResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, getResult.signum());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(0, num.getLowestSetBit());
    assertEquals(1, den.signum());
    assertTrue(getResult.isIntegral());
    Rational getResult2 = map.get("Var");
    assertSame(den, getResult2.getDen());
    assertSame(den, getResult2.getNum());
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link LinearExpression#sub(LinearExpression)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When empty.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#sub(LinearExpression)}
   */
  @Test
  public void testSub_givenEmpty_whenEmpty_thenReturnEmpty() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();
    LinearExpression<Object> other = LinearExpression.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult.sub(other));
  }

  /**
   * Test {@link LinearExpression#sub(LinearExpression)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   *   <li>Then return Map {@code Var} Den toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#sub(LinearExpression)}
   */
  @Test
  public void testSub_givenEmpty_whenMonomialVarAndNeg_one_thenReturnMapVarDenToStringIs1() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();
    LinearExpression<Object> other = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act
    LinearExpression<Object> actualSubResult = emptyResult.sub(other);

    // Assert
    ImmutableMap<Object, Rational> map = actualSubResult.getMap();
    assertEquals(1, map.size());
    Rational getResult = map.get("Var");
    BigInteger den = getResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(1, den.signum());
    assertEquals(1, actualSubResult.size());
    assertEquals(1, getResult.signum());
    assertSame(den, getResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link LinearExpression#sub(LinearExpression)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When monomial {@code Var} and {@link Rational#ONE}.</li>
   *   <li>Then return Map {@code Var} Num toString is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#sub(LinearExpression)}
   */
  @Test
  public void testSub_givenEmpty_whenMonomialVarAndOne_thenReturnMapVarNumToStringIs1() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();
    LinearExpression<Object> other = LinearExpression.monomial("Var", Rational.ONE);

    // Act and Assert
    ImmutableMap<Object, Rational> map = emptyResult.sub(other).getMap();
    assertEquals(1, map.size());
    Rational getResult = map.get("Var");
    BigInteger num = getResult.getNum();
    assertEquals("-1", num.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, getResult.signum());
    assertEquals(0, num.getLowestSetBit());
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, getResult.getDen().toByteArray());
  }

  /**
   * Test {@link LinearExpression#sub(LinearExpression)}.
   * <ul>
   *   <li>Given monomial one and {@link Rational#NEG_ONE}.</li>
   *   <li>Then return Map one Num toString is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#sub(LinearExpression)}
   */
  @Test
  public void testSub_givenMonomialOneAndNeg_one_thenReturnMapOneNumToStringIs1() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.<Object>monomial(1, Rational.NEG_ONE);
    LinearExpression<Object> other = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act and Assert
    ImmutableMap<Object, Rational> map = monomialResult.sub(other).getMap();
    assertEquals(2, map.size());
    Rational getResult = map.get(1);
    BigInteger num = getResult.getNum();
    assertEquals("-1", num.toString());
    BigInteger den = getResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, getResult.signum());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(0, num.getLowestSetBit());
    assertEquals(1, den.signum());
    assertTrue(getResult.isIntegral());
    Rational getResult2 = map.get("Var");
    assertSame(den, getResult2.getDen());
    assertSame(den, getResult2.getNum());
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link LinearExpression#sub(LinearExpression)}.
   * <ul>
   *   <li>Given monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#sub(LinearExpression)}
   */
  @Test
  public void testSub_givenMonomialVarAndNeg_one_thenReturnSizeIsZero() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.NEG_ONE);
    LinearExpression<Object> other = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act
    LinearExpression<Object> actualSubResult = monomialResult.sub(other);

    // Assert
    assertEquals(0, actualSubResult.size());
    assertTrue(actualSubResult.getMap().isEmpty());
    assertTrue(actualSubResult.isEmpty());
  }

  /**
   * Test {@link LinearExpression#sub(LinearExpression)}.
   * <ul>
   *   <li>Given monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   *   <li>When empty.</li>
   *   <li>Then return monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#sub(LinearExpression)}
   */
  @Test
  public void testSub_givenMonomialVarAndNeg_one_whenEmpty_thenReturnMonomialVarAndNeg_one() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.NEG_ONE);
    LinearExpression<Object> other = LinearExpression.empty();

    // Act and Assert
    assertEquals(monomialResult, monomialResult.sub(other));
  }

  /**
   * Test {@link LinearExpression#sub(LinearExpression)}.
   * <ul>
   *   <li>Given monomial {@code Var} and {@link Rational#ONE}.</li>
   *   <li>Then return Map {@code Var} Num toString is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#sub(LinearExpression)}
   */
  @Test
  public void testSub_givenMonomialVarAndOne_thenReturnMapVarNumToStringIs2() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.ONE);
    LinearExpression<Object> other = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act and Assert
    ImmutableMap<Object, Rational> map = monomialResult.sub(other).getMap();
    assertEquals(1, map.size());
    Rational getResult = map.get("Var");
    BigInteger num = getResult.getNum();
    assertEquals("2", num.toString());
    assertEquals(1, num.getLowestSetBit());
    assertEquals(1, num.signum());
    assertArrayEquals(new byte[]{1}, getResult.getDen().toByteArray());
    assertArrayEquals(new byte[]{2}, num.toByteArray());
  }

  /**
   * Test {@link LinearExpression#multByConst(Rational)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#multByConst(Rational)}
   */
  @Test
  public void testMultByConst_givenEmpty_whenNeg_one_thenReturnEmpty() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult.multByConst(Rational.NEG_ONE));
  }

  /**
   * Test {@link LinearExpression#multByConst(Rational)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Rational#ZERO}.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#multByConst(Rational)}
   */
  @Test
  public void testMultByConst_givenEmpty_whenZero_thenReturnEmpty() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult.multByConst(Rational.ZERO));
  }

  /**
   * Test {@link LinearExpression#multByConst(Rational)}.
   * <ul>
   *   <li>Given monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   *   <li>Then return Map {@code Var} is {@link Rational#NEG_ONE} {@link Rational#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#multByConst(Rational)}
   */
  @Test
  public void testMultByConst_givenMonomialVarAndNeg_one_thenReturnMapVarIsNeg_oneOne() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.NEG_ONE);
    Rational constant = Rational.NEG_ONE;

    // Act and Assert
    ImmutableMap<Object, Rational> map = monomialResult.multByConst(constant).getMap();
    assertEquals(1, map.size());
    Rational expectedGetResult = constant.ONE;
    assertSame(expectedGetResult, map.get("Var"));
  }

  /**
   * Test {@link LinearExpression#multByConst(Rational)}.
   * <ul>
   *   <li>Given monomial {@code Var} and {@link Rational#ONE}.</li>
   *   <li>Then return Map {@code Var} is {@link Rational#NEG_ONE} {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#multByConst(Rational)}
   */
  @Test
  public void testMultByConst_givenMonomialVarAndOne_thenReturnMapVarIsNeg_oneNeg_one() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.ONE);
    Rational constant = Rational.NEG_ONE;

    // Act and Assert
    ImmutableMap<Object, Rational> map = monomialResult.multByConst(constant).getMap();
    assertEquals(1, map.size());
    Rational expectedGetResult = constant.NEG_ONE;
    assertSame(expectedGetResult, map.get("Var"));
  }

  /**
   * Test {@link LinearExpression#multByConst(Rational)}.
   * <ul>
   *   <li>When {@link Rational#ONE}.</li>
   *   <li>Then return monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#multByConst(Rational)}
   */
  @Test
  public void testMultByConst_whenOne_thenReturnMonomialVarAndNeg_one() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act and Assert
    assertEquals(monomialResult, monomialResult.multByConst(Rational.ONE));
  }

  /**
   * Test {@link LinearExpression#negate()}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#negate()}
   */
  @Test
  public void testNegate_givenEmpty_thenReturnEmpty() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult.negate());
  }

  /**
   * Test {@link LinearExpression#negate()}.
   * <ul>
   *   <li>Given monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   *   <li>Then return Map {@code Var} Den toString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#negate()}
   */
  @Test
  public void testNegate_givenMonomialVarAndNeg_one_thenReturnMapVarDenToStringIs1() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act
    LinearExpression<Object> actualNegateResult = monomialResult.negate();

    // Assert
    ImmutableMap<Object, Rational> map = actualNegateResult.getMap();
    assertEquals(1, map.size());
    Rational getResult = map.get("Var");
    BigInteger den = getResult.getDen();
    assertEquals("1", den.toString());
    assertEquals(0, den.getLowestSetBit());
    assertEquals(1, den.signum());
    assertEquals(1, actualNegateResult.size());
    assertEquals(1, getResult.signum());
    assertFalse(actualNegateResult.isEmpty());
    assertTrue(getResult.isIntegral());
    assertSame(den, getResult.getNum());
    assertArrayEquals(new byte[]{1}, den.toByteArray());
  }

  /**
   * Test {@link LinearExpression#negate()}.
   * <ul>
   *   <li>Given monomial {@code Var} and {@link Rational#ONE}.</li>
   *   <li>Then return Map {@code Var} Num toString is {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#negate()}
   */
  @Test
  public void testNegate_givenMonomialVarAndOne_thenReturnMapVarNumToStringIs1() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.ONE);

    // Act and Assert
    ImmutableMap<Object, Rational> map = monomialResult.negate().getMap();
    assertEquals(1, map.size());
    Rational getResult = map.get("Var");
    BigInteger num = getResult.getNum();
    assertEquals("-1", num.toString());
    assertEquals(-1, num.signum());
    assertEquals(-1, getResult.signum());
    assertEquals(0, num.getLowestSetBit());
    assertArrayEquals(new byte[]{-1}, num.toByteArray());
    assertArrayEquals(new byte[]{1}, getResult.getDen().toByteArray());
  }

  /**
   * Test {@link LinearExpression#getCoeff(Object)}.
   * <p>
   * Method under test: {@link LinearExpression#getCoeff(Object)}
   */
  @Test
  public void testGetCoeff() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act
    Rational actualCoeff = emptyResult.getCoeff("Variable");

    // Assert
    assertSame(actualCoeff.ZERO, actualCoeff);
  }

  /**
   * Test {@link LinearExpression#size()}.
   * <p>
   * Method under test: {@link LinearExpression#size()}
   */
  @Test
  public void testSize() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act and Assert
    assertEquals(0, emptyResult.size());
  }

  /**
   * Test {@link LinearExpression#isEmpty()}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#isEmpty()}
   */
  @Test
  public void testIsEmpty_givenEmpty_thenReturnTrue() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act and Assert
    assertTrue(emptyResult.isEmpty());
  }

  /**
   * Test {@link LinearExpression#isEmpty()}.
   * <ul>
   *   <li>Given monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#isEmpty()}
   */
  @Test
  public void testIsEmpty_givenMonomialVarAndNeg_one_thenReturnFalse() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act and Assert
    assertFalse(monomialResult.isEmpty());
  }

  /**
   * Test {@link LinearExpression#isIntegral()}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#isIntegral()}
   */
  @Test
  public void testIsIntegral_givenEmpty() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act and Assert
    assertTrue(emptyResult.isIntegral());
  }

  /**
   * Test {@link LinearExpression#isIntegral()}.
   * <ul>
   *   <li>Given monomial {@code Var} and {@link Rational#NEG_ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#isIntegral()}
   */
  @Test
  public void testIsIntegral_givenMonomialVarAndNeg_one() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.NEG_ONE);

    // Act and Assert
    assertTrue(monomialResult.isIntegral());
  }

  /**
   * Test {@link LinearExpression#divide(LinearExpression)}.
   * <p>
   * Method under test: {@link LinearExpression#divide(LinearExpression)}
   */
  @Test
  public void testDivide() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.NEG_ONE);
    LinearExpression<Object> other = LinearExpression.empty();

    // Act and Assert
    assertFalse(monomialResult.divide(other).isPresent());
  }

  /**
   * Test {@link LinearExpression#iterator()}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#iterator()}
   */
  @Test
  public void testIterator_givenEmpty() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act and Assert
    assertFalse(emptyResult.iterator().hasNext());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LinearExpression#toString()}
   *   <li>{@link LinearExpression#getMap()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act
    String actualToStringResult = emptyResult.toString();

    // Assert
    assertEquals("", actualToStringResult);
    assertTrue(emptyResult.getMap().isEmpty());
  }

  /**
   * Test {@link LinearExpression#writeMonomial(String, Rational, StringBuilder)}.
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with empty string toString is {@code - Var Serialized}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#writeMonomial(String, Rational, StringBuilder)}
   */
  @Test
  public void testWriteMonomial_thenStringBuilderWithEmptyStringToStringIsVarSerialized() {
    // Arrange
    StringBuilder b = new StringBuilder("");

    // Act
    LinearExpression.writeMonomial("Var Serialized", Rational.NEG_ONE, b);

    // Assert
    assertEquals(" - Var Serialized", b.toString());
  }

  /**
   * Test {@link LinearExpression#writeMonomial(String, Rational, StringBuilder)}.
   * <ul>
   *   <li>When {@link Rational#NEG_ONE}.</li>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code foo - Var Serialized}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#writeMonomial(String, Rational, StringBuilder)}
   */
  @Test
  public void testWriteMonomial_whenNeg_one_thenStringBuilderWithFooToStringIsFooVarSerialized() {
    // Arrange
    StringBuilder b = new StringBuilder("foo");

    // Act
    LinearExpression.writeMonomial("Var Serialized", Rational.NEG_ONE, b);

    // Assert
    assertEquals("foo - Var Serialized", b.toString());
  }

  /**
   * Test {@link LinearExpression#writeMonomial(String, Rational, StringBuilder)}.
   * <ul>
   *   <li>When {@link Rational#ONE}.</li>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code foo + Var Serialized}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#writeMonomial(String, Rational, StringBuilder)}
   */
  @Test
  public void testWriteMonomial_whenOne_thenStringBuilderWithFooToStringIsFooVarSerialized() {
    // Arrange
    StringBuilder b = new StringBuilder("foo");

    // Act
    LinearExpression.writeMonomial("Var Serialized", Rational.ONE, b);

    // Assert
    assertEquals("foo + Var Serialized", b.toString());
  }

  /**
   * Test {@link LinearExpression#writeMonomial(String, Rational, StringBuilder)}.
   * <ul>
   *   <li>When {@link Rational#ZERO}.</li>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code foo + 0Var Serialized}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#writeMonomial(String, Rational, StringBuilder)}
   */
  @Test
  public void testWriteMonomial_whenZero_thenStringBuilderWithFooToStringIsFoo0VarSerialized() {
    // Arrange
    StringBuilder b = new StringBuilder("foo");

    // Act
    LinearExpression.writeMonomial("Var Serialized", Rational.ZERO, b);

    // Assert
    assertEquals("foo + 0Var Serialized", b.toString());
  }

  /**
   * Test {@link LinearExpression#equals(Object)}, and {@link LinearExpression#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LinearExpression#equals(Object)}
   *   <li>{@link LinearExpression#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();
    LinearExpression<Object> emptyResult2 = LinearExpression.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult2);
    int expectedHashCodeResult = emptyResult.hashCode();
    assertEquals(expectedHashCodeResult, emptyResult2.hashCode());
  }

  /**
   * Test {@link LinearExpression#equals(Object)}, and {@link LinearExpression#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LinearExpression#equals(Object)}
   *   <li>{@link LinearExpression#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act and Assert
    assertEquals(emptyResult, emptyResult);
    int expectedHashCodeResult = emptyResult.hashCode();
    assertEquals(expectedHashCodeResult, emptyResult.hashCode());
  }

  /**
   * Test {@link LinearExpression#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LinearExpression<Object> monomialResult = LinearExpression.monomial("Var", Rational.NEG_ONE);
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act and Assert
    assertNotEquals(monomialResult, emptyResult);
  }

  /**
   * Test {@link LinearExpression#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act and Assert
    assertNotEquals(emptyResult, null);
  }

  /**
   * Test {@link LinearExpression#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinearExpression#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LinearExpression<Object> emptyResult = LinearExpression.empty();

    // Act and Assert
    assertNotEquals(emptyResult, "Different type to LinearExpression");
  }
}
