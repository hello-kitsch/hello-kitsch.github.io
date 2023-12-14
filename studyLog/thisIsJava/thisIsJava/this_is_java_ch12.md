# 1. API 도큐먼트
- 자바 표준 모듈에서 제공하는 라이브러리(클래스+인터페이스)는 방대 -> Application Programming Interface 도큐먼트(라이브러리 사용 방법 기술)가 존재
- [JDK 버전별 사용가능한 API 도큐먼트](https://docs.oracle.com/en/java/javase/index.html)
- ex) String 도큐먼트
  - java.base(모듈)>java.lang(패키지)>String(클래스)
  - **클래스 선언부 보기**: 어떻게 정의되어 있는지(final, abstract 여부)
  - **구성 멤버 보기**: 상단 메뉴의 SUMMARY를 활용->링크가 있으면 공개된(public, protected)멤버가 존재
    - NESTED: 중첩클래스/중첩 인터페이스 목록으로 이동
    - FIELD: 필드 목록으로 이동 
      - Modifier and Type: static여부와 필드타입
      - Field: 필드명-클릭 시 선언부와 상세한 설명, 모두 대문자인 경우 관례적으로 public static final로 선언된 상수 필드
      - Description: 간단한 설명
    - CONSTR: 생성자 목록으로 이동
      - Constructor: 생성자의 매개변수 타입
      - Description: 이에 대한 간단한 설명(오버로딩된 생성자 등)
    - METHOD: 메소드 목록으로 이동
      - Modifier and Type: static 여부와 리턴 타입의 종류
      - Method: 메소드명과 매개변수 타입 및 개수
      - Description: 그에 대한 간단한 설명
        - All Methods: 모든 메소드 목록
        - Static Methods: 정적 메소드 목록
        - Instance Methods: 인스턴스 메소드 목록
        - Concrete Methods: 완전한 실행부를 갖춘 메소드 목록
        - Deprecated Methods: 향후 제거될 메소드 목록
# 2. java.base 모듈
- 모든 모듈이 의존하는 기본 모듈: java.base(모듈 중 유일하게 requires하지 않아도 사용 가능)
- 모듈에 포함되어 있는 주요 패키지와 용도
  - java.lang: 자바 언어의 기본 클래스 제공
    - Object: 자바 클래스의 최상위 클래스로 사용
    - System: 키보드로부터 데이터를 입력받을 때, 모니터(콘솔)로 출력하기 위해, 프로세스를 종료시킬때, 진행시간을 읽을때, 시스템 속성(프로퍼티)를 읽을때 사용
    - String: 문자열을 저장/조작할 때 사용
    - StringBuilder: 효율적인 문자열 조작 기능이 필요할 때 사용
    - java.util.StringTokenizer: 구분자로 연결된 문자열을 분리할 때 사용
    - Byte, Short, Character, Integer, Float, Double, Boolean: 기본 타입의 값을 포장할 때 사용, 문자열을 기본 타입으로 변환 시 사용
    - Math: 수학 계산이 필요할 때 사용
    - Class: 클래스의 메타 정보(이름, 구성 멤버)등을 조사할 때 사용
  - java.util: 자료 구조와 관련된 컬렉션 클래스 제공
  - java.text: 날짜 및 숫자를 원하는 형태의 문자열로 만들어주는 포맷 클래스 제공
  - java.time: 날짜 및 시간을 조작, 연산하는 클래스 제공
  - java.io: 입출력 스트림 클래스 제공
  - java.net: 네트워크 통신과 관련된 클래스를 제공
  - java.nio: 데이터 저장을 위한 Buffer 및 새로운 입출력 클래스 제공
# 3. Object 클래스
- 클래스를 선언시 `extends` 키워드로 다른 클래스를 상속하지 않으면 암시적으로 `java.lang.Object` 클래스를 상속하게 됨 -> 자바의 모든 클래스는 Object의 자식/자손 클래스  
-> Object가 가진 메소드는 모든 객체에서 사용 가능
## 객체 동등 비교
- `public boolean equals(Object obj)`
- 매개변수 타입이 Object이므로 자동 타입 변환에 의해 모든 객체가 매개값으로 대입될 수 있음.
- 비교 연산자 `==`과 동일한 결과를 리턴
- 일반적인 사용법: 메소드를 재정의하여 동등 비교(객체가 비록 달라도 내부의 데이터가 같은지를 비교하는 것)
  - ex) String은 equals() 메소드를 재정의하여 내부 문자열이 같은지를 비교
## 객체 해시코드
- `public int hashCode()`
- 객체 해시코드: 객체를 식별하는 정수
- Object의 hashCode() 메소드: 객체의 메모리번지를 이용해서 해시코드를 생성 -> 객체마다 다른 정수값을 리턴
- 두 객체가 동등한지 비교할 때 주로 사용 - equals() 메소드와 용도 비슷, 객체의 데이터를 기준으로 재정의하여 새로운 정수값을 리턴하도록 하는 것이 일반적.
  - hashCode()가 리턴하는 정수값이 같은지를 확인 -> equals()메소드가 true를 리턴하는지를 확인(같이 사용)
## 객체 문자 정보
- Object의 `toString()` 메소드: 객체의 문자 정보(객체를 문자열로 표현한 값)를 리턴, `클래스명@16진수해시코드`
- 객체의 문자 정보가 중요한 경우, Object의 toString() 메소드를 재정의하여 간결/유익한 정보를 리턴
  - Date 클래스: 현재 날짜와 시간, String 클래스: 저장된 문자열을 리턴
- `System.out.println()`메소드는 매개값이
  - 기본타입/문자열인 경우: 해당 값을 그대로 출력
  - 객체인 경우: 객체의 toString() 메소드를 호출하여 리턴값을 출력
## 레코드 선언
- 레코드: 데이터 전달을 위한 Data Transfer Object(DTO)를 작성 시 반복적으로 사용되는 코드를 줄이기 위해 Java 14부터 레코드가 도입됨
  - 변수의 타입과 이름을 이용해 private final 필드가 자동 생성됨
  - 생성자 및 Getter 메소드가 자동으로 추가됨.
  - hashCode(), equals(), toString() 메소드를 재정의한 코드도 자동으로 추가됨.
```java
public record Person(String name, int age) {
}
//와 아래 코드는 같음
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() { return this.name; }
    public String age() { return this.age; }

    @Override
    public int hashCode() { ... }
    
    @Override
    public boolean equals(Object obj) { ... }

    @Override
    public String toString() { ... }
}
```
## 롬복 사용하기
- 롬복 Lombok: JDK에 포함된 표준 라이브러리는 아님, 개발자들이 즐겨쓰는 자동 코드 생성 라이브러리
  - 레코드와 마찬가지로 DTO 클래스 작성 시 Getter, Setter, hashcode(), equals(), toString()를 자동 생성
    - 필드가 final이 아님
    - Getter: getXxx(isXxx), Setter: setXxx로 생성됨.
  - `https://projectlombok.org/download` -> 프롬프트(관리자 권한 실행)에서 다운받은 jar파일이 있는 곳으로 이동하여 명령어 실행 `java -jar lombok.jar`
  - lib폴더를 생성해 lombok.jar 파일을 복사, 해당 파일을 클릭해 Build Path -> Add to Build Path를 선택(Referenced Libraries에 추가됨)
  - `import lombok.Data`, `@Data` 어노테이션을 선언하고 클래스를 선언(필드 선언) -> 기본 생성자, Getter, Setter, hashCode(), equals(), toString() 메소드가 자동 생성됨
  - 이외의 사용 가능한 어노테이션 종류
    - `@NoArgsConstructor`: 기본(매개변수가 없는) 생성자 포함
    - `@AllArgsConstructor`: 모든 필드를 초기화시키는 생성자 포함
    - `@RequiredArgsConstructor`: 기본적으로 매개변수가 없는 생성자(final 또는 @NonNull이 붙은 필드가 있다면 이것들만 초기화시키는 생성자) 포함
      - NonNull: final은 초기화 후 변경할 수 없고 Setter가 만들어지지 않지만, NonNull은 Null이 아닌 다른 값으로 Setter를 통해 변경 가능
    - `@Getter`: Getter 메소드 포함
    - `@Setter`: Setter 메소드 포함
    - `@EqualsAndHashCode`: equals()와 hashCode() 메소드 포함
    - `@ToString`: toString() 메소드 포함
   - `@Data`어노테이션 =  `@RequiredArgsConstructor`, `@Getter`, `@Setter`, `@EqualsAndHashCode`, `@ToString`을 합친 것
# 4. System 클래스
- 운영체제 상에서 바로 실행x, JVM 위에서 실행o -> 운영체제의 모든 기능을 자바 코드로 직접 접근하기 어려움 -> java.lang.System 클래스를 이용해 일부 기능을 이용
- System 클래스의 정적 필드
  - out: 콘솔에 문자 출력
  - err: 콘솔에 에러 내용 출력
  - in: 키보드 입력
- System 클래스의 메소드
  - exit(int status): 프로세스 종료
  - currentTimeMillis(): 현재 시간을 밀리초 단위의 long값으로 리턴
  - nanoTime(): 현재 시간을 나노초 단위의 long값으로 리턴
  - getProperty(): 운영체제와 사용자 정보 제공
  - getenv(): 운영체제의 환경 변수 정보 제공
## 콘솔 출력
- out, err(빨간색 출력) 필드를 이용해 콘솔에 원하는 문자열을 출력 가능
## 키보드 입력
- in 필드를 이용해 키보드로부터 입력된 키를 읽음
- `int keyCode = System.int.read();`: 입력된 키의 코드값을 얻을 수 있음. Enter키를 누르기 전까지는 대기 상태, 누르는 동시에 입력했던 키들을 하나씩 읽음.
  - read()는 IOException이 발생할 수 있는 코드 -> 예외 처리가 필요
## 프로세스 종료
- 운영체제는 실행 중인 프로그램을 프로세스로 관리: 자바 프로그램 시작 -> JVM 프로세스 실행 -> main() 메소드를 호출
  - 프로세스를 강제 종료하고 싶다면 `System.exit(int status)` 메소드를 사용
  - 종료 상태값인 int 매개값이 필요: 정상종료(0), 비정상 종료(1, -1)
> Java17 전까지는 종료 상태값은 System에 설정되는 SecurityManager에서 활용됨. 종료 상태값에 따라 특정 행위를 하도록 코딩 가능
## 진행 시간 읽기
- System클래스의 `currentTimeMillis()`메소드 - $1/1000$초 단위 - , `nanoTime()`메소드 - $1/10^9$초 단위 - 는 1970년 1월 1일 0시부터 시작해서 현재까지 진행된 시간을 리턴
- 프로그램 처리 시간을 측정 시 주로 사용됨: 프로그램 처리를 시작할 때 한번, 끝날 때 한번 읽어서 그 차이를 구함
## 시스템 프로퍼티 읽기
- 시스템 프로퍼티 System Property: 자바 프로그램이 시작될 때 자동 설정되는 시스템의 속성(운영체제 종류 및 사용자 정보, 자바 버전 등의 기본 사양 정보)
- 속성이름(key)와 값에 대한 설명
  - java.specification.version: 자바 스펙 버전
  - java.home: JDK 디렉토리 경로
  - os.name: 운영체제
  - user.name: 사용자 이름
  - user.home: 사용자 홈 디렉토리 경로
  - user.dir: 현재 디렉토리 경로
- `System.getProperty`
# 5. 문자열 클래스
- String: 문자열을 저장 및 조작할 때 사용
- StringBuilder: 효율적인 문자열 조작 기능이 필요할 때 사용
- StringTokenizer: 구분자로 연결된 문자열을 분리 시 사용
## String 클래스
1. 문자열 리터럴은 자동으로 String 객체로 생성됨
2. String 클래스의 다양한 생성자를 이용해 직접 객체 생성 가능
- byte 배열을 문자열로 변환하는 경우
`String str = new String(byte[] bytes); //기본 문자셋으로 디코딩`  
`String str = new String(byte[] bytes, String charsetName); //특정 문자셋으로 디코딩`
## StringBuiler 클래스
- `String data = "ABC"; data += "DEF";`: 내부 문자열을 수정x, 새로운 String 객체를 생성하여 data변수의 참조가 변경됨.
- 문자열의 +연산: 새로운 String 객체가 생성, 이전 객체는 버려짐 -> 효율이 좋지 않음
- StringBuilder를 사용: 내부 버퍼에 문자열을 저장해두고 그 안에서 추가/수정/삭제 작업을 하도록 설계
  - `StringBuilder append(기본값 | 문자열)`: 문자열을 끝에 추가
  - `StringBuilder insert(위치, 기본값 | 문자열)`: 문자열을 지정 위치에 추가
  - `StringBuilder delete(시작 위치, 끝 위치)`: 문자열 일부를 삭제
  - `StringBuilder replace(시작 위치, 끝 위치, 문자열)`: 문자열 일부를 대체
  - `String toString()`: 완성된 문자열을 리턴
- StringBuilder의 대부분 메소드는 StringBuilder를 다시 리턴하기 때문에 연이어 다른 메소드를 호출 가능(메소드 체이닝 패턴)
## StringTokenizer 클래스
- 구분자로 연결된 문자열 -> 구분자를 기준으로 분리하려면
  - String.split() 메소드 이용 - 정규표현식으로 구분
  - java.util.StringTokenizer 클래스를 이용 - 문자로 구분
- 여러 종류의 구분자가 있는 문자열의 경우 split()을 이용, 한 종류의 구분자만 있는 문자열의 경우 StringTokenizer를 사용 가능(객체 생성시 첫번째 매개값=전체 문자열, 두번째 매개값=구분자)
```java
String data = "홍길동&이수홍,박연수,김자바-최명호";
String[] names = data.split("&|,|-");

String data = "홍길동/이수홍/박연수";
StringTokenizer st = new StringTokenizer(data, "/");
```
- StringTokenizer 객체의 메소드
  - `int countTokens()`: 분리할 수 있는 문자열의 총 수
  - `boolean hasMoreTokens()`: 남아있는 문자열이 있는지 여부
  - `String nextToken()`: 문자열을 하나씩 가져옴, 더 이상 가져올 문자열이 없다면 예외를 발생시킴
# 6. 포장 클래스
- 포장 객체: 기본 타입(byte, char, short, int, long, float, double, boolean)의 값을 갖는 객체
- 포장 객체를 생성하기 위한 클래스: java.lang 패키지에 포함
  - byte -> Byte
  - char -> Character
  - short -> Short
  - int -> Integer
  - long -> Long
  - float -> Float
  - double -> Double
  - boolean -> Boolean
- 포장 객체는 값을 변경 불가, 단지 객체로의 생성에 목적이 있음 -> 컬렉션 객체(기본 타입의 값은 저장불가)에 저장 가능
## 박싱과 언박싱
- 박싱: 기본 타입의 값을 포장 객체로 만드는 과정 `포장클래스 변수 = 기본타입값`
- 언박싱: 포장 객체에서 기본 타입의 값을 얻어내는 과정 `기본타입 변수 = 포장객체`
  - 연산과정에서도 발생. ex `int value = obj + 50;`
## 문자열을 기본 타입 값으로 변환
- 포장 클래스: 문자열을 기본 타입 값으로 변환 시 사용
  - 대부분의 포장 클래스에 존재하는 `parse기본타입명`으로 된 정적 메소드: 문자열을 해당 기본 타입 값으로 변환
## 포장 값 비교
- 포장 객체는 내부 값을 비교하기 위해 `==`,`!=` 연산자를 사용시 포장 객체의 번지를 비교하게 됨.
  - 포장 객체가 공유되는 값의 범위 -> 비교 연산자로 비교 가능
    - boolean(true, false)
    - char(\u0000 ~ \u007f)
    - byte, short, int(-128 ~ 127)
- 포장 객체에 어떤 값이 저장될지 모르는 상황 -> equals() 메소드로 내부 값을 비교
  - 포장 클래스의 equals() 메소드는 내부의 값을 비교하도록 재정의되어 있음
# 7. 수학 클래스
- Math 클래스: 수학 계산에 사용할 수 있는 메소드(static)를 제공
  - 절대값: Math.abs();
  - 올림값: Math.ceil();
  - 버림값: Math.floor();
  - 최대값: Math.max();
  - 최소값: Math.min();
  - 랜덤값: Math.random();
    - 0.0 ~ 1.0 사이의 double 타입 난수를 리턴
    - start부터 시작하는 n개의 정수 중 하나의 정수를 얻기 위한 공식: `int num = (int) (Math.random() * n) + start;`
  - 반올림값: Math.round();
- 난수를 얻는 또 다른 방법: `java.util.Random` 클래스 이용
  - Random 객체의 생성자
    - Random(): 현재 시간을 이용해서 시드값을 자동 설정
    - Random(long seed): 주어진 시드값을 사용
  - Random 클래스의 메소드
    - `boolean nextBoolean()`: boolean 타입의 난수를 리턴
    - `double nextDouble()`: double 타입의 난수를 리턴
    - `int nextInt()`: int 타입의 난수를 리턴($-2^{32}$ ~ $2^{32}-1$)
    - `int nextInt(int n)`: int 타입의 난수를 리턴(0<= ~ <n)
# 8. 날짜와 시간 클래스
- java.util 패키지에서 Date(날짜 정보 전달), Calendar(다양한 시간대별로 날짜와 시간을 얻을때) 클래스를 제공
- java.time 패키지에서 LocalDateTime(날짜와 시간을 조작) 클래스 제공
## Date 클래스
- 날짜를 표현하는 클래스, 객체 간에 날자 정보를 주고받을 때 사용
- 여러 개의 생성자; 대부분 Deprecated, Date() 생성자 -컴퓨터의 현재 날짜를 읽어 Date 객체로 만듦- 만 주로 사용  
`Date now = new Date()`
- 현재 날짜를 문자열로 얻고 싶다면
  - toString(): 영문으로 출력
  - SimpleDateFormat 클래스와 함께 사용
## Calendar 클래스
- 달력을 표현하는 추상 클래스 
  - 날짜와 시간을 계산하는 방법이 지역/문화에 따라 다르기 때문에 특정 역법을 따르는 달력은 자식 클래스에서 구현
  - 특별한 역법을 사용하는 경우가 아닐때 -> Calendar 클래스의 정적 메소드 getInstance() 메소드를 이용해 컴퓨터에 설정되어 있는 시간대를 기준으로 하위 객체를 얻음  
  `Calendar now = Calendar.getInstance();`
    - Calendar 객체가 제공하는 날짜와 시간에 대한 정보를 얻기 위해서 get() 메소드를 이용, 매개값으로 Calendar에 정의된 상수를 전달(YEAR, MONTH, DAY_OF_MONTH, DAY_OF_WEEK, AM_PM, HOUR, MINUTE, SECOND)
  - Calendar 클래스의 오버로딩된 다른 getInstance() 메소드를 이용하여, 알고 싶은 시간대의 TimeZone 객체를 얻어 매개값으로 넘겨주면 됨.  
  `TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");`  
  `Calendar now = Calendar.getInstance(timeZone);`
## 날짜와 시간 조작
- `Date`, `Calendar`는 날짜/시간 정보 획득 가능; 조작은 불가 -> `java.time.LocalDateTime` 클래스의 메소드를 이용
  - `minusYears(long)`: 년 빼기
  - `minusMonths(long)`: 월 빼기
  - `minusDays(long)`: 일 빼기
  - `minusWeeks(long)`: 주 빼기
  - `plusYears(long)`: 년 더하기
  - `plusMonths(long)`: 월 더하기
  - `plusWeeks(long)`: 주 더하기
  - `plusDays(long)`: 일 더하기
  - `minusHours(long)`: 시간 빼기
  - `minusMinutes(long)`: 분 빼기
  - `minusSeconds(long)`: 초 빼기
  - `minusNanos(long)`: 나노초 빼기
  - `plusHours(long)`: 시간 더하기
  - `plusMinutes(long)`: 분 더하기
  - `plusSeconds(long)`: 초 더하기
- `LocalDateTime now = LocalDateTime.now()`: LocalDateTime 클래스를 이용해 현재 컴퓨터의 날짜와 시간을 얻는 법  
## 날짜와 시간 비교
- `LocalDateTime` 클래스의 날짜/시간 비교 메소드
  - `boolean isAfter(other)`: 이후 날짜인지?
  - `boolean isBefore(other)`: 이전 날짜인지?
  - `boolean isEqual(other)`: 동일 날짜인지?
  - `long until(other, unit)`: 주어진 단위 unit 차이를 리턴
- `LocalDateTime target = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);`: 비교를 위해 특정 날짜/시간으로 LocalDateTime 객체를 얻는 방법(매개값은 int타입 값으로 제공)
# 9. 형식 클래스
- `java.text` 패키지에 포함된 Format 클래스: 숫자 또는 날짜를 원하는 형태의 문자열로 변환해주는 기능을 제공
  - `DecimalFormat`: 숫자를 형식화된 문자열로 변환
  - `SimpleDateFormat`: 날짜를 형식화된 문자열로 변환
## DecimalFormat
- 숫자를 형식화된 문자열로 변환하는 기능을 제공
- 원하는 형식으로 표현하기 위해 패턴을 사용
  - 0: 10진수(빈자리는 0으로 채움)
  - #: 10진수(빈자리는 채우지 않음)
  - .: 소수점
  - -: 음수 기호
  - ,: 단위 구분
  - E: 지수 문자
  - ;: 양수와 음수의 패턴을 기술할 경우의 패턴 구분자
  - %: %문자
  - \u00A4: 통화 기호
- DecimalFormat 객체의 `format()` 메소드로 숫자를 제공하여 사용.
## SimpleDateFormat
- 날짜를 형식화된 문자열로 변환하는 기능을 제공
- 원하는 형식으로 표현하기 위해 패턴을 사용
  - y: 년
  - M: 월
  - d: 일
  - D: 월 구분이 없는 일(1~365)
  - E: 요일
  - a: 오전/오후
  - w: 년의 몇 번째 주
  - W: 월의 몇 번째 주
  - H: 시(0~23)
  - h: 시(1~12)
  - K: 시(0~11)
  - k: 시(1~24)
  - m: 분
  - s: 초
  - S: 밀리세컨드(1/1000초)
- 패턴은 자릿수에 맞게 기호를 반복해서 작성 가능
- 패턴 정보와 함께 SimpleDateFormat 객체를 생성, `format()` 메소드로 날짜를 제공
# 10. 정규 표현식 클래스
- 문자열이 정해져 있는 형식으로 구성되어 있는지 검증해야하는 경우 정규표현식을 이용
## 정규 표현식 작성 방법
- 문자 또는 숫자와 관련된 표현과 반복 기호가 결합된 문자열
- `[]`: 한 개의 문자
  - `[abc]`: a,b,c 중 하나의 문자
  - `[^abc]`: a,b,c 이외의 하나의 문자
  - `[a-zA-Z]`: a~z, A~Z 중 하나의 문자
- `\d`: 한개의 숫자, [0-9] 와 동일
- `\s`: 공백
- `\w`: 한 개의 알파벳 또는 한 개의 숫자, [a-zA-Z_0-9] 와 동일
- `\.`: .
- `.`: 모든 문자 중 한 개의 문자
- `?`: 없음 또는 한 개
- `*`: 없음 또는 한 개 이상
- `+`: 한 개 이상
- `{n}`: 정확히 n개
- `{n,}`: 최소한 n개
- `{n,m}`: n개부터 m개까지
- `a|b`: a 또는 b
- `()`: 그룹핑
## Pattern 클래스로 검증
- java.util.regex 패키지의 Pattern 클래스의 matches() 메소드: 정규표현식으로 문자열을 검증  
`boolean result = Pattern.matches("정규식", "검증할 문자열");`
# 11. 리플렉션
- 자바는 클래스, 인터페이스의 메타 정보(패키지 정보, 타입 정보, 멤버-생성자, 필드, 메소드- 정보 등)를 Class 객체로 관리함.
- 리플렉션 reflection: 메타 정보를 프로그앰에서 읽고 수정하는 행위
- 프로그램에서 Class 객체를 얻는 방법
  - 1. 클래스이름: `Class clazz = 클래스이름.class`
  - 2. 클래스이름: `Class clazz = Class.forName("패키지...클래스이름");`
  - 3. 객체참조변수: `Class clazz = 객체참조변수.getClass();`
## 패키지와 타입 정보 얻기
- 패키지와 타입(클래스, 인터페이스) 이름 정보를 얻는 메소드
  - `Package getPackage()`: 패키지 정보 읽기
  - `String getSimpleName()`: 패키지를 제외한 타입 이름
  - `String getName()`: 패키지를 포함한 전체 타입 이름
## 멤버 정보 얻기
- 타입(클래스, 인터페이스)가 가지고 있는 멤버 정보를 얻는 메소드
  - `Constructor[] getDeclaredConstructors()`: 생성자 정보 읽기
  - `Field[] getDeclaredFields()`: 필드 정보 읽기
  - `Method[] getDeclaredMethods()`: 메소드 정보 읽기
- Constructor, Field, Method 클래스는 모두 java.lang.reflect 패키지에 있음. 
  - 각각 생성자, 필드, 메소드에 대한 선언부 정보를 제공
## 리소스 경로 얻기
- Class 객체: 클래스 파일(.class)의 경로 정보를 가지고 있음.  
-> 이 경로를 기준으로 상대 경로에 있는 다른 리소스 파일의 정보를 얻을 수 있음
  - `URL getResource(String name)`: 리소스 파일의 URL(객체) 리턴
  - `InputStream getResourceAsStream(String name)`: 리소스 파일의 InputStream(객체) 리턴
# 12. 어노테이션
- 어노테이션: 코드에서 @으로 작성되는 요소. 클래스 또는 인터페이스를 컴파일하거나 실행할 때 어떻게 처리해야 할 것인지를 알려주는 설정 정보
  1. 컴파일 시 사용하는 정보 전달
  2. 빌드 툴이 코드를 자동으로 생성할 때 사용하는 정보 전달
  3. 실행 시 특정 기능을 처리할 때 사용하는 정보 전달
## 어노테이션 타입 정의와 적용
- 어노테이션도 하나의 타입 -> 사용하기 위해서 정의가 필요 (~=인터페이스 정의와 유사)
`public @interface AnnotationName { }` -> `@AnnotationName`으로 코드에서 사용됨
- 어노테이션은 속성(타입과 이름으로 구성)을 가질 수 있음. 
  - 속성의 기본값은 default 키워드로 지정.
  - 기본 속성: value -> 코드에서 단독 사용 시 값만 기술(다른 속성과 함께 기술 시 속성이름을 명시)
```java
public @interface AnnotationName {
    String value();
    String prop1();
    int prop2() default 1;
}

//어노테이션의 속성을 코드에서 사용할 때
@AnnotationName(prop1="값");
@AnnotationName(prop1="값", prop2=3);
@AnnotationName("값");
@AnnotationName(value="값", prop2=3);
```
## 어노테이션 적용 대상
- 설정 정보의 대상을 명시해야함 -> 적용할 수 있는 대상의 종류는 ElementType 열거 상수로 정의되어 있음.
  - `TYPE`: 클래스, 인터페이스, 열거 타입
  - `ANNOTATION_TYPE`: 어노테이션
  - `FIELD`: 필드
  - `CONSTRUCTOR`: 생성자
  - `METHOD`: 메소드
  - `LOCAL_VARIABLE`: 로컬 변수
  - `PACKAGE`: 패키지
- 적용 대상을 지정 시 `@Target` 어노테이션을 사용, `@Target`의 기본 속성인 value는 ElementType 배열을 값으로 가짐.
```java
//클래스, 필드, 메소드에만 적용 가능한 어노테이션 정의
@Target( {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD} )
public @interface AnnotationName {
}

@AnnotationName
public class ClassName {
    @AnnotationName
    private String fieldName;

    //@AnnotationName
    public ClassName() { }

    @AnnotationName
    public void methodName() { }
}
```
## 어노테이션 유지 정책
- 어노테이션 유지 정책: @AnnotationName을 언제까지 유지할 것인지 지정 -> RetentionPolicy 열거 상수
  - `SOURCE`: 컴파일할 때 적용, 컴파일된 후에 제거됨
  - `CLASS`: 메모리로 로딩할 때 적용, 메모리로 로딩된 후에 제거됨
  - `RUNTIME`: 실행할 때 적용, 계속 유지됨
- 유지 정책 지정 시 `@Retention` 어노테이션을 사용, `@Retention`의 기본 속성인 value는 RetentionPolicy 열거 상수 값을 가짐.
```java
@Target( {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD} )
@Retention( RetentionPolicy.RUNTIME )
public @interface AnnotationName {
}
```
## 어노테이션 설정 정보 이용
- 설정 정보를 이용해 처리할 지는 애플리케이션의 몫 -> 리플렉션을 이용해 적용 대상으로부터 어노테이션 정보를 얻어내기 가능
  - `boolean isAnnotationPresent(AnnotationName.class)`: 지정한 어노테이션이 적용되었는지 여부
  - `Annotation getAnnotation(AnnotationName.class)`: 지정한 어노테이션이 적용된 경우 어노테이션을 리턴, 그렇지 않다면 null을 리턴
  - `Annotation[] getDeclaredAnnotations()`: 적용된 모든 어노테이션을 리턴