package animal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

public class Test {
@org.junit.Test
public void givenObject_whenGetsClassName_thenCorrect() {
    Object goat = new Goat("goat");
    Class<?> clazz = goat.getClass();
    assertEquals("Goat", clazz.getSimpleName());
    assertEquals("animal.Goat", clazz.getName());
    assertEquals("animal.Goat", clazz.getCanonicalName());
}
@org.junit.Test
public void givenClassName_whenCreatesObject_thenCorrect() throws ClassNotFoundException{
    Class<?> clazz = Class.forName("animal.Goat");
    assertEquals("Goat", clazz.getSimpleName());
    assertEquals("animal.Goat", clazz.getName());
    assertEquals("animal.Goat", clazz.getCanonicalName()); 
}
@org.junit.Test
public void givenClass_whenRecognisesModifiers_thenCorrect() throws ClassNotFoundException {
    Class<?> goatClass = Class.forName("animal.Goat");
    Class<?> animalClass = Class.forName("animal.Animal");
 
    int goatMods = goatClass.getModifiers();
    int animalMods = animalClass.getModifiers();
 
    assertTrue(Modifier.isPublic(goatMods));
    assertTrue(Modifier.isAbstract(animalMods));
    assertTrue(Modifier.isPublic(animalMods));
}
@org.junit.Test
public void givenClass_whenGetsPackageInfo_thenCorrect() {
    Goat goat = new Goat("goat");
    Class<?> goatClass = goat.getClass();
    Package pkg = goatClass.getPackage();
 
    assertEquals("animal", pkg.getName());
}
@org.junit.Test
public void givenClass_whenGetsSuperClass_thenCorrect() {
    Goat goat = new Goat("goat");
    String str = "any string";
 
    Class<?> goatClass = goat.getClass();
    Class<?> goatSuperClass = goatClass.getSuperclass();
 
    assertEquals("Animal", goatSuperClass.getSimpleName());
    assertEquals("Object", str.getClass().getSuperclass().getSimpleName());
}
}
