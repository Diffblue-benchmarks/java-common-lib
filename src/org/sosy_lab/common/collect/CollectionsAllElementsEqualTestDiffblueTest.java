package org.sosy_lab.common.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

public class CollectionsAllElementsEqualTestDiffblueTest {
  /**
   * Test {@link CollectionsAllElementsEqualTest#parameters()}.
   * <p>
   * Method under test: {@link CollectionsAllElementsEqualTest#parameters()}
   */
  @Test
  public void testParameters() {
    // Arrange and Act
    ImmutableList<Object[]> actualParametersResult = CollectionsAllElementsEqualTest.parameters();

    // Assert
    assertEquals(10, actualParametersResult.size());
    assertEquals(2, actualParametersResult.get(0).length);
    assertEquals(2, actualParametersResult.get(1).length);
    assertEquals(2, actualParametersResult.get(2).length);
    assertEquals(2, actualParametersResult.get(3).length);
    assertEquals(2, actualParametersResult.get(4).length);
    assertEquals(2, actualParametersResult.get(5).length);
    assertEquals(2, actualParametersResult.get(6).length);
    assertEquals(2, actualParametersResult.get(7).length);
    assertEquals(2, actualParametersResult.get(8).length);
    assertEquals(2, actualParametersResult.get(9).length);
  }

  /**
   * Test new {@link CollectionsAllElementsEqualTest} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CollectionsAllElementsEqualTest}
   */
  @Test
  public void testNewCollectionsAllElementsEqualTest() {
    // Arrange and Act
    CollectionsAllElementsEqualTest actualCollectionsAllElementsEqualTest = new CollectionsAllElementsEqualTest();

    // Assert
    assertNull(actualCollectionsAllElementsEqualTest.inputs);
    assertFalse(actualCollectionsAllElementsEqualTest.expectedResult);
  }
}
