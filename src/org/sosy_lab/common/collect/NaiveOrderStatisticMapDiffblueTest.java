package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.junit.Test;

public class NaiveOrderStatisticMapDiffblueTest {
  /**
   * Test {@link NaiveOrderStatisticMap#createMap()}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#createMap()}
   */
  @Test
  public void testCreateMap() {
    // Arrange and Act
    NaiveOrderStatisticMap<Object, Object> actualCreateMapResult = NaiveOrderStatisticMap.createMap();

    // Assert
    assertTrue(actualCreateMapResult.isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticMap#createMap(Comparator)} with {@code Comparator}.
   * <ul>
   *   <li>When {@link Comparator}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#createMap(Comparator)}
   */
  @Test
  public void testCreateMapWithComparator_whenComparator_thenReturnEmpty() {
    // Arrange and Act
    NaiveOrderStatisticMap<Object, Object> actualCreateMapResult = NaiveOrderStatisticMap
        .<Object, Object>createMap(mock(Comparator.class));

    // Assert
    assertTrue(actualCreateMapResult.isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticMap#createMapWithNaturalOrder(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#createMapWithNaturalOrder(Map)}
   */
  @Test
  public void testCreateMapWithNaturalOrder_whenHashMap_thenReturnHashMap() {
    // Arrange
    HashMap<Object, Object> pMap = new HashMap<>();

    // Act
    NaiveOrderStatisticMap<Object, Object> actualCreateMapWithNaturalOrderResult = NaiveOrderStatisticMap
        .createMapWithNaturalOrder(pMap);

    // Assert
    assertEquals(pMap, actualCreateMapWithNaturalOrderResult);
  }

  /**
   * Test {@link NaiveOrderStatisticMap#createMapWithSameOrder(SortedMap)}.
   * <ul>
   *   <li>When {@link TreeMap#TreeMap()}.</li>
   *   <li>Then return {@link TreeMap#TreeMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#createMapWithSameOrder(SortedMap)}
   */
  @Test
  public void testCreateMapWithSameOrder_whenTreeMap_thenReturnTreeMap() {
    // Arrange
    TreeMap<Object, Object> pSortedMap = new TreeMap<>();

    // Act
    NaiveOrderStatisticMap<Object, Object> actualCreateMapWithSameOrderResult = NaiveOrderStatisticMap
        .createMapWithSameOrder(pSortedMap);

    // Assert
    assertEquals(pSortedMap, actualCreateMapWithSameOrderResult);
  }

  /**
   * Test {@link NaiveOrderStatisticMap#delegate()}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#delegate()}
   */
  @Test
  public void testDelegate() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();

    // Act and Assert
    assertTrue(createMapResult.delegate().isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticMap#getKeyByRank(int)}.
   * <ul>
   *   <li>Then return {@code Comparator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#getKeyByRank(int)}
   */
  @Test
  public void testGetKeyByRank_thenReturnJavaUtilComparator() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();
    createMapResult.put("java.util.Comparator", "Value");
    createMapResult.put("Key", "Value");

    // Act and Assert
    assertEquals("java.util.Comparator", createMapResult.getKeyByRank(1));
  }

  /**
   * Test {@link NaiveOrderStatisticMap#removeByRank(int)}.
   * <ul>
   *   <li>Given createMap {@code Comparator} is {@code Value}.</li>
   *   <li>Then createMap size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#removeByRank(int)}
   */
  @Test
  public void testRemoveByRank_givenCreateMapJavaUtilComparatorIsValue_thenCreateMapSizeIsOne() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();
    createMapResult.put("java.util.Comparator", "Value");
    createMapResult.put("Key", "Value");

    // Act
    String actualRemoveByRankResult = createMapResult.removeByRank(1);

    // Assert
    assertEquals(1, createMapResult.size());
    assertEquals("java.util.Comparator", actualRemoveByRankResult);
    assertTrue(createMapResult.containsKey("Key"));
  }

  /**
   * Test {@link NaiveOrderStatisticMap#rankOf(Object)}.
   * <ul>
   *   <li>Given createMap {@code Key} is {@code Value}.</li>
   *   <li>When {@code P Obj}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#rankOf(Object)}
   */
  @Test
  public void testRankOf_givenCreateMapKeyIsValue_whenPObj_thenReturnMinusOne() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();
    createMapResult.put("Key", "Value");

    // Act and Assert
    assertEquals(-1, createMapResult.rankOf("P Obj"));
  }

  /**
   * Test {@link NaiveOrderStatisticMap#rankOf(Object)}.
   * <ul>
   *   <li>Given createMap.</li>
   *   <li>When {@code P Obj}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#rankOf(Object)}
   */
  @Test
  public void testRankOf_givenCreateMap_whenPObj_thenReturnMinusOne() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();

    // Act and Assert
    assertEquals(-1, createMapResult.rankOf("P Obj"));
  }

  /**
   * Test {@link NaiveOrderStatisticMap#navigableKeySet()}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#navigableKeySet()}
   */
  @Test
  public void testNavigableKeySet() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();

    // Act and Assert
    assertTrue(createMapResult.navigableKeySet().isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticMap#descendingKeySet()}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#descendingKeySet()}
   */
  @Test
  public void testDescendingKeySet() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();

    // Act and Assert
    assertTrue(createMapResult.descendingKeySet().isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticMap#descendingMap()}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#descendingMap()}
   */
  @Test
  public void testDescendingMap() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();

    // Act and Assert
    assertTrue(createMapResult.descendingMap().isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticMap#subMap(Object, boolean, Object, boolean)} with {@code fromKey}, {@code fromInclusive}, {@code toKey}, {@code toInclusive}.
   * <ul>
   *   <li>When {@code From Key}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#subMap(Object, boolean, Object, boolean)}
   */
  @Test
  public void testSubMapWithFromKeyFromInclusiveToKeyToInclusive_whenFromKey_thenReturnEmpty() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();

    // Act and Assert
    assertTrue(createMapResult.subMap("From Key", true, "To Key", true).isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticMap#subMap(Object, Object)} with {@code fromKey}, {@code toKey}.
   * <ul>
   *   <li>When {@code From Key}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#subMap(Object, Object)}
   */
  @Test
  public void testSubMapWithFromKeyToKey_whenFromKey_thenReturnEmpty() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();

    // Act and Assert
    assertTrue(createMapResult.subMap("From Key", "To Key").isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticMap#headMap(Object)} with {@code toKey}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#headMap(Object)}
   */
  @Test
  public void testHeadMapWithToKey() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();

    // Act and Assert
    assertTrue(createMapResult.headMap("To Key").isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticMap#headMap(Object, boolean)} with {@code toKey}, {@code inclusive}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#headMap(Object, boolean)}
   */
  @Test
  public void testHeadMapWithToKeyInclusive() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();

    // Act and Assert
    assertTrue(createMapResult.headMap("To Key", true).isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticMap#tailMap(Object)} with {@code fromKey}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#tailMap(Object)}
   */
  @Test
  public void testTailMapWithFromKey() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();

    // Act and Assert
    assertTrue(createMapResult.tailMap("From Key").isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticMap#tailMap(Object, boolean)} with {@code fromKey}, {@code inclusive}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticMap#tailMap(Object, boolean)}
   */
  @Test
  public void testTailMapWithFromKeyInclusive() {
    // Arrange
    NaiveOrderStatisticMap<String, Object> createMapResult = NaiveOrderStatisticMap.createMap();

    // Act and Assert
    assertTrue(createMapResult.tailMap("From Key", true).isEmpty());
  }
}
