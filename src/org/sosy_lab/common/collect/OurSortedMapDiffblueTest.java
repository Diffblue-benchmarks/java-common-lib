package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.sosy_lab.common.collect.OurSortedMap.EmptyImmutableOurSortedMap;

public class OurSortedMapDiffblueTest {
  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#containsKey(Object)}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#containsKey(Object)}
   */
  @Test
  public void testEmptyImmutableOurSortedMapContainsKey() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertFalse(comparableObjectMap.containsKey("P Key"));
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#containsValue(Object)}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#containsValue(Object)}
   */
  @Test
  public void testEmptyImmutableOurSortedMapContainsValue() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertFalse(comparableObjectMap.containsValue("P Value"));
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#descendingEntryIterator()}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#descendingEntryIterator()}
   */
  @Test
  public void testEmptyImmutableOurSortedMapDescendingEntryIterator() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertFalse(comparableObjectMap.descendingEntryIterator().hasNext());
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#descendingMap()}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#descendingMap()}
   */
  @Test
  public void testEmptyImmutableOurSortedMapDescendingMap() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertSame(comparableObjectMap, comparableObjectMap.descendingMap());
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#entryIterator()}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#entryIterator()}
   */
  @Test
  public void testEmptyImmutableOurSortedMapEntryIterator() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertFalse(comparableObjectMap.entryIterator().hasNext());
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#entrySet()}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#entrySet()}
   */
  @Test
  public void testEmptyImmutableOurSortedMapEntrySet() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertTrue(comparableObjectMap.entrySet().isEmpty());
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#equals(Object)}, and {@link EmptyImmutableOurSortedMap#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmptyImmutableOurSortedMap#equals(Object)}
   *   <li>{@link EmptyImmutableOurSortedMap#hashCode()}
   * </ul>
   */
  @Test
  public void testEmptyImmutableOurSortedMapEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap2 = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertEquals(comparableObjectMap, comparableObjectMap2);
    int expectedHashCodeResult = comparableObjectMap.hashCode();
    assertEquals(expectedHashCodeResult, comparableObjectMap2.hashCode());
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#equals(Object)}, and {@link EmptyImmutableOurSortedMap#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmptyImmutableOurSortedMap#equals(Object)}
   *   <li>{@link EmptyImmutableOurSortedMap#hashCode()}
   * </ul>
   */
  @Test
  public void testEmptyImmutableOurSortedMapEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertEquals(comparableObjectMap, comparableObjectMap);
    int expectedHashCodeResult = comparableObjectMap.hashCode();
    assertEquals(expectedHashCodeResult, comparableObjectMap.hashCode());
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#equals(Object)}
   */
  @Test
  public void testEmptyImmutableOurSortedMapEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertNotEquals(comparableObjectMap, null);
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#equals(Object)}
   */
  @Test
  public void testEmptyImmutableOurSortedMapEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertNotEquals(comparableObjectMap, "Different type to EmptyImmutableOurSortedMap");
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#firstEntry()}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#firstEntry()}
   */
  @Test
  public void testEmptyImmutableOurSortedMapFirstEntry() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertNull(comparableObjectMap.firstEntry());
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#get(Object)}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#get(Object)}
   */
  @Test
  public void testEmptyImmutableOurSortedMapGet() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertNull(comparableObjectMap.get("P Key"));
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#getEntry(Object)}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#getEntry(Object)}
   */
  @Test
  public void testEmptyImmutableOurSortedMapGetEntry() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertNull(comparableObjectMap.getEntry("P Key"));
  }

  /**
   * Test EmptyImmutableOurSortedMap getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmptyImmutableOurSortedMap}
   *   <li>{@link EmptyImmutableOurSortedMap#toString()}
   *   <li>{@link EmptyImmutableOurSortedMap#isEmpty()}
   *   <li>{@link EmptyImmutableOurSortedMap#size()}
   * </ul>
   */
  @Test
  public void testEmptyImmutableOurSortedMapGettersAndSetters() {
    // Arrange and Act
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> actualComparableObjectMap = new EmptyImmutableOurSortedMap<>();
    String actualToStringResult = actualComparableObjectMap.toString();
    boolean actualIsEmptyResult = actualComparableObjectMap.isEmpty();

    // Assert
    assertEquals("{}", actualToStringResult);
    assertEquals(0, actualComparableObjectMap.size());
    assertTrue(actualIsEmptyResult);
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#lastEntry()}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#lastEntry()}
   */
  @Test
  public void testEmptyImmutableOurSortedMapLastEntry() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertNull(comparableObjectMap.lastEntry());
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#navigableKeySet()}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#navigableKeySet()}
   */
  @Test
  public void testEmptyImmutableOurSortedMapNavigableKeySet() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertTrue(comparableObjectMap.navigableKeySet().isEmpty());
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#of()}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#of()}
   */
  @Test
  public void testEmptyImmutableOurSortedMapOf() {
    // Arrange and Act
    OurSortedMap<Comparable<? super Comparable>, Object> actualOfResult = EmptyImmutableOurSortedMap.of();

    // Assert
    assertTrue(actualOfResult.isEmpty());
  }

  /**
   * Test EmptyImmutableOurSortedMap {@link EmptyImmutableOurSortedMap#values()}.
   * <p>
   * Method under test: {@link EmptyImmutableOurSortedMap#values()}
   */
  @Test
  public void testEmptyImmutableOurSortedMapValues() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertTrue(comparableObjectMap.values().isEmpty());
  }
}
