package org.sosy_lab.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import javax.management.loading.MLet;
import org.junit.Test;
import org.sosy_lab.common.AutoValue_ExtendedUrlClassLoader_ExtendedUrlClassLoaderConfiguration.Builder;
import org.sosy_lab.common.ExtendedUrlClassLoader.ExtendedUrlClassLoaderConfiguration;
import org.sosy_lab.common.ExtendedUrlClassLoader.ExtendedUrlClassLoaderConfiguration.AutoBuilder;

public class AutoValue_ExtendedUrlClassLoader_ExtendedUrlClassLoaderConfigurationDiffblueTest {
  /**
   * Test Builder {@link Builder#autoBuild()}.
   * <p>
   * Method under test: {@link Builder#autoBuild()}
   */
  @Test
  public void testBuilderAutoBuild() {
    // Arrange
    Builder builder = new Builder();
    builder.setUrls(new ArrayList<>());
    builder.setDirectLoadClasses(mock(Predicate.class));
    builder.setCustomLookupNativeLibraries(mock(Predicate.class));

    // Act
    ExtendedUrlClassLoaderConfiguration actualAutoBuildResult = builder.autoBuild();

    // Assert
    assertTrue(actualAutoBuildResult instanceof AutoValue_ExtendedUrlClassLoader_ExtendedUrlClassLoaderConfiguration);
    assertFalse(actualAutoBuildResult.parent().isPresent());
    assertTrue(actualAutoBuildResult.urls().isEmpty());
  }

  /**
   * Test Builder {@link Builder#autoBuild()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) CustomLookupNativeLibraries is {@link Predicate}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#autoBuild()}
   */
  @Test
  public void testBuilderAutoBuild_givenBuilderCustomLookupNativeLibrariesIsPredicate() {
    // Arrange
    Builder builder = new Builder();
    builder.setCustomLookupNativeLibraries(mock(Predicate.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builder.autoBuild());
  }

  /**
   * Test Builder {@link Builder#autoBuild()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) DirectLoadClasses is {@link Predicate}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#autoBuild()}
   */
  @Test
  public void testBuilderAutoBuild_givenBuilderDirectLoadClassesIsPredicate() {
    // Arrange
    Builder builder = new Builder();
    builder.setDirectLoadClasses(mock(Predicate.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builder.autoBuild());
  }

  /**
   * Test Builder {@link Builder#autoBuild()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) DirectLoadClasses is {@link Predicate}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#autoBuild()}
   */
  @Test
  public void testBuilderAutoBuild_givenBuilderDirectLoadClassesIsPredicate2() {
    // Arrange
    Builder builder = new Builder();
    builder.setDirectLoadClasses(mock(Predicate.class));
    builder.setUrls(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builder.autoBuild());
  }

  /**
   * Test Builder {@link Builder#autoBuild()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) Urls is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#autoBuild()}
   */
  @Test
  public void testBuilderAutoBuild_givenBuilderUrlsIsArrayList_thenThrowIllegalStateException() {
    // Arrange
    Builder builder = new Builder();
    builder.setUrls(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builder.autoBuild());
  }

  /**
   * Test Builder {@link Builder#autoBuild()}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor).</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#autoBuild()}
   */
  @Test
  public void testBuilderAutoBuild_givenBuilder_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new Builder()).autoBuild());
  }

  /**
   * Test Builder {@link Builder#setCustomLookupNativeLibraries(Predicate)} with {@code Predicate}.
   * <ul>
   *   <li>Then return {@link Builder}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#setCustomLookupNativeLibraries(Predicate)}
   */
  @Test
  public void testBuilderSetCustomLookupNativeLibrariesWithPredicate_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    AutoBuilder actualSetCustomLookupNativeLibrariesResult = builder
        .setCustomLookupNativeLibraries(mock(Predicate.class));

    // Assert
    assertTrue(actualSetCustomLookupNativeLibrariesResult instanceof Builder);
    assertSame(builder, actualSetCustomLookupNativeLibrariesResult);
  }

  /**
   * Test Builder {@link Builder#setDirectLoadClasses(Predicate)} with {@code directLoadClasses}.
   * <ul>
   *   <li>Then return {@link Builder}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#setDirectLoadClasses(Predicate)}
   */
  @Test
  public void testBuilderSetDirectLoadClassesWithDirectLoadClasses_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    AutoBuilder actualSetDirectLoadClassesResult = builder.setDirectLoadClasses(mock(Predicate.class));

    // Assert
    assertTrue(actualSetDirectLoadClassesResult instanceof Builder);
    assertSame(builder, actualSetDirectLoadClassesResult);
  }

  /**
   * Test Builder {@link Builder#setParent(ClassLoader)}.
   * <p>
   * Method under test: {@link Builder#setParent(ClassLoader)}
   */
  @Test
  public void testBuilderSetParent() throws MalformedURLException {
    // Arrange
    Builder builder = new Builder();
    Predicate<String> pLoadInChild = mock(Predicate.class);
    Pattern pClassPattern = Pattern.compile(".*\\.txt");

    // Act
    AutoBuilder actualSetParentResult = builder.setParent(new ChildFirstPatternClassLoader(pLoadInChild,
        new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()},
        new ChildFirstPatternClassLoader(pClassPattern,
            new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}, new MLet())));

    // Assert
    assertTrue(actualSetParentResult instanceof Builder);
    assertSame(builder, actualSetParentResult);
  }

  /**
   * Test Builder {@link Builder#setUrls(Iterable)} with {@code urls}.
   * <p>
   * Method under test: {@link Builder#setUrls(Iterable)}
   */
  @Test
  public void testBuilderSetUrlsWithUrls() throws MalformedURLException {
    // Arrange
    Builder builder = new Builder();

    LinkedHashSet<URL> urls = new LinkedHashSet<>();
    urls.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Act
    AutoBuilder actualSetUrlsResult = builder.setUrls(urls);

    // Assert
    assertTrue(actualSetUrlsResult instanceof Builder);
    assertSame(builder, actualSetUrlsResult);
  }

  /**
   * Test Builder {@link Builder#setUrls(Iterable)} with {@code urls}.
   * <p>
   * Method under test: {@link Builder#setUrls(Iterable)}
   */
  @Test
  public void testBuilderSetUrlsWithUrls2() throws MalformedURLException {
    // Arrange
    Builder builder = new Builder();

    ArrayList<URL> urls = new ArrayList<>();
    urls.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    urls.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Act
    AutoBuilder actualSetUrlsResult = builder.setUrls(urls);

    // Assert
    assertTrue(actualSetUrlsResult instanceof Builder);
    assertSame(builder, actualSetUrlsResult);
  }

  /**
   * Test Builder {@link Builder#setUrls(Iterable)} with {@code urls}.
   * <p>
   * Method under test: {@link Builder#setUrls(Iterable)}
   */
  @Test
  public void testBuilderSetUrlsWithUrls3() throws MalformedURLException {
    // Arrange
    Builder builder = new Builder();

    ArrayList<URL> urlList = new ArrayList<>();
    urlList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    Iterable<URL> urls = mock(Iterable.class);
    when(urls.iterator()).thenReturn(urlList.iterator());

    // Act
    AutoBuilder actualSetUrlsResult = builder.setUrls(urls);

    // Assert
    verify(urls).iterator();
    assertTrue(actualSetUrlsResult instanceof Builder);
    assertSame(builder, actualSetUrlsResult);
  }

  /**
   * Test Builder {@link Builder#setUrls(Iterable)} with {@code urls}.
   * <p>
   * Method under test: {@link Builder#setUrls(Iterable)}
   */
  @Test
  public void testBuilderSetUrlsWithUrls4() throws MalformedURLException {
    // Arrange
    Builder builder = new Builder();

    ArrayList<URL> urlList = new ArrayList<>();
    urlList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    urlList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    Iterable<URL> urls = mock(Iterable.class);
    when(urls.iterator()).thenReturn(urlList.iterator());

    // Act
    AutoBuilder actualSetUrlsResult = builder.setUrls(urls);

    // Assert
    verify(urls).iterator();
    assertTrue(actualSetUrlsResult instanceof Builder);
    assertSame(builder, actualSetUrlsResult);
  }

  /**
   * Test Builder {@link Builder#setUrls(Iterable)} with {@code urls}.
   * <p>
   * Method under test: {@link Builder#setUrls(Iterable)}
   */
  @Test
  public void testBuilderSetUrlsWithUrls5() throws MalformedURLException {
    // Arrange
    Builder builder = new Builder();

    ArrayList<URL> urlList = new ArrayList<>();
    urlList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    urlList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    urlList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    Iterable<URL> urls = mock(Iterable.class);
    when(urls.iterator()).thenReturn(urlList.iterator());

    // Act
    AutoBuilder actualSetUrlsResult = builder.setUrls(urls);

    // Assert
    verify(urls).iterator();
    assertTrue(actualSetUrlsResult instanceof Builder);
    assertSame(builder, actualSetUrlsResult);
  }

  /**
   * Test Builder {@link Builder#setUrls(Iterable)} with {@code urls}.
   * <p>
   * Method under test: {@link Builder#setUrls(Iterable)}
   */
  @Test
  public void testBuilderSetUrlsWithUrls6() throws MalformedURLException {
    // Arrange
    Builder builder = new Builder();

    ArrayList<URL> urlList = new ArrayList<>();
    urlList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    urlList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    urlList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    urlList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    urlList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());
    Iterable<URL> urls = mock(Iterable.class);
    when(urls.iterator()).thenReturn(urlList.iterator());

    // Act
    AutoBuilder actualSetUrlsResult = builder.setUrls(urls);

    // Assert
    verify(urls).iterator();
    assertTrue(actualSetUrlsResult instanceof Builder);
    assertSame(builder, actualSetUrlsResult);
  }

  /**
   * Test Builder {@link Builder#setUrls(URL[])} with {@code urls}.
   * <p>
   * Method under test: {@link Builder#setUrls(URL[])}
   */
  @Test
  public void testBuilderSetUrlsWithUrls7() {
    // Arrange
    Builder builder = new Builder();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    AutoBuilder actualSetUrlsResult = builder.setUrls();

    // Assert
    assertTrue(actualSetUrlsResult instanceof Builder);
    assertSame(builder, actualSetUrlsResult);
  }

  /**
   * Test Builder {@link Builder#setUrls(URL[])} with {@code urls}.
   * <p>
   * Method under test: {@link Builder#setUrls(URL[])}
   */
  @Test
  public void testBuilderSetUrlsWithUrls8() throws MalformedURLException {
    // Arrange
    Builder builder = new Builder();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    AutoBuilder actualSetUrlsResult = builder.setUrls(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    assertTrue(actualSetUrlsResult instanceof Builder);
    assertSame(builder, actualSetUrlsResult);
  }

  /**
   * Test Builder {@link Builder#setUrls(Iterable)} with {@code urls}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#setUrls(Iterable)}
   */
  @Test
  public void testBuilderSetUrlsWithUrls_givenArrayListIterator_thenCallsIterator() {
    // Arrange
    Builder builder = new Builder();
    Iterable<URL> urls = mock(Iterable.class);

    ArrayList<URL> urlList = new ArrayList<>();
    when(urls.iterator()).thenReturn(urlList.iterator());

    // Act
    AutoBuilder actualSetUrlsResult = builder.setUrls(urls);

    // Assert
    verify(urls).iterator();
    assertTrue(actualSetUrlsResult instanceof Builder);
    assertSame(builder, actualSetUrlsResult);
  }

  /**
   * Test Builder {@link Builder#setUrls(Iterable)} with {@code urls}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Builder}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#setUrls(Iterable)}
   */
  @Test
  public void testBuilderSetUrlsWithUrls_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    AutoBuilder actualSetUrlsResult = builder.setUrls(new ArrayList<>());

    // Assert
    assertTrue(actualSetUrlsResult instanceof Builder);
    assertSame(builder, actualSetUrlsResult);
  }

  /**
   * Test Builder {@link Builder#setUrls(URL[])} with {@code urls}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri toURL.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#setUrls(URL[])}
   */
  @Test
  public void testBuilderSetUrlsWithUrls_whenPropertyIsJavaIoTmpdirIsTestTxtToUriToURL() throws MalformedURLException {
    // Arrange
    Builder builder = new Builder();

    // Act
    AutoBuilder actualSetUrlsResult = builder
        .setUrls(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    assertTrue(actualSetUrlsResult instanceof Builder);
    assertSame(builder, actualSetUrlsResult);
  }
}
