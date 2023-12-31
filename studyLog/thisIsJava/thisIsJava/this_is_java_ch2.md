# 2. 변수와 타입
## 1. 변수 선언
- 컴퓨터 메모리(데이터 저장 공간), 프로그램은 데이터를 메모리에 저장, 읽는 작업 수행
- 메모리 관리: 데이터를 어디에, 어떤 방식으로 저장할지 정한 규칙
  - 변수: 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름
    - 타입: 정수형 변수, 실수형 변수 등
    - 변수 선언: 어떤 타입의 데이터를 저장할 것인지, 변수 이름이 무엇인지를 결정
    - 변수 이름 규칙: 첫 번째 글자가 문자, 중간부터 문자,숫자,$,\_를 포함 가능
    > camel style(대소문자를 섞어쓰는 스타일): 자바 소스 파일명(클래스명)은 대문자로 시작하는 관례, 변수명은 소문자로 시작하는 관례가 있음
  - 변수 선언 후 값을 저장 -> 대입 연산자(=)를 사용
  > 변수 이름의 길이는 상관없음, 변수 이름은 어떤 값을 저장하고 있는지 쉽게 알 수 있도록 의미있는 이름을 짓기, 변수 이름에 한글 포함x이 관례
  - 변수 선언: 저장되는 값의 타입과 이름만 결정, 메모리에 할당x
  - 변수 초기화: 변수에 최초로 값을 대입하는 행위(초기값), 초기화되지 않은 변수는 아직 메모리에 할당되지 않았기 때문에 메모리 값을 읽을 수 없음, 컴파일에러
  - 변수는 출력문, 연산식에 사용되어 변수값을 활용함.
  - 변수는 또 다른 변수에 대입되어 메모리 간 값의 복사를 허용
## 2. 정수 타입
- 변수는 선언될 때 타입에 따라 저장할 수 있는 값의 종류와 허용 범위가 달라짐
  - 정수: byte(1byte=8bit), short(2byte=16bit), char(2byte=16bit,유니코드), int(4byte=32bit), long(8byte=64bit)
    - 부호비트(1비트) -> 따라서 허용범위가 $-2^{n-1}~-1, 0~(2^{n-1}-1)$
    - 최상위 비트(부호 비트)가 1인 경우=음수: 1의 보수로 바꾸고 1을 더한 값에 부호를 바꿈.
    - 리터럴(literal): 2진수(0b/OB으로 시작), 8진수(0으로 시작), 10진수(소수점x), 16진수(0x/0X으로 시작)
    - long 타입은 수치가 큰 데이터를 다룰때 사용, 기본적으로 컴파일러는 정수 리터럴을 int 타입값으로 간주->int 타입의 허용 범위를 초과하는 리터럴은 뒤에 소문자'l', 대문자'L'을 붙여줘야함
  - 실수: float, double
  - 논리: boolean
## 3. 문자 타입
- 문자 리터럴: 하나의 문자를 작은 따옴표로 감싼 것
  - 유니코드(0~65535)로 변환되어 저장 -> 자바는 char 타입을 제공
  - 유니코드가 정수이므로 char 타입도 정수 타입에 속함, 유니코드 숫자를 직접 대입 가능
  - char 타입의 변수에 빈 문자는 허용되지 않음. 초기화를 할 목적이라면 공백(유니코드:32)을 사용
## 4. 실수 타입
- float(4byte=32bit): $1.4\times 10^{-45}$ ~ $3.4\times 10^{38}$, 유효 소수 이하 자리=7
- double(8byte=64bit): $4.9\times 10^{-324}$ ~ $1.8\times 10^{308}$, 유효 소수 이하 자리=15
- 자바는 IEEE 754 표준에 근거해 부동 소수점 방식으로 메모리에 저장(부호, 가수, 지수)
  - float: 부호(1bit)+지수(8bit)+가수(23bit)=32bit=4byte
  - double: 부호(1bit)+지수(11bit)+가수(52bit)=64bit=8byte
  - e 또는 E가 포함된 리터럴 표기법: (가수)e(지수)
  - 컴파일러는 실수 리터럴을 기본적으로 double 타입으로 해석->float 타입에 대입하기 위해서는 리터럴 뒤에 f나 F를 붙여야함
## 5. 논리 타입
- 논리 리터럴: true(참), false(거짓)
- 논리 리터럴은 boolean 타입 변수에 대입 가능
- boolean 타입 변수는 주로 두 가지 상태값을 저장할 필요가 있을 경우에 사용(상태값에 따라 조건문/제어문의 실행 흐름을 변경하는데 사용됨)
## 6. 문자열 타입
- 작은 따옴표로 감싼 한 개의 문자 = char 타입(유니코드)
- 큰 따옴표로 감싼 여러 개의 문자는 유니코드로 변환되지 않는 **문자열** -> String 타입(기본타입이 아닌 참조타입)에 저장
- 이스케이프 문자(\가 붙은 문자)
  - \": "문자 포함
  - \': '문자 포함
  - \\\\: \문자 포함
  - \u(16진수): 16진수 유니코드에 해당하는 문자 포함
  - \t: 출력 시 탭만큼 띄움
  - \n: 출력 시 줄바꿈(라인피드)
  - \r: 출력 시 캐리지 리턴(enter)
- 텍스트 블록 문법(Java13부터 지원): 큰따옴표 3개로 감싸기->이스케이프하거나 라인피드를 할 필요 없이 작성된 그대로 문자열로 저장됨
  - 텍스트 블록에서 줄바꿈(\n)을 하고 싶지 않다면 맨 끝에 \를 붙이면 됨
## 7. 자동 타입 변환
- 값의 허용 범위가 작은 타입이 허용 범위가 큰 타입으로 대입될 때 발생 `큰 허용 범위 타입 = 작은 허용 범위 타입`
- 기본 타입의 허용범위 순 나열: byte < short, char < int < long < float < double
- 허용 범위가 작은 타입이 큰 타입에 대입되면 자동 타입 변환이 이루어짐
  - 예외: byte 타입은 (그보다 큰) char 타입으로 자동 변환될 수 없음. char 타입의 허용 범위는 음수를 포함하지 않기 때문
## 8. 강제 타입 변환
- 강제 타입 변환: 큰 허용 범위 타입을 작은 허용 범위 타입으로 쪼개어 저장
  - 캐스팅 연산자로 괄호()를 사용
  - 괄호 안에 들어가는 타입은 쪼개는 단위
  - 목적: 원래 값이 유지되면서 타입만 바꾸는 것, 따라서 작은 허용 범위 타입에 저장될 수 있는 값을 가지고 강제 타입 변환을 해야함.
- int->byte: 4byte->1byte (2byte 이상이 필요한 int값은 원래 값이 보존되지 않음)
- long->int: 8byte->4byte
- int->char: char의 허용범위(0~65535)만 값을 유지
- 실수->정수: 소수점 이하 부분은 버려지고 정수 부분만 저장됨
## 9. 연산식에서 자동 타입 변환
- 자바는 실행 성능을 향상시키기 위해 컴파일 단계에서 연산을 수행
  - 피연산자가 정수 리터럴인 경우, 컴파일 과정에서 연산 수행 후의 결과를 변수에 저장 -> 실행 시 연산이 없으므로 성능이 좋아짐 `byte result = 10 + 20 //컴파일: byte result = 30`
  - 피연산자가 변수인 경우, byte, short 타입 변수는 int 타입으로 자동 타입 변환 되어 연산이 수행됨.
  ```java
  //byte 타입 변수가 피연산자로 사용된 경우
  byte x = 10;
  byte y = 20;
  //byte result = x + y //컴파일 에러
  int result = x + y; //피연산자인 변수값은 int 타입으로 변환되어 연산됨.
  
  //int 타입 변수가 피연산자로 사용된 경우
  int x = 10;
  int y = 20;
  int result = x + y;
  ```
  - 특별한 이유가 없다면 정수 연산에서 변수가 사용될 경우에는 int 타입으로 변수를 선언하는 것이 실행 성능에 도움이 됨.
  - int 타입보다 허용범위가 더 큰 long타입이나 float/double 타입의 경우 더 큰쪽에 맞추어 자동 타입 변환이 이루어짐.
  - 자바에서 정수 연산의 결과는 항상 정수가 됨
  ```java
  int x = 1;
  int y = 2;
  double result1 = x / y; //0.0
  double result2 = x / (double) y; //0.5
  double result3 = (double) x / (double) y; //0.5
  ```
- 자바에서 + 연산자의 두 가지 기능
  1. 피연산자가 모두 숫자: 덧셈 연산
  2. 피연산자 중 하나가 문자열: 나머지 피연산자도 문자열로 자동 변환되어 문자열 결합 연산
  - 연산식에서 + 연산자가 연이어 나올 경우->순차적으로 +연산을 수행
    - 특정 부분을 우선 연산하고 싶다면 괄호()를 이용
## 10. 문자열을 기본 타입으로 변환
- String->byte: Byte.parseByte(str)
- String->short: Short.parseShort(str)
- String->int: Integer.parseInteger(str)
- String->long: Long.parseLong(str)
- String->float: Float.parseFloat(str)
- String->double: Double.parseDouble(str)
- String->boolean: Boolean.parseBoolean(str)
- 기본 타입 값->String: String.valueOf(기본타입값)
## 11. 변수 사용 범위
- main() 메소드 블록 안의 다른 중괄호 {} 블록들에서 선언된 변수는 중괄호 {} 블록 내에서만 사용이 가능
  - 메소드 블록 첫머리에 선언: 메소드 블록 전체에서 사용
  - 특정 블록 내에서 선언: 특정 블록 내부에서만 사용
## 12. 콘솔로 변수값 출력
- `Syste.out.println(리터럴 또는 변수);`
  - `println(내용);`: 괄호 안의 내용을 출력하고 행을 바꿔라.
  - `print(내용)`: 괄호 안의 내용을 출력하고 행은 바꾸지 말아라.
  - `printf("형식 문자열", 값1, 값2, ...)`: 형식 문자열에 맞추어 뒤의 값을 출력해라.
    - `% [argument_index$] [flag] [width] [.precision] conversion`: [] 안의 값은 생략 가능
    - conversion: d(정수), f(실수), s(문자열)
    - argument_index$: 순번, (ex.1$, 2$)
    - flag: 생략(왼쪽이 공백), -(오른쪽이 공백), 0(공백 대신 0으로 채움)
    - width: 소수점을 포함한 전체 자릿수
    - .precision: 소수 이하 자릿수
    - 특수 문자: \t(탭), \n(줄바꿈), %%(%)
## 13. 키보드 입력 데이터를 변수에 저장
- Scanner 타입 변수를 선언, 대입 연산자를 사용하여 new 연산자로 생성한 Scanner 객체를 변수에 대입
  - `Scanner scanner = new Scanner(System.in);`
- scanner.nextLine()을 실행하면 enter키가 입력되기 전까지 블로킹(대기)상태가 되며, enter키가 입력되면 지금까지 입력된 모든 내용을 문자열로 읽음  
  - `String inputData = scanner.nextLine();`
- ==: 기본 타입(byte, short, int, long, float, double, boolean) 값이 동일한지 비교할 때
- equals(): String 타입 값이 동일한지 비교할 때 `boolean result = data.equals("문자열")`