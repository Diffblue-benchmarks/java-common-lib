package org.sosy_lab.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.mockito.Mockito;
import org.sosy_lab.common.ShutdownNotifier.ShutdownRequestListener;

public class ShutdownNotifierDiffblueTest {
  /**
   * Test {@link ShutdownNotifier#ShutdownNotifier(ShutdownManager)}.
   * <p>
   * Method under test: {@link ShutdownNotifier#ShutdownNotifier(ShutdownManager)}
   */
  @Test
  public void testNewShutdownNotifier() {
    // Arrange, Act and Assert
    assertFalse((new ShutdownNotifier(ShutdownManager.create())).shouldShutdown());
  }

  /**
   * Test {@link ShutdownNotifier#createDummy()}.
   * <p>
   * Method under test: {@link ShutdownNotifier#createDummy()}
   */
  @Test
  public void testCreateDummy() {
    // Arrange, Act and Assert
    assertFalse(ShutdownNotifier.createDummy().shouldShutdown());
  }

  /**
   * Test {@link ShutdownNotifier#requestShutdown(String)}.
   * <p>
   * Method under test: {@link ShutdownNotifier#requestShutdown(String)}
   */
  @Test
  public void testRequestShutdown() {
    // Arrange
    ShutdownNotifier createDummyResult = ShutdownNotifier.createDummy();

    // Act
    createDummyResult.requestShutdown("Just cause");

    // Assert
    assertEquals("Just cause", createDummyResult.getReason());
  }

  /**
   * Test {@link ShutdownNotifier#shouldShutdown()}.
   * <ul>
   *   <li>Given createDummy requestShutdown {@code Just cause}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShutdownNotifier#shouldShutdown()}
   */
  @Test
  public void testShouldShutdown_givenCreateDummyRequestShutdownJustCause_thenReturnTrue() {
    // Arrange
    ShutdownNotifier createDummyResult = ShutdownNotifier.createDummy();
    createDummyResult.requestShutdown("Just cause");

    // Act and Assert
    assertTrue(createDummyResult.shouldShutdown());
  }

  /**
   * Test {@link ShutdownNotifier#shouldShutdown()}.
   * <ul>
   *   <li>Given createDummy.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShutdownNotifier#shouldShutdown()}
   */
  @Test
  public void testShouldShutdown_givenCreateDummy_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ShutdownNotifier.createDummy().shouldShutdown());
  }

  /**
   * Test {@link ShutdownNotifier#shutdownIfNecessary()}.
   * <ul>
   *   <li>Then throw {@link InterruptedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShutdownNotifier#shutdownIfNecessary()}
   */
  @Test
  public void testShutdownIfNecessary_thenThrowInterruptedException() throws InterruptedException {
    // Arrange
    ShutdownNotifier createDummyResult = ShutdownNotifier.createDummy();
    createDummyResult.requestShutdown("Just cause");

    // Act and Assert
    assertThrows(InterruptedException.class, () -> createDummyResult.shutdownIfNecessary());
  }

  /**
   * Test {@link ShutdownNotifier#getReason()}.
   * <ul>
   *   <li>Given createDummy requestShutdown {@code Just cause}.</li>
   *   <li>Then return {@code Just cause}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShutdownNotifier#getReason()}
   */
  @Test
  public void testGetReason_givenCreateDummyRequestShutdownJustCause_thenReturnJustCause() {
    // Arrange
    ShutdownNotifier createDummyResult = ShutdownNotifier.createDummy();
    createDummyResult.requestShutdown("Just cause");

    // Act and Assert
    assertEquals("Just cause", createDummyResult.getReason());
  }

  /**
   * Test {@link ShutdownNotifier#registerAndCheckImmediately(ShutdownRequestListener)}.
   * <ul>
   *   <li>Then calls {@link ShutdownRequestListener#shutdownRequested(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShutdownNotifier#registerAndCheckImmediately(ShutdownRequestListener)}
   */
  @Test
  public void testRegisterAndCheckImmediately_thenCallsShutdownRequested() {
    // Arrange
    ShutdownNotifier createDummyResult = ShutdownNotifier.createDummy();
    createDummyResult.requestShutdown("Just cause");
    ShutdownRequestListener listener = mock(ShutdownRequestListener.class);
    doNothing().when(listener).shutdownRequested(Mockito.<String>any());

    // Act
    createDummyResult.registerAndCheckImmediately(listener);

    // Assert
    verify(listener).shutdownRequested(eq("Just cause"));
  }
}
