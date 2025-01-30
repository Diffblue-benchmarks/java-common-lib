package org.sosy_lab.common.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class AutoValue_OptionCollector_OptionsInfoDiffblueTest {
  /**
   * Test {@link AutoValue_OptionCollector_OptionsInfo#element()}.
   * <p>
   * Method under test: {@link AutoValue_OptionCollector_OptionsInfo#element()}
   */
  @Test
  public void testElement() {
    // Arrange
    Options options = mock(Options.class);
    Class<Object> element = Object.class;

    // Act
    Class<?> actualElementResult = (new AutoValue_OptionCollector_OptionsInfo("Name", options, element)).element();

    // Assert
    Class<Object> expectedElementResult = Object.class;
    assertEquals(expectedElementResult, actualElementResult);
  }

  /**
   * Test {@link AutoValue_OptionCollector_OptionsInfo#equals(Object)}, and {@link AutoValue_OptionCollector_OptionsInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoValue_OptionCollector_OptionsInfo#equals(Object)}
   *   <li>{@link AutoValue_OptionCollector_OptionsInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Options options = mock(Options.class);
    Class<Object> element = Object.class;
    AutoValue_OptionCollector_OptionsInfo autoValue_OptionCollector_OptionsInfo = new AutoValue_OptionCollector_OptionsInfo(
        "Name", options, element);

    // Act and Assert
    assertEquals(autoValue_OptionCollector_OptionsInfo, autoValue_OptionCollector_OptionsInfo);
    int expectedHashCodeResult = autoValue_OptionCollector_OptionsInfo.hashCode();
    assertEquals(expectedHashCodeResult, autoValue_OptionCollector_OptionsInfo.hashCode());
  }

  /**
   * Test {@link AutoValue_OptionCollector_OptionsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_OptionCollector_OptionsInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Options options = mock(Options.class);
    Class<Object> element = Object.class;
    AutoValue_OptionCollector_OptionsInfo autoValue_OptionCollector_OptionsInfo = new AutoValue_OptionCollector_OptionsInfo(
        "Name", options, element);
    Options options2 = mock(Options.class);
    Class<Object> element2 = Object.class;

    // Act and Assert
    assertNotEquals(autoValue_OptionCollector_OptionsInfo,
        new AutoValue_OptionCollector_OptionsInfo("Name", options2, element2));
  }

  /**
   * Test {@link AutoValue_OptionCollector_OptionsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_OptionCollector_OptionsInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Options options = mock(Options.class);
    Class<Object> element = Object.class;
    AutoValue_OptionCollector_OptionsInfo autoValue_OptionCollector_OptionsInfo = new AutoValue_OptionCollector_OptionsInfo(
        "org.sosy_lab.common.configuration.OptionCollector$OptionsInfo", options, element);
    Options options2 = mock(Options.class);
    Class<Object> element2 = Object.class;

    // Act and Assert
    assertNotEquals(autoValue_OptionCollector_OptionsInfo,
        new AutoValue_OptionCollector_OptionsInfo("Name", options2, element2));
  }

  /**
   * Test {@link AutoValue_OptionCollector_OptionsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_OptionCollector_OptionsInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Options options = mock(Options.class);
    Class<Object> element = Object.class;

    // Act and Assert
    assertNotEquals(new AutoValue_OptionCollector_OptionsInfo("Name", options, element), null);
  }

  /**
   * Test {@link AutoValue_OptionCollector_OptionsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_OptionCollector_OptionsInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Options options = mock(Options.class);
    Class<Object> element = Object.class;

    // Act and Assert
    assertNotEquals(new AutoValue_OptionCollector_OptionsInfo("Name", options, element),
        "Different type to AutoValue_OptionCollector_OptionsInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoValue_OptionCollector_OptionsInfo#toString()}
   *   <li>{@link AutoValue_OptionCollector_OptionsInfo#name()}
   *   <li>{@link AutoValue_OptionCollector_OptionsInfo#options()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Options options = mock(Options.class);
    Class<Object> element = Object.class;
    AutoValue_OptionCollector_OptionsInfo autoValue_OptionCollector_OptionsInfo = new AutoValue_OptionCollector_OptionsInfo(
        "Name", options, element);

    // Act
    autoValue_OptionCollector_OptionsInfo.toString();
    String actualNameResult = autoValue_OptionCollector_OptionsInfo.name();
    autoValue_OptionCollector_OptionsInfo.options();

    // Assert
    assertEquals("Name", actualNameResult);
  }

  /**
   * Test {@link AutoValue_OptionCollector_OptionsInfo#AutoValue_OptionCollector_OptionsInfo(String, Options, Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoValue_OptionCollector_OptionsInfo#AutoValue_OptionCollector_OptionsInfo(String, Options, Class)}
   */
  @Test
  public void testNewAutoValue_OptionCollector_OptionsInfo_whenJavaLangObject_thenReturnName() {
    // Arrange
    Options options = mock(Options.class);
    Class<Object> element = Object.class;

    // Act
    AutoValue_OptionCollector_OptionsInfo actualAutoValue_OptionCollector_OptionsInfo = new AutoValue_OptionCollector_OptionsInfo(
        "Name", options, element);

    // Assert
    assertEquals("Name", actualAutoValue_OptionCollector_OptionsInfo.name());
    assertNull(actualAutoValue_OptionCollector_OptionsInfo.description());
    Class<Object> expectedElementResult = Object.class;
    assertEquals(expectedElementResult, actualAutoValue_OptionCollector_OptionsInfo.element());
    assertSame(options, actualAutoValue_OptionCollector_OptionsInfo.options());
  }
}
