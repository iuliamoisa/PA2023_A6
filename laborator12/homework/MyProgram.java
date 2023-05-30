package org.example;

public class MyProgram {
    @Test
    public static void m1() { }
    public static void m2() { }
    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }
    public static void m4() { }
    @Test
    public static void m5() { }
    public static void m6() { }
    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }
    public static void m8() { }

    public static void m9(String text1, int value, String text2) { }
    public static void m11(int value) { }
    @Test
    public static void m12(int value1, int value2) { }
}
