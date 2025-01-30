package org.sosy_lab.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import javax.management.loading.MLet;
import org.junit.Test;
import org.mockito.Mockito;

public class ChildFirstPatternClassLoaderDiffblueTest {
  /**
   * Test {@link ChildFirstPatternClassLoader#ChildFirstPatternClassLoader(Pattern, URL[], ClassLoader)}.
   * <ul>
   *   <li>When compile {@code .*\.txt}.</li>
   *   <li>Then return not {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildFirstPatternClassLoader#ChildFirstPatternClassLoader(Pattern, URL[], ClassLoader)}
   */
  @Test
  public void testNewChildFirstPatternClassLoader_whenCompileTxt_thenReturnNotNull() throws MalformedURLException {
    // Arrange
    Pattern pClassPattern = Pattern.compile(".*\\.txt");
    Predicate<String> pLoadInChild = mock(Predicate.class);

    // Act and Assert
    assertNotNull(new ChildFirstPatternClassLoader(pClassPattern,
        new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()},
        new ChildFirstPatternClassLoader(pLoadInChild,
            new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}, new MLet())));
  }

  /**
   * Test {@link ChildFirstPatternClassLoader#ChildFirstPatternClassLoader(Predicate, URL[], ClassLoader)}.
   * <ul>
   *   <li>When {@link Predicate}.</li>
   *   <li>Then return not {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildFirstPatternClassLoader#ChildFirstPatternClassLoader(Predicate, URL[], ClassLoader)}
   */
  @Test
  public void testNewChildFirstPatternClassLoader_whenPredicate_thenReturnNotNull() throws MalformedURLException {
    // Arrange
    Predicate<String> pLoadInChild = mock(Predicate.class);
    Pattern pClassPattern = Pattern.compile(".*\\.txt");

    // Act and Assert
    assertNotNull(new ChildFirstPatternClassLoader(pLoadInChild,
        new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()},
        new ChildFirstPatternClassLoader(pClassPattern,
            new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}, new MLet())));
  }

  /**
   * Test {@link ChildFirstPatternClassLoader#loadClass(String, boolean)} with {@code String}, {@code boolean}.
   * <ul>
   *   <li>When {@code ClassLoader}.</li>
   *   <li>Then return {@link ClassLoader}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChildFirstPatternClassLoader#loadClass(String, boolean)}
   */
  @Test
  public void testLoadClassWithStringBoolean_whenJavaLangClassLoader_thenReturnClassLoader()
      throws ClassNotFoundException, MalformedURLException {
    // Arrange
    Predicate<String> pLoadInChild = mock(Predicate.class);
    when(pLoadInChild.test(Mockito.<String>any())).thenReturn(false);
    Pattern pClassPattern = Pattern.compile(".*\\.txt");

    // Act
    Class<?> actualLoadClassResult = (new ChildFirstPatternClassLoader(pLoadInChild,
        new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()},
        new ChildFirstPatternClassLoader(pClassPattern,
            new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}, new MLet())))
        .loadClass("java.lang.ClassLoader", true);

    // Assert
    verify(pLoadInChild).test(eq("java.lang.ClassLoader"));
    Class<ClassLoader> expectedLoadClassResult = ClassLoader.class;
    assertEquals(expectedLoadClassResult, actualLoadClassResult);
  }
}
