package org.sosy_lab.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import javax.management.loading.MLet;
import org.junit.Test;
import org.mockito.internal.util.reflection.GenericMetadataSupport;
import org.mockito.internal.util.reflection.GenericMetadataSupport.TypeVarBoundedType;
import org.sosy_lab.common.AutoValue_ExtendedUrlClassLoader_ExtendedUrlClassLoaderConfiguration.Builder;
import org.sosy_lab.common.Classes.ClassInstantiationException;
import org.sosy_lab.common.Classes.ClassLoaderBuilder;
import org.sosy_lab.common.Classes.UnexpectedCheckedException;
import org.sosy_lab.common.Classes.UnsuitedClassException;
import org.sosy_lab.common.ExtendedUrlClassLoader.ExtendedUrlClassLoaderConfiguration;
import org.sosy_lab.common.ExtendedUrlClassLoader.ExtendedUrlClassLoaderConfiguration.AutoBuilder;
import org.sosy_lab.common.configuration.InvalidConfigurationException;

public class ClassesDiffblueTest {
  /**
   * Test ClassInstantiationException {@link ClassInstantiationException#ClassInstantiationException(String, String, Throwable)}.
   * <p>
   * Method under test: {@link ClassInstantiationException#ClassInstantiationException(String, String, Throwable)}
   */
  @Test
  public void testClassInstantiationExceptionNewClassInstantiationException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ClassInstantiationException actualClassInstantiationException = new ClassInstantiationException("Class Name", "Msg",
        cause);

    // Assert
    assertEquals("Cannot instantiate class Class Name:Msg", actualClassInstantiationException.getLocalizedMessage());
    assertEquals("Cannot instantiate class Class Name:Msg", actualClassInstantiationException.getMessage());
    assertEquals(0, actualClassInstantiationException.getSuppressed().length);
    assertSame(cause, actualClassInstantiationException.getCause());
  }

  /**
   * Test ClassInstantiationException {@link ClassInstantiationException#ClassInstantiationException(String, Throwable)}.
   * <p>
   * Method under test: {@link ClassInstantiationException#ClassInstantiationException(String, Throwable)}
   */
  @Test
  public void testClassInstantiationExceptionNewClassInstantiationException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ClassInstantiationException actualClassInstantiationException = new ClassInstantiationException("Class Name",
        cause);

    // Assert
    assertEquals("Cannot instantiate class Class Name:null", actualClassInstantiationException.getLocalizedMessage());
    assertEquals("Cannot instantiate class Class Name:null", actualClassInstantiationException.getMessage());
    assertEquals(0, actualClassInstantiationException.getSuppressed().length);
    assertSame(cause, actualClassInstantiationException.getCause());
  }

  /**
   * Test ClassLoaderBuilder {@link ClassLoaderBuilder#setCustomLookupNativeLibraries(Pattern)} with {@code Pattern}.
   * <p>
   * Method under test: {@link ClassLoaderBuilder#setCustomLookupNativeLibraries(Pattern)}
   */
  @Test
  public void testClassLoaderBuilderSetCustomLookupNativeLibrariesWithPattern() {
    // Arrange
    Builder builder = new Builder();

    // Act
    AutoBuilder actualSetCustomLookupNativeLibrariesResult = builder
        .setCustomLookupNativeLibraries(Pattern.compile(".*\\.txt"));

    // Assert
    assertTrue(actualSetCustomLookupNativeLibrariesResult instanceof Builder);
    assertSame(builder, actualSetCustomLookupNativeLibrariesResult);
  }

  /**
   * Test ClassLoaderBuilder {@link ClassLoaderBuilder#setCustomLookupNativeLibraries(String[])} with {@code String[]}.
   * <p>
   * Method under test: {@link ClassLoaderBuilder#setCustomLookupNativeLibraries(String[])}
   */
  @Test
  public void testClassLoaderBuilderSetCustomLookupNativeLibrariesWithString() {
    // Arrange
    Builder builder = new Builder();

    // Act
    AutoBuilder actualSetCustomLookupNativeLibrariesResult = builder.setCustomLookupNativeLibraries("Native Libraries");

    // Assert
    assertTrue(actualSetCustomLookupNativeLibrariesResult instanceof Builder);
    assertSame(builder, actualSetCustomLookupNativeLibrariesResult);
  }

  /**
   * Test ClassLoaderBuilder {@link ClassLoaderBuilder#setCustomLookupNativeLibraries(String[])} with {@code String[]}.
   * <p>
   * Method under test: {@link ClassLoaderBuilder#setCustomLookupNativeLibraries(String[])}
   */
  @Test
  public void testClassLoaderBuilderSetCustomLookupNativeLibrariesWithString2() {
    // Arrange
    Builder builder = new Builder();

    // Act
    AutoBuilder actualSetCustomLookupNativeLibrariesResult = builder.setCustomLookupNativeLibraries("Native Libraries",
        "42");

    // Assert
    assertTrue(actualSetCustomLookupNativeLibrariesResult instanceof Builder);
    assertSame(builder, actualSetCustomLookupNativeLibrariesResult);
  }

  /**
   * Test ClassLoaderBuilder {@link ClassLoaderBuilder#setCustomLookupNativeLibraries(String[])} with {@code String[]}.
   * <p>
   * Method under test: {@link ClassLoaderBuilder#setCustomLookupNativeLibraries(String[])}
   */
  @Test
  public void testClassLoaderBuilderSetCustomLookupNativeLibrariesWithString3() throws MalformedURLException {
    // Arrange
    Builder builder = new Builder();
    Predicate<String> pLoadInChild = mock(Predicate.class);
    Pattern pClassPattern = Pattern.compile(".*\\.txt");
    builder.setParent(new ChildFirstPatternClassLoader(pLoadInChild,
        new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()},
        new ChildFirstPatternClassLoader(pClassPattern,
            new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}, new MLet())));

    // Act
    AutoBuilder actualSetCustomLookupNativeLibrariesResult = builder.setCustomLookupNativeLibraries();

    // Assert
    assertTrue(actualSetCustomLookupNativeLibrariesResult instanceof Builder);
    assertSame(builder, actualSetCustomLookupNativeLibrariesResult);
  }

  /**
   * Test ClassLoaderBuilder {@link ClassLoaderBuilder#setCustomLookupNativeLibraries(String[])} with {@code String[]}.
   * <ul>
   *   <li>Then return {@link Builder}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassLoaderBuilder#setCustomLookupNativeLibraries(String[])}
   */
  @Test
  public void testClassLoaderBuilderSetCustomLookupNativeLibrariesWithString_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    AutoBuilder actualSetCustomLookupNativeLibrariesResult = builder.setCustomLookupNativeLibraries();

    // Assert
    assertTrue(actualSetCustomLookupNativeLibrariesResult instanceof Builder);
    assertSame(builder, actualSetCustomLookupNativeLibrariesResult);
  }

  /**
   * Test ClassLoaderBuilder {@link ClassLoaderBuilder#setCustomLookupNativeLibraries(String[])} with {@code String[]}.
   * <ul>
   *   <li>When {@code 42} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClassLoaderBuilder#setCustomLookupNativeLibraries(String[])}
   */
  @Test
  public void testClassLoaderBuilderSetCustomLookupNativeLibrariesWithString_when42And42() {
    // Arrange
    Builder builder = new Builder();

    // Act
    AutoBuilder actualSetCustomLookupNativeLibrariesResult = builder.setCustomLookupNativeLibraries("42", "42");

    // Assert
    assertTrue(actualSetCustomLookupNativeLibrariesResult instanceof Builder);
    assertSame(builder, actualSetCustomLookupNativeLibrariesResult);
  }

  /**
   * Test ClassLoaderBuilder {@link ClassLoaderBuilder#setDirectLoadClasses(Pattern)} with {@code Pattern}.
   * <p>
   * Method under test: {@link ClassLoaderBuilder#setDirectLoadClasses(Pattern)}
   */
  @Test
  public void testClassLoaderBuilderSetDirectLoadClassesWithPattern() {
    // Arrange
    Builder builder = new Builder();

    // Act
    AutoBuilder actualSetDirectLoadClassesResult = builder.setDirectLoadClasses(Pattern.compile(".*\\.txt"));

    // Assert
    assertTrue(actualSetDirectLoadClassesResult instanceof Builder);
    assertSame(builder, actualSetDirectLoadClassesResult);
  }

  /**
   * Test ClassLoaderBuilder {@link ClassLoaderBuilder#setParentAndUrls(URLClassLoader)}.
   * <p>
   * Method under test: {@link ClassLoaderBuilder#setParentAndUrls(URLClassLoader)}
   */
  @Test
  public void testClassLoaderBuilderSetParentAndUrls() throws MalformedURLException {
    // Arrange
    Builder builder = new Builder();

    // Act
    AutoBuilder actualSetParentAndUrlsResult = builder.setParentAndUrls(
        new URLClassLoader(new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()}));

    // Assert
    assertTrue(actualSetParentAndUrlsResult instanceof Builder);
    assertSame(builder, actualSetParentAndUrlsResult);
  }

  /**
   * Test ClassLoaderBuilder {@link ClassLoaderBuilder#setParentAndUrls(URLClassLoader)}.
   * <p>
   * Method under test: {@link ClassLoaderBuilder#setParentAndUrls(URLClassLoader)}
   */
  @Test
  public void testClassLoaderBuilderSetParentAndUrls2() {
    // Arrange
    Builder builder = new Builder();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    AutoBuilder actualSetParentAndUrlsResult = builder.setParentAndUrls(new URLClassLoader(new URL[]{}));

    // Assert
    assertTrue(actualSetParentAndUrlsResult instanceof Builder);
    assertSame(builder, actualSetParentAndUrlsResult);
  }

  /**
   * Test {@link Classes#getCodeLocation(Class)}.
   * <ul>
   *   <li>Then return toFile Name is {@code guava.jar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Classes#getCodeLocation(Class)}
   */
  @Test
  public void testGetCodeLocation_thenReturnToFileNameIsGuavaJar() {
    // Arrange
    Class<ImmutableList> cls = ImmutableList.class;

    // Act and Assert
    File toFileResult = Classes.getCodeLocation(cls).toFile();
    assertEquals("guava.jar", toFileResult.getName());
    assertTrue(toFileResult.isAbsolute());
  }

  /**
   * Test {@link Classes#getCodeLocation(Class)}.
   * <ul>
   *   <li>Then return toFile Name is {@code guava.jar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Classes#getCodeLocation(Class)}
   */
  @Test
  public void testGetCodeLocation_thenReturnToFileNameIsGuavaJar2() {
    // Arrange
    Class<ImmutableList> cls = ImmutableList.class;

    // Act and Assert
    File toFileResult = Classes.getCodeLocation(cls).toFile();
    assertEquals("guava.jar", toFileResult.getName());
    assertTrue(toFileResult.isAbsolute());
  }

  /**
   * Test {@link Classes#createInstance(Class, Class[], Object[], Class)} with {@code cls}, {@code argumentTypes}, {@code argumentValues}, {@code type}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class[], Object[], Class)}
   */
  @Test
  public void testCreateInstanceWithClsArgumentTypesArgumentValuesType()
      throws InvocationTargetException, ClassInstantiationException {
    // Arrange
    Class<Object> cls = Object.class;
    Class<Object> forNameResult = Object.class;
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(ClassInstantiationException.class,
        () -> Classes.createInstance(cls, new Class[]{forNameResult}, new Object[]{"Argument Values"}, type));
  }

  /**
   * Test {@link Classes#createInstance(Class, Class[], Object[], Class)} with {@code cls}, {@code argumentTypes}, {@code argumentValues}, {@code type}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class[], Object[], Class)}
   */
  @Test
  public void testCreateInstanceWithClsArgumentTypesArgumentValuesType2()
      throws InvocationTargetException, ClassInstantiationException {
    // Arrange
    Class<Object> cls = Object.class;
    Class<Object> forNameResult = Object.class;
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(ClassInstantiationException.class,
        () -> Classes.createInstance(cls, new Class[]{forNameResult}, new Object[]{"Argument Values"}, type));
  }

  /**
   * Test {@link Classes#createInstance(Class, Class, Class[], Object[])} with {@code type}, {@code cls}, {@code argumentTypes}, {@code argumentValues}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class, Class[], Object[])}
   */
  @Test
  public void testCreateInstanceWithTypeClsArgumentTypesArgumentValues() throws InvalidConfigurationException {
    // Arrange
    Class<Object> type = Object.class;
    Class<Object> cls = Object.class;
    Class<Object> forNameResult = Object.class;

    // Act and Assert
    assertThrows(InvalidConfigurationException.class,
        () -> Classes.createInstance(type, cls, new Class[]{forNameResult}, new Object[]{"Argument Values"}));
  }

  /**
   * Test {@link Classes#createInstance(Class, Class, Class[], Object[])} with {@code type}, {@code cls}, {@code argumentTypes}, {@code argumentValues}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class, Class[], Object[])}
   */
  @Test
  public void testCreateInstanceWithTypeClsArgumentTypesArgumentValues2() throws InvalidConfigurationException {
    // Arrange
    Class<Object> type = Object.class;
    Class<Object> cls = Object.class;

    // Act and Assert
    assertThrows(InvalidConfigurationException.class,
        () -> Classes.createInstance(type, cls, null, new Object[]{"Argument Values"}));
  }

  /**
   * Test {@link Classes#createInstance(Class, Class, Class[], Object[])} with {@code type}, {@code cls}, {@code argumentTypes}, {@code argumentValues}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class, Class[], Object[])}
   */
  @Test
  public void testCreateInstanceWithTypeClsArgumentTypesArgumentValues3() throws InvalidConfigurationException {
    // Arrange
    Class<Object> type = Object.class;
    Class<InvalidConfigurationException> cls = InvalidConfigurationException.class;

    // Act
    Object actualCreateInstanceResult = Classes.createInstance(type, cls, null, new Object[]{"Argument Values"});

    // Assert
    assertTrue(actualCreateInstanceResult instanceof InvalidConfigurationException);
    assertEquals("Argument Values", ((InvalidConfigurationException) actualCreateInstanceResult).getLocalizedMessage());
    assertEquals("Argument Values", ((InvalidConfigurationException) actualCreateInstanceResult).getMessage());
    assertNull(((InvalidConfigurationException) actualCreateInstanceResult).getCause());
    assertEquals(0, ((InvalidConfigurationException) actualCreateInstanceResult).getSuppressed().length);
  }

  /**
   * Test {@link Classes#createInstance(Class, Class, Class[], Object[])} with {@code type}, {@code cls}, {@code argumentTypes}, {@code argumentValues}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class, Class[], Object[])}
   */
  @Test
  public void testCreateInstanceWithTypeClsArgumentTypesArgumentValues4() throws InvalidConfigurationException {
    // Arrange
    Class<Object> type = Object.class;
    Class<Object> cls = Object.class;
    Class<Object> forNameResult = Object.class;

    // Act and Assert
    assertThrows(InvalidConfigurationException.class,
        () -> Classes.createInstance(type, cls, new Class[]{forNameResult}, new Object[]{"Argument Values"}));
  }

  /**
   * Test {@link Classes#createInstance(Class, Class, Class[], Object[])} with {@code type}, {@code cls}, {@code argumentTypes}, {@code argumentValues}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class, Class[], Object[])}
   */
  @Test
  public void testCreateInstanceWithTypeClsArgumentTypesArgumentValues5() throws InvalidConfigurationException {
    // Arrange
    Class<Object> type = Object.class;
    Class<Object> cls = Object.class;

    // Act and Assert
    assertThrows(InvalidConfigurationException.class,
        () -> Classes.createInstance(type, cls, null, new Object[]{"Argument Values"}));
  }

  /**
   * Test {@link Classes#createInstance(Class, Class, Class[], Object[])} with {@code type}, {@code cls}, {@code argumentTypes}, {@code argumentValues}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class, Class[], Object[])}
   */
  @Test
  public void testCreateInstanceWithTypeClsArgumentTypesArgumentValues6() throws InvalidConfigurationException {
    // Arrange
    Class<Object> type = Object.class;
    Class<InvalidConfigurationException> cls = InvalidConfigurationException.class;

    // Act
    Object actualCreateInstanceResult = Classes.createInstance(type, cls, null, new Object[]{"Argument Values"});

    // Assert
    assertTrue(actualCreateInstanceResult instanceof InvalidConfigurationException);
    assertEquals("Argument Values", ((InvalidConfigurationException) actualCreateInstanceResult).getLocalizedMessage());
    assertEquals("Argument Values", ((InvalidConfigurationException) actualCreateInstanceResult).getMessage());
    assertNull(((InvalidConfigurationException) actualCreateInstanceResult).getCause());
    assertEquals(0, ((InvalidConfigurationException) actualCreateInstanceResult).getSuppressed().length);
  }

  /**
   * Test {@link Classes#createInstance(Class, Class, Class[], Object[], Class)} with {@code type}, {@code cls}, {@code argumentTypes}, {@code argumentValues}, {@code exceptionType}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class, Class[], Object[], Class)}
   */
  @Test
  public void testCreateInstanceWithTypeClsArgumentTypesArgumentValuesExceptionType() throws Exception {
    // Arrange
    Class<Object> type = Object.class;
    Class<Object> cls = Object.class;
    Class<Object> forNameResult = Object.class;
    Class<Exception> exceptionType = Exception.class;

    // Act and Assert
    assertThrows(InvalidConfigurationException.class, () -> Classes.createInstance(type, cls,
        new Class[]{forNameResult}, new Object[]{"Argument Values"}, exceptionType));
  }

  /**
   * Test {@link Classes#createInstance(Class, Class, Class[], Object[], Class)} with {@code type}, {@code cls}, {@code argumentTypes}, {@code argumentValues}, {@code exceptionType}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class, Class[], Object[], Class)}
   */
  @Test
  public void testCreateInstanceWithTypeClsArgumentTypesArgumentValuesExceptionType2() throws Exception {
    // Arrange
    Class<Object> type = Object.class;
    Class<Object> cls = Object.class;
    Class<Exception> exceptionType = Exception.class;

    // Act and Assert
    assertThrows(InvalidConfigurationException.class,
        () -> Classes.createInstance(type, cls, null, new Object[]{"Argument Values"}, exceptionType));
  }

  /**
   * Test {@link Classes#createInstance(Class, Class, Class[], Object[], Class)} with {@code type}, {@code cls}, {@code argumentTypes}, {@code argumentValues}, {@code exceptionType}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class, Class[], Object[], Class)}
   */
  @Test
  public void testCreateInstanceWithTypeClsArgumentTypesArgumentValuesExceptionType3() throws Exception {
    // Arrange
    Class<Object> type = Object.class;
    Class<InvalidConfigurationException> cls = InvalidConfigurationException.class;
    Class<Exception> exceptionType = Exception.class;

    // Act
    Object actualCreateInstanceResult = Classes.createInstance(type, cls, null, new Object[]{"Argument Values"},
        exceptionType);

    // Assert
    assertTrue(actualCreateInstanceResult instanceof InvalidConfigurationException);
    assertEquals("Argument Values", ((InvalidConfigurationException) actualCreateInstanceResult).getLocalizedMessage());
    assertEquals("Argument Values", ((InvalidConfigurationException) actualCreateInstanceResult).getMessage());
    assertNull(((InvalidConfigurationException) actualCreateInstanceResult).getCause());
    assertEquals(0, ((InvalidConfigurationException) actualCreateInstanceResult).getSuppressed().length);
  }

  /**
   * Test {@link Classes#createInstance(Class, Class, Class[], Object[], Class)} with {@code type}, {@code cls}, {@code argumentTypes}, {@code argumentValues}, {@code exceptionType}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class, Class[], Object[], Class)}
   */
  @Test
  public void testCreateInstanceWithTypeClsArgumentTypesArgumentValuesExceptionType4() throws Exception {
    // Arrange
    Class<Object> type = Object.class;
    Class<Object> cls = Object.class;
    Class<Object> forNameResult = Object.class;
    Class<Exception> exceptionType = Exception.class;

    // Act and Assert
    assertThrows(InvalidConfigurationException.class, () -> Classes.createInstance(type, cls,
        new Class[]{forNameResult}, new Object[]{"Argument Values"}, exceptionType));
  }

  /**
   * Test {@link Classes#createInstance(Class, Class, Class[], Object[], Class)} with {@code type}, {@code cls}, {@code argumentTypes}, {@code argumentValues}, {@code exceptionType}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class, Class[], Object[], Class)}
   */
  @Test
  public void testCreateInstanceWithTypeClsArgumentTypesArgumentValuesExceptionType5() throws Exception {
    // Arrange
    Class<Object> type = Object.class;
    Class<Object> cls = Object.class;
    Class<Exception> exceptionType = Exception.class;

    // Act and Assert
    assertThrows(InvalidConfigurationException.class,
        () -> Classes.createInstance(type, cls, null, new Object[]{"Argument Values"}, exceptionType));
  }

  /**
   * Test {@link Classes#createInstance(Class, Class, Class[], Object[], Class)} with {@code type}, {@code cls}, {@code argumentTypes}, {@code argumentValues}, {@code exceptionType}.
   * <p>
   * Method under test: {@link Classes#createInstance(Class, Class, Class[], Object[], Class)}
   */
  @Test
  public void testCreateInstanceWithTypeClsArgumentTypesArgumentValuesExceptionType6() throws Exception {
    // Arrange
    Class<Object> type = Object.class;
    Class<InvalidConfigurationException> cls = InvalidConfigurationException.class;
    Class<Exception> exceptionType = Exception.class;

    // Act
    Object actualCreateInstanceResult = Classes.createInstance(type, cls, null, new Object[]{"Argument Values"},
        exceptionType);

    // Assert
    assertTrue(actualCreateInstanceResult instanceof InvalidConfigurationException);
    assertEquals("Argument Values", ((InvalidConfigurationException) actualCreateInstanceResult).getLocalizedMessage());
    assertEquals("Argument Values", ((InvalidConfigurationException) actualCreateInstanceResult).getMessage());
    assertNull(((InvalidConfigurationException) actualCreateInstanceResult).getCause());
    assertEquals(0, ((InvalidConfigurationException) actualCreateInstanceResult).getSuppressed().length);
  }

  /**
   * Test {@link Classes#forName(String, String)} with {@code name}, {@code prefix}.
   * <ul>
   *   <li>Then return {@link ImmutableList}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Classes#forName(String, String)}
   */
  @Test
  public void testForNameWithNamePrefix_thenReturnImmutableList() throws ClassNotFoundException {
    // Arrange and Act
    Class<?> actualForNameResult = Classes.forName("com.google.common.collect.ImmutableList", "Prefix");

    // Assert
    Class<ImmutableList> expectedForNameResult = ImmutableList.class;
    assertEquals(expectedForNameResult, actualForNameResult);
  }

  /**
   * Test {@link Classes#forName(String, String)} with {@code name}, {@code prefix}.
   * <ul>
   *   <li>Then return {@link ImmutableList}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Classes#forName(String, String)}
   */
  @Test
  public void testForNameWithNamePrefix_thenReturnImmutableList2() throws ClassNotFoundException {
    // Arrange and Act
    Class<?> actualForNameResult = Classes.forName("com.google.common.collect.ImmutableList", "Prefix");

    // Assert
    Class<ImmutableList> expectedForNameResult = ImmutableList.class;
    assertEquals(expectedForNameResult, actualForNameResult);
  }

  /**
   * Test {@link Classes#forName(String, String)} with {@code name}, {@code prefix}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link ImmutableList}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Classes#forName(String, String)}
   */
  @Test
  public void testForNameWithNamePrefix_whenEmptyString_thenReturnImmutableList() throws ClassNotFoundException {
    // Arrange and Act
    Class<?> actualForNameResult = Classes.forName("com.google.common.collect.ImmutableList", "");

    // Assert
    Class<ImmutableList> expectedForNameResult = ImmutableList.class;
    assertEquals(expectedForNameResult, actualForNameResult);
  }

  /**
   * Test {@link Classes#forName(String, String)} with {@code name}, {@code prefix}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link ImmutableList}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Classes#forName(String, String)}
   */
  @Test
  public void testForNameWithNamePrefix_whenEmptyString_thenReturnImmutableList2() throws ClassNotFoundException {
    // Arrange and Act
    Class<?> actualForNameResult = Classes.forName("com.google.common.collect.ImmutableList", "");

    // Assert
    Class<ImmutableList> expectedForNameResult = ImmutableList.class;
    assertEquals(expectedForNameResult, actualForNameResult);
  }

  /**
   * Test UnexpectedCheckedException {@link UnexpectedCheckedException#UnexpectedCheckedException(String, Throwable)}.
   * <p>
   * Method under test: {@link UnexpectedCheckedException#UnexpectedCheckedException(String, Throwable)}
   */
  @Test
  public void testUnexpectedCheckedExceptionNewUnexpectedCheckedException() {
    // Arrange
    IOException source = new IOException("foo");

    // Act
    UnexpectedCheckedException actualUnexpectedCheckedException = new UnexpectedCheckedException("An error occurred",
        source);

    // Assert
    assertEquals("Unexpected checked exception IOException during An error occurred: foo",
        actualUnexpectedCheckedException.getLocalizedMessage());
    assertEquals("Unexpected checked exception IOException during An error occurred: foo",
        actualUnexpectedCheckedException.getMessage());
    assertSame(source, actualUnexpectedCheckedException.getCause());
  }

  /**
   * Test UnexpectedCheckedException {@link UnexpectedCheckedException#UnexpectedCheckedException(String, Throwable)}.
   * <p>
   * Method under test: {@link UnexpectedCheckedException#UnexpectedCheckedException(String, Throwable)}
   */
  @Test
  public void testUnexpectedCheckedExceptionNewUnexpectedCheckedException2() {
    // Arrange
    IOException source = new IOException();

    // Act
    UnexpectedCheckedException actualUnexpectedCheckedException = new UnexpectedCheckedException("An error occurred",
        source);

    // Assert
    assertEquals("Unexpected checked exception IOException during An error occurred",
        actualUnexpectedCheckedException.getLocalizedMessage());
    assertEquals("Unexpected checked exception IOException during An error occurred",
        actualUnexpectedCheckedException.getMessage());
    assertSame(source, actualUnexpectedCheckedException.getCause());
  }

  /**
   * Test UnsuitedClassException {@link UnsuitedClassException#UnsuitedClassException(String, Object[])}.
   * <p>
   * Method under test: {@link UnsuitedClassException#UnsuitedClassException(String, Object[])}
   */
  @Test
  public void testUnsuitedClassExceptionNewUnsuitedClassException() {
    // Arrange and Act
    UnsuitedClassException actualUnsuitedClassException = new UnsuitedClassException("Msg", "Args");

    // Assert
    assertEquals("Msg", actualUnsuitedClassException.getLocalizedMessage());
    assertEquals("Msg", actualUnsuitedClassException.getMessage());
    assertNull(actualUnsuitedClassException.getCause());
    assertEquals(0, actualUnsuitedClassException.getSuppressed().length);
  }

  /**
   * Test {@link Classes#verifyDeclaredExceptions(Invokable, Class[])} with {@code invokable}, {@code allowedExceptionTypes}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Classes#verifyDeclaredExceptions(Invokable, Class[])}
   */
  @Test
  public void testVerifyDeclaredExceptionsWithInvokableAllowedExceptionTypes_thenReturnNull() {
    // Arrange
    UnmodifiableIterator<TypeToken<? extends Throwable>> unmodifiableIterator = mock(UnmodifiableIterator.class);
    when(unmodifiableIterator.hasNext()).thenReturn(false);
    ImmutableList<TypeToken<? extends Throwable>> typeTokenList = mock(ImmutableList.class);
    org.mockito.Mockito.<UnmodifiableIterator<TypeToken<? extends Throwable>>>when(typeTokenList.iterator())
        .thenReturn(unmodifiableIterator);
    Invokable<Object, Object> invokable = mock(Invokable.class);
    org.mockito.Mockito.<ImmutableList<TypeToken<? extends Throwable>>>when(invokable.getExceptionTypes())
        .thenReturn(typeTokenList);
    Class<Object> forNameResult = Object.class;

    // Act
    String actualVerifyDeclaredExceptionsResult = Classes.verifyDeclaredExceptions(invokable, forNameResult);

    // Assert
    verify(typeTokenList).iterator();
    verify(invokable).getExceptionTypes();
    verify(unmodifiableIterator).hasNext();
    assertNull(actualVerifyDeclaredExceptionsResult);
  }

  /**
   * Test {@link Classes#verifyDeclaredExceptions(Invokable, Class[])} with {@code invokable}, {@code allowedExceptionTypes}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Classes#verifyDeclaredExceptions(Invokable, Class[])}
   */
  @Test
  public void testVerifyDeclaredExceptionsWithInvokableAllowedExceptionTypes_thenReturnNull2() {
    // Arrange
    UnmodifiableIterator<TypeToken<? extends Throwable>> unmodifiableIterator = mock(UnmodifiableIterator.class);
    when(unmodifiableIterator.hasNext()).thenReturn(false);
    ImmutableList<TypeToken<? extends Throwable>> typeTokenList = mock(ImmutableList.class);
    org.mockito.Mockito.<UnmodifiableIterator<TypeToken<? extends Throwable>>>when(typeTokenList.iterator())
        .thenReturn(unmodifiableIterator);
    Invokable<Object, Object> invokable = mock(Invokable.class);
    org.mockito.Mockito.<ImmutableList<TypeToken<? extends Throwable>>>when(invokable.getExceptionTypes())
        .thenReturn(typeTokenList);
    Class<Object> forNameResult = Object.class;

    // Act
    String actualVerifyDeclaredExceptionsResult = Classes.verifyDeclaredExceptions(invokable, forNameResult);

    // Assert
    verify(typeTokenList).iterator();
    verify(invokable).getExceptionTypes();
    verify(unmodifiableIterator).hasNext();
    assertNull(actualVerifyDeclaredExceptionsResult);
  }

  /**
   * Test {@link Classes#extractUpperBoundFromType(Type)}.
   * <ul>
   *   <li>Then return {@link TypeVarBoundedType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Classes#extractUpperBoundFromType(Type)}
   */
  @Test
  public void testExtractUpperBoundFromType_thenReturnTypeVarBoundedType() {
    // Arrange and Act
    Type actualExtractUpperBoundFromTypeResult = Classes.extractUpperBoundFromType(new TypeVarBoundedType(null));

    // Assert
    assertTrue(actualExtractUpperBoundFromTypeResult instanceof TypeVarBoundedType);
    assertNull(((TypeVarBoundedType) actualExtractUpperBoundFromTypeResult).typeVariable());
  }

  /**
   * Test {@link Classes#extractUpperBoundFromType(Type)}.
   * <ul>
   *   <li>Then return {@link TypeVarBoundedType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Classes#extractUpperBoundFromType(Type)}
   */
  @Test
  public void testExtractUpperBoundFromType_thenReturnTypeVarBoundedType2() {
    // Arrange and Act
    Type actualExtractUpperBoundFromTypeResult = Classes.extractUpperBoundFromType(new TypeVarBoundedType(null));

    // Assert
    assertTrue(actualExtractUpperBoundFromTypeResult instanceof TypeVarBoundedType);
    assertNull(((TypeVarBoundedType) actualExtractUpperBoundFromTypeResult).typeVariable());
  }

  /**
   * Test {@link Classes#createFactory(TypeToken, Class)} with {@code TypeToken}, {@code Class}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Classes#createFactory(TypeToken, Class)}
   */
  @Test
  public void testCreateFactoryWithTypeTokenClass_thenThrowSecurityException() throws UnsuitedClassException {
    // Arrange
    TypeToken<Object> factoryType = mock(TypeToken.class);
    org.mockito.Mockito.<Class<? super Object>>when(factoryType.getRawType()).thenThrow(new SecurityException("foo"));
    Class<Object> cls = Object.class;

    // Act and Assert
    assertThrows(SecurityException.class, () -> Classes.createFactory(factoryType, cls));
    verify(factoryType).getRawType();
  }

  /**
   * Test {@link Classes#createFactory(TypeToken, Class)} with {@code TypeToken}, {@code Class}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Classes#createFactory(TypeToken, Class)}
   */
  @Test
  public void testCreateFactoryWithTypeTokenClass_thenThrowSecurityException2() throws UnsuitedClassException {
    // Arrange
    TypeToken<Object> factoryType = mock(TypeToken.class);
    org.mockito.Mockito.<Class<? super Object>>when(factoryType.getRawType()).thenThrow(new SecurityException("foo"));
    Class<Object> cls = Object.class;

    // Act and Assert
    assertThrows(SecurityException.class, () -> Classes.createFactory(factoryType, cls));
    verify(factoryType).getRawType();
  }
}
