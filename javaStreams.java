interface myInterface {
    void myMethod();

    // this is a functional interface. It can have only one abstract method. this is needed to
    // implement lambda expressions

    // default methods are allowed

    default void myDefaultMethod() {
        System.out.println("This is a default method");
    }

    // static methods are allowed

    static void myStaticMethod() {
        System.out.println("This is a static method");
    }
}
