# 1. 멀티 스레드 개념
- 운영체제는 실행중인 프로그램을 프로세스로 관리
- 멀티태스킹: 두 가지 이상의 작업을 동시에 처리
  - 멀티 프로세스: 프로그램 단위의 멀티 태스킹
  - 멀티 스레드: 하나의 프로세스가 두 가지 이상의 작업을 처리(스레드=코드의 실행 흐름), 프로그램 내부에서의 멀티 태스킹, 한 스레드의 예외는 프로세스 전체에 영향 -> 예외 처리 주의
    - 데이터 분할 및 병렬 처리
    - 안드로이드 앱에서 네트워크 통신
    - 다수의 클라이언트 요청을 처리하는 서버 개발
# 2. 메인 스레드
- 자바 프로그램은 메인 스레드가 main() 메소드를 실행하며 시작됨.
  - main() 메소드의 첫 코드부터 순차적으로 실행, 마지막 코드를 실행 OR return문을 만나면 실행 종료
  - 메인스레드가 여러 개의 작업 스레드를 만들어 낼 수 있음
    - 싱글 스레드: 메인 스레드가 종료되면 프로세스도 종료
    - 멀티 스레드: 실행 중인 스레드가 하나라도 있다면 프로세스 종료X
# 3. 작업 스레드 생성과 실행
- 몇 개의 작업을 병렬로 실행할지 결정 -> 각 작업별로 스레드 생성
- 자바는 작업 스레드도 객체로 관리 -> 클래스가 필요
  - Thread 클래스로 직접 객체 생성
  - 하위 클래스를 만들어 생성
## Thread 클래스로 직접 생성
- java.lang.Thread 클래스의 Runnable 구현 객체를 매개값으로 갖는 생성자 호출  
`Thread thread = new Thread(Runnable target);`
- Runnable: 스레드가 작업 실행 시 사용하는 인터페이스, run() 메소드가 정의되어 있음 -> 구현 클래스는 재정의하여 스레드에 전달해 사용
```java
class Task implements Runnable {
    @Override
    public void run() {
        //스레드가 실행할 코드
    }
}

//명시적인 Runnable 구현 클래스를 작성하지 않고 Thread 생성자를 호출할 때 Runnable 익명 구현 객체를 매개값으로 사용하는 방법
Thread thread = new Thread( new Runnable() {
    @Override
    public void run() {
        //스레드가 실행할 코드
    }
});
```
- 작업 스레드 생성 후 start()메소드를 호출해야 실행됨.
## Thread 자식 클래스로 생성
- Thread 클래스를 상속한 후 run() 메소드를 재정의하여 스레드가 실행할 코드를 작성, 객체 생성
```java
public class WorkerThread extends Thread {
    @Override
    public void run() {
        //스레드가 실행할 코드
    }
}
Thread thread = new WorkerThread();
thread.start();
```
# 4. 스레드 이름
# 5. 스레드 상태
# 6. 스레드 동기화
# 7. 스레드 안전 종료
# 8. 데몬 스레드
# 9. 스레드풀