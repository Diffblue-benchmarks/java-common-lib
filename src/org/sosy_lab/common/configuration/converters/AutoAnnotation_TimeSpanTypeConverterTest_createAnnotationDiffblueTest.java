package org.sosy_lab.common.configuration.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.sosy_lab.common.configuration.TimeSpanOption;

public class AutoAnnotation_TimeSpanTypeConverterTest_createAnnotationDiffblueTest {
  /**
   * Test {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#annotationType()}.
   * <p>
   * Method under test: {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#annotationType()}
   */
  @Test
  public void testAnnotationType() {
    // Arrange and Act
    Class<? extends TimeSpanOption> actualAnnotationTypeResult = (new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(
        TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS)).annotationType();

    // Assert
    Class<TimeSpanOption> expectedAnnotationTypeResult = TimeSpanOption.class;
    assertEquals(expectedAnnotationTypeResult, actualAnnotationTypeResult);
  }

  /**
   * Test {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#equals(Object)}, and {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#equals(Object)}
   *   <li>{@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation autoAnnotation_TimeSpanTypeConverterTest_createAnnotation = new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(
        TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS);
    AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation autoAnnotation_TimeSpanTypeConverterTest_createAnnotation2 = new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(
        TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS);

    // Act and Assert
    assertEquals(autoAnnotation_TimeSpanTypeConverterTest_createAnnotation,
        autoAnnotation_TimeSpanTypeConverterTest_createAnnotation2);
    int expectedHashCodeResult = autoAnnotation_TimeSpanTypeConverterTest_createAnnotation.hashCode();
    assertEquals(expectedHashCodeResult, autoAnnotation_TimeSpanTypeConverterTest_createAnnotation2.hashCode());
  }

  /**
   * Test {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#equals(Object)}, and {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#equals(Object)}
   *   <li>{@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation autoAnnotation_TimeSpanTypeConverterTest_createAnnotation = new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(
        TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS);

    // Act and Assert
    assertEquals(autoAnnotation_TimeSpanTypeConverterTest_createAnnotation,
        autoAnnotation_TimeSpanTypeConverterTest_createAnnotation);
    int expectedHashCodeResult = autoAnnotation_TimeSpanTypeConverterTest_createAnnotation.hashCode();
    assertEquals(expectedHashCodeResult, autoAnnotation_TimeSpanTypeConverterTest_createAnnotation.hashCode());
  }

  /**
   * Test {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation autoAnnotation_TimeSpanTypeConverterTest_createAnnotation = new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(
        TimeUnit.MICROSECONDS, TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(autoAnnotation_TimeSpanTypeConverterTest_createAnnotation,
        new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation autoAnnotation_TimeSpanTypeConverterTest_createAnnotation = new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(
        TimeUnit.NANOSECONDS, TimeUnit.MICROSECONDS);

    // Act and Assert
    assertNotEquals(autoAnnotation_TimeSpanTypeConverterTest_createAnnotation,
        new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS),
        null);
  }

  /**
   * Test {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS),
        "Different type to AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#toString()}
   *   <li>{@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#codeUnit()}
   *   <li>{@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#defaultUserUnit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation autoAnnotation_TimeSpanTypeConverterTest_createAnnotation = new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(
        TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS);

    // Act
    String actualToStringResult = autoAnnotation_TimeSpanTypeConverterTest_createAnnotation.toString();
    TimeUnit actualCodeUnitResult = autoAnnotation_TimeSpanTypeConverterTest_createAnnotation.codeUnit();

    // Assert
    assertEquals("@org.sosy_lab.common.configuration.TimeSpanOption(codeUnit=NANOSECONDS, defaultUserUnit=NANOSECONDS)",
        actualToStringResult);
    assertEquals(TimeUnit.NANOSECONDS, actualCodeUnitResult);
    assertEquals(TimeUnit.NANOSECONDS, autoAnnotation_TimeSpanTypeConverterTest_createAnnotation.defaultUserUnit());
  }

  /**
   * Test {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#max()}.
   * <p>
   * Method under test: {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#max()}
   */
  @Test
  public void testMax() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE,
        (new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS))
            .max());
  }

  /**
   * Test {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#min()}.
   * <p>
   * Method under test: {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#min()}
   */
  @Test
  public void testMin() {
    // Arrange, Act and Assert
    assertEquals(Long.MIN_VALUE,
        (new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS))
            .min());
  }

  /**
   * Test {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit, TimeUnit)}.
   * <p>
   * Method under test: {@link AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation#AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit, TimeUnit)}
   */
  @Test
  public void testNewAutoAnnotation_TimeSpanTypeConverterTest_createAnnotation() {
    // Arrange and Act
    AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation actualAutoAnnotation_TimeSpanTypeConverterTest_createAnnotation = new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(
        TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS);

    // Assert
    assertEquals(TimeUnit.NANOSECONDS, actualAutoAnnotation_TimeSpanTypeConverterTest_createAnnotation.codeUnit());
    assertEquals(TimeUnit.NANOSECONDS,
        actualAutoAnnotation_TimeSpanTypeConverterTest_createAnnotation.defaultUserUnit());
    assertEquals(Long.MAX_VALUE, actualAutoAnnotation_TimeSpanTypeConverterTest_createAnnotation.max());
    assertEquals(Long.MIN_VALUE, actualAutoAnnotation_TimeSpanTypeConverterTest_createAnnotation.min());
  }
}
