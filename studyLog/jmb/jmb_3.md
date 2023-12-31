# 3. 코딩과 디버깅에 관하여
## 3.1 도입: 코딩의 중요성을 간과하지 말라
- 프로그래밍 대회에서 좋은 성적을 올리기 위한 비결: 빨리 코딩X, 읽기 쉬운 코드를 작성(정확한 작성과 디버깅에 유리)
- 간결하고 효율적인 프로그램을 작성하는 능력

## 3.2 좋은 코드를 짜기 위한 원칙
- 프로그래밍 대회에서 특히 중요하게 적용되는 원칙들과 예외들
### 간결한 코드를 작성하기
- 코드가 짧을수록 오타/단순 버그가 생길 우려가 줄어듬, 디버깅이 쉬워짐.
- (흑마법)전역 변수의 광범위한 사용, 매크로를 이용
```cpp
//일반적인 코드
bool hasDuplicate(const vector<int>& array) {
    for(int i = 0; i < array.size(); ++i)
        for(int j = 0; j < i; ++j)
            if(array[i] == array[j])
                return true;
    return false;
}
//매크로 흑마법 사용 코드
#define FOR(i, n) for(int i = 0; i < (n); ++i)
bool hasDuplicate(const vector<int>& array) {
    FOR(i, array.size())
        FOR(j, i)
            if(array[i] == array[j])
                return true;
    return false;
}
```
- 이중 for문에서 증감식에서 변수를 착각하는 일을 없앨 수 없음.
- 실수를 피해 가는 올바른 방법: 배열의 인덱스를 반복문으로 순회하는 대신 java, C#에서처럼 foreach 구문을 사용하는 것.
### 적극적으로 코드 재사용하기
- 간결한 코드 -> 모듈화(함수, 클래스로 분리)
  - n번이상 등장하면 분리한다는 기본 원칙을 세우면 좋음
  - 실무에서 이상적인 코드: 한 함수가 두 가지 이상의 일을 해서는 안됨(분리가 필요)
### 표준 라이브러리 공부하기
- 큐, 스택과 같은 자료구조, 정렬 등의 기초 알고리즘을 직접 작성하는 것은 시간 낭비
- 표준 라이브러리는 셀 수 없을 정도로 많이 사용되고 검증 -> 메모리 관리, 정당성 증명이 검증됨.
### 항상 같은 형태로 프로그램을 작성하기
- 여러 종류의 코드를 반복적으로 짜게 됨->같은 코드를 다양한 방식으로 짜봄.
- 알아보기 쉬운 코드를 작성하는데 도움이 되지만 코드 검증에는 어려움. 그래야 **도구가 아닌 문제에 집중 가능**
### 일관적이고 명료한 명명법 사용하기
- 모호하지 않은 변수명, 함수명을 사용하기
- 사용하는 언어의 표준 라이브러리에서 사용하는 명명 규약 익히기.
  - `bool judge(int y, int x, int cy, int cx, int cr)` 대신 `bool isInsideCircle(int y, int x, int cy, int cx, int cr)`사용
### 모든 자료를 정규화해서 저장하기
- 같은 자료를 두 가지 형태로 저장하지 않는 것.
- ex. 축과 점이 이루는 각도/유리수를 표현하는 클래스 Fraction -> 기약분수로 표현해야 같은 자료가 두 개 이상의 표현을 가지지 않음
  - 문자열 표현이 달라지고, 해시값이 달라지는 등의 문제로 인한 버그 발생 가능
- ex. 프로그램이 시간을 표현할 경우 어떤 시간대로 저장되는지(썸마타임 등) 섞이기 일쑤 -> 표준에서 표시한 시간과 시간대의 조합으로 저장
- ex. 입력에 문자열 인코딩이 섞여있을 수 있으니 가능한 한 UTF-16 이나 UTF-8 인코딩으로 변환해야 다루기 쉬움
- 정규화는 프로그램이 자료를 입력받거나 계산하자마자(생성자) 곧장 이루어져야함.
### 코드와 데이터를 분리하기
- 날짜를 다루는 프로그램에서 영문이름으로 출력할 때 코드의 논리(if)와 상관없는 데이터는 배열 등으로 분리하여 다루기.
  - `const string monthName[] = { "January", "February", ...}`
  - `int daysIn[12] = { 31, 28, ...}`
- 체스 같은 보드 게임은 말의 움직임을 다룰 때 움직일 수 있는 위치를 프로그램(if문 등)으로 작성하는 대신 움직일 수 있는 상대좌표를 배열에 저장해두면 좋음
  - `const int knightDx[8] = { 2, 2, -2, -2, 1, 1, -1, -1};`
  - `const int knightDy[8] = { 1, -1, 1, -1, 2, 2, 2, -2};`

## 3.3 자주 하는 실수
- 실수에서 배우기, 남의 실수로부터 배우기
### 산술 오버플로
### 배열 범위 밖 원소에 접근
- C/C++는 배열의 원소에 접근시 인덱스 범위 체크를 해주지 않음 (속도에는 좋지만 버그 찾기 힘듦)
  - 런타임 스택을 건드려서 런타임 오류를 내고 종료->디버깅 가능
  - 오류가 나지 않으면서 틀린 닶->디버깅 힘듦
  - `int array[10], t;`: 메모리 상에 연속해서 위치하게 되는 경우 -> 덮어쓰기가 되면서 찾기 어려운 버그 발생
  - 배열 크기를 정할 때 신중한 계산을 할 것(시작위치가 0인 것과 1인 것을 혼동)
### 일관되지 않은 범위 표현 방식 사용하기
- 배열 위치 참조 오류의 원인 -> 프로그램 내에서 여러 가지의 범위 표현 방식을 섞어서 씀
- 닫힌 구간 vs 열린 구간
  - 닫힌 구간은 공집합을 우아하게 표현할 수 있는 방법이 없다는 단점.
  - 열린 구간은 배열의 첫번째 원소부터 시작하는 범위(배열 인덱스이 0부터 시작하는 범위)를 표현하고 싶을 때 음수 인덱스를 사용해야한다는 단점
- 반 열린 구간을 사용: [lo, hi)
  - 배열 a의 인덱스 범위: 0 ~ n-1 (0<=i\<n)
  - C++ STL 반복자로 범위 표현시 begin()은 첫번째 원소, end()는 마지막 원소 다음의 가상의 원소를 가리킴.
  - 자바 SortedSet 인터페이스는 범위를 fromElement(범위에 포함o), toElement(범위에 포함x)로 전달받음.
  - 파이썬 리스트 인덱싱에서도 끝나는 숫자는 포함하지 않는 부분 배열을 얻음.
- 장점: 공집합인 텅 빈 구간을 쉽게 표현 가능, 두 구간의 연속을 쉽게 확인 가능, 구간의 크기를 쉽게 측정 가능
- 자연어에서 사용하는 범위와 차이가 있음 -> 함수 내에서 사용하는 표현방법과 함수 밖에서 사용하는 표현방법에 차이가 있다면 혼란이 생김 -> 프로그램 내에서 한 가지 방법(프로그래밍 언어가 지원하는 범위 표현 방식)으로만 범위를 표현할 필요o 
### Off-by-one 오류
- 계산의 큰 줄기는 맞지만 하나가 모자라거나 많아서 틀리는 코드의 오류들
- 반복문에서 <, >, <=, >= 연산자를 혼동하여 원소를 하나 더 적게/많이 순회하는 경우나 반 열린 구간과 닫힌 구간을 혼용해쓴 경우에 발생.
- 최소 입력이 주어졌을때 코드가 어떻게 동작할지 되새겨보며 프로그램을 짜기.
### 컴파일러가 잡아주지 못하는 상수 오타
- 코드와 데이터를 분리하기 위해 데이터를 별도의 상수 배열에 저장할 때 오타 발생시 찾기 어려움
- 출력할 문자열 상수를 잘못 쓰는 경우
- 계산해야할 값이 아주 큰 경우 큰 수 M으로 나눈 나머지를 대신 계산하는 문제에서 M의 자릿수를 틀리게 쓰는 경우
- 64비트 정수형에 들어갈 상수를 쓰면서 해당 상수가 64비트라고 지정하지 않는 경우 오버플로 발생 가능
### 스택 오버플로
- 콜 스택이 오버플러해서 프로그램이 강제 종료되는 것.
- 대개 재귀 호출의 깊이가 너무 깊어져서 생김.
- 사용하는 환경의 스택 허용량을 체크(스택 최대 크기는 컴파일이나 실행시에 설정 가능)
- C++: 지역 변수로 선언한 배열, 클래스 인스턴스가 기본적으로 스택 메모리를 사용 -> 힙에 메모리를 할당하는 STL 컨테이너 or 전역 변수를 사용
### 다차원 배열 인덱스 순서 바꿔쓰기
- ex. 동적 계획법을 위한 메모이제이션 패턴을 사용시 
- 특정 배열에 접근하는 위치를 하나로 통일
### 잘못된 비교 함수 작성
- 정수의 집합을 저장하는 IntegerSet 클래스, `vector<IntegerSet>`에 담긴 집합들을 순서대로 처리하도록 정렬하는(`<`연산자 오버로딩) 함수->A가 B의 진부분집합일 경우 A가 B보다 항상 먼처 처리되어야하는 규칙
```cpp
bool isProperSubset(const IntegerSet& a, const IntegerSet& b);
bool operator < (const IntegerSet& a, const IntegerSet& b) {
    if(isProperSubset(a, b)) return true;
    if(isProperSubset(b, a)) return false;
    return false;
}
```
- C++ 표준 라이브러리는 `<`연산자의 성질이 유지된다고 예상함.
  - 비반사성: `a < a`는 거짓
  - 비대칭성: `a < b`가 참이면 `b < a`는 거짓
  - 전이성: `a < b`가 참이고 `b < c`가 참이면 `a < c`
  - 상등 관계의 전이성: `a < b`가 거짓이고 `b < a`가 거짓인 경우 `a == b`, `a == b`이고 `b == c`이면 `a == c`
- a와 b가 완전히 같은 경우를 제외하고는 어느때도 두 집합이 같다고 판단하지 않는 것 (두 조건문의 조건이 모두 거짓일 때 두 집합을 같다고 판단한 것과 달리)
```cpp
bool operator < (const IntegerSet& a, const IntegerSet& b) {
    if(isProperSubset(a, b)) return true;
    if(isProperSubset(b, a)) return false;
    if(a.size() != b.size()) return a.size() < b.size();
    return lexicographical_compare(a.begin(), a.end(), b.begin(), b.end());
}
```
- 크기 비교만으로 주어진 조건에 맞는 정렬은 가능
> 자바의 표준 라이브러리는 < 연산 대신에 <=연산을 비교 함수의 모델로 씀.
> - .NET 표준 라이브러리는 불린값 대신 정수를 반환(양수, 음수, 0)하는 것으로 자바의 문제를 해결
### 최소, 최대 예외 잘못 다루기
- 예외: 우리가 예상한 입력의 규칙에 들어맞지 않는 모든 입력 -> 광범위
  - 가능한 입력 중 최소값과 최대값이 예외가 되는 문제들에 한해서는 오류를 잡을 수 있는 경우가 많음
- 자연수를 입력받아 소수인지 판정하는 함수
```cpp
bool isPrime(int n) {
    if(n == 2) return true; //소수가 아닌 가장 작은 입력인 1을 처리하지 못함.
    if(n % 2 == 0) return false; //소수인 가장 작은 입력인 2를 처리하지 못함.
    for(int i = 2; i < n; ++i)
        if(n % i == 0)
            return false;
    return true;
}
```
### 연산자 우선순위 잘못 쓰기
- 시프트 연산자, 비트 단위 연산자들의 우선순위가 헷갈리는 경우 -> 괄호로 감싸기
- `if(b & 1 == 0)`: &는 ==보다 우선순위가 낮음
### 너무 느린 입출력 방식 선택
- 텍스트를 입출력할 수 있는 다양한 방법을 제공, 입/출력 변수의 수가 1만개를 넘어가면 체크할 필요o
- C++: 저수준 입출력 방식 `gets()` vs 고수준 입출력 방식 `cin`
### 변수 초기화 문제
- 프로그램을 한번만 실행; 한번에 여러 개의 입력에 대해 답을 처리하기를 요구 -> 이전 입력에서 사용한 전역 변수 값을 초기화하지 않고 그대로 사용하는 실수
- C/C++의 전역변수나 다른 언어들에서의 멤버 변수들은 생성시에 모두 기본값으로 초기화됨 -> 별도의 초기화를 직접 하지 않고 의존하는 경우 두번째 입력부터 오답 발생 가능.
- 예제 입력 파일을 몇번 반복해 쓰면 대부분 검증이 됨.
## 3.4 디버깅과 테스팅
### 디버깅에 관하여
- 프로그램을 작성하고 예제 입력을 실행 후 다른 결과가 나왔을때 -> 디버거를 켜고 프로그램이 실행되는 과정을 추적
  - 짧은 소스는 눈으로 읽어내려가며 디버깅 가능.
  - 재귀 호출 or 중복 반복문을 많이 사용하는 복잡한 코드는 디버거로 디버깅하기 적당하지 않음
  - 잘 분리된 기능적인 코드를 짜기
- 디버거 대용
  - 작은 입력에 대해 제대로 실행되나 확인
  - 단정문 사용: 주어진 조건이 거짓일 때 오류를 내고 프로그램을 강제 종료시키는 함수 또는 구문
  - 프로그램의 계산 중간 결과를 출력
- 프로그램이 런타임 오류를 내고 종료하는 경우는 디버거를 사용해도 좋음
### 테스트에 관하여
- 주어진 예제 입력을 약간 바꿔서 넣거나, 있을 수 있는 가장 작은 입력과 큰 입력을 만들어 넣어보고 시간안에 실행되는지와 정답 여부를 테스트
- 스캐폴딩: (뼈대를 잡기 위한) 임시 구조물, 코드의 정당성을 확인하거나 반례를 찾는데 유용하게 쓰임.
- ex. 직접 작성한 정렬 함수를 테스트 할때 잘못 동작하는 입력을 찾아내는 자동화 코드
```cpp
void mySort(vector<int>& array);
String toString(const vector<int>& array);
int main() {
  while(true) {
    int n = rand() % 100 + 1;
    vector<int> input(n);
    for(int i = 0; i < n; ++i)
        input[i] = rand();
    vector<int> mySorted = input;
    mySort(mySorted);
    vector<int> reference = input;
    sort(reference.begin(), reference.end());
    if(mySorted != reference) {
        cout << "Mismatch!" << endl;
        cout << "Input: " << toString(input) << endl;
        cout << "Expected: " << toString(reference) << endl;
        cout << "Got: " << toString(mySorted) << endl;
    }
  }
}
```
- 코드를 비교할 대상(ex.표준라이브러리)이 없는 경우 작은 입력에서만 동작하는 더 느리지만 단순한 알고리즘을 사용해 답안을 검증.
- 산술 오버플러 같은 오류들은 큰 예제에서만 등장->스캐폴딩으로 검출x
## 3.5 변수 범위의 이해
### 산술 오버플로
- 컴퓨터의 유한성이라는 제한. 수학에서와 달리 변수에 담을 수 있는 숫자에 제한O -> 산술 오버플로 때문(어떤 식의 계산 값이 반환되는 자료형의 표현 가능한 범위를 벗어나는 경우)
  - 이유1) 대부분의 프로그래밍 언어는 사칙연산 과정에서 오버플로를 확인해주지 않음(비효율적이기때문)
  - 이유2) 프로그램의 정당성 검증 시 논리의 정확성에만 집중하기 쉽기 때문
- 현대의 많은 언어들에서는 표준 라이브러리에서 메모리가 허락하는 한도내에서 가능한 한 큰 정수를 구현하는 클래스를 제공
### 너무 큰 결과
- 프로그램이 출력해야할 결과가 흔히 사용하는 32비트를 넘어가면 64비트를 사용해야함. 
### 너무 큰 중간 값
- 프로그램 출력 값의 범위는 작지만 중간 과정에서 큰 값을 일시적으로 계산해야하는 경우. 
- ex. 최소 공배수를 구하는 과정에서 $lcm(a,b) = \frac {a\times b}{gcd(a,b)}$
```cpp
int gcd(int a, int b);
int lcm(int a, int b) {
    return (a * b) / gcd(a, b); //중간값 a*b이 오버플로를 만듦
}
```
### 너무 큰 '무한대'값
- 프로그램을 짜다보면 무한대에 해당하는 큰 값을 이용하는게 편리할 때가 존재.
- ex. 두 위치를 잇는 가장 짧은 길을 구할 때(중간 지점을 거쳐야할 때) -> $dist(s,t) = min \begin{cases} dist(s,a)+dist(a,t)\\ dist(s,b)+dist(b,t)\\ dist(s,c)+dist(c,t) \end{cases}$
  - 두 구간을 잇는 경로가 존재하지 않음 -> 예외처리를 따로 해서 특수한 값을 사용하거나 min()에서 자동으로 걸리지도록 매우 큰 값을 사용 
    - 후자를 택하는 경우 해당 자료형이 처리할 수 있는 가장 큰 값을 쓰는 경우 산술 연산이 추가로 행해지는 경우 오버플로 발생 
    - $2^30$에 가까우면서 오타확인에 용이한 987654321을 이용
### 오버플로 피해가기
- 오버플로 발생 사실을 알았을때 코드 고치기
  - 더 큰 자료형을 사용
    - `int lcm(int a, int b) { return (a * (long long)b) / gcd(a, b); }`
  - 오버플로가 나지 않도록 연산의 순서를 바꾸기-괄호 사용
    - `int lcm(int a, int b) { return a * (b / gcd(a, b)); }`
  - 문제에 따라 계산 방법을 다르게 해 오버플로를 피해가는 방법
    - 이항 계수 $\binom{n}{r} = \frac {n!}{(n-r)!r!}$ 계산 시 점화식 이용 ($\binom{n}{r} = \binom{n-1}{r-1} + \binom{n-1}{r}$)
### 자료형의 프로모션
- 프로모션: 이항 연산자들이 받는 두 개의 피연산자의 자료형이 서로 다르거나 자료형의 범위가 너무 작은 경우 이들을 같은 자료형으로 변환해서 계산
  - C++의 규칙
    1. 정수형 & 실수형 -> 모두 실수형
    2. 둘 다 정수형/둘 다 실수형 -> 보다 넓은 범위를 갖는 자료형
    3. 둘 다 int형보다 작은 정수형 -> int형
    4. 부호 없는 정수형 & 부호 있는 정수형 -> 부호 없는 정수형
  ```cpp
  unsigned char a = 17;
  short b = -18;
  int c = 2;
  unsigned int d = 0;
  cout << (a + b) * c + d << endl;
  ```
  - 부호 없는 정수형으로 프로모션된 결과 변수에 음수가 저장되면 오버플로가 일어남.
  ```cpp
  bool isSorted(const vector<int>& seq) {
      for(int i = 0; i < seq.size()-1; ++i)
          if(seq[i] > seq[i+1])
              return false;
      return true;
  }
  ```
  - STL에서 모든 컨테이너의 size()는 부호 없는 정수형(size_t)를 반환하여 연산결과가 seq.size()-1은 부호 없는 정수형으로 캐스팅 됨 -> 배열이 비어있는 경우 (-1을 부호 없는 정수형으로 강제 캐스팅하여 $2^32-1$이 되어) 문제가 됨.
    - seq[]가 비어 있는 경우를 처음에 예외로 처리
    - seq.size()를 int형으로 변환
    - i를 1부터 시작하고 조건문을 seq[i-1]>seq[i]로 변경
    - C#에서는 컨테이너의 크기가 부호 있는 정수로 반환, java에서는 부호 없는 정수를 언어차원에서 지원하지 않음 -> 부호 관련 프로모션에 대해서 신경쓸 필요 없음.
## 3.6 실수 자료형의 이해
### 실수 연산의 어려움
- [1, n]범위의 모든 자연수 중 $\frac {1}{x} \times x = 1$인 x의 수를 세는 구현
```cpp
int countObvious(int n) {
    int same = 0;
    for(int x = 1; x <= n; ++x) {
        double y = 1.0 / x;
        if(y * x == 1.0)
            ++same;
    }
    return same;
}
```
### 실수와 근사 값
- 일상적으로 다루는 정수형는 컴퓨터가 정확하게 표현 가능
- 실수는 무한소수 등 무한한 값을 유한한 메모리에 정확하게 담을 수 없어서 근사값을 사용(컴퓨터의 모든 실수 변수는 정확돠 제한된 근사값을 저장)
  - 근사값으로 연산한 결과는 수학적으로 정확하지 않을 수 있기 때문에 실수를 다루기 까다로워짐.
    - 어떤 순서로 계산하는지
    - 컴파일러 최적화는 켰는지
    - 중간에 로그 메시지를 출력하는지
    여부에 따라 계산할 때마다 답이 달라질 수 있음
### IEEE 754 표준
- 이진수를 실수로 표기
- 부동소수점 표기법
- 무한대, 비정규 수, NaN 등의 특수한 값이 존재
- 그 외: 실수 연산에 관한 규정, 오버플로와 언더플로의 처리, 반올림에 관한 규정 등
### 실수의 이진법 표기
- 십진법 표기: 소수점 밑 i번째 자리의 크기= $\frac {1}{10^i}$
- 이진법 표기: 소수점 밑 i번째 자리의 크= $\frac {1}{2^i}$
### 부동소수점 표기
- 사용 가능한 비트의 공간을 이용해 정수부와 소수부를 배분하는 법
  - 고정된 분할(고정 소수점 실수 표기법)-> 모두를 만족시킬 수 있는 분할이 존재하지 않음
  - IEEE 754를 포함한 대부분의 실수 표준에서는 소수점을 옮길 수 있도록 함-> 어떤 형태의 숫자건 소수점을 적절히 옮겨서 소수점 위에 한 자리만 남도록 한 후(소수점을 몇 칸이나 옮겼는지 기록), 최상위 비트에서부터 표현할 수 있는 만큼 표시 후 나머지는 반올림 처리.
    - 부호 비트, 지수(소수점을 몇 칸 옮겼는지), 가수(소수점을 옮긴 실수의 최상위 X비트)
    - 지수와 가수에 각각 몇 비트를 써야하는가 -> 가수 > 지수
- 부동소수점 표기 방식: 소수점을 옮길 수 있는 개수에 따라서 표현할 수 있는 숫자의 범위가 정해짐.
  - 32비트: (부호:1, 지수:8, 가수:23) -> 유효십진수자릿수(6)
  - 64비트: (부호:1, 지수:11, 가수:23) -> 유효십진수자릿수(15)
  - 80비트: (부호:1, 지수:15, 가수:64) -> 유효십진수자릿수(18)
### 실수 비교하기
- 이진법으로 표현할 수 없는 형태의 실수는 근사값으로 저장되므로 이때 생기는 작은 오차가 비교 연산 계산 과정에서 다른 결과를 가져옴.
- 두 실수 값이 같은지 비교할 때는 항상 어느 정도의 오차를 염두에 두고 작성
```cpp
bool absoluteEqual(double a, double b) { 
    return fabs(a - b) < 1e-10; //fabs()는 주어진 실수의 절댓값을 반환
}
```
- 하지만 작은 오차보다 커지는 경우($\frac {10^20}{x} \times x == 10^20$ 에서 중간과정 중 반올림되는 부분에서 오차가 발생)
#### 하나. 비교할 실수의 크기들에 비례한 오차 한도를 정한다
- 실제 입력으로 들어올 최대값과 최소값을 대략 예측 가능, 크게 차이 나지 않는 경우 하나의 오차 한도 값을 사용 가능
  - 같다고 판단해야하는 값들은 오차가 좀 있더라도 같게 판단할 수 있을만큼 커야함
    - 
  - 다르다고 판단해야하는 값들은 오차가 좀 있더라도 다르게 판단할 수 있을만큼 작아야함.


