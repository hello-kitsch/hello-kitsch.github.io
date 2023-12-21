# 1. 컬렉션 프레임워크
- 컬렉션 프레임워크: 자료구조를 바탕으로 객체들을 효율적으로 추가, 삭제, 검색할 수 있도록 관련 인터페이스와 클래스를 java.util 패키지에 포함시켜 놓은 것.
- 주요 인터페이스: List, Set, Map
  - `List`, `Set`은 객체를 추가, 삭제, 검색하는 방법에 있어서 공통점이 있음 -> 공통된 메소드만 따로 모아 `Collection` 인터페이스로 정의해두고 이것을 상속
  - `Map`은 키와 값을 하나의 쌍으로 묶어서 관리하는 구조

인터페이스 분류|세부 분류|특징|구현 클래스
---|---|---|---
Collection|List|순서를 유지하고 저장/중복 저장 가능|ArrayList, Vector, LinkedList
Collection|Set|순서를 유지하지 않고 저장/중복 저장 안됨|HashSet, TreeSet
Map||키와 값으로 구성된 엔트리 저장/키는 중복 저장 안됨|HashMap, Hashtable, TreeMap, Properties
# 2. List 컬렉션
- `List`컬렉션: 객체를 인덱스로 관리, 객체를 저장하면 인덱스 부여, 인덱스로 객체를 검색, 삭제할 수 있는 기능을 제공
- List 컬렉션에서 공통적으로 사용 가능한 List 인터페이스 메소드
  - 객체 추가
    - `boolean add(E e)`: 주어진 객체를 맨 끝에 추가
    - `void add(int index, E element)`: 주어진 인덱스에 객체를 추가
    - `set(int index, E element)`: 주어진 인덱스의 객체를 새로운 객체로 바꿈
  - 객체 검색
    - `boolean contains(Object o)`: 주어진 객체가 저장되어 있는지 여부
    - `E get(int index)`: 주어진 인덱스에 저장된 객체를 리턴
    - `isEmpty()`: 컬렉션이 비어 있는지 조사
    - `int size()`: 저장되어 있는 전체 객체 수를 리턴
  - 객체 삭제
    - `void clear()`: 저장된 모든 객체를 삭제
    - `E remove(int index)`: 주어진 인덱스에 저장된 객체를 삭제
    - `boolean remove(Object o)`: 주어진 객체를 삭제
## ArrayList
- ArrayList: List 컬렉션에서 가장 많이 사용되는 컬렉션, 객체 추가시 내부 배열에 객체가 저장됨, 제한 없이 객체 추가 가능
  - 객체의 번지를 저장
  - 동일한 객체를 중복 저장 가능(동일한 번지가 저장됨)
  - null 저장 가능
```java
List<E> list = new ArrayList<E>(); //타입 파라미터 E에는 ArrayList에 저장하고 싶은 객체 타입을 지정
List<E> list = new ArrayList<>(); //List에 지정한 객체 타입과 동일하다면 뒤에는 생략 가능
List list = new ArrayList(); //객체 타입을 모두 생략하면 모든 종류의 객체를 저장 가능
```
- 객체 추가 시 인덱스 0번부터 차례로 저장됨
- 객체 제거 시 뒤 인덱스부터 마지막 인덱스까지 모두 앞으로 1씩 당겨짐 -> 빈번한 객체 삭제/삽입이 일어나는 곳에서는 ArrayList를 사용 자제
## Vector
- ArrayList와 동일한 내부 구조; 
- 동기화된 메소드로 구성되어 있어 멀티 스레드가 동시에 Vector() 메소드를 실행 불가 -> 멀티 스레드 환경에서 안전하게 객체를 추가/삭제 가능
```java
List<E> list = new Vector<E>(); //타입 파라미터 E에는 Vector에 저장하고 싶은 객체 타입을 지정
List<E> list = new Vector<>(); //List에 지정한 객체 타입과 동일하다면 뒤에는 생략 가능
List list = new Vector(); //객체 타입을 모두 생략하면 모든 종류의 객체를 저장 가능
```
# 3. Set 컬렉션
# 4. Map 컬렉션
# 5. 검색 기능을 강화시킨 컬렉션
# 6. LIFO와 FIFO 컬렉션
# 7. 동기화된 컬렉션
# 8. 수정할 수 없는 컬렉션