package org.sosy_lab.common.io;

import static org.junit.Assert.assertSame;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import org.sosy_lab.common.io.TempFile.TempFileBuilder;

public class TempFileDiffblueTest {
  /**
   * Test TempFileBuilder {@link TempFileBuilder#dir(Path)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link TempFileBuilder#dir(Path)}
   */
  @Test
  public void testTempFileBuilderDir_whenPropertyIsJavaIoTmpdirIsTestTxt_thenReturnBuilder() {
    // Arrange
    TempFileBuilder builderResult = TempFile.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dir(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test TempFileBuilder {@link TempFileBuilder#initialContent(Object, Charset)}.
   * <ul>
   *   <li>When forName {@code UTF-8}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link TempFileBuilder#initialContent(Object, Charset)}
   */
  @Test
  public void testTempFileBuilderInitialContent_whenForNameUtf8_thenReturnBuilder() {
    // Arrange
    TempFileBuilder builderResult = TempFile.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.initialContent("P Content", Charset.forName("UTF-8")));
  }

  /**
   * Test TempFileBuilder {@link TempFileBuilder#noDeleteOnJvmExit()}.
   * <p>
   * Method under test: {@link TempFileBuilder#noDeleteOnJvmExit()}
   */
  @Test
  public void testTempFileBuilderNoDeleteOnJvmExit() {
    // Arrange
    TempFileBuilder builderResult = TempFile.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.noDeleteOnJvmExit());
  }

  /**
   * Test TempFileBuilder {@link TempFileBuilder#prefix(String)}.
   * <ul>
   *   <li>When {@code P Prefix}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link TempFileBuilder#prefix(String)}
   */
  @Test
  public void testTempFileBuilderPrefix_whenPPrefix_thenReturnBuilder() {
    // Arrange
    TempFileBuilder builderResult = TempFile.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.prefix("P Prefix"));
  }

  /**
   * Test TempFileBuilder {@link TempFileBuilder#suffix(String)}.
   * <ul>
   *   <li>When {@code P Suffix}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link TempFileBuilder#suffix(String)}
   */
  @Test
  public void testTempFileBuilderSuffix_whenPSuffix_thenReturnBuilder() {
    // Arrange
    TempFileBuilder builderResult = TempFile.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.suffix("P Suffix"));
  }
}
