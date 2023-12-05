# 1. 라이브러리
- 라이브러리: 프로그램 개발 시 활용할 수 있는 클래스와 인터페이스들을 모아놓은 것을 말함.
  - JAR(Java ARchive) 압축 파일 형태: 클래스와 인터페이스의 바이트코드 파일(.class)들이 압축되어 있음
- 프로그램 개발 시 라이브러리를 이용하려면 라이브러리 JAR 파일을 ClassPath에 추가해야함.
  - 콘솔에서 프로그램을 실행 시: java 명령어를 실행할 때 -classpath로 제공, CLASSPATH 환경 변수에 경로를 추가
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
- 윈도우: 
- 맥OS: 

# 2. 모듈
# 3. 응용프로그램 모듈화
# 4. 모듈 배포용 JAR 파일
# 5. 패키지 은닉
# 6. 전이 의존
# 7. 집합 모듈
# 8. 리플렉션 허용
# 9. 자바 표준 모듈