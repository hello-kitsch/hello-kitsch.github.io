```python
#1. 재귀: 팩토리얼
def factorial1(n):
    result = 1
    while True:
        result *= n
        n -= 1
        if n == 0:
            break
    return result

def factorial2(n):
    result = 1
    for i in range(1, n+1, 1):
        result *= i
    return result

def factorial3(n):
    if n == 1:
        return 1
    else:
        return n * factorial3(n-1)

n = int(input("숫자 입력!"))
print(factorial1(n))

#2. 함수_이름 = lambda 매개변수1, 매개변수2, ... : 매개변수를_이용한_표현식
list(filter(lambda x: x > 0, [1, -3, 2, 0, -5, 6]))

#3. 구구단 프로그래밍
def gugudan_for(n):
    result = []
    for i in range(10):
        result.append(n * i)
    return result

def gugudan_while(n):
    result = []
    i = 1
    while i < 10:
        result.append(n * i)
        i += 1
    return result

def three_or_five():
    result_list = []
    i = 1
    result = 1
    while i < 1000:
        if i % 3 == 0 or i % 5 == 0:
            result_list.append(i)
        i = i + 1
    for k in result_list:
        result += k
    return result

n = int(input("구구단 단수 입력!"))
print(gugudan_for(n))

#4. 가상환경 만들기
#conda create -n virtual_space_name python=3.8
#conda activate virtual_space_name
#conda install numpy
#conda install jupyter

#5. 3과 5의 배수를 모두 더하기
result = 0
for n in range(1, 1000):
    if n % 3 == 0 or n % 5 == 0:
        result += n
print(result)

#6. 게시판 페이징 하기
def get_total_page(m, n):
    if m == 0:
        return 0
    elif m % n == 0:
        return m // n
    else:
        return m // n + 1
    
m, n = input("게시물의 총 개수와 한 페이지에 보여줄 게시물 수를 차례로 입력").split(' ')
m = int(m)
n = int(n)
print("{0}개의 게시판이 필요합니다.".format(get_total_page(m, n)))

#7. 간단한 메모장 만들기
import sys
#입력: python memo.py -a "Life is too short"
option = sys.argv[1] #-a

if option == '-a':
    memo = sys.argv[2] #"Life is too short"
    f = open('memo.txt', 'a')
    f.write(memo)
    f.write('\n')
    f.close()
elif option == '-v':
    f = open('memo.txt')
    memo = f.read()
    f.close()
    print(memo)
    
#8. 탭 문자를 공백 문자 4개로 바꾸기
import sys

def tab_to_space():
    src = sys.argv[1]
    dst = sys.argv[2]

    f = open(src)
    tab_content = f.read()
    f.close

    space_content = tab_content.replace("\t", " "*4)

    f = open(dst, 'w')
    f.write(space_content)
    f.close()
    
#9. 하위 디렉터리 검색
import os

def search(dirname):
    try:
        filenames = os.listdir(dirname)
        for filename in filenames:
            full_filename = os.path.join(dirname, filename)
            if os.path.isdir(full_filename):
                search(full_filename)
            else:
                ext = os.path.splitext(full_filename)[-1]
                if ext == '.py':
                    print(full_filename)
    except PermissionError:
        pass

# search("c:/") #주석 해제 후 실행

def search_os_walk():
    for (path, dir, files) in os.walk("c:/"):
        for filename in files:
            ext = os.path.splitext(filename)[-1]
            if ext == ".py":
                print("%s/%s" %(path, filename))
                
#k번째 수
def solution1(array, commands):
    answer = []

    for i in commands:
        arr = array[i[0]-1 : i[1]-1]
        arr.sort()
        answer.append(arr[i[2]-1])
    return answer

def solution2(array, commands):
    return list(map(lambda x: sorted(array[x[0]-1:x[1]])[x[2]-1], commands))
    
#직사각형 별찍기
n, m = map(int, input("n과 m을 입력하세요").strip().split(' '))

def solution1(n, m):
    for i in range(m):
        for k in range(n):
            print("*")
        print("\n")

def solution2(n, m):
    stars = "*" * n
    for i in range(m):
        print(stars)

def solution3(n, m):
    stars = ("*" * a + '\n') * b
    print(stars)
    
solution2(n, m)

#공원 산책
def solution(park, routes):
    for i in range(len(park)): #직사각형 세로(y축)
        for k in range(len(park[i])): #직사각형 가로(x축)
            if park[i][k] == 'S':
                y = i
                x = k
    
    option = {'N':(-1, 0), 'S':(1, 0), 'W':(0, -1), 'E':(0, 1)}

    for route in routes:
        dy, dx = option[route.split(' ')[0]]
        n = route.split(' ')[1]
        yy, xx = y, x
        move = True

        for _ in range(n):
            y_n = yy + dy
            x_n = xx + dx
            if 0 <= y_n <= len(park)-1 and 0 <= x_n <= len(park[0])-1 and park[dy, dx] != 'X':
                move = True
                yy = y_n
                xx = x_n
            else:
                move = False
                break
        
        if move:
            y, x = y_n, x_n #xx, yy면 안되나?
    return [y, x]

#모의고사
def solution(answer: list) -> list:
    n1 = [1, 2, 3, 4, 5]
    n2 = [2, 1, 2, 3, 2, 4, 2, 5]
    n3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    counts = [0, 0, 0]
    who = []
    
    for i, number in enumerate(answer):
        n1_count, n2_count, n3_count = 0, 0, 0
        if number == n1[i % len(n1)]:
            counts[0] += 1
        if number == n2[i % len(n2)]:
            counts[1] += 1
        if number == n3[i % len(n3)]:
            counts[2] += 1
    for idx, count in enumerate(counts):
        if count == max(counts):
            who.append(idx + 1)
    return who
    
#괄호 회전하기
def solution(s: str) -> int:
    stack = []
    for char in s:
        if char == ']' or char == '}' or char == ')':
            stack.append()
        elif char == '[' and stack[-1]
        
#n^2 배열 자르기
def solution(n, left, right):
    arr = []
    for i in range(left, right+1): #초기 풀이는 n*n을 돌고 마지막 주석처리된 행을 리턴
        a = i // n
        b = i % n
        if a <= b:
            arr[i] = a + 1
        else:
            arr[i] = b + 1
    return arr
    #return arr[left:right_1] #슬라이싱 내부는 어떻게 구현되어있을까?

#괄호 회전하기(re)
def check(string): 
    stack = []
    for i in string:
        if len(stack) == 0:
            stack.append(i)
        else:
            if i == ')' and stack[-1] == '(':
                stack.pop()
            elif i == ']' and stack[-1] == '[':
                stack.pop()
            elif i == '}' and stack[-1] == '{':
                stack.pop()
            else:
                stack.append(i)
    return 1 if len(stack) == 0 else 0

def solution(string):  
    count = 0 
    for i in range(len(string)):
        if check(string) == 1:
            count += 1
            s = s[1:] + s[:1] #회전loop을 따로 만드느냐 아니면 데큐에 담느냐의 문제
    return count

from collections import deque

def solution2(string):
    count = 0
    stack = []
    queue = deque(string)
    flag = False

    for i in range(len(queue)):
        for str in queue:
            if str == '(' or str == '[' or str == '{':
                stack.append(str)
            else:
                if stack:
                    if stack[-1] == '(' and str == ')':
                        stack.pop()
                        flag = True
                    elif stack[-1] == '[' and str == ']':
                        stack.pop()
                        flag = True
                    elif stack[-1] == '{' and str == '}':
                        stack.pop()
                        flag = True
        if flag and not stack:
            count += 1
        stack = []
        flag = False
        queue.append(queue.popleft()) #회전
    return count
```
```python
#이게 뭥미(주석을 습관화하자)
from collections import defaultdict

clothes=[["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]
size=len(clothes)
dic=defaultdict(list)

for i in range(size):
    dic[clothes[i][1]].append(clothes[i][0])

print(list(dic.values()))

#가장 긴 팰린드롬 망한 풀이
def Palindrome(string: str) -> str:
    if len(string) <= 1: return True
    elif string[0] == string[-1]: return Palindrome(string[1:-1])
    else: return False
                
def LongestPalindromeSubstring(string: str) -> str:
    candidates = []
    round_len = round(len(string) / 2)
    for i in range(round_len):
        last = len(string) - i + 1
        curstr = string[i:last]
        if Palindrome(curstr) == True:
            candidates.append(curstr)
        else:
            pass
    return max(candidates, key=len)

string = input("영문 입력")
print(LongestPalindromeSubstring(string))
```