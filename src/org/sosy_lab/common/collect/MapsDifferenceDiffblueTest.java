package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Optional;
import org.junit.Test;
import org.sosy_lab.common.collect.MapsDifference.Entry;

public class MapsDifferenceDiffblueTest {
  /**
   * Test Entry {@link Entry#forDifferingValues(Object, Object, Object)}.
   * <ul>
   *   <li>When {@code P Key}.</li>
   *   <li>Then return {@link AutoValue_MapsDifference_Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entry#forDifferingValues(Object, Object, Object)}
   */
  @Test
  public void testEntryForDifferingValues_whenPKey_thenReturnAutoValue_MapsDifference_Entry() {
    // Arrange and Act
    Entry<Object, Object> actualForDifferingValuesResult = Entry.forDifferingValues("P Key", "P Left Value",
        "P Right Value");

    // Assert
    assertTrue(actualForDifferingValuesResult instanceof AutoValue_MapsDifference_Entry);
    assertEquals("P Key", actualForDifferingValuesResult.getKey());
    Optional<Object> leftValue = actualForDifferingValuesResult.getLeftValue();
    assertEquals("P Left Value", leftValue.get());
    Optional<Object> rightValue = actualForDifferingValuesResult.getRightValue();
    assertEquals("P Right Value", rightValue.get());
    assertTrue(leftValue.isPresent());
    assertTrue(rightValue.isPresent());
  }

  /**
   * Test Entry {@link Entry#forLeftValueOnly(Object, Object)}.
   * <ul>
   *   <li>When {@code P Key}.</li>
   *   <li>Then return {@link AutoValue_MapsDifference_Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entry#forLeftValueOnly(Object, Object)}
   */
  @Test
  public void testEntryForLeftValueOnly_whenPKey_thenReturnAutoValue_MapsDifference_Entry() {
    // Arrange and Act
    Entry<Object, Object> actualForLeftValueOnlyResult = Entry.forLeftValueOnly("P Key", "P Left Value");

    // Assert
    assertTrue(actualForLeftValueOnlyResult instanceof AutoValue_MapsDifference_Entry);
    assertEquals("P Key", actualForLeftValueOnlyResult.getKey());
    Optional<Object> leftValue = actualForLeftValueOnlyResult.getLeftValue();
    assertEquals("P Left Value", leftValue.get());
    assertFalse(actualForLeftValueOnlyResult.getRightValue().isPresent());
    assertTrue(leftValue.isPresent());
  }

  /**
   * Test Entry {@link Entry#forRightValueOnly(Object, Object)}.
   * <ul>
   *   <li>When {@code P Key}.</li>
   *   <li>Then return {@link AutoValue_MapsDifference_Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entry#forRightValueOnly(Object, Object)}
   */
  @Test
  public void testEntryForRightValueOnly_whenPKey_thenReturnAutoValue_MapsDifference_Entry() {
    // Arrange and Act
    Entry<Object, Object> actualForRightValueOnlyResult = Entry.forRightValueOnly("P Key", "P Right Value");

    // Assert
    assertTrue(actualForRightValueOnlyResult instanceof AutoValue_MapsDifference_Entry);
    assertEquals("P Key", actualForRightValueOnlyResult.getKey());
    Optional<Object> rightValue = actualForRightValueOnlyResult.getRightValue();
    assertEquals("P Right Value", rightValue.get());
    assertFalse(actualForRightValueOnlyResult.getLeftValue().isPresent());
    assertTrue(rightValue.isPresent());
  }
}
