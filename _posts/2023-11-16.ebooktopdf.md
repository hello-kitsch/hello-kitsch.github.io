---
layout: post
title: Ebook to PDF...
subtitle: 삽질의 연속
category: project
tags: [toyprj, ebook, DRM, pdf, macro]
comments: true
author: jyesoon
---

# step1. pdf 변환
## 자동캡쳐/pdf파일로 만들기
### 사전조사
- 맥 버전
[ebookToPdf blog](https://eastshine12.tistory.com/55)  
- 윈도우 버전
[자동캡쳐프로그램](https://pcwindows.tistory.com/447)  

### 목표: 직접 뜯어보고 개선해서 구현해보자!(파이썬)
[파이썬 키보드 인풋 제어](https://wikidocs.net/85709)
[ebookToPdf github](https://github.com/eastshine12/eBookToPdf/blob/master/eBookToPdf.py)  
[GUI 개발 QT6 가이드](https://wikidocs.net/170600)  
## Bonus: 이미지에서 텍스트 인식(OCR)
[Tesseract OCR introduction](https://builtin.com/data-science/python-ocr)  
[Tesseract OCR 1](https://yunwoong.tistory.com/58)  
[Tesseract OCR 2](https://yunwoong.tistory.com/72?category=902345)  
[Tesseract OCR 3](https://yunwoong.tistory.com/73?category=902345)  
- 사실 이 단계를 무사히 자동화 시킬 수 있는다해도 문제가 되는게, 어떻게 원본 텍스트의 규격에 맞게 재구성시킬 것인가...에 대한 것이다.  
[pdf 포맷 규격](https://tmxhsk99.tistory.com/221)  
[adobe pdf api](https://opensource.adobe.com/dc-acrobat-sdk-docs/)  
[웹PDF뷰어 프레임워크](https://tonhnegod.tistory.com/entry/%EC%9B%B9%ED%8E%98%EC%9D%B4%EC%A7%80%EC%97%90%EC%84%9C-PDF-%ED%8C%8C%EC%9D%BC-%EB%B3%B4%EC%97%AC%EC%A3%BC%EA%B8%B0-PDF-%EB%B7%B0%EC%96%B4-%EB%84%A3%EA%B8%B0)  
- 그래서 PDF를 열어봄 VSCODE/github는 일렉트론에 기반  

# step2. DRM 제거
[DeDRM github](https://github.com/apprenticeharper/DeDRM_tools/tree/master/DeDRM_plugin)  
- 교보: Fasoo DRM
- (한국이퍼브)예스24, 알라딘, 반디앤루스: Markany X-sync
- 리디북스: 자체 DRM
- 구글북스,소니북스,코보,오버드라이브: adobe drm
- 아마존: 자체 DRM  
## ebook 뷰어 구현 코드...
- 를 분석해서 DRM을 복호화해서 제거  
[리디DRM분석제거](https://tonhnegod.tistory.com/entry/%EC%9B%B9%ED%8E%98%EC%9D%B4%EC%A7%80%EC%97%90%EC%84%9C-PDF-%ED%8C%8C%EC%9D%BC-%EB%B3%B4%EC%97%AC%EC%A3%BC%EA%B8%B0-PDF-%EB%B7%B0%EC%96%B4-%EB%84%A3%EA%B8%B0)  
- 해킹과 리버스 엔지니어링(정적/동적 분석툴)적 지식이 필요함. 그니까 언제쯤 가능하게 될지 모른다는 소리.  
> 해킹: 시스템 해킹, 리버스엔지니어링, 웹해킹, 포렌식, 네트워크 해킹, 암호학  
> 보안 취업: 개발자로 경력 쌓고 보안 공부를 통해 이직 준비  
> 정적분석툴: IDA, ghidra를 가지고 어셈블리/바이너리 -> 코드로 바꿔줌(디컴파일러?)  
> 동적분석툴: ollydbg, x64dbg, GDB 등의 디버거를 이용  

# 임시 결론
- 이 모든 삽질의 이유는 개불편한 알라딘 ebook 때문인데, 진심 커스텀이 1도 안되고, 사용자를 고려하지 않은 인터페이스와 창 크기 및 위치 캐싱이 안되는 점...이 너무 짜증나서 추출해버릴까 생각함.
- 맨 처음 생각한 방법은 캡쳐 후 이미지로 pdf만들기. 
- 근데 사실 pdf파일의 (보통 사용자가 느끼는) 장점은 검색이 가능한 텍스트파일을 어디서든 열 수 있다이므로...스캔된 이미지 pdf파일은 큰 의미가 없을수도 있겠다 싶었다. ~~근데 있을 듯~~ 그래서 OCR을 적용하면 어떨까 싶었는데
- OCR을 적용해 추출한 텍스트를 원본 포맷에 맞게 재구성하려면 DRM을 풀어서 pdf 헤더와 바디파일을 뜯어봐야한다. 아니면 정말 CV 그 자체가 되버릴 수 있다.
- ~~뭔소리야~~ 그래서 결국에 윈도우용 자동 캡쳐 프로그램을 만들거나 리버스 엔지니어링을 배워서 DRM을 푸는 것...으로 결론이 나는데...지금 할 수 있는 건 전자이지만 사용성이 매우 떨어질 듯 하여...~~일단 미룬다~~
- 디지털 시대와 저작권은 참...양립 불가능한 존재구나 하는 것을 또 다시 한번 느꼈다...뭐 영상이나 음성에도 할많하않이지만, 텍스트는...애초에 pdf라는 포맷이 이렇게나 선풍적인 건 어디에서나 열 수 있다는 건데 그런 pdf에 또 다시 암호화를 걸고 그 키를 가지고 복호화를 할 수 있는 어플리케이션에서만 볼 수 있게 하는 게 얼마나 비효율적인 일인가...그리고 나는 오픈소스를 지향~~찬양~~하는 입장에서...생각이 많아진다. 근데 공부부터 하자 그래야 내 손으로 뭘 만들거나 하지.