package ch09.sec04.exam03;

public class A {
    public void method1(int arg) { //final int arg
        int var = 1; 
        class B {
            void method2() {
                System.out.println("arg: " + arg);
                System.out.println("var: " + var);

                //arg = 2
                //var = 2 
                //로컬 변수 수정x
            }
        }
        B b = new B();
        b.method2();

        //arg = 3;
        //var = 3;
        //로컬 변수를 수정x
    }
}