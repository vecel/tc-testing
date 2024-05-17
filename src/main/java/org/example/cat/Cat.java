package org.example.cat;

public class Cat {

    public String meow() {
        return "Meow";
    }

    public String loudMeow(int intensity) {
        String e = "";
        for (int i = 0; i < intensity; i++)
            e += "e";
        return "M" + e + "ow!";
    }
}
