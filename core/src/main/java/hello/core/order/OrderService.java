package hello.core.order;

public interface OrderService {
    //클라이언트 -> 주문 생성(회원 아이디, 상품명, 상품 가격) -> 최종 Order 결과 반환하는 메소드
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
