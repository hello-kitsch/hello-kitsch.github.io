# 개관
- 학교 교육의 문제: 알고리즘을 배운 뒤 연습 문제를 풀 수는 있어도, 문제를 해결하기 위한 새로운 무언가를 고안할 수는 없는 개발자가 되는 것.
  - 처음부터 완전한 체계를 갖추고 발전하는 학문은 없음. **직관에 따른 시행착오**와 경험이 하나씩 쌓여 학문의 기초를 이룸 -> 학문의 뼈대가 되는 공리들과 법칙들을 만들고 학문의 체계를 정리
  - 최종 결과물인 복잡한 개념, 도구를 제시 -> 개념의 이론에 대해 설명 -> 연습문제
    - 특정 알고리즘이 생겨난 배경과 알고리즘을 설계하는데 필요했던 결정적 통찰을 얻을 수 없음.
    - 체계적 지식을 주입 가능; 문제의 답을 스스로 고안할 수 있는 능력을 기르기엔 부족함
- 프로그래밍 대회: 알고리즘에 사용된 원칙들을 이해하고 변형해야 풀 수 있는 문제들을 해결하고 구현하는 능력

# 1. 문제 해결과 프로그래밍 대회
## 1.1 도입
- SI 프로그래머, DB 프로그래머, 웹 프로그래머, 게임 프로그래머 등은 전혀 다른 환경, 다른 언어, 도구를 써서 프로그램을 작성
### 프로그래밍은 문제 해결이다
- 문제 해결 능력: 프로그래밍 언어의 특성, 프로그램이 동작할 하드웨어와 운영체제에 관한 지식, 사용하고 있는 라이브러리들에 대한 유의사항 등을 떠올리며 프로그래밍(퍼즐 조각) -> 메모리/시간 제한/재사용성이 높은 간결한 코드를 짜는 능력(조각을 배치하고 연결하여 큰 그림을 만들기)
## 1.2 프로그래밍 대회
- 문제 해결 기술을 연마: 현업의 요구 사항이 아닌 어떤 값을 읽어들여 어떤 값을 계산하는 프로그램을 작성하라는 형태
### 문제: 록 페스티벌 (난이도 하)
#### 재정의
- 간판스타 L개의 팀 -> 최소 L일, 전체 팀 수는 미정
- 공연장을 빌리는 데 드는 비용이 배열로 주어짐
- L일 이상 연속해서 대여하되, 평균 비용을 최소화하는 조합을 도출
#### 접근
- 삼중 for문: L~N까지 L을 키워가면서, 0~(N-L)까지 i를 더한 j값까지의 비용들을 다 더하고 평균을 구해서 최솟값을 구함.
#### 구현
```cpp
#include <iostream>
using namespace std;

int main() {
    int C, N, L, sum;
    int cost[1001];
    double avg, min;

    cin >> C;
    while(C--) {
        min = 1000;
        cin >> N >> L;
        
        for(int i = 0; i <= N; i++) {
            cin >> cost[i];
        }
        for(; L <= N; L++) {
            for(int i = 0; i < N - L; i++) {
                sum = 0;
                for(int j = 0; j < i + L; j++) {
                    sum += cost[j];
                }
                avg = (double) sum / L;
                if (min > avg) 
                    min = avg;
            }
        } 
        cout << min <<endl;
    }
    return 0;
}
```
#### 개선
- ???
### 프로그래밍 대회에서 배울 수 있는 것들
- GUI를 사용하지 않고 텍스트 파일만을 입출력하기 때문에 문제를 해결하는데만 집중 가능
- 명시적인 시간 제한, 메모리 제한: 계산 집중적(DB,Network접근이 아닌 CPU를 통한 계산)->적절한 알고리즘과 자료구조를 사용하지 않으면 시간 제한 내에 동작하지 않음. 알고리즘에 사용된 원칙들을 이해하고 변형해야 풀 수 있는 문제들이 많이 출제됨
- 정답과 오답의 여부가 명확히 가려짐(현업의 단위테스트, 상호 간 코드 리뷰), 빠르고 객관적인 피드백은 예외 없고 정확한 프로그램을 짜는 좋은 훈련
- 실시간으로 실행시간/메모리 사용량 정보가 제공->프로그램을 고쳐가며 작은 변경이 프로그램의 효율성에 미치는 영향을 직접 체험 가능
- 대형 프로젝트에서 간과했던 프로그램의 작은 부분에 집중할 수 있는 계기를 만들어줌.(코드의 구조 변경, 우아한 프로그램)
- 다른 사람이 짠 코드를 직접 보고 자신이 짠 코드와 비교 가능
## 1.5 대회 준비를 위한 조언
### 가능한 한 많은 문제 풀기
- 복잡한 알고리즘을 하나 더 아는 것보다 실제로 자신이 아는 것을 이용해 문제를 풀 수 있는 능력이 훨씬 더 중요
### 온라인 채점 사이트 이용
- 자신의 코드를 채점받아보며 제대로 풀고 있는지 확인해야 배울 수 있음.
### 가능한 한 많은 프로그래밍 대회에 참가하기
- 실제 대회에 참가해서 다른 살암과 경쟁하는 경험->많은 도움과 자극
### 팀 단위 연습을 위한 조언
- 종이 위에 답안 스케치하기: 답안의 중요한 부분들을 종이 위에 미리 스케치(어떤 자료 구조를 사용, 각 함수의 이름과 역할, 중요한 부분의 의사코드)
- 치밀한 역할 분담: 코딩과 문제풀이 계획을 분담
- 페어 프로그래밍 연습: 두 사람이 같은 코드를 보면서 코딩하는 연습
- 디버거 없이 디버깅: 눈 디버깅 연습
- 인쇄 대기 감소를 위한 두 화면 분할
### 팀 노트북 준비하기
- 미리미리 준비: 대회 준비를 하며 문제를 풀 때 나중에도 유용하게 사용될 것 같은 코드를 정리
- 간단한 형태의 문서화: 소스 코드들이 하는 일, 실행 전 조건, 실행 후 조건들을 간략하게 주석으로 적어두기(각 함수의 사전조건, 사후조건을 명시해두기)
- 클래스 형태로 준비: 소스 코드가 복잡한 자료 구조를 이용하는 경우에 클래스 형태로 정의(타이핑이 길어지고 번거롭지만 코드의 블랙박스화가 강제->초기화 등 까다로운 점들에 신경을 쓰지 않아도 되는 장점)
- 적절한 글꼴 선택하기: 프로그래밍용 글꼴 사용
## 1.6 더 읽을거리
- 인터넷, 검색엔진, 위키백과
- Introduction to Algorithms(CLRS), Programming Challenges, The Art of Computer Programming, 프로그래밍 콘테스트 챌린징