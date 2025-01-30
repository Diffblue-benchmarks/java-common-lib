package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.util.Optional;
import org.junit.Test;

public class AutoValue_MapsDifference_EntryDiffblueTest {
  /**
   * Test {@link AutoValue_MapsDifference_Entry#equals(Object)}, and {@link AutoValue_MapsDifference_Entry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoValue_MapsDifference_Entry#equals(Object)}
   *   <li>{@link AutoValue_MapsDifference_Entry#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Optional<Object> leftValue = Optional.of("42");
    Optional<Object> rightValue = Optional.of("42");
    AutoValue_MapsDifference_Entry<Object, Object> autoValue_MapsDifference_Entry = new AutoValue_MapsDifference_Entry<>(
        "Key", leftValue, rightValue);
    Optional<Object> leftValue2 = Optional.of("42");
    Optional<Object> rightValue2 = Optional.of("42");
    AutoValue_MapsDifference_Entry<Object, Object> autoValue_MapsDifference_Entry2 = new AutoValue_MapsDifference_Entry<>(
        "Key", leftValue2, rightValue2);

    // Act and Assert
    assertEquals(autoValue_MapsDifference_Entry, autoValue_MapsDifference_Entry2);
    int expectedHashCodeResult = autoValue_MapsDifference_Entry.hashCode();
    assertEquals(expectedHashCodeResult, autoValue_MapsDifference_Entry2.hashCode());
  }

  /**
   * Test {@link AutoValue_MapsDifference_Entry#equals(Object)}, and {@link AutoValue_MapsDifference_Entry#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoValue_MapsDifference_Entry#equals(Object)}
   *   <li>{@link AutoValue_MapsDifference_Entry#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Optional<Object> leftValue = Optional.of("42");
    Optional<Object> rightValue = Optional.of("42");
    AutoValue_MapsDifference_Entry<Object, Object> autoValue_MapsDifference_Entry = new AutoValue_MapsDifference_Entry<>(
        "Key", leftValue, rightValue);

    // Act and Assert
    assertEquals(autoValue_MapsDifference_Entry, autoValue_MapsDifference_Entry);
    int expectedHashCodeResult = autoValue_MapsDifference_Entry.hashCode();
    assertEquals(expectedHashCodeResult, autoValue_MapsDifference_Entry.hashCode());
  }

  /**
   * Test {@link AutoValue_MapsDifference_Entry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_MapsDifference_Entry#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Optional<Object> leftValue = Optional.of("42");
    Optional<Object> rightValue = Optional.of("42");
    AutoValue_MapsDifference_Entry<Object, Object> autoValue_MapsDifference_Entry = new AutoValue_MapsDifference_Entry<>(
        1, leftValue, rightValue);
    Optional<Object> leftValue2 = Optional.of("42");
    Optional<Object> rightValue2 = Optional.of("42");

    // Act and Assert
    assertNotEquals(autoValue_MapsDifference_Entry,
        new AutoValue_MapsDifference_Entry<>("Key", leftValue2, rightValue2));
  }

  /**
   * Test {@link AutoValue_MapsDifference_Entry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_MapsDifference_Entry#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Optional<Object> leftValue = Optional.<Object>of(1);
    Optional<Object> rightValue = Optional.of("42");
    AutoValue_MapsDifference_Entry<Object, Object> autoValue_MapsDifference_Entry = new AutoValue_MapsDifference_Entry<>(
        "Key", leftValue, rightValue);
    Optional<Object> leftValue2 = Optional.of("42");
    Optional<Object> rightValue2 = Optional.of("42");

    // Act and Assert
    assertNotEquals(autoValue_MapsDifference_Entry,
        new AutoValue_MapsDifference_Entry<>("Key", leftValue2, rightValue2));
  }

  /**
   * Test {@link AutoValue_MapsDifference_Entry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_MapsDifference_Entry#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Optional<Object> leftValue = Optional.of("42");
    Optional<Object> rightValue = Optional.<Object>of(1);
    AutoValue_MapsDifference_Entry<Object, Object> autoValue_MapsDifference_Entry = new AutoValue_MapsDifference_Entry<>(
        "Key", leftValue, rightValue);
    Optional<Object> leftValue2 = Optional.of("42");
    Optional<Object> rightValue2 = Optional.of("42");

    // Act and Assert
    assertNotEquals(autoValue_MapsDifference_Entry,
        new AutoValue_MapsDifference_Entry<>("Key", leftValue2, rightValue2));
  }

  /**
   * Test {@link AutoValue_MapsDifference_Entry#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_MapsDifference_Entry#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Optional<Object> leftValue = Optional.of("42");
    Optional<Object> rightValue = Optional.of("42");
    AutoValue_MapsDifference_Entry<Object, Object> autoValue_MapsDifference_Entry = new AutoValue_MapsDifference_Entry<>(
        "Key", leftValue, rightValue);

    // Act and Assert
    assertNotEquals(autoValue_MapsDifference_Entry, null);
  }

  /**
   * Test {@link AutoValue_MapsDifference_Entry#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_MapsDifference_Entry#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Optional<Object> leftValue = Optional.of("42");
    Optional<Object> rightValue = Optional.of("42");
    AutoValue_MapsDifference_Entry<Object, Object> autoValue_MapsDifference_Entry = new AutoValue_MapsDifference_Entry<>(
        "Key", leftValue, rightValue);

    // Act and Assert
    assertNotEquals(autoValue_MapsDifference_Entry, "Different type to AutoValue_MapsDifference_Entry");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoValue_MapsDifference_Entry#toString()}
   *   <li>{@link AutoValue_MapsDifference_Entry#getKey()}
   *   <li>{@link AutoValue_MapsDifference_Entry#getLeftValue()}
   *   <li>{@link AutoValue_MapsDifference_Entry#getRightValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Optional<Object> leftValue = Optional.of("42");
    Optional<Object> rightValue = Optional.of("42");
    AutoValue_MapsDifference_Entry<Object, Object> autoValue_MapsDifference_Entry = new AutoValue_MapsDifference_Entry<>(
        "Key", leftValue, rightValue);

    // Act
    String actualToStringResult = autoValue_MapsDifference_Entry.toString();
    Object actualKey = autoValue_MapsDifference_Entry.getKey();
    Optional<Object> actualLeftValue = autoValue_MapsDifference_Entry.getLeftValue();

    // Assert
    assertEquals("Entry{key=Key, leftValue=Optional[42], rightValue=Optional[42]}", actualToStringResult);
    assertEquals("Key", actualKey);
    assertSame(leftValue, actualLeftValue);
    assertSame(rightValue, autoValue_MapsDifference_Entry.getRightValue());
  }

  /**
   * Test {@link AutoValue_MapsDifference_Entry#AutoValue_MapsDifference_Entry(Object, Optional, Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_MapsDifference_Entry#AutoValue_MapsDifference_Entry(Object, Optional, Optional)}
   */
  @Test
  public void testNewAutoValue_MapsDifference_Entry_whenOptionalWith42_thenReturnKey() {
    // Arrange
    Optional<Object> leftValue = Optional.of("42");
    Optional<Object> rightValue = Optional.of("42");

    // Act
    AutoValue_MapsDifference_Entry<Object, Object> actualAutoValue_MapsDifference_Entry = new AutoValue_MapsDifference_Entry<>(
        "Key", leftValue, rightValue);

    // Assert
    assertEquals("Key", actualAutoValue_MapsDifference_Entry.getKey());
    assertSame(leftValue, actualAutoValue_MapsDifference_Entry.getLeftValue());
    assertSame(rightValue, actualAutoValue_MapsDifference_Entry.getRightValue());
  }
}
