package org.sosy_lab.common.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.io.File;
import org.junit.Test;

public class PathCounterTemplateDiffblueTest {
  /**
   * Test {@link PathCounterTemplate#ofFormatString(String)}.
   * <ul>
   *   <li>When {@code P Template}.</li>
   *   <li>Then return FreshPath toFile Name is {@code P Template}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathCounterTemplate#ofFormatString(String)}
   */
  @Test
  public void testOfFormatString_whenPTemplate_thenReturnFreshPathToFileNameIsPTemplate() {
    // Arrange and Act
    PathCounterTemplate actualOfFormatStringResult = PathCounterTemplate.ofFormatString("P Template");

    // Assert
    File toFileResult = actualOfFormatStringResult.getFreshPath().toFile();
    assertEquals("P Template", toFileResult.getName());
    assertEquals("P Template", actualOfFormatStringResult.getTemplate());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link PathCounterTemplate#getFreshPath()}.
   * <p>
   * Method under test: {@link PathCounterTemplate#getFreshPath()}
   */
  @Test
  public void testGetFreshPath() {
    // Arrange, Act and Assert
    File toFileResult = PathCounterTemplate.ofFormatString("P Template").getFreshPath().toFile();
    assertEquals("P Template", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PathCounterTemplate#toString()}
   *   <li>{@link PathCounterTemplate#getTemplate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PathCounterTemplate ofFormatStringResult = PathCounterTemplate.ofFormatString("P Template");

    // Act
    String actualToStringResult = ofFormatStringResult.toString();

    // Assert
    assertEquals("P Template", ofFormatStringResult.getTemplate());
    assertEquals("PathCounterTemplate{template=P Template, counter=0}", actualToStringResult);
  }
}
