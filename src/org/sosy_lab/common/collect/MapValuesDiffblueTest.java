package org.sosy_lab.common.collect;

import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MapValuesDiffblueTest {
  /**
   * Test {@link MapValues#MapValues(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapValues#MapValues(Map)}
   */
  @Test
  public void testNewMapValues_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    MapValues<Object> actualMapValues = new MapValues<>(new HashMap<>());

    // Assert
    assertTrue(actualMapValues.isEmpty());
  }
}
