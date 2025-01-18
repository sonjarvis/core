package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//구성영역
public class AppConfig {

    //생성자 주입 : 생성자를 통해서 객체가 유인스턴스 생성된게 들어감
    //멤버 서비스 인플을 만들고 내가 만든 멤버 서비스 인플은 메모리 멤버 리포지토리를 사용할 거야  --> 생성자 주입
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); //구현체 객
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy()); //생성자 주입
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy(); //원하는 할인 정책으로 변경만 하면 끝
    }

}
