---
layout: post
title: game clone-coding with pygame
subtitle: pygame 라이브러리 공부 겸 클론코딩 첫걸음
category: project
tags: [pygame, cloneCoding]
comments: true
use_math: true
published: true
author: jyesoon
---
# 1. tutorial game
1. 소스 코드
```python
import pygame

pygame.init()

WHITE = (255, 255, 255)
size = [400, 300]
screen = pygame.display.set_mode(size)

done = False
clock = pygame.time.Clock()

airplane = pygame.image.load('images/plane.png')
airplane = pygame.transform.scale(airplane, (60, 45))

def runGame():
    global done, airplane
    x = 20
    y = 24

    while not done:
        clock.tick(10)
        screen.fill(WHITE)

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                done = True
            
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_UP:
                    y -= 10
                elif event.key == pygame.K_DOWN:
                    y += 10
        
        screen.blit(airplane, (x, y))
        pygame.display.update()
        
runGame()
pygame.quit()
```

2. pygame 관련
- Simple DirectMedia Layer 라이브러리 기반 멀티미디어 소프트웨어를 위한 파이썬 라이브러리
- 위 tutorial 프로그램에서 사용된 pygame API
  - `init()`
  