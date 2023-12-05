# 1. 라이브러리
- 라이브러리: 프로그램 개발 시 활용할 수 있는 클래스와 인터페이스들을 모아놓은 것을 말함.
  - JAR(Java ARchive) 압축 파일 형태: 클래스와 인터페이스의 바이트코드 파일(.class)들이 압축되어 있음
- 프로그램 개발 시 라이브러리를 이용하려면 라이브러리 JAR 파일을 ClassPath에 추가해야함.
  - 콘솔에서 프로그램을 실행 시: java 명령어를 실행할 때 -classpath로 제공/CLASSPATH 환경 변수에 경로를 추가
  - 이클립스 프로젝트에서 실행 시: 프로젝트의 Build Path에 추가
## my_lib 라이브러리 프로젝트 생성
-my_lib
  -JRE System Library
  -src
    -pack1
      -A.java
    -pack2
      -B.java
  -dist
- JAR file로 my_lib의 src를 export해서 dist 폴더에 저장
## my_application_1 프로젝트 생성
- Build Path에서 my_lib.jar 파일을 선택
-my_application_1
  -src
    -app
      -Main.java
  -JRE System Library
  -Referenced Libraries
## 콘솔에서 -classpath 옵션 사용
- 윈도우
  - 명령 프롬프트에서 bin 디렉토리로 이동하고 Main 클래스를 실행
    - `C:\...>cd C:\ThisIsJavaSecondEdition\workspace\my_application_1\bin`
    - `C:\...\bin>java app.Main` -> Exception in thread "main" java.lang.NoClassDefFoundError: pack1/A
    - `C:\...\bin>java -classpath C:\ThisIsJavaSecondEdition\workspace\my_lib\dist\my_lib.jar;. app.Main`
      - -classpath 대신 -cp를 사용
      - classpath 구분자: 세미콜론(;)
      - 경로 뒤에 세미콜론(;)과 함께 마침표(.)를 추가
- 맥OS
  - 터미널에서 실행, classpath 구분자는 콜론(:)이므로 마침표(.)를 경로 뒤에 추가
    - `cd ~/ThisIsJavaSecondEdition/workspace/my_application_1/bin`
    - `java -classpath ~/ThisIsJavaSecondEdition/workspace/my_lib/dist/my_lib.jar:. app.Main`
## 환경 변수 CLASSPATH 사용
- -classpath 옵션은 java 명령어를 실행할 때마다 별도로 추가해야하는 불편함이 존재 -> 여러 프로그램에서 공통으로 사용하는 라이브러리는 환경 변수 CLASSPATH에 경로를 추가
- 윈도우: 환경 변수의 시스템 변수에 `CLASSPATH`를 이름으로 하는 `.;C:\ThisIsJavaSecondEdition\workspace\my_lib\dist\my_lib.jar`을 입력
- 그 후 다음 명령 프롬프트에서 다음 명령을 실행
`C:\...>cd C:\ThisIsJavaSecondEdition\workspace\my_application_1\bin`  
`C:\...\bin>java app.Main`
- 맥OS: 사용자 홈 디렉토리에서 `ls -all`명령어를 실행 후 `.bash_profile`을 찾아보고 없다면 생성  
`$ touch .bash_profile`  
파일을 열고 `export CLASSPATH=.:~/ThisIsJavaSecondEdition/workspace/my_lib/dist/my_lib.jar`을 작성 후 저장  
터미널을 열고 `$ source ~/.bash_profile`을 실행  
다음과 같이 실행  
`cd ~/ThisIsJavaSecondEdition/workspace/my_application_1/bin`  
`java app.Main`
# 2. 모듈
- 모듈: 패키지 관리 기능까지 포함된 라이브러리
  - 일반 라이브러리는 내부에 포함된 모든 패키지에 외부 프로그램에서의 접근이 가능
  - 모듈은 일부 패키지를 은닉하여 접근을 불가하게 할 수 있음
  - 모듈 기술자(module-info.java)에 자신이 실행할 때 필요로 하는 의존 모듈을 기술 가능 -> 모듈 간의 의존 관계를 쉽게 파악 가능
- 모듈도 라이브러리이므로 JAR 파일 형태로 배포 가능
- 대규모 응용프로그램은 기능별로 모듈화해서 개발 후 조립 가능 -> 재사용성, 유지보수에 유리
# 3. 응용프로그램 모듈화
- 응용프로그램은 하나의 프로젝트로도 개발 가능; 기능별로 서브 프로젝트(모듈)로 쪼갠 후 조합하여 개발 가능
- 협업/유지보수/재사용 측면에서 서브 모듈로 쪼개서 개발하는 것이 유리
## my_module_a 모듈 생성
- module-info.java 파일 생성
-my_module_a
  -JRE System Library
  -src
    -pack1
      -A.java
    -pack2
      -B.java
    module-info.java
```java
//A.java
package pack1;

public class A {
    public void method() {
        System.out.println("A-method 실행");
    }
}

//B.java
package pack2;

public class B {
    public void method() {
        System.out.println("B-method 실행");
    }
}

//module-info.java
module my_module_a {
    exports pack1;
    exports pack2;
}
```
## my_module_b 모듈 생성
- module-info.java 파일 생성
-my_module_b
  -JRE System Library
  -src
    -pack3
      -C.java
    -pack4
      -D.java
    module-info.java
```java
//C.java
package pack3;

public class C {
    public void method() {
        System.out.println("C-method 실행");
    }
}

//D.java
package pack4;

public class D {
    public void method() {
        System.out.println("D-method 실행");
    }
}

//module-info.java
module my_module_b {
    exports pack3;
    exports pack4;
}
```
## my_application_2 프로젝트 생성
- module-info.java 파일 생성
> 응용프로그램도 하나의 모듈: 모듈로 개발하는 것이 아닌 다른 모듈을 조합하는 응용프로그램을 위한 프로젝트여도 어떤 모듈을 가져와 사용할 것인지를 기술해야하기 때문에 모듈 기술자가 필요(하면 모듈).
```java
//module-info.java
module my_application_2 {
    requires my_module_a;
    requires my_module_b;
}

//Main.java
package app;

import pack1.A;
import pack2.B;
import pack3.C;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.method();

        B b = new B();
        b.method();

        C c = new C();
        c.method();
    }
}
```
- Build Path에서 Modulepath 항목을 선택하여 경로 지정
# 4. 모듈 배포용 JAR 파일
- 모듈 개발 완료 -> 다른 모듈에서 쉽게 사용할 수 있도록 바이트코드 파일(.class)로 구성된 배포용 JAR파일을 생성
## 모듈 배포용 JAR 파일 생성
-my_module_a
  -JRE System Library
  -src
  -dist
-my_module_b
  -JRE System Library
  -src
  -dist
- JAR 파일로 export하여 dist에 저장
## my_application_3 프로젝트 생성
- module-info.java 파일 생성
# 5. 패키지 은닉
# 6. 전이 의존
# 7. 집합 모듈
# 8. 리플렉션 허용
# 9. 자바 표준 모듈