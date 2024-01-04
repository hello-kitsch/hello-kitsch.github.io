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
## LinkedList
- ArrayList와 사용 방법은 동일, 내부 구조는 다름
  - ArrayList: 내부 배열에 객체를 저장
  - LinkedList: 인접 객체를 체인처럼 연결해서 관리
- 특정 위치에 객체 삽입/삭제 시 성능면에서 유리: 바로 앞뒤 링크만 변경하면 되므로.
```java
List<E> list = new LinkedList<E>(); //타입 파라미터 E에는 LinkedList에 저장하고 싶은 객체 타입을 지정
List<> list = new LinkedList<>(); //List에 지정한 객체 타입과 동일하다면 뒤에는 생략 가능
List list = new LinkedList(); //객체 타입을 모두 생략하면 모든 타입의 객체를 저장 가능
```
# 3. Set 컬렉션
- List 컬렉션과 달리 저장 순서 유지X
- 객체 중복 저장 불가, 하나의 null만 저장 가능
- Set 컬렉션: HashSet, LinkedHashSet, TreeSet 등(인덱스를 관리X)
- Set 인터페이스의 메소드
  - 객체 추가
    - `boolean add(E e)`: 주어진 객체를 성공적으로 저장하면 true를 리턴, 중복 객체면 false를 리턴
  - 객체 검색
    - `boolean contains(Object o)`: 주어진 객체가 저장되어 있는지 여부
    - `isEmpty()`: 컬렉션이 비어 있는지 조사
    - `Iterator<E> iterator()`: 저장된 객체를 한번 씩 가져오는 반복자 리턴
    - `int size()`: 저장되어 있는 전체 객체 수 리턴
  - 객체 삭제
    - `void clear()`: 저장된 모든 객체를 삭제
    - `boolean remove(Object o)`: 주어진 객체를 삭제
## HashSet
- Set 컬렉션 중에서 가장 많이 사용되는 것
- 생성 방법
```java
Set<E> set = new HashSet<E>(); //타입 파라미터 E에는 HashSet에 저장하고 싶은 객체 타입을 지정
Set<E> set = new HashSet<>(); //Set에 지정한 객체 타입과 동일하다면 뒤에는 생략 가능
Set set = new HashSet(); //객체 타입을 모두 생략하면 모든 타입의 객체를 저장 가능
```
- 동일한 객체(동등 객체)는 중복 저장하지 않음. 
  - hashCode() 리턴값과 equals() 리턴값이 모두 같으면 동일한 객체
    - 문자열을 HashSet에 저장 시, 같은 문자열을 갖는 String 객체는 동등한 객체로 간주
- 인덱스로 객체를 검색해서 가져오는 메소드가 없음 -> 객체를 한 개씩 반복해서 가져와야함.
  1. for문 이용
  ```java
  Set<E> set = new HashSet<>();
  for(E e : set) {
      ...
  }
  ```
  2. Set 컬렉션의 iterator() 메소드로 반복자를 얻어 객체를 하나씩 가져옴
  ```java
  Set<E> set = new HashSet<>();
  Iterator<E> iterator = set.iterator();
  ```
    - iterator()가 반환하는 Iterator<>가 제공하는 메소드
      - `boolean hasNext()`: 가져올 객체가 있으면 true, 없으면 false를 리턴
      - `E next()`: 컬렉션에서 하나의 객체를 가져옴
      - `void remove()`: next()로 가져온 객체를 Set 컬렉션에서 제거
  ```java
  while(iterator.hasNext()) {
      E e = iterator.next();
  }
  ```
# 4. Map 컬렉션
- Map 컬렉션: 키와 값(객체)으로 구성된 엔트리 객체를 저장
  - 키는 중복 저장 불가(기존에 저장된 키와 동일한 키로 저장 시 대치가 이루어짐), 값은 중복 저장 가능
  - 키와 값을 합쳐서 Map.Entry
- Map에는 HashMap, Hashtable, LinkedHashMap, Properties, TreeMap 등이 존재. (K: 키 타입 파라미터, V: 값 타입 파라미터)
  - 객체 추가
    - `V put(K key, V value)`: 주어진 키와 값을 추가, 저장이 되면 값을 리턴
  - 객체 검색
    - `boolean containsKey(Object key)`: 주어진 키가 있는지 여부
    - `boolean containsValue(Object value)`: 주어진 값이 있는지 여부
    - `Set<Map.Entry<K,V>> entrySet()`: 키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 Set에 담아서 리턴
    - `V get(Object key)`: 주어진 키의 값을 리턴
    - `boolean isEmpty()`: 컬렉션이 비어있는지 여부
    - `Set<K> keySet()`: 모든 키를 Set 객체에 담아서 리턴
    - `int size()`: 저장된 키의 총 수를 리턴
    - `Collection<V> values()`: 저장된 모든 값 Collection에 담아서 리턴
  - 객체 삭제
    - `void clear()`: 모든 Map.Entry(키와 값)를 삭제
    - `V remove(Object key)`: 주어진 키와 일치하는 Map.Entry 삭제, 삭제되면 값을 리턴
## HashMap
- HashMap은 키로 사용할 객체가 
  - `hashCode()`메소드와 리턴값이 같고 
  - `equals()`메소드가 true를 리턴 시, 동일 키로 보고 중복 저장 허용X
- HashMap 컬렉션을 생성하는 방법: `Map<K, V> map = new HashMap<K, V>();`
```java
Map<String, Integer> map = new HashMap<String, Integer>();
Map<String, Integer> map = new HashMap<>();
Map map = new HashMap(); //모든 타입의 키와 객체를 저장 가능하도록 HashMap을 생성은 가능; 거의 없는 경우임.
```
## Hashtable
- HashMap과 동일한 내부 구조; 동기화된 메소드로 구성됨 -> 멀티 스레드가 동시에 Hashtable의 메소드들을 실행 불가 -> 멀티 스레드 환경에서도 안전하게 객체 추가 및 삭제 가능
```java
Map<String, Integer> map = new Hashtable<String, Integer>();
Map<String, Integer> map = new Hashtable<>();
Map map = new Hashtable(); //모든 타입의 키와 객체를 저장 가능; 거의 사용하지 않음
```
## Properties
- Hashtable의 자식 클래스 -> Hashtable의 특징을 그대로 가지고 있음.
- Properties는 키와 값을 String 타입으로 제한한 컬렉션. 확장자가 `.properties`인 프로퍼티 파일을 읽을 때 사용
  - 프로퍼티 파일: 키와 값이 `=`기호로 연결되어 있는 텍스트 파일
    - ISO 8859-1 문자셋으로 저장됨, 한글의 경우 \u+유니코드로 표현되어 저장됨.
- `Properties`을 사용 시 프로퍼티 파일의 내용을 코드에서 쉽게 읽을 수 있음
```java
Properties properties = new Properties(); //Properties 객체를 생성
properties.load(Xxx.class.getResourceAsStream("database.properties")); //load() 메소드로 프로퍼티 파일의 내용을 메모리로 로드
```
- class 객체의 `getResourceAsStream()`메소드: 주어진 상대 경로의 리소스 파일을 읽는 InputStream을 리턴
# 5. 검색 기능을 강화시킨 컬렉션
- 컬렉션 프레임워크는 검색 기능을 강화시킨 TreeSet(Set컬렉션)과 TreeMap(Map컬렉션)을 제공
## TreeSet
- 이진 트리(여러 개의 노드가 트리 형태로 연결된 구조, 하나의 노드에서 시작해 각 노드에 최대 2개의 노드를 연결할 수 있는 구조)를 기반으로 한 Set 컬렉션.
- TreeSet에 객체 저장시 자동으로 정렬됨. 부모 노드의 객체와 비교해 낮은 것은 왼쪽 자식 노드, 높은 것은 오른쪽 자식 노드.
```java
TreeSet<E> treeSet = new TreeSet<E>();
TreeSet<E> treeSet = new TreeSet<>();
```
- TreeSet에 정의된 검색 관련 메소드
  - `E first()`: 제일 낮은 객체를 리턴
  - `E last()`: 제일 높은 객체를 리턴
  - `E lower(E e)`: 주어진 객체보다 바로 아래 객체를 리턴
  - `E higher(E e)`: 주어진 객체보다 바로 위 객체를 리턴
  - `E floor(E e)`: 주어진 객체와 동등한 객체가 있다면 리턴, 없다면 주어진 객체의 바로 아래의 객체를 리턴
  - `E ceiling(E e)`: 주어진 객체와 동등한 객체가 있으면 리턴, 없다면 주어진 객체의 바로 위의 객체를 리턴
  - `E pollFirst()`: 제일 낮은 객체를 꺼내오고 컬렉션에서 제거함
  - `E pollLast()`: 제일 높은 객체를 꺼내오고 컬렉션에서 제거함
  - `Iterator<E> descendingIterator()`: 내림차순으로 정렬된 Iterator를 리턴
  - `NavigableSet<E> descendingSet()`: 내림차순으로 정렬된 NavigableSet을 리턴
  - `NavigableSet<E> headSet(E toElement, boolean inclusive)`: 주어진 객체보다 낮은 객체들을 NavigableSet으로 리턴, 주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐
  - `NavigableSet<E> tailSet(E fromElement, boolean inclusive)`: 주어진 객체보다 높은 객체들을 NavigableSet으로 리턴, 주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐
  - `NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)`: 시작과 끝으로 주어진 객체 사이의 객체들을 NavigableSet으로 리턴, 시작과 끝 객체의 포함 여부는 두 번째, 네 번째 매개값에 따라 달라짐
## TreeMap
- 이진 트리를 기반으로 한 Map 컬렉션
- TreeSet과의 차이점: 키와 값이 저장된 Entry를 저장함. Entry를 저장 시 키를 기준으로 자동 정렬됨(부모 키 값과 비교하여 낮은 것은 왼쪽, 높은 것은 오른쪽 자식 노드에 Entry 객체를 저장)
```java
TreeMap<K, V> treeMap = new TreeMap<K, V>();
TreeMap<K, V> treeMap = new TreeMap<>();
```
- TreeMap 타입에 존재하는 검색 관련 메소드
  - `Map.Entry<K,V> firstEntry()`: 제일 낮은 Map.Entry를 리턴
  - `Map.Entry<K,V> lastEntry()`: 제일 높은 Map.Entry를 리턴
  - `Map.Entry<K,V> lowerEntry(K key)`: 주어진 키보다 바로 아래 Map.Entry를 리턴
  - `Map.Entry<K,V> higherEntry(K key)`: 주어진 키보다 바로 위 Map.Entry를 리턴
  - `Map.Entry<K,V> floorEntry(K key)`: 주어진 키와 동등한 키가 있으면 해당 Map.Entry를 리턴, 없다면 주어진 키 바로 아래의 Map.Entry를 리턴
  - `Map.Entry<K,V> ceilingEntry(K key)`: 주어진 키와 동등한 키가 있으면 해당 Map.Entry를 리턴, 없다면 주어진 키 바로 위의 Map.Entry를 리턴
  - `Map.Entry<K,V> pollFirstEntry()`: 제일 낮은 Map.Entry를 꺼내오고 컬렉션에서 제거함.
  - `Map.Entry<K,V> pollLastEntry()`: 제일 높은 Map.Entry를 꺼내오고 컬렉션에서 제거함
  - `NavigableSet<K,V> descendingKeySet()`: 내림차순으로 정렬된 키의 NavigableSet을 리턴
  - `NavigableMap<K,V> descendingMap()`: 내림차순으로 정렬된 Map.Entry의 NavigableMap을 리턴
  - `NavigableMap<K,V> headMap(K toKey, boolean inclusive)`: 주어진 키보다 낮은 Map.Entry들을 NavigableMap으로 리턴. 주어진 키의 Map.Entry 포함 여부는 두 번째 매개값에 따라 달라짐
  - `NavigableMap<K,V> tailMap(K fromKey, boolean inclusive)`: 주어진 키보다 높은 Map.Entry들을 NavigableMap으로 리턴. 주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐
  - `NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)`: 시작과 끝으로 주어진 키 사이의 Map.Entry들을 NavigableMap 컬렉션으로 반환. 시작과 끝 키의 Map.Entry 포함 여부는 두 번쨰, 네 번째 매개값에 따라 달라짐.
## Comparable과 Comparator
- TreeSet에 저장되는 객체와 TreeMap에 저장되는 키 객체는 저장과 동시에 오름차순으로 정렬(단, **객체가 Comparable 인터페이스를 구현**하고 있어야 가능)
  - Integer, Double, String 타입은 모두 Comparable을 구현하고 있음
  - 사용자 정의 객체를 저장 시 반드시 Comparable을 구현해야함.
  - Comparable 인터페이스에는 compareTo() 메소드가 정의되어 있음 -> 사용자 정의 클래스에서 이 메소드를 재정의해야함 
    - `int compareTo(T o)`: 주어진 객체와 같으면 0을 리턴, 주어진 객체보다 적으면 음수를 리턴, 주어진 객체보다 크면 양수를 리턴
- 비교 기능이 없는 Comparable 비구현 객체를 TreeSet/TreeMap에 저장하고 싶다면 **TreeSet과 TreeMap을 생성할 때 비교자를 제공**
  - `TreeSet<E> treeSet = new TreeSet<E>( new ComparatorImpl() );`
  - `TreeMap<K,V> treeMap = new TreeMap<K,V>( new ComparatorImpl() );`
  - 비교자: Comparator 인터페이스를 구현한 객체
    - Comparator 인터페이스에는 compare() 메소드가 정의되어 있음 -> 비교자는 이 메소드를 재정의해서 비교 결과를 정수 값으로 리턴
      - `int compare(T o1, T o2)`: o1과 o2가 동등하다면 0을 리턴, o1이 앞에 오게 하려면 음수를 리턴, o1이 뒤에 오게 하려면 양수를 리턴
# 6. LIFO와 FIFO 컬렉션
- 후입선출(LIFO): 나중에 넣은 객체가 먼저 빠져나감 (스택)
- 선입선출(FIFO): 먼저 넣은 객체가 먼저 빠져나감 ()

# 7. 동기화된 컬렉션
# 8. 수정할 수 없는 컬렉션
