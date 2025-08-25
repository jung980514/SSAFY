<div align="center">

# 📚 SSAFY 알고리즘 풀이 아카이브

백준 · 프로그래머스 · SWEA 문제 풀이를 기록하는 저장소입니다.  
문제별로 **폴더 + 코드 + 간단한 README**를 남깁니다.

<!-- 배지: 아래 OWNER/REPO, solved.ac 아이디를 본인 것으로 변경하세요 -->
<a href="./"><img alt="Last Commit" src="https://img.shields.io/github/last-commit/jung980514/SSAFY?label=last%20update"></a>
<img alt="Language" src="https://img.shields.io/badge/language-Java-orange">
<a href="./"><img alt="PRs Welcome" src="https://img.shields.io/badge/PRs-welcome-brightgreen"></a>
<a href="https://solved.ac/profile/solar37"><img alt="solved.ac" src="http://mazassumnida.wtf/api/mini/generate_badge?boj=solar37"></a>

</div>

---

## 🗂️ 폴더 구조

<pre>
.
├─ SWEA/
│  ├─ D2/
│  ├─ D3/
│  ├─ D4/
│  ├─ D5/
│  ├─ D6/1267. [S/W 문제해결 응용] ...
│  └─ Unrated/
│
├─ 백준/
│  ├─ Bronze/
│  ├─ Silver/
│  ├─ Gold/
│  ├─ Platinum/
│  ├─ Diamond/
│  └─ Unrated/1237. 정ㅋ벅ㅋ ...
│
├─ 프로그래머스/
│  ├─ 1/
│  │  ├─ 1845. 폰켓몬/
│  │  └─ ...
│  ├─ 2/
│  └─ 4/
│
└─ README.md
</pre>

> 각 플랫폼 → **난이도(또는 레벨)** → `문제번호. 문제이름` 폴더 안에 풀이 파일과 `README.md`를 둡니다.

---

## 🧭 네이밍 규칙

- **SWEA**: `SWEA/D{난이도}/{문제번호}. {문제명}/`  
  예) `SWEA/D2/14510. 나무 높이/`
- **백준**: `백준/{티어}/{문제번호}. {문제명}/`  
  예) `백준/Gold/10026. 적록색약/`
- **프로그래머스**: `프로그래머스/{레벨}/{문제ID}. {문제명}/`  
  예) `프로그래머스/1/1845. 폰켓몬/`

파일명은 플랫폼 기본(`Main.java` 등) 그대로 두고, **폴더명으로 문제를 식별**합니다.

---

## ✍️ 문제별 README 템플릿

<details>
<summary>펼치기</summary>

<pre>
# [Gold V] 적록색약 - 10026

**문제 링크**: https://www.acmicpc.net/problem/10026

## 성능 요약
메모리: 12976 KB, 시간: 84 ms

## 분류
너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

## 제출 일자
2025-03-07 15:46:58

## 풀이 요약
- 일반 시야와 적록색약 시야를 분리하여 영역 카운트
- 'R'과 'G'를 동일 그룹으로 취급한 보드로 한 번 더 탐색
- BFS(4방향), 방문 배열 두 세트 사용

## 배운 점 / 실수 메모
- 방문 배열 초기화 누락으로 첫 제출 실패 → 분리 선언으로 해결
</pre>

</details>

---

## 🔖 커밋 메시지 가이드

- 자동 커밋(BaekjoonHub)은 기본 포맷 유지
- 수동 커밋은 아래처럼 요약(가급적 시간/메모리 포함)
  - `[BOJ] 10026_적록색약 | BFS | 84ms`
  - `[PGS] LV1_폰켓몬 | Set | O(N)`
  - `[SWEA] D2_나무 높이 | 그리디`

---

## 🔗 바로가기

- 백준: https://www.acmicpc.net/
- 프로그래머스: https://programmers.co.kr/
- SWEA: https://swexpertacademy.com/
- solved.ac: https://solved.ac/

---

## 📄 라이선스

개인 학습/면접 대비용 아카이브입니다.  
문제 원문은 각 플랫폼의 저작권 정책을 따릅니다.
