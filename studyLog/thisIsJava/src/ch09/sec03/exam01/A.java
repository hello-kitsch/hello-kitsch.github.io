package ch09.sec03.exam01;

public class A {
    static class B {}

    B field1 = new B();
    static B field2 = new B(); //정적 필드

    A() {
        B b = new B();
    }
    void method1() {
        B b = new B();
    }
    static void method2() { //정적 메소드
        B b = new B();
    }
}
