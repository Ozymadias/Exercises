package tasks.first;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class ClassWithEqualsTest {
    @Test
    public void twoDifferentObjectsAreNotEqualEqual() {
        Object object1 = new Object();
        Object object2 = new Object();

        assertFalse(object1 == object2);
    }

    @Test
    public void sameObjectIsEqualEqualToItself() {
        Object object1 = new Object();

        assertTrue(object1 == object1);
    }

    @Test
    public void sameObjectIsEqualEqualToItselfEvenWhenDifferentlyName() {
        Object object1 = new Object();
        Object object2 = object1;

        assertTrue(object1 == object2);
    }

    @Test
    public void forObjectsEqualEqualIsTheSameAsEqualsMethod() {
        Object object1 = new Object();
        Object object2 = object1;
        Object object3 = new Object();

        assertTrue(object1.equals(object1));
        assertTrue(object1.equals(object2));
        assertFalse(object1.equals(object3));
    }

    @Test
    public void forIntegersEqualEqualAndEqualsMethodBehaveALMOSTTheSameAsForObjects() {
        Integer object1 = 1;
        Integer object2 = object1;
        Integer object3 = 1;

        assertTrue(object1 == object1);
        assertTrue(object1 == object2);
        assertTrue(object1.equals(object1));
        assertTrue(object1.equals(object2));

        assertTrue(object1 == object3);//Pool of integers
        assertTrue(object1.equals(object3)); //!!!! overwrite equals (Ctrl + b on equals in this line)
    }

    @Test
    public void nowBehaveALittleBitMoreSimilarToBehaviourForObjects() {
        Integer object1 = 1;
        Integer object2 = object1;
        Integer object3 = new Integer(1);

        assertTrue(object1 == object1);
        assertTrue(object1 == object2);
        assertFalse(object1 == object3);
        assertTrue(object1.equals(object1));
        assertTrue(object1.equals(object2));

        assertTrue(object1.equals(object3));//!!!! overwrite equals (Ctrl + b on equals in this line)
    }

    @Test
    public void forNewClassBehaveSameAsForObject() {
        ClassWithEquals object1 = new ClassWithEquals();
        ClassWithEquals object2 = object1;
        ClassWithEquals object3 = new ClassWithEquals();

        assertTrue(object1 == object1);
        assertTrue(object1 == object2);
        assertFalse(object1 == object3);
        assertTrue(object1.equals(object1));
        assertTrue(object1.equals(object2));
        assertFalse(object1.equals(object3));
    }

    @Test
    public void makeThisTestWorkingWithoutChangingAnythingItIt() {
        ClassWithEquals object1 = new ClassWithEquals();
        ClassWithEquals object2 = new ClassWithEquals();

        assertTrue(object1.equals(object2));
    }

    @Test
    public void makeThisTestWorkingWithoutChangingAnythingItIt2() {
        ClassWithEquals object1 = new ClassWithEquals("Anna", "Kowalska");
        ClassWithEquals object2 = new ClassWithEquals("Alicja", "Nowak");

        assertFalse(object1.equals(object2));
    }

    @Test
    public void makeThisTestWorkingWithoutChangingAnythingItIt3() {
        ClassWithEquals object1 = new ClassWithEquals("Anna", "Kowalska");
        ClassWithEquals object3 = new ClassWithEquals("Anna", "Kowalska");

        assertFalse(object1.equals(object3));
        assertTrue(object1.equals(object3));
    }

    @Test
    public void makeThisTestWorkingWithoutChangingAnythingItIt4() {
        ClassWithEquals object1 = new ClassWithEquals("Anna", "Kowalska");
        ClassWithEquals object3 = new ClassWithEquals();

        assertFalse(object1.equals(object3));
    }

    @Test
    public void twoDifferentObjectsHasDifferentHashcode() {
        Object object1 = new Object();
        Object object2 = new Object();

        assertNotEquals(object1.hashCode(), object2.hashCode());
    }

    @Test
    public void objectHasAlwaysSameHashcode() {
        Object object1 = new Object();

        assertEquals(object1.hashCode(), object1.hashCode());
    }

    @Test
    public void objectHasAlwaysSameHashcodeEvenWhenDifferentlyName() {
        Object object1 = new Object();
        Object object2 = object1;

        assertEquals(object1.hashCode(), object2.hashCode());
    }

    @Test
    public void hashcodeOfNewClassBehaveSame() {
        ClassWithEquals object1 = new ClassWithEquals();
        ClassWithEquals object2 = new ClassWithEquals();
        ClassWithEquals object3 = new ClassWithEquals("Anna","Noc");
        ClassWithEquals object4 = new ClassWithEquals("Anna","Noc");

        assertNotEquals(object1.hashCode(), object2.hashCode());
        assertNotEquals(object1.hashCode(), object3.hashCode());
        assertNotEquals(object3.hashCode(), object4.hashCode());
    }

    @Test
    public void whyOnlyEqualsIsNotEnough_WhyThereIsMoreThanTwoElementsInSet() {
        ClassWithEquals object1 = new ClassWithEquals();
        ClassWithEquals object2 = new ClassWithEquals();
        ClassWithEquals object3 = new ClassWithEquals("Anna","Noc");
        ClassWithEquals object4 = new ClassWithEquals("Anna","Noc");

        Set<ClassWithEquals> set = new HashSet<ClassWithEquals>();
        set.add(object1);
        set.add(object2);
        set.add(object3);
        set.add(object4);

        assertEquals(object1, object2);
        assertEquals(object3, object4);
        assertEquals(set.size(), 2);
    }
}