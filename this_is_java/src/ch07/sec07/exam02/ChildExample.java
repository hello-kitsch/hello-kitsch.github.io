package ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = child;

        parent.method1();
        parent.method2(); //오버라이딩된 자식객체의 메소드 호출
        //parent.method3(); //호출 불가능
    }
}
