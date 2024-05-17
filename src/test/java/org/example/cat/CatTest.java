package org.example.cat;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CatTest {

    Cat cat = new Cat();
    @Test
    public void meow() {
        Assertions.assertEquals("Meow", cat.meow());
    }

    @Test
    public void loudMeow() {
        Assertions.assertEquals("Meeow!", cat.loudMeow(2));
        Assertions.assertEquals("Mow!", cat.loudMeow(0));
    }
}