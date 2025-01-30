package org.sosy_lab.common.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.logging.Level;
import org.junit.Test;

public class StringBuildingLogHandlerDiffblueTest {
  /**
   * Test {@link StringBuildingLogHandler#getLog()}.
   * <p>
   * Method under test: {@link StringBuildingLogHandler#getLog()}
   */
  @Test
  public void testGetLog() {
    // Arrange, Act and Assert
    assertEquals("", (new StringBuildingLogHandler()).getLog());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StringBuildingLogHandler}
   *   <li>{@link StringBuildingLogHandler#close()}
   *   <li>{@link StringBuildingLogHandler#flush()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StringBuildingLogHandler actualStringBuildingLogHandler = new StringBuildingLogHandler();
    actualStringBuildingLogHandler.close();
    actualStringBuildingLogHandler.flush();

    // Assert
    Level level = actualStringBuildingLogHandler.getLevel();
    assertEquals("ALL", level.getLocalizedName());
    assertEquals("ALL", level.getName());
    assertEquals("ALL", level.toString());
    assertEquals("sun.util.logging.resources.logging", level.getResourceBundleName());
    assertNull(actualStringBuildingLogHandler.getEncoding());
    assertNull(actualStringBuildingLogHandler.getFilter());
    assertNull(actualStringBuildingLogHandler.getFormatter());
  }
}
