package org.sosy_lab.common.collect;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.sosy_lab.common.collect.OurSortedMap.EmptyImmutableOurSortedMap;

public class AbstractImmutableSortedMapDiffblueTest {
  /**
   * Test {@link AbstractImmutableSortedMap#keySet()}.
   * <p>
   * Method under test: {@link AbstractImmutableSortedMap#keySet()}
   */
  @Test
  public void testKeySet() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertTrue(comparableObjectMap.keySet().isEmpty());
  }

  /**
   * Test {@link AbstractImmutableSortedMap#descendingKeySet()}.
   * <p>
   * Method under test: {@link AbstractImmutableSortedMap#descendingKeySet()}
   */
  @Test
  public void testDescendingKeySet() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertTrue(comparableObjectMap.descendingKeySet().isEmpty());
  }

  /**
   * Test {@link AbstractImmutableSortedMap#pollFirstEntry()}.
   * <p>
   * Method under test: {@link AbstractImmutableSortedMap#pollFirstEntry()}
   */
  @Test
  public void testPollFirstEntry() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> comparableObjectMap.pollFirstEntry());
  }

  /**
   * Test {@link AbstractImmutableSortedMap#pollLastEntry()}.
   * <p>
   * Method under test: {@link AbstractImmutableSortedMap#pollLastEntry()}
   */
  @Test
  public void testPollLastEntry() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> comparableObjectMap.pollLastEntry());
  }
}
