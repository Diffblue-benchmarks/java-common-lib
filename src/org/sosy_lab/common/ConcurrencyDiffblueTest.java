package org.sosy_lab.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.Test;

public class ConcurrencyDiffblueTest {
  /**
   * Test {@link Concurrency#createThreadPool()}.
   * <p>
   * Method under test: {@link Concurrency#createThreadPool()}
   */
  @Test
  public void testCreateThreadPool() {
    // Arrange and Act
    ExecutorService actualCreateThreadPoolResult = Concurrency.createThreadPool();

    // Assert
    assertTrue(actualCreateThreadPoolResult instanceof ThreadPoolExecutor);
    assertEquals(0, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getActiveCount());
    assertEquals(0, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getLargestPoolSize());
    assertEquals(0, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getPoolSize());
    assertEquals(0L, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getCompletedTaskCount());
    assertEquals(0L, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getTaskCount());
    assertEquals(4, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getCorePoolSize());
    assertEquals(4, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getMaximumPoolSize());
    assertTrue(((ThreadPoolExecutor) actualCreateThreadPoolResult).getQueue().isEmpty());
  }

  /**
   * Test {@link Concurrency#createThreadPool(ThreadFactory)} with {@code ThreadFactory}.
   * <p>
   * Method under test: {@link Concurrency#createThreadPool(ThreadFactory)}
   */
  @Test
  public void testCreateThreadPoolWithThreadFactory() {
    // Arrange
    ThreadFactory threadFactory = mock(ThreadFactory.class);

    // Act
    ExecutorService actualCreateThreadPoolResult = Concurrency.createThreadPool(threadFactory);

    // Assert
    assertTrue(actualCreateThreadPoolResult instanceof ThreadPoolExecutor);
    assertEquals(0, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getActiveCount());
    assertEquals(0, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getLargestPoolSize());
    assertEquals(0, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getPoolSize());
    assertEquals(0L, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getCompletedTaskCount());
    assertEquals(0L, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getTaskCount());
    assertEquals(4, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getCorePoolSize());
    assertEquals(4, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getMaximumPoolSize());
    assertTrue(((ThreadPoolExecutor) actualCreateThreadPoolResult).getQueue().isEmpty());
    assertSame(threadFactory, ((ThreadPoolExecutor) actualCreateThreadPoolResult).getThreadFactory());
  }
}
