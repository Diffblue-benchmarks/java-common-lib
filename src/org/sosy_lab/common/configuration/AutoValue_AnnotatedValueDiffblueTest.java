package org.sosy_lab.common.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.util.Optional;
import org.junit.Test;

public class AutoValue_AnnotatedValueDiffblueTest {
  /**
   * Test {@link AutoValue_AnnotatedValue#equals(Object)}, and {@link AutoValue_AnnotatedValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoValue_AnnotatedValue#equals(Object)}
   *   <li>{@link AutoValue_AnnotatedValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Optional<String> annotation = Optional.of("foo");
    AutoValue_AnnotatedValue<Object> autoValue_AnnotatedValue = new AutoValue_AnnotatedValue<>("Value", annotation);
    Optional<String> annotation2 = Optional.of("foo");
    AutoValue_AnnotatedValue<Object> autoValue_AnnotatedValue2 = new AutoValue_AnnotatedValue<>("Value", annotation2);

    // Act and Assert
    assertEquals(autoValue_AnnotatedValue, autoValue_AnnotatedValue2);
    int expectedHashCodeResult = autoValue_AnnotatedValue.hashCode();
    assertEquals(expectedHashCodeResult, autoValue_AnnotatedValue2.hashCode());
  }

  /**
   * Test {@link AutoValue_AnnotatedValue#equals(Object)}, and {@link AutoValue_AnnotatedValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoValue_AnnotatedValue#equals(Object)}
   *   <li>{@link AutoValue_AnnotatedValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Optional<String> annotation = Optional.of("foo");
    AutoValue_AnnotatedValue<Object> autoValue_AnnotatedValue = new AutoValue_AnnotatedValue<>("Value", annotation);

    // Act and Assert
    assertEquals(autoValue_AnnotatedValue, autoValue_AnnotatedValue);
    int expectedHashCodeResult = autoValue_AnnotatedValue.hashCode();
    assertEquals(expectedHashCodeResult, autoValue_AnnotatedValue.hashCode());
  }

  /**
   * Test {@link AutoValue_AnnotatedValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_AnnotatedValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Optional<String> annotation = Optional.of("foo");
    AutoValue_AnnotatedValue<Object> autoValue_AnnotatedValue = new AutoValue_AnnotatedValue<>(42, annotation);
    Optional<String> annotation2 = Optional.of("foo");

    // Act and Assert
    assertNotEquals(autoValue_AnnotatedValue, new AutoValue_AnnotatedValue<>("Value", annotation2));
  }

  /**
   * Test {@link AutoValue_AnnotatedValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_AnnotatedValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Optional<String> annotation = Optional.of("Value");
    AutoValue_AnnotatedValue<Object> autoValue_AnnotatedValue = new AutoValue_AnnotatedValue<>("Value", annotation);
    Optional<String> annotation2 = Optional.of("foo");

    // Act and Assert
    assertNotEquals(autoValue_AnnotatedValue, new AutoValue_AnnotatedValue<>("Value", annotation2));
  }

  /**
   * Test {@link AutoValue_AnnotatedValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_AnnotatedValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Optional<String> annotation = Optional.of("foo");
    AutoValue_AnnotatedValue<Object> autoValue_AnnotatedValue = new AutoValue_AnnotatedValue<>("Value", annotation);

    // Act and Assert
    assertNotEquals(autoValue_AnnotatedValue, null);
  }

  /**
   * Test {@link AutoValue_AnnotatedValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_AnnotatedValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Optional<String> annotation = Optional.of("foo");
    AutoValue_AnnotatedValue<Object> autoValue_AnnotatedValue = new AutoValue_AnnotatedValue<>("Value", annotation);

    // Act and Assert
    assertNotEquals(autoValue_AnnotatedValue, "Different type to AutoValue_AnnotatedValue");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoValue_AnnotatedValue#toString()}
   *   <li>{@link AutoValue_AnnotatedValue#annotation()}
   *   <li>{@link AutoValue_AnnotatedValue#value()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Optional<String> annotation = Optional.of("foo");
    AutoValue_AnnotatedValue<Object> autoValue_AnnotatedValue = new AutoValue_AnnotatedValue<>("Value", annotation);

    // Act
    String actualToStringResult = autoValue_AnnotatedValue.toString();
    Optional<String> actualAnnotationResult = autoValue_AnnotatedValue.annotation();

    // Assert
    assertEquals("AnnotatedValue{value=Value, annotation=Optional[foo]}", actualToStringResult);
    assertEquals("Value", autoValue_AnnotatedValue.value());
    assertSame(annotation, actualAnnotationResult);
  }

  /**
   * Test {@link AutoValue_AnnotatedValue#AutoValue_AnnotatedValue(Object, Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@code foo}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_AnnotatedValue#AutoValue_AnnotatedValue(Object, Optional)}
   */
  @Test
  public void testNewAutoValue_AnnotatedValue_whenOptionalWithFoo_thenReturnValue() {
    // Arrange
    Optional<String> annotation = Optional.of("foo");

    // Act
    AutoValue_AnnotatedValue<Object> actualAutoValue_AnnotatedValue = new AutoValue_AnnotatedValue<>("Value",
        annotation);

    // Assert
    assertEquals("Value", actualAutoValue_AnnotatedValue.value());
    assertSame(annotation, actualAutoValue_AnnotatedValue.annotation());
  }
}
