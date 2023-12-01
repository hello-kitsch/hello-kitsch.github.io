package ch09.sec03.exam02;

public class A {
    static class B {
        int field1 = 1;
        static int field2 = 2; //(인스턴스/정적)멤버 클래스 내부에 정적 필드 선언은 Java 17부터 허용

        B() {
            System.out.println("B-생성자 실행");
        }
        void method1() {
            System.out.println("B-method1 실행");
        }
        static void method2() { //(인스턴스/정적)멤버 클래스 내부에 정적 메소드 선언은 Java 17부터 허용
            System.out.println("B-method2 실행");
        }
    }
}