package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.Test;

public class OrderStatisticSetDiffblueTest {
  /**
   * Test {@link OrderStatisticSet#create()}.
   * <p>
   * Method under test: {@link OrderStatisticSet#create()}
   */
  @Test
  public void testCreate() {
    // Arrange and Act
    OrderStatisticSet<Object> actualCreateResult = OrderStatisticSet.create();

    // Assert
    assertTrue(actualCreateResult.isEmpty());
  }

  /**
   * Test {@link OrderStatisticSet#create(Comparator)} with {@code Comparator}.
   * <ul>
   *   <li>When {@link Comparator}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticSet#create(Comparator)}
   */
  @Test
  public void testCreateWithComparator_whenComparator_thenReturnEmpty() {
    // Arrange and Act
    OrderStatisticSet<Object> actualCreateResult = OrderStatisticSet.<Object>create(mock(Comparator.class));

    // Assert
    assertTrue(actualCreateResult.isEmpty());
  }

  /**
   * Test {@link OrderStatisticSet#createWithNaturalOrder(Iterable)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticSet#createWithNaturalOrder(Iterable)}
   */
  @Test
  public void testCreateWithNaturalOrder_givenArrayListIterator_thenCallsIterator() {
    // Arrange
    Iterable<Object> pCollection = mock(Iterable.class);

    ArrayList<Object> objectList = new ArrayList<>();
    when(pCollection.iterator()).thenReturn(objectList.iterator());

    // Act
    OrderStatisticSet<Object> actualCreateWithNaturalOrderResult = OrderStatisticSet
        .createWithNaturalOrder(pCollection);

    // Assert
    verify(pCollection).iterator();
    assertTrue(actualCreateWithNaturalOrderResult.isEmpty());
  }

  /**
   * Test {@link OrderStatisticSet#createWithNaturalOrder(Iterable)}.
   * <ul>
   *   <li>Given {@code Element}.</li>
   *   <li>When createSet add {@code Element}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticSet#createWithNaturalOrder(Iterable)}
   */
  @Test
  public void testCreateWithNaturalOrder_givenElement_whenCreateSetAddElement() {
    // Arrange
    NaiveOrderStatisticSet<Object> pCollection = NaiveOrderStatisticSet.createSet();
    pCollection.add("Element");

    // Act
    OrderStatisticSet<Object> actualCreateWithNaturalOrderResult = OrderStatisticSet
        .createWithNaturalOrder(pCollection);

    // Assert
    assertEquals(pCollection, actualCreateWithNaturalOrderResult);
  }

  /**
   * Test {@link OrderStatisticSet#createWithNaturalOrder(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticSet#createWithNaturalOrder(Iterable)}
   */
  @Test
  public void testCreateWithNaturalOrder_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    OrderStatisticSet<Object> actualCreateWithNaturalOrderResult = OrderStatisticSet
        .createWithNaturalOrder(new ArrayList<>());

    // Assert
    assertTrue(actualCreateWithNaturalOrderResult.isEmpty());
  }

  /**
   * Test {@link OrderStatisticSet#createWithNaturalOrder(Iterable)}.
   * <ul>
   *   <li>When createSet.</li>
   *   <li>Then return createSet.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticSet#createWithNaturalOrder(Iterable)}
   */
  @Test
  public void testCreateWithNaturalOrder_whenCreateSet_thenReturnCreateSet() {
    // Arrange
    NaiveOrderStatisticSet<Object> pCollection = NaiveOrderStatisticSet.createSet();

    // Act
    OrderStatisticSet<Object> actualCreateWithNaturalOrderResult = OrderStatisticSet
        .createWithNaturalOrder(pCollection);

    // Assert
    assertEquals(pCollection, actualCreateWithNaturalOrderResult);
  }

  /**
   * Test {@link OrderStatisticSet#createWithSameOrder(SortedSet)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link TreeSet#TreeSet()} add {@code 42}.</li>
   *   <li>Then return {@link TreeSet#TreeSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticSet#createWithSameOrder(SortedSet)}
   */
  @Test
  public void testCreateWithSameOrder_given42_whenTreeSetAdd42_thenReturnTreeSet() {
    // Arrange
    TreeSet<Object> pSortedSet = new TreeSet<>();
    pSortedSet.add("42");

    // Act
    OrderStatisticSet<Object> actualCreateWithSameOrderResult = OrderStatisticSet.createWithSameOrder(pSortedSet);

    // Assert
    assertEquals(pSortedSet, actualCreateWithSameOrderResult);
  }

  /**
   * Test {@link OrderStatisticSet#createWithSameOrder(SortedSet)}.
   * <ul>
   *   <li>Given {@code Element}.</li>
   *   <li>When createSet add {@code Element}.</li>
   *   <li>Then return createSet.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticSet#createWithSameOrder(SortedSet)}
   */
  @Test
  public void testCreateWithSameOrder_givenElement_whenCreateSetAddElement_thenReturnCreateSet() {
    // Arrange
    NaiveOrderStatisticSet<Object> pSortedSet = NaiveOrderStatisticSet.createSet();
    pSortedSet.add("Element");

    // Act
    OrderStatisticSet<Object> actualCreateWithSameOrderResult = OrderStatisticSet.createWithSameOrder(pSortedSet);

    // Assert
    assertEquals(pSortedSet, actualCreateWithSameOrderResult);
  }

  /**
   * Test {@link OrderStatisticSet#createWithSameOrder(SortedSet)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link TreeSet#TreeSet()} add {@code foo}.</li>
   *   <li>Then return {@link TreeSet#TreeSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticSet#createWithSameOrder(SortedSet)}
   */
  @Test
  public void testCreateWithSameOrder_givenFoo_whenTreeSetAddFoo_thenReturnTreeSet() {
    // Arrange
    TreeSet<Object> pSortedSet = new TreeSet<>();
    pSortedSet.add("foo");
    pSortedSet.add("42");

    // Act
    OrderStatisticSet<Object> actualCreateWithSameOrderResult = OrderStatisticSet.createWithSameOrder(pSortedSet);

    // Assert
    assertEquals(pSortedSet, actualCreateWithSameOrderResult);
  }

  /**
   * Test {@link OrderStatisticSet#createWithSameOrder(SortedSet)}.
   * <ul>
   *   <li>When createSet.</li>
   *   <li>Then return createSet.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticSet#createWithSameOrder(SortedSet)}
   */
  @Test
  public void testCreateWithSameOrder_whenCreateSet_thenReturnCreateSet() {
    // Arrange
    NaiveOrderStatisticSet<Object> pSortedSet = NaiveOrderStatisticSet.createSet();

    // Act
    OrderStatisticSet<Object> actualCreateWithSameOrderResult = OrderStatisticSet.createWithSameOrder(pSortedSet);

    // Assert
    assertEquals(pSortedSet, actualCreateWithSameOrderResult);
  }

  /**
   * Test {@link OrderStatisticSet#createWithSameOrder(SortedSet)}.
   * <ul>
   *   <li>When {@link TreeSet#TreeSet()}.</li>
   *   <li>Then return {@link TreeSet#TreeSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderStatisticSet#createWithSameOrder(SortedSet)}
   */
  @Test
  public void testCreateWithSameOrder_whenTreeSet_thenReturnTreeSet() {
    // Arrange
    TreeSet<Object> pSortedSet = new TreeSet<>();

    // Act
    OrderStatisticSet<Object> actualCreateWithSameOrderResult = OrderStatisticSet.createWithSameOrder(pSortedSet);

    // Assert
    assertEquals(pSortedSet, actualCreateWithSameOrderResult);
  }
}
