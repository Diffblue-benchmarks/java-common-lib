package org.sosy_lab.common.collect;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.base.Equivalence;
import java.util.TreeSet;
import org.junit.Test;
import org.sosy_lab.common.collect.MapsDifference.Visitor;
import org.sosy_lab.common.collect.PersistentSortedMaps.MergeConflictHandler;

public class PersistentSortedMapsDiffblueTest {
  /**
   * Test {@link PersistentSortedMaps#getExceptionMergeConflictHandler()}.
   * <p>
   * Method under test: {@link PersistentSortedMaps#getExceptionMergeConflictHandler()}
   */
  @Test
  public void testGetExceptionMergeConflictHandler() {
    // Arrange and Act
    MergeConflictHandler<Object, Object> actualExceptionMergeConflictHandler = PersistentSortedMaps
        .getExceptionMergeConflictHandler();

    // Assert
    assertThrows(IllegalArgumentException.class,
        () -> actualExceptionMergeConflictHandler.resolveConflict("42", "42", "42"));
  }

  /**
   * Test {@link PersistentSortedMaps#merge(PersistentSortedMap, PersistentSortedMap, MergeConflictHandler)} with {@code map1}, {@code map2}, {@code conflictHandler}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistentSortedMaps#merge(PersistentSortedMap, PersistentSortedMap, MergeConflictHandler)}
   */
  @Test
  public void testMergeWithMap1Map2ConflictHandler_givenOne() {
    // Arrange
    PersistentSortedMap<Comparable<Comparable>, Object> map1 = mock(PersistentSortedMap.class);
    when(map1.size()).thenReturn(1);
    when(map1.entrySet()).thenReturn(new TreeSet<>());
    PersistentSortedMap<Comparable<Comparable>, Object> map2 = mock(PersistentSortedMap.class);
    when(map2.size()).thenReturn(3);
    when(map2.entrySet()).thenReturn(new TreeSet<>());

    // Act
    PersistentSortedMaps.merge(map1, map2, mock(MergeConflictHandler.class));

    // Assert
    verify(map1, atLeast(1)).size();
    verify(map2, atLeast(1)).size();
    verify(map1).entrySet();
    verify(map2).entrySet();
  }

  /**
   * Test {@link PersistentSortedMaps#merge(PersistentSortedMap, PersistentSortedMap, MergeConflictHandler)} with {@code map1}, {@code map2}, {@code conflictHandler}.
   * <ul>
   *   <li>Given {@link TreeSet#TreeSet()}.</li>
   *   <li>Then calls {@link PersistentSortedMap#entrySet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistentSortedMaps#merge(PersistentSortedMap, PersistentSortedMap, MergeConflictHandler)}
   */
  @Test
  public void testMergeWithMap1Map2ConflictHandler_givenTreeSet_thenCallsEntrySet() {
    // Arrange
    PersistentSortedMap<Comparable<Comparable>, Object> map1 = mock(PersistentSortedMap.class);
    when(map1.size()).thenReturn(3);
    when(map1.entrySet()).thenReturn(new TreeSet<>());
    PersistentSortedMap<Comparable<Comparable>, Object> map2 = mock(PersistentSortedMap.class);
    when(map2.size()).thenReturn(3);
    when(map2.entrySet()).thenReturn(new TreeSet<>());

    // Act
    PersistentSortedMaps.merge(map1, map2, mock(MergeConflictHandler.class));

    // Assert
    verify(map2, atLeast(1)).size();
    verify(map1, atLeast(1)).size();
    verify(map1).entrySet();
    verify(map2).entrySet();
  }

  /**
   * Test {@link PersistentSortedMaps#merge(PersistentSortedMap, PersistentSortedMap, MergeConflictHandler)} with {@code map1}, {@code map2}, {@code conflictHandler}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistentSortedMaps#merge(PersistentSortedMap, PersistentSortedMap, MergeConflictHandler)}
   */
  @Test
  public void testMergeWithMap1Map2ConflictHandler_thenThrowIllegalArgumentException() {
    // Arrange
    PersistentSortedMap<Comparable<Comparable>, Object> map1 = mock(PersistentSortedMap.class);
    when(map1.size()).thenReturn(3);
    PersistentSortedMap<Comparable<Comparable>, Object> map2 = mock(PersistentSortedMap.class);
    when(map2.size()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PersistentSortedMaps.merge(map1, map2, mock(MergeConflictHandler.class)));
    verify(map1).size();
    verify(map2).size();
  }

  /**
   * Test {@link PersistentSortedMaps#merge(PersistentSortedMap, PersistentSortedMap, Equivalence, MergeConflictHandler, Visitor)} with {@code map1}, {@code map2}, {@code valueEquals}, {@code conflictHandler}, {@code collectDifferences}.
   * <p>
   * Method under test: {@link PersistentSortedMaps#merge(PersistentSortedMap, PersistentSortedMap, Equivalence, MergeConflictHandler, Visitor)}
   */
  @Test
  public void testMergeWithMap1Map2ValueEqualsConflictHandlerCollectDifferences() {
    // Arrange
    PersistentSortedMap<Comparable<Comparable>, Object> map1 = mock(PersistentSortedMap.class);
    when(map1.size()).thenReturn(3);
    when(map1.entrySet()).thenReturn(new TreeSet<>());
    PersistentSortedMap<Comparable<Comparable>, Object> map2 = mock(PersistentSortedMap.class);
    when(map2.size()).thenReturn(3);
    when(map2.entrySet()).thenReturn(new TreeSet<>());

    // Act
    PersistentSortedMaps.merge(map1, map2, mock(Equivalence.class), mock(MergeConflictHandler.class),
        mock(Visitor.class));

    // Assert
    verify(map2).size();
    verify(map1, atLeast(1)).size();
    verify(map1).entrySet();
    verify(map2).entrySet();
  }

  /**
   * Test {@link PersistentSortedMaps#merge(PersistentSortedMap, PersistentSortedMap, Equivalence, MergeConflictHandler, Visitor)} with {@code map1}, {@code map2}, {@code valueEquals}, {@code conflictHandler}, {@code collectDifferences}.
   * <p>
   * Method under test: {@link PersistentSortedMaps#merge(PersistentSortedMap, PersistentSortedMap, Equivalence, MergeConflictHandler, Visitor)}
   */
  @Test
  public void testMergeWithMap1Map2ValueEqualsConflictHandlerCollectDifferences2() {
    // Arrange
    PersistentSortedMap<Comparable<Comparable>, Object> map1 = mock(PersistentSortedMap.class);
    when(map1.size()).thenReturn(3);
    when(map1.entrySet()).thenReturn(new TreeSet<>());
    PersistentSortedMap<Comparable<Comparable>, Object> map2 = mock(PersistentSortedMap.class);
    when(map2.size()).thenThrow(new IllegalArgumentException("foo"));
    when(map2.entrySet()).thenReturn(new TreeSet<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PersistentSortedMaps.merge(map1, map2, mock(Equivalence.class),
        mock(MergeConflictHandler.class), mock(Visitor.class)));
    verify(map2).size();
    verify(map1, atLeast(1)).size();
    verify(map1).entrySet();
    verify(map2).entrySet();
  }
}
