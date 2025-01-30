package org.sosy_lab.common.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.sosy_lab.common.configuration.OptionCollector.OptionsInfo;

public class OptionCollectorDiffblueTest {
  /**
   * Test OptionsInfo {@link OptionsInfo#create(Options, Class)}.
   * <ul>
   *   <li>Then return {@link AutoValue_OptionCollector_OptionsInfo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionsInfo#create(Options, Class)}
   */
  @Test
  public void testOptionsInfoCreate_thenReturnAutoValue_OptionCollector_OptionsInfo() {
    // Arrange
    Options options = mock(Options.class);
    when(options.prefix()).thenReturn("Prefix");
    Class<Object> c = Object.class;

    // Act
    OptionsInfo actualCreateResult = OptionsInfo.create(options, c);

    // Assert
    verify(options).prefix();
    assertTrue(actualCreateResult instanceof AutoValue_OptionCollector_OptionsInfo);
    assertEquals("Prefix", actualCreateResult.name());
    assertNull(actualCreateResult.description());
    Class<Object> expectedElementResult = Object.class;
    assertEquals(expectedElementResult, actualCreateResult.element());
    assertSame(options, actualCreateResult.options());
  }

  /**
   * Test OptionsInfo {@link OptionsInfo#description()}.
   * <p>
   * Method under test: {@link OptionsInfo#description()}
   */
  @Test
  public void testOptionsInfoDescription() {
    // Arrange
    Options options = mock(Options.class);
    when(options.description()).thenReturn("The characteristics of someone or something");
    Class<Object> element = Object.class;

    // Act
    String actualDescriptionResult = (new AutoValue_OptionCollector_OptionsInfo("Name", options, element))
        .description();

    // Assert
    verify(options).description();
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
  }

  /**
   * Test OptionsInfo {@link OptionsInfo#owningClass()}.
   * <p>
   * Method under test: {@link OptionsInfo#owningClass()}
   */
  @Test
  public void testOptionsInfoOwningClass() {
    // Arrange
    Options options = mock(Options.class);
    Class<Object> element = Object.class;

    // Act
    Class<?> actualOwningClassResult = (new AutoValue_OptionCollector_OptionsInfo("Name", options, element))
        .owningClass();

    // Assert
    Class<Object> expectedOwningClassResult = Object.class;
    assertEquals(expectedOwningClassResult, actualOwningClassResult);
  }
}
