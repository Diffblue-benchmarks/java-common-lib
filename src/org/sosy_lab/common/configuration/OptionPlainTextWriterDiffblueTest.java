package org.sosy_lab.common.configuration;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.Test;
import org.sosy_lab.common.configuration.OptionCollector.AnnotationInfo;

public class OptionPlainTextWriterDiffblueTest {
  /**
   * Test {@link OptionPlainTextWriter#writeOption(Iterable)}.
   * <p>
   * Method under test: {@link OptionPlainTextWriter#writeOption(Iterable)}
   */
  @Test
  public void testWriteOption() {
    // Arrange
    OptionPlainTextWriter optionPlainTextWriter = new OptionPlainTextWriter(true,
        new PrintStream(new ByteArrayOutputStream(1)));
    Options options = mock(Options.class);
    when(options.description()).thenReturn("The characteristics of someone or something");
    Class<Object> element = Object.class;
    AutoValue_OptionCollector_OptionsInfo autoValue_OptionCollector_OptionsInfo = new AutoValue_OptionCollector_OptionsInfo(
        "Name", options, element);

    Options options2 = mock(Options.class);
    when(options2.description()).thenReturn("The characteristics of someone or something");
    Class<Object> element2 = Object.class;
    AutoValue_OptionCollector_OptionsInfo autoValue_OptionCollector_OptionsInfo2 = new AutoValue_OptionCollector_OptionsInfo(
        "# ", options2, element2);

    ArrayList<AnnotationInfo> allInstances = new ArrayList<>();
    allInstances.add(autoValue_OptionCollector_OptionsInfo2);
    allInstances.add(autoValue_OptionCollector_OptionsInfo);

    // Act
    optionPlainTextWriter.writeOption(allInstances);

    // Assert
    verify(options2).description();
    verify(options).description();
  }

  /**
   * Test {@link OptionPlainTextWriter#writeOption(Iterable)}.
   * <ul>
   *   <li>Then calls {@link Options#description()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionPlainTextWriter#writeOption(Iterable)}
   */
  @Test
  public void testWriteOption_thenCallsDescription() {
    // Arrange
    OptionPlainTextWriter optionPlainTextWriter = new OptionPlainTextWriter(true,
        new PrintStream(new ByteArrayOutputStream(1)));
    Options options = mock(Options.class);
    when(options.description()).thenReturn("The characteristics of someone or something");
    Class<Object> element = Object.class;
    AutoValue_OptionCollector_OptionsInfo autoValue_OptionCollector_OptionsInfo = new AutoValue_OptionCollector_OptionsInfo(
        "Name", options, element);

    ArrayList<AnnotationInfo> allInstances = new ArrayList<>();
    allInstances.add(autoValue_OptionCollector_OptionsInfo);

    // Act
    optionPlainTextWriter.writeOption(allInstances);

    // Assert
    verify(options).description();
  }

  /**
   * Test {@link OptionPlainTextWriter#formatText(String)} with {@code text}.
   * <p>
   * Method under test: {@link OptionPlainTextWriter#formatText(String)}
   */
  @Test
  public void testFormatTextWithText() {
    // Arrange, Act and Assert
    assertEquals("# java.io.PrintStreamorg.sosy_lab.common.configuration.OptionCollector$OptionInf\n",
        OptionPlainTextWriter
            .formatText("java.io.PrintStreamorg.sosy_lab.common.configuration.OptionCollector$OptionInfo"));
  }

  /**
   * Test {@link OptionPlainTextWriter#formatText(String)} with {@code text}.
   * <p>
   * Method under test: {@link OptionPlainTextWriter#formatText(String)}
   */
  @Test
  public void testFormatTextWithText2() {
    // Arrange, Act and Assert
    assertEquals("# #\n# java.io.PrintStreamorg.sosy_lab.common.configuration.OptionCollector$OptionInf\n",
        OptionPlainTextWriter
            .formatText("# java.io.PrintStreamorg.sosy_lab.common.configuration.OptionCollector$OptionInfo"));
  }

  /**
   * Test {@link OptionPlainTextWriter#formatText(String)} with {@code text}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionPlainTextWriter#formatText(String)}
   */
  @Test
  public void testFormatTextWithText_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", OptionPlainTextWriter.formatText(""));
  }

  /**
   * Test {@link OptionPlainTextWriter#formatText(String)} with {@code text}.
   * <ul>
   *   <li>When {@code Text}.</li>
   *   <li>Then return {@code # Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionPlainTextWriter#formatText(String)}
   */
  @Test
  public void testFormatTextWithText_whenText_thenReturnText() {
    // Arrange, Act and Assert
    assertEquals("# Text\n", OptionPlainTextWriter.formatText("Text"));
  }
}
