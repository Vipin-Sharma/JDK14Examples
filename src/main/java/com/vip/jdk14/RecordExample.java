package com.vip.jdk14;

record RecordExample(String name, int value) {
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
        record Point(int x, int y) {
        }
    }
}

