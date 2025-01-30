package org.sosy_lab.common.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.lang.reflect.AnnotatedElement;
import org.junit.Test;

public class AutoValue_OptionCollector_OptionInfoDiffblueTest {
  /**
   * Test {@link AutoValue_OptionCollector_OptionInfo#AutoValue_OptionCollector_OptionInfo(AnnotatedElement, String, String, Class, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return defaultValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_OptionCollector_OptionInfo#AutoValue_OptionCollector_OptionInfo(AnnotatedElement, String, String, Class, String)}
   */
  @Test
  public void testNewAutoValue_OptionCollector_OptionInfo_when42_thenReturnDefaultValueIs42() {
    // Arrange
    Class<Object> element = Object.class;
    Class<Object> type = Object.class;

    // Act
    AutoValue_OptionCollector_OptionInfo actualAutoValue_OptionCollector_OptionInfo = new AutoValue_OptionCollector_OptionInfo(
        element, "Name", "The characteristics of someone or something", type, "42");

    // Assert
    assertEquals("42", actualAutoValue_OptionCollector_OptionInfo.defaultValue());
    assertEquals("Name", actualAutoValue_OptionCollector_OptionInfo.name());
    assertEquals("The characteristics of someone or something",
        actualAutoValue_OptionCollector_OptionInfo.description());
    assertSame(type, actualAutoValue_OptionCollector_OptionInfo.element());
    assertSame(type, actualAutoValue_OptionCollector_OptionInfo.type());
  }
}
