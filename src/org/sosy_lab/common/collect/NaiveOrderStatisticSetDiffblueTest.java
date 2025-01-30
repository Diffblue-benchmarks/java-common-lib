package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.Test;

public class NaiveOrderStatisticSetDiffblueTest {
  /**
   * Test {@link NaiveOrderStatisticSet#createSet()}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createSet()}
   */
  @Test
  public void testCreateSet() {
    // Arrange and Act
    NaiveOrderStatisticSet<Object> actualCreateSetResult = NaiveOrderStatisticSet.createSet();

    // Assert
    assertTrue(actualCreateSetResult.isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticSet#createSet(Comparator)} with {@code Comparator}.
   * <ul>
   *   <li>When {@link Comparator}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createSet(Comparator)}
   */
  @Test
  public void testCreateSetWithComparator_whenComparator_thenReturnEmpty() {
    // Arrange and Act
    NaiveOrderStatisticSet<Object> actualCreateSetResult = NaiveOrderStatisticSet
        .<Object>createSet(mock(Comparator.class));

    // Assert
    assertTrue(actualCreateSetResult.isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticSet#createSetWithNaturalOrder(Iterable)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createSetWithNaturalOrder(Iterable)}
   */
  @Test
  public void testCreateSetWithNaturalOrder_givenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Iterable<Object> pSet = mock(Iterable.class);
    when(pSet.iterator()).thenReturn(objectList.iterator());

    // Act
    NaiveOrderStatisticSet<Object> actualCreateSetWithNaturalOrderResult = NaiveOrderStatisticSet
        .createSetWithNaturalOrder(pSet);

    // Assert
    verify(pSet).iterator();
    assertEquals(1, actualCreateSetWithNaturalOrderResult.size());
  }

  /**
   * Test {@link NaiveOrderStatisticSet#createSetWithNaturalOrder(Iterable)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createSetWithNaturalOrder(Iterable)}
   */
  @Test
  public void testCreateSetWithNaturalOrder_givenArrayListIterator_thenReturnEmpty() {
    // Arrange
    Iterable<Object> pSet = mock(Iterable.class);

    ArrayList<Object> objectList = new ArrayList<>();
    when(pSet.iterator()).thenReturn(objectList.iterator());

    // Act
    NaiveOrderStatisticSet<Object> actualCreateSetWithNaturalOrderResult = NaiveOrderStatisticSet
        .createSetWithNaturalOrder(pSet);

    // Assert
    verify(pSet).iterator();
    assertTrue(actualCreateSetWithNaturalOrderResult.isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticSet#createSetWithNaturalOrder(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createSetWithNaturalOrder(Iterable)}
   */
  @Test
  public void testCreateSetWithNaturalOrder_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    NaiveOrderStatisticSet<Object> actualCreateSetWithNaturalOrderResult = NaiveOrderStatisticSet
        .createSetWithNaturalOrder(new ArrayList<>());

    // Assert
    assertTrue(actualCreateSetWithNaturalOrderResult.isEmpty());
  }

  /**
   * Test {@link NaiveOrderStatisticSet#createSetWithSameOrder(SortedSet)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link TreeSet#TreeSet()} add {@code 42}.</li>
   *   <li>Then return {@link TreeSet#TreeSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createSetWithSameOrder(SortedSet)}
   */
  @Test
  public void testCreateSetWithSameOrder_given42_whenTreeSetAdd42_thenReturnTreeSet() {
    // Arrange
    TreeSet<Object> pSortedSet = new TreeSet<>();
    pSortedSet.add("42");

    // Act
    NaiveOrderStatisticSet<Object> actualCreateSetWithSameOrderResult = NaiveOrderStatisticSet
        .createSetWithSameOrder(pSortedSet);

    // Assert
    assertEquals(pSortedSet, actualCreateSetWithSameOrderResult);
  }

  /**
   * Test {@link NaiveOrderStatisticSet#createSetWithSameOrder(SortedSet)}.
   * <ul>
   *   <li>Given {@code Element}.</li>
   *   <li>When createSet add {@code Element}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createSetWithSameOrder(SortedSet)}
   */
  @Test
  public void testCreateSetWithSameOrder_givenElement_whenCreateSetAddElement() {
    // Arrange
    NaiveOrderStatisticSet<Object> pSortedSet = NaiveOrderStatisticSet.createSet();
    pSortedSet.add("Element");

    // Act
    NaiveOrderStatisticSet<Object> actualCreateSetWithSameOrderResult = NaiveOrderStatisticSet
        .createSetWithSameOrder(pSortedSet);

    // Assert
    assertEquals(pSortedSet, actualCreateSetWithSameOrderResult);
  }

  /**
   * Test {@link NaiveOrderStatisticSet#createSetWithSameOrder(SortedSet)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link TreeSet#TreeSet()} add {@code foo}.</li>
   *   <li>Then return {@link TreeSet#TreeSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createSetWithSameOrder(SortedSet)}
   */
  @Test
  public void testCreateSetWithSameOrder_givenFoo_whenTreeSetAddFoo_thenReturnTreeSet() {
    // Arrange
    TreeSet<Object> pSortedSet = new TreeSet<>();
    pSortedSet.add("foo");
    pSortedSet.add("42");

    // Act
    NaiveOrderStatisticSet<Object> actualCreateSetWithSameOrderResult = NaiveOrderStatisticSet
        .createSetWithSameOrder(pSortedSet);

    // Assert
    assertEquals(pSortedSet, actualCreateSetWithSameOrderResult);
  }

  /**
   * Test {@link NaiveOrderStatisticSet#createSetWithSameOrder(SortedSet)}.
   * <ul>
   *   <li>When createSet.</li>
   *   <li>Then return createSet.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createSetWithSameOrder(SortedSet)}
   */
  @Test
  public void testCreateSetWithSameOrder_whenCreateSet_thenReturnCreateSet() {
    // Arrange
    NaiveOrderStatisticSet<Object> pSortedSet = NaiveOrderStatisticSet.createSet();

    // Act
    NaiveOrderStatisticSet<Object> actualCreateSetWithSameOrderResult = NaiveOrderStatisticSet
        .createSetWithSameOrder(pSortedSet);

    // Assert
    assertEquals(pSortedSet, actualCreateSetWithSameOrderResult);
  }

  /**
   * Test {@link NaiveOrderStatisticSet#createSetWithSameOrder(SortedSet)}.
   * <ul>
   *   <li>When {@link TreeSet#TreeSet()}.</li>
   *   <li>Then return {@link TreeSet#TreeSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createSetWithSameOrder(SortedSet)}
   */
  @Test
  public void testCreateSetWithSameOrder_whenTreeSet_thenReturnTreeSet() {
    // Arrange
    TreeSet<Object> pSortedSet = new TreeSet<>();

    // Act
    NaiveOrderStatisticSet<Object> actualCreateSetWithSameOrderResult = NaiveOrderStatisticSet
        .createSetWithSameOrder(pSortedSet);

    // Assert
    assertEquals(pSortedSet, actualCreateSetWithSameOrderResult);
  }

  /**
   * Test {@link NaiveOrderStatisticSet#createView(NavigableSet)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link TreeSet#TreeSet()} add {@code 42}.</li>
   *   <li>Then return {@link TreeSet#TreeSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createView(NavigableSet)}
   */
  @Test
  public void testCreateView_given42_whenTreeSetAdd42_thenReturnTreeSet() {
    // Arrange
    TreeSet<Object> pNavigableSet = new TreeSet<>();
    pNavigableSet.add("42");

    // Act
    NaiveOrderStatisticSet<Object> actualCreateViewResult = NaiveOrderStatisticSet.createView(pNavigableSet);

    // Assert
    assertEquals(pNavigableSet, actualCreateViewResult);
  }

  /**
   * Test {@link NaiveOrderStatisticSet#createView(NavigableSet)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link TreeSet#TreeSet()} add {@code foo}.</li>
   *   <li>Then return {@link TreeSet#TreeSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createView(NavigableSet)}
   */
  @Test
  public void testCreateView_givenFoo_whenTreeSetAddFoo_thenReturnTreeSet() {
    // Arrange
    TreeSet<Object> pNavigableSet = new TreeSet<>();
    pNavigableSet.add("foo");
    pNavigableSet.add("42");

    // Act
    NaiveOrderStatisticSet<Object> actualCreateViewResult = NaiveOrderStatisticSet.createView(pNavigableSet);

    // Assert
    assertEquals(pNavigableSet, actualCreateViewResult);
  }

  /**
   * Test {@link NaiveOrderStatisticSet#createView(NavigableSet)}.
   * <ul>
   *   <li>When {@link TreeSet#TreeSet()}.</li>
   *   <li>Then return {@link TreeSet#TreeSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#createView(NavigableSet)}
   */
  @Test
  public void testCreateView_whenTreeSet_thenReturnTreeSet() {
    // Arrange
    TreeSet<Object> pNavigableSet = new TreeSet<>();

    // Act
    NaiveOrderStatisticSet<Object> actualCreateViewResult = NaiveOrderStatisticSet.createView(pNavigableSet);

    // Assert
    assertEquals(pNavigableSet, actualCreateViewResult);
  }

  /**
   * Test {@link NaiveOrderStatisticSet#delegate()}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#delegate()}
   */
  @Test
  public void testDelegate() {
    // Arrange
    NaiveOrderStatisticSet<Object> createSetResult = NaiveOrderStatisticSet.createSet();

    // Act and Assert
    assertEquals(createSetResult, createSetResult.delegate());
  }

  /**
   * Test {@link NaiveOrderStatisticSet#getByRank(int)}.
   * <ul>
   *   <li>Given createSet add {@code 42}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@code Element}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#getByRank(int)}
   */
  @Test
  public void testGetByRank_givenCreateSetAdd42_whenOne_thenReturnElement() {
    // Arrange
    NaiveOrderStatisticSet<Object> createSetResult = NaiveOrderStatisticSet.createSet();
    createSetResult.add("42");
    createSetResult.add("Element");

    // Act and Assert
    assertEquals("Element", createSetResult.getByRank(1));
  }

  /**
   * Test {@link NaiveOrderStatisticSet#removeByRank(int)}.
   * <ul>
   *   <li>Given createSet add {@code 42}.</li>
   *   <li>When one.</li>
   *   <li>Then createSet size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#removeByRank(int)}
   */
  @Test
  public void testRemoveByRank_givenCreateSetAdd42_whenOne_thenCreateSetSizeIsOne() {
    // Arrange
    NaiveOrderStatisticSet<Object> createSetResult = NaiveOrderStatisticSet.createSet();
    createSetResult.add("42");
    createSetResult.add("Element");

    // Act
    Object actualRemoveByRankResult = createSetResult.removeByRank(1);

    // Assert
    assertEquals(1, createSetResult.size());
    assertEquals("Element", actualRemoveByRankResult);
  }

  /**
   * Test {@link NaiveOrderStatisticSet#rankOf(Object)}.
   * <ul>
   *   <li>Given createSet add {@code Element}.</li>
   *   <li>When {@code P Obj}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#rankOf(Object)}
   */
  @Test
  public void testRankOf_givenCreateSetAddElement_whenPObj_thenReturnMinusOne() {
    // Arrange
    NaiveOrderStatisticSet<Object> createSetResult = NaiveOrderStatisticSet.createSet();
    createSetResult.add("Element");

    // Act and Assert
    assertEquals(-1, createSetResult.rankOf("P Obj"));
  }

  /**
   * Test {@link NaiveOrderStatisticSet#rankOf(Object)}.
   * <ul>
   *   <li>Given createSet.</li>
   *   <li>When {@code P Obj}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#rankOf(Object)}
   */
  @Test
  public void testRankOf_givenCreateSet_whenPObj_thenReturnMinusOne() {
    // Arrange
    NaiveOrderStatisticSet<Object> createSetResult = NaiveOrderStatisticSet.createSet();

    // Act and Assert
    assertEquals(-1, createSetResult.rankOf("P Obj"));
  }

  /**
   * Test {@link NaiveOrderStatisticSet#descendingSet()}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#descendingSet()}
   */
  @Test
  public void testDescendingSet() {
    // Arrange
    NaiveOrderStatisticSet<Object> createSetResult = NaiveOrderStatisticSet.createSet();

    // Act and Assert
    assertEquals(createSetResult, createSetResult.descendingSet());
  }

  /**
   * Test {@link NaiveOrderStatisticSet#subSet(Object, boolean, Object, boolean)} with {@code fromElement}, {@code fromInclusive}, {@code toElement}, {@code toInclusive}.
   * <ul>
   *   <li>Then return createSet.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#subSet(Object, boolean, Object, boolean)}
   */
  @Test
  public void testSubSetWithFromElementFromInclusiveToElementToInclusive_thenReturnCreateSet() {
    // Arrange
    NaiveOrderStatisticSet<Object> createSetResult = NaiveOrderStatisticSet.createSet();

    // Act and Assert
    assertEquals(createSetResult, createSetResult.subSet("From Element", true, "To Element", true));
  }

  /**
   * Test {@link NaiveOrderStatisticSet#subSet(Object, Object)} with {@code fromElement}, {@code toElement}.
   * <ul>
   *   <li>When {@code From Element}.</li>
   *   <li>Then return createSet.</li>
   * </ul>
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#subSet(Object, Object)}
   */
  @Test
  public void testSubSetWithFromElementToElement_whenFromElement_thenReturnCreateSet() {
    // Arrange
    NaiveOrderStatisticSet<Object> createSetResult = NaiveOrderStatisticSet.createSet();

    // Act and Assert
    assertEquals(createSetResult, createSetResult.subSet("From Element", "To Element"));
  }

  /**
   * Test {@link NaiveOrderStatisticSet#headSet(Object)} with {@code toElement}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#headSet(Object)}
   */
  @Test
  public void testHeadSetWithToElement() {
    // Arrange
    NaiveOrderStatisticSet<Object> createSetResult = NaiveOrderStatisticSet.createSet();

    // Act and Assert
    assertEquals(createSetResult, createSetResult.headSet("To Element"));
  }

  /**
   * Test {@link NaiveOrderStatisticSet#headSet(Object, boolean)} with {@code toElement}, {@code inclusive}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#headSet(Object, boolean)}
   */
  @Test
  public void testHeadSetWithToElementInclusive() {
    // Arrange
    NaiveOrderStatisticSet<Object> createSetResult = NaiveOrderStatisticSet.createSet();

    // Act and Assert
    assertEquals(createSetResult, createSetResult.headSet("To Element", true));
  }

  /**
   * Test {@link NaiveOrderStatisticSet#tailSet(Object)} with {@code fromElement}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#tailSet(Object)}
   */
  @Test
  public void testTailSetWithFromElement() {
    // Arrange
    NaiveOrderStatisticSet<Object> createSetResult = NaiveOrderStatisticSet.createSet();

    // Act and Assert
    assertEquals(createSetResult, createSetResult.tailSet("From Element"));
  }

  /**
   * Test {@link NaiveOrderStatisticSet#tailSet(Object, boolean)} with {@code fromElement}, {@code inclusive}.
   * <p>
   * Method under test: {@link NaiveOrderStatisticSet#tailSet(Object, boolean)}
   */
  @Test
  public void testTailSetWithFromElementInclusive() {
    // Arrange
    NaiveOrderStatisticSet<Object> createSetResult = NaiveOrderStatisticSet.createSet();

    // Act and Assert
    assertEquals(createSetResult, createSetResult.tailSet("From Element", true));
  }
}
