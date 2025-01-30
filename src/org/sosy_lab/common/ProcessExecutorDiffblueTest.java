package org.sosy_lab.common;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.function.Supplier;
import java.util.logging.Level;
import org.junit.Test;
import org.mockito.Mockito;
import org.sosy_lab.common.log.BasicLogManager;
import org.sosy_lab.common.log.LogManager;

public class ProcessExecutorDiffblueTest {
  /**
   * Test {@link ProcessExecutor#ProcessExecutor(LogManager, Class, Map, File, String[])}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessExecutor#ProcessExecutor(LogManager, Class, Map, File, String[])}
   */
  @Test
  public void testNewProcessExecutor_givenFoo_whenHashMapFooIsFoo() throws IOException {
    // Arrange
    BasicLogManager logger = mock(BasicLogManager.class);
    doThrow(new CancellationException("foo")).when(logger).log(Mockito.<Level>any(), Mockito.<Supplier<String>>any());
    Class<Exception> exceptionClass = Exception.class;

    HashMap<String, String> environmentOverride = new HashMap<>();
    environmentOverride.put("foo", "foo");

    // Act and Assert
    assertThrows(CancellationException.class, () -> new ProcessExecutor<>(logger, exceptionClass, environmentOverride,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), "Cmd"));

    verify(logger).log(isA(Level.class), isA(Supplier.class));
  }

  /**
   * Test {@link ProcessExecutor#ProcessExecutor(LogManager, Class, Map, String[])}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessExecutor#ProcessExecutor(LogManager, Class, Map, String[])}
   */
  @Test
  public void testNewProcessExecutor_givenFoo_whenHashMapFooIsFoo2() throws IOException {
    // Arrange
    BasicLogManager logger = mock(BasicLogManager.class);
    doThrow(new CancellationException("foo")).when(logger).log(Mockito.<Level>any(), Mockito.<Supplier<String>>any());
    Class<Exception> exceptionClass = Exception.class;

    HashMap<String, String> environmentOverride = new HashMap<>();
    environmentOverride.put("foo", "foo");

    // Act and Assert
    assertThrows(CancellationException.class,
        () -> new ProcessExecutor<>(logger, exceptionClass, environmentOverride, "Cmd"));

    verify(logger).log(isA(Level.class), isA(Supplier.class));
  }

  /**
   * Test {@link ProcessExecutor#ProcessExecutor(LogManager, Class, File, String[])}.
   * <ul>
   *   <li>Then throw {@link CancellationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessExecutor#ProcessExecutor(LogManager, Class, File, String[])}
   */
  @Test
  public void testNewProcessExecutor_thenThrowCancellationException() throws IOException {
    // Arrange
    BasicLogManager logger = mock(BasicLogManager.class);
    doThrow(new CancellationException("foo")).when(logger).log(Mockito.<Level>any(), Mockito.<Supplier<String>>any());
    Class<Exception> exceptionClass = Exception.class;

    // Act and Assert
    assertThrows(CancellationException.class, () -> new ProcessExecutor<>(logger, exceptionClass,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), "Cmd"));

    verify(logger).log(isA(Level.class), isA(Supplier.class));
  }

  /**
   * Test {@link ProcessExecutor#ProcessExecutor(LogManager, Class, Map, File, String[])}.
   * <ul>
   *   <li>Then throw {@link CancellationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessExecutor#ProcessExecutor(LogManager, Class, Map, File, String[])}
   */
  @Test
  public void testNewProcessExecutor_thenThrowCancellationException2() throws IOException {
    // Arrange
    BasicLogManager logger = mock(BasicLogManager.class);
    doThrow(new CancellationException("foo")).when(logger).log(Mockito.<Level>any(), Mockito.<Supplier<String>>any());
    Class<Exception> exceptionClass = Exception.class;
    HashMap<String, String> environmentOverride = new HashMap<>();

    // Act and Assert
    assertThrows(CancellationException.class, () -> new ProcessExecutor<>(logger, exceptionClass, environmentOverride,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), "Cmd"));

    verify(logger).log(isA(Level.class), isA(Supplier.class));
  }

  /**
   * Test {@link ProcessExecutor#ProcessExecutor(LogManager, Class, Map, String[])}.
   * <ul>
   *   <li>Then throw {@link CancellationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessExecutor#ProcessExecutor(LogManager, Class, Map, String[])}
   */
  @Test
  public void testNewProcessExecutor_thenThrowCancellationException3() throws IOException {
    // Arrange
    BasicLogManager logger = mock(BasicLogManager.class);
    doThrow(new CancellationException("foo")).when(logger).log(Mockito.<Level>any(), Mockito.<Supplier<String>>any());
    Class<Exception> exceptionClass = Exception.class;

    // Act and Assert
    assertThrows(CancellationException.class,
        () -> new ProcessExecutor<>(logger, exceptionClass, new HashMap<>(), "Cmd"));

    verify(logger).log(isA(Level.class), isA(Supplier.class));
  }

  /**
   * Test {@link ProcessExecutor#ProcessExecutor(LogManager, Class, String[])}.
   * <ul>
   *   <li>Then throw {@link CancellationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessExecutor#ProcessExecutor(LogManager, Class, String[])}
   */
  @Test
  public void testNewProcessExecutor_thenThrowCancellationException4() throws IOException {
    // Arrange
    BasicLogManager logger = mock(BasicLogManager.class);
    doThrow(new CancellationException("foo")).when(logger).log(Mockito.<Level>any(), Mockito.<Supplier<String>>any());
    Class<Exception> exceptionClass = Exception.class;

    // Act and Assert
    assertThrows(CancellationException.class, () -> new ProcessExecutor<>(logger, exceptionClass, "Cmd"));

    verify(logger).log(isA(Level.class), isA(Supplier.class));
  }
}
