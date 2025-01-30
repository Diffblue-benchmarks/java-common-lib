package org.sosy_lab.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class LazyFutureTaskDiffblueTest {
  /**
   * Test {@link LazyFutureTask#get(long, TimeUnit)} with {@code long}, {@code TimeUnit}.
   * <p>
   * Method under test: {@link LazyFutureTask#get(long, TimeUnit)}
   */
  @Test
  public void testGetWithLongTimeUnit() {
    // Arrange
    LazyFutureTask<Object> lazyFutureTask = new LazyFutureTask<>(mock(Callable.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> lazyFutureTask.get(1L, TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link LazyFutureTask#get()}.
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@code Call}.</li>
   *   <li>Then return {@code Call}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LazyFutureTask#get()}
   */
  @Test
  public void testGet_givenCallableCallReturnCall_thenReturnCall() throws Exception {
    // Arrange
    Callable<Object> pCallable = mock(Callable.class);
    when(pCallable.call()).thenReturn("Call");
    LazyFutureTask<Object> lazyFutureTask = new LazyFutureTask<>(pCallable);

    // Act
    Object actualGetResult = lazyFutureTask.get();

    // Assert
    verify(pCallable).call();
    assertEquals("Call", actualGetResult);
    assertEquals("Call", lazyFutureTask.get());
    assertTrue(lazyFutureTask.isDone());
  }
}
