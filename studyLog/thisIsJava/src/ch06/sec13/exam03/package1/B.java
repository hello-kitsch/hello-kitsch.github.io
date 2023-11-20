package ch06.sec13.exam03.package1;

public class B {
    public void method() {
        A a = new A();

        a.field1 = 1;
        a.field2 = 1;
        a.field3 = 1; //private 필드 접근 불가

        a.method1();
        a.method2();
        a.method3(); //private 메소드 접근 불가
    }
}
