package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    //DIP 만족하는 코드 작성 -- 인터페이스에만 의존

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //어떤 구현 객체가 주입될지는 오직 외부 AppConfig에서 결정. 여기서는 실행에만 집중!
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //멤버 찾기
        Member member = memberRepository.findById(memberId);
        //할인 가격
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //최종 생성된 주문 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //test 용도!
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
