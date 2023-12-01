package ch09.sec02.exam02;

public class A {
    class B {
        int field1 = 1;
        
        static int field2 = 2; //정적 필드(Java 17부터 허용)

        B() {
            System.out.println("B-생성자 실행");
        }

        void method1() {
            System.out.println("B-method1 실행");
        }

        static void method2() { //정적 메소드(Java 17부터 허용)
            System.out.println("B-method2 실행");
        }
    }

    void useB() {
        B b = new B(); //B 객체 생성 및 인스턴스 필드,메소드 사용
        System.out.println(b.field1);
        b.method1();
        //B 클래스의 정적 필드,메소드 사용
        System.out.println(B.field2);
        B.method2();
    }
}
