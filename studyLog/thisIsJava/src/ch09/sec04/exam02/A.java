package ch09.sec04.exam02;

public class A {
    void useB() {
        class B {
            int field1 = 1;
            static int field2 = 2; //(로컬)클래스 내부에의 정적 필드 선언은 Java 17부터 허용

            B() {
                System.out.println("B-생성자 실행");
            }

            void method1() {
                System.out.println("B-method1 실행");
            }

            static void method2() {
                System.out.println("B-method2 실행");
            }
        }
        B b = new B();
        System.out.println(b.field1);
        b.method1();
        System.out.println(B.field2);
        B.method2();
    }
}