---
layout: post
title: Git & Github and blog
subtitle: 로그를 남기는 법
category: question
tags: [git, github, blog, log]
comments: true
use_math: true
author: jyesoon
---
# $Q_1$ 버전 관리 시스템와 웹 레포지토리 뷰어 시스템의 구축
## 명령어
## 브랜치
- what is a rebase?  

# $Q_2$: jekyll 기반 깃허브 블로그 repo에서 서버까지 반영되는 시간이 느린 이유...  
- SSR(static site generator)인 jekyll의 문제인가, 웹 호스팅 서비스인 github page의 문제인가?  

## jekyll(정적 사이트 생성기)
- 마크다운 포스트를 HTML로 변환하여(Perl 같은 스크립트 언어와 관련이 있나?) 정적 사이트를 만들어줌.
- 검색 엔진에서 필요로 하는 sitemap.xml과 robots.txt 를 자동 생성
  - 구글 검색 엔진 등에 검색되기 위해서는 헤드 태그에 google-site-verification을 추가해야함.
## github page(웹 호스팅 서비스)
- 깃허브 레포지터리에 마크다운 형식 파일을 저장하면 웹사이트를 만들어주는 서비스  

# $Q_3$: velog 태그 분류 동기화가 느린 것에 대하여...
- jekyll의 경우엔 레포->서버에 동기화되는 시간은 느려도 태그 및 카테고리 설정은 잘만되는데 왜 벨로그는 포스팅 업데이트는 잘되면서 태그 분류 동기화는 느린거지?  

# $Q_4$: jekyll 뜯어보기
- RSS(Rich Site Summary/Really Simple Syndication) 설정
  - 어떤 사이트의 콘텐츠가 업데이트되었을때, 방문하지 않고 RSS리더가 긁어온 것을 한 곳에서 보는 방법
    - RSS 리더 개발사측에서는 사용자의 간접적 사용, 광고를 넣기 어려움(RSS 부분적 접근제한이 어려움)
    - RSS를 허용하지 않는 측: 페이지뷰와 광고수 산정에 좋을 게 없음.
  - 개발자 아론 스워츠: 이후 마크다운 문법 개발, 레딧 공동 설립, 크리에이티브 커먼즈에 참여
    - 정보의 자유로운 공개를 주장