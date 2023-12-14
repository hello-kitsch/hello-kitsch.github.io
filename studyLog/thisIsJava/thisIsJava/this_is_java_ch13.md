# 1. 제네릭이란?
- 다양한 내용물을 저장해야하는 Box에 넣을 내용물로 content 필드를 선언해야하는 상황
```java
//모든 클래스의 최상위 부모 클래스인 Object타입으로 선언
public class Box {
    public Object content;
}

//모든 객체는 부모 타입인 Object로 자동 타입 변환이 됨.
Box box = new Box();
box.content = 모든 객체;

//Box 안의 내용물을 얻을 때 Object 타입이므로 어떤 객체가 대입되어 있는지 확실하지 않음
//타입을 아는 경우, 강제 타입 변환을 거침
String content = (String) box.content;
//타입을 모르는 경우 instanceof 연산자로 타입 조사 가능; 한계O -> Object 타입으로의 선언보다 다른 방법이 필요
```
- Box를 생성할 때 어떤 내용물을 넣을 지 알고 있음 -> 저장할 내용물의 타입을 미리 알려주는 것 = **제네릭**
- 제네릭 Generic: 결정되지 않은 타입을 파라미터로 처리, 실제 사용 시 파라미터를 구체적인 타입으로 대체시키는 기능
```java
public class Box <T> {
    public T content;
}

Box<String> box = new Box<String>();
box.content = "안녕하세요.";
String content = box.content;

Box<Integer> box = new Box<Integer>();
box.content = 100;
int content = box.content;
```
- 타입 파라미터 T(다른 알파벳도 무관)를 대체하는 타입: 클래스, 인터페이스(not int)
- 변수를 선언할 때와 동일한 타입으로 호출하고 싶다면 생성자 호출시 생성자에는 타입을 명시하지않고 <>만 붙일 수 있음
`Box<String> box = new Box<String>();` -> `Box<String> box = new Box<>();`
# 2. 제네릭 타입
- 제네릭 타입: 결정되지 않은 타입을 파라미터로 가지는 클래스와 인터페이스
  - 선언부에 `<>`부호가 붙고 그 사이에 타입 파라미터들이 위치
  - 타입 파라미터는 변수명과 동일한 규칙에 따라 작성 가능; 일반적으로 대문자 알파벳 한 글자로 표현
  - 외부에서 제네릭 타입을 사용하려면 타입 파라미터에 구체적인 타입을 지정해야함(암묵적으론 Object 타입이 사용됨)'
- 타입 파라미터는 기본적으로 Object 타입으로 간주 -> Object가 가지고 있는 메소드를 호출 가능
# 3. 제네릭 메소드

# 4. 제한된 타입 파라미터
# 5. 와일드카드 타입 파라미터