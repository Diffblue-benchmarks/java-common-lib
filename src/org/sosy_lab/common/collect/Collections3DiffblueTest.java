package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.mockito.Mockito;

public class Collections3DiffblueTest {
  /**
   * Test {@link Collections3#allElementsEqual(Object[])} with {@code array}.
   * <ul>
   *   <li>When array of {@link Object} with {@code Array} and {@code Array}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#allElementsEqual(Object[])}
   */
  @Test
  public void testAllElementsEqualWithArray_whenArrayOfObjectWithArrayAndArray_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Collections3.allElementsEqual(new Object[]{"Array", "Array"}));
  }

  /**
   * Test {@link Collections3#allElementsEqual(Object[])} with {@code array}.
   * <ul>
   *   <li>When array of {@link Object} with {@code Array}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#allElementsEqual(Object[])}
   */
  @Test
  public void testAllElementsEqualWithArray_whenArrayOfObjectWithArray_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Collections3.allElementsEqual(new Object[]{"Array"}));
  }

  /**
   * Test {@link Collections3#allElementsEqual(Object[])} with {@code array}.
   * <ul>
   *   <li>When array of {@link Object} with one and {@code Array}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#allElementsEqual(Object[])}
   */
  @Test
  public void testAllElementsEqualWithArray_whenArrayOfObjectWithOneAndArray_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Collections3.allElementsEqual(new Object[]{1, "Array"}));
  }

  /**
   * Test {@link Collections3#allElementsEqual(Iterable)} with {@code iterable}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#allElementsEqual(Iterable)}
   */
  @Test
  public void testAllElementsEqualWithIterable_given42_whenArrayListAdd42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> iterable = new ArrayList<>();
    iterable.add("42");

    // Act and Assert
    assertTrue(Collections3.allElementsEqual(iterable));
  }

  /**
   * Test {@link Collections3#allElementsEqual(Iterable)} with {@code iterable}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#allElementsEqual(Iterable)}
   */
  @Test
  public void testAllElementsEqualWithIterable_given42_whenArrayListAdd42_thenReturnTrue2() {
    // Arrange
    ArrayList<Object> iterable = new ArrayList<>();
    iterable.add("42");
    iterable.add("42");

    // Act and Assert
    assertTrue(Collections3.allElementsEqual(iterable));
  }

  /**
   * Test {@link Collections3#allElementsEqual(Iterable)} with {@code iterable}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#allElementsEqual(Iterable)}
   */
  @Test
  public void testAllElementsEqualWithIterable_givenTwo_whenArrayListAddTwo_thenReturnFalse() {
    // Arrange
    ArrayList<Object> iterable = new ArrayList<>();
    iterable.add(2);
    iterable.add("42");

    // Act and Assert
    assertFalse(Collections3.allElementsEqual(iterable));
  }

  /**
   * Test {@link Collections3#allElementsEqual(Stream)} with {@code stream}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#allElementsEqual(Stream)}
   */
  @Test
  public void testAllElementsEqualWithStream_given42_whenArrayListAdd42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Stream<Object> stream = objectList.stream();

    // Act and Assert
    assertTrue(Collections3.allElementsEqual(stream));
  }

  /**
   * Test {@link Collections3#allElementsEqual(Stream)} with {@code stream}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#allElementsEqual(Stream)}
   */
  @Test
  public void testAllElementsEqualWithStream_given42_whenArrayListAdd42_thenReturnTrue2() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    objectList.add("42");
    Stream<Object> stream = objectList.stream();

    // Act and Assert
    assertTrue(Collections3.allElementsEqual(stream));
  }

  /**
   * Test {@link Collections3#allElementsEqual(Stream)} with {@code stream}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#allElementsEqual(Stream)}
   */
  @Test
  public void testAllElementsEqualWithStream_givenTwo_whenArrayListAddTwo_thenReturnFalse() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(2);
    objectList.add("42");
    Stream<Object> stream = objectList.stream();

    // Act and Assert
    assertFalse(Collections3.allElementsEqual(stream));
  }

  /**
   * Test {@link Collections3#transformedImmutableListCopy(Object[], Function)} with {@code Object[]}, {@code Function}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#transformedImmutableListCopy(Object[], Function)}
   */
  @Test
  public void testTransformedImmutableListCopyWithObjectFunction_thenReturnEmpty() {
    // Arrange and Act
    ImmutableList<Object> actualTransformedImmutableListCopyResult = Collections3
        .<Object, Object>transformedImmutableListCopy(new Object[]{}, mock(Function.class));

    // Assert
    assertTrue(actualTransformedImmutableListCopyResult.isEmpty());
  }

  /**
   * Test {@link Collections3#transformedImmutableListCopy(Object[], Function)} with {@code Object[]}, {@code Function}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#transformedImmutableListCopy(Object[], Function)}
   */
  @Test
  public void testTransformedImmutableListCopyWithObjectFunction_thenReturnSizeIsOne() {
    // Arrange
    Function<Object, Object> transformer = mock(Function.class);
    when(transformer.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    ImmutableList<Object> actualTransformedImmutableListCopyResult = Collections3
        .transformedImmutableListCopy(new Object[]{"Input"}, transformer);

    // Assert
    verify(transformer).apply(isA(Object.class));
    assertEquals(1, actualTransformedImmutableListCopyResult.size());
    assertEquals("Apply", actualTransformedImmutableListCopyResult.get(0));
  }

  /**
   * Test {@link Collections3#transformedImmutableListCopy(Object[], Function)} with {@code Object[]}, {@code Function}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#transformedImmutableListCopy(Object[], Function)}
   */
  @Test
  public void testTransformedImmutableListCopyWithObjectFunction_thenReturnSizeIsTwo() {
    // Arrange
    Function<Object, Object> transformer = mock(Function.class);
    when(transformer.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    ImmutableList<Object> actualTransformedImmutableListCopyResult = Collections3
        .transformedImmutableListCopy(new Object[]{"Input", "Input"}, transformer);

    // Assert
    verify(transformer, atLeast(1)).apply(isA(Object.class));
    assertEquals(2, actualTransformedImmutableListCopyResult.size());
    assertEquals("Apply", actualTransformedImmutableListCopyResult.get(0));
    assertEquals("Apply", actualTransformedImmutableListCopyResult.get(1));
  }

  /**
   * Test {@link Collections3#transformedImmutableSetCopy(Collection, Function)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#transformedImmutableSetCopy(Collection, Function)}
   */
  @Test
  public void testTransformedImmutableSetCopy_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> input = new ArrayList<>();
    input.add("42");
    Function<Object, Object> transformer = mock(Function.class);
    when(transformer.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    ImmutableSet<Object> actualTransformedImmutableSetCopyResult = Collections3.transformedImmutableSetCopy(input,
        transformer);

    // Assert
    verify(transformer).apply(isA(Object.class));
    assertEquals(1, actualTransformedImmutableSetCopyResult.size());
  }

  /**
   * Test {@link Collections3#transformedImmutableSetCopy(Collection, Function)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#transformedImmutableSetCopy(Collection, Function)}
   */
  @Test
  public void testTransformedImmutableSetCopy_given42_whenArrayListAdd42_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Object> input = new ArrayList<>();
    input.add("42");
    input.add("42");
    Function<Object, Object> transformer = mock(Function.class);
    when(transformer.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    ImmutableSet<Object> actualTransformedImmutableSetCopyResult = Collections3.transformedImmutableSetCopy(input,
        transformer);

    // Assert
    verify(transformer, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualTransformedImmutableSetCopyResult.size());
  }

  /**
   * Test {@link Collections3#transformedImmutableSetCopy(Collection, Function)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#transformedImmutableSetCopy(Collection, Function)}
   */
  @Test
  public void testTransformedImmutableSetCopy_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    ImmutableSet<Object> actualTransformedImmutableSetCopyResult = Collections3
        .<Object, Object>transformedImmutableSetCopy(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualTransformedImmutableSetCopyResult.isEmpty());
  }

  /**
   * Test {@link Collections3#zipMapEntries(Iterable, BiFunction)} with {@code entries}, {@code func}.
   * <ul>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#zipMapEntries(Iterable, BiFunction)}
   */
  @Test
  public void testZipMapEntriesWithEntriesFunc_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Object> actualZipMapEntriesResult = Collections3.<Object, Object, Object>zipMapEntries(new ArrayList<>(),
        mock(BiFunction.class));

    // Assert
    assertTrue(actualZipMapEntriesResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Collections3#zipMapEntries(Map, BiFunction)} with {@code map}, {@code func}.
   * <ul>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#zipMapEntries(Map, BiFunction)}
   */
  @Test
  public void testZipMapEntriesWithMapFunc_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Object> actualZipMapEntriesResult = Collections3.<Object, Object, Object>zipMapEntries(new HashMap<>(),
        mock(BiFunction.class));

    // Assert
    assertTrue(actualZipMapEntriesResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Collections3#filterByClass(Collection, Class)} with {@code collection}, {@code cls}.
   * <ul>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#filterByClass(Collection, Class)}
   */
  @Test
  public void testFilterByClassWithCollectionCls_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    Class<Object> cls = Object.class;

    // Act
    Stream<Object> actualFilterByClassResult = Collections3.filterByClass(collection, cls);

    // Assert
    assertTrue(actualFilterByClassResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Collections3#filterByClass(Collection, Class)} with {@code collection}, {@code cls}.
   * <ul>
   *   <li>Then return limit five collect toList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#filterByClass(Collection, Class)}
   */
  @Test
  public void testFilterByClassWithCollectionCls_thenReturnLimitFiveCollectToListSizeIsOne() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    Class<Object> cls = Object.class;

    // Act
    Stream<Object> actualFilterByClassResult = Collections3.filterByClass(collection, cls);

    // Assert
    List<Object> collectResult = actualFilterByClassResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("42", collectResult.get(0));
  }

  /**
   * Test {@link Collections3#filterByClass(Collection, Class)} with {@code collection}, {@code cls}.
   * <ul>
   *   <li>Then return limit five collect toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#filterByClass(Collection, Class)}
   */
  @Test
  public void testFilterByClassWithCollectionCls_thenReturnLimitFiveCollectToListSizeIsTwo() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");
    Class<Object> cls = Object.class;

    // Act
    Stream<Object> actualFilterByClassResult = Collections3.filterByClass(collection, cls);

    // Assert
    List<Object> collectResult = actualFilterByClassResult.limit(5).collect(Collectors.toList());
    assertEquals(2, collectResult.size());
    assertEquals("42", collectResult.get(0));
    assertEquals("42", collectResult.get(1));
  }

  /**
   * Test {@link Collections3#filterByClass(Iterable, Class)} with {@code iterable}, {@code cls}.
   * <p>
   * Method under test: {@link Collections3#filterByClass(Iterable, Class)}
   */
  @Test
  public void testFilterByClassWithIterableCls() {
    // Arrange
    ArrayList<Object> iterable = new ArrayList<>();
    Class<Object> cls = Object.class;

    // Act
    Stream<Object> actualFilterByClassResult = Collections3.filterByClass((Iterable<? super Object>) iterable, cls);

    // Assert
    assertTrue(actualFilterByClassResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Collections3#filterByClass(Stream, Class)} with {@code stream}, {@code cls}.
   * <p>
   * Method under test: {@link Collections3#filterByClass(Stream, Class)}
   */
  @Test
  public void testFilterByClassWithStreamCls() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> stream = objectList.stream();
    Class<Object> cls = Object.class;

    // Act
    Stream<Object> actualFilterByClassResult = Collections3.filterByClass(stream, cls);

    // Assert
    assertTrue(actualFilterByClassResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Collections3#elementAndList(Object, Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#elementAndList(Object, Collection)}
   */
  @Test
  public void testElementAndList_given42_whenArrayListAdd42_thenReturnSizeIsThree() {
    // Arrange
    ArrayList<Object> coll = new ArrayList<>();
    coll.add("42");
    coll.add("42");

    // Act
    ImmutableList<Object> actualElementAndListResult = Collections3.elementAndList("Elem", coll);

    // Assert
    assertEquals(3, actualElementAndListResult.size());
    assertEquals("42", actualElementAndListResult.get(1));
    assertEquals("42", actualElementAndListResult.get(2));
  }

  /**
   * Test {@link Collections3#elementAndList(Object, Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#elementAndList(Object, Collection)}
   */
  @Test
  public void testElementAndList_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Object> coll = new ArrayList<>();
    coll.add("42");

    // Act
    ImmutableList<Object> actualElementAndListResult = Collections3.elementAndList("Elem", coll);

    // Assert
    assertEquals(2, actualElementAndListResult.size());
    assertEquals("42", actualElementAndListResult.get(1));
    assertEquals("Elem", actualElementAndListResult.get(0));
  }

  /**
   * Test {@link Collections3#elementAndList(Object, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#elementAndList(Object, Collection)}
   */
  @Test
  public void testElementAndList_whenArrayList_thenReturnSizeIsOne() {
    // Arrange and Act
    ImmutableList<Object> actualElementAndListResult = Collections3.elementAndList("Elem", new ArrayList<>());

    // Assert
    assertEquals(1, actualElementAndListResult.size());
    assertEquals("Elem", actualElementAndListResult.get(0));
  }

  /**
   * Test {@link Collections3#listAndElement(Collection, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#listAndElement(Collection, Object)}
   */
  @Test
  public void testListAndElement_given42_whenArrayListAdd42_thenReturnSizeIsThree() {
    // Arrange
    ArrayList<Object> coll = new ArrayList<>();
    coll.add("42");
    coll.add("42");

    // Act
    ImmutableList<Object> actualListAndElementResult = Collections3.listAndElement(coll, "Elem");

    // Assert
    assertEquals(3, actualListAndElementResult.size());
    assertEquals("42", actualListAndElementResult.get(1));
    assertEquals("Elem", actualListAndElementResult.get(2));
  }

  /**
   * Test {@link Collections3#listAndElement(Collection, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#listAndElement(Collection, Object)}
   */
  @Test
  public void testListAndElement_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Object> coll = new ArrayList<>();
    coll.add("42");

    // Act
    ImmutableList<Object> actualListAndElementResult = Collections3.listAndElement(coll, "Elem");

    // Assert
    assertEquals(2, actualListAndElementResult.size());
    assertEquals("42", actualListAndElementResult.get(0));
    assertEquals("Elem", actualListAndElementResult.get(1));
  }

  /**
   * Test {@link Collections3#listAndElement(Collection, Object)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#listAndElement(Collection, Object)}
   */
  @Test
  public void testListAndElement_whenArrayList_thenReturnSizeIsOne() {
    // Arrange and Act
    ImmutableList<Object> actualListAndElementResult = Collections3.listAndElement(new ArrayList<>(), "Elem");

    // Assert
    assertEquals(1, actualListAndElementResult.size());
    assertEquals("Elem", actualListAndElementResult.get(0));
  }

  /**
   * Test {@link Collections3#elementsAndList(Object, Object, Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#elementsAndList(Object, Object, Collection)}
   */
  @Test
  public void testElementsAndList_given42_whenArrayListAdd42_thenReturnSizeIsFour() {
    // Arrange
    ArrayList<Object> coll = new ArrayList<>();
    coll.add("42");
    coll.add("42");

    // Act
    ImmutableList<Object> actualElementsAndListResult = Collections3.elementsAndList("Elem1", "Elem2", coll);

    // Assert
    assertEquals(4, actualElementsAndListResult.size());
    assertEquals("42", actualElementsAndListResult.get(2));
    assertEquals("42", actualElementsAndListResult.get(3));
  }

  /**
   * Test {@link Collections3#elementsAndList(Object, Object, Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#elementsAndList(Object, Object, Collection)}
   */
  @Test
  public void testElementsAndList_given42_whenArrayListAdd42_thenReturnSizeIsThree() {
    // Arrange
    ArrayList<Object> coll = new ArrayList<>();
    coll.add("42");

    // Act
    ImmutableList<Object> actualElementsAndListResult = Collections3.elementsAndList("Elem1", "Elem2", coll);

    // Assert
    assertEquals(3, actualElementsAndListResult.size());
    assertEquals("42", actualElementsAndListResult.get(2));
    assertEquals("Elem1", actualElementsAndListResult.get(0));
    assertEquals("Elem2", actualElementsAndListResult.get(1));
  }

  /**
   * Test {@link Collections3#elementsAndList(Object, Object, Collection)}.
   * <ul>
   *   <li>When {@code Elem2}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#elementsAndList(Object, Object, Collection)}
   */
  @Test
  public void testElementsAndList_whenElem2_thenReturnSizeIsTwo() {
    // Arrange and Act
    ImmutableList<Object> actualElementsAndListResult = Collections3.elementsAndList("Elem1", "Elem2",
        new ArrayList<>());

    // Assert
    assertEquals(2, actualElementsAndListResult.size());
    assertEquals("Elem1", actualElementsAndListResult.get(0));
    assertEquals("Elem2", actualElementsAndListResult.get(1));
  }

  /**
   * Test {@link Collections3#listAndSurroundingElements(Object, Collection, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#listAndSurroundingElements(Object, Collection, Object)}
   */
  @Test
  public void testListAndSurroundingElements_given42_whenArrayListAdd42_thenReturnSizeIsFour() {
    // Arrange
    ArrayList<Object> coll = new ArrayList<>();
    coll.add("42");
    coll.add("42");

    // Act
    ImmutableList<Object> actualListAndSurroundingElementsResult = Collections3.listAndSurroundingElements("Elem1",
        coll, "Elem2");

    // Assert
    assertEquals(4, actualListAndSurroundingElementsResult.size());
    assertEquals("42", actualListAndSurroundingElementsResult.get(2));
    assertEquals("Elem2", actualListAndSurroundingElementsResult.get(3));
  }

  /**
   * Test {@link Collections3#listAndSurroundingElements(Object, Collection, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#listAndSurroundingElements(Object, Collection, Object)}
   */
  @Test
  public void testListAndSurroundingElements_given42_whenArrayListAdd42_thenReturnSizeIsThree() {
    // Arrange
    ArrayList<Object> coll = new ArrayList<>();
    coll.add("42");

    // Act
    ImmutableList<Object> actualListAndSurroundingElementsResult = Collections3.listAndSurroundingElements("Elem1",
        coll, "Elem2");

    // Assert
    assertEquals(3, actualListAndSurroundingElementsResult.size());
    assertEquals("42", actualListAndSurroundingElementsResult.get(1));
    assertEquals("Elem2", actualListAndSurroundingElementsResult.get(2));
  }

  /**
   * Test {@link Collections3#listAndSurroundingElements(Object, Collection, Object)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#listAndSurroundingElements(Object, Collection, Object)}
   */
  @Test
  public void testListAndSurroundingElements_whenArrayList_thenReturnSizeIsTwo() {
    // Arrange and Act
    ImmutableList<Object> actualListAndSurroundingElementsResult = Collections3.listAndSurroundingElements("Elem1",
        new ArrayList<>(), "Elem2");

    // Assert
    assertEquals(2, actualListAndSurroundingElementsResult.size());
    assertEquals("Elem1", actualListAndSurroundingElementsResult.get(0));
    assertEquals("Elem2", actualListAndSurroundingElementsResult.get(1));
  }

  /**
   * Test {@link Collections3#listAndElements(Collection, Object, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#listAndElements(Collection, Object, Object)}
   */
  @Test
  public void testListAndElements_given42_whenArrayListAdd42_thenReturnSizeIsFour() {
    // Arrange
    ArrayList<Object> coll = new ArrayList<>();
    coll.add("42");
    coll.add("42");

    // Act
    ImmutableList<Object> actualListAndElementsResult = Collections3.listAndElements(coll, "Elem1", "Elem2");

    // Assert
    assertEquals(4, actualListAndElementsResult.size());
    assertEquals("42", actualListAndElementsResult.get(1));
    assertEquals("Elem1", actualListAndElementsResult.get(2));
    assertEquals("Elem2", actualListAndElementsResult.get(3));
  }

  /**
   * Test {@link Collections3#listAndElements(Collection, Object, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#listAndElements(Collection, Object, Object)}
   */
  @Test
  public void testListAndElements_given42_whenArrayListAdd42_thenReturnSizeIsThree() {
    // Arrange
    ArrayList<Object> coll = new ArrayList<>();
    coll.add("42");

    // Act
    ImmutableList<Object> actualListAndElementsResult = Collections3.listAndElements(coll, "Elem1", "Elem2");

    // Assert
    assertEquals(3, actualListAndElementsResult.size());
    assertEquals("42", actualListAndElementsResult.get(0));
    assertEquals("Elem1", actualListAndElementsResult.get(1));
    assertEquals("Elem2", actualListAndElementsResult.get(2));
  }

  /**
   * Test {@link Collections3#listAndElements(Collection, Object, Object)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#listAndElements(Collection, Object, Object)}
   */
  @Test
  public void testListAndElements_whenArrayList_thenReturnSizeIsTwo() {
    // Arrange and Act
    ImmutableList<Object> actualListAndElementsResult = Collections3.listAndElements(new ArrayList<>(), "Elem1",
        "Elem2");

    // Assert
    assertEquals(2, actualListAndElementsResult.size());
    assertEquals("Elem1", actualListAndElementsResult.get(0));
    assertEquals("Elem2", actualListAndElementsResult.get(1));
  }

  /**
   * Test {@link Collections3#subMapWithPrefix(NavigableMap, String)} with {@code NavigableMap}, {@code String}.
   * <ul>
   *   <li>When of.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#subMapWithPrefix(NavigableMap, String)}
   */
  @Test
  public void testSubMapWithPrefixWithNavigableMapString_whenOf_thenReturnEmpty() {
    // Arrange
    ImmutableSortedMap<String, Object> map = ImmutableSortedMap.of();

    // Act
    NavigableMap<String, Object> actualSubMapWithPrefixResult = Collections3.subMapWithPrefix(map, "Prefix");

    // Assert
    assertTrue(actualSubMapWithPrefixResult.isEmpty());
  }

  /**
   * Test {@link Collections3#subMapWithPrefix(NavigableMap, String)} with {@code NavigableMap}, {@code String}.
   * <ul>
   *   <li>When {@link TreeMap#TreeMap()}.</li>
   *   <li>Then return {@link TreeMap#TreeMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#subMapWithPrefix(NavigableMap, String)}
   */
  @Test
  public void testSubMapWithPrefixWithNavigableMapString_whenTreeMap_thenReturnTreeMap() {
    // Arrange
    TreeMap<String, Object> map = new TreeMap<>();

    // Act
    NavigableMap<String, Object> actualSubMapWithPrefixResult = Collections3.subMapWithPrefix(map, "Prefix");

    // Assert
    assertEquals(map, actualSubMapWithPrefixResult);
  }

  /**
   * Test {@link Collections3#subMapWithPrefix(SortedMap, String)} with {@code SortedMap}, {@code String}.
   * <ul>
   *   <li>When of.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#subMapWithPrefix(SortedMap, String)}
   */
  @Test
  public void testSubMapWithPrefixWithSortedMapString_whenOf_thenReturnEmpty() {
    // Arrange
    ImmutableSortedMap<String, Object> map = ImmutableSortedMap.of();

    // Act
    SortedMap<String, Object> actualSubMapWithPrefixResult = Collections3
        .subMapWithPrefix((SortedMap<String, Object>) map, "Prefix");

    // Assert
    assertTrue(actualSubMapWithPrefixResult.isEmpty());
  }

  /**
   * Test {@link Collections3#subMapWithPrefix(SortedMap, String)} with {@code SortedMap}, {@code String}.
   * <ul>
   *   <li>When {@link TreeMap#TreeMap()}.</li>
   *   <li>Then return {@link TreeMap#TreeMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#subMapWithPrefix(SortedMap, String)}
   */
  @Test
  public void testSubMapWithPrefixWithSortedMapString_whenTreeMap_thenReturnTreeMap() {
    // Arrange
    TreeMap<String, Object> map = new TreeMap<>();

    // Act
    SortedMap<String, Object> actualSubMapWithPrefixResult = Collections3
        .subMapWithPrefix((SortedMap<String, Object>) map, "Prefix");

    // Assert
    assertEquals(map, actualSubMapWithPrefixResult);
  }

  /**
   * Test {@link Collections3#subSetWithPrefix(NavigableSet, String)} with {@code NavigableSet}, {@code String}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link TreeSet#TreeSet()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#subSetWithPrefix(NavigableSet, String)}
   */
  @Test
  public void testSubSetWithPrefixWithNavigableSetString_given42_whenTreeSetAdd42() {
    // Arrange
    TreeSet<String> set = new TreeSet<>();
    set.add("42");
    set.add("foo");

    // Act
    NavigableSet<String> actualSubSetWithPrefixResult = Collections3.subSetWithPrefix(set, "Prefix");

    // Assert
    assertTrue(actualSubSetWithPrefixResult.isEmpty());
  }

  /**
   * Test {@link Collections3#subSetWithPrefix(NavigableSet, String)} with {@code NavigableSet}, {@code String}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#subSetWithPrefix(NavigableSet, String)}
   */
  @Test
  public void testSubSetWithPrefixWithNavigableSetString_givenFoo_thenReturnEmpty() {
    // Arrange
    TreeSet<String> set = new TreeSet<>();
    set.add("foo");

    // Act
    NavigableSet<String> actualSubSetWithPrefixResult = Collections3.subSetWithPrefix(set, "Prefix");

    // Assert
    assertTrue(actualSubSetWithPrefixResult.isEmpty());
  }

  /**
   * Test {@link Collections3#subSetWithPrefix(NavigableSet, String)} with {@code NavigableSet}, {@code String}.
   * <ul>
   *   <li>When {@link TreeSet#TreeSet()}.</li>
   *   <li>Then return {@link TreeSet#TreeSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#subSetWithPrefix(NavigableSet, String)}
   */
  @Test
  public void testSubSetWithPrefixWithNavigableSetString_whenTreeSet_thenReturnTreeSet() {
    // Arrange
    TreeSet<String> set = new TreeSet<>();

    // Act
    NavigableSet<String> actualSubSetWithPrefixResult = Collections3.subSetWithPrefix(set, "Prefix");

    // Assert
    assertEquals(set, actualSubSetWithPrefixResult);
  }

  /**
   * Test {@link Collections3#subSetWithPrefix(SortedSet, String)} with {@code SortedSet}, {@code String}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link TreeSet#TreeSet()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#subSetWithPrefix(SortedSet, String)}
   */
  @Test
  public void testSubSetWithPrefixWithSortedSetString_given42_whenTreeSetAdd42_thenReturnEmpty() {
    // Arrange
    TreeSet<String> set = new TreeSet<>();
    set.add("42");
    set.add("foo");

    // Act
    SortedSet<String> actualSubSetWithPrefixResult = Collections3.subSetWithPrefix((SortedSet<String>) set, "Prefix");

    // Assert
    assertTrue(actualSubSetWithPrefixResult.isEmpty());
  }

  /**
   * Test {@link Collections3#subSetWithPrefix(SortedSet, String)} with {@code SortedSet}, {@code String}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#subSetWithPrefix(SortedSet, String)}
   */
  @Test
  public void testSubSetWithPrefixWithSortedSetString_givenFoo_thenReturnEmpty() {
    // Arrange
    TreeSet<String> set = new TreeSet<>();
    set.add("foo");

    // Act
    SortedSet<String> actualSubSetWithPrefixResult = Collections3.subSetWithPrefix((SortedSet<String>) set, "Prefix");

    // Assert
    assertTrue(actualSubSetWithPrefixResult.isEmpty());
  }

  /**
   * Test {@link Collections3#subSetWithPrefix(SortedSet, String)} with {@code SortedSet}, {@code String}.
   * <ul>
   *   <li>When {@link TreeSet#TreeSet()}.</li>
   *   <li>Then return {@link TreeSet#TreeSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#subSetWithPrefix(SortedSet, String)}
   */
  @Test
  public void testSubSetWithPrefixWithSortedSetString_whenTreeSet_thenReturnTreeSet() {
    // Arrange
    TreeSet<String> set = new TreeSet<>();

    // Act
    SortedSet<String> actualSubSetWithPrefixResult = Collections3.subSetWithPrefix((SortedSet<String>) set, "Prefix");

    // Assert
    assertEquals(set, actualSubSetWithPrefixResult);
  }

  /**
   * Test {@link Collections3#guaranteedSameOrder(Comparator, Comparator)}.
   * <p>
   * Method under test: {@link Collections3#guaranteedSameOrder(Comparator, Comparator)}
   */
  @Test
  public void testGuaranteedSameOrder() {
    // Arrange, Act and Assert
    assertFalse(Collections3.guaranteedSameOrder(mock(Comparator.class), mock(Comparator.class)));
  }

  /**
   * Test {@link Collections3#sortedSetEquals(SortedSet, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetEquals(SortedSet, Object)}
   */
  @Test
  public void testSortedSetEquals_given42_whenHashSet_thenReturnFalse() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();
    coll1.add("42");

    // Act and Assert
    assertFalse(Collections3.sortedSetEquals(coll1, new HashSet<>()));
  }

  /**
   * Test {@link Collections3#sortedSetEquals(SortedSet, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code P Coll2}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetEquals(SortedSet, Object)}
   */
  @Test
  public void testSortedSetEquals_given42_whenPColl2_thenReturnFalse() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();
    coll1.add("42");

    // Act and Assert
    assertFalse(Collections3.sortedSetEquals(coll1, "P Coll2"));
  }

  /**
   * Test {@link Collections3#sortedSetEquals(SortedSet, Object)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link TreeSet#TreeSet()} add {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetEquals(SortedSet, Object)}
   */
  @Test
  public void testSortedSetEquals_givenFoo_whenTreeSetAddFoo_thenReturnFalse() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();
    coll1.add("foo");
    coll1.add("42");

    // Act and Assert
    assertFalse(Collections3.sortedSetEquals(coll1, "P Coll2"));
  }

  /**
   * Test {@link Collections3#sortedSetEquals(SortedSet, Object)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetEquals(SortedSet, Object)}
   */
  @Test
  public void testSortedSetEquals_givenTwo_whenHashSetAddTwo_thenReturnFalse() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();
    coll1.add("42");

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(2);

    // Act and Assert
    assertFalse(Collections3.sortedSetEquals(coll1, objectSet));
  }

  /**
   * Test {@link Collections3#sortedSetEquals(SortedSet, Object)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetEquals(SortedSet, Object)}
   */
  @Test
  public void testSortedSetEquals_whenHashSet_thenReturnTrue() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();

    // Act and Assert
    assertTrue(Collections3.sortedSetEquals(coll1, new HashSet<>()));
  }

  /**
   * Test {@link Collections3#sortedSetEquals(SortedSet, Object)}.
   * <ul>
   *   <li>When {@link TreeSet#TreeSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetEquals(SortedSet, Object)}
   */
  @Test
  public void testSortedSetEquals_whenTreeSet_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Collections3.sortedSetEquals(new TreeSet<>(), "P Coll2"));
  }

  /**
   * Test {@link Collections3#sortedSetEquals(SortedSet, Object)}.
   * <ul>
   *   <li>When {@link TreeSet#TreeSet()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetEquals(SortedSet, Object)}
   */
  @Test
  public void testSortedSetEquals_whenTreeSet_thenReturnTrue() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();

    // Act and Assert
    assertTrue(Collections3.sortedSetEquals(coll1, new TreeSet<>()));
  }

  /**
   * Test {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}
   */
  @Test
  public void testSortedSetContainsAll_given42_whenArrayListAdd42_thenReturnTrue() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();
    coll1.add("42");

    ArrayList<Object> pColl2 = new ArrayList<>();
    pColl2.add("42");

    // Act and Assert
    assertTrue(Collections3.sortedSetContainsAll(coll1, pColl2, mock(Equivalence.class)));
  }

  /**
   * Test {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}
   */
  @Test
  public void testSortedSetContainsAll_given42_whenArrayList_thenReturnTrue() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();
    coll1.add("42");

    // Act and Assert
    assertTrue(Collections3.sortedSetContainsAll(coll1, new ArrayList<>(), mock(Equivalence.class)));
  }

  /**
   * Test {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link TreeSet#TreeSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}
   */
  @Test
  public void testSortedSetContainsAll_given42_whenTreeSet_thenReturnFalse() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();

    ArrayList<Object> pColl2 = new ArrayList<>();
    pColl2.add("42");

    // Act and Assert
    assertFalse(Collections3.sortedSetContainsAll(coll1, pColl2, mock(Equivalence.class)));
  }

  /**
   * Test {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link TreeSet#TreeSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}
   */
  @Test
  public void testSortedSetContainsAll_given42_whenTreeSet_thenReturnFalse2() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();

    ArrayList<Object> pColl2 = new ArrayList<>();
    pColl2.add("42");
    pColl2.add("42");

    // Act and Assert
    assertFalse(Collections3.sortedSetContainsAll(coll1, pColl2, mock(Equivalence.class)));
  }

  /**
   * Test {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link TreeSet#TreeSet()} add {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}
   */
  @Test
  public void testSortedSetContainsAll_givenFoo_whenTreeSetAddFoo_thenReturnTrue() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();
    coll1.add("foo");
    coll1.add("42");

    // Act and Assert
    assertTrue(Collections3.sortedSetContainsAll(coll1, new ArrayList<>(), mock(Equivalence.class)));
  }

  /**
   * Test {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link TreeSet#TreeSet()} add one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}
   */
  @Test
  public void testSortedSetContainsAll_givenOne_whenTreeSetAddOne_thenReturnFalse() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();
    coll1.add(1);

    ArrayList<Object> pColl2 = new ArrayList<>();
    pColl2.add(2);

    // Act and Assert
    assertFalse(Collections3.sortedSetContainsAll(coll1, pColl2, mock(Equivalence.class)));
  }

  /**
   * Test {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}.
   * <ul>
   *   <li>When {@link TreeSet#TreeSet()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Collections3#sortedSetContainsAll(SortedSet, Collection, Equivalence)}
   */
  @Test
  public void testSortedSetContainsAll_whenTreeSet_thenReturnTrue() {
    // Arrange
    TreeSet<Object> coll1 = new TreeSet<>();

    // Act and Assert
    assertTrue(Collections3.sortedSetContainsAll(coll1, new ArrayList<>(), mock(Equivalence.class)));
  }
}
