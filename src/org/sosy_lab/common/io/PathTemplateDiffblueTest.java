package org.sosy_lab.common.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.io.File;
import org.junit.Test;

public class PathTemplateDiffblueTest {
  /**
   * Test {@link PathTemplate#ofFormatString(String)}.
   * <ul>
   *   <li>When {@code P Template}.</li>
   *   <li>Then return Template is {@code P Template}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathTemplate#ofFormatString(String)}
   */
  @Test
  public void testOfFormatString_whenPTemplate_thenReturnTemplateIsPTemplate() {
    // Arrange, Act and Assert
    assertEquals("P Template", PathTemplate.ofFormatString("P Template").getTemplate());
  }

  /**
   * Test {@link PathTemplate#getPath(Object[])}.
   * <p>
   * Method under test: {@link PathTemplate#getPath(Object[])}
   */
  @Test
  public void testGetPath() {
    // Arrange, Act and Assert
    File toFileResult = PathTemplate.ofFormatString("P Template").getPath("Args").toFile();
    assertEquals("P Template", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PathTemplate#toString()}
   *   <li>{@link PathTemplate#getTemplate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PathTemplate ofFormatStringResult = PathTemplate.ofFormatString("P Template");

    // Act
    String actualToStringResult = ofFormatStringResult.toString();

    // Assert
    assertEquals("P Template", ofFormatStringResult.getTemplate());
    assertEquals("PathTemplate{template=P Template}", actualToStringResult);
  }
}
