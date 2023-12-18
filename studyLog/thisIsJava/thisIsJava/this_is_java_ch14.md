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

//Thread 익명 자식 객체를 사용하는 경우
Thread thread = new Thread() {
    @Override
    public void run() {
        //스레드가 실행할 코드
    }
};
thread.start();
```
# 4. 스레드 이름
- 스레드는 자신의 이름을 가지고 있음. 
  - 메인 스레드: `main`
  - 작업 스레드는 자동적으로 `Thread-n`, 다른 이름으로 설정하고 싶다면 setName() 메소드를 사용
  `thread.setName("스레드 이름");`
- 스레드 이름은 디버깅 시 어떤 스레드가 작업을 하는지 조사할 때 사용됨 -> 정적 메소드인 currentThread()로 스레드 객체의 참조를 얻은 후 getName() 메소드로 이름 출력
```java
Thread thread = Thread.currentThread();
System.out.println(thread.getName());
```
# 5. 스레드 상태
- 스레드 객체를 생성(`new`), `start()`메소드 호출 시, 실행대기상태`RUNNABLE`가 됨.
- RUNNABLE 상태에서 CPU 스케줄링에 따라 CPU 점유 및 `run()`메소드 실행 -> `RUNNING`
  - `run()`메소드를 모두 실행하기 전에 스케줄링에 의해 다시 RUNNABLE 상태로 돌아갈 수 있음.
  - 실행 상태에서 일시정지 상태(스레드가 실행할 수 없는 상태)로 가기도 함.
- RUNNABLE 상태와 RUNNING 상태를 번갈아가며 `run()`메소드를 실행하고 종료되면 스레드의 실행은 멈춤 -> `TERMINATED`
- 일시정지상태 -> 실행대기상태 -> 실행상태
  - 실행 -> 일시정지
    - `sleep(long millis)`: 주어진 시간 동안 스레드를 일시 정지 상태로 만듦. 주어진 시간이 지나면 자동적으로 실행 대기 상태가 됨. **Thread 클래스의 메소드**
    - `join()`: join() 메소드를 호출한 스레드는 일시 정지 상태가 됨. 실행 대기 상태가 되려면 join() 메소드를 가진 스레드가 종료되어야함. **Thread 클래스의 메소드**
    - `wait()`: 동기화 블록 내에서 스레드를 일시 정지 상태로 만듦. **Object 클래스의 메소드**
  - 일시정지 -> 실행대기/종료
    - `interrupt()`: 일시정지 상태일 경우, InterruptedException을 발생시켜 실행대기/종료 상태로 만듦. **Thread 클래스의 메소드**
    - `notify()`, `notifyAll()`: wait()메소드로 인해 일시정지 상태인 스레드를 실행대기 상태로 만듦. **Object 클래스의 메소드** 
  - 실행 -> 실행대기
    - `yield()`: 실행 상태에서 다른 스레드에게 실행을 양보하고 실행 대기 상태가 됨. **Thread 클래스의 메소드**
## 주어진 시간 동안 일시 정지
- `sleep(long millis)`: 실행 중인 스레드를 일정 시간 멈추게 하고 싶을 때 사용, 매개값에는 얼마동안 일시 정지 상태로 있을 것인지.
  - 일시 정지 상태에서는 InterruptedException이 발생할 수 있기 때문에 sleep()은 예외 처리가 필요한 메소드.
```java
try {
    Thread.sleep(1000);
} catch(InterruptedException e) {
    //interrupt() 메소드가 호출되면 실행
}
```
## 다른 스레드의 종료를 기다림
- `join()`: 스레드는 다른 스레드와 독립적으로 실행; 다른 스레드가 종료될 때까지 기다렸다가 실행을 해야하는 경우 사용.
```java
//threadA 안
threadB.start(); //threadB.run() { ... }
threadB.join(); //threadA 일시정지, threadB의 run() 메소드가 종료되어야 일시정지에서 풀림
```
## 다른 스레드에게 실행 양보
- 스레드가 처리하는 작업은 반복 실행(for문, while문)을 포함하는 경우가 많음, 무의미한 반복을 하는 경우 실행 양보 후 실행 대기 상태로 가야 성능에 도움이 됨. -> `yield()`메소드 사용
```java
//무의미한 반복
public void run() {
    while(true) {
        if(work) {
            System.out.println("ThreadA 작업 내용");
        }
    }
}

//무의미한 반복X, 실행 양보
public void run() {
    while(true) {
        if(work) {
            System.out.println("ThreadA 작업 내용");
        } else {
            Thread.yield();
        }
    }
}
```
# 6. 스레드 동기화
- 멀티 스레드는 하나의 객체를 공유해서 작업 가능 -> 다른 스레드에 의해 객체 내부 데이터가 쉽게 변경 가능 -> 의도한 것과 다른 결과 발생 가능
- 자바의 동기화 synchronized 메소드/블록: 스레드가 사용 중인 객체를 다른 스레드가 변경할 수 없도록 하기 위해 스레드 작업이 끝날 때까지 잠금을 거는 것.
  - 객체 내부에 동기화 메소드/블록이 여러 개 있다면 이들 하나가 스레드에서 실행 중일 때 다른 스레드는 그러한 동기화 메소드/블록을 실행 불가(일반 메소드는 실행 가능)
## 동기화 메소드 및 블록 선언
- 동기화 메소드를 선언하는 법: `synchronized`키워드 붙이기 (인스턴스, 정적 메소드 어디든 가능)
`public synchronized void method() { //단 하나의 스레드만 실행하는 영역 }`
- 메소드 전체가 아닌 일부 영역을 실행할 때만 객체 잠금 -> 동기화 블록을 선언
```java
public void method() {
    //여러 스레드가 실행할 수 있는 영역
    synchronized(공유객체) {
        //단 하나의 스레드만 실행하는 영역
    }
    //여러 스레드가 실행할 수 있는 영역
}
```
## wait()와 notify()를 이용한 스레드 제어
- 스레드의 정확한 교대작업이 필요한 경우 -> 자신의 작업이 끝나면 상대방 스레드를 일시 정지 상태에서 풀어주고 자신은 일시 정지 상태로 만들면 됨.
  - 공유 객체를 이용하여 두 스레드가 작업할 내용을 각각 동기화 메소드로 정해놓음  
  -> 한 스레드가 작업을 완료 시 `notify()` 메소드를 호출하여 일시 정지 상태에 있는 다른 스레드를 실행 대기 상태로 만듦.  
  -> 자신은 `wait()` 메소드를 호출해 일시정지 상태로 만듦.
- 동기화 메소드/동기화 블록 내에서만 사용가능한 메소드
  - `notify()`: `wait()`에 의해 일시 정지된 스레드 중 한 개를 실행 대기 상태로 만듦
  - `notifyAll()`: `wait()`에 의해 일시 정지된 모든 스레드를 실행 대기 상태로 만듦.

# 7. 스레드 안전 종료
# 8. 데몬 스레드
# 9. 스레드풀