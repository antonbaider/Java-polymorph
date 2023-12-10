package jom.com.softserve.s2.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    final private static String PACKAGE = "jom.com.softserve.s2.task2.";


    @DisplayName("Check that Classes is present")
    @ParameterizedTest
    @MethodSource("listOfClasses")
    void isTypePresent(String cl) {
        try {
            assertNotNull(Class.forName(PACKAGE + cl));
            assertEquals(cl, Class.forName(PACKAGE + cl).getSimpleName());
        } catch (ClassNotFoundException e) {
            fail("There is no class " + cl);
        }
    }

    private static Stream<Arguments> listOfClasses() {
        return Stream.of(Arguments.of("MyUtils"), Arguments.of("DrinkReceipt"), Arguments.of("DrinkPreparation"),
                Arguments.of("Rating"), Arguments.of("Coffee"), Arguments.of("Espresso"),
                Arguments.of("Cappuccino"));
    }

    @DisplayName("Check that class is interface")
    @ParameterizedTest
    @MethodSource("listOfInterface")
    void isTypeInterface(String cl) {
        try {
            Class<?> clazz = Class.forName(PACKAGE + cl);
            assertTrue(clazz.isInterface());
        } catch (ClassNotFoundException e) {
            fail("There is no " + cl + " class");
        }
    }

    private static Stream<Arguments> listOfInterface() {
        return Stream.of(Arguments.of("DrinkReceipt"), Arguments.of("DrinkPreparation"),
                Arguments.of("Rating"));
    }

    @DisplayName("Check that is classes in project")
    @ParameterizedTest
    @MethodSource("listOfTypeClass")
    void isTypeClass(String cl) {
        try {
            Class<?> clazz = Class.forName(PACKAGE + cl);
            assertTrue(!Modifier.isAbstract(clazz.getModifiers()) && !Modifier.isInterface(clazz.getModifiers()));
        } catch (ClassNotFoundException e) {
            fail("There is no " + cl + " class");
        }
    }

    private static Stream<Arguments> listOfTypeClass() {
        return Stream.of(Arguments.of("MyUtils"), Arguments.of("Coffee"),
                Arguments.of("Cappuccino"), Arguments.of("Espresso"));
    }

    @DisplayName("Check that Constructor is Public")
    @ParameterizedTest
    @MethodSource("listClassesAndConstructor")
    void isConstructorPublic(String clas, String[] parameterTypesName) {
        try {
            Class<?> clazz = Class.forName(PACKAGE + clas);
            Constructor<?>[] declaredConstructors;
            declaredConstructors = clazz.getDeclaredConstructors();
            boolean isConstructorCorrect = false;
            for (final Constructor<?> constructor : declaredConstructors) {
                final Type[] types = constructor.getGenericParameterTypes();
                final String[] parameterTypes = new String[types.length];
                for (int i = 0; i < types.length; ++i) {
                    final String[] parts = types[i].getTypeName().split("\\.");
                    parameterTypes[i] = parts[parts.length - 1];
                }
                if (Arrays.equals(parameterTypes, parameterTypesName)) {
                    isConstructorCorrect = true;
                    assertTrue(Modifier.isPublic(constructor.getModifiers()));
                    break;
                }
            }
            assertTrue(isConstructorCorrect, "Do not have a Constructor");
        } catch (ClassNotFoundException e) {
            fail("There is no class " + clas);
        }
    }

    private static Stream<Arguments> listClassesAndConstructor() {
        return Stream.of(Arguments.of("Coffee", new String[]{"String", "int"}),
                Arguments.of("Espresso", new String[]{"String", "int"}),
                Arguments.of("Cappuccino", new String[]{"String", "int"}));
    }

    @DisplayName("Check that class contain method")
    @ParameterizedTest
    @MethodSource("listClassesAndMethods")
    void hasGetHealthStatusMethod(String cl, String m) {
        Method[] methods = null;
        try {
            methods = Class.forName(PACKAGE + cl).getDeclaredMethods();
        } catch (ClassNotFoundException e) {
            fail("There is no class " + cl);
        }
        boolean isMethod = false;
        for (Method method : methods) {
            if (method.getName().equals(m)) {
                isMethod = true;
                assertEquals(method.getName(), m);
                break;
            }
        }
        assertTrue(isMethod, "Do not have method '" + m + "'");
    }

    private static Stream<Arguments> listClassesAndMethods() {
        return Stream.of(Arguments.of("MyUtils", "averageRating"),
                Arguments.of("Coffee", "getRating"), Arguments.of("Coffee", "getName"),
                Arguments.of("Coffee", "addComponent"), Arguments.of("Coffee", "makeDrink"),
                Arguments.of("Espresso", "makeDrink"),
                Arguments.of("Cappuccino", "makeDrink"));
    }

    @DisplayName("Check that child class extends Parent")
    @ParameterizedTest
    @MethodSource("listOfChildren")
    void extendsTypeClass(String parent, String child) {
        try {
            final Class<?> parentClazz = Class.forName(PACKAGE + parent);
            final Class<?> childClazz = Class.forName(PACKAGE + child);
            assertTrue(parentClazz.isAssignableFrom(childClazz));
        } catch (ClassNotFoundException e) {
            fail("There is no extends " + child + " the parent class " + parent);
        }
    }

    private static Stream<Arguments> listOfChildren() {
        String parent = "Coffee";
        String child1 = "Espresso";
        String child2 = "Cappuccino";
        return Stream.of(Arguments.of(parent, child1), Arguments.of(parent, child2));
    }

    @DisplayName("Check that class implements Interface")
    @ParameterizedTest
    @MethodSource("listOfImplementInterface")
    void implementInterface(String parentName, String childName) {
        try {
            final Class<?> parentClazz = Class.forName(PACKAGE + parentName);
            final Class<?> childClazz = Class.forName(PACKAGE + childName);
            assertTrue(parentClazz.isAssignableFrom(childClazz) && parentClazz.isInterface());
        } catch (ClassNotFoundException e) {
            fail("Class " + childName + " do not implement interface " + parentName);
        }
    }

    private static Stream<Arguments> listOfImplementInterface() {
        String cl = "Coffee";
        String interface1 = "DrinkReceipt";
        String interface2 = "DrinkPreparation";
        String interface3 = "Rating";
        return Stream.of(Arguments.of(interface1, cl), Arguments.of(interface2, cl),
                Arguments.of(interface3, cl));
    }

    @DisplayName("Check that fields is Private")
    @ParameterizedTest
    @MethodSource("listPrivateFields")
    void isFieldPrivate(String clas, String fieldName) {
        try {
            Class<?> clazz = Class.forName(PACKAGE + clas);
            Field field = clazz.getDeclaredField(fieldName);
            assertTrue(Modifier.isPrivate(field.getModifiers()));
        } catch (ClassNotFoundException e) {
            fail("There is no " + clas + " class");
        } catch (NoSuchFieldException e) {
            fail("There is no " + fieldName + " field");
        }
    }

    private static Stream<Arguments> listPrivateFields() {
        return Stream.of(Arguments.of("Coffee", "name"), Arguments.of("Coffee", "rating"),
                Arguments.of("Coffee", "ingredients"));
    }

    @DisplayName("Check that Coffee MakeDrink")
    @Test
    void checkCoffeeMakeDrink() {
        final Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("Water", 100);
        expected.put("Arabica", 20);
        Map<String, Integer> actual = null;
        try {
            actual = (Map<String, Integer>) new Coffee("Coffee", 1).makeDrink();
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("Coffee do not MakeDrink");
        }
    }

    @DisplayName("Check that Espresso MakeDrink")
    @Test
    void checkEspressoMakeDrink() {
        final Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("Water", 50);
        expected.put("Arabica", 20);
        Map<String, Integer> actual = null;
        try {
            actual = (Map<String, Integer>) new Espresso("Coffee", 1).makeDrink();
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("Espresso do not MakeDrink");
        }
    }

    @DisplayName("Check that Cappuccino MakeDrink")
    @Test
    void checkCappuccinoMakeDrink() {
        final Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("Water", 100);
        expected.put("Arabica", 20);
        expected.put("Milk", 50);
        Map<String, Integer> actual = null;
        try {
            actual = (Map<String, Integer>) new Cappuccino("Coffee", 1).makeDrink();
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("Cappuccino do not MakeDrink");
        }
    }

    @DisplayName("Check if original parameters unchanged in the 'averageRating' method")
    @Test
    void checkOriginUnchanged() {
        final List<Coffee> originList = new ArrayList<Coffee>();
        originList.add((Coffee) new Espresso("Espresso", 8));
        originList.add((Coffee) new Cappuccino("Cappuccino", 10));
        originList.add((Coffee) new Espresso("Espresso", 10));
        originList.add((Coffee) new Cappuccino("Cappuccino", 6));
        originList.add(new Coffee("Coffee", 6));
        final List<Coffee> sendList = new ArrayList<Coffee>(originList);
        try {
            new MyUtils().averageRating((List) sendList);
            assertEquals(originList, sendList);
        } catch (Exception e) {
            fail("Original parameters changed in the 'averageRating' method");
        }
    }

    @DisplayName("Check that use parameters without duplicate  Coffee names")
    @Test
    void checkUniqueAll() {
        final List<Coffee> originList = new ArrayList<Coffee>();
        originList.add((Coffee) new Espresso("Espresso", 8));
        originList.add((Coffee) new Cappuccino("Cappuccino", 10));
        originList.add(new Coffee("Coffee", 6));
        final Map<String, Double> expected = new HashMap<String, Double>();
        expected.put("Espresso", 8.0);
        expected.put("Cappuccino", 10.0);
        expected.put("Coffee", 6.0);
        Map<String, Double> actual = null;
        try {
            actual = (Map<String, Double>) new MyUtils().averageRating((List) originList);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("Do not work correct with unique Coffee names");
        }
    }

    @DisplayName("Check that use duplicate Coffee names in the 'everageRating' method parameter")
    @Test
    void checkDuplicateCoffee() {
        final List<Coffee> originList = new ArrayList<Coffee>();
        originList.add((Coffee) new Espresso("Espresso", 8));
        originList.add((Coffee) new Cappuccino("Cappuccino", 10));
        originList.add((Coffee) new Espresso("Espresso", 8));
        originList.add((Coffee) new Cappuccino("Cappuccino", 10));
        originList.add(new Coffee("Coffee", 6));
        originList.add(new Coffee("Coffee", 6));
        final Map<String, Double> expected = new HashMap<String, Double>();
        expected.put("Espresso", 8.0);
        expected.put("Cappuccino", 10.0);
        expected.put("Coffee", 6.0);
        Map<String, Double> actual = null;
        try {
            actual = (Map<String, Double>) new MyUtils().averageRating((List) originList);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("Do not work correct with duplicate Coffee names");
        }
    }

    @DisplayName("Check that one Coffee in the List")
    @Test
    void checkOneCoffee() {
        final List<Coffee> originList = new ArrayList<Coffee>();
        originList.add((Coffee) new Espresso("Espresso", 8));
        final Map<String, Double> expected = new HashMap<String, Double>();
        expected.put("Espresso", 8.0);
        Map<String, Double> actual = null;
        try {
            actual = (Map<String, Double>) new MyUtils().averageRating((List) originList);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("Do not work correct with one Coffee names");
        }
    }

    @DisplayName("Check if original list is empty")
    @Test
    void checkEmptyList() {
        final List<Coffee> originList = new ArrayList<Coffee>();
        final Map<String, Double> expected = new HashMap<String, Double>();
        Map<String, Double> actual = null;
        try {
            actual = (Map<String, Double>) new MyUtils().averageRating((List) originList);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("Do not work correct with empty List");
        }
    }


}
