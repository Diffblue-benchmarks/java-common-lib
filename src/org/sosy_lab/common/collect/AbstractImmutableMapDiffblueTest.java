package org.sosy_lab.common.collect;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;
import org.sosy_lab.common.collect.OurSortedMap.EmptyImmutableOurSortedMap;

public class AbstractImmutableMapDiffblueTest {
  /**
   * Test {@link AbstractImmutableMap#clear()}.
   * <p>
   * Method under test: {@link AbstractImmutableMap#clear()}
   */
  @Test
  public void testClear() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> comparableObjectMap.clear());
  }

  /**
   * Test {@link AbstractImmutableMap#putAll(Map)}.
   * <p>
   * Method under test: {@link AbstractImmutableMap#putAll(Map)}
   */
  @Test
  public void testPutAll() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> comparableObjectMap.putAll(new HashMap<>()));
  }

  /**
   * Test {@link AbstractImmutableMap#remove(Object)} with {@code pKey}.
   * <p>
   * Method under test: {@link AbstractImmutableMap#remove(Object)}
   */
  @Test
  public void testRemoveWithPKey() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> comparableObjectMap.remove("P Key"));
  }

  /**
   * Test {@link AbstractImmutableMap#remove(Object, Object)} with {@code pKey}, {@code pValue}.
   * <p>
   * Method under test: {@link AbstractImmutableMap#remove(Object, Object)}
   */
  @Test
  public void testRemoveWithPKeyPValue() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> comparableObjectMap.remove("P Key", "P Value"));
  }

  /**
   * Test {@link AbstractImmutableMap#replaceAll(BiFunction)}.
   * <p>
   * Method under test: {@link AbstractImmutableMap#replaceAll(BiFunction)}
   */
  @Test
  public void testReplaceAll() {
    // Arrange
    EmptyImmutableOurSortedMap<Comparable<? super Comparable>, Object> comparableObjectMap = new EmptyImmutableOurSortedMap<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> comparableObjectMap.replaceAll(mock(BiFunction.class)));
  }
}
