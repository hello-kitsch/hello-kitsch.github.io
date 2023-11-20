# input
이미지 인식 -> 해당안됨.
오디오 인식 -> ???
텍스트 인식 -> 언어모델
비언어적 인식 -> ???
-상황극:피부전도,뇌전도,체온
-자유발화:피부전도,맥박,체온

<output>
-감정레이블(기쁨,놀람,분노,중립,혐오,공포,슬픔)
-이완~각성 (5단계)
-부정~긍정(5단계)

<what to do>
1. 기존의 논문을 많이 찾아보는 게 우선이므로 그 전에 기본기를 쌓아두어야함.
2. 논문들의 기술을 익히고(돌려보고) : 해당분야에서 중요한 주제인지-과거 관련 연구, 참고문헌 기술
3. 지향점을 추가해서(ideal) : 해결하려는 문제, 해결방안, 결론을 명확히 기술-새로운 방법 시도(기술적 우월성)
4. 세부구현을 해내기(implement) : 논문의 구성,서술,검증(실험,증명),결과의 기대효과

<택n>
1. 모델 부분에서의 개선(개별모델튜닝)
2. 데이터셋의 도메인적 특징 selection or extraction(피쳐튜닝)
3. 데이터셋의 멀티모달적 퓨전(전체모델짜기)

<ideal>
거짓감정.
극과 실제상황 속에 신체적 반응의 유의미한 차이가 있는가?
극적인 상황인지 자유발화인지
왜 데이터셋이 다른 종류의 두 개인지? 왜 상황극(성우대상)이 먼저 이루어졌는지?

<또 다른 요소>
Personality
Context
Relationship
Expectation
넌씨눈

<프로젝트 진행순서>
1. 기존의 논문을 많이 찾아보는 게 우선이므로 그 전에 기본기를 쌓아두어야함.
2. 논문들의 기술을 익히고(돌려보고) : 해당분야에서 중요한 주제인지-과거 관련 연구, 참고문헌 기술
3. 지향점을 추가해서(ideal) : 해결하려는 문제, 해결방안, 결론을 명확히 기술-새로운 방법 시도(기술적 우월성)
4. 세부구현을 해내기(implement) : 논문의 구성,서술,검증(실험,증명),결과의 기대효과

<논문구성>
1. 서론:해결하려는 문제,(기술적 우월성,새로운 방법이 있는)해결방안,결론을 간략히 서술
2. 관련연구:이 분야에서 중요한 주제인지를 입증하는 과거 관련 연구,참고문헌에 관한 기술
3. 방법론:데이터셋의 전처리(임베딩),모델구조(인코딩-디코딩)
4. 실험 및 결과: 방법론 별 성능분석
5. 결론: 요약 및 향후기대과제

<과제>
1. 데이터셋의 멀티모달적 퓨전 모델(=네트워크?)
2. 데이터셋의 도메인적 특징: feature selection or extraction(feature engineering)

<idea>
1. 성격: 복합적 감정, 가짜감정, context를 어떻게 살릴 것인지
2. 상호작용: 관계,눈치,예상
"Moreover, it has potential applications in health-care systems (as a tool for psychological
analysis), education (understanding student frustration), and more"

<전처리모델에 반영>
1. 복합감정
-상황극+자유발화 데이터셋을 모두 사용. 각각의 감정레이블의 일정량 이상의 표본 확보를 위해서.
-특정 데이터의 기존 감정 레이블의 비율에 따른 감정레이블의 세분화 규칙
2. 가짜감정 걸러내기
-각성도/긍부정도(표정에서 얻는 데이터라고 해석가능)와 비언어적데이터(뇌전도도,피부전도도,체온,맥박 등) 간의 정합성 척도
-표정에서 얻는 데이터가 유의미해질 때: 관용적,상투적인 표현(모호한 단어)

<향후 연구과제>
3. 이 감정인식모델이 향후 인간과의 상호작용에 어떻게 쓰일지에 대한 구체적인 청사진.

<input>
이미지 인식 -> 해당안됨.
오디오 인식 -> ???
텍스트 인식 -> 언어모델 (문맥-확률 or 의미)
비언어적 인식 -> ???
-상황극:피부전도,뇌전도,체온
-자유발화:피부전도,맥박,체온

<output>
-감정레이블(기쁨,놀람,분노,중립,혐오,공포,슬픔)
-이완~각성 (5단계)
-부정~긍정(5단계)

<research challenges>
A. CATEGORIZATION OF EMOTIONS : categorical and dimensional
B. BASIS OF EMOTION ANNOTATION : situation aware annotation.
C. CONVERSATIONAL CONTEXT MODELING : self dependency, inter-personal dependency
D. SPEAKER SPECIFIC MODELING : necessary background information is often missing from the conversations, speaker profiling based on preceding utterances often yields improved results.
E. LISTENER SPECIFIC MODELING : there is no
textual data on the listener’s reaction to the speaker while the
speaker speaks. A model must resort to visual modality to
model the listener’s facial expression to capture the listener’s
reaction. However, according to DialogueRNN, capturing
listener reaction does not yield any improvement as the listener’s subsequent utterance carries their reaction.
F. PRESENCE OF EMOTION SHIFT : DialogueRNN is more accurate in emotion detection for the
utterances without emotional shift or when the shift is to a
similar emotion (e.g., from fear to sad)
G. FINE-GRAINED EMOTION RECOGNITION
H. MULTIPARTY CONVERSATION
I. PRESENCE OF SARCASM
J. EMOTION REASONING : Unlike context modeling, emotion reasoning
does not only find the contextual utterances in conversational
history that triggers the emotion of an utterance, but also
determines the function of those contextual utterances on the target utterance.
At present, there is no available dataset which contains such rich annotations.

***임베딩,인코더,신경망 구상, 코드짜기 (애로사항:복합감정,가짜감정)

<model level>
(1) multi modal (상호정보반영도) : EDA,TEMP 데이터 레이어/n가지 데이터를 어떤 방식으로 합쳐서 사용하지? : transformer
(2) context을 고려할 수 있는 모델
[1] self dependency, inter-personal dependency
[2] preceding utterances
[3] emotion in the preceding utterances.
[4] intent,topic
[5] logic
[6] shift
[7] reasoning (추가의 데이터셋 필요)(강화학습)
-BERT/ELECTRA: 언어 전반을 이해하고, 이를 백터로 표현하는데 특화된 모델. (word2vec)
-LSTM/GRU vs MLP-mixer : 그 벡터를 가지고 context를 구성하는 모델. 과연 감정의 이유를 추론해낼 수 있을까?(RNN)

<data level>
(3) 레이블(categorical model) :
- 데이터셋 분포도 파악
- 감정레이블의 세분화->척도 만들기(데이터셋 분포도 고려해야 함)
(4) 각성도(dimensional model)

***돌려보기, 논문작성(서술,검증,기대효과)

intent,topic,logic
이건 추후에 생각해봄직한 문제
4-1:모델/4-2:실험,논문

1. 레이블(categorical model) & 각성도,긍정도(dimensional model)
- 데이터셋 분포도 파악
- 복합적인 감정: 감정레이블의 세분화->척도 만들기(데이터셋 분포도 고려해야 함)

2. multi modal (상호정보반영도)
(1)EDA: 변화량의 누적 데이터->shift
(2)TEMP: 평균체온 대비 차이량->shift
(3)txt: BERT/ELECTRA- 언어 전반을 이해하고, 이를 벡터로 표현하는데(임베딩) 특화된 모델.
(4)wav: speech recognition- 음성 전반을 이해하고, 이를 벡터로 표현하는데(임베딩) 특화된 모델

then, 4가지 데이터를 어떤 방식으로 합쳐서 사용하지?
-일단 데이터에서 벡터를 추출한 후
벡터를 가지고 RNN/seq2seq/attention(transformer) 신경망(인코더,디코더)의 구조를 활용해
context를 구성하는 모델을 구축

3. context을 고려할 수 있는 모델(conversation의 특성을 잘 반영하는 구조)
***self dependency(speaker's emotion inertia) & inter-personal dependency(induced by counterpart)
(1) preceding utterances(발화 그자체)
(2) emotion in the preceding utterances(이전의 감정)
***shift
***reasoning
-지도학습시 추가의 annotation 데이터셋 필요
-강화학습은 agent,policy,action,state,reward로 구성
(1)policy를 parameterize로 만들어서 expert의 policy를 따라하게끔 학습-imitation learning.
(2)action은 발화자1명과의 대화 중에 감정변화의 근거가 되는 발화를 택하는 행위.

발화별 BERT(orELECTRA)+wav2vec2->transformer(transfuser) :여기까지가 멀티모달
(wav2vec2 vs spectrogram+2d conv)
이것들을 다시 MLP에 넣고 GRU를 돌리고 이 과정에서 대화의 특성을 살린 병렬처리를 한다.
<dependency>를 prev-utterence차원에서 고려하는 IANN의 구조와 (prev-emotion차원에서 고려가능한지? 역전파개념이 순환신경망 기반 언어모델에서 어떻게 적용되는지?)
<shift>를 EDA,TEMP데이터를 활용하여 고려하는 새로운 구조를 통합시켜서 만든다.

rnn신경망은 타겟 추측이 목적임(seq2seq, LSTM, GRU)
word2vec은 단어의 분산표현(벡터) 추출이 목적으로 쓰여지므로 트랜스포머모델인 bert가 대체 가능.

1. dependency, shift 반영 모델 구축-화,수
(1) LSTM or GRU 로는 어디까지 dependency를 고려할 수 있는지? 이전 발화와 이전 감정까지 고려할 수 있는지?
(2) IANN,dialogue RNN
(3) EDA,TEMP 변화량 데이터를 shift로 고려하는 구조.
(4) transformer-attention is all you need.
(5) BERT vs ELECTRA -GPT,ELMo
(6) wav2vec2 vs spectro-gram+2d conv
(7) multi modal paper

2. 모델 코드 짜기(데이터전처리,메트릭)-목,금,토,일
3. 모델 실험 및 논문 작성-월,화,수,목,금
(1) 서론:해결하려는 문제
(2) 관련연구
(3) 방법론-데이터셋,모델
(4) 실험결과-방법론별 성능분석
(5) 요약 및 기대과제

1. 임베더 어떻게 만들거임
2. 그 임베더 어디다가 꽂아넣거임
1+1 _ 1+1 ->2_2
txt+wav _ eda_temp
둘 다 랜스퓨저
혹은 전자는 concat, 후자는 트랜스 퓨저

참고문헌
1. 리뷰논문
2. shift 논문
3. koElectra
4. wav2vec2
5. LSTM
6. 작년 카이스트논문

1. 데이터 전처리
-utils.py : 작동에 필요한 함수를 정의
-dataset.py : torch.utils.data Dataset class를 상속한 dataset class
-preprocessing.ipynb : 데이터셋 전처리, split등 전처리에 사용된 코드

2.
입력층(임베딩:concatenate(KoBERT,wav2vec2)->멀티헤드어텐션)
은닉층(bi-LSTM_SHFT)
출력층(Affine+softmax with Loss)
-model.py : 우리의 모델
-loss.py : Emotion classification과 Valence, Arousal MSE Loss를 정의하는 class. CBLoss를 정의하는 class
-constants.py : 하이퍼 파라미터
-main.py : main 함수
성능메트릭(F1, CCC)
-metric.py : f1, recall, precision, ccc
requirements.txt : 프레임워크 버전