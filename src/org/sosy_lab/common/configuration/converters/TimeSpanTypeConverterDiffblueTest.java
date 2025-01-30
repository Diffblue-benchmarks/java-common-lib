package org.sosy_lab.common.configuration.converters;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.sosy_lab.common.configuration.InvalidConfigurationException;
import org.sosy_lab.common.configuration.TimeSpanOption;
import org.sosy_lab.common.log.LogManager;

public class TimeSpanTypeConverterDiffblueTest {
  /**
   * Test {@link TimeSpanTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}.
   * <ul>
   *   <li>Given {@link Long#MAX_VALUE}.</li>
   *   <li>When {@link TimeSpanOption} {@link TimeSpanOption#min()} return {@link Long#MAX_VALUE}.</li>
   *   <li>Then calls {@link TimeSpanOption#max()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpanTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}
   */
  @Test
  public void testConvert_givenMax_value_whenTimeSpanOptionMinReturnMax_value_thenCallsMax()
      throws InvalidConfigurationException {
    // Arrange
    TimeSpanTypeConverter timeSpanTypeConverter = new TimeSpanTypeConverter();
    TypeToken<Object> pType = mock(TypeToken.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType()).thenReturn(forNameResult);
    TimeSpanOption pOption = mock(TimeSpanOption.class);
    when(pOption.max()).thenReturn(1L);
    when(pOption.min()).thenReturn(Long.MAX_VALUE);
    when(pOption.codeUnit()).thenReturn(TimeUnit.NANOSECONDS);
    when(pOption.defaultUserUnit()).thenReturn(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertThrows(InvalidConfigurationException.class, () -> timeSpanTypeConverter.convert("Option Name", "42", pType,
        pOption, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), mock(LogManager.class)));
    verify(pType).getRawType();
    verify(pOption).codeUnit();
    verify(pOption).defaultUserUnit();
    verify(pOption).max();
    verify(pOption, atLeast(1)).min();
  }

  /**
   * Test {@link TimeSpanTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link TimeSpanOption} {@link TimeSpanOption#min()} return one.</li>
   *   <li>Then calls {@link TimeSpanOption#max()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpanTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}
   */
  @Test
  public void testConvert_givenOne_whenTimeSpanOptionMinReturnOne_thenCallsMax() throws InvalidConfigurationException {
    // Arrange
    TimeSpanTypeConverter timeSpanTypeConverter = new TimeSpanTypeConverter();
    TypeToken<Object> pType = mock(TypeToken.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType()).thenReturn(forNameResult);
    TimeSpanOption pOption = mock(TimeSpanOption.class);
    when(pOption.max()).thenReturn(1L);
    when(pOption.min()).thenReturn(1L);
    when(pOption.codeUnit()).thenReturn(TimeUnit.NANOSECONDS);
    when(pOption.defaultUserUnit()).thenReturn(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertThrows(InvalidConfigurationException.class, () -> timeSpanTypeConverter.convert("Option Name", "42", pType,
        pOption, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), mock(LogManager.class)));
    verify(pType).getRawType();
    verify(pOption).codeUnit();
    verify(pOption).defaultUserUnit();
    verify(pOption, atLeast(1)).max();
    verify(pOption, atLeast(1)).min();
  }

  /**
   * Test {@link TimeSpanTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpanTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}
   */
  @Test
  public void testConvert_thenThrowNumberFormatException() throws InvalidConfigurationException {
    // Arrange
    TimeSpanTypeConverter timeSpanTypeConverter = new TimeSpanTypeConverter();
    TypeToken<Object> pType = mock(TypeToken.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType()).thenReturn(forNameResult);
    TimeSpanOption pOption = mock(TimeSpanOption.class);
    when(pOption.min()).thenThrow(
        new NumberFormatException("Invalid value in configuration file: \"%s = %s (not in range [%d %s, %d %s])"));
    when(pOption.codeUnit()).thenReturn(TimeUnit.NANOSECONDS);
    when(pOption.defaultUserUnit()).thenReturn(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> timeSpanTypeConverter.convert("Option Name", "42", pType, pOption,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), mock(LogManager.class)));
    verify(pType).getRawType();
    verify(pOption).codeUnit();
    verify(pOption).defaultUserUnit();
    verify(pOption).min();
  }

  /**
   * Test {@link TimeSpanTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link InvalidConfigurationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpanTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}
   */
  @Test
  public void testConvert_whenEmptyString_thenThrowInvalidConfigurationException()
      throws InvalidConfigurationException {
    // Arrange
    TimeSpanTypeConverter timeSpanTypeConverter = new TimeSpanTypeConverter();
    TypeToken<Object> pType = mock(TypeToken.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(InvalidConfigurationException.class,
        () -> timeSpanTypeConverter.convert("Option Name", "", pType,
            new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), mock(LogManager.class)));
    verify(pType).getRawType();
  }

  /**
   * Test {@link TimeSpanTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}.
   * <ul>
   *   <li>When {@code Invalid value in configuration file: "%s = %s (not in range [%d %s, %d %s])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpanTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}
   */
  @Test
  public void testConvert_whenInvalidValueInConfigurationFileSSNotInRangeDSDS() throws InvalidConfigurationException {
    // Arrange
    TimeSpanTypeConverter timeSpanTypeConverter = new TimeSpanTypeConverter();
    TypeToken<Object> pType = mock(TypeToken.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType()).thenReturn(forNameResult);
    TimeSpanOption pOption = mock(TimeSpanOption.class);
    when(pOption.defaultUserUnit()).thenReturn(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertThrows(InvalidConfigurationException.class,
        () -> timeSpanTypeConverter.convert("Option Name",
            "Invalid value in configuration file: \"%s = %s (not in range [%d %s, %d %s])", pType, pOption,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), mock(LogManager.class)));
    verify(pType).getRawType();
    verify(pOption).defaultUserUnit();
  }

  /**
   * Test {@link TimeSpanTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}.
   * <ul>
   *   <li>When {@code Value Str}.</li>
   *   <li>Then throw {@link InvalidConfigurationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeSpanTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}
   */
  @Test
  public void testConvert_whenValueStr_thenThrowInvalidConfigurationException() throws InvalidConfigurationException {
    // Arrange
    TimeSpanTypeConverter timeSpanTypeConverter = new TimeSpanTypeConverter();
    TypeToken<Object> pType = mock(TypeToken.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(InvalidConfigurationException.class,
        () -> timeSpanTypeConverter.convert("Option Name", "Value Str", pType,
            new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), mock(LogManager.class)));
    verify(pType).getRawType();
  }
}
