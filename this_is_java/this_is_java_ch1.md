# 1. 자바 시작하기

## 1. 프로그래밍 언어와 자바
- 프로그래밍 언어는 자연어와 기계어의 다리 역할
- 고급언어: 사람이 쉽게 이해할 수 있는 언어, 컴파일을 통해 기계어로 변환
- 저급언어: 기계어에 가까운 언어
- 소스파일: 개발자가 고급언어로 작성한 파일
- 자바는 1995년도에 썬 마이크로시스템즈에서 발표된 언어
- 자바의 특징
  - 모든 운영체제에서 실행 가능
  - 객체 지향 프로그래밍
  - 메모리 자동 정리
  - 무료 라이브러리 풍부

## 2. 운영체제별 JDK 설치
- Java Standard Edition의 구현체인 JDK(Java Development Kit)를 설치
  - Open JDK, Oracle JDK

## 3. 윈도우 환경 변수 설정
- JDK설치 후 (윈도우는) 환경변수 설정하기(시스템 변수-JAVA_HOME, path)`%JAVA_HOME%\bin`
- 환경변수 설정 확인 `$javac -version`, `$java -version`

## 4. 맥OS 환경 변수 설정
- `$ ls -all`로 .bash_profile을 찾기
- 없으면 `$ touch .bash_profile`으로 생성
- .bash_profile 파일을 텍스트 편집기로 열어 다음을 추가`export JAVA_HOME=/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home`
`export PATH=${PATH}:$JAVA_HOME/bin`
- .bash_profile 파일 내용을 적용하는 명령어`$ source ~/.bash_profile`
- 환경변수 설정 확인`$ javac -version`, `$ java -version`

## 5. 바이트코드 파일과 자바 가상 머신
- 자바 소스 파일의 확장명: .java
### 바이트코드 파일
- 소스 파일을 작성 후에 컴파일->.class인 바이트코드 파일로 생성
- 운영체제에 상관없이 javac로 컴파일하면 모두 동일한 바이트코드 파일이 생성됨
### 자바 가상 머신
- java 명령어: JVM을 구동시켜 바이트코드 파일을 특정 운영체제가 이해하는 기계어로 번역, 실행함
- 운영체제별로 이해하는 기계어가 다름->자바 가상 머신이 운영체제별로 달라야하는 이유

## 6. 소스 작성부터 실행까지
- ~\temp\src\ch01\sec06\Hello.java
```java
package ch01.sec06;

public class Hello {
	public static void main(String[] args) {
    	System.out.println("Hello, Java");
    }
}
```
- 바이트코드로 컴파일: `javac -d [바이트코드파일저장위치] [소스경로/소스코드파일이름]`
- 기계어로 컴파일: `java -cp [바이트코드파일위치] [패키지...클래스명]`

## 7. 이클립스 설치
- Integrated Development Environment(IDE) 중 이클립스를 설치

## 8. 이클립스 프로젝트 생성
- JRE의 세 가지 선택 옵션
  - Use a execution environment JRE: 빌드 번호와 상관없이 JavaSE버전에 중점을 둘 때 선택
  - Use a project specific JRE: 선택된 JDK 기준으로 소스파일을 컴파일, 실행(빌드 번호별로 선택이 다를때 유용)
  - Use default JRE 'xxx' and workspace compiler preferences: 이클립스의 기본 자바 버전을 사용해서 컴파일,실행
- 용어 차이: Java(개발 도구), JRE(실행 환경), JavaSE(스펙 내용)
- 이클립스의 기본 텍스트 파일 인코딩 설정 체크(UTF-8)

## 9. 이클립스 소스 작성부터 실행까지
- 작업할 디렉토리에서 패키지를 생성(패키지: 소스파일과 바이트코드 파일을 관리하기 위한 디렉토리 개념)
  - 패키지 구분 기호: 도트(.)
- 소스 파일 저장 여부를 표시하는 별표(*)
- 자동 컴파일된 바이트코드는 프로젝트 디렉토리 안 bin 디렉토리에 패키지 디렉토리와 함께 저장됨.

## 10. 코드 용어 이해
- 패키지 선언 `package ch01.sec09`: 소스 파일이 명시된 패키지에 있다는 뜻
- 클래스 선언 `public class Hello`: 클래스명은 숫자로 시작할 수 없고 공백 포함 불가. 소스 파일명과 대소문자가 완전히 일치해야함.
- 클래스 블록: 다음에 나오는 중괄호, 클래스의 정의내용이 작성됨
- main 메소드 `public static void main (String[] args) {...}`: 메소드명+메소드 블록
  - main() 메소드는 프로그램 실행 진입점
- Console 출력 코드 `System.out.pringln("Hello, Java");`

## 11. 코드 주석 달기
- 프로그램 실행과는 상관없이(컴파일 과정에서 무시됨) 코드에 설명을 붙인 것
  - 행 주석(//)
  - 범위 주석(/* ... */)
  - 도큐먼트주석(/** ... */): javadoc 명령어로 API 도큐먼트를 생성하는데 사용
- 주석 기호는 문자열 내부를 제외한 코드 내 어디서든 작성 가능

## 12. 실행문과 세미콜론
- 실행문: 변수 선언, 변수값 저장, 메소드 호출에 해당하는 코드
- 실행문 끝에는 반드시 세미콜론(;)을 붙여야 컴파일 에러가 안남.