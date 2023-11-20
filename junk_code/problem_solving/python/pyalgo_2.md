# 파이썬 문법
## 인덴트
- PEP 8(공식 가이드)에 따라 공백 4칸을 원칙
  - 첫번째 줄에 파라미터가 있다면, 파라미터가 시작되는 부분에 맞추기
  - 첫번째 줄에 파라미터가 없다면, 공백 4칸 인덴트를 한 번 더 추가하여 다른 행과 구분
## 네이밍 컨벤션
- 각 단어를 밑줄로 구분하여 표기하는 스네이크 케이스(vs 단어별로 대소문자를 구별하여 표기하는 카멜 케이스)
## 타입 힌트
- `def f n(a: int) -> bool:`
- mypy 패키지 활용 가능
## 리스트 컴프리헨션
- 파이썬은 map, filter와 같은 함수형 기능을 지원
  - `list(map(lambda x: x + 10 , [1, 2, 3]))`
- 기존 리스트를 기반으로 새로운 리스트를 만들어내는 리스트 컴프리헨션
  - `[n * 2 for n in range(1, 10 + 1) if n % 2 == 1]`
  ```python
  a = [] #별도의 리스트 변수를 필요로 함
  for n in range(1, 10 + 1):
  if n % 2 == 1:
  a.append(n * 2)
  print(a) #라인 수가 많이 증가.
  ```
- 딕셔너리 등도 가능
  ```python
  a = {}
  for key, value in original.items():
  a[key] = value
  ```
  - `a = {key : value for key, value in original.items()}`
## 제너레이터
- 루프의 반복 동작을 제어할 수 잇는 루틴 형태 (제너레이터만 생성해두고 필요할 때 언제든 데이터를 만들어낼 수 있음)
  - 이터레이터(반복 가능 객체)를 생성해주는 함수
- return: 값을 리턴하고 모든 함수의 동작을 종료 
- yeild: 값을 리턴하고 함수는 종료되지 않고 계속해서 맨 끝에 도달할 때까지 실행.
  - 리턴값: 제너레이터 객체
  - 다음 값을 생성하려면 next()로 추출
  - 여러 타입의 값을 하나의 함수에서 생성하는 것도 가능.
## range
- range()는 제너레이터 역할을 하는 range 클래스를 리턴
- for문에서 사용시, 제너레이터의 next()를 호출하듯 다음 숫자를 생성
- 2.x 버전까지는 숫자를 미리 생성해서 리스트로 리턴(제너레이터를 리턴하는 방식은 xrange()로 따로 존재)
- 생성된 값이 담겨있는 게 아니라 생성해야한다는 조건만 존재(메모리 점유율이 낮음)
- 미리 생성하지 않은 값도 인덱스에 접근이 가능(접근 시 바로 생성하도록 구현되어 있음)
## enumerate
- 여러가지 자료형(리스트, 튜플, 집합 등)을 인덱스를 포함한 enumerate 객체로 리턴(인덱스 자동 부여)
```python 
for i in range(len(a)): #전체 길이를 조회하여 루프를 처리하는 형태가 깔끔하지 않음
    print(i, a[i]) #불필요한 a[i]조회 작업

i = 0 #인덱스를 위한 변수를 별도로 관리->깔끔x
for v in a:
    print(i, v)
    i += 1

for i, v in enumerate(a):
    print(i, v)
```
## // 나눗셈 연산자
- 파이썬 2 이하 버전에서는 나눗셈 결과를 정수형으로 유지했었음.(3 이상 버전의 // 와 동일)
- //: 정수형 나눗셈 시 동일한 정수형을 결과로 리턴하면서 내림 연산자
- %: 나머지를 구하는 모듈로 연산자
- divmod(): 몫과 나머지를 동시에 구함(튜플로 반환)
## print
- 코테에서 디버깅(실무에서는 디버거, TDD-테스트 주도 방식을 사용)
- 인자를 콤마로 구분
- sep파라미터로 구분자 지정 가능(' '이 디폴트)
- end파라미터로 줄바꿈 제한 가능('\n'이 디폴트)
- join()으로 리스트의 요소를 하나의 문자열로 묶어서 출력 가능
- 변수 여러개를 출력
  - `print('{0}, {1}'.format(zero, one))`
  - f-string(3.6+지원): `print(f'abc{idx+1}:{alpha}')` 
## pass
- 코드 골격을 잡아놓고 시작할때 사용(목업 인터페이스부터 구현 후 추후 구현을 진행 가능)
- 널 연산: 아무것도 하지 않는 기능(인덴트 오류 등을 방지)
## locals
- 로컬 심볼 테이블 딕셔너리를 가져오는 메소드(업데이트도 지원) -> 디버깅(잘못 선언한 부분을 찾는 등)에 도움
- tip: pprint로 출력하면 줄바꿈 처리를 해줌

# 코딩 스타일
- \<clean code\>, \<프로그래밍 수련법\> 등의 책 참고
## 변수명과 주석
- 의미를 부여해 작명, PEP8 문서 기준에 따라 스네이크 케이스로 작성
- 상세한 (영어) 주석을 추천
## 리스트 컴프리헨션
- 가독성이 떨어지므로 줄바꿈을 곁들이기
- 표현식이 2개를 넘지 않아야 가독성이 떨어지지 않음

## 구글 파이썬 스타일 가이드
- 함수의 기본 값으로 가변 객체(Mutable Object) 사용x
  - 기본값으로 \[],{} 사용 지양: `def foo(a, b=[]): `,`def foo(a, b: Mapping = {}`
  - 대신 불변 객체를 사용: `def foo(a, b=None): if b is None: b = []`, `def foo(a, b: Optional[Sequence]=None): if b is None: b=[]`
  > - 파이썬 typing 모듈에 대한 글: https://www.daleseo.com/python-typing/
  > - 파이썬 Sequence 자료형: 문자열, 리스트, 튜플
- True, False를 판별할 때 암시적인 방법을 사용/정수를 처리할 때는 암시적인 방법보다는 직접 비교
  - 지양:`if len(users) == 0`, `if foo is not None and not foo:`, `if not i % 10:`
  - 지향:`if not users:`, `if foo == 0:`, `if i % 10 == 0:`, `if foo:`
- 세미콜론으로 줄을 끝내선 안됨, 세미콜론을 사용해 같은 줄에 두 문장을 쓰면 안됨.
- 최대 줄 길이는 80자

# 빅오, 자료형
- 입력값이 커질 때 알고리즘의 실행시간(시간 복잡도)과 함께 공간 요구사항(공간 복잡도)이 어떻게 증가하는지 분류 시 사용
- 시간 복잡도 분석시 상한 vs 최악, 함수의 동작을 설명하는 방법 중 하나인 분할 상환 분석

## 빅오
- 입력값이 무한대로 향할 때 함수의 상한을 설명하는 수학적 표기 방법
- 점근적 실행시간(시간 복잡도)을 표기
  - 시간 복잡도: 어떤 알고리즘을 수행하는데 걸리는 시간을 설명하는 계산 복잡도(대표적인 방법이 빅오)
- 빅오 표기법의 종류
  - $O(1)$: 입력값이 아무리 커도 실행시간은 일정(해시 테이블의 조회 및 삽입)
  - $O(log n)$: 이진검색
  - $O(n)$: 선형 시간 알고리즘, 정렬되지 않는 리스트에서 최댓값/최솟값을 찾는 경우
  - $O(n\times log n)$: 병합 정렬 등 대부분의 효율 좋은 정렬 알고리즘.
  - $O(n^2)$: 버블 정렬과 같은 비효율적인 정렬 알고리즘
  - $O(2^n)$: 피보나치수를 재귀로 계산하는 알고리즘
  - $O(n!)$: 외판원 문제(TSP)를 브루트 포스로 풀이하는 경우, 가장 느린 알고리즘.
- 알고리즘은 시간과 공간의 트레이드오프.
### 상한과 최악
- 빅오는 상한(Upper bound)을 의미(이외에 빅오메가(Lower Bound), 빅세타(평균)가 있음)
- 정확하게 쓰기에는 너무 길고 복잡한 함수를 적당히 정확하게 표현하는 방법일 뿐, 최악/평균의 경우의 시간복잡도와는 무관한 개념.(ex. 퀵정렬)
- 빅오 표기법은 주어진 경우의 수행시간의 상한을 나타냄(높게 잡아도 말은 되나, 아무런 의미가 없다)
### 분할 상환 분석
- 빅오가 지나치게 비관적인 관점이라는 이유로 분할 상환 분석 방법이 등장.
- ex. 동적 배열: 더블링이 일어나는 경우 O(n)이지만 확률상 낮음
- 최악의 경우를 여러 번에 걸쳐 골고루 나눠주는 형태
### 병렬화
- 일부 알고리즘은 병렬화로 실행속도를 높일 수 있음. 
- 알고리즘 자체의 시간 복잡도 외에 병렬화 가능성 또한 우수성의 평가 지표.

## 자료형
### 파이썬 자료형
- 파이썬3 표준 타입 계층 구조
  - None: class None Type
  - 숫자
    - 실수(class float)
    - 정수형: 정수(class int), 불리언(class bool)
  - 집합형 
    - 집합(class Set)
  - 매핑
    - 딕셔너리(class dict)
  - 시퀀스
    - 불변: 문자열(class str), 튜플(class tuple), 바이트(class bytes)
    - 가변: 리스트(class list)
- 숫자 
  - 정수형으로 int만을 제공, 파이썬2에서는 int가 고정 정밀도, long이 임의 정밀도 정수형이었음. 이후 int가 임의 정밀도를 지원하며 통합됨.(*임의정밀도: 정수를 숫자의 배열로 간주, 자릿수 단위로 쪼개어 배열 형태로 표현, 오버플로를 방지하는 기능과 안전을 위해 속도를 맞바꾼 셈*)
  - bool은 원래 논리 자료형이지만 내부적으로 1(True), 0(False)로 처리되는 int의 서브클래스.
> 임의 정밀도 정수형에 관한 글: https://rushter.com/blog/python-integer-implementation/
- 매핑: 키, 자료형으로 구성된 복합 자료형(딕셔너리)
- 집합: 중복된 값을 가지 않는 set(입력 순서 유지x)
```python
a = set() #빈 집합을 선언
b = {'a', 'b', 'c'} #값이 포함된 집합 선언(딕셔너리와 구분 요망)
```
- 시퀀스: 수열. 특정 대상의 순서 있는 나열. 
  - Immutable(불변): str(변수가 가리키는 값이 달라질 뿐, 그 값 자체는 불변-할당자의 처리를 허락하지 않음), tuple, bytes
  - Mutable(가변): List(동적 배열)
### 원시 타입
- C의 원시 타입: short, long, long long, unsigned short, unsigned long, unsigned long long, float, double, int, unsigned int
- 메모리에 정확하게 타입 크기만큼의 공간을 할당, 그 공간을 오로지 값으로만 채워 넣음.
- 배열의 경우 물리 메모리에 자료형의 크기만큼의 공간이 연속된 순서로 배치되는 형태로 할당.
- 자바의 경우, 원시 타입 뿐 아니라 원시 타입과 대응되는 객체를 지원-> 메모리에 숫자만 보관하고 있을 때는 하지 못했던 일들이 가능(문자로 변환, 16진수로 변환, 시프팅등)
`java -jar jol-cli/target/jol-cli.jar internals java.lang.Integer`
- 파이썬은 성능에 대한 우선순위보다 기능 제공에 우선순위를 둔 언어->원시 타입을 제공x

### 객체
- 파이썬은 모든 것이 객체
  - 불변 객체: bool, int, float, tuple, str
  - 가변 객체: list, set, dict
#### 불변 객체
- 파이썬에서 변수를 할당하는 작업은 해당 객체(문자, 숫자 등)에 대해 참조를 하는 것.
- 하나의 변수2가 (이미 존재하는) 상수를 가리키는 변수1을 참조 할당할 때, 상수, 변수1, 변수2에 id() 메서드를 적용하면 메모리 상에 위치한 객체의 주소가 모두 동일해지는 것을 확인 가능
- 불변 객체는 dict의 키나 set의 값으로 사용 가능.
#### 가변 객체
- list는 값이 바뀔 수 있으며, 다른 변수가 참조하고 있을 때 그 변수의 값 또한 변경됨.
> - C++의 참조 방식 vs 파이썬의 참조 할당 방식: C++은 완전한 참조, 파이썬은 일시적 참조(이후 값을 새로 할당(not 변경)하게 되면 더 이상 이전 변수를 참조하지 않고 새로운 객체를 참조하여 ID가 바뀜. 가변 객체의 경우에선 참조 대상의 변수도 변경 가능함.)
> - is 와 ==: is는 id()값을 비교하는 함수, ==는 값을 비교하는 연산자
#### 속도
- 파이썬 객체 구조는 설계와 기능 상에서 우수하지만 속도의 문제가 있음.
- ex. 정수형의 덧셈 연산을 하는 경우, 메모리에서 값을 꺼내 한번 연산하면 끝인 원시 타입에 비해 파이썬의 객체는 값을 꺼내는데 오래 걸림(var->PyObject_HEAD에서 타입 코드를 찾는 등의 부가작업)
> - %timeit 에서 %란?: line magic function(much like OS command-line calls: they get as an argument the rest of the line, where arguments are passed without parentheses or quotes)
https://ipython.readthedocs.io/en/stable/interactive/tutorial.html#magic-functions
> - 자료구조: 데이터에 효율적으로 접근하고 조작하기 위한 데이터의 조직, 관리, 저장 구조(배열, 연결리스트, 객체/자료형의 입장에서 복합 자료형)
> - 자료형: 컴파일러/인터프리터에게 프로그래머가 데이터를 어떻게 사용하는지를 알려주는 데이터 속성
> - 추상자료형: 자료형에 대한 수학적 모델, 해당 유형의 자료에 대한 연산들을 명기

## 리스트, 딕셔너리
### 리스트
- 순서대로 저장하는 시퀀스, 변경 가능한 목록(Mutable List)
- 내부로는 동적 배열로 구현(C++-std::vector, java-ArrayList)
- 파이썬 리스트 사용 시 스택vs큐 고민을 하지 않아도 됨. 
  - a.append(): $O(1)$
  - a.pop(): $O(n)$ #스택의 연산
  - a.pop(0): $O(n)$ #큐의 연산. 전체 복사가 이루어짐. 데크를 권장.
  - len(a): $O(1)$
  - a\[i]: $O(1)$
  - a\[i:j]: $O(k)$ #k=j-i
  - elem in a: $O(n)$ #순차탐색
  - a.count(elem): $O(n)$
  - a.index(elem): $O(n)$
  - del a\[i]: $O(n)$
  - a.sort(): $O(nlogn)$
  - min(a), max(a): $O(n)$
  - a.reverse(): $O(n)$

### 리스트의 활용 방법
```python 
a = list() #선언
a = [] #선언
a.append(1) #값을 추가(숫자, 문자, 불리언 등)
a.insert(2,0) #특정 위치의 인덱스를 지정해 요소 추가
a[0] #값을 꺼내오기(IndexError의 발생을 예외처리할 수 있음)
a[0:2:2] #슬라이싱(타언어의 인덱스 반복문이 불필요), [시작인덱스:종료인덱스:step]

del a[1] #인덱스로 삭제
a.remove(1) #값으로 삭제
a.pop(1) #값을 리턴 후 삭제
```
### 리스트의 특징
- 파이썬 리스트 = 연속된 공간에 요소를 배치하는 배열의 특성+다양한 타입을 연결해 배치하는 연결 리스트의 특성
  - 연결 리스트에 대한 포인터 목록을 배열 형태로 관리
- 원시 타입 자료형은 제공하지도 않음. 모든 것이 객체이기 때문에 리스트는 이들 객체에 대한 포인터 목록을 관리하는 형태로 구현되어 있음. 
```c
//cpython/Include/cpython/listobject.h
typedef struct {
	PyObject_VAR_HEAD
    PyObject **ob_item; #요소에 대한 포인터 목록
    Py_ssize_t allocated;
} PyListObject;
```
> - 파이썬 int 내부구조: https://kadensungbincho.tistory.com/64
> - 파이썬 리스트 내부구조: https://kadensungbincho.tistory.com/59
- 각 자료형의 크기는 저마다 다르기 때문에 연속된 메모리 공간에 할당이 불가능하므로 객체에 대한 참조로 구현 -> 인덱스 조회 시 모든 포인터의 위치를 찾아가 타입 코드를 확인, 값을 일일이 살펴봐야하는 추가작업이 필요(속도 희생)

## 딕셔너리
- (다양한 타입의)키/값 구조, 입력 순서 유지
- 내부적으로는 해시 테이블로 구현
- 파이썬의 딕셔너리는 C++(std::unordered_map), java(HashMap)과 다르게 모든 불변 객체를 모두 키로 사용 가능(해싱)
- 입력과 조회는 분할 상환 분석에 따른 경우 $O(1)$, 최악의 경우 $O(n)$
  - len(a): $O(1)$
  - a[key]: $O(1)$
  - a[key] = value: $O(1)$
  - key in a: $O(1)$
- 파이썬 3.6이하에선 입력 순서가 유지x (대신 collections.OrderedDict()을 사용), 파이썬 3.7부터 내부적으로 인덱스를 이용해 입력순서를 유지
- 파이썬 내의 딕셔너리 생성과 관련된 추가 모듈을 지원: collections 모듈
### 딕셔너리의 활용 방법
```python
>>> a = dict()
>>> a = {}
>>> a = {'key1':'value1'}
>>> a['key2'] = 'value2'
#존재하지 않는 키를 조회할 경우 KeyError발생, 이를 예외 처리 가능
#미리 키가 존재하는지 (key in a) 확인 후 작업 진행 가능
>>> for k,v in a.items(): #items()메소드로 키와 값을 각각 꺼내오기
		print(k,v)
>>> del a['key1']
```
### 딕셔너리 모듈(collections)
#### defaultdict 객체
- 존재하지 않는 키를 조회할 경우, 에러 메시지 출력 대신 디폴트 값을 기준으로 해당 키에 대한 딕셔너리 아이템을 생성.
- `>>> a = collections.defaultdict(int)`
#### Counter 객체
- 아이템에 대한 개수를 계산해 딕셔너리로 리턴(Counter객체)
- Counter 객체는 키에는 아이템 값, 값에는 아이템 개수가 들어간 딕셔너리를 생성하고 한번 더 래핑한 collections.Counter 클래스를 가짐.
  - most_common(): 가장 빈도 수가 높은 요소를 추출하는 메서드(**튜플**을 요소로 가진 **리스트**로 반환, 인풋으로 전달하는 숫자는 반환하는 요소의 수)
#### OrderedDict 객체
- 대부분의 언어에서 해시테이블을 이용한 자료형은 입력 순서 유지x, 3.7부터 지원(내부 인덱스를 사용); 입력 순서를 기대하는 것은 위험
> 타입 선언: 이름을 지정/기호를 사용(\[]:List, ():Tuple, {}:Dict, {1}:Set)

# 문자열 조작
- 문자열을 변경/분리하는 등의 여러 과정
- 로우레벨이나 C와 같은 문자형이 없는 언어에서는 조작이 까다로움
- 대부분의 언어는 기본적으로 문자열을 조작하는 다양한 기능을 제공
- 실무의 다양한 분야에서 쓰임
  - 정보 처리 분야(웹 페이지 탐색 시)
  - 통신 시스템 분야(문자 메세지, 이메일을 전송할 때)
  - 프로그래밍 시스템 분야(컴파일러, 인터프리터는 문자열을 해석,처리,변환하는 역할)

## 1. 유효한 팰린드롬
- 주어진 문자열이 팰린드롬인지 확인. 
- 대소문자 구분x
- 영문자와 숫자만을 대상으로 함
```python
#풀이1: 리스트로 변환
def valid_palindrome_1(s: str) -> bool:
    strs = []
    for char in s:
        if char.isalnum():
            strs.append(char.lower())
    while len(strs) > 1:
        if strs.pop(0) != strs.pop():
            return False
    return True

#풀이2: 데크 자료형 이용
import collections

def valid_palindrome_2(s: str) -> bool:
    strs = collections.deque()
    for char in s:
        if char.isalnum():
            strs.append(char.lower())
    while len(strs) > 1:
        if strs.popleft() != strs.pop():
            return False
    return True
    
#풀이3: 슬라이싱 사용
def valid_palindrome_3(s: str) -> bool:
    s.lower()
    s.re.sub('[^a-z0-9]', '', s)
    
    return s == s[::-1]
```
```c
//풀이4: C로 구현
bool valid_palindrome_c(char* s) {
    int bias_left = 0;
    int bias_right = 1;
    
    int str_len = strlen(s);
    for(int i = 0; i < str_len; i++) {
        while (!isalnum(s[i + bias_left])) {
            bias_left ++;
            if (i + bias_left == str_len)
                return true;
        }
        while (!isalnum(s[str_len - i - bias_right])) {
            bias_right ++;
        }
        if (i + bias_left >= strlen - i - bias_right)
            break;
        if (tolower(s[i + bias_left]) != tolower(s[str_len - i - bias_right]))
            return false;
    }
    return true;
}
```
- 문자열 슬라이싱: 내부적으로 빠르게 동작(위치를 지정하면 해당 위치의 배열 포인터를 얻게 되며 이를 통해 연결된 객체를 찾아 실제 값을 찾아냄)
  - 별도로 리스트로 매핑하는 과정을 거칠때 상당한 연산 비용이 필요.

## 2. 문자열 뒤집기
- 문자열을 뒤집는 함수를 작성하라. 입력값은 문자 배열, 리턴 없이 리스트 내부를 직접 조작
```python
def reverse_string_1(s: list[str]) -> None:
    left, right = 0, len(s) - 1
    while left < right:
        s[left], s[right] = s[right], s[left]
        left += 1
        right += 1

def reverse_string_2(s: list[str]) -> None:
    s.reverse()
    
def reverse_string_2_2(s: list[str]) -> None:
    s[:] = s[::-1]
```

## 3. 로그 파일 재정렬
- 로그를 재정렬하라.
  - 로그의 가장 앞 부분은 식별자
  - 문자로 구성된 로그가 숫자 로그보다 앞에 옴
  - 식별자는 순서에 영향x, 문자가 동일한 경우 식별자 순
  - 숫자로그는 입력 순서대로
```python
def reorder_log_files(logs: list[str]) -> list[str]:
    digits = []
    letters = []
    for log in logs:
        if log.split(" ")[1].isdigit():
            digits.append(log)
        else:
            letters.append(log)
    letters.sort(key=lambda x: (x.split()[1:], x.split()[0]))  
    return letters + digits
```
- 람다 표현식: 식별자 없이 실행 가능한 함수, 함수 선언 없이도 하나의 식으로 함수를 단순하게 표현 가능.
```python
s.sort(key=lambda x: (x.split()[1], x.split()[0]))

def func(x):
    return x.split()[1], x.split()[0]
s.sort(key=func)
```
## 4. 가장 흔한 단어
- 금지된 단어를 제외하고 가장 흔하게 등장하는 단어를 출력
- 대소문자 구분X, 구두점 무시
```python
import collections
def most_common_word(paragraph: str, banned: list[str]) -> str:
    words = [word for word in re.sub(r'[^\w]', ' ', paragraph)
             .lower().split() if word not in banned]
    counts = collections.defaultdict(int)
    for word in words:
        counts[word] += 1
    return max(counts, key=counts.get)
```
1. 대소문자, 쉼표 등의 구두점 -> 데이터 클렌징(전처리)가 필요 -> split 이전에 regex를 활용한 전처리 진행
2. count를 위해 딕셔너리를 사용하되, 키 값의 유무를 확인을 피하기 위해 defaultdict를 사용
```python
import collections

def most_common_word(paragraph: str, banned: list[str]) -> str:
    words = [word for word in re.sub(r'[^\w]', ' ', paragraph)
            .lower().split() if word not in banned]
    counts = collections.Counter()
    counts.most_common(1)[0][0]
```
## 5. 그룹 애너그램
- 문자열 배열을 받아 애너그램 단위로 그룹핑
```python
def group_anagrams(group: list[str]) -> list:
    anagram = collections.defaultdict(list)
    for word in group:
        anagram[''.join(sorted(word))].append(word)
    return list(anagram.values|())
```
## 여러 가지 정렬 방법
- 파이썬은 정렬 함수를 기본으로 제공
- 정렬 함수의 기능
  - sorted(): 반복가능한 객체를 인수로 받아서 정렬한 리스트를 (별도로) 리턴
    - key=(정렬을 위한 키, 함수-람다식)
  - sort(): 리스트 자료형이 제공하는 메서드, 제자리 정렬(In-place Sort)
- 팀소트 알고리즘 vs 폰 노이만의 병합정렬(안정정렬) vs 퀵정렬
  - 실제 데이터는 대부분 이미 정렬되어있을 것임을 가정하고 설계한 알고리즘
  - 삽입 정렬과 병합 정렬을 휴리스틱하게 조합해 사용하는 알고리즘 
  
## 6. 가장 긴 팰린드롬 부분 문자열
- 가장 긴 팰린드롬 부분 문자열을 출력
```python
def longest_palindrome_substring(string: str) -> str:
    def expand(left, right):
        while (left > 0 and right < len(string) 
               and string[left] == string[right]):
            left -= 1
            right += 1
        return string[left + 1:right]
    
    if len(s) < 2 or s == s[::-1]:
        return s
    
    result = ''
    for i in range(len(string)-1):
        result = max(result, expand(i, i+1), expand(i, i+2), key=len)
    
    return result 
```

## 유니코드와 UTF-8
- ASCII 인코딩: 1바이트(1비트는 체크섬)에 모든 문자를 표현 -> 한글,한자 같은 문자는 2개 이상의 특수문자를 합쳐서 표현하다보니 깨지는 경우 발생
- 유니코드 인코딩: 2~4바이트 -> 1바이트로 표현 가능한 문자들의 경우 메모리 낭비
  - 가변 길이 문자 인코딩: UTF-8
- 파이썬의 문자열 처리 방식의 변화(버전3 업데이트)
  - 유니코드 기반
  - 가변 인코딩 UTF-8: 시작 비트를 살펴보면 문자의 전체 바이트를 결정 가능(0, 10, 110, 1110, 11110)
> 유니코드 인코딩: 유니코드로 모든 문자열을 표현하지만, 파이썬에서는 내부적으로 UTF-8을 사용하지 않음. 
인덱스를 통해 개별 문자에 접근하기 어렵기 때문. 문자열 슬라이싱 등 원하는 문자에 인덱스로 접근할 수 있는 다양한 방식을 제공시 고정 길이 인코딩 방식이 필요.
>- 모든 문자열이 ASCII 범위 내에 있는 경우-Latin-1 인코딩(고정 1바이트 인코딩)
>- 이외의 대부분의 문자열-UCS-2(고정 2바이트 인코딩)
>- 특수 기호, 그림 이모티콘, 희귀언어-UCS-4(고정 4바이트 인코딩)

# 배열
- 메모리 공간 기반의 연속 Contiguous 방식/포인터 기반의 연결 Link 방식
- 배열: Contiguous 방식의 가장 기본이 되는 자료형 (Link 방식의 가장 기본이 되는 자료형은 연결리스트)
- 추상 자료형(ADT)의 실제 구현 대부분은 배열(큐) 또는 연결리스트(스택)를 기반으로 함
- (C언어 기준의) 배열은 크기를 지정, 해당 크기만큼의 연속된 메모리 공간을 할당받는 작업을 수행하는 자료형, 크기 고정, 한번 생성한 배열은 크기를 변경하는 것이 불가능
  - 특정 자료형도 컴파일러와 프로세서의 구조에 따라 바이트 크기가 상이
  - `sizeof(int)`로 사이즈 확인 가능, limits.h 헤더 파일에 크기가 정의되어있음 -보통 4바이트
  - 메모리에 대한 접근은 바이트 단위, 가리키는 주소는 1바이트마다 1씩 증가
  - 배열의 빅오= O(1)
  > - 메모리와 포인터: 32비트 머신의 포인터는 32비트, 64비트 머신의 포인터는 64비트
  > - 포인터: 메모리 영역을 1바이트 단위로 가리키는 주소
  > - 따라서 n비트 머신의 경우 2^n 이상 인식할 수 없음
- 실제 데이터에서는 전체 크기를 가늠하기 힘들 때가 많음(부족하거나 낭비되거나)
  - 크기를 지정하지 않고 자동으로 리사-이징하는 **동적 배열**
  - 프로그래밍 언어 별 동적 배열: ArrayList(자바), std::vector(C++), List(python)
  - 동적 프로그래밍 언어는 정적배열을 제공하지 않음(파이썬 등)
- 동적 배열의 원리: 미리 초깃값을 작게 잡아 배열 생성, 데이터가 추가되면서 꽉 채워지면 늘려주고 모두 복사.
  - 더블링: 보통 2배씩 늘려줌(모든 언어에 해당되는 것은 아님, 늘려가는 비율은 상이)
    - 파이썬의 더블링 구조: 동적 배열인 리스트의 구현은 Cpython의 listobject.c에 정의
    - 재할당 비율 = 그로스 팩터(성장인자)
    - 파이썬의 그로스 팩터는 초반에는 2배, 전체적으로는 1.125배 (자바는 1.5배, C++/ruby는 2배)
    - 더블링 시(최악의 경우), 새로운 메모리 공간에 더 큰 크기의 배열을 할당, 기존 데이터를 복사하는 작업이 필요 -> O(n) ; 자주 일어나는 일이 아니므로 분할 상환 분석에 따른 시간 복잡도로 계산하는 경우가 많음
```c
// cpython/Objects/listobject.c
// The growth pattern is: 0, 4, 8, 16, 25, 35, 58, 72, 88,...
new_allocated = (size_t)newsize + (newsize >> 3) + (newsize < 9 ? 3 : 6)
```

## 7. 두 수의 합
- 덧셈하여 타겟을 만들 수 있는 배열의 두 숫자 인덱스를 리턴
```python
#1. brute force
def two_sum(nums: List[int], target: int) -> List[int]:
	for i in range(len(nums)):
    	for j in range(i+1, len(nums)):
        	if nums[i]+nums[j] == target:
            	return [i, j]    	

#2. 합->차로 바꾸어 검색(in)
def two_sum_2(nums: List[int], target: int) -> List[int]:
	for i, num in enumerate(nums):
    	complement = target - num
        if complement in nums[i+1:]:
        	return [i, nums[i+1:].index(complement) + (i + 1)]

#3. 비교나 탐색을 한번에, 값이 아닌 키로 조회
def two_sum_3(nums: List[int], target: int) -> List[int]:
	nums_map = {}
    for i, num in enumerate(nums):
    	nums_map[num] = i
    
    for i, num enumerate(nums):
    	if target - num in nums_map and i != nums_map[target - num]:
        return [i, nums_map[target - num]]

#4. 조회 구조 개선
def two_sum_4(nums: List[int], target: int) -> List[int]:
    nums_map = {}
    for i, num in enumerate(nums):
        if target - num in nums_map:
            return [nums_map[target - num], i]
        nums_map[num] = i
```