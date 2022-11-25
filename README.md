# jpaShop
실전! 스프링부트와 JPA 활용

### 💻 실전! 스프링 부트와 JPA 활용1 - 웹 애플리케이션 개발

#### 🧷 스프링 부트와 JPA를 활용한 웹 애플리케이션 설계 및 개발에 대해 학습 (~22.10.31)

#### 🧷 해당 학습을 통해 배운 정보

  → 📒 [build.gradle](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-build.gradle)

  → 📒 [application.yml](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-application.yml)

#### 🧷 해당 프로젝트를 기반으로 코드 리팩토링 진행
|📌 수정 사항|🗓 진행 일자|📒 수정 내용|
|:-:|:-:|:-:|
|`Entity`의 기본 생성자의 접근 제어자 `public` → `protected`로 변경| 22.10.31 ~ 22.11.01| [객체 생성자 접근 제어자를 `public` → `protected`로 변경하는 이유](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-%EA%B0%9D%EC%B2%B4-%EC%83%9D%EC%84%B1%EC%9E%90-%EC%A0%91%EA%B7%BC-%EC%A0%9C%EC%96%B4-protected%EB%A1%9C-%EB%B3%80%EA%B2%BD)|
|`Entity`의 `Setter` 제거|22.11.01 ~ 22.11.01|[Entity의 Setter 사용을 지양하는 이유](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-Entity-Setter-%EC%A0%9C%EA%B1%B0)|
|부모 클래스를 상속(`extends`)한 자식 클래스에서 부모 변수의 멤버변수를 변경하기 위한 방법|22.11.03 ~ 22.11.03|[[문제&해결] 접근 제한자 protected의 사용을 통한 코드 중복 해결](https://velog.io/@isayaksh/JAVA-%EC%A0%91%EA%B7%BC-%EC%A0%9C%ED%95%9C%EC%9E%90-protected%EC%9D%98-%EC%82%AC%EC%9A%A9-%EB%A8%B8%EC%8B%9C%EA%B8%B0)|
|주문 내역에 출력되어야 하는 누락된 아이템 정보들 출력될 수 있도록 코드 수정|22.11.05 ~ 22.11.05|[주문 내역 각 Item 별 분할 출력](https://velog.io/@isayaksh/%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9)|
|이메일과 비밀번호를 통한 로그인 기능 구현|22.11.09 ~ 22.11.13|[Login 기능 구현](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-Login-%EA%B8%B0%EB%8A%A5-%EA%B5%AC%ED%98%84)|
|Cache를 이용한 회원 목록 중복 쿼리 제거|22.11.22 ~ 22.11.24|[Cache를 활용한 Query 중복 제거](https://velog.io/@isayaksh/Spring-Cache%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-Query-%EC%A4%91%EB%B3%B5-%EC%A0%9C%EA%B1%B0)|

#### 🧷 각 페이지 별 핵심 비지니스 로직

#### 📌 로그인 화면
![image](https://user-images.githubusercontent.com/85926257/201507554-2dd0dfc9-444a-4145-aa60-69e901420106.png)

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
