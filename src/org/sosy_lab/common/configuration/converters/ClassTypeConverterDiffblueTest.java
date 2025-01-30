package org.sosy_lab.common.configuration.converters;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import com.google.common.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.sosy_lab.common.configuration.InvalidConfigurationException;
import org.sosy_lab.common.log.LogManager;

public class ClassTypeConverterDiffblueTest {
  /**
   * Test {@link ClassTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}.
   * <p>
   * Method under test: {@link ClassTypeConverter#convert(String, String, TypeToken, Annotation, Path, LogManager)}
   */
  @Test
  public void testConvert() throws InvalidConfigurationException {
    // Arrange
    ClassTypeConverter classTypeConverter = new ClassTypeConverter();
    TypeToken<Object> type = mock(TypeToken.class);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> classTypeConverter.convert("Option Name", "42", type,
            new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS),
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), mock(LogManager.class)));
  }
}
