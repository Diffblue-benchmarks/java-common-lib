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

public class OrderStatisticMapDiffblueTest {
  /**
   * Test {@link OrderStatisticMap#getKeyByRank(int)}.
   * <ul>
   *   <li>Then return {@code Comparator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticMap#getKeyByRank(int)}
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
   * Test {@link OrderStatisticMap#create()}.
   * <p>
   * Method under test: {@link OrderStatisticMap#create()}
   */
  @Test
  public void testCreate() {
    // Arrange and Act
    OrderStatisticMap<Object, Object> actualCreateResult = OrderStatisticMap.create();

    // Assert
    assertTrue(actualCreateResult.isEmpty());
  }

  /**
   * Test {@link OrderStatisticMap#create(Comparator)} with {@code Comparator}.
   * <ul>
   *   <li>When {@link Comparator}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticMap#create(Comparator)}
   */
  @Test
  public void testCreateWithComparator_whenComparator_thenReturnEmpty() {
    // Arrange and Act
    OrderStatisticMap<Object, Object> actualCreateResult = OrderStatisticMap
        .<Object, Object>create(mock(Comparator.class));

    // Assert
    assertTrue(actualCreateResult.isEmpty());
  }

  /**
   * Test {@link OrderStatisticMap#createWithNaturalOrder(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticMap#createWithNaturalOrder(Map)}
   */
  @Test
  public void testCreateWithNaturalOrder_whenHashMap_thenReturnHashMap() {
    // Arrange
    HashMap<Object, Object> pMap = new HashMap<>();

    // Act
    OrderStatisticMap<Object, Object> actualCreateWithNaturalOrderResult = OrderStatisticMap
        .createWithNaturalOrder(pMap);

    // Assert
    assertEquals(pMap, actualCreateWithNaturalOrderResult);
  }

  /**
   * Test {@link OrderStatisticMap#createWithSameOrder(SortedMap)}.
   * <ul>
   *   <li>When {@link TreeMap#TreeMap()}.</li>
   *   <li>Then return {@link TreeMap#TreeMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticMap#createWithSameOrder(SortedMap)}
   */
  @Test
  public void testCreateWithSameOrder_whenTreeMap_thenReturnTreeMap() {
    // Arrange
    TreeMap<Object, Object> pSortedMap = new TreeMap<>();

    // Act
    OrderStatisticMap<Object, Object> actualCreateWithSameOrderResult = OrderStatisticMap
        .createWithSameOrder(pSortedMap);

    // Assert
    assertEquals(pSortedMap, actualCreateWithSameOrderResult);
  }
}
