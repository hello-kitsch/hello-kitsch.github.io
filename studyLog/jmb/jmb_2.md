# 2. 문제 해결 개관
## 2.1 도입
- 무작정 알고리즘을 외우고 문제를 푼다고 문제 해결 실력이 쌓이는 것은 아님
- 문제 해결 능력: 언어나 알고리즘처럼 명확히 정의된 실체가 없는 추상적인 개념, 단순한 반복만으로는 연마하기 어려움.
- 자신이 문제를 어떤 방식으로 해결하는지를 의식하고, 어느 부분이 부족한지, 어떤 부분을 개선해야 할지 파악해야함.
  - 과정을 여러 부분으로 나눠보고 각 과정을 자신이 잘하고 있는지, 잘하지 못하고 있다면 어떤 방향으로 개선해야 하는지를 끊임없이 파악해야함.
## 2.2 문제 해결 과정
### 파인만 알고리즘
  1. 칠판에 문제를 적는다.
  2. 골똘히 생각한다.
  3. 칠판에 답안을 적는다.
  - 문제 해결 과정을 단계별로 나누는 아이디어: 해결하기 위해 거쳐 가야 하는 과정들을 세분화함으로써, 어디가 부족하고 어디를 개선해야 하는지 판단할 수 있게됨. 문제를 적는 단계(읽고 이해, 자신의 언어로 재정의)
### 어떻게 문제를 풀 것인가
  1. 문제를 이해한다.
  2. 어떻게 풀지 계획을 세운다.
  3. 계획을 수행해서 문제를 해결한다.
  4. 어떻게 풀었는지 돌아보고, 개선할 방법이 있는지 찾아본다.
### 프로그래밍 대회를 위한 여섯 단계 문제 해결 알고리즘
1. 문제를 **읽고 이해**한다.
  - 문제 설명을 공격적으로 읽으며 문제가 원하는 바를 완전히 이해하는 과정이 반드시 필요
  - 문제의 궁극적인 목적을 옳게 이해하더라도 사소한 제약 조건을 잘못 이해하면 풀 수 없게 되는 문제들이 흔함.
2. 문제를 익숙한 용어로 **재정의**한다.
  - 자신이 다루기 쉬운 개념을 이용해 문제를 자신의 언어로 풀어 쓰는 것.
  - 문제의 추상화(현실 세계의 개념을 우리가 다루기 쉬운 수학적,전산학적 개념으로 옮겨 표현하는 과정)
  - 문제의 본질: 어떤 방식으로 재구성하느냐에 따라 같은 일을 하는 프로그램이라도 전혀 다른 문제로 받아들여질 수 있음. 
  - 어떤 부분을 추상화할 것인지를 선택하는 작업, 문제를 재정의하는 방법들에 대한 고찰
3. 어떻게 해결할지 **계획**을 세운다.
  - 문제를 어떤 방식으로 해결할지 결정, 사용할 알고리즘과 자료구조를 선택 (가장 중요한 단계)
4. 계획을 **검증**한다.
  - 구현을 시작하기 전에 계획을 검증하는 과정
  - 모든 경우에 요구 조건을 정확히 수행하는지 증명, 수행에 걸리는 시간과 사용하는 메모리 문제가 제한내에 맞는지.
5. 프로그램으로 **구현**한다.
  - 구현이 부정확하거나 비효율적이면 프로그램은 정확히 동작할 수 없음
6. 어떻게 풀었는지 돌아보고, **개선할 방법**이 있는지 찾아본다.
  - 문제를 한번만 풀어서는 그 문제에서 배울 수 있는 것들을 다 배우지 못함(효율적인 알고리즘, 간결한 코드)
  - 문제 해결 기술은 의사코드도 엄밀한 증명도 없는 추상적인 기술->이 기술들을 어떻게 사용하고 있는지 회고하고 개선할 필요o.
  - 문제를 풀 때마다 코드+자신의 접근과 꺠달음+오답 원인을 기록
  - 다른 사ㅏ람의 코드를 보면서 통찰과 자극을 얻기
### 문제를 풀지 못할 때
- 일정 시간이 지나도록 고민해도 답을 찾지 못할 때->다른 사람의 소스코드나 풀이를 참조 + 복기(접근, 왜 떠올리지 못했는지)
## 2.3 문제 해결 전략
### 직관과 체계적인 접근
- 직관: 해당 문제를 해결하는 알고리즘이 대략적으로 어떤 형태를 가질지를 짐작하게 해줌
- 체계적인 방법: 백지에서부터 시작해 문제를 해결하기 위한 기반을 차근차근 쌓아올림
### 체계적인 접근을 위한 질문들
#### 비슷한 문제를 풀어본 적이 있던가?
- 문제의 목적을 보고 적절한 접근방법을 선택하기 위해서는 어떤 문제가 최적화 문제인지, 경우의 수를 구하는 문제인지, 검색 문제인지 등을 분류하는 방법을 익히고 각 알고리즘들이 어느 경우에 사용될 수 있는지 체계적으로 공부
- 최단 경로 문제 -> 조건들이 붙는 문제(한도시를 두번 방문x~가장 긴 경로, 기차를 네번이하로 갈아타기~가장 짧은 경로, 역 간 운행거리중 가장 긴 구간이 가장 짧은 경로, 역 간 운행거리중 가장 짧은 구간이 가장 긴 경로, 가장 긴 구간과 가장 짧은 구간의 길이 차이가 가장 적은 경로)
- 형태가 비슷하거나 문제의 목표가 같은 경우 등 문제의 목적을 보고 적절한 접근 방법을 선택하기 위해서는 어떤 문제가 최적화 문제인지, 경우의 수나 확률을 구하는 문제인지, 검색 문제인지 등을 분류하는 방법을 익히고 각 알고리즘들이 어느 경우에 사용될 수 있는지 체계적으로 공부해야함. 
#### 단순한 방법에서 시작할 수 있을까?
- 무식하게 풀 수 있을까?: 시간과 공간제약을 생각하지 않고 문제를 해결할 수 있는 단순한 알고리즘을 만들기
  - 간단히 풀 수 있는 문제를 너무 복잡하게 생각해서 어렵게 푸는 실수를 예방
  - 효율적인 알고리즘이라도 단순한 알고리즘을 기반으로 구성(효율적인 자료구조, 중복 계산을 피하는 등의 최적화)된 경우가 많기 때문.
  - 알고리즘 효율성의 기준선을 정해주는 효과가 있음
- ex. N(<=30)개의 사탕(무게=20이하의 정수)을 세 명의 어린이에게 최대한 공평하게 분배. (공평함의 기준=총 무게가 가장 무거운 어린이-총 무게가 가장 가벼운 어린이) -> 완전탐색($3^N$) -> 각 어린이가 가진 사탕의 양을 표현하는 세 개의 정수를 하나의 상태로 나타내고 각 어린이가 가진 사탕의 총량을 상태 공간으로 하여 너비 우선 탐색 진행.
  - 실제로 가진 사탕이 달라도 무게가 같은 경우 하나의 상태로 취급 -> $(20\times N + 1)^3 \leq 601^3$
  - 가장 많이 받은 어린이의 무게 이상의 상태는 무시 가능 -> $(\frac {20\times N}{3} + 20)^3 \leq 220^3$ -> 순서가 없는 조합문제이므로 오름차순으로 정렬되어 있는 경우만 탐색(1/6로 줄어듬)
#### 내가 문제를 푸는 과정을 수식화할 수 있을까?
- 번뜩이는 영감이 필요한 문제를 만났을 때 -> 손으로 여러 간단한 입력(주어진 예제 입력)을 직접 해결해보며 공식화 or 고려해야할 점, 간과한 점을 알게 됨.
#### 문제를 단순화할 수 없을까?
- 주어진 문제의 좀 더 쉬운 변형판을 먼저 풀어보기
  - 문제의 제약 조건 없애기
  - 계산해야 하는 변수의 수 줄이기
  - 다차원의 문제를 1차원으로 줄이기
- 단순화된 문제의 해법이 원래 문제의 해법에 대한 직관을 제공하거나 직접적으로 해법을 제공 가능
- 예제: 가로선 혹은 세로선을 따라서만 움직일 수 있을때(거리 = x좌표차의 차 + y좌표의 차) 주어진 N개의 점들의 거리 합이 최소가 되는 점의 위치 찾기
  - 1차원 형태로 바꾸어서 생각하여 후보 위치의 왼쪽에 있는 점의 수와 오른쪽에 있는 점의 수를 비교하여 후보 위치를 옮기기.
#### 그림으로 그려볼 수 있을까?
- 숫자나열보다 기하학적 도형을 더 직관적으로 받아들임
- 두 개의 정수 쌍->2차원 평면 상의 좌표/직선 상의 구간들
#### 수식으로 표현할 수 있을까?
- 평문으로 쓰여 있는 문제를 수식으로 표현 -> 전개/축약 등의 순수한 수학적 조작이 문제해결에 도움을 줄 수 있음.
#### 문제를 분해할 수 있을까?
- 다루기 쉬운 형태로 문제를 변형: 문제의 제약 조건(복잡한 조건)을 (더 단순한 형태를 갖는 조건의 집합으로) 분해
- 예제: N명의 육상 선수, 이전까지의 기록 best[i] & worst[i], M개의 신문기사(i는 j에게 반드시 패배함/i와 j가 서로 상대에게 이길 가능성이 있음)에 오류가 있는지 확인하여 기사의 주장을 모두 만족시키는 기록의 집합이 존재하는지 확인하는 알고리즘 설계
  - 기록범위를 수직선 상에 표시 -> 요구조건(기사의 주장)을 수식으로 표현한 후 두번째 형태의 조건을 첫번째 형태의 조건으로 변환(부등호와 교집합연산자)
#### 뒤에서부터 생각해서 문제를 풀 수 있을까?
- 문제에 내재된 순서를 바꿔보기.
- 예제: 사다리 게임, A->B은 어렵지만 B->A는 훨씬 쉬워지는 경우
#### 순서를 강제할 수 있을까?
- 순서가 없는 문제에 순서를 강제해 문제 풀기
- 예제: 격자 한칸을 클릭하면 그 칸+상하좌우의 칸들의 상태가 동시에 변함(on<->off) -> 모든 칸을 다 켜는 방법 중 최소의 클릭 수.
  - 어떤 순서로 칸들을 클릭하든 상관X, 칸의 최종상태는 클릭한 총 횟수에 따라 결정됨
  - 한 칸을 두 번 이상 클릭할 필요x
  - $2^{n^2}$가지를 모두 시도해서 최솟값 찾기; 특정 순서를 강제 -> 첫줄부터 -> 두번째 줄부터 정해짐. -> $2^n$ 
- 순서 강제 기법은 경우의 수를 셀때 중복을 제하는 좋은 방법
#### 특정 형태의 답만을 고려할 수 있을까?
- 정규화: 고려해야 할 답들 중 형태가 다르지만 결과적으로는 똑같은 것들을 그룹으로 묶은 뒤, 각 그룹의 대표들만을 고려하는 방법
- 예제: 여러 개의 점선 원을 모두 담는 (주어진 반지름의)원 A의 중심 좌표를 구하기 -> 무한개의 모든 후보를 고려하는 대신에 후보의 유한한 부분 집합만을 고려할 수 있게 하는 정규화
  - 어떤 답이 주어지더라도 이것을 특정 형태의 답으로 바꿀 수 있는 변형 과정을 찾아야함.
    - 접한 경계 -> 어떤 답이라도 **두 개 이상의 점선 원과 접한 원**으로 바꿀 수 있음. 
## 2.4 더 읽을 거리
- 어떻게 문제를 풀 것인가(How to Solve It): 문제 해결 분야의 고전