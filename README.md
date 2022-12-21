# jpaShop
실전! 스프링부트와 JPA 활용

### 💻 실전! 스프링 부트와 JPA 활용1 - 웹 애플리케이션 개발

#### 🧷 스프링 부트와 JPA를 활용한 웹 애플리케이션 설계 및 개발에 대해 학습 (🗓 ~ 22.10.31)

#### 🧷 해당 프로젝트를 기반으로 코드 리팩토링 진행
|📌 수정 사항|🗓 진행 일자|📒 수정 내용|
|:-:|:-:|:-:|
|`Entity`의 기본 생성자의 접근 제어자 `public` → `protected`로 변경| 22.10.31 ~ 22.11.01| [객체 생성자 접근 제어자를 `public` → `protected`로 변경하는 이유](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-%EA%B0%9D%EC%B2%B4-%EC%83%9D%EC%84%B1%EC%9E%90-%EC%A0%91%EA%B7%BC-%EC%A0%9C%EC%96%B4-protected%EB%A1%9C-%EB%B3%80%EA%B2%BD)|
|`Entity`의 `Setter` 제거|22.11.01 ~ 22.11.01|[Entity의 Setter 사용을 지양하는 이유](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-Entity-Setter-%EC%A0%9C%EA%B1%B0)|
|부모 클래스를 상속(`extends`)한 자식 클래스에서 부모 변수의 멤버변수를 변경하기 위한 방법|22.11.03 ~ 22.11.03|[[문제&해결] 접근 제한자 protected의 사용을 통한 코드 중복 해결](https://velog.io/@isayaksh/JAVA-%EC%A0%91%EA%B7%BC-%EC%A0%9C%ED%95%9C%EC%9E%90-protected%EC%9D%98-%EC%82%AC%EC%9A%A9-%EB%A8%B8%EC%8B%9C%EA%B8%B0)|
|주문 내역에 출력되어야 하는 누락된 아이템 정보들 출력될 수 있도록 코드 수정|22.11.05 ~ 22.11.05|[주문 내역 각 Item 별 분할 출력](https://velog.io/@isayaksh/%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9)|
|이메일과 비밀번호를 통한 로그인 기능 구현|22.11.09 ~ 22.11.13|[Login 기능 구현](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-Login-%EA%B8%B0%EB%8A%A5-%EA%B5%AC%ED%98%84)|
|Cache를 이용한 회원 목록 중복 쿼리 제거|22.11.22 ~ 22.11.24|[Cache를 활용한 Query 중복 제거](https://velog.io/@isayaksh/Spring-Cache%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-Query-%EC%A4%91%EB%B3%B5-%EC%A0%9C%EA%B1%B0)|
|Item에 누락된 Album, Movie 기능 구현|22.11.25 ~ 22.11.25|[상품 종류 별 상품 등록 기능 개선](https://velog.io/@isayaksh/Spring-%EC%83%81%ED%92%88-%EC%A2%85%EB%A5%98-%EB%B3%84-%EC%83%81%ED%92%88-%EB%93%B1%EB%A1%9D-%EA%B8%B0%EB%8A%A5-%EA%B0%9C%EC%84%A0)|
|HTML 페이지 중복 제거|22.11.28 ~ 22.11.29|[상품 등록 페이지 중복 제거](https://velog.io/@isayaksh/Spring-HTML%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%83%81%ED%92%88-%EB%93%B1%EB%A1%9D-%ED%8E%98%EC%9D%B4%EC%A7%80-%EC%A4%91%EB%B3%B5-%EC%A0%9C%EA%B1%B0)|
|상품 주문 기능 개선|22.11.29 ~ 22.12.01|[Session을 활용한 상품 주문 기능 개선](https://velog.io/@isayaksh/Spring-Session%EC%9D%84-%ED%99%9C%EC%9A%A9%ED%95%9C-%EC%83%81%ED%92%88-%EC%A3%BC%EB%AC%B8-%EA%B8%B0%EB%8A%A5-%EA%B0%9C%EC%84%A0)|
|`Entity` 필드 수정시 발생하는 업데이트 쿼리 개선|22.12.19 ~ 22.12.19|[Update 쿼리 개선](https://velog.io/@isayaksh/JPA-Update-%EC%BF%BC%EB%A6%AC-%EA%B0%9C%EC%84%A0)|
|다형성을 적용하여 OCP를 지키고 코드 반복 |22.12.20~22.12.21|[상속 클래스 다형성 적용](https://velog.io/@isayaksh/JAVA-%EC%83%81%EC%86%8D-%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%8B%A4%ED%98%95%EC%84%B1-%EC%A0%81%EC%9A%A9)|

#### 🧷 각 페이지 별 핵심 비지니스 로직

#### 📌 로그인 화면
- [UPDATE] 🗓 22.11.13
<img width="2032" alt="image" src="https://user-images.githubusercontent.com/85926257/204483068-892c4c95-4b24-4a49-97f1-17ae1d4a7c47.png">

#### 📌 메인 화면
<img width="2032" alt="image" src="https://user-images.githubusercontent.com/85926257/205059383-d770645e-de95-454b-b80b-a170ae8241e9.png">

#### 📌 회원 등록
- [UPDATE] 🗓 22.11.13
<img width="2032" alt="image" src="https://user-images.githubusercontent.com/85926257/204483293-b59f8663-b801-4fe3-b143-b17c5d11d070.png">

#### 📌 회원 목록
- [UPDATE] 🗓 22.11.21
<img width="2032" alt="image" src="https://user-images.githubusercontent.com/85926257/204483463-86290f69-f1ee-4a5e-ba56-77e905d62982.png">

#### 📌 상품 등록
- [UPDATE] 🗓 22.11.25
<img width="2032" alt="image" src="https://user-images.githubusercontent.com/85926257/204483663-20e82b8d-f76b-4d41-ac9f-08b0b379d89b.png">

#### 📌 상품 목록
- [UPDATE] 🗓 22.12.01
<img width="2032" alt="image" src="https://user-images.githubusercontent.com/85926257/205059518-8680d72d-f7ad-458d-960b-fa8ac2f97131.png">

#### 📌 상품 목록 수정
<img width="1792" alt="image" src="https://user-images.githubusercontent.com/85926257/198992171-b9dd381e-9c56-4c6e-91b7-8914cc4bcb8a.png">

#### 📌 상품 주문
- [UPDATE] 🗓 22.12.01
<img width="2032" alt="image" src="https://user-images.githubusercontent.com/85926257/205059695-401a745a-22dc-4264-ba53-679fed037b76.png">

#### 📌 주문 목록
- [UPDATE] 🗓 22.11.05
<img width="2032" alt="image" src="https://user-images.githubusercontent.com/85926257/205059825-e4ac7424-a5eb-4427-aa5d-9edffd08a32d.png">
