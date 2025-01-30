package org.sosy_lab.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.nio.file.Path;
import java.util.Optional;
import org.junit.Test;
import org.sosy_lab.common.NativeLibraries.Architecture;
import org.sosy_lab.common.NativeLibraries.OS;

public class NativeLibrariesDiffblueTest {
  /**
   * Test Architecture {@link Architecture#guessVmArchitecture()}.
   * <p>
   * Method under test: {@link Architecture#guessVmArchitecture()}
   */
  @Test
  public void testArchitectureGuessVmArchitecture() {
    // Arrange, Act and Assert
    assertEquals(Architecture.X86_64, Architecture.guessVmArchitecture());
  }

  /**
   * Test {@link NativeLibraries#getNativeLibraryPath()}.
   * <p>
   * Method under test: {@link NativeLibraries#getNativeLibraryPath()}
   */
  @Test
  public void testGetNativeLibraryPath() {
    // Arrange, Act and Assert
    File toFileResult = NativeLibraries.getNativeLibraryPath().toFile();
    assertEquals("x86_64-linux", toFileResult.getName());
    assertTrue(toFileResult.isAbsolute());
  }

  /**
   * Test {@link NativeLibraries#findPathForLibrary(String)}.
   * <ul>
   *   <li>When {@code Library Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NativeLibraries#findPathForLibrary(String)}
   */
  @Test
  public void testFindPathForLibrary_whenLibraryName() {
    // Arrange and Act
    Optional<Path> actualFindPathForLibraryResult = NativeLibraries.findPathForLibrary("Library Name");

    // Assert
    assertFalse(actualFindPathForLibraryResult.isPresent());
  }

  /**
   * Test {@link NativeLibraries#findPathForLibrary(String)}.
   * <ul>
   *   <li>When {@code U32bitU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NativeLibraries#findPathForLibrary(String)}
   */
  @Test
  public void testFindPathForLibrary_whenU32bitU() {
    // Arrange and Act
    Optional<Path> actualFindPathForLibraryResult = NativeLibraries.findPathForLibrary("U32bitU");

    // Assert
    assertFalse(actualFindPathForLibraryResult.isPresent());
  }

  /**
   * Test OS {@link OS#guessOperatingSystem()}.
   * <p>
   * Method under test: {@link OS#guessOperatingSystem()}
   */
  @Test
  public void testOSGuessOperatingSystem() {
    // Arrange, Act and Assert
    assertEquals(OS.LINUX, OS.guessOperatingSystem());
  }
}
