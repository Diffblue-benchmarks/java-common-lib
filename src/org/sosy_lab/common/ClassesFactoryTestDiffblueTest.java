package org.sosy_lab.common;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.sosy_lab.common.ClassesFactoryTest.FactoryMethodTestClass;
import org.sosy_lab.common.ClassesFactoryTest.FactoryMethodTestClass2;

public class ClassesFactoryTestDiffblueTest {
  /**
   * Test FactoryMethodTestClass2 {@link FactoryMethodTestClass2#create(String)}.
   * <p>
   * Method under test: {@link FactoryMethodTestClass2#create(String)}
   */
  @Test
  public void testFactoryMethodTestClass2Create() {
    // Arrange, Act and Assert
    assertTrue(FactoryMethodTestClass2.create("foo") instanceof FactoryMethodTestClass2);
  }

  /**
   * Test FactoryMethodTestClass {@link FactoryMethodTestClass#create(String)}.
   * <p>
   * Method under test: {@link FactoryMethodTestClass#create(String)}
   */
  @Test
  public void testFactoryMethodTestClassCreate() {
    // Arrange, Act and Assert
    assertTrue(FactoryMethodTestClass.create("foo") instanceof FactoryMethodTestClass);
  }
}
