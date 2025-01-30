package org.sosy_lab.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.mockito.Mockito;

public class OptionalsDiffblueTest {
  /**
   * Test {@link Optionals#toGuavaOptional(Optional)}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return not toJavaUtil Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link Optionals#toGuavaOptional(Optional)}
   */
  @Test
  public void testToGuavaOptional_whenEmpty_thenReturnNotToJavaUtilPresent() {
    // Arrange
    Optional<Object> optional = Optional.empty();

    // Act
    com.google.common.base.Optional<Object> actualToGuavaOptionalResult = Optionals.toGuavaOptional(optional);

    // Assert
    assertFalse(actualToGuavaOptionalResult.toJavaUtil().isPresent());
  }

  /**
   * Test {@link Optionals#toGuavaOptional(Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return toJavaUtil is {@link Optional} with {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Optionals#toGuavaOptional(Optional)}
   */
  @Test
  public void testToGuavaOptional_whenOptionalWith42_thenReturnToJavaUtilIsOptionalWith42() {
    // Arrange
    Optional<Object> optional = Optional.of("42");

    // Act
    com.google.common.base.Optional<Object> actualToGuavaOptionalResult = Optionals.toGuavaOptional(optional);

    // Assert
    assertEquals(optional, actualToGuavaOptionalResult.toJavaUtil());
  }

  /**
   * Test {@link Optionals#fromGuavaOptional(Optional)}.
   * <p>
   * Method under test: {@link Optionals#fromGuavaOptional(com.google.common.base.Optional)}
   */
  @Test
  public void testFromGuavaOptional() {
    // Arrange
    com.google.common.base.Optional<Object> optional = mock(com.google.common.base.Optional.class);
    Optional<Object> ofResult = Optional.of("42");
    when(optional.toJavaUtil()).thenReturn(ofResult);

    // Act
    Optional<Object> actualFromGuavaOptionalResult = Optionals.fromGuavaOptional(optional);

    // Assert
    verify(optional).toJavaUtil();
    assertEquals("42", actualFromGuavaOptionalResult.get());
    assertTrue(actualFromGuavaOptionalResult.isPresent());
  }

  /**
   * Test {@link Optionals#asSet(Optional)}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Optionals#asSet(Optional)}
   */
  @Test
  public void testAsSet_whenEmpty_thenReturnEmpty() {
    // Arrange
    Optional<Object> optional = Optional.empty();

    // Act
    ImmutableSet<Object> actualAsSetResult = Optionals.asSet(optional);

    // Assert
    assertTrue(actualAsSetResult.isEmpty());
  }

  /**
   * Test {@link Optionals#asSet(Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Optionals#asSet(Optional)}
   */
  @Test
  public void testAsSet_whenOptionalWith42_thenReturnSizeIsOne() {
    // Arrange
    Optional<Object> optional = Optional.of("42");

    // Act
    ImmutableSet<Object> actualAsSetResult = Optionals.asSet(optional);

    // Assert
    assertEquals(1, actualAsSetResult.size());
  }

  /**
   * Test {@link Optionals#asStream(Optional)}.
   * <p>
   * Method under test: {@link Optionals#asStream(Optional)}
   */
  @Test
  public void testAsStream() {
    // Arrange
    Optional<Object> optional = Optional.of("42");

    // Act
    Stream<Object> actualAsStreamResult = Optionals.asStream(optional);

    // Assert
    List<Object> collectResult = actualAsStreamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("42", collectResult.get(0));
  }

  /**
   * Test {@link Optionals#presentInstances(Iterable)} with {@code iterable}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Optionals#presentInstances(Iterable)}
   */
  @Test
  public void testPresentInstancesWithIterable_whenArrayList_thenReturnToListEmpty() {
    // Arrange and Act
    FluentIterable<Object> actualPresentInstancesResult = Optionals.presentInstances(new ArrayList<>());

    // Assert
    assertTrue(actualPresentInstancesResult.toList().isEmpty());
  }

  /**
   * Test {@link Optionals#presentInstances(Stream)} with {@code stream}.
   * <p>
   * Method under test: {@link Optionals#presentInstances(Stream)}
   */
  @Test
  public void testPresentInstancesWithStream() {
    // Arrange
    ArrayList<Optional<Object>> optionalList = new ArrayList<>();
    Stream<Optional<Object>> stream = optionalList.stream();

    // Act
    Stream<Object> actualPresentInstancesResult = Optionals.presentInstances(stream);

    // Assert
    assertTrue(actualPresentInstancesResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Optionals#comparingEmptyFirst()}.
   * <p>
   * Method under test: {@link Optionals#comparingEmptyFirst()}
   */
  @Test
  public void testComparingEmptyFirst() {
    // Arrange and Act
    Comparator<Optional<File>> actualComparingEmptyFirstResult = Optionals.comparingEmptyFirst();
    Optional<File> ofResult = Optional.of(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    Optional<File> ofResult2 = Optional.of(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    assertEquals(0, actualComparingEmptyFirstResult.compare(ofResult, ofResult2));
  }

  /**
   * Test {@link Optionals#comparingEmptyFirst(Comparator)} with {@code Comparator}.
   * <p>
   * Method under test: {@link Optionals#comparingEmptyFirst(Comparator)}
   */
  @Test
  public void testComparingEmptyFirstWithComparator() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    // Act
    Comparator<Optional<Object>> actualComparingEmptyFirstResult = Optionals.comparingEmptyFirst(comparator);
    Optional<Object> ofResult = Optional.of("42");
    Optional<Object> ofResult2 = Optional.of("42");
    int actualCompareResult = actualComparingEmptyFirstResult.compare(ofResult, ofResult2);

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, actualCompareResult);
  }

  /**
   * Test {@link Optionals#comparingEmptyLast()}.
   * <p>
   * Method under test: {@link Optionals#comparingEmptyLast()}
   */
  @Test
  public void testComparingEmptyLast() {
    // Arrange and Act
    Comparator<Optional<File>> actualComparingEmptyLastResult = Optionals.comparingEmptyLast();
    Optional<File> ofResult = Optional.of(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    Optional<File> ofResult2 = Optional.of(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    assertEquals(0, actualComparingEmptyLastResult.compare(ofResult, ofResult2));
  }

  /**
   * Test {@link Optionals#comparingEmptyLast(Comparator)} with {@code Comparator}.
   * <p>
   * Method under test: {@link Optionals#comparingEmptyLast(Comparator)}
   */
  @Test
  public void testComparingEmptyLastWithComparator() {
    // Arrange
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    // Act
    Comparator<Optional<Object>> actualComparingEmptyLastResult = Optionals.comparingEmptyLast(comparator);
    Optional<Object> ofResult = Optional.of("42");
    Optional<Object> ofResult2 = Optional.of("42");
    int actualCompareResult = actualComparingEmptyLastResult.compare(ofResult, ofResult2);

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(1, actualCompareResult);
  }
}
