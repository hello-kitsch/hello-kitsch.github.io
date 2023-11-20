package ch05.sec11;

public class MainStringArrayArgument {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("프로그램 입력값이 부족");
            System.exit(0);
        }
        String strNum1 = args[0];
        String strNum2 = args[1];

        int num1 = Integer.parseInt(strNum1);
        int num2 = Integer.parseInt(strNum2);

        int result = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + result);
    }
}

/*
 * javac -d [바이트코드가 저장될 위치] [현 디렉토리로부터 실행파일의 위치/실행파일명.java]
 * java -cp [바이트코드가 저장된 위치] [패키지명.클래스명] [argument-있으면]
 */