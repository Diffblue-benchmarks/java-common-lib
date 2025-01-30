package org.sosy_lab.common;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ShutdownManagerDiffblueTest {
  /**
   * Test {@link ShutdownManager#createWithParent(ShutdownNotifier)}.
   * <ul>
   *   <li>Given {@code Just cause}.</li>
   *   <li>Then return Notifier Reason is {@code Just cause}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShutdownManager#createWithParent(ShutdownNotifier)}
   */
  @Test
  public void testCreateWithParent_givenJustCause_thenReturnNotifierReasonIsJustCause() {
    // Arrange
    ShutdownNotifier parent = ShutdownNotifier.createDummy();
    parent.requestShutdown("Just cause");

    // Act and Assert
    assertEquals("Just cause", ShutdownManager.createWithParent(parent).getNotifier().getReason());
  }

  /**
   * Test {@link ShutdownManager#requestShutdown(String)}.
   * <ul>
   *   <li>Given create.</li>
   *   <li>Then create Notifier Reason is {@code Just cause}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShutdownManager#requestShutdown(String)}
   */
  @Test
  public void testRequestShutdown_givenCreate_thenCreateNotifierReasonIsJustCause() {
    // Arrange
    ShutdownManager createResult = ShutdownManager.create();

    // Act
    createResult.requestShutdown("Just cause");

    // Assert
    assertEquals("Just cause", createResult.getNotifier().getReason());
  }

  /**
   * Test {@link ShutdownManager#requestShutdown(String)}.
   * <ul>
   *   <li>Then createWithParent createDummy Notifier Reason is {@code Just cause}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShutdownManager#requestShutdown(String)}
   */
  @Test
  public void testRequestShutdown_thenCreateWithParentCreateDummyNotifierReasonIsJustCause() {
    // Arrange
    ShutdownNotifier parent = ShutdownNotifier.createDummy();
    parent.requestShutdown("Just cause");
    ShutdownManager createWithParentResult = ShutdownManager.createWithParent(parent);

    // Act
    createWithParentResult.requestShutdown("Just cause");

    // Assert that nothing has changed
    assertEquals("Just cause", createWithParentResult.getNotifier().getReason());
  }
}
