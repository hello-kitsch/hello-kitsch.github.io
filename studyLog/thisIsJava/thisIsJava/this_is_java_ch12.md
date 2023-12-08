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
  - java.util: 자료 구조와 관련된 컬렉션 클래스 제공
  - java.text: 날짜 및 숫자를 원하는 형태의 문자열로 만들어주는 포맷 클래스 제공
  - java.time: 날짜 및 시간을 조작, 연산하는 클래스 제공
  - java.io: 입출력 스트림 클래스 제공
  - java.net: 네트워크 통신과 관련된 클래스를 제공
  - java.nio: 데이터 저장을 위한 Buffer 및 새로운 입출력 클래스 제공
- java.lang 패키지에 포함된 주요 클래스와 용도
  - Object: 자바 클래스의 최상위 클래스로 사용
  - System: 키보드로부터 데이터를 입력받을 때, 모니터(콘솔)로 출력하기 위해, 프로세스를 종료시킬때, 진행시간을 읽을때, 시스템 속성(프로퍼티)를 읽을때 사용
  - String: 문자열을 저장/조작할 때 사용
  - StringBuilder: 효율적인 문자열 조작 기능이 필요할 때 사용
  - java.util.StringTokenizer: 구분자로 연결된 문자열을 분리할 때 사용
  - Byte, Short, Character, Integer, Float, Double, Boolean: 기본 타입의 값을 포장할 때 사용, 문자열을 기본 타입으로 변환 시 사용
  - Math: 수학 계산이 필요할 때 사용
  - Class: 클래스의 메타 정보(이름, 구성 멤버)등을 조사할 때 사용
# 3. Object 클래스
- 클래스를 선언시 `extends` 키워드로 다른 클래스를 상속하지 않으면 암시적으로 `java.lang.Object` 클래스를 상속하게 됨 -> 자바의 모든 클래스는 Object의 자식/자손 클래스  
-> Object가 가진 메소드는 모든 객체에서 사용 가능
  - `boolean equals(Object obj)`: 객체의 번지를 비교, 결과를 리턴
  - `int hashCode()`: 객체의 해시코드를 리턴
  - `String toString()`: 객체 문자 정보를 리턴
## 객체 동등 비교
- `public boolean equals(Object obj)`
- 매개변수 타입이 Object
# 4. System 클래스
# 5. 문자열 클래스
# 6. 포장 클래스
# 7. 수학 클래스
# 8. 날짜와 시간 클래스
# 9. 형식 클래스
# 10. 정규 표현식 클래스
# 11. 리플렉션
# 12. 어노테이션