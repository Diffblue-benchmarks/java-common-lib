package org.sosy_lab.common;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UniqueIdGeneratorDiffblueTest {
  /**
   * Test {@link UniqueIdGenerator#getFreshId()}.
   * <p>
   * Method under test: {@link UniqueIdGenerator#getFreshId()}
   */
  @Test
  public void testGetFreshId() {
    // Arrange, Act and Assert
    assertEquals(0, (new UniqueIdGenerator()).getFreshId());
  }
}
