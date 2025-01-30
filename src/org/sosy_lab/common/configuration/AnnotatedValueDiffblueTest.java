package org.sosy_lab.common.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Optional;
import org.junit.Test;

public class AnnotatedValueDiffblueTest {
  /**
   * Test {@link AnnotatedValue#create(Object, Optional)} with {@code Object}, {@code Optional}.
   * <ul>
   *   <li>Then return {@link AutoValue_AnnotatedValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AnnotatedValue#create(Object, Optional)}
   */
  @Test
  public void testCreateWithObjectOptional_thenReturnAutoValue_AnnotatedValue() {
    // Arrange
    Optional<String> annotation = Optional.of("foo");

    // Act
    AnnotatedValue<Object> actualCreateResult = AnnotatedValue.create("Value", annotation);

    // Assert
    assertTrue(actualCreateResult instanceof AutoValue_AnnotatedValue);
    assertEquals("Value", actualCreateResult.value());
    assertSame(annotation, actualCreateResult.annotation());
  }

  /**
   * Test {@link AnnotatedValue#create(Object, String)} with {@code Object}, {@code String}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@link AutoValue_AnnotatedValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AnnotatedValue#create(Object, String)}
   */
  @Test
  public void testCreateWithObjectString_whenValue_thenReturnAutoValue_AnnotatedValue() {
    // Arrange and Act
    AnnotatedValue<Object> actualCreateResult = AnnotatedValue.create("Value", "Annotation");

    // Assert
    assertTrue(actualCreateResult instanceof AutoValue_AnnotatedValue);
    Optional<String> annotationResult = actualCreateResult.annotation();
    assertEquals("Annotation", annotationResult.get());
    assertEquals("Value", actualCreateResult.value());
    assertTrue(annotationResult.isPresent());
  }

  /**
   * Test {@link AnnotatedValue#create(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@link AutoValue_AnnotatedValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AnnotatedValue#create(Object)}
   */
  @Test
  public void testCreateWithObject_whenValue_thenReturnAutoValue_AnnotatedValue() {
    // Arrange and Act
    AnnotatedValue<Object> actualCreateResult = AnnotatedValue.create("Value");

    // Assert
    assertTrue(actualCreateResult instanceof AutoValue_AnnotatedValue);
    assertEquals("Value", actualCreateResult.value());
    assertFalse(actualCreateResult.annotation().isPresent());
  }
}
