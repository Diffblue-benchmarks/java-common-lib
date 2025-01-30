package org.sosy_lab.common.configuration.converters;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.google.common.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.sosy_lab.common.configuration.InvalidConfigurationException;

public class TypeConverterDiffblueTest {
  /**
   * Test {@link TypeConverter#convertDefaultValue(String, Object, TypeToken, Annotation)}.
   * <p>
   * Method under test: {@link TypeConverter#convertDefaultValue(String, Object, TypeToken, Annotation)}
   */
  @Test
  public void testConvertDefaultValue() throws InvalidConfigurationException {
    // Arrange
    ClassTypeConverter classTypeConverter = new ClassTypeConverter();
    TypeToken<Object> type = mock(TypeToken.class);

    // Act and Assert
    assertEquals("Value", classTypeConverter.convertDefaultValue("Option Name", "Value", type,
        new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS)));
  }

  /**
   * Test {@link TypeConverter#convertDefaultValueFromOtherInstance(String, Object, TypeToken, Annotation)}.
   * <p>
   * Method under test: {@link TypeConverter#convertDefaultValueFromOtherInstance(String, Object, TypeToken, Annotation)}
   */
  @Test
  public void testConvertDefaultValueFromOtherInstance() throws InvalidConfigurationException {
    // Arrange
    ClassTypeConverter classTypeConverter = new ClassTypeConverter();
    TypeToken<Object> type = mock(TypeToken.class);

    // Act and Assert
    assertEquals("Value", classTypeConverter.convertDefaultValueFromOtherInstance("Option Name", "Value", type,
        new AutoAnnotation_TimeSpanTypeConverterTest_createAnnotation(TimeUnit.NANOSECONDS, TimeUnit.NANOSECONDS)));
  }
}
