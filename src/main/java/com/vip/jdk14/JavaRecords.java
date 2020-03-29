package com.vip.jdk14;

public class JavaRecords {
    public static void main(String[] args) {
        String input = "Vipin:1";
        NameValue nameValue = m1(input);
        System.out.println(nameValue.name() + nameValue.value());
        /*new NameValue("stringPart", 2);*/
        /*new NameValue(2);*/
        //new NameValue(); // Having compact constructor doesnt mean we can initialize Record in this way
        /*int y = new NameValue("stringPart", 2).y;
        System.out.println(y);*/
    }

    private static NameValue m1(String input) {
        String[] strings = input.split(":");
        String stringPart = strings[0];
        int intPart = Integer.parseInt(strings[1]);
        return new NameValue(stringPart, intPart);
    }
}

/*
The record's body may declare static methods, static fields, static initializers, constructors,
instance methods, and nested types.
 */
record NameValue(String name, int value) {
    /*private final int y=0;*/ // compilation error, records can not declare instance fields.
    static int y;

    /*//compact constructor, always called when defined.
    public NameValue {
        if(value == 1) throw new RuntimeException("");
    }*/

    /*//canonical constructor (the one whose signature matches the record's state description)
    public NameValue(String name, int value) {
        this.name = name;
        this.value = value;
    }*/

    /*// Custom constructor
    public NameValue(int value) {
        this(null, value); // Necessary to avoid compilation error
        if(value == 2) throw new RuntimeException("");
    }*/

    static int x;

    static {
        System.out.println("I am static initializer");
    }

    void instanceMethod() {
        System.out.println("I am instance method");
    }

    static void staticMethod() {
        System.out.println("I am static method");
    }

    // nested Record which is static implicitly.
    record NestedRecord(int x) {

    }
}

//Following code shows compilation error: Cannot inherit from final 'com.vip.jdk14.Base'
/*
record Base(int a) { }
record Child(int a, int b) extends Base { }
*/
