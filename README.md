# Shopping Mall

#### 🧷 스프링 부트와 JPA를 활용한 웹 애플리케이션 설계 및 개발에 대해 학습 (🗓 ~ 22.10.31)

![jpashop](https://user-images.githubusercontent.com/85926257/209926456-f81cac1d-9049-43dd-b237-f807e5e064db.gif)

#### 🧷 해당 프로젝트를 기반으로 코드 리팩토링 진행

|📌 수정 사항|🗓 진행 일자|📒 수정 내용|
|:-:|:-:|:-:|
|양방향 맵핑 지연 로딩 미적용 문제 개선|22.12.29 ~ 22.12.29|[@OneToOne 양방향 맵핑 지연 로딩 미적용 문제 개선](https://velog.io/@isayaksh/JPA-OneToOne-%EC%96%91%EB%B0%A9%ED%96%A5-%EB%A7%B5%ED%95%91-%EC%A7%80%EC%97%B0-%EB%A1%9C%EB%94%A9-%EB%AF%B8%EC%A0%81%EC%9A%A9-%EB%AC%B8%EC%A0%9C-%EA%B0%9C%EC%84%A0)|
|일괄 DELETE 쿼리 개선|22.12.28 ~ 22.12.28|[대량의 데이터 일괄 DELETE](https://velog.io/@isayaksh/JPA-%EB%8C%80%EB%9F%89%EC%9D%98-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%9D%BC%EA%B4%84-DELETE-%EC%BF%BC%EB%A6%AC-%EA%B0%9C%EC%84%A0)|
|쇼핑몰 장바구니 기능 추가|22.12.23 ~ 22.12.27|[장바구니 기능 추가](https://velog.io/@isayaksh/Spring-%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88-%EA%B8%B0%EB%8A%A5-%EC%B6%94%EA%B0%80)|
|다형성을 적용하여 OCP를 지키고 반복되는 코드 개선 |22.12.20 ~ 22.12.21|[상속 클래스 다형성 적용](https://velog.io/@isayaksh/JAVA-%EC%83%81%EC%86%8D-%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%8B%A4%ED%98%95%EC%84%B1-%EC%A0%81%EC%9A%A9)|
|`Entity` 필드 수정시 발생하는 업데이트 쿼리 개선|22.12.19 ~ 22.12.19|[Update 쿼리 개선](https://velog.io/@isayaksh/JPA-Update-%EC%BF%BC%EB%A6%AC-%EA%B0%9C%EC%84%A0)|
|상품 주문 기능 개선|22.11.29 ~ 22.12.01|[Session을 활용한 상품 주문 기능 개선](https://velog.io/@isayaksh/Spring-Session%EC%9D%84-%ED%99%9C%EC%9A%A9%ED%95%9C-%EC%83%81%ED%92%88-%EC%A3%BC%EB%AC%B8-%EA%B8%B0%EB%8A%A5-%EA%B0%9C%EC%84%A0)|
|HTML 페이지 중복 제거|22.11.28 ~ 22.11.29|[상품 등록 페이지 중복 제거](https://velog.io/@isayaksh/Spring-HTML%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%83%81%ED%92%88-%EB%93%B1%EB%A1%9D-%ED%8E%98%EC%9D%B4%EC%A7%80-%EC%A4%91%EB%B3%B5-%EC%A0%9C%EA%B1%B0)|
|Item에 누락된 Album, Movie 기능 구현|22.11.25 ~ 22.11.25|[상품 종류 별 상품 등록 기능 개선](https://velog.io/@isayaksh/Spring-%EC%83%81%ED%92%88-%EC%A2%85%EB%A5%98-%EB%B3%84-%EC%83%81%ED%92%88-%EB%93%B1%EB%A1%9D-%EA%B8%B0%EB%8A%A5-%EA%B0%9C%EC%84%A0)|
|Cache를 이용한 회원 목록 중복 쿼리 제거|22.11.22 ~ 22.11.24|[Cache를 활용한 Query 중복 제거](https://velog.io/@isayaksh/Spring-Cache%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-Query-%EC%A4%91%EB%B3%B5-%EC%A0%9C%EA%B1%B0)|
|이메일과 비밀번호를 통한 로그인 기능 구현|22.11.09 ~ 22.11.13|[Login 기능 구현](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-Login-%EA%B8%B0%EB%8A%A5-%EA%B5%AC%ED%98%84)|
|주문 내역에 출력되어야 하는 누락된 아이템 정보들 출력될 수 있도록 코드 수정|22.11.05 ~ 22.11.05|[주문 내역 각 Item 별 분할 출력](https://velog.io/@isayaksh/%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9)|
|부모 클래스를 상속(`extends`)한 자식 클래스에서 부모 변수의 멤버변수를 변경하기 위한 방법|22.11.03 ~ 22.11.03|[[문제&해결] 접근 제한자 protected의 사용을 통한 코드 중복 해결](https://velog.io/@isayaksh/JAVA-%EC%A0%91%EA%B7%BC-%EC%A0%9C%ED%95%9C%EC%9E%90-protected%EC%9D%98-%EC%82%AC%EC%9A%A9-%EB%A8%B8%EC%8B%9C%EA%B8%B0)|
|`Entity`의 `Setter` 제거|22.11.01 ~ 22.11.01|[Entity의 Setter 사용을 지양하는 이유](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-Entity-Setter-%EC%A0%9C%EA%B1%B0)|
|`Entity`의 기본 생성자의 접근 제어자 `public` → `protected`로 변경| 22.10.31 ~ 22.11.01| [객체 생성자 접근 제어자를 `public` → `protected`로 변경하는 이유](https://velog.io/@isayaksh/Spring-%EC%8B%A4%EC%A0%84-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-JPA-%ED%99%9C%EC%9A%A9-%EA%B0%9D%EC%B2%B4-%EC%83%9D%EC%84%B1%EC%9E%90-%EC%A0%91%EA%B7%BC-%EC%A0%9C%EC%96%B4-protected%EB%A1%9C-%EB%B3%80%EA%B2%BD)|
