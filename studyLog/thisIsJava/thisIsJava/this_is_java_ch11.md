# 1. 예외와 예외 클래스
- 에러: 컴퓨터 하드웨어의 고장으로 응용프로그램 실행 오류가 발생하는 것.
- 예외: 잘못된 사용 또는 코딩으로 인한 오류, 곧바로 종료되지만 예외처리를 통해 실행 상태를 유지 가능
  - 일반 예외(Exception): 컴파일러가 예외 처리 코드 여부를 검사하는 예외
  - 실행 예외(Runtime Exception): 컴파일러가 예외 처리 코드 여부를 검사하지 않는 예외
- 자바 예외 발생 -> 예외 클래스로부터 객체를 생성하여 예외 처리시 사용
  - 자바의 모든 에러와 예외 클래스 -> `Throwable`을 상속받음
  - 예외 클래스는 추가적으로 `java.lang.Exception`클래스를 상속받음
- 실행 예외: `RuntimeException`클래스와 그 자식 클래스
- 일반 예외: 그 밖의 모든 예외 클래스
- 자주 사용하는 예외 클래스 -> 표준 라이브러리로 제공
  - `ClassNotFoundException`, `InterruptedException`, `RuntimeException`, `NullPointerException`, `ArrayIndexOutOfBOundsException`, `NumberFormatException`
# 2. 예외 처리 코드
- 예외 처리 코드: 예외가 발생 시, 프로그램의 갑작스러운 종료를 막고 정상 실행을 유지할 수 있도록 처리하는 코드
  - try-catch-finally 블록으로 구성됨.
```java
try {
    예외 발생 가능 코드, 예외 발생시 바로 catch 블록으로 점프
} catch(예외클래스 e) {
    예외처리, 예외가 발생되지 않으면 실행되지 않음
} finally {
    항상 실행;
}
```
- try 블록과 catch 블록세어 return 문(메소드 종료)을 사용하더라도 finally 블록은 항상 실행됨.
- finally 블록은 옵션으로 생략 가능
- 발생된 예외의 정보를 출력하는 방법
  1. `e.getMessage()`: 예외가 발생한 이유만 리턴
  2. `e.toString()`: 예외가 발생한 이유와 예외의 종류를 리턴
  3. `e.printStackTrace()`: 예외가 발생한 이유, 예외의 종류, 예외가 어디서 발생했는지 추적한 내용을 출력
# 3. 예외 종류에 따른 처리
- try 블록에서 발생하는 다양한 종류의 예외 -> 다중 catch를 사용시 발생하는 예외에 따라 예외 처리 코드를 다르게 작성 가능
  - catch 블록의 예외 클래스 = try 블록에서 발생된 예외의 종류, 해당 타입의 예외 발생시 catch블록이 선택되어 실행됨.
  - 여러 개의 catch블록이 있어도 단 하나만 실행됨. try 블록에서 동시다발적으로 예외가 발생하지 않음. 
- 처리해야 할 예외 클래스들이 상속 관계에 있는 경우 하위 클래스 catch블록을 먼저 작성해야함.(하위 클래스도 상위 클래스 타입이므로)
- 두 개 이상의 예외를 하나의 catch 블록으로 동일한 예외처리 -> "|"를 이용
# 4. 리소스 자동 닫기
- 리소스: 데이터를 제공하는 객체
  - 사용하기 위해 open, 사용이 끝난 후 close
  - 리소스를 사용 중 예외가 발생될 경우 안전하게 닫아야 리소스를 보호 가능
- 예외 발생 여부와 상관 없이 finally 블록에서 안전하게 close하는 예제
```java
FileInputStream fis = null;
try {
    fis = new FileInputStream("file.txt");
    ...
} catch(IOException e) {
    ...
} finally {
    fis.close();
}
```
- try-with-resource 블록(try 괄호에 리소스를 여는 코드를 작성)을 사용 시 예외 발생 여부와 상관없이 리소스를 자동으로 close.
  - 조건: 리소스는 java.lang.AutoCloseable 인터페이스를 구현하여 close() 메소드를 재정의 해야함
  - 복수개의 리소스를 사용 시, try() 괄호 안에 세미콜론으로 구분하여 작성
```java
//try-with-resource 블록을 사용하기 위한 조건
public class FileInputStream implements AutoCloseable {
    ...
    @Override
    public void close() throw Exception { ... }
}

//try-with-resource 블록의 사용 예시
try(FileInputStream fis = new FileInputStream("file.txt")) {
    ...
} catch(IOException e) {
    ...
}

//try-with-resource 블록에서 복수 개의 리소스를 사용하는 예시
try(
    FileInputStream fis1 = new FileInputStream("file1.txt");
    FileInputStream fis2 = new FileInputStream("file2.txt")
) {
    ...
} catch(IOException e) {
    ...
}
```
- Java 9부터는 외부 리소스 변수를 사용 가능
```java
FileInputStream fis1 = new FileInputStream("file1.txt");
FileInputStream fis2 = new FileInputStream("file2.txt");
try(fis1; fis2) {
    ...
} catch(IOException e) {
    ...
}
```
# 5. 예외 떠넘기기
- 메소드 내부에서 예외 발생 시,
  - try-catch 블록으로 예외를 처리
  - 메소드를 호출한 곳으로 예외를 떠넘길 수 있음 -> `throws`키워드
    - `리턴타입 메소드명(매개변수, ...) throws 예외클래스1, 예외클래스2, ... { ... }`
    - 메소드를 호출하는 곳에서 예외를 받아 처리해야함.
    - 나열해야할 예외 클래스가 많은 경우: `throws Exception`, `throws Throwable`만으로 모든 예외를 떠넘길 수 있음
    - main() 메소드에서 throws 키워드를 사용해 예외를 떠넘기는 경우: JVM이 최종적으로 예외처리(예외의 내용을 콘솔에 출력)
```java
public void method1() {
    try {
        method2();
    } catch(ClassNotFoundException e) {
        System.out.println("예외 처리: " + e.getMessage());
    }
}

public void method2() throws ClassNotFoundException {
    Class.forName("java.lang.String2");
}
```
# 6. 사용자 정의 예외
- 예) 은행 뱅킹 프로그램에서 표준 라이브러리에는 존재하지 않는 잔고 부족 예외를 발생시킬 필요가 있음 -> 직접 예외 클래스를 정의해서 사용(사용자 정의 예외)
## 사용자 정의 예외
- 일반 예외(컴파일러가 체크): Exception의 자식 클래스로 선언
- 실행 예외(컴파일러가 체크하지 않음): RuntimeException의 자식 클래스로 선언
```java
public class XXXException extends [ Exception | RuntimeException ] {
    //기본 생성자
    public XXXException() {
    }
    //예외 메시지를 입력받는 생성자
    public XXXException(String message) { 
        super(message); //예외 메시지는 부모 생성자 매개값으로 넘겨 예외 객체의 공통 메소드인 getMessage()의 리턴값으로 사용.
    }
}
```
## 예외 발생 시키기
- 자바~제공 표준 예외/사용자 정의 예외를 직접 코드에서 발생 <- `throw` 키워드와 함께 예외 객체를 제공(`new Exception()`)
  - 예외 원인 메시지를 제공하려면 생성자 매개값으로 전달(`throw new Exception("예외메시지")`)
  - throw된 예외를 직접 `try-catch`블록으로 처리 OR 메소드를 호출한 곳에서 예외를 처리하도록 `throws`키워드로 떠넘김(대부분)