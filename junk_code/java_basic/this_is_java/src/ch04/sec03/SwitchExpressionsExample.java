package ch04.sec03;

public class SwitchExpressionsExample {
    public static void main(String[] args) {
        char grade = 'B';
        //Switch Expressions으로 다시 작성
        switch(grade) {
            case 'A', 'a' -> { System.out.println("우수 회원입니다."); }
            case 'B', 'b' -> { System.out.println("일반 회원입니다."); }
            default -> { System.out.println("손님입니다."); }
            //중괄호 안에 실행문이 하나만 있을 경우엔 생략 가능
        }
    }
}
