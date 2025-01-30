package org.sosy_lab.common.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Supplier;
import java.util.logging.Level;
import org.junit.Test;
import org.mockito.Mockito;

public class LogManagerWithoutDuplicatesDiffblueTest {
  /**
   * Test {@link LogManagerWithoutDuplicates#LogManagerWithoutDuplicates(LogManager)}.
   * <ul>
   *   <li>When {@link NullLogManager#INSTANCE}.</li>
   *   <li>Then delegate return {@link NullLogManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogManagerWithoutDuplicates#LogManagerWithoutDuplicates(LogManager)}
   */
  @Test
  public void testNewLogManagerWithoutDuplicates_whenInstance_thenDelegateReturnNullLogManager() {
    // Arrange, Act and Assert
    LogManager delegateResult = (new LogManagerWithoutDuplicates(NullLogManager.INSTANCE)).delegate();
    assertTrue(delegateResult instanceof NullLogManager);
    assertEquals(NullLogManager.INSTANCE, delegateResult);
  }

  /**
   * Test {@link LogManagerWithoutDuplicates#delegate()}.
   * <p>
   * Method under test: {@link LogManagerWithoutDuplicates#delegate()}
   */
  @Test
  public void testDelegate() {
    // Arrange and Act
    LogManager actualDelegateResult = (new LogManagerWithoutDuplicates(NullLogManager.INSTANCE)).delegate();

    // Assert
    assertTrue(actualDelegateResult instanceof NullLogManager);
    assertEquals(NullLogManager.INSTANCE, actualDelegateResult);
  }

  /**
   * Test {@link LogManagerWithoutDuplicates#withComponentName(String)}.
   * <ul>
   *   <li>Then delegate return {@link LogManagerWithoutDuplicates}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogManagerWithoutDuplicates#withComponentName(String)}
   */
  @Test
  public void testWithComponentName_thenDelegateReturnLogManagerWithoutDuplicates() {
    // Arrange, Act and Assert
    LogManager delegateResult = (new LogManagerWithoutDuplicates(
        new LogManagerWithoutDuplicates(NullLogManager.INSTANCE))).withComponentName("P Name").delegate();
    assertTrue(delegateResult instanceof LogManagerWithoutDuplicates);
    LogManager delegateResult2 = ((LogManagerWithoutDuplicates) delegateResult).delegate();
    assertTrue(delegateResult2 instanceof NullLogManager);
    assertEquals(NullLogManager.INSTANCE, delegateResult2);
  }

  /**
   * Test {@link LogManagerWithoutDuplicates#withComponentName(String)}.
   * <ul>
   *   <li>Then delegate return {@link NullLogManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogManagerWithoutDuplicates#withComponentName(String)}
   */
  @Test
  public void testWithComponentName_thenDelegateReturnNullLogManager() {
    // Arrange, Act and Assert
    LogManager delegateResult = (new LogManagerWithoutDuplicates(NullLogManager.INSTANCE)).withComponentName("P Name")
        .delegate();
    assertTrue(delegateResult instanceof NullLogManager);
    assertEquals(NullLogManager.INSTANCE, delegateResult);
  }

  /**
   * Test {@link LogManagerWithoutDuplicates#withComponentName(String)}.
   * <ul>
   *   <li>Then delegate return {@link TestLogManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogManagerWithoutDuplicates#withComponentName(String)}
   */
  @Test
  public void testWithComponentName_thenDelegateReturnTestLogManager() {
    // Arrange, Act and Assert
    LogManager delegateResult = (new LogManagerWithoutDuplicates(TestLogManager.INSTANCE)).withComponentName("P Name")
        .delegate();
    assertTrue(delegateResult instanceof TestLogManager);
    assertEquals(TestLogManager.INSTANCE, delegateResult);
  }

  /**
   * Test {@link LogManagerWithoutDuplicates#logOnce(Level, Object[])} with {@code pPriority}, {@code pArgs}.
   * <ul>
   *   <li>Given {@link BasicLogManager} {@link BasicLogManager#log(Level, Object[])} does nothing.</li>
   *   <li>Then calls {@link BasicLogManager#log(Level, Object[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogManagerWithoutDuplicates#logOnce(Level, Object[])}
   */
  @Test
  public void testLogOnceWithPPriorityPArgs_givenBasicLogManagerLogDoesNothing_thenCallsLog() {
    // Arrange
    BasicLogManager pDelegate = mock(BasicLogManager.class);
    doNothing().when(pDelegate).log(Mockito.<Level>any(), isA(Object[].class));
    when(pDelegate.wouldBeLogged(Mockito.<Level>any())).thenReturn(true);

    // Act
    (new LogManagerWithoutDuplicates(pDelegate)).logOnce(null, "P Args");

    // Assert
    verify(pDelegate).log((Level) isNull(), isA(Object[].class));
    verify(pDelegate).wouldBeLogged(isNull());
  }

  /**
   * Test {@link LogManagerWithoutDuplicates#logOnce(Level, Supplier)} with {@code pPriority}, {@code pMsgSupplier}.
   * <ul>
   *   <li>Then calls {@link BasicLogManager#log(Level, Object[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogManagerWithoutDuplicates#logOnce(Level, Supplier)}
   */
  @Test
  public void testLogOnceWithPPriorityPMsgSupplier_thenCallsLog() {
    // Arrange
    BasicLogManager pDelegate = mock(BasicLogManager.class);
    doNothing().when(pDelegate).log(Mockito.<Level>any(), isA(Object[].class));
    when(pDelegate.wouldBeLogged(Mockito.<Level>any())).thenReturn(true);
    LogManagerWithoutDuplicates logManagerWithoutDuplicates = new LogManagerWithoutDuplicates(pDelegate);

    // Act
    logManagerWithoutDuplicates.logOnce(null, new ConsoleLogFormatter(new LoggingOptions())::toString);

    // Assert
    verify(pDelegate).log((Level) isNull(), isA(Object[].class));
    verify(pDelegate).wouldBeLogged(isNull());
  }

  /**
   * Test {@link LogManagerWithoutDuplicates#logOnce(Level, Supplier)} with {@code pPriority}, {@code pMsgSupplier}.
   * <ul>
   *   <li>When {@link ConsoleLogFormatter}.</li>
   *   <li>Then calls {@link BasicLogManager#log(Level, Object[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogManagerWithoutDuplicates#logOnce(Level, Supplier)}
   */
  @Test
  public void testLogOnceWithPPriorityPMsgSupplier_whenConsoleLogFormatter_thenCallsLog() {
    // Arrange
    BasicLogManager pDelegate = mock(BasicLogManager.class);
    doNothing().when(pDelegate).log(Mockito.<Level>any(), isA(Object[].class));
    when(pDelegate.wouldBeLogged(Mockito.<Level>any())).thenReturn(true);
    LogManagerWithoutDuplicates logManagerWithoutDuplicates = new LogManagerWithoutDuplicates(pDelegate);

    // Act
    logManagerWithoutDuplicates.logOnce(null, mock(ConsoleLogFormatter.class)::toString);

    // Assert
    verify(pDelegate).log((Level) isNull(), isA(Object[].class));
    verify(pDelegate).wouldBeLogged(isNull());
  }

  /**
   * Test {@link LogManagerWithoutDuplicates#logfOnce(Level, String, Object[])}.
   * <ul>
   *   <li>Given {@link BasicLogManager} {@link BasicLogManager#logf(Level, String, Object[])} does nothing.</li>
   *   <li>When {@code P Args}.</li>
   *   <li>Then calls {@link BasicLogManager#logf(Level, String, Object[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogManagerWithoutDuplicates#logfOnce(Level, String, Object[])}
   */
  @Test
  public void testLogfOnce_givenBasicLogManagerLogfDoesNothing_whenPArgs_thenCallsLogf() {
    // Arrange
    BasicLogManager pDelegate = mock(BasicLogManager.class);
    doNothing().when(pDelegate).logf(Mockito.<Level>any(), Mockito.<String>any(), isA(Object[].class));
    when(pDelegate.wouldBeLogged(Mockito.<Level>any())).thenReturn(true);

    // Act
    (new LogManagerWithoutDuplicates(pDelegate)).logfOnce(null, "P Format", "P Args");

    // Assert
    verify(pDelegate).logf(isNull(), eq("P Format"), isA(Object[].class));
    verify(pDelegate).wouldBeLogged(isNull());
  }
}
