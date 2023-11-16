---
layout: post
title: StardewValley MultiPlay & create_server
subtitle: 24시간 굴러가는 스타듀밸리 서버 만들기 클론코딩 프로젝트 
tags: [toyprj, server, game]
comments: true
author: jyesoon
---

아래 글에서 영감을 받아서 쓰는 글  
[headless server for stardewvalley](https://velog.io/@ruby/%EC%8A%A4%ED%83%80%EB%93%80%EB%B0%B8%EB%A6%AC-headless-%EC%84%9C%EB%B2%84-%EB%A7%8C%EB%93%A4%EA%B8%B0)

# 1.
자체 서버 없이 호스트를 서버 역할로 만들어 멀티 플레이를 구현했다 - how???
- hint: 스타듀밸리에 멀티플레이 모드가 등장하기 전에 있었던 mod (Always-On-Server-for-Multiplayer)를 SMAPI(중간자)를 이용해서 적용하는 구현의 내부를 안다면 추정 가능할 것.  
> https://github.com/funny-snek/Always-On-Server-for-Multiplayer  

# 2. 
- mod(게임 전반)와 SMAPI(스타듀밸리 한정)에 대해서도 어떻게 굴러가는 것인지 잘 모른다.

# 3. 
- 서버컴 내부에는 어떤 부품들이 필요조건으로 있는지?와 서버의 스펙은 무엇으로 결정되는지? (램?)
- 서버와 클라이언트의 통신(네트워크) 품질은 어떻게 결정 되는지? (랜카드?)
- 호스트 서버가 노트북일때와 데스크탑일때 나오는 품질 차이는 어떠한 원리에 의한 것인지?
- VPN(이를테면 하마치 등)을 이용하는 방법이 통신 문제를 해결하는 이유는?  

# 4.
- 클라우드 서비스를 이용해 24시간 서버를 만들고 VNC를 이용해 돌리는 법 (맨 위의 링크에 구현되어 있음-클론 코딩) 