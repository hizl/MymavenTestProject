package testHashMap;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Objects;

public class MainClass {
    public static void main(String[] args) {
        TestFromUser.giveMap_whenEqualsAndHashCodeNotOverridden_thenMemoryLeak();
    }
}

class Person {
    private String name;
    private String surname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

class TestFromUser {
    @Test
    public static void giveMap_whenEqualsAndHashCodeNotOverridden_thenMemoryLeak() {
        HashMap<Person, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(new Person("Alex", "Smith"), 2);
        }
        Assert.assertFalse(map.size() == 10);
    }
}