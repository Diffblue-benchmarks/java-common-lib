package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import org.junit.Test;

public class PersistentLinkedListDiffblueTest {
  /**
   * Test {@link PersistentLinkedList#of(Object, Object, Object)} with {@code v1}, {@code v2}, {@code v3}.
   * <ul>
   *   <li>When {@code V1}.</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistentLinkedList#of(Object, Object, Object)}
   */
  @Test
  public void testOfWithV1V2V3_whenV1_thenReturnSizeIsThree() {
    // Arrange and Act
    PersistentLinkedList<Object> actualOfResult = PersistentLinkedList.of("V1", "V2", "V3");

    // Assert
    assertEquals(3, actualOfResult.size());
    assertEquals("V1", actualOfResult.get(0));
    assertEquals("V2", actualOfResult.get(1));
    assertEquals("V3", actualOfResult.get(2));
  }

  /**
   * Test {@link PersistentLinkedList#of(Object, Object)} with {@code v1}, {@code v2}.
   * <ul>
   *   <li>When {@code V1}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistentLinkedList#of(Object, Object)}
   */
  @Test
  public void testOfWithV1V2_whenV1_thenReturnSizeIsTwo() {
    // Arrange and Act
    PersistentLinkedList<Object> actualOfResult = PersistentLinkedList.of("V1", "V2");

    // Assert
    assertEquals(2, actualOfResult.size());
    assertEquals("V1", actualOfResult.get(0));
    assertEquals("V2", actualOfResult.get(1));
  }

  /**
   * Test {@link PersistentLinkedList#of(Object, Object[])} with {@code v1}, {@code values}.
   * <ul>
   *   <li>When {@code V1}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistentLinkedList#of(Object, Object[])}
   */
  @Test
  public void testOfWithV1Values_whenV1_thenReturnSizeIsTwo() {
    // Arrange and Act
    PersistentLinkedList<Object> actualOfResult = PersistentLinkedList.of("V1", "Values");

    // Assert
    assertEquals(2, actualOfResult.size());
    assertEquals("V1", actualOfResult.get(0));
    assertEquals("Values", actualOfResult.get(1));
  }

  /**
   * Test {@link PersistentLinkedList#of(Object)} with {@code value}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistentLinkedList#of(Object)}
   */
  @Test
  public void testOfWithValue_whenValue_thenReturnSizeIsOne() {
    // Arrange and Act
    PersistentLinkedList<Object> actualOfResult = PersistentLinkedList.of("Value");

    // Assert
    assertEquals(1, actualOfResult.size());
    assertEquals("Value", actualOfResult.get(0));
  }

  /**
   * Test {@link PersistentLinkedList#copyOf(Object[])} with {@code Object[]}.
   * <p>
   * Method under test: {@link PersistentLinkedList#copyOf(Object[])}
   */
  @Test
  public void testCopyOfWithObject() {
    // Arrange and Act
    PersistentLinkedList<Object> actualCopyOfResult = PersistentLinkedList.copyOf("Values");

    // Assert
    assertEquals(1, actualCopyOfResult.size());
    assertEquals("Values", actualCopyOfResult.get(0));
  }

  /**
   * Test {@link PersistentLinkedList#with(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistentLinkedList#with(Object)}
   */
  @Test
  public void testWith_whenValue_thenReturnSizeIsOne() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    // Act
    PersistentLinkedList<Object> actualWithResult = ofResult.with("Value");

    // Assert
    assertEquals(1, actualWithResult.size());
    assertEquals("Value", actualWithResult.get(0));
  }

  /**
   * Test {@link PersistentLinkedList#withAll(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistentLinkedList#withAll(List)}
   */
  @Test
  public void testWithAll_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    ArrayList<Object> values = new ArrayList<>();
    values.add("42");
    values.add("42");

    // Act and Assert
    assertEquals(values, ofResult.withAll(values));
  }

  /**
   * Test {@link PersistentLinkedList#withAll(List)}.
   * <ul>
   *   <li>Given {@code Values}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code Values}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistentLinkedList#withAll(List)}
   */
  @Test
  public void testWithAll_givenValues_whenArrayListAddValues_thenReturnArrayList() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    ArrayList<Object> values = new ArrayList<>();
    values.add("Values");

    // Act and Assert
    assertEquals(values, ofResult.withAll(values));
  }

  /**
   * Test {@link PersistentLinkedList#withAll(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link PersistentLinkedList}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistentLinkedList#withAll(List)}
   */
  @Test
  public void testWithAll_whenArrayList_thenReturnPersistentLinkedList() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    // Act and Assert
    assertSame(ofResult, ofResult.withAll(new ArrayList<>()));
  }

  /**
   * Test {@link PersistentLinkedList#without(Object)}.
   * <p>
   * Method under test: {@link PersistentLinkedList#without(Object)}
   */
  @Test
  public void testWithout() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    // Act and Assert
    assertSame(ofResult, ofResult.without("Value"));
  }

  /**
   * Test {@link PersistentLinkedList#empty()}.
   * <p>
   * Method under test: {@link PersistentLinkedList#empty()}
   */
  @Test
  public void testEmpty() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    // Act and Assert
    assertSame(ofResult, ofResult.empty());
  }

  /**
   * Test {@link PersistentLinkedList#size()}.
   * <p>
   * Method under test: {@link PersistentLinkedList#size()}
   */
  @Test
  public void testSize() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    // Act and Assert
    assertEquals(0, ofResult.size());
  }

  /**
   * Test {@link PersistentLinkedList#isEmpty()}.
   * <p>
   * Method under test: {@link PersistentLinkedList#isEmpty()}
   */
  @Test
  public void testIsEmpty() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    // Act and Assert
    assertTrue(ofResult.isEmpty());
  }

  /**
   * Test {@link PersistentLinkedList#reversed()}.
   * <p>
   * Method under test: {@link PersistentLinkedList#reversed()}
   */
  @Test
  public void testReversed() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    // Act and Assert
    assertSame(ofResult, ofResult.reversed());
  }

  /**
   * Test {@link PersistentLinkedList#iterator()}.
   * <p>
   * Method under test: {@link PersistentLinkedList#iterator()}
   */
  @Test
  public void testIterator() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    // Act and Assert
    assertFalse(ofResult.iterator().hasNext());
  }

  /**
   * Test {@link PersistentLinkedList#listIterator(int)} with {@code int}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistentLinkedList#listIterator(int)}
   */
  @Test
  public void testListIteratorWithInt_whenZero_thenReturnNotHasNext() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    // Act and Assert
    assertFalse(ofResult.listIterator(0).hasNext());
  }

  /**
   * Test {@link PersistentLinkedList#replaceAll(UnaryOperator)}.
   * <p>
   * Method under test: {@link PersistentLinkedList#replaceAll(UnaryOperator)}
   */
  @Test
  public void testReplaceAll() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ofResult.replaceAll(mock(UnaryOperator.class)));
  }

  /**
   * Test {@link PersistentLinkedList#sort(Comparator)}.
   * <p>
   * Method under test: {@link PersistentLinkedList#sort(Comparator)}
   */
  @Test
  public void testSort() {
    // Arrange
    PersistentLinkedList<Object> ofResult = PersistentLinkedList.of();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> ofResult.sort(mock(Comparator.class)));
  }
}
