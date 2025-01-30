package org.sosy_lab.common.configuration.converters;

import static org.junit.Assert.assertThrows;
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
import org.sosy_lab.common.log.LogManager;

public class IntegerTypeConverterDiffblueTest {
  /**
   * Test {@link IntegerTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}.
   * <p>
   * Method under test: {@link IntegerTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}
   */
  @Test
  public void testConvert() throws InvalidConfigurationException {
    // Arrange
    IntegerTypeConverter integerTypeConverter = new IntegerTypeConverter();
    TypeToken<Object> pType = mock(TypeToken.class);
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType())
        .thenThrow(
            new UnsupportedOperationException("IntegerTypeConverter needs options annotated with @IntegerOption"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> integerTypeConverter.convert("Option Name", "42", pType,
            new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), mock(LogManager.class)));
    verify(pType).getRawType();
  }

  /**
   * Test {@link IntegerTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@link TypeToken} {@link TypeToken#getRawType()} return {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegerTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}
   */
  @Test
  public void testConvert_givenJavaLangObject_whenTypeTokenGetRawTypeReturnObject()
      throws InvalidConfigurationException {
    // Arrange
    IntegerTypeConverter integerTypeConverter = new IntegerTypeConverter();
    TypeToken<Object> pType = mock(TypeToken.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<? super Object>>when(pType.getRawType()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> integerTypeConverter.convert("Option Name", "42", pType,
            new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), mock(LogManager.class)));
    verify(pType).getRawType();
  }
}
