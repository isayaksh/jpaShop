# jpaShop
실전! 스프링부트와 JPA 활용

### 📒 실전! 스프링 부트와 JPA 활용1 - 웹 애플리케이션 개발

#### 스프링 부트와 JPA를 활용한 웹 애플리케이션 설계 및 개발에 대해 학습하였습니다. (~22.10.31)

#### 해당 학습을 통해 배운 것을 정리하였습니다.

  → 📒 [build.gradle](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-build.gradle)

  → 📒 [application.yml](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-application.yml)

#### 해당 프로젝트를 기반으로 코드 리팩토링을 진행할 예정입니다.
- `Entity`의 기본 생성자의 접근 제어자 `public` → `protected`로 변경 (🗓 22.10.31 ~ 22.11.01)

  → 📒 [객체 생성자 접근 제어자를 `public` → `protected`로 변경하는 이유](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-%EA%B0%9D%EC%B2%B4-%EC%83%9D%EC%84%B1%EC%9E%90-%EC%A0%91%EA%B7%BC-%EC%A0%9C%EC%96%B4-protected%EB%A1%9C-%EB%B3%80%EA%B2%BD)
- `Entity`의 `Setter` 제거 (🗓 22.11.01 ~ 22.11.01)

  → 📒 [Entity의 Setter 사용을 지양하는 이유](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-Entity-Setter-%EC%A0%9C%EA%B1%B0)
- 주문 시 2개 이상의 제품을 한 번에 주문하는 기능 추가(22.11.01 ~ ing)
- `Book` 이외의 `Item`인 `Album` 과 `Movie`에 대한 주문 기능 추가

#### 각 페이지 별 핵심 비지니스 로직

#### 📌 메인 화면
<img width="1792" alt="image" src="https://user-images.githubusercontent.com/85926257/198991130-86ec215e-1204-4e26-8c7b-a4536cdcb546.png">

#### 📌 회원 목록
<img width="1792" alt="image" src="https://user-images.githubusercontent.com/85926257/198991311-a76031c1-0de2-4e23-9e16-8e15928812ce.png">

#### 📌 상품 등록
<img width="1792" alt="image" src="https://user-images.githubusercontent.com/85926257/198991408-afa7c1ec-3992-451f-be58-a833a8be81e9.png">

#### 📌 상품 등록
<img width="1792" alt="image" src="https://user-images.githubusercontent.com/85926257/198991467-0e351c2e-bc49-4973-925a-6fd2a952dd08.png">

#### 📌 상품 목록
<img width="1792" alt="image" src="https://user-images.githubusercontent.com/85926257/198992087-42653cde-2865-4864-9bc0-9a67c12f51b8.png">

#### 📌 상품 목록 수정
<img width="1792" alt="image" src="https://user-images.githubusercontent.com/85926257/198992171-b9dd381e-9c56-4c6e-91b7-8914cc4bcb8a.png">

#### 📌 상품 주문
<img width="1792" alt="image" src="https://user-images.githubusercontent.com/85926257/198992311-707a09fb-3ad7-44c0-af05-ccef2259523c.png">

#### 📌 주문 내역
<img width="1792" alt="image" src="https://user-images.githubusercontent.com/85926257/198992361-721a45f8-8028-4273-ac06-43501da243ee.png">
