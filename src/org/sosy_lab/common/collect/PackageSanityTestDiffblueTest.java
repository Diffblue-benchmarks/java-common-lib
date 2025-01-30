package org.sosy_lab.common.collect;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PackageSanityTestDiffblueTest {
  /**
   * Test new {@link PackageSanityTest} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PackageSanityTest}
   */
  @Test
  public void testNewPackageSanityTest() {
    // Arrange, Act and Assert
    assertNull((new PackageSanityTest()).getName());
  }
}
