package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class PathCopyingPersistentTreeMapDiffblueTest {
  /**
   * Test {@link PathCopyingPersistentTreeMap#of()}.
   * <p>
   * Method under test: {@link PathCopyingPersistentTreeMap#of()}
   */
  @Test
  public void testOf() {
    // Arrange and Act
    PersistentSortedMap<Comparable<? super Comparable>, Object> actualOfResult = PathCopyingPersistentTreeMap.of();

    // Assert
    assertTrue(actualOfResult.isEmpty());
  }

  /**
   * Test {@link PathCopyingPersistentTreeMap#copyOf(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathCopyingPersistentTreeMap#copyOf(Map)}
   */
  @Test
  public void testCopyOf_whenHashMap_thenReturnHashMap() {
    // Arrange
    HashMap<Comparable<? super Comparable>, Object> map = new HashMap<>();

    // Act
    PersistentSortedMap<Comparable<? super Comparable>, Object> actualCopyOfResult = PathCopyingPersistentTreeMap
        .copyOf(map);

    // Assert
    assertEquals(map, actualCopyOfResult);
  }
}
