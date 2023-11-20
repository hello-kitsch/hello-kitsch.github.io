package ch02.sec01;
//초기화되지 않은 변수가 컴파일 에러를 일으키는 예제
public class VariableInitializationExample {
    public static void main(String[] args) {
        int value;
        int result = value + 10;
        System.out.println(result);
    }
}
